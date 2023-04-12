package com.example.contactactivity.Repo;

import android.content.Context;
import com.example.contactactivity.database.DAOMahasiswa;
import com.example.contactactivity.database.Mahasiswa;
import com.example.contactactivity.database.MahasiswaRoom;

import java.util.List;

public class repoMahasiswa {
    private final DAOMahasiswa mahaDaoNotes;
    public repoMahasiswa(Context application){
        MahasiswaRoom db = MahasiswaRoom.getDatabase(application);
        mahaDaoNotes = db.daoNote();
    }
    public List<Mahasiswa> getAllNotes(){
        return mahaDaoNotes.getAllNotes();
    }

    public void insert(final Mahasiswa mahasiswa) {
        mahaDaoNotes.insert(mahasiswa);
    }

    public void delete(final Mahasiswa mahasiswa) {
        mahaDaoNotes.delete(mahasiswa);
    }

    public void update(final Mahasiswa mahasiswa) {
        mahaDaoNotes.update(mahasiswa);
    }
}
