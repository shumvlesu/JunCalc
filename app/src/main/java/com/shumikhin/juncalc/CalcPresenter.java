package com.shumikhin.juncalc;

import android.widget.TextView;

import net.objecthunter.exp4j.Expression;
import net.objecthunter.exp4j.ExpressionBuilder;

public class CalcPresenter {
    // Последняя нажатая клавиша, если true - то цифра
    private boolean lastNumeric;

    // стостояние ошибки
    private boolean stateError;

    //если точка уже стоит то true и больше добавлять точку нельзя
    private boolean booleanDot;


    public String onEqual(TextView txtScreen) {

        //Если ошибка то пропускаем
        //Если число то считаем
        String txt;
        String returnTxt = "";
        if (lastNumeric && !stateError) {
            txt = txtScreen.getText().toString();
            Expression expression = new ExpressionBuilder(txt).build();
            try {
                // Передаю решение в вывод
                double result = expression.evaluate();
                returnTxt = Double.toString(result);
                booleanDot = true; // считаем что точка нажата
            } catch (ArithmeticException ex) {
                // Сообщаю о ошибке
                returnTxt = "Error";
                stateError = true;
                lastNumeric = false;
            }
        }
        return returnTxt;
    }

}