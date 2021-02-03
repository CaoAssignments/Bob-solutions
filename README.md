# UCSD CSE 199 Winter 2021 - USACO Jan 2019 Bronze Level Solution
Bob's solution to the challenge prompts (see below)

~All of these challenges require some sort of problem-breakdown skills which I'm not sure how to deliver. However, problem description along with required tech skills are listed below.~
Update 2/2: records are no longer maintained here. See CSE 199 Google Sheet for details and classification.

All solutions are writte in `Java`.

## Questions that I was _not_ able to figure out
USACO 2012 US Open, Problem 4: Unlocking Blocks
http://www.usaco.org/index.php?page=viewproblem2&cpid=133

## Week 3
### Marathon
After reading this problem, my first thought was to iterate through all steps Bessie has to get through, and find the largest distance increment.

I was able to figure this out so fast because one of my previous LeetCode challenge followed similar ideas (calculate the total cost, figure out each step's reduction, and return the step with the maximum reduction). The problem setting of Manhattan Distance as well as only skipping one iteration of a checkpoint if the checkpoint is reached multiple times also further reduced the complexity of my thought process.

One key point other than technical implementation I'd like to highlight is the thought process of replacing calculating all combinations of increments with calculating the total cost first followed by trying all kinds of reductions.

### Crosswords
This challenge could be solved by using a nested loop to iterate through the matrix and search for the corresponding pattern.

Technical skills required: arrays, File I/O, nested for loop

### Cow Jog 
Based on the problem description, I realized that after some long but **finite** time, all cows will reach their terminal velocity. Therefore if the first cow runs at velocity 2 initially, then all cows after it cannot run faster than 2 and thus form a group. Yet if another cow behind runs at velocity 1 initially, that cow and every cow after it will form another group since they are never able to catch up with the velocity 2 group (also note that the track is infinitely-long and single-lane, so no loops are possible).

So the problem breaks down to finding these subgroups within cows, which could be finished within a linear search.

Technical skills required: arrays, File I/O

### Learning by Example

## Week 2
### Shell Game
My approach is to assume the prize starts at one index, in between each swap, move the prize's location around if applicable, and check if the guessed position matches the actual position. There are only 3 index to check so it's not a big problem if we check them all, but if there were to more index I recommend something more efficient.

I believe understanding of Arrays, and linear search are required, along with basic File I/O operations.

### Sleepy Cow Sorting
Since only one cow is paying attention to the farmer among all `N` cows, if there is a cow in the wrong place at index `k`, we'll need `k` steps to move all other cows behind that cow. Therefore this problem breaks down to finding the farthermost unsorted pair of cows, which could be accomplished with a linear search.

#### Required Background
I believe understanding of Arrays, and linear search are required, along with basic File I/O operations.

### Guess the Animal
This challenge asked for the maximum number of `YES` Bessie could answer before Elsie reaches her answer. Since each `YES` answer removes some animals from the feasible set, the maximum number Elsie could get is when 2 animals are only one characteristic off among all `N` characteristics, where Elsie would need to ask `N` questions and get `(N-1) YES` and `1 NO` to reach her conclusion.

After realizing this, the rest of the problem just became: for all pairs of animals in the given dataset, find the pair that has the most characteristics in common, return that number reduced by 1. 

While iterating through all pairs requires an `O(N^2)` runtime, within each pair we could simply use the `retainAll()` method from `Java`'s `HashSet` class (which I didn't realize when developing this solution in the first place).

#### Required Background
I believe solid understanding of Arrays, Maps, and Sets are required, along with basic File I/O operations.
