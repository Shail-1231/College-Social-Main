package com.myapp.collegesocial;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.GridView;

import java.util.ArrayList;

public class HomeActivity extends AppCompatActivity {

    GridView gridView;
    String[] colleges = {"Ahmedabad University", "Nirma University", "LJ University", "PDPU"};
    int[] images = {R.drawable.aublur, R.drawable.nirmablur, R.drawable.ljblur, R.drawable.pdpublur};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        gridView = findViewById(R.id.grid);
        ArrayList<CollegeModel> collegeModelArrayList = new ArrayList<CollegeModel>();

        for(int i = 0; i < colleges.length; i++)
        {
            CollegeModel model = new CollegeModel(colleges[i], images[i]);
            collegeModelArrayList.add(model);
        }

        MyCollegeAdapter myCollegeAdapter = new MyCollegeAdapter(this, collegeModelArrayList);
        gridView.setAdapter(myCollegeAdapter);
    }
}