package com.myapp.collegesocial.ui.home;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.myapp.collegesocial.CollegeModel;
import com.myapp.collegesocial.MyCollegeAdapter;
import com.myapp.collegesocial.R;
import com.myapp.collegesocial.SliderAdp;
import com.smarteist.autoimageslider.IndicatorView.animation.type.IndicatorAnimationType;
import com.smarteist.autoimageslider.SliderAnimations;
import com.smarteist.autoimageslider.SliderView;

import java.util.ArrayList;

public class HomeFragment extends Fragment {
    GridView gridView;
    String[] colleges = {"Ahmedabad University", "Nirma University", "LJ University", "PDPU"};
    int[] blurImages = {R.drawable.aublur, R.drawable.nirmablur, R.drawable.ljblur, R.drawable.pdpublur};
    SliderView sliderView;
    int[] mainEventImages = {R.drawable.convocation, R.drawable.ingenium};
    SliderAdp sliderAdp;


    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        View root = inflater.inflate(R.layout.activity_home, container, false);

        sliderView = root.findViewById(R.id.slider_view);

        sliderAdp = new SliderAdp(mainEventImages);

        sliderView.setSliderAdapter(sliderAdp);

        sliderView.setIndicatorAnimation(IndicatorAnimationType.WORM);

        sliderView.setSliderTransformAnimation(SliderAnimations.DEPTHTRANSFORMATION);

        sliderView.startAutoCycle();

        gridView = root.findViewById(R.id.grid);
        ArrayList<CollegeModel> collegeModelArrayList = new ArrayList<>();

        for (int i = 0; i < colleges.length; i++) {
            CollegeModel model = new CollegeModel(colleges[i], blurImages[i]);
            collegeModelArrayList.add(model);
        }

        MyCollegeAdapter myCollegeAdapter = new MyCollegeAdapter(getActivity(), collegeModelArrayList);
        gridView.setAdapter(myCollegeAdapter);

        return root;
    }
}