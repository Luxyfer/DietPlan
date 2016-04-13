package com.bright.dietplan;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by Luis on 09/04/2016.
 */
public class NameAgeFragment extends Fragment {
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.fragment_name_age, container, false);


        return rootView;
    }

    public void asdjsak() {
        /*getSupportActionBar().setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM);
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
*/
}
    }
