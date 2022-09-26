# Change Function Declaration

## Resources

- [Change Function Declaration](https://memberservices.informit.com/my_account/webedition/9780135425664/html/changefunctiondeclaration.html)


---
## Motivation

### Function Declarations are CONSTRUCTION JOINTS

- #### Functions Represent the primary way we break a Program down into Parts
- #### Function Declarations, the JOINTS, Represent How these Parts Fit Together, Effectively
- #### Any Construction much Depends on those JOINTS
- #### Good JOINTS Make Devs Add New Parts to the System Easily
- #### Bad JOINTS are a Constant Source of Difficulty
  - Making it harder to figure out what the software does and how to modify it
- #### JOINTS should be easy to Understand and Change


### Function Name


### Function Parameters


---
## Mechanics


### Simple Mechanics

> ___To Both Change The Name and Add A Parameter, Do These As Separate Steps___

- #### Removing a Parameter, Ensure it isn't Referenced in the Body of the Function
- #### Change the method declaration to the desired declaration
- #### Find and Update all References to the Old Method Declaration
- #### Test


### Migration Mechanics

- #### If Necessary, Refactor the Body of the Function 
  - to Make It Easy to do the following Extraction Step 
- #### Create a New Function (having new name) with the Old Body of the Old Func
- #### Test
- #### Replace the body of the Old Func with a New Func Call -> Inline Function
- #### Test
- #### Deprecate the Old Func and Using the new Func
  - Replace Old Func Reference one by one with the New Func Reference
  - Or, Wait for Callers to Change their Old Func Reference
- #### Test (One by One)
- #### Remove the old Func
- #### Replace the Name of the New Func with the Name of the Old Func, if desired

