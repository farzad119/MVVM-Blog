package com.example.blogmvvm.model.database;

import android.content.Context;
import android.os.AsyncTask;
import androidx.annotation.NonNull;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteDatabase;

@Database(version = 1,entities = {Post.class})
public abstract class MyDatabase extends RoomDatabase {

    public static MyDatabase instance;

    public abstract PostDao postDao();

    public static MyDatabase getInsttance(Context context){
        if (instance==null){
            instance = Room.databaseBuilder(context.getApplicationContext(),
                    MyDatabase.class,
                    "posts_database")
                    .addCallback(roomCallback)
                    .allowMainThreadQueries()
                    .build();
        }
        return instance;
    }

    private static RoomDatabase.Callback roomCallback = new RoomDatabase.Callback() {
        @Override
        public void onCreate(@NonNull SupportSQLiteDatabase db) {
            super.onCreate(db);
            new populateAxynctask(instance).execute();
        }
    };

    private static class populateAxynctask extends AsyncTask<Void, Void, Void> {

        private MyDatabase myDatabase;

        public populateAxynctask(MyDatabase myDatabase) {
            this.myDatabase = myDatabase;
        }

        @Override
        protected Void doInBackground(Void... voids) {
            Post post = new Post();
            post.setAuthor("نویسنده");
            post.setContent("محتوا");
            post.setTitle("تیتر");
            post.setType(1);
            myDatabase.postDao().insertPost(post);
            return null;
        }
    }
}
