package org.example;

import java.util.Scanner;

public class Chess {

    public static String Resolve(int king_x, int king_y, int bishope_x, int bishope_y, int rook_x, int rook_y) {

        if ((Math.abs(bishope_x - king_x) != Math.abs(bishope_y - king_y)) && (king_x != rook_x && king_y != rook_y)) {
            System.out.println("The king is alive");
            return "king";
        }

        /*Если слон ест короля*/
        if (king_x == rook_x || king_y == rook_y) {
            if ((bishope_y == rook_y) || (bishope_x == rook_x)) {
                if (Math.abs(bishope_y - king_y) > Math.abs(rook_y - king_y)) {
                    System.out.println("Rook ate the king");
                    return "rook";
                }
                if (Math.abs(bishope_x - king_x) > Math.abs(rook_x - king_x)) {
                    System.out.println("Rook ate the king");
                    return "rook";
                } else {
                    System.out.println("The king is alive");
                    return "king";
                }
            } else {
                System.out.println("Rook ate the king");
                return "rook";
            }
        }

        /*Если ладья ест короля*/
        if (Math.abs(bishope_x - king_x) == Math.abs(bishope_y - king_y)) {
            if (Math.abs(rook_x - king_x) == Math.abs(rook_y - king_y)) {
                if (Math.abs(bishope_x - king_x) < Math.abs(rook_x - king_x)) {
                    System.out.println("Bishop ate the king");
                    return "bishop";
                }
                if (Math.abs(bishope_y - king_y) < Math.abs(rook_y - king_y)) {
                    System.out.println("Bishop ate the king");
                    return "bishop";
                } else {
                    System.out.println("The king is alive");
                    return "king";
                }
            } else {
                System.out.println("Bishop ate the king");
                return "bishop";
            }
        }
        return "default";
    }
}

