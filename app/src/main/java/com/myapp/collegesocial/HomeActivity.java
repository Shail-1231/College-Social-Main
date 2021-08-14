package com.myapp.collegesocial;

import android.os.Bundle;
import android.widget.GridView;

import androidx.appcompat.app.AppCompatActivity;

import com.smarteist.autoimageslider.IndicatorView.animation.type.IndicatorAnimationType;
import com.smarteist.autoimageslider.SliderAnimations;
import com.smarteist.autoimageslider.SliderView;

import java.util.ArrayList;

public class HomeActivity extends AppCompatActivity {

    GridView gridView;
    String[] colleges = {"Ahmedabad University", "Nirma University", "LJ University", "PDPU"};
    int[] blurImages = {R.drawable.aublur, R.drawable.nirmablur, R.drawable.ljblur, R.drawable.pdpublur};
    SliderView sliderView;
    int[] mainEventImages = {R.drawable.convocation, R.drawable.ingenium};
    SliderAdp sliderAdp;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        sliderView = findViewById(R.id.slider_view);

        sliderAdp = new SliderAdp(mainEventImages);

        sliderView.setSliderAdapter(sliderAdp);

        sliderView.setIndicatorAnimation(IndicatorAnimationType.WORM);

        sliderView.setSliderTransformAnimation(SliderAnimations.DEPTHTRANSFORMATION);

        sliderView.startAutoCycle();

        gridView = findViewById(R.id.grid);
        ArrayList<CollegeModel> collegeModelArrayList = new ArrayList<>();

        for (int i = 0; i < colleges.length; i++) {
            CollegeModel model = new CollegeModel(colleges[i], blurImages[i]);
            collegeModelArrayList.add(model);
        }

        MyCollegeAdapter myCollegeAdapter = new MyCollegeAdapter(this, collegeModelArrayList);
        gridView.setAdapter(myCollegeAdapter);

    }
}