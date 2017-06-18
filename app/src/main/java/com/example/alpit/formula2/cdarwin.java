package com.example.alpit.formula2;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.webkit.WebView;
import android.widget.Toast;

public class cdarwin extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener{

    private DrawerLayout drawerLayout;
    private NavigationView navigationView;
    private ActionBarDrawerToggle phy_law_toggel;
    private Toolbar toolbar;
    private WebView webView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cdarwin);
        setTitle(R.string.Cdarawin);
        drawerLayout = (DrawerLayout) findViewById(R.id.phy_draw);

        phy_law_toggel = new ActionBarDrawerToggle(this, drawerLayout, R.string.open, R.string.Close);
        navigationView = (NavigationView) findViewById(R.id.nav_view_phy);
        navigationView.setNavigationItemSelectedListener(this);
        drawerLayout.addDrawerListener(phy_law_toggel);
        Toolbar toolbar = (Toolbar) findViewById(R.id.phy_lawtoolbar);
        setSupportActionBar(toolbar);
        phy_law_toggel.syncState();
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        navigationView.setItemIconTintList(null);
        webView = (WebView) findViewById(R.id.phy_law_web);
        webView.getSettings().setJavaScriptEnabled(true);
        webView.getSettings().setBuiltInZoomControls(true);
        webView.loadUrl("file:///android_asset/mathscribe/cdarwin.html");
    }
@Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (phy_law_toggel.onOptionsItemSelected(item)) {
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
