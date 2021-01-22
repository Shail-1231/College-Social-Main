package com.myapp.collegesocial;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
;

import java.util.ArrayList;

public class MyCollegeAdapter extends BaseAdapter {

    Context context;
    ArrayList<CollegeModel> collegeModelArrayList;

    public MyCollegeAdapter(Context context, ArrayList<CollegeModel> collegeModelArrayList) {
        this.context = context;
        this.collegeModelArrayList = collegeModelArrayList;
    }

    @Override
    public int getCount() {
        return collegeModelArrayList.size();
    }

    @Override
    public Object getItem(int position) {
        return collegeModelArrayList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @SuppressLint("ViewHolder")
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        LayoutInflater layoutInflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        convertView = layoutInflater.inflate(R.layout.raw_college_list, null);

        TextView collegeName = convertView.findViewById(R.id.tv_college_name);
        ImageView imgCollege = convertView.findViewById(R.id.img_college);

        collegeName.setText(collegeModelArrayList.get(position).getCollegeName());
        imgCollege.setImageResource(collegeModelArrayList.get(position).getCollegeImage());

        return convertView;
    }
}
