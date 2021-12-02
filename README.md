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

![](https://img.shields.io/badge/day%20📅-2-blue) ![](https://img.shields.io/badge/stars%20⭐-4-yellow)	![](https://img.shields.io/badge/days%20completed-2-red)
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
</table>
