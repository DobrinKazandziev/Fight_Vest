package dobrink.fight_vest;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends Activity {

    private Button buttonBT;
    private TextView textViewMSG;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Intent intent = new Intent(this, BluetoothWebService.class);
        startService(intent);

        buttonBT = (Button) findViewById(R.id.buttonBT);
        textViewMSG = (TextView) findViewById(R.id.textViewMSG);

        buttonBT.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                Log.d("BTONCLICK", "clicked");
                Intent i = new Intent(MainActivity.this,BluetoothActivity.class);
                startActivity(i);
                return true;
            }
        });
    }
    private BroadcastReceiver mMessageReceiver = new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {
            String message = intent.getStringExtra("message");
            textViewMSG.setText(message);
            Log.d("receiver", "Got message: " + message);
        }
    };

}
