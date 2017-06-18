package com.example.alpit.formula2;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.support.v4.view.ViewPager;
import android.view.MenuItem;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;


public class Triangle extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener{
    private DrawerLayout mDrawerLayout;
    private ActionBarDrawerToggle mtoggle;
    private NavigationView navigationView;
    private DrawerLayout drawerLayout;
    private ActionBarDrawerToggle unit_toggle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_triangle);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        setTitle(R.string.Triangle);
        ViewPager viewPager = (ViewPager) findViewById(R.id.viewpager);
        setupViewPager(viewPager);
        TabLayout tabs = (TabLayout) findViewById(R.id.tabs);
        tabs.setupWithViewPager(viewPager);

        drawerLayout = (DrawerLayout) findViewById(R.id.unit_drawerlayout);
        navigationView = (NavigationView) findViewById(R.id.unit_view);
        unit_toggle = new ActionBarDrawerToggle(this, drawerLayout, R.string.open, R.string.Close);
        drawerLayout.addDrawerListener(unit_toggle);
        navigationView.setNavigationItemSelectedListener(this);
        unit_toggle.syncState();
        navigationView.setItemIconTintList(null);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        navigationView.setItemIconTintList(null);



    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (unit_toggle.onOptionsItemSelected(item)) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        int id=item.getItemId();
        if(id==R.id.favourite)
        {
            startActivity(new Intent(getApplicationContext(),FavoritePage.class));
        }
        else if (id == R.id.nav_maths) {
            startActivity(new Intent(getApplicationContext(), Maths.class));
        }
        else if (id == R.id.nav_physics) {
            startActivity(new Intent(getApplicationContext(), Physics.class));
        }
        else if (id == R.id.nav_chem) {
            startActivity(new Intent(getApplicationContext(), Chemistry.class));
        }
        else if (id == R.id.EEE) {
            startActivity(new Intent(getApplicationContext(), Electrical.class));
        }
        else if (id == R.id.unitconversion) {
            startActivity(new Intent(getApplicationContext(), Unitconversion.class));
        }
        else if (id == R.id.Scientist) {
            startActivity(new Intent(getApplicationContext(), Scientist.class));
        }
        else if (id == R.id.Share) {
            Toast.makeText(getApplication().getApplicationContext(),"Will be available in the next update",Toast.LENGTH_LONG).show();
        }
        else if (id == R.id.ads) {
            Toast.makeText(getApplication().getApplicationContext(),"Will be available in the next update",Toast.LENGTH_LONG).show();
        }
        else if (id == R.id.aboutus) {
            startActivity(new Intent(getApplicationContext(), Aboutus.class));
        }
        drawerLayout.closeDrawer(GravityCompat.START);
        return true;
    }

    public void setupViewPager(ViewPager viewPager) {
        Adapter adapter = new Adapter(getSupportFragmentManager());
        adapter.addFragment(new Trianglearea(), "Area");
        adapter.addFragment(new Triangleperimeter(), "Perimeter");
        viewPager.setAdapter(adapter);
    }
    static class Adapter extends FragmentPagerAdapter {
        private final List<Fragment> mfraglist = new ArrayList<>();
        private final List<String> mfragtitlelist = new ArrayList<>();

        public Adapter(FragmentManager manager) {
            super(manager);
        }

        @Override
        public Fragment getItem(int position) {
            return mfraglist.get(position);
        }

        @Override
        public int getCount() {
            return mfraglist.size();
        }

        public void addFragment(Fragment fragment, String title) {
            mfraglist.add(fragment);
            mfragtitlelist.add(title);
        }


        @Override
        public CharSequence getPageTitle(int position) {
            return mfragtitlelist.get(position);
        }
    }


}