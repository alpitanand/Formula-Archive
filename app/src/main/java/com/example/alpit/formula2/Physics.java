package com.example.alpit.formula2;

import android.content.Intent;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.widget.Toast;

public class Physics extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener{
private DrawerLayout mpDrawerLayout;
    private Toolbar toolbar;
    private ActionBarDrawerToggle aToggle;
    private RecyclerView recyclerView;
    private Physics_recycler physics_recycler;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_physics);
        mpDrawerLayout = (DrawerLayout) findViewById(R.id.drawer1);
        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view1);
        aToggle = new ActionBarDrawerToggle(this, mpDrawerLayout, R.string.open, R.string.Close);
        navigationView.setNavigationItemSelectedListener(this);
        mpDrawerLayout.addDrawerListener(aToggle);
        toolbar = (Toolbar) findViewById(R.id.nav_action1);
        setSupportActionBar(toolbar);
        setTitle(R.string.Physicss);

        recyclerView = (RecyclerView) findViewById(R.id.recycler);
        physics_recycler = new Physics_recycler(getApplicationContext());
        final LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(physics_recycler);
        aToggle.syncState();
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        navigationView.setItemIconTintList(null);
    }

@Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if(aToggle.onOptionsItemSelected(item)){
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
        mpDrawerLayout.closeDrawer(GravityCompat.START);
        return true;
    }


}
