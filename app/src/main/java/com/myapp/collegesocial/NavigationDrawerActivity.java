package com.myapp.collegesocial;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import com.google.android.material.navigation.NavigationView;
import com.myapp.collegesocial.ui.aboutus.AboutUsFragment;
import com.myapp.collegesocial.ui.gallery.GalleryFragment;
import com.myapp.collegesocial.ui.home.HomeFragment;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.core.view.GravityCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

public class NavigationDrawerActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    NavigationView navigationView;
    DrawerLayout drawerLayout;
    TextView name, email;
    private String strEmail;
    private String strPassword;
    private String strName;
    View header;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_navigation_drawer);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        navigationView = findViewById(R.id.nav_view);
        drawerLayout = findViewById(R.id.drawer_layout);
        header = navigationView.getHeaderView(0);
        name = header.findViewById(R.id.tv_name_nav);
        email = header.findViewById(R.id.tv_email_nav);


        SharedPreferences sharedPreferences = getSharedPreferences("MYAPP", MODE_PRIVATE);
        strName = sharedPreferences.getString("KEY_Name", "");
        strEmail = sharedPreferences.getString("KEY_Email", "");
        strPassword = sharedPreferences.getString("KEY_Password", "");
        name.setText(strName);
        email.setText(strEmail);


        ActionBarDrawerToggle actionBarDrawerToggle = new ActionBarDrawerToggle(this, drawerLayout,
                toolbar, R.string.nav_app_bar_open_drawer_description,
                R.string.nav_app_bar_open_drawer_description);
        drawerLayout.addDrawerListener(actionBarDrawerToggle);
        actionBarDrawerToggle.syncState();


        navigationView.setNavigationItemSelectedListener(this);
        HomeFragment fragment = new HomeFragment();
        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.frame, fragment);
        fragmentTransaction.commit();

    }


    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
        int id = menuItem.getItemId();

        Fragment fragment = null;
        if (id == R.id.nav_home) {
            fragment = new HomeFragment();

        } else if (id == R.id.nav_colleges) {

            fragment = new GalleryFragment();
        } else if (id == R.id.nav_about_us) {
            fragment = new AboutUsFragment();

        } else if (id == R.id.nav_logout) {

            SharedPreferences sharedPreferences = getSharedPreferences("MYAPP", MODE_PRIVATE);
            SharedPreferences.Editor editor = sharedPreferences.edit();
            editor.remove("KEY_Name");
            editor.remove("KEY_Email");
            editor.remove("KEY_Password");
            editor.apply();


            Intent i = new Intent(NavigationDrawerActivity.this, LoginActivity.class);
            startActivity(i);
            finish();
        }

        if (fragment != null) {


            FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
            fragmentTransaction.replace(R.id.frame, fragment);
            fragmentTransaction.commit();

        }
        drawerLayout.closeDrawer(GravityCompat.START);
        return true;

    }
}