# Introduce Parameter Object

## Resources

- [Introduce Parameter Object](https://memberservices.informit.com/my_account/webedition/9780135425664/html/introduceparameterobject.html)


---
## Motivation


### Data Clump

- #### Groups of Data Items that Regularly Travel Together 
  - Appearing in Function after Function


### Grouping Data into a Structure is Valuable

- #### It Makes Explicit the Relationship Between the Data Items
- #### It Reduces the Size Of Parameter Lists
- #### It Helps Consistency 


### Parameter Object Enables Deeper Changes

- #### Will have the Chance to Reorient the Behaviour of the Program
  - Create Functions that Capture the Common Behavior over this Data 
    - Introduce a class that combines the data structure with these functions
- #### It can Change the Conceptual Picture of the code
- #### It can greatly Simplify the Understanding of the Domain


---
## Mechanics

- ### Create New ___Immutable Class___ for Grouping Parameter Data

- ### Test 

- ### Adjust Each Caller to Pass in the Correct Instance of the New Structure
  - #### Test After Each One

- ### For Each Element of the New Structure, Replace the Use of the Original Parameter 

- ### Test