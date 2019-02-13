package com.example.srs.activity;

import android.arch.persistence.room.Room;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;

//import com.example.srs.HomePageActivity;
import com.example.srs.R;
import com.example.srs.database.UserDataBase;

public class MainActivity extends AppCompatActivity {

    public static final String EXTRA_MESSAGE = "com.example.srs.MESSAGE";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final Spinner spinner = (Spinner) findViewById(R.id.spinner);


        String register_answer_question;
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view,
                                       int pos, long id) {

                String[] languages = getResources().getStringArray(R.array.a);
                String register_answer_question;
                register_answer_question=languages[pos];
            }
            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                // Another interface callback
            }
        });

        findViewById(R.id.button2).setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                EditText editText = findViewById(R.id.editText13);
                String register_age = editText.getText().toString();


                editText = findViewById(R.id.editText2);
                String register_name = editText.getText().toString();

                editText = findViewById(R.id.editText3);
                String register_username = editText.getText().toString();

                editText = findViewById(R.id.editText6);
                String register_gender = editText.getText().toString();

                editText = findViewById(R.id.editText7);
                String register_phone_num = editText.getText().toString();


                editText = findViewById(R.id.editText9);
                String register_answer = editText.getText().toString();

                editText = findViewById(R.id.editText10);
                String register_password = editText.getText().toString();

                editText = findViewById(R.id.editText12);
                String register_confirm_password = editText.getText().toString();


                TextView showtext = findViewById(R.id.textView4);
                if(!register_confirm_password.equals(register_password))
                {
                    showtext.setText("The two passwords not match!\n");
                }
                else if(register_age.equals("")||register_name.equals("")||register_username.equals("")||register_gender.equals("")||register_phone_num.equals("")||register_password.equals("")||register_confirm_password.equals("")||register_answer.equals(""))
                {
                    showtext.setText("Please enter all blank fields!\n");
                }
                else if(register_password.length()<8)
                {
                    showtext.setText("The length of password should be more than 8 character!\n");
                }
                else
                {
                    int flag_int=0;
                    int flag_char=0;
                    for(int i=0;i<register_password.length();i++)
                    {
                        if(register_password.charAt(i)<'9'&&register_password.charAt(i)>'0')
                        {
                            flag_int=1;
                        }
                        else if(register_password.charAt(i)<'z'&&register_password.charAt(i)>'a'||register_password.charAt(i)<'Z'&&register_password.charAt(i)>'A')
                        {
                            flag_char=1;
                        }
                    }
                    if(!(flag_char==1&&flag_int==1))
                    {
                        showtext.setText("Password should contain both digits and characters\n");
                    }
                    else
                        showtext.setText("\n");
                }

//                refresh();
            }
        });

    }

    /** Called when the user taps the Send button */
    public void sendMessage(View view) {
        // Do something in response to button


        EditText editText = findViewById(R.id.editText10);
        String register_password = editText.getText().toString();

        editText = findViewById(R.id.editText12);
        String register_confirm_password = editText.getText().toString();

        if(!register_confirm_password.equals(register_password))
        {
            Intent intent = new Intent(this, MainActivity.class);
            TextView textView = findViewById(R.id.textView4);
            String message = textView.getText().toString();
            intent.putExtra(EXTRA_MESSAGE, message);
            startActivity(intent);
        }

//        TextView editText = findViewById(R.id.textView4);
//        String message = editText.getText().toString();
//        intent.putExtra(EXTRA_MESSAGE, message);
//        startActivity(intent);
    }

    /**
     * 刷新
     */
    private void refresh() {
        finish();
        Intent intent = new Intent(MainActivity.this, MainActivity.class);
        startActivity(intent);
    }

}
