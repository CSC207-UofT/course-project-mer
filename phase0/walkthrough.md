This program can be compiled with Android Studio and, as test, works on API version 30.

For the scenario walk through, we will be implementing the basic playing feature of the music player. \
The program will be packed with a mp3 file for demonstration purpose. \
When the program is compiled and ran, MainActivity will call PlayControl to initialize button controls, and also tell PlayAction to prepare audio playback. \
After initialization, PlayAction will load the audio file and playback will be ready. \
User of the app will be able to play/pause the audio through click of a button. \
We have packed our audio file in res/raw so, when presented, the program can be run with one click.
