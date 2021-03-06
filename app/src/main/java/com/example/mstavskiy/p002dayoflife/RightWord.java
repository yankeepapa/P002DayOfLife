package com.example.mstavskiy.p002dayoflife;

public class RightWord {

    private String[] text = new String[4];

    public int alg(int y) {
        int key;

        if (y == 11 | y== 12 | y== 13 | y== 14) {
            key = 2;
        } else {
            if (y < 10) {
                y = y + 10;
            }
            if (y % 10 == 1) {
                key = 0;
            } else {
                if (y % 10 == 2 | y % 10 == 3 | y % 10 == 4) {
                    key = 1;
                } else {
                    key = 2;
                }
            }
        }
        return key;
    }

    public String[] ymdt(int[] ym ) {

        String[] years = {" год", " года", " лет"};
        String[] months = {" месяц", " месяца", " месяцев"};
        String[] days = {" день", " дня", " дней"};

        for (int q = 0; q < 4; q++) {
            switch (q) {
                case 0:
                    text[q] = years[alg(ym[q])];
                    break;

                case 1:
                    text[q] = months[alg(ym[q])];
                    break;

                case 2:
                    text[q] = days[alg(ym[q])];
                    break;

                case 3:
                    text[q] = days [alg(ym[q])];
                    break;

            }

        }
        return text;


    }
}
