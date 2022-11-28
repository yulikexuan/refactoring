# Replace Loop with Pipeline


## Resources

- [Replace Loop with Pipeline](https://memberservices.informit.com/my_account/webedition/9780135425664/html/replaceloopwithpipeline.html)
- [Refactoring with Loops and Collection Pipelines](https://martinfowler.com/articles/refactoring-pipelines.html)

---
## Motivation

### The [Collection Pipelines](https://martinfowler.com/articles/collection-pipeline/) is an Appealing Alternative

### Use [Collection Pipelines](https://martinfowler.com/articles/collection-pipeline/) to Iterate Over a Collection of Objects
> Collection Pipelines are a Programming Pattern (Stream in Java)
> - where you Organize Some Computation as a Sequence of Operations 
>   - which compose by taking a collection as output of one operation, 
>     and feeding it into the next
> - Common operations are filter, map, and reduce

### Logic Much Easier to Follow if it is Expressed as a Pipeline 
- Read from top to bottom to see how objects flow through the pipeline


---
## Mechanics

- ### Create a New Variable for the Loop's Collection
- ### Starting at the top, take each bit of behavior in the loop 
  - Replace the Behavior with a Collection Pipeline Operation 
    - in the derivation of the loop collection variable
  - Test after Each Change
- ### Once all Behavior is Removed from the Loop, Remove It
  - If it assigns to an accumulator, assign the pipeline result to the accumulator