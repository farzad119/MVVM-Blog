package com.example.blogmvvm.di.components;

import com.example.blogmvvm.di.modules.AppModules;
import com.example.blogmvvm.di.modules.MyModules;
import com.example.blogmvvm.view.activity.PostsActivity;
import dagger.Component;

import javax.inject.Singleton;

@Singleton
@Component(modules = {AppModules.class, MyModules.class})
public interface MyComponent {
    void inject (PostsActivity postsActivity);
}
