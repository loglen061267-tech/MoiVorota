package ru.moivorota.app;

import android.app.Activity;
import android.os.Bundle;
import android.graphics.Color;
import android.view.Gravity;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MainActivity extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        LinearLayout root = new LinearLayout(this);
        root.setOrientation(LinearLayout.VERTICAL);
        root.setGravity(Gravity.CENTER);
        root.setPadding(28, 28, 28, 28);
        root.setBackgroundColor(Color.rgb(245, 247, 250));

        TextView title = new TextView(this);
        title.setText("Мои ворота");
        title.setTextSize(30);
        title.setTextColor(Color.rgb(30, 45, 65));
        title.setGravity(Gravity.CENTER);
        root.addView(title, new LinearLayout.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT));

        TextView status = new TextView(this);
        status.setText("Начальная версия приложения. Подключение реле Tuya будет настроено отдельно.");
        status.setTextSize(17);
        status.setTextColor(Color.rgb(55, 65, 80));
        status.setGravity(Gravity.CENTER);
        LinearLayout.LayoutParams statusParams = new LinearLayout.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        statusParams.topMargin = 24;
        root.addView(status, statusParams);

        Button smartLife = new Button(this);
        smartLife.setText("Открыть Smart Life");
        LinearLayout.LayoutParams buttonParams = new LinearLayout.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        buttonParams.topMargin = 28;
        root.addView(smartLife, buttonParams);
        smartLife.setOnClickListener(v -> {
            android.content.Intent intent = getPackageManager().getLaunchIntentForPackage("com.tuya.smartlife");
            if (intent == null) {
                intent = getPackageManager().getLaunchIntentForPackage("com.tuya.smart");
            }
            if (intent != null) {
                startActivity(intent);
            } else {
                status.setText("Smart Life не найден на телефоне. Установите его из официального магазина.");
            }
        });

        setContentView(root);
    }
}
