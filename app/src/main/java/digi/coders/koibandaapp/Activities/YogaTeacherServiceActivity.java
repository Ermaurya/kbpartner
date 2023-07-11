package digi.coders.koibandaapp.Activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import com.google.android.material.appbar.MaterialToolbar;

import digi.coders.koibandaapp.R;

public class YogaTeacherServiceActivity extends AppCompatActivity {

    MaterialToolbar materialToolbaryagaTeacher;
    TextView textContinue;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_yoga_teacher);

        materialToolbaryagaTeacher = findViewById(R.id.materialToolbar_yogateacher);
        textContinue = findViewById(R.id.txt_Continue);

        clickableMethod();

    }

    private void clickableMethod() {
        materialToolbaryagaTeacher.setNavigationOnClickListener(v -> {
            finish();
        });

        textContinue.setOnClickListener(v -> {
            Intent intent = new Intent(getApplicationContext(),CartActivity.class);
            startActivity(intent);
        });
    }
}