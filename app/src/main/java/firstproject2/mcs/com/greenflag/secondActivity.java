package firstproject2.mcs.com.greenflag;

import android.content.Intent;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

public class secondActivity extends AppCompatActivity {
    View view;
    ImageButton button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        view = this.getWindow().getDecorView();
        view.setBackgroundResource(R.color.Black);
    }



    public void launchThirdActivity(View view){
        Intent intent = new Intent(this, ThirdActivity.class);
        startActivity(intent);
    }

}


