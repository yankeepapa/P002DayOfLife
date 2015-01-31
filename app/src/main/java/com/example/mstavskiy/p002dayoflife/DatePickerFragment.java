package com.example.mstavskiy.p002dayoflife;

import android.app.Activity;
import android.app.DatePickerDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.os.Bundle;
import android.widget.DatePicker;

import java.util.Calendar;
import java.util.Date;

public class DatePickerFragment extends DialogFragment implements
        DatePickerDialog.OnDateSetListener {

    private DatePickedListener mListener;

    static int year = 1985;
    static int month = 10;
    static int day = 16;

        @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        // установим свою дату в диалоговом окне


        // создадим экземпляр класса DatePickerDialog и вернем его
        //return new DatePickerDialog(getActivity(), this, year, month, day);

        DatePickerDialog dialog = new DatePickerDialog(getActivity(), this, year, month, day);
        dialog.getDatePicker().setMaxDate(new Date().getTime());
        return dialog;
    }

    @Override
    public void onAttach(Activity activity) {
        // when the fragment is initially shown (i.e. attached to the activity),
        // cast the activity to the callback interface type
        super.onAttach(activity);

        try {
            mListener = (DatePickedListener) activity;
        } catch (ClassCastException e) {
            throw new ClassCastException(activity.toString()
                    + " must implement " + DatePickedListener.class.getName());
        }
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
