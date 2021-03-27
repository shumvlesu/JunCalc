package com.shumikhin.juncalc;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

//1. Напишите обработку каждой кнопки из макета калькулятора.
//2. Создайте объект с данными и операциями калькулятора. Продумайте, каким образом будете хранить введённые пользователем данные.
//3. * Создайте макет калькулятора для горизонтальной ориентации экрана и отображайте его в ландшафтной ориентации.

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    //окно куда выводится результат
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

    }

    @Override
    public void onClick(View view) {

        switch (view.getId()) {
            case R.id.button0:

                //engine.appendEntry(".");
                break;
            case R.id.button1:

                //engine.appendEntry(".");
                break;
        }

    }

}