package org.JMeshGenerator.Algorithm.Common;

import java.util.*;

public class Sudoku {
    private Map<Integer, int[][]> subPuzzleMap = new HashMap<>();
    private Map<Integer, int[]> rowMap = new HashMap<>();
    private Map<Integer, int[]> columnMap = new HashMap<>();

    public boolean solve(int[][] puzzle) {
        partition(puzzle); // 初始化行、列、子数独映射

        return solveRecursive(puzzle);
    }

    private boolean solveRecursive(int[][] puzzle) {
        for (int rowIndex = 0; rowIndex < 9; rowIndex++) {
            for (int colIndex = 0; colIndex < 9; colIndex++) {
                if (puzzle[rowIndex][colIndex] == 0) { // 找到一个空格
                    // 获取当前位置可用的数字列表
                    List<Integer> availableNums = getAvailableNumsForCell(rowIndex, colIndex);

                    for (Integer num : availableNums) {
                        puzzle[rowIndex][colIndex] = num; // 尝试填充数字
                        if (solveRecursive(puzzle)) {
                            return true; // 找到解决方案，递归结束
                        }
                        puzzle[rowIndex][colIndex] = 0; // 回溯
                    }

                    return false; // 没有找到有效数字，回溯
                }
            }
        }
        return true; // 所有空格都填满，数独解决
    }

    private List<Integer> getAvailableNumsForCell(int rowIndex, int colIndex) {
        List<Integer> rowAvailable = getAvailableNum(rowMap.get(rowIndex));
        List<Integer> colAvailable = getAvailableNum(columnMap.get(colIndex));
        List<Integer> subPuzzleAvailable = getAvailableNum(subPuzzleMap.get(getIndexOfSubPuzzle(rowIndex, colIndex)));

        return getAvailableNumInCommon(rowAvailable, colAvailable, subPuzzleAvailable);
    }

    private void partition(int[][] puzzle) {
        if (puzzle.length != 9 || puzzle[0].length != 9) {
            return;
        }

        // 存储每一行
        for (int i = 0; i < puzzle.length; i++) {
            rowMap.put(i, puzzle[i]);
        }

        // 存储每一列
        for (int j = 0; j < puzzle[0].length; j++) {
            int[] column = new int[9];
            for (int i = 0; i < puzzle.length; i++) {
                column[i] = puzzle[i][j];
            }
            columnMap.put(j, column);
        }

        // 分割并存储3x3的子数独
        for (int subPuzzleRowIndex = 0; subPuzzleRowIndex < 3; subPuzzleRowIndex++) {
            for (int subPuzzleColIndex = 0; subPuzzleColIndex < 3; subPuzzleColIndex++) {
                int[][] subPuzzle = new int[3][3];
                for (int x = 0; x < 3; x++) {
                    for (int y = 0; y < 3; y++) {
                        // 计算当前元素在原数独中的位置
                        int curRowIndex = subPuzzleRowIndex * 3 + x;
                        int curColIndex = subPuzzleColIndex * 3 + y;
                        subPuzzle[x][y] = puzzle[curRowIndex][curColIndex];
                    }
                }
                // 使用唯一的索引方式来标识每个子数独
                // 左上角为0，右下角为8
                int subPuzzleIndex = subPuzzleRowIndex * 3 + subPuzzleColIndex;
                subPuzzleMap.put(subPuzzleIndex, subPuzzle);
            }
        }
    }

    private static int[][] deepCopySudoku(int[][] original) {
        if (original == null) {
            return null;
        }

        int[][] copy = new int[original.length][original[0].length];
        for (int i = 0; i < original.length; i++) {
            System.arraycopy(original[i], 0, copy[i], 0, original[i].length);
        }

        return copy;
    }
    private int getIndexOfSubPuzzle(int rowIndex, int colIndex) {
        // 计算子数独的行号和列号
        int subPuzzleRow = rowIndex / 3;
        int subPuzzleCol = colIndex / 3;
        // 根据子数独的行号和列号计算序号
        return subPuzzleRow * 3 + subPuzzleCol;
    }

    private int getCountInCurPuzzle(int num, int[][] curStepPuzzle) {
        int res = 0;
        for (int[] row : curStepPuzzle) {
            for (int i : row) {
                if (i == num) {
                    res++;
                }
            }
        }
        return res;
    }

    private List<Integer> getAvailableNum(int[] curUnit) {
        Set<Integer> curSet = new HashSet<>();
        for (int num : curUnit) {
            curSet.add(num);
        }

        return getAvailableNum(curSet);
    }

    private List<Integer> getAvailableNum(int[][] curPuzzle) {
        Set<Integer> curSet = new HashSet<>();
        for (int[] row : curPuzzle) {
            for (int num : row) {
                curSet.add(num);
            }
        }

        return getAvailableNum(curSet);
    }

    private static List<Integer> getAvailableNum(Set<Integer> curSet) {
        List<Integer> res = new ArrayList<>();
        for (int i = 1; i <= 9; i++) {
            if (!curSet.contains(i)) {
                res.add(i);
            }
        }
        return res;
    }

    private List<Integer> getAvailableNumInCommon(List<Integer> rowAvailable, List<Integer> colAvailable, List<Integer> subPuzzleAvailable) {
        Set<Integer> commonSet = new HashSet<>(rowAvailable);
        commonSet.retainAll(colAvailable);
        commonSet.retainAll(subPuzzleAvailable);

        return new ArrayList<>(commonSet);
    }

    private boolean checkUnit(int[] curUnit) {
        Set<Integer> curSet = new HashSet<>();
        for (int num : curUnit) {
            if (num == 0) { // 如果存在0，直接返回false
                return false;
            }
            curSet.add(num);
        }
        return curSet.size() == 9; // 确保没有重复的数字，并且所有数字都被包含
    }

    private boolean checkSubPuzzle(int[][] subPuzzle) {
        Set<Integer> curSet = new HashSet<>();
        for (int[] row : subPuzzle) {
            for (int num : row) {
                if (num == 0) {
                    return false;
                }
                curSet.add(num);
            }
        }
        return curSet.size() == 9;
    }

}
