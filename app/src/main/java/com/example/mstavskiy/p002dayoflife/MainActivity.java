package com.example.mstavskiy.p002dayoflife;

import android.app.Activity;
import android.app.DialogFragment;
import android.content.Context;
import android.os.Bundle;
import android.os.Vibrator;
import android.view.View;
import android.widget.ImageButton;
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

    TextView dob;
    ImageButton btn_count;

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        tv_y = (TextView) findViewById(R.id.tv_y);
        tv_m = (TextView) findViewById(R.id.tv_m);
        tv_d = (TextView) findViewById(R.id.tv_d);
        tv_t = (TextView) findViewById(R.id.tv_t);
        tv_total = (TextView)findViewById(R.id.tv_total);

        dob = (TextView) findViewById(R.id.dob);
        btn_count = (ImageButton) findViewById(R.id.btn_count);

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

                Vibrator vib = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE);
                long milliseconds = 200;
                vib.vibrate(milliseconds);

                YearsMonthsDaysCounter ymdc = new YearsMonthsDaysCounter();
                int[] ym = ymdc.yearsMonthsDaysCounter(y1,m1,d1,y2,m2,d2);


                RightWord rw = new RightWord();
                String[] str = rw.ymdt(ym);

                tv_t.setText("Вы прожили:");
                tv_d.setText(ym[2] + str[2]);
                tv_m.setText(ym[1] + str[1]);
                tv_y.setText(ym[0] + str[0]);
                tv_total.setText("Всего: " + ym[3] + str[3]);

             break;

         }
    }
}



