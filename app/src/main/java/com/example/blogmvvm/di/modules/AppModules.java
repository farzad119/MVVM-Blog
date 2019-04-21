package com.example.blogmvvm.di.modules;

import android.app.Application;
import dagger.Module;
import dagger.Provides;

import javax.inject.Singleton;

@Module
public class AppModules {
    Application application;

    public AppModules(Application application) {
        this.application = application;
    }

    @Singleton
    @Provides
    Application provideApplication(){
        return application;
    }
}
