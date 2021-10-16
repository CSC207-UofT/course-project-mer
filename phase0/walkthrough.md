For the scenario walk through, we will implementing the base play feature of the music player.
We will be providing a locally saved mp3 file for demonstration purpose.
When the program is being compiled and ran, mainactivity will access the mp3 file in through res/raw
as well as other ui elements such as the play and pause buttons.

After the mp3 file is loaded. The user may press the play button to start playing the track.
This is done through the button under PlayControl class, when pressed, it will call upon
the corresponding play method in PlayAction class. The same will apply with the pause button, when
the music is playing, pressing the pause button will also call the pause method.