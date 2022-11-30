# Change Reference to Value


## Resources

- [Change Reference to Value](https://memberservices.informit.com/my_account/webedition/9780135425664/html/changereferencetovalue.html)


### Inverse of [Change Value to Reference](https://memberservices.informit.com/my_account/webedition/9780135425664/html/changevaluetoreference.html)


---
## Motivation

### Treat the Inner Object as a Reference or as a Value
- when Nest an Object, or Data Structure, within Another Object
- The big Difference is How Handling the Updates of the Inner Object's Properties

### If Treating the Inner Object As a Reference
- Update the Inner Object's and still Keeping the Same Inner Object

### If Treating the Inner Object As a Value
- Replace the Entire Inner Object with a New One HHaving The Desired Property

### To Treat A Field as a Value 
- [Value Object](https://martinfowler.com/bliki/ValueObject.html) is Immutable
- Changing the Class of The Inner Object to Make It a [Value Object](https://martinfowler.com/bliki/ValueObject.html)
- In general, Immutable Data Structures are Easier to Deal With

### Immutable Data Value can be PASSED ON OUT TO Other Parts of the App 
- without Worrying that it might Change without the Enclosing Object being Aware of The Change
- Devs can Replicate Values around the App and Not Worry About Maintaining Memory Links

### [Value Object](https://martinfowler.com/bliki/ValueObject.html) are Especially Useful in Distributed & Concurrent Systems

### Do not Use [Value Object](https://martinfowler.com/bliki/ValueObject.html) when Sharing an Object between several objects 
- so that Any Change to the Shared Object is Visible to All Its Collaborators


---
## Mechanics

- ### Check that the Candidate Class is Immutable or Can Become Immutable

- ### For each setter, apply [Remove Setting Method](https://memberservices.informit.com/my_account/webedition/9780135425664/html/removesettingmethod.html)

- ### Provide a Value-Based Equality Method that uses the Fields of the Value Object