package com.silo.silo_app;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.NavigationUI;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final NavController controller = Navigation.findNavController(this, R.id.nav_host_fragment);
        BottomNavigationView bottomBar = findViewById(R.id.bottom_navigation);
        NavigationUI.setupWithNavController(bottomBar, controller);

//        bottomBar.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
//            @Override
//            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
//                switch (item.getItemId()) {
//                    case R.id.menu_1:
//                        controller.navigate(R.id.action_profileFragment_to_mainFragment);
//                        break;
//                    case R.id.menu_2:
//                        controller.navigate(R.id.action_mainFragment_to_profileFragment);
//                }
//                return true;
//            }
//        });
    }
}
