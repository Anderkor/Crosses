package com.company;

import java.util.Random;
import java.util.Scanner;

public class Main {
    private static Scanner in = new Scanner(System.in);
    private static Random random = new Random();

    public static int check(int board[][], int score) {
        int winX = 0;
        int winO = 0;
        row:
        for (int row = 0; row < board.length; row++) {
            for (int column = 0; column < board[row].length; column++) {
                if (board[row][column] == 1) {
                    winX++;
                } else {
                    winX = 0;
                }
                if (winX >= score) return 1;
                if (board[row][column] == 2) {
                    winO++;
                } else {
                    winO = 0;
                }
                if (winO >= score) return 2;
            }
            winX = 0;
            winO = 0;
        }
        column:
        for (int column = 0; column < board[0].length; column++) {
            for (int row = 0; row < board.length; row++) {
                if (board[row][column] == 1) {
                    winX++;
                } else {
                    winX = 0;
                }
                if (winX >= score) return 1;
                if (board[row][column] == 2) {
                    winO++;
                } else {
                    winO = 0;
                }
                if (winO >= score) return 2;
            }
            winX = 0;
            winO = 0;
        }
        diagonal:
        for (int column = board[0].length - 1; column >= 0; column--) {
            for (int row = 0; row < board.length; row++) {
                if ((row >= 0) && ((column + row) >= 0) && (row < board.length) && ((column + row) < board.length)) {
                    if (board[row][column + row] == 1) {
                        winX++;
                    } else {
                        winX = 0;
                    }
                    if (winX >= score) return 1;

                    if (board[row][column + row] == 2) {
                        winO++;
                    } else {
                        winO = 0;
                    }
                    if (winO >= score) return 2;
                }
            }
            winX = 0;
            winO = 0;
            for (int row = board.length; row >= 0; row--) {
                if ((row >= 0) && ((column - row) >= 0) && (row < board.length) && ((column - row) < board.length)) {
                    if (board[row][column - row] == 1) {
                        winX++;
                    } else {
                        winX = 0;
                    }
                    if (winX >= score) return 1;
                    if (board[row][column - row] == 2) {
                        winO++;
                    } else {
                        winO = 0;
                    }
                    if (winO >= score) return 2;
                }
            }
            winX = 0;
            winO = 0;
            for (int row = 0; row < board.length; row++) {
                if ((row >= 0) && ((column - row) >= 0) && (row < board.length) && ((column - row) < board.length)) {
                    if (board[row][column - row] == 1) {
                        winX++;
                    } else {
                        winX = 0;
                    }
                    if (winX >= score) return 1;
                    if (board[row][column - row] == 2) {
                        winO++;
                    } else {
                        winO = 0;
                    }
                    if (winO >= score) return 2;
                }
            }
            winX = 0;
            winO = 0;
            for (int row = board.length; row >= 0; row--) {
                if ((row >= 0) && ((column + row) >= 0) && (row < board.length) && ((column + row) < board.length)) {
                    if (board[row][column + row] == 1) {
                        winX++;
                    } else {
                        winX = 0;
                    }
                    if (winX >= score) return 1;
                    if (board[row][column + row] == 2) {
                        winO++;
                    } else {
                        winO = 0;
                    }
                    if (winO >= score) return 2;
                }
            }
            winX = 0;
            winO = 0;
        }
        return 0;
    }

    public static void draw(int board[][]) {
        System.out.print("  ");
        for (int size = 0; size < board.length; size++) {
            System.out.print((size + 1) + " ");
        }
        System.out.println();
        String symbol = " ";
        for (int row = 0; row < board.length; row++) {
            System.out.print((row + 1) + "|");
            for (int column = 0; column < board[row].length; column++) {
                if (board[row][column] == 0) symbol = " ";
                if (board[row][column] == 1) symbol = "X";
                if (board[row][column] == 2) symbol = "O";
                System.out.print(symbol + "|");
            }
            System.out.println();
        }
    }


    public static void alternative(int board[][], int score) {
        int winO = 0;
        row:
        for (int row = 0; row < board.length; row++) {
            for (int column = 0; column < board[row].length; column++) {
                if ((board[row][column] == 0) || (board[row][column] == 2)) {
                    winO++;
                } else {
                    winO = 0;
                }
                if (winO >= score) {
                    for (int step = score-1; step >= 0; step--) {
                        if (((column - step) >= 0)&& ((column - step) < board.length)) {
                            if (board[row][column - step] == 0) {
                                board[row][column - step] = 2;
                                return;
                            }
                        }
                    }
                }
            }
            winO = 0;
        }

        column:
        for (int column = 0; column < board[0].length; column++) {
            for (int row = 0; row < board.length; row++) {
                if (board[row][column] == 0 || (board[row][column] == 2)) {
                    winO++;
                } else {
                    winO = 0;
                }
                if (winO >= score) {
                    for (int step = score-1; step >= 0; step--) {
                        if ((row - step >= 0) && ((row - step) < board.length)) {
                            if (board[row - step][column] == 0) {
                                board[row - step][column] = 2;
                                return;
                            }
                        }
                    }
                }
            }
            winO = 0;
        }
        diagonal:
        for (int column = board[0].length; column >= 0; column--) {
            for (int row = 0; row < board.length; row++) {
                if ((row >= 0) && (column + row >= 0) && ((row) < board.length) && ((column + row) < board.length)) {
                    if (board[row][column + row] == 0 || (board[row][column + row] == 2)) {
                        winO++;
                    } else {
                        winO = 0;
                    }
                    if (winO >= score) {
                        for (int step = score-1; step >= 0; step--) {
                            if ((row - step >= 0) && (column + row - step >= 0) && ((row - step) < board.length) && ((column + row - step) < board.length)) {
                                if (board[row - step][column + row - step] == 0) {
                                    board[row - step][column + row - step] = 2;
                                    return;
                                }
                            }
                        }
                    }
                }
            }
            winO = 0;
            for (int row = board.length; row >= 0; row--) {
                if ((row >= 0) && (column - row >= 0) && ((row) < board.length) && ((column - row) < board.length)) {
                    if (board[row][column - row] == 0 || (board[row][column - row] == 2)) {
                        winO++;
                    } else {
                        winO = 0;
                    }
                    if (winO >= score) {
                        for (int step = score-1; step >= 0; step--) {
                            if ((row - step >= 0) && (column - row - step >= 0) && ((row - step) < board.length) && ((column - row - step) < board.length)) {
                                if (board[row - step][column - row - step] == 0) {
                                    board[row - step][column - row - step] = 2;
                                    return;
                                }
                            }
                        }
                    }
                }
            }
            winO = 0;
            for (int row = 0; row < board.length; row++) {
                if ((row >= 0) && (column - row >= 0) && ((row) < board.length) && ((column - row) < board.length)) {
                    if (board[row][column - row] == 0 || (board[row][column - row] == 2)) {
                        winO++;
                    } else {
                        winO = 0;
                    }
                    if (winO >= score) {
                        for (int step = score-1; step >= 0; step--) {
                            if ((row - step >= 0) && (column - row - step >= 0) && ((row - step) < board.length) && ((column - row - step) < board.length)) {
                                if (board[row - step][column - row - step] == 0) {
                                    board[row - step][column - row - step] = 2;
                                    return;
                                }
                            }
                        }
                    }
                }
            }
            winO = 0;
            for (int row = board.length; row >= 0; row--) {
                if ((row >= 0) && (column + row >= 0) && ((row) < board.length) && ((column + row) < board.length)) {
                    if (board[row][column + row] == 0 || (board[row][column + row] == 2)) {
                        winO++;
                    } else {
                        winO = 0;
                    }
                    if (winO >= score) {
                        for (int step = score-1; step >= 0; step--) {
                            if ((row - step >= 0) && (column + row - step >= 0) && ((row - step) < board.length) && ((column + row - step) < board.length)) {
                                if (board[row - step][column + row - step] == 0) {
                                    board[row - step][column + row - step] = 2;
                                    return;
                                }
                            }
                        }
                    }
                }
            }
            winO = 0;
        }
    }

    public static void simple(int board[][]) {
        boolean turn = false;
        while (!turn) {
            int row = random.nextInt(board.length - 1);
            int column = random.nextInt(board.length - 1);
            if (board[row][column] == 0) {
                board[row][column] = 2;
                turn = true;
                return;
            } else {
                continue;
            }
        }
    }

    public static void menu() {
        int size = 3;
        int score = 3;
        System.out.println("Желаете ли вы изменить правила игры?(y/n)");
        if (((in.nextLine().trim()).toLowerCase()).equals("y")) {
            System.out.println("Укажите размер игры(от 2 до 9)");
            size = in.nextInt();
            if ((size > 9) || (size < 2)) {
                System.out.println("Указан неверный размер игры. Настройки не применены.");
                Main.menu();
            }
            System.out.println("Укажите счет для победы(от 2 до 9)");
            score = in.nextInt();
            if ((score > 9) || (score < 2) || (score > size)) {
                System.out.println("Указан неверный счет для победы. Настройки не применены.");
                Main.menu();
            }
        }
        int[][] board = new int[size][size];
        int row = 0;
        int column = 0;
        System.out.println("Выберите тип игры:\n" +
                "1 - против человека\n" +
                "2 - против компьютера\n" +
                "0 - выход");
        int opponent = in.nextInt();
        switch (opponent) {
            case 1:
                Main.draw(board);
                while (Main.check(board, score) == 0) {
                    System.out.println("X, введите поочередно номер строки и столбца, куда желаете сделать ход");
                    row = in.nextInt() - 1;
                    column = in.nextInt() - 1;
                    while ((row > size) || (row < 0) || (column > size) || (column < 0) || (board[row][column] != 0)) {
                        row = in.nextInt() - 1;
                        column = in.nextInt() - 1;
                        System.out.println("Невозможно сделать ход в эту клетку");
                        continue;
                    }
                    board[row][column] = 1;
                    Main.draw(board);
                    if (Main.check(board, score) != 0) break;
                    System.out.println("O, введите поочередно номер строки и столбца, куда желаете сделать ход");
                    row = in.nextInt() - 1;
                    column = in.nextInt() - 1;
                    while ((row > size) || (row < 0) || (column > size) || (column < 0) || (board[row][column] != 0)) {
                        row = in.nextInt() - 1;
                        column = in.nextInt() - 1;
                        System.out.println("Невозможно сделать ход в эту клетку");
                        continue;
                    }
                    board[row][column] = 2;
                    Main.draw(board);
                }
                if (Main.check(board, score) == 1) System.out.println("Выиграл X");
                if (Main.check(board, score) == 2) System.out.println("Выиграл O");
                break;
            case 2:
                System.out.println("Выберите тип:\n" +
                        "1 - случайный\n" +
                        "2 - альтернативный(алгоритм, стремящийся заполнить линию)\n");
                int type = in.nextInt();
                switch (type) {
                    case 1:
                        Main.draw(board);
                        while (Main.check(board, score) == 0) {
                            System.out.println("Введите поочередно номер строки и столбца, куда желаете сделать ход");
                            row = in.nextInt() - 1;
                            column = in.nextInt() - 1;
                            if ((row > size) || (row < 0) || (column > size) || (column < 0) || (board[row][column] != 0)) {
                                System.out.println("Невозможно сделать ход в эту клетку");
                                continue;
                            }
                            board[row][column] = 1;
                            Main.draw(board);
                            if (Main.check(board, score) != 0) break;
                            Main.simple(board);
                            System.out.println("Компьютер сделал ход");
                            Main.draw(board);
                        }
                        if (Main.check(board, score) == 1) System.out.println("Выиграл человек");
                        if (Main.check(board, score) == 2) System.out.println("Победила машина");
                        break;
                    case 2:
                        Main.draw(board);
                        while (Main.check(board, score) == 0) {
                            System.out.println("Введите поочередно номер строки и столбца, куда желаете сделать ход");
                            row = in.nextInt() - 1;
                            column = in.nextInt() - 1;
                            if ((row > size) || (row < 0) || (column > size) || (column < 0) || (board[row][column] != 0)) {
                                System.out.println("Невозможно сделать ход в эту клетку");
                                continue;
                            }
                            board[row][column] = 1;
                            Main.draw(board);
                            if (Main.check(board, score) != 0) break;
                            Main.alternative(board, score);
                            System.out.println("Компьютер сделал ход");
                            Main.draw(board);
                        }
                        if (Main.check(board, score) == 1) System.out.println("Выиграл человек");
                        if (Main.check(board, score) == 2) System.out.println("Победила машина");

                        break;
                    default:
                        System.out.println("Такой сложности не существует");
                        Main.menu();
                }
            case 0:
                break;
            default:
                System.out.println("Такого варианта не существует!");
                Main.menu();
        }
    }

    public static void main(String[] args) {
        System.out.println("Игра крестики-нолики.");
        Main.menu();
    }
}
