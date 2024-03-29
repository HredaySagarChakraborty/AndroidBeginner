package comp.example.hreday.androidbeginner;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {


    private ViewPager viewPager;
    private TabLayout tabLayout;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        this.setTitle("MainActivity");


        viewPager = findViewById(R.id.viewPagerId);
        tabLayout = findViewById(R.id.tabId);
        TabPagerAdapter tabPagerAdapter = new TabPagerAdapter(getSupportFragmentManager());
        viewPager.setAdapter(tabPagerAdapter);
        tabLayout.setupWithViewPager(viewPager);




        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
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
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_camera) {
            // Handle the camera action
        } else if (id == R.id.nav_gallery) {

        } else if (id == R.id.nav_slideshow) {

        } else if (id == R.id.nav_manage) {

        } else if (id == R.id.nav_share) {

        } else if (id == R.id.nav_send) {

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }






    public void goThere(View view) {
        Intent intent = new Intent(MainActivity.this, FirebaseActivity1.class);
        startActivity(intent);


    }


    public void hiThere(View view) {
        Intent intent = new Intent(MainActivity.this, FirebaseActivity2.class);
        startActivity(intent);


    }


      public void goLayout(View view) {
        Intent intent = new Intent(MainActivity.this, FirebaseActivity3.class);
        startActivity(intent);


    }


    public void goWidget(View view) {
        Intent intent = new Intent(MainActivity.this, FirebaseActivity4.class);
        startActivity(intent);


    }


    public void goFragments(View view) {
        Intent intent = new Intent(MainActivity.this, FirebaseActivity5.class);
        startActivity(intent);


    }



    public void goService(View view) {
        Intent intent = new Intent(MainActivity.this, FirebaseActivity6.class);
        startActivity(intent);


    }


    public void goMenu(View view) {
        Intent intent = new Intent(MainActivity.this, FirebaseActivity7.class);
        startActivity(intent);


    }


    public void goContainer(View view) {
        Intent intent = new Intent(MainActivity.this, FirebaseActivity8.class);
        startActivity(intent);


    }

    public void  goStorage(View view) {
        Intent intent = new Intent(MainActivity.this, FirebaseActivity9.class);
        startActivity(intent);


    }


    public void goSqlite(View view) {
        Intent intent = new Intent(MainActivity.this, FirebaseActivity10.class);
        startActivity(intent);


    }










}
