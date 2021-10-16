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
* Reviewed feedback and restructured classes, and redistributed responsibilities.
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
* Created classes for everything in the project that will not be presented in the skeletal program

## Works done by each member and plans:

<table>
  <tr>
   <td>Name
   </td>
   <td>Work Done
   </td>
   <td>Future Plan
   </td>
  </tr>
  <tr>
   <td>Alex
   </td>
   <td>Structured Controller classes for future implementation.
<p>
Polished and reorganized CRC card into categories on github.
   </td>
   <td>Implement track storage system and other classes based on group decisions.
   </td>
  </tr>
  <tr>
   <td>Jaden
   </td>
   <td>Optimized code for PlayAction and PlayControl necessary for the walkthrough scenario demo.
<p>
Optimized the responsibility and dependency for CRC cards.
   </td>
   <td>Implement user cases and controllers.
<p>
Fine tone the relationship and dependency of each class.
   </td>
  </tr>
  <tr>
   <td>Joseph
   </td>
   <td>Wrote progress report, initial walkthrough scenario design.
   </td>
   <td>Implement assigned classes based on group communication. 
   </td>
  </tr>
  <tr>
   <td>Kaibo
   </td>
   <td>Drawn user interface for both Play and unimplemented features.
<p>
Implemented UI for walkthrough scenario.
   </td>
   <td>Design and implement user interface. Work on the UI interaction code.
   </td>
  </tr>
  <tr>
   <td>Michael
   </td>
   <td>Created project specifications
<p>
Implemented the audio playback feature for skeleton program 
<p>
Fine-tuned structures of entity classes
<p>
Edited scenario walk-through according to implementation details
   </td>
   <td>Work on the apps communication to Android (e.g. FileIO, saving contents to local files)
<p>
Work on implementing more features outlined in specs
<p>
Add documentation (JavaDoc) to methods
   </td>
  </tr>
  <tr>
   <td>Nigel
   </td>
   <td>Wrote majority of entity classes (Michael fixed various parts)
   </td>
   <td>Implement assigned classes based on group communication. 
   </td>
  </tr>
  <tr>
   <td>Victor
   </td>
   <td>Wrote unittest for PlayAction, and helped edited progress report.
   </td>
   <td>Implement assigned classes based on group communication. 
   </td>
  </tr>
</table>

