import java.util.*;
import java.io.*;
public class Maze{

        private char[][]maze;
        private boolean animate;
        int rows;
        int columns;
        int pathLength = 0;
        int mazeSolved = 0;

        /*Constructor loads a maze text file, and sets animate to false by default.
          When the file is not found then:
             throw a FileNotFoundException

          You may assume the file contains a rectangular ascii maze, made with the following 4 characters:
          '#' - Walls - locations that cannot be moved onto
          ' ' - Empty Space - locations that can be moved onto
          'E' - the location of the goal (exactly 1 per file)
          'S' - the location of the start(exactly 1 per file)

          You may also assume the maze has a border of '#' around the edges.
          So you don't have to check for out of bounds!
        */
        public Maze(String filename) throws FileNotFoundException{
          File text = new File(filename);
          pathLength = 0;
          // scan once to get # rows and columns.
          Scanner inf = new Scanner(text);
          rows = 0;
          columns = 0;

          while(inf.hasNextLine()){
              rows += 1;
              String line = inf.nextLine();
              columns = line.length();
              //System.out.println(line);//hopefully you can do other things with the line
          }
          //System.out.println("Number of rows is: " + rows + " and number of columns is: " + columns);


          maze = new char[rows][columns];

          int rownum = 0;
          inf = new Scanner(text);
          while(inf.hasNextLine()){
              String line = inf.nextLine();
              for (int i = 0; i < line.length(); i++) {
                maze[rownum][i] = line.charAt(i);
              }
              rownum += 1;
          }


        } // closes Maze class

        private void wait(int millis){
             try {
                 Thread.sleep(millis);
             }
             catch (InterruptedException e) {
             }
         }

        public void setAnimate(boolean b){
            animate = b;
        }

        public static void clearTerminal(){
            //erase terminal
            System.out.println("\033[2J");
        }
        public static void gotoTop(){
          //go to top left of screen
          System.out.println("\033[1;1H");
        }

        /*Return the string that represents the maze.
         It should look like the text file with some characters replaced.
        */
        public String toString(){
          String s = "";
          for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
              s += maze[i][j];
            }
            s += "\n";
            }
            return s;
        }

        /*Wrapper Solve Function returns the helper function
          Note the helper function has the same name, but different parameters.
          Since the constructor exits when the file is not found or is missing an E or S, we can assume it exists.
        */
        public int solve(){
                int startX = 0;
                int startY = 0;
                pathLength = 0;
                mazeSolved = 0;

                //only clear the terminal if you are running animation
                if(animate){
                  clearTerminal();
                }
                for (int i = 0; i < rows; i++) {
                  for (int j = 0; j < columns; j++) {
                    if(maze[i][j] == 'S') {
                      startX = i;
                      startY = j;
                    }
                  }
                }
                return solve(startX, startY);
                //start solving at the location of the s.
                //return solve(???,???);
        }

        /*
          Recursive Solve function:

          A solved maze has a path marked with '@' from S to E.

          Returns the number of @ symbols from S to E when the maze is solved,
          Returns -1 when the maze has no solution.

          Postcondition:
            The 'S' is replaced with '@'
            The 'E' remain the same
            All visited spots that were not part of the solution are changed to '.'
            All visited spots that are part of the solution are changed to '@'
        */
        private int solve(int x, int y){ //you can add more parameters since this is private
            //automatic animation! You are welcome.
            if (mazeSolved == 1) return pathLength;
            if(animate){
                gotoTop();
                System.out.println(this);
                wait(5);
            }

            if (maze[x][y] == 'E') {
              // count number of @
              pathLength = 0;
              for (int i = 0; i < rows; i++) {
                for (int j = 0; j < columns; j++) {
                  if(maze[i][j] == '@') {
                    pathLength += 1;
                  }
                }
              }
              //System.out.println("Answer was found!! -> " + pathLength);
              mazeSolved = 1;
            }

            if (x >= 0 && x < rows && y >= 0 && y < columns && (maze[x][y] == ' ' || maze[x][y] == 'S')) {

              maze[x][y] = '@';
              if (solve(x + 1, y) == 1) return 1;
              if (solve(x, y + 1) == 1) return 1;
              if (solve(x-1, y) == 1) return 1;
              if (solve(x, y-1) == 1) return 1;

              maze[x][y] = '.';
              if (mazeSolved == 1) {
                return pathLength;
              } else {
              return 0;
              }
            }
            return -1;

            /*  OlD CODE
            if(maze[x + 1][y] == 'E' || maze[x - 1][y] == 'E' || maze[x][y + 1] == 'E' || maze[x][y - 1] == 'E') {
              maze[x][y] = '@';
              return 1;
            }
            	maze[x][y] = '@';
            	if (maze[x + 1][y] == ' ') {
                solve(x + 1, y);
                return 0;
            	}
            	else if (maze[x - 1][y] == ' ') {
                solve(x - 1, y);
                return 0;
            	}
            	else if (maze[x][y + 1] == ' ') {
                solve(x, y + 1);
                return 0;
            	}
            	else if (maze[x][y - 1] == ' ') {
                solve(x, y - 1);
                return 0;
            	}
            	else {
            		maze[x][y] = '.';
                for (int i = 0; i < rows; i++) {
                  for (int j = 0; j < columns; j++) {
                    if(maze[i][j] == '@') maze[i][j] = ' ';
                  }
                }
                solve(1, 1);
            		return 0;
            	}
              */
            //COMPLETE SOLVE
        }
      }
