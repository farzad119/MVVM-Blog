package com.example.blogmvvm.view;

import android.os.Bundle;
import android.util.Log;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import com.example.blogmvvm.R;
import com.example.blogmvvm.model.database.Post;
import com.example.blogmvvm.viewModel.PostsViewModel;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import androidx.appcompat.app.AppCompatActivity;
import android.view.View;

import java.util.List;

public class PostsActivity extends AppCompatActivity {

    private PostsViewModel postsViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_posts);
        postsViewModel = ViewModelProviders.of(this).get(PostsViewModel.class);

        postsViewModel.getPosts().observe(this, new Observer<List<Post>>() {
            @Override
            public void onChanged(List<Post> posts) {
                for (Post post : posts) {
                    Log.w("PostActivity", " TITlE : " + post.getTitle());
                }
            }
        });

        FloatingActionButton fab = findViewById(R.id.fab_add);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Post post = new Post();
                post.setType(2);
                post.setTitle("title new with fab");
                post.setContent("content new with fab");
                post.setAuthor("author new with fab");
                postsViewModel.insertPost(post);
            }
        });
    }

}
