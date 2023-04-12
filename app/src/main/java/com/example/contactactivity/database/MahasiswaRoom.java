package com.example.contactactivity.database;

import android.content.Context;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
@Database(entities = {Mahasiswa.class}, version = 1)


public abstract class MahasiswaRoom extends RoomDatabase{
    public abstract DAOMahasiswa daoNote();
    private static volatile MahasiswaRoom INSTANCE;
    public static MahasiswaRoom getDatabase(final Context context){
        if(INSTANCE == null){
            synchronized (MahasiswaRoom.class){
                INSTANCE = Room.databaseBuilder(context.getApplicationContext(), MahasiswaRoom.class, "mahasiswa_db").allowMainThreadQueries().build();
            }
        }
        return INSTANCE;
    }
}
