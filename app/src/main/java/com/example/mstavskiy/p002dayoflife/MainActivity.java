package com.example.mstavskiy.p002dayoflife;

import java.util.Calendar;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

// Проверка работы github и версий.

public class MainActivity extends Activity implements OnClickListener {

    static int d1 = 16;
    static int m1 = 11;
    static int y1 = 1985;
    int DIALOG_DATE = 1;

    TextView tv_y;
    TextView tv_m;
    TextView tv_d;
    TextView tv_t;
    TextView tv_total;

    Button dob;
    Button btn_count;




    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        tv_y = (TextView) findViewById(R.id.tv_y);
        tv_m = (TextView) findViewById(R.id.tv_m);
        tv_d = (TextView) findViewById(R.id.tv_d);
        tv_t = (TextView) findViewById(R.id.tv_t);
        tv_total = (TextView)findViewById(R.id.tv_total);

        dob = (Button) findViewById(R.id.dob);
        btn_count = (Button) findViewById(R.id.btn_count);

        dob.setOnClickListener(this);
        btn_count.setOnClickListener(this);

    }

    /*   public static class DatePickerFragment extends DialogFragment implements DatePickerDialog.OnDateSetListener {
       @Override

           public Dialog onCreateDialog(Bundle savedInstanceState) {

           return new DatePickerDialog(getActivity(), this, y1, m1, d1);
           }

           public void onDateSet(DatePicker view, int year, int month, int day) {
           y1 = year;
           m1 = month;
           d1 = day;
           };
      }



       public void showDatePickerDialog (View v) {
          DialogFragment newFragment = new DatePickerFragment();
          newFragment.show(getSupportFragmentManager(), "datePicker");
           }
   */
    @Override
    public void onClick (View v) {

        switch (v.getId()){

            case R.id.btn_count:

                int y = 0; //kol-vo let
                int m = 0; //kol-vo mesyacev
                int d = 0; //kol-vo dney
                int total = 0; //obshee kolichesctvo dney

                Calendar cal = Calendar.getInstance();
                int d2= cal.get(Calendar.DAY_OF_MONTH);
                int m2= cal.get(Calendar.MONTH)+1;
                int y2= cal.get(Calendar.YEAR);


                if (y2 < y1) {
                    tv_t.setText("No way.");
                    break;
                };

                //Vychislenie kolichestva let, mesyacev, dney.
                if (m2>=m1) {
                    y=y2-y1;
                    if (d2>=d1) {
                        m=m2-m1;
                        d=d2-d1;
                    } else {
                        m = m2-m1-1;
                        if (m1<8) {
                            if (m1%2==0) {
                                if (m1==2) {
                                    if (y2%4==0) {
                                        d=29-d1+d2;
                                    } else {d=28-d1+d2;}
                                } else {d=30-d1+d2;}
                            } else {d=31-d1+d2;}
                        } else {
                            if (m1%2==0) {
                                d=31-d1+d2;
                            } else {d=30-d1+d2;};
                        };
                    }
                } else {
                    y=y2-y1-1;
                    if (d2>=d1) {
                        d=d2-d1;
                        m=12-m1+m2;
                    } else {
                        m=12-m1+m2-1;
                        if (m1<8) {
                            if (m1%2==0) {
                                if (m1==2) {
                                    if (y2%4==0) {
                                        d=29-d1+d2;
                                    } else {d=28-d1+d2;}
                                } else {d=30-d1+d2;}
                            } else {d=31-d1+d2;}
                        } else {
                            if (m1%2==0) {
                                d=31-d1+d2;
                            } else {d=30-d1+d2;}
                        }
                    }

                };


                //Vychislenie kolichestva dney
                for (int i = y1 + 1; i < y2; i++ ) {
                    if (i%4 == 0) {
                        total = total + 366;
                    } else {
                        total = total + 365;
                    }
                };

                for (int i = 1; i < m2; i++) {
                    if (i < 8) {
                        if (i % 2 == 0) {
                            if (i == 2) {
                                if (y2 % 4 == 0 ) {
                                    total = total + 29;
                                } else {
                                    total = total + 28;
                                };
                            } else {
                                total = total + 30;
                            };
                        } else {
                            total = total + 31;
                        };
                    } else {
                        if (i % 2 ==0) {
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
                                if (y2 % 4 == 0 ) {
                                    total = total + 29;
                                } else {
                                    total = total + 28;
                                };
                            } else {
                                total = total + 30;
                            };
                        } else {
                            total = total + 31;
                        };
                    } else {
                        if (i % 2 ==0) {
                            total = total + 31;
                        } else {
                            total = total + 30;
                        }
                    }
                }

                if (m1 < 8) {
                    if (m1 % 2 == 0) {
                        if (m1 == 2) {
                            if (m1 % 4 == 0 ) {
                                total = total + 29 - d1;
                            } else {
                                total = total + 28 - d1;
                            };
                        } else {
                            total = total + 30 - d1;
                        };
                    } else {
                        total = total + 31 - d1;
                    };
                } else {
                    if (m1 % 2 == 0) {
                        total = total + 31 - d1;
                    } else {
                        total = total + 30 - d1;
                    }
                };




                tv_t.setText("Вы прожили:");
                tv_d.setText(d + " дней");
                tv_m.setText(m + " месяцев");
                tv_y.setText(y + " лет");
                tv_total.setText("Всего: " + total +"дней");

                break;
        };
    };

}