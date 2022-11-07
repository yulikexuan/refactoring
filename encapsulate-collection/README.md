# Encapsulate Collection


## Resources

- [Encapsulate Collection](https://memberservices.informit.com/my_account/webedition/9780135425664/html/encapsulatecollection.html)


---
## Motivation

### Avoid that the Collection Field's Membership could be Altered 

- without the Intervene of the Enclosing class


---
## Mechanics

- ### Apply [Encapsulate Variable](https://memberservices.informit.com/my_account/webedition/9780135425664/html/encapsulatevariable.html)
  - if the reference to the collection isn't already encapsulated 

- ### Add functions to add and remove elements from the collection
  - If there is a setter for the collection, use [Remove Setting Method](https://memberservices.informit.com/my_account/webedition/9780135425664/html/removesettingmethod.html) if possible

- ### Run Static Checks

- ### Find all References to the Collection 
  - If anyone calls modifiers on the collection 
    - change them to use the new add/remove functions 
    - Test after each change

- ### Modify the getter for the collection to return a protected view on it 
  - using a read-only proxy or a copy 

- ### Test