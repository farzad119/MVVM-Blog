package com.example.blogmvvm.model.database;

import androidx.lifecycle.LiveData;
import androidx.room.*;

import java.util.List;

@Dao
public interface PostDao {

    @Insert
    void insertPost(Post post);

    @Update
    void updatePost(Post post);

    @Delete
    void deletePost(Post post);

    @Query("Delete FROM post_table")
    void deleteAllPosts();

    @Query("SELECT * FROM post_table")
    LiveData<List<Post>> getAllPosts();

    @Query("SELECT * FROM post_table WHERE id =:postId")
    Post getPost(int postId);
}
