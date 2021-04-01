package com.shumikhin.juncalc;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

//1. Напишите обработку каждой кнопки из макета калькулятора.
//2. Создайте объект с данными и операциями калькулятора. Продумайте, каким образом будете хранить введённые пользователем данные.
//3. * Создайте макет калькулятора для горизонтальной ориентации экрана и отображайте его в ландшафтной ориентации.

public class MainActivity extends BaseActivity implements View.OnClickListener {

    private static final String CALC_CLASS = "CALC_CLASS";
    TextView text_calc;
    CalcPresenter calcPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculator);

        initialization();
    }

    private void initialization() {

        int[] numericButtons = {R.id.button0, R.id.button1, R.id.button2, R.id.button3, R.id.button4, R.id.button5, R.id.button6, R.id.button7, R.id.button8, R.id.button9};
        for (int numericButton : numericButtons) {
            findViewById(numericButton).setOnClickListener(this);
        }

        int[] operatorButtons = {R.id.button_plus, R.id.button_minus, R.id.button_multiply, R.id.button_divide, R.id.button_dot, R.id.button_equally, R.id.button_dropping};
        for (int operatorButton : operatorButtons) {
            findViewById(operatorButton).setOnClickListener(this);
        }

        text_calc = findViewById(R.id.text_calc);

        calcPresenter = new CalcPresenter();


        findViewById(R.id.button_customization).setOnClickListener(view -> {
            startActivity(new Intent(MainActivity.this, Customization.class));
        });

    }

    @Override
    public void onClick(View view) {

        //Егор, есть какя-то альтернатива этой партянке?
        switch (view.getId()) {
            case R.id.button0:
                calcPresenter.numericClick("0");
                break;
            case R.id.button1:
                calcPresenter.numericClick("1");
                break;
            case R.id.button2:
                calcPresenter.numericClick("2");
                break;
            case R.id.button3:
                calcPresenter.numericClick("3");
                break;
            case R.id.button4:
                calcPresenter.numericClick("4");
                break;
            case R.id.button5:
                calcPresenter.numericClick("5");
                break;
            case R.id.button6:
                calcPresenter.numericClick("6");
                break;
            case R.id.button7:
                calcPresenter.numericClick("7");
                break;
            case R.id.button8:
                calcPresenter.numericClick("8");
                break;
            case R.id.button9:
                calcPresenter.numericClick("9");
                break;
            case R.id.button_plus:
                calcPresenter.mathOperationClick("+");
                break;
            case R.id.button_minus:
                calcPresenter.mathOperationClick("-");
                break;
            case R.id.button_multiply:
                calcPresenter.mathOperationClick("*");
                break;
            case R.id.button_divide:
                calcPresenter.mathOperationClick("/");
                break;
            case R.id.button_equally:
                calcPresenter.onEqual();
                break;
            case R.id.button_dot:
                calcPresenter.dotClick();
                break;
            case R.id.button_dropping:
                calcPresenter.clearAll();
                break;

            default:
                throw new IllegalStateException("Unexpected value: " + view.getId());
        }
        text_calc.setText(calcPresenter.getText_calc());
    }

    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putParcelable(CALC_CLASS, calcPresenter);
    }

    @Override
    protected void onRestoreInstanceState(@NonNull Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        calcPresenter = savedInstanceState.getParcelable(CALC_CLASS);
        assert calcPresenter != null;
        text_calc.setText(calcPresenter.getText_calc());
    }

}