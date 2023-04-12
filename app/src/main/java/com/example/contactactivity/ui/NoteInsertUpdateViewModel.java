package com.example.contactactivity.ui;

import android.app.Application;
import androidx.lifecycle.ViewModel;
import com.example.contactactivity.database.Mahasiswa;
import com.example.contactactivity.Repo.repoMahasiswa;

public class NoteInsertUpdateViewModel extends ViewModel {
    private final repoMahasiswa repoMahasiswa;
    public NoteInsertUpdateViewModel(Application application){
        repoMahasiswa = new repoMahasiswa(application);
    }

    public void insert (Mahasiswa note){
        repoMahasiswa.insert(note);
    }

    public void update (Mahasiswa note){
        repoMahasiswa.update(note);
    }

    public void delete (Mahasiswa note){
        repoMahasiswa.delete(note);
    }

}
