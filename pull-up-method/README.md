# Pull Up Method


### [Pull Up Method](https://memberservices.informit.com/my_account/webedition/9780135425664/html/pullupmethod.html)


---

## Motivation

### Eliminating Duplicate Code is Important

### Two Methods in Different Classes that Can Be Parameterized In Such a Way 
- #### that they End Up as Essentially the Same Method
- #### Apply [Parameterize Function](https://memberservices.informit.com/my_account/webedition/9780135425664/html/parameterizefunction.html) Separately 
  - #### and then Pull Up Method

### The Method Body Refers to Features that are On The Subclass 
- #### but NOT On The Superclass
- #### use [Pull Up Field](https://memberservices.informit.com/my_account/webedition/9780135425664/html/pullupfield.html) 
  - and then Pull Up Method 

### Having Two Methods with a Similar Overall Flow 
- #### but Differing in Details
- #### Consider [Form Template Method](https://refactoring.com/catalog/formTemplateMethod.html)


--- 
## Mechanics

- ### Inspect Methods to Ensure they are Identical
  - If they Do The Same Thing, But Are Not Identical
    - Refactor Them Until They Have Identical Bodies

- ### Check that All Method Calls and Field References Inside the Method Body 
  - refer to Features that Can Be Called From the Superclass

- ### If the Methods Have Different Signatures
  - use [Change Function Declaration](https://memberservices.informit.com/my_account/webedition/9780135425664/html/changefunctiondeclaration.html) to get them to the one Desired on the Superclass

- ### Create a New Method in the Superclass
  - Copy the body of one of the methods over to it

- ### Test

- ### Delete One Subclass Method

- ### Test

- ### Keep Deleting Subclass Methods Until They Are All Gone






