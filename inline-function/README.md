# Inline Function

## Resources

- [Inline Function](https://memberservices.informit.com/my_account/webedition/9780135425664/html/inlinefunction.html)


---
## Motivation

### A Func in which the body is as clear as the name

- #### Needless Indirection is Irritating


### A Group of Funcs that seem Badly Factored

- #### Inline them all into one big function 
- #### Re-Extract the functions the different way


### Code using Too Much Indirection 

- #### When it seems that Every Func does Simple Delegation to Another Func 
- #### and Getting Lost in All the Delegation
- #### Some of this INDIRECTION MAY BE Worthwhile, But Not All Of It
- #### By Inlining, Flush Out the Useful Ones and Eliminate the Rest

> flush out: to bring to light
> - To flush out something: is to cause it to leave a hiding place


## Mechanics

### Check that This Is Not a Polymorphic Method

- #### If this is a method is overridden by subclasses, DO NOT iInline

### Find all the callers of the function

### Replace each call with the function's body

### Test after each replacement

- #### The Entire Inlining doesn't have to be done all at once 
- #### If some parts of the inline are tricky, they can be done gradually as opportunity permits 

### Remove the Function Definition

### Always be Ready to Take Smaller Steps