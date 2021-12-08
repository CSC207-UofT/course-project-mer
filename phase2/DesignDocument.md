# Design Document

## Major Design Decisions:



* Every basic entity is represented by a string representation. In particular, playlists and tracks are represented by a string of integers. This is because we want to allow tracks and playlists of the same names to exist. This can also help us to follow the clean architecture as controllers can just pass those representations to the use cases when searching for an entity.
* Decide to use tinyBD as our serialization strategy. Serialization by basic file creating and appending methods were proven to cause a lot of problems, and can easily mess up our database. Thus an outside file storage manager is the best option to use here. After some struggling, and a failed method because of not following clean architecture, we came up with a clean method of serialization. 
* We ended up having a lot of user interfaces to implement, thus we divide them up as different activities, and then connect them together. This makes the whole user interface implementation much easier.

## Clean Architecture: 

In our project, we try to keep the dependency between every layer very clean. However, during the implementation, there are constantly small errors being made that mistakenly introduce dependencies between controllers and entities. They are often noticed only after a while, and affect a lot of other codes that are connected to it. Luckily most of them are fixed in the end.

In most cases, string representation of entities really came to rescue. We set up our program such that it can easily reference entities using their string representations, which makes the controller implementation much easier.

A big clean architecture problem we ran into was serialization. Since TinyDB is on the gateway level, it becomes a problem for how it should gain access to entities that we want to store. We eventually came up with a way. Instead of saving each track/playlist/user to a local file, we found a way to store the whole library class to the local file, and update it on every entity creation. This happens at the controller level so it perfectly follows clean architecture, and it is easy to keep track of.

## SOLID Principle:

SOLID Principle is being followed as much as possible during the code design. For example, each of our classes is only responsible for one of the entities. Sometimes there are multiple classes for one entity just to divide work up. 

## Packaging Strategy:

The packaging strategy we chose since phase 0, which hasn't changed until now, is to package by layer. This is because we have classes with similar names in every layer. Such as the class playlist(entity), the class playlistaction(use cases), and the class playlistcontrol(controller). This is almost the same for every function we have. Thus it is to our interest to put every layer in their own folder, so anyone who has a chance to read our code can navigate to the right class they want without having to actually read those classes.

## Design Patterns:

One of the design patterns we have implemented so far is the observer design pattern. When the user is registering for an account, their input will become an observable object and be used by observers like userlibrary.  The builder design pattern is also used. Since track is not merely an artificial class like playlist and user, it actually refers to an mp3 file, which, by nature has different metadata attributes (e.g. some doesn’t have genre information but some does). To accommodate such situation, we used Builder design pattern to give each Track object the metadata an mp3 has, which avoids assigning non-existent metadata to a Track object, and helps us follow the Clean Architecture since Track implemented this way will not need to fetch information from Android.

## Details and descriptions about unit tests:
Unit tests were constructed to test most of the methods for entities, use cases, and controllers. These tests were constructed to ensure that each method performs as it should. The difficulty to create these unit tests were also clear indicators to violations of clean architecture, SOLID principle, or the presence of code smells as violations would drastically increase the difficulty to create said tests. Without these violations, most unit tests no longer required the ability to mock an android environment as they were used to test the relationship with each other (controllers with use cases, use cases with entities). 
