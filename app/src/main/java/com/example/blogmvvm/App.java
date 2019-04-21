package com.example.blogmvvm;

import android.app.Application;
import com.example.blogmvvm.di.components.DaggerMyComponent;
import com.example.blogmvvm.di.components.MyComponent;
import com.example.blogmvvm.di.modules.AppModules;
import com.example.blogmvvm.di.modules.MyModules;

public class App extends Application {

    MyComponent myComponent;

    @Override
    public void onCreate() {
        super.onCreate();
        myComponent = DaggerMyComponent
                .builder()
                .myModules(new MyModules())
                .appModules(new AppModules(this))
                .build();
    }

    public MyComponent getMyComponent(){
        return myComponent;
    }
}
