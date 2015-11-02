package projact.finalprojact.projact;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

/**
 * Created by Admin on 24/10/2015.
 */
public class Schedule_Event extends Fragment {

    Button chooseTime;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View newEvent= inflater.inflate(R.layout.schedule_event, container, false);
        return newEvent;
    }

}