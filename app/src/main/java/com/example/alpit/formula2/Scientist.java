package com.example.alpit.formula2;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.widget.Toast;

public class Scientist extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener{

    private DrawerLayout drawerLayout;
    private Toolbar toolbar;
    private RecyclerView recyclerView;
    private ActionBarDrawerToggle actionBarDrawerToggle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scientist);
        drawerLayout = (DrawerLayout) findViewById(R.id.activity_scientist);
        actionBarDrawerToggle = new ActionBarDrawerToggle(this, drawerLayout, R.string.open, R.string.Close);
        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view1);
        navigationView.setNavigationItemSelectedListener(this);
        drawerLayout.addDrawerListener(actionBarDrawerToggle);
        setTitle(R.string.Scientist);
        toolbar = (Toolbar) findViewById(R.id.science_tool);
        setSupportActionBar(toolbar);
        actionBarDrawerToggle.syncState();
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        navigationView.setItemIconTintList(null);
        recyclerView = (RecyclerView) findViewById(R.id.science_recycler);
        Science_recycler science_recycler = new Science_recycler(getApplicationContext());
        recyclerView.setAdapter(science_recycler);
        final LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(layoutManager);

    }
    public boolean onOptionsItemSelected(MenuItem item) {
        if (actionBarDrawerToggle.onOptionsItemSelected(item)) {
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
}
