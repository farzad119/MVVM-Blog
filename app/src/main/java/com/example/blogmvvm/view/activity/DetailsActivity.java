package com.example.blogmvvm.view.activity;

import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import androidx.lifecycle.ViewModelProviders;
import butterknife.BindView;
import butterknife.ButterKnife;
import com.example.blogmvvm.R;
import com.example.blogmvvm.model.database.Post;
import com.example.blogmvvm.viewModel.DetailsViewModel;
import com.example.blogmvvm.viewModel.PostsViewModel;

public class DetailsActivity extends AppCompatActivity {

    @BindView(R.id.tv_content)
    TextView tvContent;

    DetailsViewModel detailsViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);
        ButterKnife.bind(this);
        detailsViewModel = ViewModelProviders.of(this).get(DetailsViewModel.class);

        int postId = getIntent().getIntExtra("POST_ID", 1);

        Post post = detailsViewModel.getPost(postId);
        tvContent.setText(post.getContent());
    }
}
