package com.mer.plamer.usecases;

import com.mer.plamer.entities.Playlist;
import com.mer.plamer.entities.PlaylistLibrary;
import com.mer.plamer.entities.Track;

import java.util.ArrayList;

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
     * Search the required playlists.
     * @param keyword the provided keyword by the user
     * @return the required playlists.
     */
    public ArrayList<Playlist> search(String keyword) {
        ArrayList<Playlist> searchPlaylist = new ArrayList<>();
        for (Playlist p : playlistLibrary.getPlaylists()){
            if (p.getName().contains(keyword)){
                searchPlaylist.add(p);
            }
            for (Track t : p.getTracks()){
                if ((t.getArtist().contains(keyword) || t.getTitle().contains(keyword)
                        || t.getGenre().contains(keyword)) && !(searchPlaylist.contains(p))){
                    searchPlaylist.add(p);
                } else
                    break;
            }
        }
        return searchPlaylist;
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
