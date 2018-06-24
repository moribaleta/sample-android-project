package xyz.ceberus.sampleappilcation;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

public class FormActivity extends AppCompatActivity {
    Context context;
    Spinner spinner;
    EditText editName;
    EditText editPassword;
    Button btnSave;

    String arrStrLocation[] = {
            "Manila","Makati","Marikina","Quezon City"
            , "Pasig","Muntinlupa","Pateros","Caloocan","Malabon","Valenzuela",
            "Las Pinas","Pasay","Mandaluyong","San Juan"
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_form);
        context = getBaseContext();
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        initLayout();
        initData();
        initData();
    }

    private void initLayout() {
        editName = (EditText)findViewById(R.id.editTextName);
        editPassword = (EditText)findViewById(R.id.editTextPassword);
        spinner = (Spinner)findViewById(R.id.spinner);
        btnSave = (Button)findViewById(R.id.btnSave);
        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String strName = editName.getText().toString();
                String strPassword = editPassword.getText().toString();
                String strLocation = spinner.getSelectedItem().toString();
                Intent intent = new Intent(FormActivity.this,ViewDataActivity.class);
                intent.putExtra("name",strName);
                intent.putExtra("password",strPassword);
                intent.putExtra("location",strLocation);
                startActivity(intent);
                finish();
            }
        });
    }

    private void initData() {
        ArrayAdapter<String>arrayAdapter = new ArrayAdapter<String>(context,android.R.layout.simple_list_item_1,arrStrLocation );
        spinner.setAdapter(arrayAdapter);
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
