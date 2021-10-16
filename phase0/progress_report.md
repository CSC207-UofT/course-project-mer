# Plamer Progress Report - Phase 0

## Specifications
Plamer will present a set of features of a music player:

- Can import an audio file and play it
- Can pause/change a Track when User prompts
- Can seek/reverse the progress of a playing Track when user prompts
- Can display a song’s metadata
- Allows register/log in as a user
- Allows user to create a playlist and stores it
- Can store a user’s play history
- Allows user to create a playlist
- Allows user to switch play modes between repeat on/off, shuffle

## Progress by date
### October 4th (1st group meeting)


* Brainstorming ideas for the project
    1. Replicate a board game

        Rejected, too common and lacks depth

    2. Tower defence game

        Rejected, would spend too much effort on game designing

    3. Music player (chose this)
* Discussed what features the project will include and wrote the first draft of the specification document.
* Came up with a few examples of entities (Library), use cases (UserAction, TrackAction), and controller classes (UserControll, TrackControll).
* Started on creating CRC cards for previously mentioned classes

### October 11th



* Completed majority of the CRC cards.
* Reviewed feedback, restructured classes ,and redistributed responsibilities.
* Discussions on whether interfaces or abstract classes should be used for certain classes.
* Prepared questions to ask in the upcoming meeting on Tuesday.
    1. Suggestions on one of the two features to add:
        1. User comments
        2. Song recommendation
    2. Inquiries on design decision-making. How many responsibilities are “too many” responsibilities for a class?

### October 12th(After TA meeting)



* Revised CRC cards:
    1. Removed class Artists, Change User from abstract class to regular class
* Considered adding abstract class/interfaces, but didn’t
* Started skeleton program
* Discussions on interactions between controller and use cases. How many use cases should a controller depend on.
* Decide to use a GUI rather than CLI.

### October 15th



* Finalized CRC cards: 
    1. Added inputs for the controller class
    2. Implemented an interface Library for entity class
    3. Add new abstract class LibraryAction
    4. Removed VolumeControl, VolumeAction, VolumeAdjust
    5. Added new presenter class
* Designed a rough user interface
* Implemented basic play function
* Created classes structures according to CRC cards (including ones that will not be presented in the skeletal program)
