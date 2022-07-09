# Stack

Stack is a logical data structure which follows LIFO(Last In First Out) technique to manage
its data.

## Stack to use as data structure when data
* Need to be arranged in LIFO way.
* Need protection from corruption

## Stack to be avoided when
* Random data access is frequent operation.

## Common operations
* push()
* pop()
* peak()
* isEmpty()
* isFull() - Applicable only if Stack got realized by Array physical data structure.
* deleteStack()

## Implementation approach
### Array
pros:
* Easy to implement
cons:
* Size of stack will be fixed and increasing stack size will require high space and 
time complexity.
### LinkedList
pros:
* size can be variable
cons:
* Implementation will be of moderate complexity.
 