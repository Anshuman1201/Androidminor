package com.example.healthcare;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import java.util.ArrayList;
import java.util.HashMap;

public class LabTestActivity extends AppCompatActivity {
private String[][] packages={
        {"Package 1 : Full Body  Checkup","","","9923492342","999"},
        {"Package 2 : Blood Glucose Fasting","","","9923492342","299"},
        {"Package 3 : COVID-19 Antibody","","","9923492342","999"},
        {"Package 4 : Thyroid Check","","","9923492342","499"},
        {"Package 5 : Immunity","","","9923492342","699"}
};

HashMap<String ,String> item;
ArrayList list;
SimpleAdapter sa;
Button btnBack;
ListView listView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lab_test);

        btnBack=findViewById(R.id.buttonODBack);
       listView=findViewById(R.id.listViewOD);

       btnBack.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {
               startActivity(new Intent(LabTestActivity.this,HomeActivity.class));
           }
       });
list=new ArrayList();
for(int i=0;i<packages.length;i++){
    item=new HashMap<String,String>();
    item.put("line1",packages[i][0]);
    item.put("line2",packages[i][1]);
    item.put("line3",packages[i][2]);
    item.put("line4","Mobile No :"+packages[i][3]);
    item.put("line5","Total Cost"+packages[i][4]+"/-");
list.add(item);
}

        sa=new SimpleAdapter(this,list,
                R.layout.multi_lines,
                new String[]{"line1","line2","line3","line4","line5"},
                new int[]{R.id.line_a,R.id.line_b,R.id.line_c,R.id.line_d,R.id.line_e}
        );
        listView.setAdapter(sa);



        }
}
