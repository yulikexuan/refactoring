# Slide Statements


## Resources

- [Slide Statements](https://memberservices.informit.com/my_account/webedition/9780135425664/html/slidestatements.html)


---
## Motivation

### Code is Easier to Understand when 
- #### Things that are Related to Each Other Appear Together
- #### If Several Lines of Code Access the Same Data Structure, it's best for them 
  - to Be Together rather than Intermingled with (夾雜著) Code Accessing 
    other Data Structures

### When Declaring and Using Variables
- #### Declare the Variable just before it is First Used

### Preparing for Applying [Extract Function](https://memberservices.informit.com/my_account/webedition/9780135425664/html/extractfunction.html)
- #### Putting Related Code into a Clearly Separated Function is a Better Separation 
  - than just Moving a Set of Lines Together
  - Do the Extract Function only when the Code is Together in the First Place


---
## Mechanics

- ### Identify the Target Position to Move the Fragment To
  - #### Examine Statements Between Source and Target 
    - to See if there is Interference for the Candidate Fragment
  - #### Abandon Action if there is any Interference
    - A fragment cannot slide backwards earlier than any element it references is declared
    - A fragment cannot slide forwards beyond any element that references it
    - A fragment cannot slide over any statement that modifies an element it references
    - A fragment that modifies an element cannot slide over any other element that references the modified element

- ### Cut the Fragment from the Source and Paste into the Target Position

- ### Test
  - #### If the Test Fails, try Breaking Down the Slide into Smaller Steps
    - Try to Slide Over Less code
    - Try to Reduce the Amount of Code in the Fragment you're Moving