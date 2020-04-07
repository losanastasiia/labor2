package example.my.labor2;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class FourthActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fourth);

        EditText et1 = findViewById(R.id.editText2);
        EditText et2 = findViewById(R.id.editText3);

        Button button = findViewById(R.id.button2);
        button.setOnClickListener(v -> {
            // Считываем значение поля
            String text = et1.getText().toString() + et2.getText().toString();
            int num = Integer.parseInt(text);
            if(num/10<num%10){

                // Формируем "пустое" намерение
                Intent intent = new Intent();
                // Добавляем в намерение данные
                intent.putExtra("result",text);

                // Устанавливаем результат
                setResult(RESULT_OK,intent);

                // Закрываем Activity
                finish();
            }
            else{
                Toast.makeText(this, "Error! The first number must be less than the second!", Toast.LENGTH_SHORT).show();
            }
        });
    }

    public void handleClick3(View view) {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
}
