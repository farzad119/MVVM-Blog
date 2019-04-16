package com.example.blogmvvm.view.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.BindView;
import butterknife.ButterKnife;
import com.example.blogmvvm.R;
import com.example.blogmvvm.model.database.Post;
import com.example.blogmvvm.view.activity.DetailsActivity;

import java.util.ArrayList;
import java.util.List;


public class PostAdapter extends RecyclerView.Adapter<PostAdapter.ViewHolder> {

    private List<Post> posts;
    private Context context;

    public PostAdapter(Context context) {
        posts = new ArrayList<>();
        this.context = context;
    }

    public void setItems(List<Post> posts) {
        this.posts = posts;
        notifyDataSetChanged();
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.post_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Post post = getItem(position);

        holder.tvTitle.setText(post.getTitle());
        holder.tvAuthor.setText(post.getAuthor());
        holder.tvContent.setText(post.getContent());

        holder.lnBase.setOnClickListener(v -> {
            Intent intent = new Intent(context, DetailsActivity.class);
            intent.putExtra("POST_ID", post.getId());
            context.startActivity(intent);
        });
    }

    @Override
    public int getItemCount() {
        return posts.size();
    }

    private Post getItem(int position) {
        return posts.get(position);
    }

    class ViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.tv_title)
        TextView tvTitle;
        @BindView(R.id.tv_author)
        TextView tvAuthor;
        @BindView(R.id.tv_content)
        TextView tvContent;
        @BindView(R.id.ln_base)
        LinearLayout lnBase;

        ViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}
