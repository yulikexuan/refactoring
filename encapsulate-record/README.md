# Encapsulate Record

## Resources

- [Encapsulate Record](https://memberservices.informit.com/my_account/webedition/9780135425664/html/encapsulaterecord.html)


---
## Motivation

### Simple Record Structures Have Disadvantages

- #### Forces to Separate What is Stored in the Record from Calculated Values 

### Favor Objects Over Records For Mutable Data

- #### Hide What is Stored and Provide Methods for All Calculated Values
- #### The user of the object doesn't need to know or care 
  - which is stored and which is calculated 


---
## Mechanics

### Use Encapsulate Variable on the variable holding the record.

### Replace the content of the variable with a simple class that wraps the record

- #### Define an accessor inside this class that returns the raw record
- #### Modify the functions that encapsulate the variable to use this accessor
- #### Test

### Provide new functions that return the object rather than the raw record

### For each user of the record 

- #### Replace its use of a function that returns the record 
  - with a function that returns the object

- #### Use an accessor on the object to get at the field data 
  - creating that accessor if needed 
  - Test after each change 

> get at something: to learn or find out something
> - The truth is sometimes difficult to get at 

### For very Complex Record, such as One with a nested structure 

- #### Focus on Clients that Update the Data First
  - Then Consider Returning a Copy or Read-Only Proxy of the Data for Clients 
    - that only read the data
  - Concentrate on the updates 
    - Getting them visible and gathered in a single place
      - is the most important part of the encapsulation 

### Remove the Class's Raw Data Accessor

### Remove the easily Searchable Functions that Returned The Raw Record

### Test

### If the Fields of the Record are Themselves Structures 

- #### consider using Encapsulate Record and Encapsulate Collection recursively 