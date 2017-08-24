package com.example.vaibhav.googlemaps;

import android.app.AlertDialog;
import android.database.Cursor;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import com.example.vaibhav.googlemaps.R;

/**
 * Created by Vaibhav on 12/10/2015.
 */
public class MainActivity extends AppCompatActivity {
    Table myDb;
    EditText editName,editPhone;
    Button btnAddData;
    Button btnRetrive;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);
        myDb = new Table(this);

        editName = (EditText)findViewById(R.id.editText_name);
        editPhone = (EditText) findViewById(R.id.editText2_phone);
        btnAddData = (Button) findViewById(R.id.button_add);
        btnRetrive = (Button) findViewById(R.id.retrive);

        AddData();
        viewAll();
    }

    public void AddData(){
        btnAddData.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if(editPhone.getText()==null||editName.getText()==null){
                            Toast.makeText(MainActivity.this, "Please enter Name and PhoneNumber!", Toast.LENGTH_LONG).show();

                        }else {
                            boolean isInserted = myDb.insertData(editName.getText().toString(),
                                    editPhone.getText().toString());
                            if (isInserted = true)
                                Toast.makeText(MainActivity.this, "Data Inserted", Toast.LENGTH_LONG).show();
                            else
                                Toast.makeText(MainActivity.this, "Data Not Inserted", Toast.LENGTH_LONG).show();
                        }


                    }


                }
        );
    }

    public void viewAll(){
        btnRetrive.setOnClickListener(
                new View.OnClickListener(){
                    @Override
                    public void onClick(View v){
                        Cursor result = myDb.getRetriveData();
                        if(result.getCount() == 0){
                            // Show Mesage
                            showMessage("Error","No Data Found");
                            return;
                        }

                        StringBuffer buffer = new StringBuffer();
                        while(result.moveToNext())  {
                            buffer.append("Name :" +result.getString(0)+"\n");
                            buffer.append("Phone :" +result.getString(1)+"\n\n");

                        }
                        // Show All Data
                        showMessage("Data",buffer.toString());
                    }
                }
        );
    }

    public void showMessage(String title,String Message){           // I have make T capital of Title
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setCancelable(true);
        builder.setTitle(title);
        builder.setMessage(Message);
        builder.show();


    }



}
