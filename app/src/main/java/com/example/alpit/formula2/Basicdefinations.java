package com.example.alpit.formula2;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.webkit.WebView;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.Toast;

public class Basicdefinations extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener,CompoundButton.OnCheckedChangeListener{
    private DrawerLayout gdrawerLayout;
    private NavigationView gnavigationView;
    private ActionBarDrawerToggle gravity_law_toggel;
    private Toolbar gtoolbar;
    private WebView gwebView;
    private CheckBox checkBox12;
    private DataBaseHandler db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_basicdefinations);
        Toolbar toolbar = (Toolbar) findViewById(R.id.gravity_lawtoolbar);
        setSupportActionBar(toolbar);
        setTitle("");
        gdrawerLayout = (DrawerLayout) findViewById(R.id.gravity_draw);
        gnavigationView = (NavigationView) findViewById(R.id.nav_view_gravity);
        gravity_law_toggel = new ActionBarDrawerToggle(this, gdrawerLayout, R.string.open, R.string.Close);
        gnavigationView.setNavigationItemSelectedListener(this);

        gnavigationView.setNavigationItemSelectedListener(this);
        gdrawerLayout.addDrawerListener(gravity_law_toggel);
        gtoolbar = (Toolbar) findViewById(R.id.gravity_lawtoolbar);
        setSupportActionBar(toolbar);
        checkBox12 = (CheckBox) findViewById(R.id.fav1);
        checkBox12.setChecked(getAsp("checkbox45"));
        checkBox12.setOnCheckedChangeListener(this);
        gravity_law_toggel.syncState();
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        gnavigationView.setItemIconTintList(null);
        gwebView = (WebView) findViewById(R.id.gravity_law_web);
        gwebView.getSettings().setJavaScriptEnabled(true);
        gwebView.getSettings().setBuiltInZoomControls(true);
        gwebView.loadUrl("file:///android_asset/mathscribe/def.html");
        db = new DataBaseHandler(this);
        FloatingActionButton floatingActionButton = (FloatingActionButton) findViewById(R.id.fab);
        floatingActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                gwebView.scrollTo(0, 0);
            }
        });
    }

    public boolean onOptionsItemSelected(MenuItem item) {
        if(gravity_law_toggel.onOptionsItemSelected(item)){
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
        gdrawerLayout.closeDrawer(GravityCompat.START);
        return true;
    }

    @Override
    public void onCheckedChanged(CompoundButton buttonView, boolean check45) {
        if (checkBox12.isChecked()) {

            saveInSp("checkbox45", check45);
            db.add_activity(this.getClass().getSimpleName());
        } else if (!checkBox12.isChecked()) {

            saveInSp("checkbox45", check45);
            db.del_activity(this.getClass().getSimpleName());
        }


    }
    private boolean getAsp(String key) {
        SharedPreferences sharedPreferences = getApplicationContext().getSharedPreferences("Alpit", android.content.Context.MODE_PRIVATE);
        return sharedPreferences.getBoolean(key,false);
    }

    private void saveInSp(String key, boolean value) {
        SharedPreferences sharedPreferences = getApplicationContext().getSharedPreferences("Alpit", android.content.Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putBoolean(key, value);
        editor.apply();
    }

}

