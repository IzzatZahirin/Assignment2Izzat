package sg.edu.rp.c346.id20042321.assignment2izzat;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class ItemListActivity extends AppCompatActivity {
    EditText etItem, etItemDate;
    Button btnAdd, btnDelete, btnUpdate;
    ListView lvActivity;

    ArrayList<String> arrayList;
    ArrayAdapter<String> arrayAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate (savedInstanceState);
        setContentView (R.layout.item_list_activity);
        etItem = findViewById (R.id.etItem);
        etItemDate = findViewById (R.id.etItemDate);
        btnAdd = findViewById (R.id.buttonAddItem);
        btnDelete = findViewById (R.id.buttonDeleteItem);
        btnUpdate = findViewById (R.id.buttonUpdateItem);
        lvActivity = findViewById (R.id.listViewItem);
        setTitle ("Item Organizer!");

        arrayList = new ArrayList<> ();
        arrayAdapter = new ArrayAdapter<> (this, android.R.layout.simple_list_item_1, arrayList);
        lvActivity.setAdapter (arrayAdapter);

        btnAdd.setOnClickListener (new View.OnClickListener () {
            @Override
            public void onClick(View v) {
                String newItem = etItem.getText ().toString ();
                int date = Integer.parseInt (etItemDate.getText().toString ());
                arrayList.add(date, newItem);
                arrayAdapter.notifyDataSetChanged ();
                etItem.setText ("");
                Toast.makeText(ItemListActivity.this,"Item Added Successfully!",Toast.LENGTH_LONG).show();
            }
        });

        btnDelete.setOnClickListener (new View.OnClickListener () {
            @Override
            public void onClick(View v) {
                arrayList.clear ();
                arrayAdapter.notifyDataSetChanged ();
                Toast.makeText(ItemListActivity.this,"Item Deleted Successfully!",Toast.LENGTH_LONG).show();
            }
        });


        btnUpdate.setOnClickListener (new View.OnClickListener () {
            @Override
            public void onClick(View v) {
                int date = Integer.parseInt (etItemDate.getText ().toString ());
                String updateItem = etItem.getText ().toString ();
                arrayList.set(date, updateItem);
                arrayAdapter.notifyDataSetChanged ();
                Toast.makeText(ItemListActivity.this,"Item Updated Successfully!",Toast.LENGTH_LONG).show();
            }
        });
    }
}
