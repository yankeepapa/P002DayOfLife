package com.example.mstavskiy.p002dayoflife;


public class YearsMonthsDaysCounter {

    private int[] ymd = new int[4]; // ymd[year,month,day] можно ли добавить total в этот же массив?

    public int[] yearsMonthsDaysCounter (int y1, int m1, int d1, int y2, int m2, int d2) {

        int y;
        int m;
        int d;
        int total = 0;
        int minus = 0;

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


        //Вычисление общего количества лет
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

        ymd[0] = y;
        ymd[1] = m;
        ymd[2] = d;
        ymd[3] = total;

        return ymd;


    }


    
}
