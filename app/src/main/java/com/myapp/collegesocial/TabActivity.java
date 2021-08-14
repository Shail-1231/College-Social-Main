package com.myapp.collegesocial;

import android.os.Build;
import android.os.Bundle;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.viewpager.widget.ViewPager;

import com.google.android.material.tabs.TabLayout;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class TabActivity extends AppCompatActivity {

    TabLayout tabLayout;
    ViewPager viewPager;
    DatabaseReference databaseReference;
    FirebaseDatabase firebaseDatabase;
    ArrayList<EventModel> eventModelsAU = new ArrayList<>();
    ArrayList<EventModel> eventModelsNirma = new ArrayList<>();
    ArrayList<EventModel> eventModelsLJ = new ArrayList<>();
    ArrayList<EventModel> eventModelsPDPU = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tab);

        tabLayout = findViewById(R.id.tab);
        viewPager = findViewById(R.id.view_pager);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        Bundle extras = getIntent().getExtras();
        String[] activities = extras.getStringArray("activities");
        for (String activity : activities) {
            tabLayout.addTab(tabLayout.newTab().setText(activity));
        }
        tabLayout.setTabGravity(TabLayout.GRAVITY_FILL);

        MyPagerAdapter myPagerAdapter = new MyPagerAdapter(getSupportFragmentManager(), tabLayout.getTabCount());
        viewPager.setAdapter(myPagerAdapter);
        tabLayout.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                viewPager.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
        viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));

        String collegeName = extras.getString("college_name");
        if (collegeName.equals("Ahmedabad University")) {

            firebaseDatabase = FirebaseDatabase.getInstance("https://college-social-43bc2-default-rtdb.firebaseio.com/");
            databaseReference = firebaseDatabase.getReference("1PFUayqO-uwNPcv-9ijlAvO8yauToDTv7tX2qsji1HX8").child("Au");
            Log.e("successful", "" + databaseReference);

            databaseReference.addValueEventListener(new ValueEventListener() {
                @RequiresApi(api = Build.VERSION_CODES.O)
                @Override
                public void onDataChange(@NonNull DataSnapshot snapshot) {

                    for (DataSnapshot snapshot1 : snapshot.getChildren()) {


                        String eventName = (String) snapshot1.child("eventName").getValue();
                        String category = (String) snapshot1.child("category").getValue();
                        Long contact = (Long) snapshot1.child("contact").getValue();
                        Long cost = (Long) snapshot1.child("cost").getValue();
                        String date = (String) snapshot1.child("date").getValue();
                        String eventDescription = (String) snapshot1.child("eventDescription").getValue();
                        String eventOrganiser = (String) snapshot1.child("eventOrganiser").getValue();
                        String registrationLink = (String) snapshot1.child("registrationLink").getValue();
                        String time = (String) snapshot1.child("time").getValue();
                        String venue = (String) snapshot1.child("venue").getValue();
                        String email = (String) snapshot1.child("email").getValue();

                        Log.e("eventname", eventName);
                        Log.e("time", time);
                        Log.e("category", category);

                        EventModel eventModel = new EventModel();
                        eventModel.setEventName(eventName);
                        eventModel.setCategory(category);
                        eventModel.setContact(contact);
                        eventModel.setCost(cost);
                        eventModel.setDate(date);
                        eventModel.setEventDescription(eventDescription);
                        eventModel.setEventOrganiser(eventOrganiser);
                        eventModel.setRegistrationLink(registrationLink);
                        eventModel.setTime(time);
                        eventModel.setVenue(venue);
                        eventModel.setEmail(email);
                        eventModelsAU.add(eventModel);
                    }

                }

                @Override
                public void onCancelled(@NonNull DatabaseError error) {

                }
            });


        }
        if (collegeName.equals("Nirma University")) {

            firebaseDatabase = FirebaseDatabase.getInstance("https://college-social-43bc2-default-rtdb.firebaseio.com/");
            databaseReference = firebaseDatabase.getReference("1PFUayqO-uwNPcv-9ijlAvO8yauToDTv7tX2qsji1HX8").child("Nirma");
            Log.e("successful", "" + databaseReference);

            databaseReference.addValueEventListener(new ValueEventListener() {
                @RequiresApi(api = Build.VERSION_CODES.O)
                @Override
                public void onDataChange(@NonNull DataSnapshot snapshot) {

                    for (DataSnapshot snapshot1 : snapshot.getChildren()) {


                        String eventName = (String) snapshot1.child("eventName").getValue();
                        String category = (String) snapshot1.child("category").getValue();
                        Long contact = (Long) snapshot1.child("contact").getValue();
                        Long cost = (Long) snapshot1.child("cost").getValue();
                        String date = (String) snapshot1.child("date").getValue();
                        String eventDescription = (String) snapshot1.child("eventDescription").getValue();
                        String eventOrganiser = (String) snapshot1.child("eventOrganiser").getValue();
                        String registrationLink = (String) snapshot1.child("registrationLink").getValue();
                        String time = (String) snapshot1.child("time").getValue();
                        String venue = (String) snapshot1.child("venue").getValue();
                        String email = (String) snapshot1.child("email").getValue();

                        Log.e("eventname", eventName);
                        Log.e("time", time);

                        EventModel eventModel = new EventModel();
                        eventModel.setEventName(eventName);
                        eventModel.setCategory(category);
                        eventModel.setContact(contact);
                        eventModel.setCost(cost);
                        eventModel.setDate(date);
                        eventModel.setEventDescription(eventDescription);
                        eventModel.setEventOrganiser(eventOrganiser);
                        eventModel.setRegistrationLink(registrationLink);
                        eventModel.setTime(time);
                        eventModel.setVenue(venue);
                        eventModel.setEmail(email);
                        eventModelsNirma.add(eventModel);


                    }
                }

                @Override
                public void onCancelled(@NonNull DatabaseError error) {

                }
            });


        }
        if (collegeName.equals("LJ University")) {

            firebaseDatabase = FirebaseDatabase.getInstance("https://college-social-43bc2-default-rtdb.firebaseio.com/");
            databaseReference = firebaseDatabase.getReference("1PFUayqO-uwNPcv-9ijlAvO8yauToDTv7tX2qsji1HX8").child("Nirma");
            Log.e("successful", "" + databaseReference);

            databaseReference.addValueEventListener(new ValueEventListener() {
                @RequiresApi(api = Build.VERSION_CODES.O)
                @Override
                public void onDataChange(@NonNull DataSnapshot snapshot) {

                    for (DataSnapshot snapshot1 : snapshot.getChildren()) {


                        String eventName = (String) snapshot1.child("eventName").getValue();
                        String category = (String) snapshot1.child("category").getValue();
                        Long contact = (Long) snapshot1.child("contact").getValue();
                        Long cost = (Long) snapshot1.child("cost").getValue();
                        String date = (String) snapshot1.child("date").getValue();
                        String eventDescription = (String) snapshot1.child("eventDescription").getValue();
                        String eventOrganiser = (String) snapshot1.child("eventOrganiser").getValue();
                        String registrationLink = (String) snapshot1.child("registrationLink").getValue();
                        String time = (String) snapshot1.child("time").getValue();
                        String venue = (String) snapshot1.child("venue").getValue();
                        String email = (String) snapshot1.child("email").getValue();

                        Log.e("eventname", eventName);
                        Log.e("time", time);

                        EventModel eventModel = new EventModel();
                        eventModel.setEventName(eventName);
                        eventModel.setCategory(category);
                        eventModel.setContact(contact);
                        eventModel.setCost(cost);
                        eventModel.setDate(date);
                        eventModel.setEventDescription(eventDescription);
                        eventModel.setEventOrganiser(eventOrganiser);
                        eventModel.setRegistrationLink(registrationLink);
                        eventModel.setTime(time);
                        eventModel.setVenue(venue);
                        eventModel.setEmail(email);
                        eventModelsLJ.add(eventModel);


                    }
                }

                @Override
                public void onCancelled(@NonNull DatabaseError error) {

                }
            });


        }
        if (collegeName.equals("PDPU")) {

            firebaseDatabase = FirebaseDatabase.getInstance("https://college-social-43bc2-default-rtdb.firebaseio.com/");
            databaseReference = firebaseDatabase.getReference("1PFUayqO-uwNPcv-9ijlAvO8yauToDTv7tX2qsji1HX8").child("Nirma");
            Log.e("successful", "" + databaseReference);

            databaseReference.addValueEventListener(new ValueEventListener() {
                @RequiresApi(api = Build.VERSION_CODES.O)
                @Override
                public void onDataChange(@NonNull DataSnapshot snapshot) {

                    for (DataSnapshot snapshot1 : snapshot.getChildren()) {


                        String eventName = (String) snapshot1.child("eventName").getValue();
                        String category = (String) snapshot1.child("category").getValue();
                        Long contact = (Long) snapshot1.child("contact").getValue();
                        Long cost = (Long) snapshot1.child("cost").getValue();
                        String date = (String) snapshot1.child("date").getValue();
                        String eventDescription = (String) snapshot1.child("eventDescription").getValue();
                        String eventOrganiser = (String) snapshot1.child("eventOrganiser").getValue();
                        String registrationLink = (String) snapshot1.child("registrationLink").getValue();
                        String time = (String) snapshot1.child("time").getValue();
                        String venue = (String) snapshot1.child("venue").getValue();
                        String email = (String) snapshot1.child("email").getValue();

                        Log.e("eventname", eventName);
                        Log.e("time", time);

                        EventModel eventModel = new EventModel();
                        eventModel.setEventName(eventName);
                        eventModel.setCategory(category);
                        eventModel.setContact(contact);
                        eventModel.setCost(cost);
                        eventModel.setDate(date);
                        eventModel.setEventDescription(eventDescription);
                        eventModel.setEventOrganiser(eventOrganiser);
                        eventModel.setRegistrationLink(registrationLink);
                        eventModel.setTime(time);
                        eventModel.setVenue(venue);
                        eventModel.setEmail(email);
                        eventModelsPDPU.add(eventModel);


                    }
                }

                @Override
                public void onCancelled(@NonNull DatabaseError error) {

                }
            });


        }

    }
}