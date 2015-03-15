package com.example.mstavskiy.p002dayoflife;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.support.v4.app.DialogFragment;
import android.os.Bundle;
import android.widget.DatePicker;
import java.util.Calendar;
import java.util.Date;

public class DatePickerFragment extends DialogFragment implements
        DatePickerDialog.OnDateSetListener {

    static int year = 1985;
    static int month = 10;
    static int day = 16;

    private DatePickedListener mListener;

    public void setInterface (DatePickedListener d) {
            mListener = d;
    }

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        // установим свою дату в диалоговом окне
        // создадим экземпляр класса DatePickerDialog и вернем его

        DatePickerDialog dialog = new DatePickerDialog(getActivity(), this, year, month, day);
        dialog.getDatePicker().setMaxDate(new Date().getTime());
        return dialog;
    }

    @Override
    public void onDateSet(DatePicker view, int year0, int month0, int day0) {
        // Пользователь выбрал дату. Выводим его в текстовой метке
        Calendar c = Calendar.getInstance();
        c.set(Calendar.YEAR, year0);
        c.set(Calendar.MONTH, month0);
        c.set(Calendar.DAY_OF_MONTH, day0);

        mListener.onDatePicked(c);

        year = year0;
        month = month0;
        day = day0;
    }

    public static interface DatePickedListener {
        public void onDatePicked(Calendar time);
    }
}
