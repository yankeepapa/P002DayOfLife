package com.example.mstavskiy.p002dayoflife;

/**
 * Created by MStavskiy on 22-Jan-15.
 */
public class YearsMonthsDaysCounter {

    int y; //kol-vo let
    int m; //kol-vo mesyacev
    int d; //kol-vo dney
    int y1;
    int m1;
    int d1;
    int y2;
    int m2;
    int d2;

    public YearsMonthsDaysCounter (int yBirth, int mBirth, int dBirth, int yNow, int mNow, int dNow) {

        //Vychislenie kolichestva let, mesyacev, dney.
        if (m2 >= m1) {
            y = y2 - y1;
            if (d2 >= d1) {
                m = m2 - m1;
                d = d2 - d1;
            } else {
                m = m2 - m1 - 1;
                if (m1 < 8) {
                    if (m1 % 2 == 0) {
                        if (m1 == 2) {
                            if (y2 % 4 == 0) {
                                d = 29 - d1 + d2;
                            } else {
                                d = 28 - d1 + d2;
                            }
                        } else {
                            d = 30 - d1 + d2;
                        }
                    } else {
                        d = 31 - d1 + d2;
                    }
                } else {
                    if (m1 % 2 == 0) {
                        d = 31 - d1 + d2;
                    } else {
                        d = 30 - d1 + d2;
                    }
                }
            }
        } else {
            y = y2 - y1 - 1;
            if (d2 >= d1) {
                d = d2 - d1;
                m = 12 - m1 + m2;
            } else {
                m = 12 - m1 + m2 - 1;
                if (m1 < 8) {
                    if (m1 % 2 == 0) {
                        if (m1 == 2) {
                            if (y2 % 4 == 0) {
                                d = 29 - d1 + d2;
                            } else {
                                d = 28 - d1 + d2;
                            }
                        } else {
                            d = 30 - d1 + d2;
                        }
                    } else {
                        d = 31 - d1 + d2;
                    }
                } else {
                    if (m1 % 2 == 0) {
                        d = 31 - d1 + d2;
                    } else {
                        d = 30 - d1 + d2;
                    }
                }
            }

        }



    }


    
}
