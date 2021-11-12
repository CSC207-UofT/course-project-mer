package com.mer.plamer.usecases;

import com.mer.plamer.entities.Playlist;
import com.mer.plamer.entities.Track;

public class PlaylistAction{

    public boolean delTrack(Playlist playlist, Track track) {
        return playlist.delTrack(track);
    }

    public void search() {

    }

    public void add() {

    }
}
