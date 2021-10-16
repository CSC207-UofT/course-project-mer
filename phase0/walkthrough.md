This program can be compiled with Android Studio and, as tested, works on Android API version 30.

For the scenario walk through, we will be implementing the basic playing feature of the music player. \
The program is be packed with a mp3 file for demonstration purpose, and is designated to run on a AVD (Android Virtual Device). \
When the program is compiled and ran, MainActivity will call PlayControl to initialize button controls, and also tell PlayAction to prepare audio playback. \
After initialization, PlayAction will load the audio file and playback will be ready. \
User of the app will be able to play/pause the audio through click of a button. \
We have packed our audio file in res/raw so, when presented, the program can be run with one click.

A set of unittests are also included in app/src/androidTest/java/com/plamer/PlayActionTest for testing basic functionality of PlayAction (play/pause)
