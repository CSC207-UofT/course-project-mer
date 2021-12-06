
Phase 2 Progress Report

Nov 24th:



* Distributed work throughout the group
* Plans are to fulfill the original specification, as phase 1 was a rush

Nov 25th:



* Discussed about separating Presenter and Controller responsibilities
* Discussed about various methods violating Clean Architecture in phase 1
* Began implementation of PlaylistControl
* Updated SearchControl with more methods

Nov 26th:



* Discussed about details on serialization (TinyDB) and began its implementation
* Serialization prototype proved to work: User account information was able to be written to and read from local storage

Nov 27th:



* Discussed and decided that LibraryAction classes do not have inheritance, since each Action classes have rather different responsibilities
* Deleted LibraryAction (The interface formerly implemented by LibraryAction classes)

Nov 28th:



* Finished part of the tests for completed classes.
* Finished serialization for User
* Track violated clean architecture, plans to fix were proposed

Nov 29th:



* Met with TA during tutorial
* Asked about separating responsibilities of presenters and controllers
* Asked about ways to resolve Clean Architecture violation when using TinyDB
* Asked about packaging strategy for TinyDB (external package)
* Decided that we would build and hand in an APK file instead of a video demo at the end of this project

Dec 3rd:



* Sorted out unfinished classes.
* Found other classes that violated clean architecture and discussed possible solutions.
* Finished implementation on serialization (all entities)

Dec 5th:



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


Major Design Decisions:



* Every basic entity is represented by a string representation. In particular, playlists and tracks are represented by a string of integers. This is because we want to allow tracks and playlists of the same names to exist. This can also help us to follow the clean architecture as controllers can just pass those representations to the use cases when searching for an entity.
* Decide to use tinyBD as our serialization strategy. Serialization by basic file creating and appending methods were proven to cause a lot of problems, and can easily mess up our database. Thus an outside file storage manager is the best option to use here. After some struggling, and a failed method because of not following clean architecture, we came up with a clean method of serialization. 
* We ended up having a lot of user interfaces to implement, thus we divide them up as different activities, and then connect them together. This makes the whole user interface implementation much easier.

#Clean Architecture: 

In our project, we try to keep the dependency between every layer very clean. However, during the implementation, there are constantly small errors being made that mistakenly introduce dependencies between controllers and entities. They are often noticed only after a while, and affect a lot of other codes that are connected to it. Luckily most of them are fixed in the end.

In most cases, string representation of entities really came to rescue. We set up our program such that it can easily reference entities using their string representations, which makes the controller implementation much easier.

A big clean architecture problem we ran into was serialization. Since TinyDB is on the gateway level, it becomes a problem for how it should gain access to entities that we want to store. We eventually came up with a way. Instead of saving each track/playlist/user to a local file, we found a way to store the whole library class to the local file, and update it on every entity creation. This happens at the controller level so it perfectly follows clean architecture, and it is easy to keep track of.

#SOLID Principle:

SOLID Principle is being followed as much as possible during the code design. For example, each of our classes is only responsible for one of the entities. Sometimes there are multiple classes for one entity just to divide work up. 

#Packaging Strategy:

The packaging strategy we chose since phase 0, which hasn't changed until now, is to package by layer. This is because we have classes with similar names in every layer. Such as the class playlist(entity), the class playlistaction(use cases), and the class playlistcontrol(controller). This is almost the same for every function we have. Thus it is to our interest to put every layer in their own folder, so anyone who has a chance to read our code can navigate to the right class they want without having to actually read those classes.

#Design Patterns:

One of the design patterns we have implemented so far is the observer design pattern. When the user is registering for an account, their input will become an observable object and be used by observers like userlibrary.  The builder design pattern is also used. Since track is not merely an artificial class like playlist and user, it actually refers to an mp3 file, which, by nature has different metadata attributes (e.g. some doesn’t have genre information but some does). To accommodate such situation, we used Builder design pattern to give each Track object the metadata an mp3 has, which avoids assigning non-existent metadata to a Track object, and helps us follow the Clean Architecture since Track implemented this way will not need to fetch information from Android.

#Details and descriptions about unit tests (To be done by nigel):
