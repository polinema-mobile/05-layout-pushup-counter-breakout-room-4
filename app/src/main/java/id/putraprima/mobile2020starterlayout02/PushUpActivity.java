package id.putraprima.mobile2020starterlayout02;

import androidx.appcompat.app.AppCompatActivity;

import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class PushUpActivity extends AppCompatActivity implements View.OnClickListener
{
    private int mCounter = 0;
    TextView textView20;
    Button btn;
    TextView txt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_push_up);

        btn = (Button) findViewById(R.id.btnPush);
        textView20 = (TextView) findViewById(R.id.textView20);
        txt = (TextView) findViewById(R.id.txtPushupCount);
        textView20.setOnClickListener(this);

        SensorManager sensorManager = (SensorManager) getSystemService(SENSOR_SERVICE);
        final Sensor proximitySensor = sensorManager.getDefaultSensor(Sensor.TYPE_PROXIMITY);

        SensorEventListener sensorEventListener = new SensorEventListener() {
            @Override
            public void onSensorChanged(SensorEvent sensorEvent) {
                if (sensorEvent.values[0] < proximitySensor.getMaximumRange()) {
                    mCounter++;
                    txt.setText(String.valueOf(mCounter));
                } else {

                }
            }

            @Override
            public void onAccuracyChanged(Sensor sensor, int accuracy) {

            }
        };
        sensorManager.registerListener(sensorEventListener, proximitySensor, 2 * 1000 * 1000);

//        btn.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view)
//            {
//                mCounter ++;
//                txt.setText(Integer.toString(mCounter));
//            }        });
    }

    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.textView20:
                mCounter++;
                txt.setText(String.valueOf(mCounter));
                break;
        }
    }
}