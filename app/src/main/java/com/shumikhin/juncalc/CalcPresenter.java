package com.shumikhin.juncalc;

import android.os.Parcel;
import android.os.Parcelable;

import net.objecthunter.exp4j.Expression;
import net.objecthunter.exp4j.ExpressionBuilder;

public class CalcPresenter implements Parcelable {

    // Последняя нажатая клавиша, если true - то цифра
    private boolean lastNumeric;

    // стостояние ошибки
    private boolean stateError;

    //если точка уже стоит то true и больше добавлять точку нельзя
    boolean booleanDot;

    //здесь храним наш текст задачи
    StringBuilder text_calc;

    public CalcPresenter() {
        clearAll();
    }

    protected CalcPresenter(Parcel in) {
        lastNumeric = in.readByte() != 0;
        stateError = in.readByte() != 0;
        booleanDot = in.readByte() != 0;
    }

    public void clearAll() {
        this.lastNumeric = false;
        this.stateError = false;
        this.booleanDot = false;
        this.text_calc = new StringBuilder();
    }

    public void numericClick(String numberStr) {
        if (stateError) {
            text_calc.delete(0, text_calc.length());
            stateError = false;
        }
        text_calc.append(numberStr);
        //указываем что последний символ был цифра
        lastNumeric = true;
    }

    public void mathOperationClick(String operationStr) {
        if (lastNumeric && !stateError) {
            text_calc.append(operationStr);
            lastNumeric = false;
            booleanDot = false;    // нет смысла если мы поставим точку после + или *
        }
    }

    public void dotClick() {
        if (lastNumeric && !stateError) {
            text_calc.append(".");
            lastNumeric = false;
            booleanDot = true;
        }
    }

    public void onEqual() {
        //Если ошибка то пропускаем
        //Если число то считаем
        String txt;
        String returnTxt = "";
        if (lastNumeric && !stateError && text_calc.length() != 0) {
            txt = text_calc.toString();
            Expression expression = new ExpressionBuilder(txt).build();
            try {
                // Передаю решение в вывод
                double result = expression.evaluate();
                returnTxt = Double.toString(result);
                booleanDot = true; // считаем что точка нажата
            } catch (ArithmeticException ex) {
                // Случилась какая-то ошибка, например поделили на 0
                returnTxt = "Error";
                stateError = true;
                lastNumeric = false;
            }
        }
        text_calc.append("=").append(returnTxt);
    }

    public StringBuilder getText_calc() {
        return text_calc;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeByte((byte) (lastNumeric ? 1 : 0));
        parcel.writeByte((byte) (stateError ? 1 : 0));
        parcel.writeByte((byte) (booleanDot ? 1 : 0));
        parcel.writeString(String.valueOf(text_calc));
    }

    public static final Creator<CalcPresenter> CREATOR = new Creator<CalcPresenter>() {
        @Override
        public CalcPresenter createFromParcel(Parcel in) {
            return new CalcPresenter(in);
        }

        @Override
        public CalcPresenter[] newArray(int size) {
            return new CalcPresenter[size];
        }
    };
}
