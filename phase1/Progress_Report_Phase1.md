# Phase 1 Progress Report

## Nov 5th



* Distributed work throughout the group
* Plan on adding activities for each feature.

## Nov 9th



* Removed searchable entity
    * Have shared responsibility with the storable entity.

## Nov 10th



* Usecases for different features
    * User
    * Playlist
* Changed libraryaction from an abstract class to an interface, due to the incompatibilities of some methods.

## Nov 11th



* Serialization
    * Scans existing files from the local library. However, this method was found to be biased later. 
* More use cases
    * Libraries
    * Actions
    * Search

## Nov 12th



* Improved UI for the player activity
* Found some clean architecture violations, namely controllers have to pass entities to use cases, which should not be allowed. The solution was to use strings as references of entities and make the controller pass down those string representations instead.
* Serialization (using dictionary)
    * Does not work well when tracks are removed, this previous serialization method will mess up the index system as the system restart. Thus instead decided to use TinyDB to store every track/playlist/user creation in a .json file, which solved the state saving problem. 

## Nov 13th



* More unit tests
* Added skeleton activity for the main page and register/log in.
* Made several design decisions, such as whether a method to create a playlist should be implemented in playlistaction or playlistlibraryaction. Decided to implement in playlistlibraryaction after discussion, and did the same for other similar classes.

## Nov 14th



* Added skeleton activity for the search feature
* Improved UI for register/log in activity
* Finalized Design Documentation and Progress report

# Open questions your group is struggling with:

Our group currently is going through a difficult learning process trying to both apply newly learned concepts in android studio as we go while maintaining a clean architecture. Since we have never properly learned interactions between the android development environment and java, our experiment trying to get things to work will often cause messy code, giving us a hard time refactoring and optimizing them.

# What has worked well so far with your design

We have implemented and have some other design patterns planned for phase 2 as we continue to round out our features.  We are also keeping the consistency of our classes with the by-layer packaging strategy.

Works done by each member and plans:

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
   <td>Worked on Serialization and library-related topics, help with documentation

   </td>
   <td>Implement the serialization into track and playlist, and adjust the data structure correspondingly.

   </td>
  </tr>
  <tr>
   <td>Jaden

   </td>
   <td>Worked on User related activities.

   </td>
   <td>Finish User related activity, and implement admin-related methods.

   </td>
  </tr>
  <tr>
   <td>Joseph

   </td>
   <td>Worked on Search related activities and documentation.

   </td>
   <td>Finish up the Search feature, and possibly other actions that interact with other activities.

   </td>
  </tr>
  <tr>
   <td>Kaibo

   </td>
   <td>Worked on icons and UI of multiple activities.

   </td>
   <td>Finish UI implementation. Work on other activities.

   </td>
  </tr>
  <tr>
   <td>Michael

   </td>
   <td>Worked on Improving Player related activities and documentation.

   </td>
   <td>
   </td>
  </tr>
  <tr>
   <td>Nigel

   </td>
   <td>Wrote unit tests for the program.

   </td>
   <td>
   </td>
  </tr>
  <tr>
   <td>Victor

   </td>
   <td>Worked on Playlist related activities.

   </td>
   <td>
   </td>
  </tr>
