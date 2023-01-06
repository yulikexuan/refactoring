# Replace Superclass with Delegate


## Resources

- [Replace Superclass with Delegate](https://memberservices.informit.com/my_account/webedition/9780135425664/html/replacesuperclasswithdelegate.html)


---
## Motivation

### Inheritance & Subclassing can be Done in a Way that 
  - #### Leads to Confusion & Complication

### An Example Mis-Inheritance

  ``` 
  class List {...}
  class Stack extends List {...}
  ```
  - All the Operations of the List were Present On the Interface of the Stack 
    - Although Most of them were Not Applicable to a Stack 
    - A better approach is to Make The List Into A Field Of The Stack 
      - delegate the necessary operations to it

### If Funcs of the Superclass DO NOT Make Sense on the Subclass
  - ### This is a Sign that we Should NOT be Using Inheritance

### Every Instance of the Subclass Should Also be an Instance of the Superclass 
- ### and a Valid Object in all Cases where Using the Superclass
- For Example, A ``` Car ``` Should NOT Be an Instance of ``` CarModel ```
  - even the ``` Car ``` class Inherited From ``` CarModel ``` class 

### Confusion and Errors Mentioned Above Can Be Easily Avoided 
- #### by Replacing Inheritance With Delegation to a Separate Object
- #### Using Delegation Makes It Clear that it is a Separate Thing

### Subclass-Superclass is Highly Coupled
- #### The Subclass is Easily Broken by Changes in the Superclass

### The Advice is to (Mostly) Use Inheritance First
- #### and Apply [Replace Superclass with Delegate]() when (and if) It Becomes a Problem


---
## Mechanics

- ### Create a Field in the Subclass that Refers to the Superclass Object
  - #### this delegate reference to a new instance

- ### For Each Element of the Superclass
  - Create a Forwarding Func in the Subclass that Forwards to the Delegate Reference
  - Test after Forwarding Each Consistent Group

- ### When All Superclass Elements Have Been Overridden with Forwarders
  - Remove the Inheritance Link

