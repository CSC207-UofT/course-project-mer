# OwnPlaylistActivity

## Parent Class:
AppCompatActivity

## Subclasses:
None

## Responsibilities:
Control the page of a specific playlist. This activity get the name of a playlist and use PlaylistControl to get its track list. Then display the tracks of this playlist on the Listview in this page. When clicking on the list of tracks, the clicked track will play. When long pressing the track, it can be deleted. When pressing the add button at the top, you can add tracks into this playlist. This activity also has some buttons to control playing or pause, switching the repeat mode, playing the previous or next track.

## Collaborators:
AddTrackToPlaylistActivity, PlayerActivity, PlayControl, PlaylistControl, TrackAdapter, PlayAction, PlaylistAction, PlaylistLibraryAction, PlaylistActivity, SearchActivity,
UserPlaylistActivity
