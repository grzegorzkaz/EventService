<p align="center">Event Service helps you create, join and search for events in your city!</p>

<p align="center"><img src="https://i.imgur.com/NL6irED.png" width=700 alt="Screenshot of Example Documentation created with Slate"></p>


INTRODUCTION
------------

* **Purpose** — _Event Service_ is our first major IT project created by five [_Software Development Academy_](https://sdacademy.dev/) students.  
Purpose of the following project is to create an App that allows you to create, join and search for events in your city.

* **Scope** — Our App gathers information about events taking place in your neighbourhood. Roles are divided to admins and users (registered and unregistered).  
Registered users can create events, invite other users, join existing events or add comments to events.  
Unregistered users can browse _Home Page_ for the events they are interested in. In order to join a certain event a registration is obligatory.  
Event creators have an authority to manage their events by editing event info, deleting comments and removing other users from the event.  
Admins manage the whole App. They can add new events, delete existing events, delete comments in all existing events or ban users.

* **Overview** — Technologies used in the project:  
    - Java
    - MariaDB
    - Spring
    - Maven
    - Thymeleaf


SYSTEM ARCHITECTURE
------------
<p align="center"><img src="https://i.imgur.com/7SorcFb.jpg" width=700 alt="Screenshot of Example Documentation created with Slate"></p>

DATA DESIGN
------------
Data is stored in MariaDB Database established on Linux server. Database is used to store information about users, their roles and events. 

HUMAN INTERFACE DESIGN
------------
Our design is focused on delivering an experience that is simple and convenient for the user. 
Clear structure of the website makes it easy to focus on the most important aspects of the website - which is event aggregation.  
Our event management is simplified and easy to use. 
The use of panels at the top of the website makes it fairly easy to navigate it between different events, adding events, searching events 
as well as logging in and logging out and account management.  
Through a use of bootstrap libraries, our app is also responsive and focused on mobile usage.  
Adding events is intuitive and requires the most basic information about an event to be able to share it with the community. 
We allow users to customize the information about their event accordingly to their needs.

QUESTIONS AND REMARKS
------------
If you have any questions or remarks don't hesitate to [contact us](https://github.com/grzegorzkaz/EventService/issues). We will be greatful for your feedback.

CONTRIBUTORS
------------
_Event Service_ is created by:
  - [@jakub-szeszycki](https://github.com/jakub-szeszycki)
  - [@grzegorzkaz](https://github.com/grzegorzkaz)
  - [@kloslukasz](https://github.com/kloslukasz)
  - [@Leziaq](https://github.com/Leziaq)
  - [@MarcelWilnicki](https://github.com/MarcelWilnicki)