package tiil.edu.ex7_intentlogin;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity2 extends AppCompatActivity {
Button xacnhan;
EditText password,username,email;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main2);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        xacnhan = findViewById(R.id.btnXacNhan);
        password = findViewById(R.id.edtPassword);
        username = findViewById(R.id.edtUserName);
        email = findViewById(R.id.edtEmail);
        xacnhan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(username.getText().toString().equals("volengocthuan") && password.getText().toString().equals("123") && email.getText().toString().equals("thuan.vln.64cntt@ntu.edu.vn")){
                    Intent in = new Intent(MainActivity2.this, MainActivity3.class);
                    in.putExtra("username", "volengocthuan");
                    in.putExtra("password", "123");
                    in.putExtra("email", "thuan.vln.64cntt@ntu.edu.vn");
                    startActivity(in);
                }
                else{
                    username.setError("Sai tên đăng nhập");
                    password.setError("Sai mật khẩu");
                    email.setError("Sai email");
                    Toast.makeText(MainActivity2.this, "Sai tên đăng nhập, mật khẩu hoac email", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}