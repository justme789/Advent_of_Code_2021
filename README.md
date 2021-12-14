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

![](https://img.shields.io/badge/day%20📅-14-blue) ![](https://img.shields.io/badge/stars%20⭐-24-yellow)	![](https://img.shields.io/badge/days%20completed-12-red)
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
    <tr>
    <td>5</td>
    <td>~15 mins</td>
    <td>1</td>
    <td>This puzzle was very straight forward and quite refreshisng. In both parts a and b i compared both the x and y values of both points to determine a starting point from which i was either going to incrmently or decrementaly cover the values that the line spans. </td>
  </tr>
  <tr>
    <td>6</td>
    <td>~60 mins</td>
    <td>4</td>
    <td>This puzzle was mean and too simple it was kinda pretty. For part a i used a fairly simple for+while loop combo and that did the trick. Then part b shows up and im like "okay i will just change the days value from 80 to 256, that'll do the trick". Just to get stuck at day 210. Now given the way i solved part a was using a for loop i kept trying to make it smarter (maybe not covering the whole dataset at once). But nothing worked and ofcourse nothing shouldve worked given the size of the list at day 210. I kept playing around with different techniques and stuff then it hit me: just do it the same way you do it in your head no containers, nothing, just arithmetic and that did the trick.</td>
  </tr>
  <tr>
    <td>7</td>
    <td>~30 mins</td>
    <td>1</td>
    <td>I just assigned the max value to 2000 and looped over every number to find the best fuel cost </td>
  </tr>
  <tr>
    <td>8</td>
    <td>~75 mins</td>
    <td>3</td>
    <td>I couldnt fully understand the question at first but once it made sense it turned out to be quite simple. I looked for patterns on number, so for example if a number contains 4 it has to be a 9, if a number contains 1 and 7 it can be a 0 or three but zero is 6 values long while 3 is 5 values long. Once i figured out the patterns for every number the next steps were comparing, decoding, and adding </td>
  </tr>
</table>
