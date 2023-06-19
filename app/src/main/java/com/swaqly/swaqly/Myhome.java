package com.swaqly.swaqly;

import android.os.Bundle;
import android.widget.GridView;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import com.swaqly.swaqly.databinding.ActivityMyhomeBinding;

import java.util.ArrayList;

public class Myhome extends AppCompatActivity {

    private ActivityMyhomeBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityMyhomeBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        BottomNavigationView navView = findViewById(R.id.nav_view);
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        AppBarConfiguration appBarConfiguration = new AppBarConfiguration.Builder(
                R.id.navigation_home, R.id.navigation_dashboard, R.id.navigation_notifications)
                .build();
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_activity_myhome);
        NavigationUI.setupActionBarWithNavController(this, navController, appBarConfiguration);
        NavigationUI.setupWithNavController(binding.navView, navController);

        GridView coursesGV = findViewById(R.id.idGVcourses);
        ArrayList<CourseModel> courseModelArrayList = new ArrayList<CourseModel>();

        courseModelArrayList.add(new CourseModel("DSA",R.drawable.ic_launcher_background));
        courseModelArrayList.add(new CourseModel("JAVA", R.drawable.ic_launcher_background));
        courseModelArrayList.add(new CourseModel("C++", R.drawable.ic_launcher_background));
        courseModelArrayList.add(new CourseModel("Python", R.drawable.ic_launcher_background));
        courseModelArrayList.add(new CourseModel("Javascript", R.drawable.ic_launcher_background));
        courseModelArrayList.add(new CourseModel("DSA", R.drawable.ic_launcher_background));

        CourseGVAdapter adapter = new CourseGVAdapter(this, courseModelArrayList);
        coursesGV.setAdapter(adapter);
    }

}