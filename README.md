# Operations into Deque-ing
## By Team Lenovo 3.0 (Roster: Ahnaf Hasan, Kevin Wang, Peter Cwalina)

The methods defined from the [Deque API](https://docs.oracle.com/javase/7/docs/api/java/util/Deque.html) page in QQKachoo are as follows.
- `size()` - returns length of the queue, needed for `isEmpty()`
- `addFirst()` - adds value to the front of the queue
- `addLast()` - adds value to the end of the queue
- `peekFirst()` - returns the value at the front of the queue
- `peekLast()` - returns the value at the end of the queue
- `removeFirst()` - removes the first element of the queue and returns it
- `removeLast()` - removes the last element of the queue and returns it
- `removeFirstOccurrence()` - removes the first occurrence of the value in the queue from the front. If not found, return `null`
- `removeLastOccurrence()` - removes the last of occurrence of the value in the queue from the front. If not found, return `null` 
- `Iterator()` - iterate through the queue
- `poll()` - safely removes the first element in the queue. If there are no elements remaining, return `null`
- `pollFirst()` - safely remove the first element in the queue. If there are no elements remaining, return `null`
- `offerFirst()` - safely add the value to the front of the queue. If it violates anything, return `false`, else, return `true`
- `offerLast()` - safely add the value to the end of the queue. If it violates anything, return `false`, else, return `true`
- `contains()` - iterate through the queue to check if the value is in the queue. If found, return `true`, else return `false`

_Note that the implementation of the methods may not reflect the order that they were placed in in the README_

_See [Projects](https://github.com/PGreatness/There-is-no-pathetic-card-in-my-Deque-Brown/projects) tab for to-do list and details_

A doubly linked node-based architecture was implemented because it allows easy trasversal between nodes, and saves both time and memory by having both a front an end modifiable in constant time.

The various elements explored in this repo stems from the Deque class available in the Java API. The methods are developed through a bottom-up approach where the most basic of the methods are added and revised by a team of three.

4 steps of maintaining runnability (To-do list):

1. Maintain runnability
2. Implement basic methods as listed above
3. Generic type Interface and class
4. Implement Iterator in Deque

Kevin Wang ([GitHub profile of Kevin Wang](https://github.com/kwang11))

Peter Cwalina ([GitHub profile of Peter Cwalina](https://github.com/PeterCwalina))

Ahnaf Hasan ([GitHub profile of Ahnaf Hasan](https://github.com/PGreatness)) 
