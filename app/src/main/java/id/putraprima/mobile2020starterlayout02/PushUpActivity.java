package id.putraprima.mobile2020starterlayout02;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class PushUpActivity extends AppCompatActivity {
    private int mCounter = 0;
    Button btn;
    TextView txt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_push_up);

        btn = (Button) findViewById(R.id.btnPush);
        txt = (TextView) findViewById(R.id.txtPushupCount);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
                mCounter ++;
                txt.setText(Integer.toString(mCounter));
            }        });
    }
}