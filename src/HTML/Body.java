package HTML;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

public class Body extends Tag {

    public Body(List<Text> list) {
        super("Body", list);
        System.out.println("Документ создан.");
    }

    public Body(Text text) {
        super("Body", text);
        System.out.println("Документ создан.");
    }


    public void addToBody(Text text) {
        this.list.add(text);
        System.out.println("Добавление произведено.");
    }

    public void addToBody(List<Text> additional) {
        this.list.addAll(additional);
        System.out.println("Добавление произведено.");
    }

    public void clearBody() {
        list = new ArrayList<>();
        System.out.println("Документ очищен.");
    }

    public void flush(String path) {
        try {
            PrintWriter printWriter = new PrintWriter(new File(path));
            printWriter.print(buildHtml());
            printWriter.close();
            System.out.print("Запись завершена. ");
        } catch (FileNotFoundException e) {
            System.out.print("Ошибка запись. ");
            e.printStackTrace();
        } finally {
            System.out.println("File's path: " + path);
        }
    }

    public void writeBody() {
        System.out.println("Документ:");
        System.out.print(buildHtml());
    }

    public boolean addTo(String tagName, Text text) {
        ArrayList<Text> additionalList = new ArrayList<>();
        additionalList.add(text);
        return addTo(tagName, additionalList);
    }

    public boolean addTo(String tagName, List<Text> additional) {
        ArrayList<Text> additionalList = new ArrayList<>(additional);
        return addTo(tagName, additionalList);

    }

    private boolean addTo(String tagName, ArrayList<Text> additionalList){
        if (tagName.equalsIgnoreCase("body")) {
            addToBody(additionalList);
            return true;
        }
        Tag tag = (Tag) getTag(tagName);
        if (tag == null) {
            System.out.println("Тег не найден.");
            return false;
        }
        tag.list.addAll(additionalList);
        System.out.println("Добавление произведено.");
        return true;
    }
}
