package com.example.blogmvvm.view.activity;

import android.os.Bundle;
import android.util.Log;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.BindView;
import butterknife.ButterKnife;
import com.example.blogmvvm.App;
import com.example.blogmvvm.R;
import com.example.blogmvvm.model.database.Post;
import com.example.blogmvvm.view.adapter.PostAdapter;
import com.example.blogmvvm.viewModel.PostsViewModel;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import androidx.appcompat.app.AppCompatActivity;
import android.view.View;

import javax.inject.Inject;
import java.util.List;

public class PostsActivity extends AppCompatActivity {

    @BindView(R.id.rv_posts)
    RecyclerView rvPosts;
    @BindView(R.id.fab_add)
    FloatingActionButton fab;

    @Inject
    PostAdapter postAdapter;

    private PostsViewModel postsViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_posts);
        ButterKnife.bind(this);
        ((App)getApplication()).getMyComponent().inject(this);
        //postAdapter = new PostAdapter(this);
        postsViewModel = ViewModelProviders.of(this).get(PostsViewModel.class);

        rvPosts.setAdapter(postAdapter);
        postsViewModel.getPosts().observe(this, posts -> postAdapter.setItems(posts));

        fab.setOnClickListener(v -> {
            Post post = new Post();
            post.setTitle("title");
            post.setAuthor("author");
            post.setContent("content");
            post.setType(1);
            postsViewModel.insertPost(post);
        });
    }
}
