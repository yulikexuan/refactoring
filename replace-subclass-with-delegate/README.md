# Replace Subclass with Delegate


## Resources

- [Replace Subclass with Delegate](https://memberservices.informit.com/my_account/webedition/9780135425664/html/replacesubclasswithdelegate.html)


---
## Motivation

### Inheritance Downsides
- #### Most Obviously, it's a Card that Can Only be Played Once
  - If having More Than One Reason To Vary Something, 
    - Devs Can Only Use Inheritance for a Single Axis of Variation
  - For Example, To Vary Behavior of People by Two Different Category:
    - ___Their Age Category___ & ___Their Income Level___
    - Devs can Either Have Subclasses for ___Young___ and ___Senior___ 
    - or for ___Well-Off___ and ___Poor___ 
    - We CANNOT Have Both
- #### Inheritance Introduces a Very Close Relationship Between Classes
  - Any Change Made to the Parent Can Easily Break Children 
    - so Devs Have To Be Very Careful & Understand 
      - ___How Children Derive From The Superclass___
    - This Problem is Made Worse when the Logic of the Two Classes 
      - Resides in Different Modules and Is Looked After By Different Teams

### Delegation Handles Both Of These Problems of Inheritance
- #### We can Delegate to Many Different Classes for Different Reasons
  - Delegation is a Regular Relationship Between Objects
    - so We can Have a Clear Interface to Work With 
      - which is Much Less Coupling Than Subclassing

### It's Common to Run Into The Problems with Subclassing 
  and Apply this [Replace Subclass with Delegate]()

> A Popular Principle: ___Favor Object Composition Over Class Inheritance"___
> (where composition is effectively the same as delegation)


---
## Mechanics

- ### If there are Many Callers for the Constructors 
  - Apply [Replace Constructor with Factory Function](https://memberservices.informit.com/my_account/webedition/9780135425664/html/replaceconstructorwithfactoryfunction.html)

- ### Create an Empty Class for the Delegate 
  - Its Constructor should Take Any Subclass-Specific Data, as well as, usually, 
    - a Back-Reference to the Superclass as an instance-field of the Delegate class

- ### ??? ___Add a Field to the Superclass to Hold the Delegate___ ???

- ### Modify the Creation of the Subclass so that it Initializes the Delegate Field 
  - with an Instance of the Delegate
  - This can be done in the factory function, or 
    - in the constructor if the constructor can reliably tell whether to create the correct delegate

- ### Choose a Subclass Method to Move to the Delegate Class

- ### Use [Move Function](https://memberservices.informit.com/my_account/webedition/9780135425664/html/movefunction.html) to Move It to The Delegate Class 
  - Don't Remove the Source's Delegating Code
  - If the method needs elements that should move to the delegate, move them
  - If it needs elements that should stay in the superclass
    - add a field to the delegate that refers to the superclass

- ### If the Source Method Has Callers Outside the Class
  - #### Move the Source's Delegating Code from the Subclass to the Superclass
    - guarding it with a Check for the Presence of the Delegate
      - If not, apply [Remove Dead Code](https://memberservices.informit.com/my_account/webedition/9780135425664/html/removedeadcode.html)
  - #### If there's More Than One Subclass Duplicating Code Within Them 
    - use [Extract Superclass](https://memberservices.informit.com/my_account/webedition/9780135425664/html/extractsuperclass.html) 
    - In this case, any delegating methods on the Source Superclass No Longer Need A Guard 
      - if the Default Behavior Is Moved To The Delegate Superclass

- ### Test

- ### Repeat Until All The Methods Of The Subclass Are Moved

- ### Find All Callers of the Subclasses' Constructor
  - #### Changing Them to Use the Superclass Constructor

- ### Test

- Use [Remove Dead Code](https://memberservices.informit.com/my_account/webedition/9780135425664/html/removedeadcode.html) on the Subclass