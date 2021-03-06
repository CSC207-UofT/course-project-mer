# Design Document

## Specifications:

Plamer presents:

- Import audio files and play them

- Pause/change tracks

- Seek/reverse to a position when playing a track

- Display a song’s metadata

- Store a user’s login information

- Store a user created playlist

- Multiple play mods (repeat on/off, shuffle)

## Major Design Decisions:

* Every basic entity is represented by a [string representation](https://github.com/CSC207-UofT/course-project-mer/blob/593c412a4ef2bba8268424332541b8dfaa121675/app/src/main/java/com/mer/plamer/entities/Track.java#L12-L28). In particular, playlists and tracks are represented by a string of integers. This is because we want to allow tracks and playlists of the same names to exist. This can also help us to follow the clean architecture as controllers can just pass those representations to the use cases when searching for an entity.
* Decide to use [tinyDB](https://github.com/CSC207-UofT/course-project-mer/blob/335aba8fcd1f4a7b83aeb335daa2f6ac15b9cd7c/app/src/main/java/com/mer/plamer/TinyDB.java) as our serialization strategy. Serialization by basic file creating and appending methods were proven to cause a lot of problems, and can easily mess up our database. Thus an outside file storage manager is the best option to use here. After some struggling, and a failed method because of not following clean architecture, we came up with a clean method of serialization. 
* We decide to intentionally [not store](https://github.com/CSC207-UofT/course-project-mer/blob/209c1fc5f348920ffa06dc61cfdbf9b23b91d43b/app/src/main/java/com/mer/plamer/controller/PlaylistControl.java#L115-L118) the playback status of playlists. This is because after some serious discussions, we concluded that many of the major websites reset the order of their lists to default every time a user visits it, so it would be in our interest to follow that pattern. This decision did not only make our program easier to use, it also saved a lot of work on user interface implementation.
We decided instead of giving our users an option to register as an admin, we provide the user with a pre-registered admin account. This is inspired by the many other websites that have admin/admin as their default login identification. This is a decision that made our admin account look more professional, instead of just a subclass made for no purpose. So just for reference, our admin account is {username: admin, password: adminadmin}.
* Decided to merge view and presenter responsibilities within one [Activity class](https://github.com/CSC207-UofT/course-project-mer/blob/1dfb92fe40e254c8ebe375070fbfa51760200642/app/src/main/java/com/mer/plamer/PlayerActivity.java#L48-L81). This potentially violates Clean Architecture but since we are developing in an Android environment, we wanted to avoid passing around contexts as parameters between classes. Part of the nature of Android is that a lot of actions are defined along with Android elements (such as buttons), so it would make sense that, if we don't pass around application contexts, we cannot tell what a button to do or update view elements. Another reason is because of the number of Activity classes we have due to the nature of our program (a music player need many pages for our specifications). If we split each into a view class and a presenter class, this would potentially cause a bigger mess and make revisions harder to track.
* We decided instead of giving our users an option to register as an admin, we provide the user with a [pre-registered admin account](https://github.com/CSC207-UofT/course-project-mer/blob/209c1fc5f348920ffa06dc61cfdbf9b23b91d43b/app/src/main/java/com/mer/plamer/entities/UserLibrary.java#L12-L15). This is inspired by the many other websites that have admin/admin as their default login identification. This is a decision that made our admin account look more professional, instead of just a subclass made for no purpose. So just for reference, our admin account is {username: admin, password: adminadmin}.


## Clean Architecture: 

In our project, we try to keep the dependency between every layer very clean. However, during the implementation, there are constantly small errors being made that mistakenly introduce dependencies between controllers and entities. They are often noticed only after a while, and affect a lot of other codes that are connected to it. Luckily most of them are fixed in the end.

In most cases, string representation of entities really came to rescue. We set up our program such that it can easily reference entities using their string representations, which makes the controller implementation much easier.

A big clean architecture problem we ran into was serialization. Since TinyDB is on the gateway level, it becomes a problem for how it should gain access to entities that we want to store. We eventually came up with a way. Instead of saving each track/playlist/user to a local file, we found a way to store the whole library class to the local file, and update it on every entity creation. This happens at the controller level so it follows clean architecture, and it is easy to keep track of. However, after all the work we have done, we still ended up refering to, inspite not directly, library classes when pulling our libraries out from tinyDB. Since the [thing](https://github.com/CSC207-UofT/course-project-mer/blob/36ddd1e8dd74553cc63cf131f78f41195d87377d/app/src/main/java/com/mer/plamer/controller/PlaylistControl.java#L98) we are refering to is only an attribute of usecases classes, there are no real indicator to tell that they have to be entities, yet we know for a fact that they are. We unfortuantely noticed it too late and could not come up with a solution with it. A full serialization will require a complete string representation of each library, which will be a not duable amount of work.

For reasonings behind our implementation on the Activities, check the Major Design Decisions section.

## SOLID Principle:

SOLID Principle is being followed as much as possible during the code design. A few examples are noted below:  
### Single Responsibility principle: 
We made sure to have enough of different [usecases](https://github.com/CSC207-UofT/course-project-mer/tree/main/app/src/main/java/com/mer/plamer/usecases) distribute responsibilities instead of assigning responsibilities to only a few or single class. (For reasonings behind our Activities implementation, check the Major Design Decisions section)
### Open/Closed principle: 
We designed our [entities](https://github.com/CSC207-UofT/course-project-mer/tree/main/app/src/main/java/com/mer/plamer/entities) such that they contain sufficient information (closed for modification) and we can add additional usecase classes to make use of those information combined to derive other features/information.  
### Liskov Substitution principle: 
We constructed class User as the default user type of our program. In addition, a class Admin is also made to have not only all the features a User have, but also additional extended features (such as deleting a user) that don't require modifying or removing existing User features.  
### Interface Segregation principle: 
In our [Storable](https://github.com/CSC207-UofT/course-project-mer/blob/main/app/src/main/java/com/mer/plamer/entities/Storable.java) interface, we did not put in redundant classes to be implemented, only keeping the minimum required for an object to be Storable (i.e. contains entities)


## Packaging Strategy:

The packaging strategy we chose since phase 0, which hasn't changed until now, is to package [by layer](https://github.com/CSC207-UofT/course-project-mer/tree/main/app/src/main/java/com/mer/plamer). This is because we have classes with similar names in every layer. Such as the class playlist(entity), the class playlistaction(use cases), and the class playlistcontrol(controller). This is almost the same for every function we have. Thus it is to our interest to put every layer in their own folder, so anyone who has a chance to read our code can navigate to the right class they want without having to actually read those classes.

## Design Patterns:

One of the design patterns we have implemented so far is the observer design pattern. When the user is registering for an account, their input will become an observable object and be used by observers like userlibrary. The [Builder](https://github.com/CSC207-UofT/course-project-mer/blob/186c0864b8f75c4befc1ceff0404697313ffec7b/app/src/main/java/com/mer/plamer/usecases/TrackLibraryAction.java#L64) design pattern is also used. Since track is not merely an artificial class like playlist and user, it actually refers to an mp3 file, which, by nature has different metadata attributes (e.g. some doesn’t have genre information but some does). To accommodate such situation, we used Builder design pattern to give each Track object the metadata an mp3 has, which avoids assigning non-existent metadata to a Track object, and helps us follow the Clean Architecture since Track implemented this way will not need to fetch information from Android.

## Refactoring Strategy:

All programmers make mistakes. So, as a group we did not expect everyone to write perfect code. Sometimes we encounter codes from members that violate Clean Architectures, do not follow naming conventions, have code smells, or even without documentations. When one of us see any of these happening, we remind each other on potential issues there are with his/her code, give them suggestions and keep track of what's happening in different classes. This is a good strategy to keep us actively seeking issues in our code, and keep track of what is happening in each class.

Examples of refactoring in action: [1](https://github.com/CSC207-UofT/course-project-mer/pull/92), [2](https://github.com/CSC207-UofT/course-project-mer/pull/94) 

Lastly, we've dedicated one member on the team for a final check on the codes (but not the function/features) for the end of each phase to ensure again the codes are issue-free.

## Details and Descriptions about Unit Tests:
Compared to Phase 1, unit tests for mostly all of entities, use cases, and controllers were added. These tests were constructed to ensure that each method performs as it should. While constructing these tests, the difficulties that we came across with making them turned out to be clear violations of clean architecture and the SOLID principles. Through these tests, we were able to ensure that each method performs as intended. In addition, the use of mocks were incorporated in and only in controller unit tests. Since controllers deal with presenters and gateways, the use of mocks were crucial in producing functional unit tests. Also, the use of mocks only in controller unit tests and not entity/use case unit tests is a good indicator that clean architecture is being followed. The coverage of these unit tests can seen here: 

<p>
  <img src="https://github.com/CSC207-UofT/course-project-mer/blob/main/phase2/test_coverage.png" width=750>
</p>

We utilized private classes in various controller adapters which, as they are private, are impossible to test. Other than those classes, all controller classes were tested. 
As for presenters, these components are heavily linked with the app itself, making it extremely difficult to unit test. Therefore, we required non-code tests that involved emulators to ensure that the presenters were doing their job. As seen in the demo, those classes function as intended.
