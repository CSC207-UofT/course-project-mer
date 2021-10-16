A music player that will have the following feature:

Can import an audio file and play it
Can pause/change a Track when User prompts
Can seek/reverse the progress of a playing Track when User prompts
Can display a Track’s metadata
Can adjust Volume when User prompts
Can register/log in as a User
Can store a User created Playlist
Can store a User’s play history
Can create a Playlist by User
Can switch play modes between repeat on/off, shuffle
Nice to haves:
**Can store and show comments a User made under a song
**Can recommend a song based on a User’s favor when User prompts

Entities: Track, Playlist, User, Admin (subclass of User), Library, TrackLibrary, PlaylistLibrary, UserLibrary

Use Cases: PlayActions, UserActions, TracklibraryActions, UserlibraryActions, PlaylistActions, LibraryActions

Controller: UserControl, PlayControl, SearchControl, PlaylistControl, LibraryControl, Presenter

GUI: play/pause/next/previous, create_User, change_User_password,  Search_song, new_Playlist
