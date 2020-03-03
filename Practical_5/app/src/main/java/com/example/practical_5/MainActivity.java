package com.example.practical_5;

import android.content.Intent;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    public static final String EXTRA_MESSAGE =
            "com.example.practical_5.extra.MESSAGE";
    public static String mOrderMessage = "";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        switch (item.getItemId()) {
            case R.id.action_order:
                Intent intent = new Intent(MainActivity.this, OrderActivity.class);
                intent.putExtra(EXTRA_MESSAGE, mOrderMessage);
                startActivity(intent);
                return true;
            case R.id.action_status:
                displayToast(getString(R.string.action_status_message));
                return true;
            case R.id.action_favorites:
                displayToast(getString(R.string.action_favorites_message));
                return true;
            case R.id.action_contacts:
                displayToast(getString(R.string.action_contact_message));
                return true;
            default:
        }

        return super.onOptionsItemSelected(item);
    }

    public void displayToast(String message) {
        Toast.makeText(getApplicationContext(), message,
                Toast.LENGTH_SHORT).show();
    }


    public void show_Order(View view){
        switch (view.getId()){
            case R.id.t1:
                mOrderMessage = mOrderMessage +"\n"+ getString(R.string.t1_order);
                displayToast(getString(R.string.t1_order));
                break;
            case R.id.t2:
                mOrderMessage = mOrderMessage +"\n"+ getString(R.string.t2_order);
                displayToast(getString(R.string.t2_order));
                break;
            case R.id.t3:
                mOrderMessage = mOrderMessage +"\n"+ getString(R.string.t3_order);
                displayToast(getString(R.string.t3_order));
                break;
            case R.id.t4:
                mOrderMessage = mOrderMessage +"\n"+ getString(R.string.t4_order);
                displayToast(getString(R.string.t4_order));
                break;
        }
    }


    public void Order(View view) {
        Intent intent = new Intent(MainActivity.this, OrderActivity.class);
        intent.putExtra(EXTRA_MESSAGE, mOrderMessage);
        startActivity(intent);
    }
}
