package com.mer.plamer.controller;

import com.mer.plamer.usecases.UserLibraryAction;
import com.mer.plamer.usecases.PlaylistLibraryAction;
import com.mer.plamer.usecases.TrackLibraryAction;

import java.util.ArrayList;

public class SearchControl {
    TrackLibraryAction trackLibraryAction;
    UserLibraryAction userLibraryAction;
    PlaylistLibraryAction playlistLibraryAction;

    /**
     * Search for all tracks that satisfies the condition.
     * @param keyword provided by the user.
     * @return an array list of all the tracks that satisfies the condition
     */
    public static ArrayList<String> searchTrack(String keyword) {
        return TrackLibraryAction.search(keyword);
    }

    /**
     * Search for all playlist that satisfies the condition.
     * @param keyword provided by the user.
     * @return an array list of all the playlist that satisfies the condition
     */
    public static ArrayList<String> searchPlaylist(String keyword) {
        return PlaylistLibraryAction.search(keyword);
    }

    /**
     * Search for all users that satisfies the condition.
     * @param keyword provided by the user.
     * @return an array list of all the users that satisfies the condition for display
     */
    public static ArrayList<String> searchUser(String keyword) {
        return UserLibraryAction.search(keyword);
    }
}
