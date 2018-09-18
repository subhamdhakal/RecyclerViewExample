package myapplication.sairamkrishna.example.com.assignment;

import android.app.Activity;
import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.util.Log;

import java.util.List;

import myapplication.sairamkrishna.example.com.assignment.Adapter.CommentAdapter;
import myapplication.sairamkrishna.example.com.assignment.Model.Comments;
import myapplication.sairamkrishna.example.com.assignment.databinding.ActivityCommentsBinding;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class CommentsActivity extends AppCompatActivity {
    
    String TAG="Assignment";
    ActivityCommentsBinding mBinding;
    CommentAdapter commentAdapter;
    private int id;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mBinding = DataBindingUtil.setContentView(this, R.layout.activity_comments);
        mBinding.commentsrecycler.setLayoutManager(new LinearLayoutManager(this));
        commentAdapter=new CommentAdapter();
        mBinding.commentsrecycler.setAdapter(commentAdapter);


        Log.d(TAG, "onCreate: CommentsActivity");
        Retrofit retrofit=new Retrofit.Builder()
                .baseUrl(Api.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        id=getIntent().getIntExtra("postId",0);
        Api api=retrofit.create(Api.class);

        Call<List<Comments>> call=api.getComments(id);
        call.enqueue(new Callback<List<Comments>>() {
            @Override
            public void onResponse(Call<List<Comments>> call, Response<List<Comments>> response) {
                Log.d(TAG, "onResponse: "+response);
                List<Comments> data = response.body();
                commentAdapter.setCommentData(data);
            }
            @Override
            public void onFailure(Call<List<Comments>> call, Throwable t) {
                Log.d(TAG, "onFailure:failure ");
            }
        });


    }
}
