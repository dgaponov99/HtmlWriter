package HTML;

import java.util.ArrayList;
import java.util.List;

public class Tag extends Text {

    private String name;
    ArrayList<Text> list = new ArrayList<>();

    public Tag(String name, List<Text> list) {
        this.name = name;
        this.list.addAll(list);
    }

    public Tag(String name, Text text) {
        this.name = name;
        this.list.add(text);
    }

    @Override
    protected StringBuilder buildHtml() {
        StringBuilder stringBuilder = new StringBuilder();
        StringBuilder indent = tabulation(LEVEL);
        stringBuilder.append(indent).append("<").append(name).append(">\n");

        for (Text text : list) {
            text.setLEVEL(LEVEL + 1);
            stringBuilder.append(text.buildHtml());
        }

        stringBuilder.append(indent).append("<\\").append(name).append(">\n");
        return stringBuilder;
    }

    Text getTag(String tagName) {
        for (Text text : list) {
            if (!(text instanceof Tag))
                continue;

            if (((Tag) text).name.equalsIgnoreCase(tagName))
                return text;

            Text tag = ((Tag) text).getTag(tagName);
            if (tag != null)
                return tag;
        }
        return null;
    }

}
