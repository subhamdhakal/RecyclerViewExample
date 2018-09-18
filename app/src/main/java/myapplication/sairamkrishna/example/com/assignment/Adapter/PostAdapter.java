package myapplication.sairamkrishna.example.com.assignment.Adapter;

import android.content.Context;
import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;


import myapplication.sairamkrishna.example.com.assignment.CommentsActivity;
import myapplication.sairamkrishna.example.com.assignment.MainActivity;
import myapplication.sairamkrishna.example.com.assignment.Model.Posts;
import myapplication.sairamkrishna.example.com.assignment.R;
import myapplication.sairamkrishna.example.com.assignment.databinding.PostsItemBinding;


    public class PostAdapter extends RecyclerView.Adapter<PostAdapter.CustomAdapterViewHolder> {


        OnClickListener mListener;
        String TAG = "Assignment";



        List<Posts> postsObject = new ArrayList<>();
        PostsItemBinding binding;

        public interface OnClickListener {
            public void OnClick(Integer id);
        }

        @NonNull
        @Override
        public PostAdapter.CustomAdapterViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            binding = DataBindingUtil.inflate(LayoutInflater.from(parent.getContext()), R.layout.posts_item, parent, false);
            return new PostAdapter.CustomAdapterViewHolder(binding);
        }

        @Override
        public void onBindViewHolder(@NonNull CustomAdapterViewHolder holder, final int position) {
            holder.bind(postsObject.get(position));
            holder.binding.linearLayout.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Log.d(TAG, "onClick:hello " + position);
                    Intent intent=new Intent(v.getContext(),CommentsActivity.class);
                    intent.putExtra("postId",position);
                    v.getContext().startActivity(intent);

                }
            });
        }

        @Override
        public int getItemCount() {
            return postsObject.size();
        }

        public class CustomAdapterViewHolder extends RecyclerView.ViewHolder {
            PostsItemBinding binding;


            public CustomAdapterViewHolder(PostsItemBinding binding) {
                super(binding.getRoot());
                this.binding = binding;
            }
            public void bind(final Posts object) {
                binding.setPost(object);
                binding.getRoot().setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        mListener.OnClick(Integer.parseInt(object.getId()));
                    }
                });
            }
        }
            public void setPostsData(List<Posts> data) {
                this.postsObject = data;
                notifyDataSetChanged();
        }
    }

