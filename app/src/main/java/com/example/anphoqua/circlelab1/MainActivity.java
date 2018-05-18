package com.example.anphoqua.circlelab1;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    EditText edt_radius;
    Button btn_solve;
    TextView textView_perimeter, textView_area;
    final float PI = 3.14f;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edt_radius = findViewById(R.id.radius);
        btn_solve = findViewById(R.id.btn_solve);
        textView_perimeter = findViewById(R.id.textview_perimeter);
        textView_area = findViewById(R.id.textview_area);

        btn_solve.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                closeKeyboard();

                double r = Double.parseDouble(edt_radius.getText().toString().trim());
                textView_perimeter.setText(String.valueOf(circlePerimeter(r)));
                textView_area.setText(String.valueOf(circleArea(r)));
            }
        });
    }

    public double circlePerimeter (double radius) {
        return (2*PI*radius);
    }

    public  double circleArea (double radius) {
        return (PI*Math.pow(radius, 2));
    }

    private void closeKeyboard() {
        View view = this.getCurrentFocus();
        if (view != null) {
            InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
            imm.hideSoftInputFromWindow(view.getWindowToken(), 0);
        }
    }
}
