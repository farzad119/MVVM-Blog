package com.example.blogmvvm.viewModel;

import android.app.Application;
import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import com.example.blogmvvm.model.database.Post;
import com.example.blogmvvm.model.repository.Repository;

import java.util.List;

public class DetailsViewModel extends AndroidViewModel {

    Repository repository;
    Post post;

    public DetailsViewModel(@NonNull Application application) {
        super(application);
        this.repository = new Repository(application.getApplicationContext());
    }

    public Post getPost(int postId) {
        if (post == null) {
            return repository.getPost(postId);
        }
        return post;
    }
}
