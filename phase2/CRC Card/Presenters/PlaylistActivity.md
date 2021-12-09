# PlaylistActivity

## Parent Class:
AppCompatActivity

## Subclasses:
None

## Responsibilities:
Control the page of playlist library a user has. This activity get information from usesControl which is a list of all playlist current user has. Then displaying the list on Listview. When clicking on the playlist in the Listview, the page of this specific playlist will be opened. When long pressing the playlist, the playlist can be deleted. When pressing the add button at the top, user can add a new empty playlist into the playlist library of this user. This activity also has some buttons to control playing or pause, switching the repeat mode, playing the previous or next track.

## Collaborators:
OwnPlaylistActivity, PlayerActivity, AddAdapter, PlayControl, PlaylistAdapter, PlaylistControl, UserControl, PlayAction, PlaylistLibraryAction, UserAction, MainPageActivity
