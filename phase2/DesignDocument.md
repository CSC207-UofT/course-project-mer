# Design Document

## Specifications:

Plamer will present a set of features of a music player:

- Can import audio files and play them

- Can pause/change tracks

- Can seek/reverse to a position when playing a track

- Can display a song’s metadata

- Can store a user’s login information

- Can store a user created playlist

- Has multiple play mods (repeat on/off, shuffle)

## Major Design Decisions:

* Every basic entity is represented by a string representation. In particular, playlists and tracks are represented by a string of integers. This is because we want to allow tracks and playlists of the same names to exist. This can also help us to follow the clean architecture as controllers can just pass those representations to the use cases when searching for an entity.
* Decide to use tinyBD as our serialization strategy. Serialization by basic file creating and appending methods were proven to cause a lot of problems, and can easily mess up our database. Thus an outside file storage manager is the best option to use here. After some struggling, and a failed method because of not following clean architecture, we came up with a clean method of serialization. 
* We ended up having a lot of user interfaces to implement, thus we divide them up as different activities, and then connect them together. This makes the whole user interface implementation much easier.
* Decided to merge view and presenter responsibilities within one Activity class. This potentially violates Clean Architecture but since we are developing in an Android environment, we wanted to avoid passing around contexts as parameters between classes. Part of the nature of Android is that a lot of actions are defined along with Android elements (such as buttons), so it would make sense that, if we don't pass around application contexts, we cannot tell what a button to do or update view elements. Another reason is because of the number of Activity classes we have due to the nature of our program (a music player need many pages for our specifications). If we split each into a view class and a presenter class, this would potentially cause a bigger mess and make revisions harder to track.

## Clean Architecture: 

In our project, we try to keep the dependency between every layer very clean. However, during the implementation, there are constantly small errors being made that mistakenly introduce dependencies between controllers and entities. They are often noticed only after a while, and affect a lot of other codes that are connected to it. Luckily most of them are fixed in the end.

In most cases, string representation of entities really came to rescue. We set up our program such that it can easily reference entities using their string representations, which makes the controller implementation much easier.

A big clean architecture problem we ran into was serialization. Since TinyDB is on the gateway level, it becomes a problem for how it should gain access to entities that we want to store. We eventually came up with a way. Instead of saving each track/playlist/user to a local file, we found a way to store the whole library class to the local file, and update it on every entity creation. This happens at the controller level so it perfectly follows clean architecture, and it is easy to keep track of.  

For reasonings behind our implementation on the Activities, check the Major Design Decisions section.

## SOLID Principle:

SOLID Principle is being followed as much as possible during the code design. A few examples are noted below:  
### Single Responsibility principle: 
We made sure to have enough of different usecases distribute responsibilities instead of assigning responsibilities to only a few or single class. (For reasonings behind our Activities implementation, check the Major Design Decisions section)
### Open/Closed principle: 
We designed our entities such that they contain sufficient information (closed for modification) and we can add additional usecase classes to make use of those information combined to derive other features/information.  
### Liskov Substitution principle: 
We constructed class User as the default user type of our program. In addition, a class Admin is also made to have not only all the features a User have, but also additional extended features (such as deleting a user) that don't require modifying or removing existing User features.  
### Interface Segregation principle: 
In our Storable interface, we did not put in redundant classes to be implemented, only keeping the minimum required for an object to be Storable (i.e. contains entities)


## Packaging Strategy:

The packaging strategy we chose since phase 0, which hasn't changed until now, is to package by layer. This is because we have classes with similar names in every layer. Such as the class playlist(entity), the class playlistaction(use cases), and the class playlistcontrol(controller). This is almost the same for every function we have. Thus it is to our interest to put every layer in their own folder, so anyone who has a chance to read our code can navigate to the right class they want without having to actually read those classes.

## Design Patterns:

One of the design patterns we have implemented so far is the observer design pattern. When the user is registering for an account, their input will become an observable object and be used by observers like userlibrary.  The builder design pattern is also used. Since track is not merely an artificial class like playlist and user, it actually refers to an mp3 file, which, by nature has different metadata attributes (e.g. some doesn’t have genre information but some does). To accommodate such situation, we used Builder design pattern to give each Track object the metadata an mp3 has, which avoids assigning non-existent metadata to a Track object, and helps us follow the Clean Architecture since Track implemented this way will not need to fetch information from Android.

## Details and descriptions about unit tests:
Unit tests were constructed to test most of the methods for entities, use cases, and controllers. These tests were constructed to ensure that each method performs as it should. The difficulty to create these unit tests were also clear indicators to violations of clean architecture, SOLID principle, or the presence of code smells as violations would drastically increase the difficulty to create said tests. Without these violations, most unit tests no longer required the ability to mock an android environment as they were used to test the relationship with each other (controllers with use cases, use cases with entities). 
