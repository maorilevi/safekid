package projact.finalprojact.projact;

import android.app.Fragment;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

import com.parse.ParseObject;

public class Schedule_Activity extends ActionBarActivity {
    protected boolean startorend=false;
    private String StartTime="";
    private String EndTime="";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.schedule_activity);
        RelativeLayout rl=(RelativeLayout)findViewById(R.id.kids_pic_RL);
        ImageView im=new ImageView(this);
        im.setImageResource(R.drawable.shado);
        rl.addView(im);
        Fragment newfragment;
        newfragment = new Schedule_List_AllEvent();
        FragmentTransaction transaction = getFragmentManager().beginTransaction();
        transaction.replace(R.id.fragment_tochange, newfragment);
        transaction.addToBackStack(null);
        transaction.commit();


    }
    public void NewEventScreen(View view){
        Fragment newfragment;
        newfragment = new Schedule_Event();
        FragmentTransaction transaction = getFragmentManager().beginTransaction();
        transaction.replace(R.id.fragment_tochange, newfragment);
        transaction.addToBackStack(null);
        transaction.commit();
    }
    public void ChooseDay(View view){
        String day="";
        if(view==findViewById(R.id.Sunday_btn)){
            day="Sunday";
        }else if(view==findViewById(R.id.Monday_btn)){
            day="Monday";
        }else if(view==findViewById(R.id.Tuesday_btn)){
            day="Tuesday";
        }else if(view==findViewById(R.id.Wednesday_btn)){
            day = "Wednesday";
        }else if(view==findViewById(R.id.Thursday_btn)){
            day = "Thursday";
        }else if(view==findViewById(R.id.Friday_btn)){
            day = "Friday";
        }
        else if(view==findViewById(R.id.Saturday_btn)){
            day = "Saturday";
        }
        ((TextView)findViewById(R.id.today_showeventscreen)).setText(day);
    }
    public void SaveNewEvent(View view){
        String nameevent=((EditText)findViewById(R.id.newevent_name)).getText().toString();
        String addressevent=((EditText)findViewById(R.id.newevent_address)).getText().toString();
        String startevent=((EditText)findViewById(R.id.newevent_start_txt)).getText().toString();
        String endevent=((EditText)findViewById(R.id.newevent__end_txt)).getText().toString();
        ParseObject AddKidTable = new ParseObject("Event");
        AddKidTable.put("NameEvent",nameevent);
        AddKidTable.put("Address",addressevent);
        AddKidTable.put("StartEvent",startevent);
        AddKidTable.put("EndEvent",endevent);
        AddKidTable.saveInBackground();
        Fragment newfragment;
        newfragment = new Schedule_List_AllEvent();
        FragmentTransaction transaction = getFragmentManager().beginTransaction();
        transaction.replace(R.id.fragment_tochange, newfragment);
        transaction.addToBackStack(null);
        transaction.commit();
    }
    public void chooseTime(View view){
        if(view==findViewById(R.id.start_time_btn)){
            startorend=true;
        }else
            startorend=false;
        Fragment newfragment;
        newfragment = new MyTimePicker();
        FragmentTransaction transaction = getFragmentManager().beginTransaction();
        transaction.replace(R.id.fragment_tochange, newfragment);
        transaction.addToBackStack(null);
        transaction.commit();
    }
    public void savetime(View view){

        String Hours=((TimePicker)findViewById(R.id.mytime)).getCurrentHour().toString();
        String Minute=((TimePicker)findViewById(R.id.mytime)).getCurrentMinute().toString();
        Toast.makeText(getApplication(),Hours+":"+Minute,Toast.LENGTH_SHORT).show();
        Fragment newfragment;
        newfragment = new Schedule_Event();
        FragmentTransaction transaction = getFragmentManager().beginTransaction();
        transaction.replace(R.id.fragment_tochange, newfragment);
        transaction.addToBackStack(null);
        transaction.commit();
        TextView start_time_txt=(TextView)findViewById(R.id.newevent_start_txt);
        TextView end_time_txt=(TextView)findViewById(R.id.newevent_start_txt);

    }
}
