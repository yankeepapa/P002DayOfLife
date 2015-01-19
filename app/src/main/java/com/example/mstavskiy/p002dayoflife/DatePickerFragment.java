package com.example.mstavskiy.p002dayoflife;

import java.util.Calendar;

import android.app.Activity;
import android.app.Dialog;
import android.app.DialogFragment;
import android.app.DatePickerDialog;
import android.os.Bundle;
import android.widget.DatePicker;

public class DatePickerFragment extends DialogFragment implements
        DatePickerDialog.OnDateSetListener {

    private DatePickedListener mListener;

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        // установим текущую дату в диалоговом окне
        final Calendar c = Calendar.getInstance();
        int year = c.get(Calendar.YEAR);
        int month = c.get(Calendar.MONTH);
        int day = c.get(Calendar.DAY_OF_MONTH);

        // создадим экземпляр класса DatePickerDialog и вернем его
        return new DatePickerDialog(getActivity(), this, year, month, day);
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
    public void onDateSet(DatePicker view, int year, int month, int day) {
        // Пользователь выбрал дату. Выводим его в текстовой метке
        Calendar c = Calendar.getInstance();
        c.set(Calendar.YEAR, year);
        c.set(Calendar.MONTH, month);
        c.set(Calendar.DAY_OF_MONTH, day);

        mListener.onDatePicked(c);
    }

    public static interface DatePickedListener {
        public void onDatePicked(Calendar time);
    }
}
