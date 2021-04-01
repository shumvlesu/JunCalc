package com.shumikhin.juncalc;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;
import com.google.android.material.switchmaterial.SwitchMaterial;
import static androidx.appcompat.app.AppCompatDelegate.setDefaultNightMode;

public abstract class BaseActivity extends AppCompatActivity {
    // наименование файла хранилища настроек
    private static final String APP_PREFERENCES = "Preferences";
    // наименование настройки в файле настроек
    private static final String NIGHT_MODE_KEY = "NightMode";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // Устанавливать тему надо только до установки макета активити
        setNightMode(getNightModePref());
    }

    public static void setNightMode(boolean mode) {
        if (mode) {
            setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES);
        } else {
            setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
        }
    }

    // Чтение настроек, параметр «ночной режим»
    protected boolean getNightModePref() {
        // getSharedPreferences() доступна только в активити
        SharedPreferences prefs = getSharedPreferences(APP_PREFERENCES, Context.MODE_PRIVATE);
        if (prefs.contains(NIGHT_MODE_KEY)) {
            // Чтение настроек, параметр «ночной режим», если настройка не найдена - взять по умолчанию false
            return prefs.getBoolean(NIGHT_MODE_KEY, false);
        } else {
            return false;
        }
    }

    // Сохранение настроек
    protected void savePrefs(SwitchMaterial switchNightMode) {
        // getSharedPreferences() доступна только в активити
        SharedPreferences prefs = getSharedPreferences(APP_PREFERENCES, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = prefs.edit();
        // Сохранение настроек, параметр «ночной режим»
        editor.putBoolean(NIGHT_MODE_KEY, switchNightMode.isChecked());
        editor.apply();
        //AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES);
    }

    // Восстановление настроек
    protected void loadPrefs(SwitchMaterial switchNightMode) {
        // getSharedPreferences() доступна только в активити
        SharedPreferences prefs = getSharedPreferences(APP_PREFERENCES, Context.MODE_PRIVATE);

        //ЕГОР, ВОПРОС:
        // Почему переключатель ночного режима работает только в портретном режиме
        //это из за того что нет портретной формы у формы настроек?
        if (switchNightMode != null) {
            if (prefs.contains(NIGHT_MODE_KEY)) {
                // Чтение настроек, параметр «ночной режим», если настройка не найдена - взять по умолчанию false
                switchNightMode.setChecked(prefs.getBoolean(NIGHT_MODE_KEY, false));
            } else {
                switchNightMode.setChecked(false);
            }
        }
    }

}

