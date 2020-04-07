package example.my.labor2;

import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import java.util.List;

import androidx.appcompat.app.AppCompatActivity;

public class SecondActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
    }

    public void handleClick2(View view) {
        finish();
    }

    public void handleClick5(View view) {

        Intent i = new Intent("some_random_action");

        i.setType("text/plain");
        i.putExtra(Intent.EXTRA_SUBJECT, "WIIINNN!!!");
        i.putExtra(Intent.EXTRA_TEXT, "Hey! I'm a winner! I have a fantastic intuition!");

        // Получаем Package Manager
        PackageManager manager = this.getPackageManager();
        // Получаем список обработчиков намерения
        List<ResolveInfo> list = manager.queryIntentActivities(i, 0);

        if (list.size() > 0) {
            startActivity(i);
        } else {
            Toast.makeText(this,"Unsupported action! Install the email app!",Toast.LENGTH_LONG).show();
        }
    }
}
