package muzhou.com.bean;

public class Content {
    private int id;
    private String title;
    private String content;

    public Content() {

    }

    public Content(int id, String title, String content) {
        setId(id);
        setTitle(title);
        setContent(content);
    }

    public int getId() {
        return id;
    }

    public String getContent() {
        return content;
    }

    public String getTitle() {
        return title;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
