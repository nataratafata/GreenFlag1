package firstproject2.mcs.com.greenflag;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;
import firstproject2.mcs.com.greenflag.Dao.dao;
import firstproject2.mcs.com.greenflag.database.database;
import firstproject2.mcs.com.greenflag.entity.customerTable;

import android.net.Uri;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.provider.MediaStore;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

public class ThirdActivity extends AppCompatActivity {

    private static final String TAG = "ThirdActivity";
    private static final int RESULT_LOAD_IMAGE = 1;
    ImageView imageUploaded;
    customerTable myDb;

    database data;
    TextView mDisplayDate;
    EditText mName, mUserName, mPassword, mAge, mAddress;
    Button btnSave, imageUpload;

    TextView dateResult;
    private DatePickerDialog.OnDateSetListener mDateSetListener;
    View view;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_third);
        //get birthday method
        mDisplayDate = (TextView) findViewById(R.id.tvDate);
        mDisplayDate.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                Calendar cal = Calendar.getInstance();
                int year = cal.get(Calendar.YEAR);
                int month = cal.get(Calendar.MONTH);
                int day = cal.get(Calendar.DAY_OF_MONTH);

                DatePickerDialog dialog = new DatePickerDialog(
                        ThirdActivity.this,
                        android.R.style.Theme_Holo_Light_DarkActionBar, mDateSetListener,
                        year, month, day);
                dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                dialog.show();
                //
                //mDisplayDate.setDate((CharSequence) cal);
              //  public void setDate (TextView view){

               //     Date today = Calendar.getInstance().getTime();//getting date
               //     SimpleDateFormat formatter = new SimpleDateFormat("dd.MM.yyyy");//formating according to my need
              //      String date = formatter.format(today);
               //     mDisplayDate.setText(date);
               // }
                //

            }



        //
         //   mDisplayDate = new SimpleDateFormat("MMM dd, yyyy",Locale.getDefault()).format(new Date());
         //   TextView tv_date = findViewById(R.id.mydateText);
         //   tv_date.setText(date_n);

            //
        });
        mDateSetListener = new DatePickerDialog.OnDateSetListener(){


            public void onDateSet(DatePicker datePicker, int i, int i1, int i2){
                Log.d(TAG, "onDateSet: data: " + i + "/" + i1+ "/" +i2);
            }
        };
//

        //

        //
     /*   mDisplayDate.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                Intent dateIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);

                startActivityForResult(dateIntent, 0);
            }

        });*/

        //
        //setting up database
        database Data = Room.databaseBuilder(getApplicationContext(),
                database.class, "database-name").allowMainThreadQueries().build();
        data = Data;
        myDb = new customerTable();

        mName = (EditText)findViewById(R.id.editText4);
        mUserName = (EditText)findViewById(R.id.editText5);
        mPassword = (EditText)findViewById(R.id.editText7);
        mAge = (EditText)findViewById(R.id.editText8);
        mAddress = (EditText)findViewById(R.id.editText9);
        btnSave = (Button)findViewById(R.id.button6);


        view = this.getWindow().getDecorView();
        view.setBackgroundResource(R.color.Black);

        //image upload method
        imageUploaded = (ImageView) findViewById(R.id.imageToUpload);

        imageUpload = (Button) findViewById(R.id.uploadImage);


        imageUpload.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                Intent galleryIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);

                startActivityForResult(galleryIntent, 0);
            }

        });






    }


    protected void onActivityResult(int requestCode, int resultCode, Intent data){
        super.onActivityResult(requestCode, resultCode, data);
        Bitmap bitmap = (Bitmap) data.getExtras().get("data");
        imageUploaded.setImageBitmap(bitmap);

    }

    public void launchFourthActivity(View view){
        Intent intent = new Intent(this, fourthActivity.class);


        myDb.getAll(mName.getText().toString(),mUserName.getText().toString(),mPassword.getText().toString(), mAge.getText().toString(),mAddress.getText().toString());
        data.userDao().insertAll(myDb);

        startActivity(intent);
    }


}
