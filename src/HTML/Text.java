package HTML;

public class Text {
    private StringBuilder text;
    int LEVEL = 0;

    Text() {
    }

    public Text(String text) {
        this.text = new StringBuilder(text);
    }

    void setLEVEL(int LEVEL) {
        this.LEVEL = LEVEL;
    }

    protected StringBuilder buildHtml(){
        return tabulation(LEVEL).append(text).append("\n");
    }
    static StringBuilder tabulation(int LEVEL) {
        StringBuilder indent = new StringBuilder();
        for (int i = 0; i < LEVEL; i++) {
            indent.append("\t");
        }
        return indent;
    }
}
