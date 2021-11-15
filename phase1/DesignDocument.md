# Design Documents

## Major Design Decisions:



* Every basic entity is represented by a string representation. In particular, playlists and tracks are represented by a string of integers. This is because we want to allow tracks and playlists of the same names to exist. This can also help us to follow the clean architecture as controllers can just pass those representations to the use cases when searching for an entity.
* Decide to use tinyBD as our serialization strategy. Serialization by basic file creating and appending methods were proven to cause a lot of problems, and can easily mess up our database. Thus an outside file storage manager is the best option to use here.
* We ended up having a lot of user interfaces to implement, thus we divide them up as different activities, and then connect them together. This makes the whole user interface implementation much easier.

## Clean Architecture: 

In our project, we try to keep the dependency between every layer very clean. However, during the implementation, there are constantly small errors being made that mistakenly introduce dependencies between controllers and entities. They are often noticed only after a while, and affect a lot of other codes that are connected to it. Luckily most of them are fixed in the end.

## SOLID Principle:

SOLID Principle is being followed as much as possible during the code design. For example, each of our classes is only responsible for one of the entities. Sometimes there are multiple classes for one entity just to divide work up. 

## Packaging Strategy:

The packaging strategy we chose on phase 0, which hasn't changed until now, is to package by layer. This is because we have classes with similar names in every layer. Such as the class playlist(entity), the class playlistaction(use cases), and the class playlistcontrol(controller). This is almost the same for every function we have. Thus it is to our interest to put every layer in their own folder, so anyone who has a chance to read our code can navigate to the right class they want without having to actually read those classes.

## Design Patterns:

One of the design patterns we have implemented so far is the observer design pattern. When the user is registering for an account, their input will become an observable object and be used by observers like userlibrary.  We also implemented the factory design pattern for search, our library action interface will instantiate different types of objects based on the user’s request.
