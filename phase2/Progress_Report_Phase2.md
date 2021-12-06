
# Phase 2 Progress Report

## Nov 24th:



* Distributed work throughout the group
* Plans are to fulfill the original specification, as phase 1 was a rush

## Nov 25th:



* Discussed about separating Presenter and Controller responsibilities
* Discussed about various methods violating Clean Architecture in phase 1
* Began implementation of PlaylistControl
* Updated SearchControl with more methods

## Nov 26th:



* Discussed about details on serialization (TinyDB) and began its implementation
* Serialization prototype proved to work: User account information was able to be written to and read from local storage

## Nov 27th:



* Discussed and decided that LibraryAction classes do not have inheritance, since each Action classes have rather different responsibilities
* Deleted LibraryAction (The interface formerly implemented by LibraryAction classes)

## Nov 28th:



* Finished part of the tests for completed classes.
* Finished serialization for User
* Track violated clean architecture, plans to fix were proposed

## Nov 29th:



* Met with TA during tutorial
* Asked about separating responsibilities of presenters and controllers
* Asked about ways to resolve Clean Architecture violation when using TinyDB
* Asked about packaging strategy for TinyDB (external package)
* Decided that we would build and hand in an APK file instead of a video demo at the end of this project

## Dec 3rd:



* Sorted out unfinished classes.
* Found other classes that violated clean architecture and discussed possible solutions.
* Finished implementation on serialization (all entities)

## Dec 5th:



* Discussed and concluded that parent class “LibraryControl” is no longer needed, as more detailed responsibilities were distributed among different controllers
* Finished the rest of the classes
* Solved clean architecture issue
* Finish implementing the user interface

<table>
  <tr>
   <td colspan="2" >
Significant pull requests
   </td>
  </tr>
  <tr>
   <td>Name
   </td>
   <td>Link to PR
   </td>
  </tr>
  <tr>
   <td>Michael
   </td>
   <td><a href="https://github.com/CSC207-UofT/course-project-mer/pull/43">https://github.com/CSC207-UofT/course-project-mer/pull/43</a>
<p>
Reasons: Aside from firsting enabling the app to play something, this pull request marks full implementation of playback features such as skip/prev and play mode change, making the app a functional one.
   </td>
  </tr>
  <tr>
   <td>Victor
   </td>
   <td><a href="https://github.com/CSC207-UofT/course-project-mer/pull/41">https://github.com/CSC207-UofT/course-project-mer/pull/41</a>
<p>
Reasons: Playlist is one of the most important features of a music player, and without this controller class our music player would not be able to manipulate playlists or have the playlist function. The newest version of this class completely follows the clean architecture issue so that any change of the music player in future would not affect this class much.
   </td>
  </tr>
  <tr>
   <td>Joseph
   </td>
   <td>
   </td>
  </tr>
  <tr>
   <td>Alex
   </td>
   <td><a href="https://github.com/CSC207-UofT/course-project-mer/pull/38">https://github.com/CSC207-UofT/course-project-mer/pull/38</a>
<p>
Reason: The newest version of Serialization is not only smaller in size, but also follows the clean architecture completely. This version of serialization is harder to cause error, and ultimately makes many-times saving and loading durable.
   </td>
  </tr>
  <tr>
   <td>Kaibo
   </td>
   <td>
   </td>
  </tr>
  <tr>
   <td>Jaden
   </td>
   <td><a href="https://github.com/CSC207-UofT/course-project-mer/pull/48">https://github.com/CSC207-UofT/course-project-mer/pull/48</a>
<p>
Reason: This pull request restructured and re implemented many methods in user related class. Before the PL, there were many obvious violations to clean architecture in user control and some other classes. This PL fixed all of them without breaking the functionality of the program.
   </td>
  </tr>
  <tr>
   <td>Nigel
   </td>
   <td>
   </td>
  </tr>
</table>



<table>
  <tr>
   <td colspan="2" >Work done per individual
   </td>
  </tr>
  <tr>
   <td>Name
   </td>
   <td>Effort
   </td>
  </tr>
  <tr>
   <td>Michael
   </td>
   <td>Fixed a few Clean Architecture violations; Implemented the rest of playback features; 
   </td>
  </tr>
  <tr>
   <td>Victor
   </td>
   <td>Implemented entity class Playlist, use case class PlaylistAction, controller class PlaylistController, Edited CRC cards for Playlist, PlaylistAction, PlaylistController, keep progress report updated.
   </td>
  </tr>
  <tr>
   <td>Joseph
   </td>
   <td>Implemented Controller class SearchControl, updated and added some methods for entity classes and the three library usecases classes. Wrote Accessibility Report.
   </td>
  </tr>
  <tr>
   <td>Alex
   </td>
   <td>Finished the serialization of the project, built a first version, then figured out a cleaner one.
   </td>
  </tr>
  <tr>
   <td>Kaibo
   </td>
   <td>
   </td>
  </tr>
  <tr>
   <td>Jaden
   </td>
   <td>Fixed Clean Architecture violations in user related classes; Implement admin and link all method and feature in user to UI.
   </td>
  </tr>
  <tr>
   <td>Nigel
   </td>
   <td>
   </td>
  </tr>
</table>
