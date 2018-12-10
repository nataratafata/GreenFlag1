package firstproject2.mcs.com.greenflag;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;
import firstproject2.mcs.com.greenflag.database.database;
import firstproject2.mcs.com.greenflag.entity.customerTable;

public class fourthActivity extends AppCompatActivity {
    View view;
    customerTable myDb;

    database data;

    EditText mName, mUserName, mPassword, mAge, mAddress;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forth);

        database Data = Room.databaseBuilder(getApplicationContext(),
                database.class, "database-name").allowMainThreadQueries().build();
        data = Data;

        myDb = new customerTable();

        myDb.setName();
        mName = (EditText)findViewById(R.id.editText4);
        mUserName = (EditText)findViewById(R.id.editText5);
        mPassword = (EditText)findViewById(R.id.editText7);
        mAge = (EditText)findViewById(R.id.editText8);
        mAddress = (EditText)findViewById(R.id.editText9);


        Toast.makeText(this, Data.userDao().getAll().get(0).name, Toast.LENGTH_SHORT).show();

        view = this.getWindow().getDecorView();
        view.setBackgroundResource(R.color.Black);
    }



}
