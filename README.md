# UCSD CSE 199 Winter 2021 - USACO Jan 2019 Bronze Level Solution
Bob's solution to Shell Game, Sleepy Cow Sorting and Guess the Animal
All of these challenges require some sort of problem-breakdown skills which I'm not sure how to deliver. However, problem description along with required tech skills are listed below.

### Shell Game
My solution was written in `Java`.

My approach is to assume the prize starts at one index, in between each swap, move the prize's location around if applicable, and check if the guessed position matches the actual position. There are only 3 index to check so it's not a big problem if we check them all, but if there were to more index I recommend something more efficient.

I believe understanding of Arrays, and linear search are required, along with basic File I/O operations.

### Sleepy Cow Sorting
My solution was written in `Java`.

Since only one cow is paying attention to the farmer among all `N` cows, if there is a cow in the wrong place at index `k`, we'll need `k` steps to move all other cows behind that cow. Therefore this problem breaks down to finding the farthermost unsorted pair of cows, which could be accomplished with a linear search.

#### Required Background
I believe understanding of Arrays, and linear search are required, along with basic File I/O operations.

### Guess the Animal
My solution was written in `Java` with the help of `HashMap` and `HashSet`.

This challenge asked for the maximum number of `YES` Bessie could answer before Elsie reaches her answer. Since each `YES` answer removes some animals from the feasible set, the maximum number Elsie could get is when 2 animals are only one characteristic off among all `N` characteristics, where Elsie would need to ask `N` questions and get `(N-1) YES` and `1 NO` to reach her conclusion.

After realizing this, the rest of the problem just became: for all pairs of animals in the given dataset, find the pair that has the most characteristics in common, return that number reduced by 1. 

While iterating through all pairs requires an `O(N^2)` runtime, within each pair we could simply use the `retainAll()` method from `Java`'s `HashSet` class (which I didn't realize when developing this solution in the first place).

#### Required Background
I believe solid understanding of Arrays, Maps, and Sets are required, along with basic File I/O operations.