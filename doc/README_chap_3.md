# [Chapter 3 - Bad Smells in Code](https://memberservices.informit.com/my_account/webedition/9780135425664/html/smells.html)

> If it stinks, change it

---
## Mysterious Name


---
## Duplicated Code


---
## Long Function

### WRITE a function instead whenever feeling the need to comment something

### Conditionals and loops also give signs for extractions


---
## Long Parameter List

### Classes are a great way to reduce parameter list sizes


---
## Global Data


---
## Mutable Data

### Changes to data can often lead to unexpected consequences and tricky bugs


---
## Divergent Change

### Divergent change occurs when one module is often changed in different ways for different reasons

### Single-Responsibility Principle - There should never be more than one reason for a class to change

### Context Boundaries are usually Unclear in the Early Days of a program

- Context Boundaries Continue to shift as a software system's capabilities change


---
## Shotgun Surgery

### Every time Making A Change, having to Make A Lot Of Little Edits to A Lot Of Different Classes

- When the changes are all over the place
    - they are hard to find
    - it’s easy to miss an important change


---
## Feature Envy

### When a Function in One Module

- Spends More Time Communicating With Functions or Data Inside Another Module
  than it Does Within Its Own Module

> Put Things Together that Change Together


---
## Data Clumps

### Bunches of Data that Hang Around Together really ought to Find A Home Together

- The first step is to look for where the clumps appear as fields
    - Use Extract Class on the fields to turn the clumps into an object
    - Creating a class here, not a simple record structure
- Then turn your attention to method signatures using
    - Introduce Parameter Object
    - PreserveWhole Object
    - to slim them down


---
## Primitive Obsession


---
## Repeated Switches

### The Same Conditional Switching Logic

- Either in a switch/case statement or in a cascade of if/else statements
    - pops up in different places
- Whenever you add a clause, you have to find all the switches and update them
- Polymorphism provides an elegant weapon for a more civilized codebase


---
## Loops

### Replace Loop with Pipeline


---
## Lazy Element

### A structure that is not needed


---
## Speculative Generality

> speculative : /ˈspekjələtɪv/
> based on guessing or on opinions that have been formed without knowing all the facts
>
> generality /ˌdʒenəˈræləti/ the fact of being general rather than detailed or exact

### When people say "Oh, I think we'll need the ability to do this kind of thing some day"

- thus add all sorts of hooks and special cases to handle things that aren't required


---
## Temporary Field

### A class in which a field is set only in certain circumstances which is difficult to understand

### Devs expect an object to need all of its fields

### Trying to understand why a field is there when it doesn't seem to be used can Drive Devs Nuts

> nuts: crazy

---
## Message Chains

- When a client asks one object for another object
    - which the client then asks for yet another object
        - which the client then asks for yet another another object
            - and so on
- the client is coupled to the structure of the navigation
- Any change to the intermediate relationships causes the client to have to change


---
## Middle Man

### More than Half The Methods of a class are Delegating To Other Class

- After a while, it is time to use Remove Middle Man
    - talk to the object that really knows what’s going on


---
## Insider Trading

### Inheritance can often lead to collusion

- Subclasses are always going to know more about their parents than their parents
  would like them to know


---
## Large Class

### A class is doing too much if it has too many fields

### When a class has too many fields, duplicated code cannot be far behind

### Sometimes a class does not use all of its fields all the time

### A class with too much code is a prime breeding ground for duplicated code, chaos, and death


---
## Alternative Classes with Different Interfaces

- Wants to allow one class to swap in for another in times of need but
    - this class has different interface from another class


---
## Data Class

### Classes that have fields, getting and setting methods for the fields, and nothing else

### Data Classes are often a sign of behavior in the wrong place

### Moving its behaviour from the client into the data class itself


---
## Refused Bequest

> Bequest: money or property that you ask to be given to a particular person when you die

### Subclasses get to inherit the methods and data which they don't really want or need

### Means the hierarchy is wrong


--- 
## Comments

### Comments are sweet smells

### Comments lead us to bad code

> When you feel the need to write a comment, first try to refactor the code
> so that any comment becomes superfluous
> - superfluous: unnecessary or more than you need or want


### A good time to use a comment

- When you don't know what to do
- Comments can indicate areas in which you aren't sure
- A comment can also explain why you did something
- This kind of information helps future modifiers, especially forgetful ones 