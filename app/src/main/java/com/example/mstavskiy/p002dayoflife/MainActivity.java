package com.example.mstavskiy.p002dayoflife;

import android.app.Activity;
import android.app.DialogFragment;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import com.example.mstavskiy.p002dayoflife.DatePickerFragment.DatePickedListener;
import java.util.Calendar;


public class MainActivity extends Activity implements DatePickedListener {

    int d1 = 16;
    int m1 = 11;
    int y1 = 1985;

    final Calendar cal = Calendar.getInstance();
    int d2= cal.get(Calendar.DAY_OF_MONTH);
    int m2= cal.get(Calendar.MONTH)+1;
    int y2= cal.get(Calendar.YEAR);

    TextView tv_y;
    TextView tv_m;
    TextView tv_d;
    TextView tv_t;
    TextView tv_total;

    Button dob;
    Button btn_count;

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        tv_y = (TextView) findViewById(R.id.tv_y);
        tv_m = (TextView) findViewById(R.id.tv_m);
        tv_d = (TextView) findViewById(R.id.tv_d);
        tv_t = (TextView) findViewById(R.id.tv_t);
        tv_total = (TextView)findViewById(R.id.tv_total);

        dob = (Button) findViewById(R.id.dob);
        btn_count = (Button) findViewById(R.id.btn_count);

        dob.setText(String.valueOf(d1)+'/' + String.valueOf(m1)+ '/' + String.valueOf(y1));

    }


    public void onLabelClick(View v) {
        DialogFragment dateFragment = new DatePickerFragment();
        dateFragment.show(getFragmentManager(), "datePicker");
    }

    public void onDatePicked(Calendar date) {
        // выводим выбранную дату в текстовой метке
        y1 = date.get(Calendar.YEAR);
        m1 = date.get(Calendar.MONTH) + 1;
        d1 = date.get(Calendar.DAY_OF_MONTH);

        updateDisplay();
    }

    // обновляем дату для вывода в TextView
    public void updateDisplay() {
        dob.setText(new StringBuilder().append(d1).append(".")
                .append(m1).append(".").append(y1));
    }


    public void onclick (View v) {
        switch (v.getId()) {

            case R.id.btn_count:


                int y; //kol-vo let
                int m; //kol-vo mesyacev
                int d; //kol-vo dney
                int total = 0; //obshee kolichesctvo dney


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


                    //Vychislenie kolichestva dney


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


                    tv_t.setText("Вы прожили:");
                    tv_d.setText(d + " дней");
                    tv_m.setText(m + " месяцев");
                    tv_y.setText(y + " лет");
                    tv_total.setText("Всего: " + total + "дней");

                    break;

                }
        }
    }



