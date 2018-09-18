package myapplication.sairamkrishna.example.com.assignment.Model;


import android.content.Intent;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Comments {


    private int postId;
    private int id;
    private String name;
    private String email;
    private String body;


    public String getPostId() {
        return postId+"" ;
    }

    public void setPostId(int postId) {
        this.postId = postId;
    }

    public String  getId() {
        return id+"" +
                "";
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }
}

//{
//        "postId": 1,
//        "id": 5,
//        "name": "vero eaque aliquid doloribus et culpa",
//        "email": "Hayden@althea.biz",
//        "body": "harum non quasi et ratione\ntempore iure ex voluptates in ratione\nharum architecto fugit inventore cupiditate\nvoluptates magni quo et"
//        }