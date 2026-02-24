# CSC 210 Data Structures
## Assignment 3 Checklist

Listed below are various aspects of the assignment.  When you turn in
your work, please indicate the status of each item

- YES: indicates that the item is fully complete
- NO: indicates that the item is not attempted
- PART: indicates that the item is attempted but not fully complete

## Grade-ability Check
Please confirm the following minimum criteria are met:

___Y__ Program compiles without errors 

___Y__ All required files included with submission (including basic readme info and completed checklist file) 

____Y_ README.md contains answers to any questions and your reflection on the assignment 

**Assignments that do not meet the above criteria cannot be graded**

## Coding Points:

___Y__ 1 pt: `SLL<T>` implements `Iterable<T>` and provides `iterator()`

__Y___ 1 pt: `DynamicArray<T>` implements `Iterable<T>` and provides `iterator()`

__Y___ 2 pt: `SLL` iterator is correct (node-walking, correct order, does not modify structure)

___Y__ 2 pt: `DynamicArray` iterator is correct (index-walking, correct order, does not modify structure)

___Y__ 1 pt: Iterator contract followed (`next()` throws `NoSuchElementException`; `iterator()` returns a fresh iterator starting at the beginning)

___Y__ 1 pt: `splitCopy(int index)` implemented for `SLL` (allocates new nodes; original unchanged)

___Y__ 1 pt: `splitCopy(int index)` implemented for `DynamicArray` (allocates new backing array; original unchanged)

___Y__ 1 pt: `splitTransfer(int index)` implemented for `SLL` (detaches/relinks existing nodes; original mutated to prefix)

___Y__ 1 pt: `splitTransfer(int index)` implemented for `DynamicArray` (moves references; original mutated to prefix)

____Y_ 1 pts: Program throws appropriate exceptions

___Y__ 1 pts: Benchmarking write-up included in README (brief observations comparing copy vs transfer and array vs linked list, based on `Timer.java` output)


## Code Hygiene (4 pts):

__Y__ 1 pt: No copy/paste near-duplicate code blocks for the same behavior (reusing your code is better for everyone!)

___Y__ 1 pt: Common logic is factored into helpers 

__Y___ 1 pt: Methods are short enough to read (no 100-line monster methods unless justified)

__Y___ 1 pt: Names communicate intent (especially for helper methods)


## General Items (6 pts):

__Y___ 1 pt: Student-written code compiles without warnings that indicate correctness problems

___Y__ 2 pts: Student-provided code runs and executes without unexpected crashing

__Y___ 2 pt: Javadoc builds without errors/warnings

__Y___ 1 pt: Indentation and other style norms are followed
