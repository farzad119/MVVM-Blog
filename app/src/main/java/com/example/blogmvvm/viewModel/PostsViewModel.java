package com.example.blogmvvm.viewModel;

import android.app.Application;
import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import com.example.blogmvvm.model.database.Post;
import com.example.blogmvvm.model.repository.Repository;

import java.util.List;

public class PostsViewModel extends AndroidViewModel {

    LiveData<List<Post>> posts;
    Repository repository;

    public PostsViewModel(@NonNull Application application) {
        super(application);
        this.repository = new Repository(application.getApplicationContext());
        posts = this.repository.getPosts();
    }

    public void insertPost(Post post){
        repository.insertPost(post);
    }

    public void updatePost(Post post){
        repository.updatePost(post);
    }

    public void deletePost(Post post){
        repository.deletePost(post);
    }

    public void deleteAllPosts(){
        repository.deleteAllPosts();
    }

    public LiveData<List<Post>> getPosts(){
        return repository.getPosts();
    }
}
