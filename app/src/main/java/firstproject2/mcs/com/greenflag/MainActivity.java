package firstproject2.mcs.com.greenflag;

import android.content.Intent;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.room.Room;
import firstproject2.mcs.com.greenflag.database.database;
import firstproject2.mcs.com.greenflag.entity.customerTable;

public class MainActivity extends AppCompatActivity {
    View view;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
       // setContentView(R.layout.activity_main);
        setContentView(R.layout.first_contraint);


        view = this.getWindow().getDecorView();
        view.setBackgroundResource(R.color.Black);
    }

    public void launchSecondActivity(View view){
        Intent intent = new Intent(this, secondActivity.class);
        startActivity(intent);
    }
}
