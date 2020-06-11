package com.movie.financial.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.movie.financial.R;
import com.movie.financial.utils.SpUtils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MainActivity extends BaseActivity {

    private EditText nameEdit,passwordEdit;
    private TextView enter,login;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        nameEdit=findViewById(R.id.name_edit);
        passwordEdit=findViewById(R.id.password_edit);
        enter=findViewById(R.id.enter);
        login=findViewById(R.id.login);
        initData();
    }

    private void initData() {
        //登入
        enter.setOnClickListener(new View.OnClickListener() {

            private String password;
            private String name;

            @Override
            public void onClick(View view) {
                name = nameEdit.getText().toString();
                password = passwordEdit.getText().toString();
                if (name.equals("")){
                    Toast.makeText(MainActivity.this, "用户名不能为空", Toast.LENGTH_SHORT).show();
                    return;
                }else if (password.equals("")){
                    Toast.makeText(MainActivity.this, "密码不能为空", Toast.LENGTH_SHORT).show();
                    return;
                }else if (!ispsd(password)){
                    Toast.makeText(MainActivity.this, "密码必须包括字母和数字", Toast.LENGTH_SHORT).show();
                    return;
                }else {

                }
            }
        });
        //注册
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this,LoginActivity.class));
            }
        });
    }
    public static boolean ispsd(String password) {
        Pattern p = Pattern
                .compile("^[a-zA-Z].*[0-9]|.*[0-9].*[a-zA-Z]");
        Matcher m = p.matcher(password);

        return m.matches();
    }
}
