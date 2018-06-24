package xyz.ceberus.sampleappilcation;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

public class ViewDataActivity extends AppCompatActivity {

    TextView textViewName;
    TextView textViewPassword;
    TextView textViewLocation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_data);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);


        initLayout();
    }

    private void initLayout() {
        Intent intent = getIntent();
        String strName = intent.getStringExtra("name");
        String strPassword = intent.getStringExtra("password");
        String strLocation = intent.getStringExtra("location");

        textViewName = (TextView)findViewById(R.id.textViewName);
        textViewPassword = (TextView)findViewById(R.id.textViewPassword);
        textViewLocation = (TextView)findViewById(R.id.textViewLocation);

        textViewName.setText(strName);
        textViewPassword.setText(strPassword);
        textViewLocation.setText(strLocation);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            // Respond to the action bar's Up/Home button
            case android.R.id.home:
                finish();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        return true;
    }
}
