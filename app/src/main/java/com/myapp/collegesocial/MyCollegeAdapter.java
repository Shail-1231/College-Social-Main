package com.myapp.collegesocial;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class MyCollegeAdapter extends BaseAdapter {

    Context context;
    ArrayList<CollegeModel> collegeModelArrayList;
    String[] college;


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

        LayoutInflater layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        convertView = layoutInflater.inflate(R.layout.raw_college_list, null);

        TextView collegeName = convertView.findViewById(R.id.tv_college_name);
        ImageView imgCollege = convertView.findViewById(R.id.img_college);

        collegeName.setText(collegeModelArrayList.get(position).getCollegeName());
        imgCollege.setImageResource(collegeModelArrayList.get(position).getCollegeImage());

        convertView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (position == 0) {
                    college = new String[]{"Art and Culture", "Sports and Fitness", "Technical and Management", "Extra"};
                    Intent i = new Intent(context, TabActivity.class);
                    i.putExtra("activities", college);
                    i.putExtra("college_name", "Ahmedabad University");
                    context.startActivity(i);
                } else if (position == 1) {
                    college = new String[]{"Art and culture", "Sports and fitness"};
                    Intent i = new Intent(context, TabActivity.class);
                    i.putExtra("activities", college);
                    i.putExtra("college_name", "Nirma University");
                    context.startActivity(i);
                } else if (position == 2) {
                    college = new String[]{"Art and culture", "Sports and Adventure"};
                    Intent i = new Intent(context, TabActivity.class);
                    i.putExtra("activities", college);
                    i.putExtra("college_name", "LJ University");
                    context.startActivity(i);
                } else if (position == 3) {
                    college = new String[]{"Social and Culture", "Sciences and Technical", "Sports Club"};
                    Intent i = new Intent(context, TabActivity.class);
                    i.putExtra("activities", college);
                    i.putExtra("college_name", "PDPU");
                    context.startActivity(i);
                }
            }
        });
        return convertView;
    }
}
