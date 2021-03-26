package com.shumikhin.juncalc;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

//1. Напишите обработку каждой кнопки из макета калькулятора.
//2. Создайте объект с данными и операциями калькулятора. Продумайте, каким образом будете хранить введённые пользователем данные.
//3. * Создайте макет калькулятора для горизонтальной ориентации экрана и отображайте его в ландшафтной ориентации.

public class MainActivity extends AppCompatActivity  {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculator);

    }
}