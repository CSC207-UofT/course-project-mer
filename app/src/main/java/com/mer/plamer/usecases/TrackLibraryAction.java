package com.mer.plamer.usecases;

import android.os.Environment;

import com.mer.plamer.entities.Track;
import com.mer.plamer.entities.TrackLibrary;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class TrackLibraryAction extends LibraryAction{

    public static TrackLibrary trackLibrary = new TrackLibrary();

    @Override
    public void delete() {

    }

    @Override
    public void search() {

    }

    @Override
    public void add() {

    }


    public static void scanLocal() {
        File musicFolder = new File(Environment.getExternalStorageDirectory(), "Music");
        File[] files = musicFolder.listFiles();

        for(int i = 0; i < Objects.requireNonNull(files).length; i++){
            if(files[i].getName().contains(".mp3")){
                trackLibrary.add(new Track(files[i].getAbsolutePath()));
            }
        }

    }
}
