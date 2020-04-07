package example.my.labor2;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    public static int a=0;
    public static int b=2;
    public static int REQUEST_CODE = 100;
    String textMain = "Let's check your intuition! \nGuess the number (" + a +" to " + b + ")";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView textView1 = findViewById(R.id.textView);
        textView1.setText(textMain);
        Button button = findViewById(R.id.button4);
        button.setOnClickListener(v -> {
            Intent intent = new Intent(this, FourthActivity.class);
            startActivityForResult(intent, REQUEST_CODE);
        });
    }

    public void handleClick(View view) {
        EditText edittext1 =findViewById(R.id.editText);
        if (checkNumb(edittext1)) {    //check that editText is not empty
            int num1 = Integer.parseInt(edittext1.getText().toString());
            int result = (int) (Math.random() * (b + 1 - a) + a);
            if(num1==result){
                Intent intent = new Intent(this, SecondActivity.class);
                startActivity(intent);
            }
            else{
                Intent intent = new Intent(this, ThirdActivity.class);
                startActivity(intent);
            }
        }
    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {

        if (requestCode == REQUEST_CODE) {
            if (resultCode == RESULT_OK) {

                if (data != null) {
                    String text = data.getStringExtra("result");
                    if (text != null) {
                        int num = Integer.parseInt(text);
                        a=num/10;
                        b=num%10;
                        TextView tv = findViewById(R.id.textView);
                        tv.setText("Let's check your intuition! \nGuess the number (" + a +" to " + b + ")");
                    }
                }
            }
        }
    }

    public boolean checkNumb(EditText editText1){
            String str1=editText1.getText().toString();
            if(TextUtils.isEmpty(str1)){
                return false;
            }
            else return true;
    }
}
