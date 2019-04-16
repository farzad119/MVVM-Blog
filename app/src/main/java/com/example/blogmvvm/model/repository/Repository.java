package com.example.blogmvvm.model.repository;

import android.content.Context;
import androidx.lifecycle.LiveData;
import com.example.blogmvvm.model.database.MyDatabase;
import com.example.blogmvvm.model.database.PostDao;
import com.example.blogmvvm.model.database.Post;

import java.util.List;

public class Repository {
    PostDao postDao;

    public Repository(Context context) {
        MyDatabase myDatabase = MyDatabase.getInsttance(context);
        postDao = myDatabase.postDao();
    }

    public void insertPost(Post post) {
        postDao.insertPost(post);
    }

    public void updatePost(Post post) {
        postDao.updatePost(post);
    }

    public void deletePost(Post post) {
        postDao.deletePost(post);
    }

    public void deleteAllPosts() {
        postDao.deleteAllPosts();
    }

    public LiveData<List<Post>> getPosts() {
        return postDao.getAllPosts();
    }

    public Post getPost(int postId) {
        return postDao.getPost(postId);
    }
}
