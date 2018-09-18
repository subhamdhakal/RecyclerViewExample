package myapplication.sairamkrishna.example.com.assignment;

import java.util.List;

import myapplication.sairamkrishna.example.com.assignment.Model.Comments;
import myapplication.sairamkrishna.example.com.assignment.Model.Posts;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface Api {


    String BASE_URL="https://jsonplaceholder.typicode.com/";

    @GET ("posts")
    Call<List<Posts>> getPosts();

    @GET("/posts/{postId}/comments")
    Call<List<Comments>> getComments(@Path("postId") int postId);


}
