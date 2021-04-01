package com.shumikhin.juncalc;

import android.os.Build;
import android.os.Bundle;

import com.google.android.material.switchmaterial.SwitchMaterial;

public class Customization extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_customization);

        SwitchMaterial switchNightMode = findViewById(R.id.switchNightMode);
        // Восстановление настроек из файла настроек
        loadPrefs(switchNightMode);

        // назначаем обработчик переключателя
        switchNightMode.setOnClickListener(v -> {
            // сохраним настройки
            savePrefs(switchNightMode);
            // пересоздадим активити, чтобы тема применилась
            recreate();
        });

    }

}