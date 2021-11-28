package com.mer.plamer.usecases;

import android.annotation.SuppressLint;

import com.mer.plamer.entities.Playlist;
import com.mer.plamer.entities.PlaylistLibrary;
import com.mer.plamer.entities.Track;
import com.mer.plamer.MyApp;
import com.mer.plamer.TinyDB;

import java.util.ArrayList;

public class PlaylistLibraryAction {

    public static PlaylistLibrary playlistLibrary = new PlaylistLibrary();
    @SuppressLint("StaticFieldLeak")
    private static final TinyDB tinydb = new TinyDB(MyApp.getContext());

    /**
     * Delete the playlist in the playlist library.
     *
     * @param playlist_id the id of the playlist.
     * @return Whether the playlist is successfully removed or not.
     */
    public static boolean delete(String playlist_id) {
        return playlistLibrary.remove(playlist_id);
    }

    /**
     * Search the required playlists.
     * @param keyword the provided keyword by the user
     * @return the required playlists.
     */
    public static ArrayList<Playlist> search(String keyword) {
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
    public static void add(String name) {
        playlistLibrary.add(playlistLibrary.create(name));


    }

    /**
     * Scan and add the local playlists on every launch.
     */
    public static void scanLocal() {
        int i = 0;
        int current_id = tinydb.getInt("playlist_static_id");
        while ( i <= current_id) {
            if (tinydb.objectExists(String.valueOf(i)+"p")) {
                playlistLibrary.add(tinydb.getObject(String.valueOf(i) + "p", Playlist.class));
            }
            i++;
        }
        Playlist.changeId(current_id);
    }
}
