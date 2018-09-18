package myapplication.sairamkrishna.example.com.assignment.Adapter;

import android.databinding.DataBindingUtil;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import java.util.ArrayList;
import java.util.List;
import myapplication.sairamkrishna.example.com.assignment.Model.Comments;
import myapplication.sairamkrishna.example.com.assignment.R;
import myapplication.sairamkrishna.example.com.assignment.databinding.CommentsItemBinding;


public class CommentAdapter extends RecyclerView.Adapter<CommentAdapter.CustomAdapterViewHolderComments> {

     public List<Comments> commentsObject = new ArrayList<>();
    CommentsItemBinding binding;



    @NonNull
    @Override
    public CustomAdapterViewHolderComments onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        binding= DataBindingUtil.inflate(LayoutInflater.from(parent.getContext()), R.layout.comments_item,  parent,false);

        return new CommentAdapter.CustomAdapterViewHolderComments(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull CustomAdapterViewHolderComments holder, int position) {
        holder.bind(commentsObject.get(position));

    }

    @Override
    public int getItemCount() {
        return commentsObject.size();
    }


    public class CustomAdapterViewHolderComments extends RecyclerView.ViewHolder {
        CommentsItemBinding binding;



        public CustomAdapterViewHolderComments(CommentsItemBinding binding) {
            super(binding.getRoot());
            this.binding = binding;

        }

        public void bind(final Comments object) {
            binding.setComment(object);

        }
    }
    public void setCommentData(List<Comments> commentData) {
        this.commentsObject = commentData;
        notifyDataSetChanged();
    }

}
