package com.harry;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ExpandableListView;
import android.widget.Toast;
import android.widget.ExpandableListView.OnChildClickListener;

public class MainActivity extends Activity {

    ExpandableListAdapter mAdapter;
    ExpandableListView	mListView;
    List<String> convo;
    HashMap<String, List<String>> messages;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        createStudentData();
        mListView=(ExpandableListView)findViewById(R.id.expanList);
        mAdapter = new ExpandableListAdapter(this, convo,messages);
        mListView.setAdapter(mAdapter);
        mListView.setOnChildClickListener(new OnChildClickListener() {

            @Override
            public boolean onChildClick(ExpandableListView arg0, View arg1, int groupPosition,
                                        int childPosition, long arg4) {
                Toast.makeText(MainActivity.this, " Show Toast "+messages.get(convo.get(groupPosition)).get(childPosition) , Toast.LENGTH_LONG).show();
                return false;
            }
        });
    }


    private void createStudentData() {
        convo = new ArrayList<String>();
        messages = new HashMap<String, List<String>>();

        convo.add("Convo1");
        convo.add("Convo2");
        convo.add("Convo3");

        List<String> convo1 = new ArrayList<String>();
        convo1.add("ABC");
        convo1.add("KLM");
        convo1.add("XYZ");

        List<String> convo2 = new ArrayList<String>();
        convo2.add("123");
        convo2.add("787");
        convo2.add("456");

        List<String> convo3 = new ArrayList<String>();
        convo3.add("ABC123");
        convo3.add("KLM787");
        convo3.add("XYZ456");

        messages.put(convo.get(0), convo1);
        messages.put(convo.get(1), convo2);
        messages.put(convo.get(2), convo3);
    }
}
