# Hide Delegate


## Resources

- [Hide Delegate](https://memberservices.informit.com/my_account/webedition/9780135425664/html/hidedelegate.html)


---
## Motivation

### Encapsulation means Modules should Know Less about other Parts 
- when things change, fewer modules need to be told about the change
- which makes the change easier to make

### If having some client code that calls a method defined on an object 
- which is a field of a server object 
- the client needs to know about this delegate obj 
- If the delegate changes its interface 
  - changes propagate to all the clients of the server that use the delegate obj
- by placing a simple delegating method on the server that hides the delegate obj
  - the dependency of the delegate obj can be removed


---
## Mechanics

- ### For each method on the delegate
  - create a simple delegating method on the server

- ### Adjust the client to call the server

- ### Test after each change

- ### If no client needs to access the delegate anymore
  - remove the server's accessor for the delegate