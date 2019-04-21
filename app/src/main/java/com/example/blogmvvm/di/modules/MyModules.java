package com.example.blogmvvm.di.modules;

import android.app.Application;
import com.example.blogmvvm.view.adapter.PostAdapter;
import dagger.Module;
import dagger.Provides;

import javax.inject.Singleton;

@Module
public class MyModules {

    public MyModules() {
    }

    @Singleton
    @Provides
    PostAdapter providePostAdapter(Application application) {
        return new PostAdapter(application);
    }
}
