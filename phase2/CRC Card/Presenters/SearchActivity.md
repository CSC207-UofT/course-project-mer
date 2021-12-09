# SearchActivity

## Parent Class:
AppCompatActivity

## Subclasses:
None

## Responsibilities:
Control the page of searching. This activity get the input of the EditText (search keyword) and Spinner (search type) and use them in SearchControl methods to search. The methods in SearchControl will return a list that contains all the information will be shown in this page. Then the information will be displayed in the Listview by adapters. When clicking the result shown on the page, if the type is track, the track will be played, if the type is a playlist, it will be open, and if the type is user, the user's playlists will be opened. This activity also has some buttons to control playing or pause, switching the repeat mode, playing the previous or next track.

## Collaborators:
OwnPlaylistActivity, PlayerActivity, PlayControl, PlaylistAdapter, SearchControl, TrackAdapter, UniversalPlaylistAdapter, UserAdapter, PlayAction, MainPageActivity
