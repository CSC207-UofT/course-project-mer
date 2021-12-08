package com.mer.plamer.usecases;


import com.mer.plamer.entities.Playlist;
import com.mer.plamer.entities.PlaylistLibrary;
import com.mer.plamer.entities.Track;

import java.util.ArrayList;

/**
 * Actions performed on the playlistLibrary
 */
public class PlaylistLibraryAction {

    public static PlaylistLibrary playlistLibrary = new PlaylistLibrary();

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
     * Search for the required playlists.
     *
     * @param keyword the provided keyword by the user
     * @return the ID of required playlists.
     */
    public static ArrayList<String> search(String keyword) {
        ArrayList<String> searchPlaylist = new ArrayList<>();
        String lKeyword = keyword.toLowerCase();
        for (Playlist p : playlistLibrary.getPlaylists()) {
            if (p.getName().toLowerCase().contains(lKeyword)) {
                searchPlaylist.add(p.getId());
            }
            for (Track t : p.getTracks()) {
                if ((t.getArtist().toLowerCase().contains(lKeyword)
                        || t.getTitle().toLowerCase().contains(lKeyword)
                        || t.getGenre().toLowerCase().contains(lKeyword))
                        && !(searchPlaylist.contains(p.getId())))
                {
                    searchPlaylist.add(p.getId());
                } else
                    break;
            }
        }
        return searchPlaylist;
    }

    /**
     * Get the name of search result from its id.
     *
     * @param id ID from search result
     * @return the name of the required playlist.
     */
    public static String searchGetName(String id) {
        for (Playlist p : playlistLibrary.getPlaylists()) {
            if (p.getId().equals(id)) {
                return p.getName();
            }
        }
        return null;
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
     * Return the static id of Playlist class.
     * @return the static id.
     */
    public static int getStaticId() { return Playlist.getStaticId();}

    /**
     * Set the static id of the Playlist to its saved value on every launch.
     * @param saved_id the saved static id of the Playlist class.
     */
    public static void changeId(int saved_id) { Playlist.changeId(saved_id); }

    /**
     * Get a list of integers containing the size of every playlist.
     * @return the list of all playlist size.
     */
    public static ArrayList<Integer> getListOfPlaylistSize() {
        return playlistLibrary.getListofPlaylistSize();
    }


    /**
     * Get a list of String containing the name of every playlist.
     * @return the list of all playlist name.
     */
    public static ArrayList<String> getListOfPlaylistName() {
        return playlistLibrary.getListofPlaylistName();
    }

    /**
     * Get a list of String containing the id of every playlist.
     * @return the list of all playlist id.
     */
    public static ArrayList<String> getListOfPlaylistId() {
        return playlistLibrary.getListOfPlaylistId();
    }

    /**
     * Assign a previously stored library as the new library.
     * @param library the stored library.
     */
    public static void assignLibrary(PlaylistLibrary library) {
        playlistLibrary = library;
    }
}