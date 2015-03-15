package com.example.mstavskiy.p002dayoflife;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;
import java.util.Calendar;


public class FragmentMain extends Fragment  {

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
    TextView dob;

    ImageButton btn_count;

    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View v = inflater.inflate(R.layout.fragment_main, null);

        tv_y = (TextView) v.findViewById(R.id.tv_y);
        tv_m = (TextView) v.findViewById(R.id.tv_m);
        tv_d = (TextView) v.findViewById(R.id.tv_d);
        tv_t = (TextView) v.findViewById(R.id.tv_t);
        tv_total = (TextView) v.findViewById(R.id.tv_total);

        dob = (TextView) v.findViewById(R.id.dob);
        btn_count = (ImageButton) v.findViewById(R.id.btn_count);

        dob.setText(String.valueOf(d1)+'.' + String.valueOf(m1)+ '.' + String.valueOf(y1));

        return v;
    }

    public void onViewCreated (View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

            btn_count.setOnClickListener(new View.OnClickListener() {

                public void onClick(View v) {
                    YearsMonthsDaysCounter ymdc = new YearsMonthsDaysCounter();
                    int[] ym = ymdc.yearsMonthsDaysCounter(y1, m1, d1, y2, m2, d2);

                    RightWord rw = new RightWord();
                    String[] str = rw.ymdt(ym);

                    tv_t.setText("   Вы прожили:");
                    tv_d.setText("   " + ym[2] + str[2]);
                    tv_m.setText("   " + ym[1] + str[1]);
                    tv_y.setText("   " + ym[0] + str[0]);
                    tv_total.setText("   Всего: " + ym[3] + str[3]);
                }
            });

             dob.setOnClickListener(new View.OnClickListener() {

                  public void onClick(View v) {
                        DatePickerFragment dateFragment = new DatePickerFragment();
                        dateFragment.setInterface(new DatePickerFragment.DatePickedListener() {
                            @Override
                            public void onDatePicked(Calendar date) {
                                y1 = date.get(Calendar.YEAR);
                                m1 = date.get(Calendar.MONTH) + 1;
                                d1 = date.get(Calendar.DAY_OF_MONTH);

                                updateDisplay();
                            }
                        });
                        dateFragment.show(getChildFragmentManager(), "datePicker");
                  }
            });
    }

    public void updateDisplay() {
        dob.setText(new StringBuilder().append(d1).append(".")
        .append(m1).append(".").append(y1));


    }
}

