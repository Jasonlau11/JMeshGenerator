package org.JMeshGenerator;

import org.JMeshGenerator.Algorithm.Common.Sudoku;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        int[][] puzzle = new int[9][9];
        int[] row0 = new int[]{0,1,0,0,3,0,0,0,0};
        int[] row1 = new int[]{0,0,8,0,0,6,0,0,9};
        int[] row2 = new int[]{6,0,0,0,9,0,0,1,0};
        int[] row3 = new int[]{0,0,4,0,0,0,0,0,0};
        int[] row4 = new int[]{1,0,2,8,0,0,0,0,0};
        int[] row5 = new int[]{0,7,5,4,0,3,0,0,0};
        int[] row6 = new int[]{0,5,1,0,0,0,4,7,0};
        int[] row7 = new int[]{0,9,0,0,0,1,0,5,0};
        int[] row8 = new int[]{3,0,0,5,0,4,2,0,0};
        puzzle[0] = row0;
        puzzle[1] = row1;
        puzzle[2] = row2;
        puzzle[3] = row3;
        puzzle[4] = row4;
        puzzle[5] = row5;
        puzzle[6] = row6;
        puzzle[7] = row7;
        puzzle[8] = row8;

        Sudoku solver = new Sudoku();
        System.out.println(Arrays.deepToString(solver.solve(puzzle)));;
    }
}