package com.tinypawz.activity;

import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.content.ContextCompat;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.Window;
import android.view.WindowManager;

import com.tinypawz.R;
import com.tinypawz.fragment.HomeFragment;
import com.tinypawz.fragment.LoginFragment;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {
    private static final String TAG = MainActivity.class.getSimpleName();
    private NavigationView _navigationView;
    private DrawerLayout _drawerLayout;
    private FragmentManager _fragmentManager;
    private HomeFragment _homeFragment;
    private LoginFragment _loginFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        _drawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, _drawerLayout, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        _drawerLayout.addDrawerListener(toggle);
        toggle.syncState();

        _fragmentManager = getSupportFragmentManager();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        // set default -- launch home fragment
        navigationView.setCheckedItem(R.id.nav_home);
        if (_homeFragment == null) {
            _homeFragment = new HomeFragment();
        }
        FragmentTransaction fragmentTransaction = _fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.fl_container, _homeFragment);
        fragmentTransaction.commit();

        Window window = getWindow();
        window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
        window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
        window.setStatusBarColor(ContextCompat.getColor(this, android.R.color.holo_orange_dark));
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        Log.d(TAG, "onNavigationItemSelected");
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_home) {
            showHomeFragment();
        } else if (id == R.id.nav_login) {
            showLoginFragment();
        } else if (id == R.id.nav_share) {

        } else if (id == R.id.nav_about_us) {

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    // show fragments on navigation
    private void showHomeFragment() {
        if (_homeFragment == null) {
            _homeFragment = new HomeFragment();
        }
        FragmentTransaction fragmentTransaction = _fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.fl_container, _homeFragment);
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commit();
    }

    private void showLoginFragment() {
        if (_loginFragment == null) {
            _loginFragment = new LoginFragment();
        }
        FragmentTransaction fragmentTransaction = _fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.fl_container, _loginFragment);
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commit();
    }
}
