# A3 Iteration and Copy-Style Slicing

## Basic Information

Your name: Michelle Jiang 

Other students you worked with, including TAs:

If anyone was particularly helpful, please give them a shout-out here:


## References

Any references or resources used besides JavaDoc and course materials:

If you used generative AI, how did you use it? What role did it play in your learning?


## Questions to Answer

Copy vs Transfer Split (lightweight benchmark)
Each timing is an average over 500 ops.
Note: sub-100 ns timings are noisy; focus on trends.

n = 1000
  get(mid):          DynamicArray 402 ns/op, SLL 1196 ns/op
  add+remove(0):     DynamicArray 7359 ns/op, SLL 576 ns/op
  splitCopy(index):  DynamicArray 12524 ns/op, SLL 10127 ns/op
  splitTransfer(idx):DynamicArray 30894 ns/op, SLL 979815 ns/op

n = 5000
  get(mid):          DynamicArray 100 ns/op, SLL 5634 ns/op
  add+remove(0):     DynamicArray 13293 ns/op, SLL 139 ns/op
  splitCopy(index):  DynamicArray 11568 ns/op, SLL 27529 ns/op
  splitTransfer(idx):DynamicArray 89608 ns/op, SLL 27701611 ns/op

n = 20000

1. Which got slower faster as `N` increased: `get(mid)` or `add(0, x)` on `SLL`? Why?
get(mid) because it requires iterating through the SLL, which is O(n) time, while add(0, x) is O(1) time aka constant time. 

2. Compare `splitCopy` vs `splitTransfer` for `DynamicArray` and `SLL`: what dominates the runtime in each?
For DynamicArray: splitTransfer is higher runtime in general and also increases in runtime faster compared to splitCopy(), with O(n) time while splitCopy is O(1)
For SLL: splitTransfer is also higher runtime in general and increases in runtime faster. 

## Reflection

Please provide a brief reflection about your experience with this assignment. What was easiest? What was hardest? How did your understanding of iteration and cost models evolve?

I found the splitting to be the most difficult part, I found it quite difficult to understand the splitCopy vs splitTransfer and how to implement them. I found the other parts of the assignment in part 1 to be relatively easy in comparison. I've realized that my understanding of iteration improved a lot with the assignment as previously I would get a lot of things incorrect in the practice exam related to iteration but afterwards, I understand it better conceptually and in terms of implementation. 