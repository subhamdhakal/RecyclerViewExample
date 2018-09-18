package myapplication.sairamkrishna.example.com.assignment.Model;

public class Posts {

    private String title;
    private String body;
    private Integer id;
    private int userId;

    public String getUserId() {
        return userId+"" ;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getId() {
        return id + "";
    }

    public void setId(int id) {
        this.id = id;
    }


    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }
}

