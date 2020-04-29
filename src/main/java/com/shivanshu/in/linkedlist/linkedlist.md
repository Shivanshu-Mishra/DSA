# LinkedList

## What is a LinkedList
Linked List is a data structure where each element is a separate object and each object hold data and reference to other
 object in list. Linked list is flexible is size.
 
 ## LinkedList vs Array
* In linkedList each element is a separate object whereas in array each cell is an entity in Array object.
* LinkedList has variable size and it can be increase/decrease during runtime. Array has fixed size and it declared 
  during initialization.
* Random access is possible in Array but for LinkedList we have to traverse through node to reach desired position.

## Components of LinkedList

* Node - Contain data and reference to next node.
* Head - Reference to the first node in the list.
* Tail - Reference to the last node in the list.

## Types of LinkedList

* Single LinkedList - Each node in list contain data and reference to next node. No node element contain reference to 
  previous node. Last node reference to null.
*  Circular LinkedList - Same as Single LinkedList with only difference in last node. Instead of Last node referencing 
   to null it will reference to first node.
* Double LinkedList - Each node contain reference to previous and next node beside that there will be a data item in 
  each node have data item. Last node next reference will be null.
* Circular Double Linked List - Same as Double Linked list with only difference in first and last node.
  First node refers to last node as previous node whereas last node refers to first node as next node.
  
## Common operations of LinkedList
* Creation of LinkedList
* Insertion of LinkedList
* Traversal of LinkedList
* Searching of LinkedList
* Deletion of a node in LinkedList
* Deletion of a LinkedList    
