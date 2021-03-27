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
    boolean booleanDot;

    //здесь храним наш текст задачи
    StringBuilder text_calc;

    public CalcPresenter() {
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

    public String onEqual() {

        //Если ошибка то пропускаем
        //Если число то считаем
        String txt;
        String returnTxt = "";
        if (lastNumeric && !stateError && text_calc.length()!=0) {
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
        return returnTxt;
    }

    public StringBuilder getText_calc() {
        return text_calc;
    }

}
