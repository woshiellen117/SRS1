package com.example.srs.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import android.database.sqlite.SQLiteDatabase;
import android.database.Cursor;
import com.example.srs.helper.*;
import com.example.srs.R;

public class MainActivity extends AppCompatActivity {


    private DBHelper dbHelper;
    private Button btn;
    private EditText EdtUser;
    private EditText EdtPwd;
    private TextView forget;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn=(Button) findViewById(R.id.button);
        EdtUser=findViewById(R.id.editText);
        EdtPwd=findViewById(R.id.editText2);
        btn.setOnClickListener(new BtnClickLinstener());
        forget=(TextView) findViewById(R.id.textView);
        forget.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intents = new Intent(MainActivity.this, ForgetActivity.class);
                startActivity(intents);
            }
        });

        Button reg=(Button) findViewById(R.id.button2);
        reg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                refresh();
            }
        });
        dbHelper=new DBHelper(this,"stock.db",null,1);

    }


    class BtnClickLinstener implements View.OnClickListener{


        public void onClick(View v){
            String inputname=EdtUser.getText().toString();
            String inputpwd=EdtPwd.getText().toString();
            SQLiteDatabase db = dbHelper.getWritableDatabase();
            Cursor cursor = db.rawQuery("select password from user where username=?",new String[]{inputname});
            if (cursor.moveToFirst()) {
                //遍历Cursor对象
                String password = cursor.getString(cursor.getColumnIndex("password"));
//                        int pages = cursor.getInt(cursor.getColumnIndex("pages"));
//                        double price = cursor.getDouble(cursor.getColumnIndex("price"));
                if (password.equals(inputpwd)){
                    Toast.makeText(getApplicationContext(), "login correct", Toast.LENGTH_SHORT).show();
                    //Intent intent = new Intent(MainActivity.this, SecondActivity.class);
                    //                startActivity(intent);
                    Intent intents = new Intent(MainActivity.this, HomepageActivity.class);
                    startActivity(intents);

                }else{
                    Toast.makeText(getApplicationContext(), "username/password is incorrect", Toast.LENGTH_SHORT).show();
                }
                //String result = "The user is" + username + "and password is " + password;
                //Toast.makeText(MainActivity.this, result, Toast.LENGTH_SHORT).show();
            }else{
                Toast.makeText(getApplicationContext(), "username/password is incorrect", Toast.LENGTH_SHORT).show();
            }
            cursor.close();
        }
    }



        /**
     * 刷新
     */
    private void refresh() {

        Intent intent = new Intent(this, RegisterActivity.class);
        startActivity(intent);
    }


}
