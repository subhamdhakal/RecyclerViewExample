package myapplication.sairamkrishna.example.com.assignment;

import android.content.Context;
import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.util.Log;
import android.view.View;

import java.util.List;

import myapplication.sairamkrishna.example.com.assignment.Adapter.PostAdapter;
import myapplication.sairamkrishna.example.com.assignment.Model.Comments;
import myapplication.sairamkrishna.example.com.assignment.Model.Posts;
import myapplication.sairamkrishna.example.com.assignment.databinding.ActivityMainBinding;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {
    String TAG = "Assignment";
    ActivityMainBinding mBinding;
    PostAdapter postAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mBinding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        mBinding.postsrecycler.setLayoutManager(new LinearLayoutManager(this));
        postAdapter=new PostAdapter();

        mBinding.postsrecycler.setAdapter(postAdapter);

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(Api.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        Api api = retrofit.create(Api.class);
        Call<List<Posts>> call = api.getPosts();
        call.enqueue(new Callback<List<Posts>>() {
            @Override
            public void onResponse(Call<List<Posts>> call, Response<List<Posts>> response) {


                List<Posts> data = response.body();
                Log.d(TAG, "onResponse: "+data);
                postAdapter.setPostsData(data);

            }

            @Override
            public void onFailure(Call<List<Posts>> call, Throwable t) {
            }
        });
    }
}
