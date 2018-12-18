package cc.stever.stever1975.multitone;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.media.AudioManager;
import android.media.ToneGenerator;


public class MainActivity extends AppCompatActivity {

    private static String TAG_MULTIPLE_TOUCH = "MULTIPLE_TOUCH";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setTitle("dev2qa.com - Android Multiple Touch Example.");

        final TextView pointerOneStatusTextView = (TextView)findViewById(R.id.multi_touch_pointer1);

        final TextView pointerTwoStatusTextView = (TextView)findViewById(R.id.multi_touch_pointer2);

        LinearLayout layout = (LinearLayout)findViewById(R.id.multi_touch_layout);
        layout.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {

                // Get total pointer number.
                int totalPointerCount = motionEvent.getPointerCount();

                // Loop for each pointer.
                for(int i=0;i<totalPointerCount;i++)
                {
                    StringBuffer pointerStatusBuf = new StringBuffer();

                    // Get pointer id.
                    int pointerId = motionEvent.getPointerId(i);
                    pointerStatusBuf.append("Pointer Id : ");
                    pointerStatusBuf.append(pointerId);
                    pointerStatusBuf.append(" . ");

                    // Get pointer action.
                    pointerStatusBuf.append("Action : ");

                    int action = motionEvent.getAction();

                    if(action == MotionEvent.ACTION_DOWN)
                    {
                        pointerStatusBuf.append("Down. ");
                    }else if(action == MotionEvent.ACTION_UP)
                    {
                        pointerStatusBuf.append("Up. ");
                    }else if(action == MotionEvent.ACTION_POINTER_DOWN)
                    {
                        pointerStatusBuf.append("Pointer Down. ");
                    }else if(action == MotionEvent.ACTION_POINTER_UP)
                    {
                        pointerStatusBuf.append("Pointer Up. ");
                    }else if(action == MotionEvent.ACTION_MOVE)
                    {
                        pointerStatusBuf.append("Move. ");
                    }else if(action == MotionEvent.ACTION_HOVER_ENTER)
                    {
                        pointerStatusBuf.append("Hover Enter. ");
                    }else if(action == MotionEvent.ACTION_HOVER_MOVE)
                    {
                        pointerStatusBuf.append("Hover Move. ");
                    }else if(action == MotionEvent.ACTION_HOVER_EXIT)
                    {
                        pointerStatusBuf.append("Hover Exit. ");
                    }else if(action == MotionEvent.ACTION_POINTER_2_DOWN)
                    {
                        pointerStatusBuf.append("Pointer 2 Down. ");
                    }else if(action == MotionEvent.ACTION_POINTER_2_UP)
                    {
                        pointerStatusBuf.append("Pointer 2 Up. ");
                    }else
                    {
                        pointerStatusBuf.append(action + ". ");
                    }


                    // Get action index.
                    int actionIndex = motionEvent.getActionIndex();
                    pointerStatusBuf.append("Action Index : ");
                    pointerStatusBuf.append(actionIndex);
                    pointerStatusBuf.append(" . ");

                    // Get pointer X coordinates.
                    float x = motionEvent.getX(i);

                    // Get pointer Y coordinates.
                    float y = motionEvent.getY(i);

                    pointerStatusBuf.append("X : ");
                    pointerStatusBuf.append(x);
                    pointerStatusBuf.append(" , Y : ");
                    pointerStatusBuf.append(y);

                    // Display the pointer info in logcat console.
                    Log.d(TAG_MULTIPLE_TOUCH, pointerStatusBuf.toString());

                    if(pointerId == 0)
                    {
                        // First textview display first touch pointer status info.
                        pointerOneStatusTextView.setText(pointerStatusBuf.toString());
                    }else
                    {
                        // Second textview display second touch pointer status info.
                        pointerTwoStatusTextView.setText(pointerStatusBuf.toString());
                    }
                }

                // Tell android system event has been consumed by this listener.
                return true;
            }
        });


        ToneGenerator toneGen1;
        ToneGenerator toneGen2;
        int type;
        boolean result = true;

        toneGen1 = new ToneGenerator(AudioManager.STREAM_MUSIC, 20);
        toneGen2 = new ToneGenerator(AudioManager.STREAM_MUSIC, 50);
        
        //toneGen1.startTone(ToneGenerator.TONE_DTMF_1);

        toneGen1.startTone(ToneGenerator.TONE_DTMF_A);
    }
}