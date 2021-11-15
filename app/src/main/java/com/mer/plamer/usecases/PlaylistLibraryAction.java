package com.mer.plamer.usecases;

import com.mer.plamer.entities.Playlist;
import com.mer.plamer.entities.PlaylistLibrary;
import com.mer.plamer.entities.Track;
import com.mer.plamer.entities.TrackLibrary;

public class PlaylistLibraryAction implements LibraryAction<Playlist> {

    public static PlaylistLibrary playlistLibrary = new PlaylistLibrary();

    /**
     * Delete the playlist in the playlist library.
     *
     * @param playlist_id the id of the playlist.
     * @return Whether the playlist is successfully removed or not.
     */
    public boolean delete(String playlist_id) {
        return playlistLibrary.remove(playlist_id);
    }

    /**
     * Search the required playlist.
     *
     * @param playlist_id the id of the required playlist.
     * @return the required playlist.
     */
    public Playlist search(String playlist_id) {
        return playlistLibrary.contain(playlist_id);
    }

    /**
     * add a playlist to the playlist library.
     *
     * @param name the playlist we want to add.
     */
    public void add(String name) {
        playlistLibrary.add(playlistLibrary.create(name));

    }
}
