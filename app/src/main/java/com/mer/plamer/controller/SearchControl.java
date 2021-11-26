package com.mer.plamer.controller;

import com.mer.plamer.usecases.LibraryAction;
import com.mer.plamer.usecases.UserLibraryAction;
import com.mer.plamer.usecases.PlaylistLibraryAction;
import com.mer.plamer.usecases.TrackLibraryAction;

public class SearchControl {
    LibraryAction libraryAction;

    public static TrackLibraryAction trackLibraryAction = new TrackLibraryAction();
    public static UserLibraryAction userLibraryAction = new UserLibraryAction();
    public static PlaylistLibraryAction playlistLibraryAction = new PlaylistLibraryAction();

    public SearchControl() {

    }

    public void searchTrack() {

    }

    public void searchPlaylist(String keyword) {

    }

    public void searchUser() {
    }
}
