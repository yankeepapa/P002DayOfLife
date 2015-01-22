package com.example.mstavskiy.p002dayoflife;

/**
 * Created by MStavskiy on 22-Jan-15.
 */
public class TotalDaysCounter {
    int total = 0; //obshee kolichesctvo dney
    int minus = 0;
    int y1;
    int m1;
    int d1;
    int y2;
    int m2;
    int d2;

    //Vychislenie kolichestva dney
    public TotalDaysCounter (int yBirth,int mBirth, int dBirth, int yNow, int mNow, int dNow ) {

        if (y1 != y2) {

            //года разные
            for (int i = y1 + 1; i < y2; i++) {
                if (i % 4 == 0) {
                    total = total + 366;
                } else {
                    total = total + 365;
                }

            }


            for (int i = 1; i < m2; i++) {
                if (i < 8) {
                    if (i % 2 == 0) {
                        if (i == 2) {
                            if (y2 % 4 == 0) {
                                total = total + 29;
                            } else {
                                total = total + 28;
                            }
                        } else {
                            total = total + 30;
                        }
                    } else {
                        total = total + 31;
                    }
                } else {
                    if (i % 2 == 0) {
                        total = total + 31;
                    } else {
                        total = total + 30;
                    }
                }
            }

            total = total + d2;

            for (int i = m1 + 1; i < 13; i++) {
                if (i < 8) {
                    if (i % 2 == 0) {
                        if (i == 2) {
                            if (y2 % 4 == 0) {
                                total = total + 29;
                            } else {
                                total = total + 28;
                            }
                        } else {
                            total = total + 30;
                        }
                    } else {
                        total = total + 31;
                    }
                } else {
                    if (i % 2 == 0) {
                        total = total + 31;
                    } else {
                        total = total + 30;
                    }
                }
            }

            if (m1 < 8) {
                if (m1 % 2 == 0) {
                    if (m1 == 2) {
                        if (m1 % 4 == 0) {
                            total = total + 29 - d1;
                        } else {
                            total = total + 28 - d1;
                        }
                    } else {
                        total = total + 30 - d1;
                    }
                } else {
                    total = total + 31 - d1;
                }
            } else {
                if (m1 % 2 == 0) {
                    total = total + 31 - d1;
                } else {
                    total = total + 30 - d1;
                }
            }
        } else {

            //ДР в этом году
            for (int i = 1; i < m2; i++) {
                if (i < 8) {
                    if (i % 2 == 0) {
                        if (i == 2) {
                            if (y2 % 4 == 0) {
                                total = total + 29;
                            } else {
                                total = total + 28;
                            }
                        } else {
                            total = total + 30;
                        }
                    } else {
                        total = total + 31;
                    }
                } else {
                    if (i % 2 == 0) {
                        total = total + 31;
                    } else {
                        total = total + 30;
                    }
                }
            }

            for (int i = 1; i < m1; i++) {
                if (i < 8) {
                    if (i % 2 == 0) {
                        if (i == 2) {
                            if (y2 % 4 == 0) {
                                minus = minus + 29;
                            } else {
                                minus = minus + 28;
                            }
                        } else {
                            minus = minus + 30;
                        }
                    } else {
                        minus = minus + 31;
                    }
                } else {
                    if (i % 2 == 0) {
                        minus = minus + 31;
                    } else {
                        minus = minus + 30;
                    }
                }
            }

            total = total - minus;

        }

    }
}
