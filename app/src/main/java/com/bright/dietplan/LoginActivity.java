package com.bright.dietplan;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {
    EditText etUsername;
    EditText etPassword;
    Drawable x;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM);
        getSupportActionBar().setCustomView(R.layout.actionbar_home);

        etUsername = (EditText)findViewById(R.id.MA_Username);
        etPassword = (EditText)findViewById(R.id.MA_Password);

        clearButton(etUsername);
        clearButton(etPassword);

        //LOLDALKDaslkdalskdaslkd

    }

    public void onLoginClick(View v){
        if(etUsername.getText().length() > 10 || etUsername.getText().length() < 5) {
            Toast.makeText(getApplicationContext(), getString(R.string.MA_Toast_BigUsername), Toast.LENGTH_SHORT).show();
            etUsername.setText("");
            return;
        }
        if(etPassword.getText().length() > 15 || etPassword.getText().length() < 5) {
            Toast.makeText(getApplicationContext(), getString(R.string.MA_Toast_BigPass), Toast.LENGTH_SHORT).show();
            etPassword.setText("");
            return;
        }

        Intent i = new Intent(this, MainActivity.class);
        startActivity(i);

    }

    public void clearButton(final EditText et) {
        x = ContextCompat.getDrawable(this, android.R.drawable.ic_menu_close_clear_cancel);
        x.setBounds(0, 0, x.getIntrinsicWidth(), x.getIntrinsicHeight());
        setClearIconVisible(false,et);

        et.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if (et.getCompoundDrawables()[2] != null) {
                    int right = et.getWidth() - et.getPaddingRight();
                    int left = right - x.getIntrinsicWidth();
                    int bottom = et.getHeight() - et.getPaddingBottom();
                    int top = bottom - x.getIntrinsicHeight();
                    boolean tappedX = new Rect(left, top, right, bottom).contains((int) event.getX(), (int) event.getY());
                    if (tappedX) {
                        if (event.getAction() == MotionEvent.ACTION_UP)
                            et.setText("");
                        return true;
                    }
                }
                return false;
            }
        });

        et.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (hasFocus)
                    setClearIconVisible(true, et);
                else {
                    setClearIconVisible(false, et);
                    InputMethodManager inputMethodManager = (InputMethodManager) getSystemService(Activity.INPUT_METHOD_SERVICE);
                    inputMethodManager.hideSoftInputFromWindow(et.getWindowToken(), 0);
                }
            }
        });
    }

    protected void setClearIconVisible(boolean visible,EditText et) {
        boolean wasVisible = (et.getCompoundDrawables()[2] != null);
        if (visible != wasVisible) {
            Drawable xD = visible ? x : null;
            et.setCompoundDrawables(et.getCompoundDrawables()[0], et.getCompoundDrawables()[1], xD, et.getCompoundDrawables()[3]);
        }
    }

}
