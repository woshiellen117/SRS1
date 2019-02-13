package com.example.srs.activity;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;
import com.example.srs.R;
import com.example.srs.helper.*;


public class MainActivity extends AppCompatActivity {
    private DBHelper dbHelper;

    public static final String EXTRA_MESSAGE = "com.example.srs.MESSAGE";
    public static int register_answer_question=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        dbHelper = new DBHelper(this, "stock.db", null, 1);
        //创建db
        final SQLiteDatabase db = dbHelper.getWritableDatabase();

//        final Spinner spinner = (Spinner) findViewById(R.id.spinner);


//        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
//            @Override
//            public void onItemSelected(AdapterView<?> parent, View view,
//                                       int pos, long id) {
//
//                String[] questions = getResources().getStringArray(R.array.a);
////                String register_answer_question;
//                register_answer_question =pos;
//            }
//            @Override
//            public void onNothingSelected(AdapterView<?> parent) {
//                // Another interface callback
//            }
//        });

        findViewById(R.id.button2).setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {


                refresh();

//                EditText editText = findViewById(R.id.editText13);
//                String register_age = editText.getText().toString();
//
//
//                editText = findViewById(R.id.editText2);
//                String register_name = editText.getText().toString();
//
//                editText = findViewById(R.id.editText3);
//                String register_username = editText.getText().toString();
//
//                editText = findViewById(R.id.editText6);
//                String register_gender = editText.getText().toString();
//
//                editText = findViewById(R.id.editText7);
//                String register_phone_num = editText.getText().toString();
//
//
//                editText = findViewById(R.id.editText9);
//                String register_answer = editText.getText().toString();
//
//                editText = findViewById(R.id.editText10);
//                String register_password = editText.getText().toString();
//
//                editText = findViewById(R.id.editText12);
//                String register_confirm_password = editText.getText().toString();
//
//
//                TextView showtext = findViewById(R.id.textView4);
//                if(alreadyexists(register_username))
//                {
//                    showtext.setText("The username already exists!\n");
//                }
//                else if(!register_confirm_password.equals(register_password))
//                {
//                    showtext.setText("The two passwords not match!\n");
//                }
//                else if(register_age.equals("")||register_name.equals("")||register_username.equals("")||register_gender.equals("")||register_phone_num.equals("")||register_password.equals("")||register_confirm_password.equals("")||register_answer.equals(""))
//                {
//                    showtext.setText("Please enter all blank fields!\n");
//                }
//                else if(register_password.length()<8)
//                {
//                    showtext.setText("The length of password should be more than 8 character!\n");
//                }
//                else
//                {
//                    int flag_int=0;
//                    int flag_char=0;
//                    for(int i=0;i<register_password.length();i++)
//                    {
//                        if(register_password.charAt(i)<'9'&&register_password.charAt(i)>'0')
//                        {
//                            flag_int=1;
//                        }
//                        else if(register_password.charAt(i)<'z'&&register_password.charAt(i)>'a'||register_password.charAt(i)<'Z'&&register_password.charAt(i)>'A')
//                        {
//                            flag_char=1;
//                        }
//                    }
//                    if(!(flag_char==1&&flag_int==1))
//                    {
//                        showtext.setText("Password should contain both digits and characters!\n");
//                    }
//                    else
//                    {
//                        db.execSQL(getString(R.string.insertData), new String[]{register_username, register_password, register_name,register_gender, register_age, register_phone_num,Integer.toString(register_answer_question),register_answer});
//                        showtext.setText("db\n");
//                        Cursor cursor = db.query("user", null, null, null, null, null, null);
//                        if (cursor.moveToFirst()) {
//                            do {
//                                //遍历Cursor对象
//                                String username = cursor.getString(cursor.getColumnIndex("username"));
//                                String password = cursor.getString(cursor.getColumnIndex("password"));
////                        int pages = cursor.getInt(cursor.getColumnIndex("pages"));
////                        double price = cursor.getDouble(cursor.getColumnIndex("price"));
//
//                                String result = "The user is" + username + "and password is " + password;
//                                Toast.makeText(MainActivity.this, result, Toast.LENGTH_SHORT).show();
//                            } while (cursor.moveToNext());
//                        }
//                        cursor.close();
//
//                    }
//
//                }

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

        Intent intent = new Intent(this, RegisterActivity.class);
        startActivity(intent);
    }

    public boolean alreadyexists(String username)
    {
//        dbHelper = new DBHelper(this, "stock.db", null, 1);
//        //创建db
        final SQLiteDatabase db = dbHelper.getWritableDatabase();
        Cursor cursor = db.query("user", null, null, null, null, null, null);

        if (cursor.moveToFirst()) {
            do {
                //遍历Cursor对象
                String findusername = cursor.getString(cursor.getColumnIndex("username"));
                String result = "The user is " + findusername ;
                Toast.makeText(MainActivity.this, result, Toast.LENGTH_SHORT).show();
                if(findusername.equals(username))
                    return true;
            } while (cursor.moveToNext());
        }
        cursor.close();
        return false;
    }

}
