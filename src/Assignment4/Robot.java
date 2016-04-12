package Assignment4;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.InputMismatchException;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class Robot {

    public static void readInstructions(String inputFileName,
            String outputFileName) {

        Scanner scan = null;
        PrintWriter writer = null;

        try {

            File inputFile = new File(inputFileName);

            File outputFile = new File(outputFileName);

            scan = new Scanner(inputFile);

            writer = new PrintWriter(outputFile);

            while (scan.hasNextLine()) {// while the input file has a next line

                String line = scan.nextLine();// splits the line

                Scanner split = new Scanner(line);

                try {

                    boolean isTerminated = false;

                    int gridRows = split.nextInt() - 1;// initial grid size y
                    int gridCols = split.nextInt() - 1;// initial grid size x

                    int robotY = split.nextInt();// initial robot y
                    int robotX = split.nextInt();// initial robot x

                    if (gridCols < 1 || gridRows < 1) {// checks if the robot is
                                                       // outside the grid
                                                       // initially, if so throw
                                                       // an exception
                        throw new InvalidRobotInstructionException();
                    }

                    while (split.hasNext()) {// while the line has a next
                                             // command

                        String direction = split.next();
                        int numOfMoves = split.nextInt();

                        if (direction.equalsIgnoreCase("E")) {
                            robotX += numOfMoves;

                        }
                        else if (direction.equalsIgnoreCase("W")) {
                            robotX -= numOfMoves;

                        }
                        else if (direction.equalsIgnoreCase("N")) {
                            robotY -= numOfMoves;

                        }
                        else if (direction.equalsIgnoreCase("S")) {
                            robotY += numOfMoves;
                        }
                        else {
                            throw new InvalidRobotInstructionException();
                        }

                        // checks if the robot is outside the grid
                        if (robotX > gridCols || robotX < 0|| robotY > gridRows || robotY < 0) {
                            isTerminated = true;
                        }
                    }

                    if (isTerminated) {
                        writer.println("terminated");
                    }
                    else {
                        writer.println(robotY + " " + robotX);
                    }

                }
                catch (InputMismatchException e) {
                    throw new InvalidRobotInstructionException();

                }
                catch (NoSuchElementException e) {
                    throw new InvalidRobotInstructionException();

                }
                finally {
                    split.close();
                }
            }

        }
        catch (FileNotFoundException e) {
            System.out.println("Input file not found.");
        }
        finally {
            if (writer != null) {
                writer.close();
            }
            if (scan != null) {
                scan.close();
            }

        }
    }

}
