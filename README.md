# Advent of Code 2021 Java Solutions

As you may know Advent of Code has started and this year I've decided to show my solutions for the puzzles in Java.

My solutions are in no way shape or form the best, fastes, or cleanest solutions, but I think it'll be fun to look back at this next year and see what has changed.

Since I will be using Java for all the puzzles I'll set down some ground rules and stuff I do before viewing the puzzle. 
- Create the .java file.
- Create Main method.
- Use the Scanner Library to use puzzle input in code.
- Store values read by Scanner in a list.
- Use basic generic for loop that goes over that list.
Having this stuff set up shaves of 30ish seconds of the time needed and is reusable for most of the puzzles.

I will also be walking you through my thought process, but please bare with me as my main focus is time and not fancy lambdas.

![](https://img.shields.io/badge/day%20📅-4-blue) ![](https://img.shields.io/badge/stars%20⭐-8-yellow)	![](https://img.shields.io/badge/days%20completed-4-red)
<table>
  <tr>
    <th>Puzzle No.</th>
    <th>Approx Time</th>
    <th>Difficulty(1-10)</th>
    <th>Description)</th>
  </tr>
  <tr>
    <td>1</td>
    <td>~5 mins</td>
    <td>1</td>
    <td>Basic for loop summation to check if the element n+1 is greater than element n. Then for part b, I just checked if n, n+1, n+2 > n+1, n+2, n+3. Then caught an IndexOutOfBoundsException to break the loop and print the result </td>
  </tr>
  <tr>
    <td>2</td>
    <td>~7 mins</td>
    <td>1</td>
    <td>Again a basic for loop summation but this time i used string manipulation to get the up, down, forward directions, and the value associated with each vector </td>
  </tr>
  <tr>
    <td>3</td>
    <td>~12 mins</td>
    <td>1.5</td>
    <td>The first part was pretty straightforward and was solved with 2 for loops. The second part was fine too but i just feel like there is a way smarter way to tackle it than using 3 for loops.  </td>
  </tr>
  <tr>
    <td>4</td>
    <td>~35 mins</td>
    <td>3</td>
    <td>This question was not particularly difficult but it was time consuming. I feel that using a 3 dimensional array was not the smartest way to do this especially since it took me 30 mins to silve this. Also you might see 6 nested for loops, but they are of fixed size. Technically this is O(nm) where n is the number of bingo balls and m is the number of sheets </td>
  </tr>
</table>
