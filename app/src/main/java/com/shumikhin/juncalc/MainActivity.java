package com.shumikhin.juncalc;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

//1. Напишите обработку каждой кнопки из макета калькулятора.
//2. Создайте объект с данными и операциями калькулятора. Продумайте, каким образом будете хранить введённые пользователем данные.
//3. * Создайте макет калькулятора для горизонтальной ориентации экрана и отображайте его в ландшафтной ориентации.

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    //окно куда выводится результат
    TextView text_calc;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculator);

        //Есть ли способ как-то эту портянку сократить?
        Button button0 = findViewById(R.id.button0);
        Button button1 = findViewById(R.id.button1);
        Button button2 = findViewById(R.id.button2);
        Button button3 = findViewById(R.id.button3);
        Button button4 = findViewById(R.id.button4);
        Button button5 = findViewById(R.id.button5);
        Button button6 = findViewById(R.id.button6);
        Button button7 = findViewById(R.id.button7);
        Button button8 = findViewById(R.id.button8);
        Button button9 = findViewById(R.id.button9);

        Button button_plus = findViewById(R.id.button_plus);// +
        Button button_minus = findViewById(R.id.button_minus);// -
        Button button_multiply = findViewById(R.id.button_multiply);// *
        Button button_divide = findViewById(R.id.button_divide);// /
        Button button_dot = findViewById(R.id.button_dot);// .
        Button button_equally = findViewById(R.id.button_equally);// =

        Button button_dropping = findViewById(R.id.button_dropping);// C

        button0.setOnClickListener(this);
        button1.setOnClickListener(this);
        button2.setOnClickListener(this);
        button3.setOnClickListener(this);
        button4.setOnClickListener(this);
        button5.setOnClickListener(this);
        button6.setOnClickListener(this);
        button7.setOnClickListener(this);
        button8.setOnClickListener(this);
        button9.setOnClickListener(this);

        button_plus.setOnClickListener(this);
        button_minus.setOnClickListener(this);
        button_multiply.setOnClickListener(this);
        button_divide.setOnClickListener(this);
        button_dot.setOnClickListener(this);
        button_equally.setOnClickListener(this);

        button_dropping.setOnClickListener(this);

        text_calc = findViewById(R.id.text_calc);

    }

    @Override
    public void onClick(View view) {
        //view.getId();


    }

}