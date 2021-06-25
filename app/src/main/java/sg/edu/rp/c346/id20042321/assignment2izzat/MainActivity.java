package sg.edu.rp.c346.id20042321.assignment2izzat;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    TextView tvWebsite;
    Button btnToItemList;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate (savedInstanceState);
        setContentView (R.layout.activity_main);
        tvWebsite = findViewById (R.id.tvWebsite);
        btnToItemList = findViewById (R.id.btnToItemList);
        setTitle ("Item Organizer!");

        tvWebsite.setOnClickListener (new View.OnClickListener () {
            public void onClick(View v) {
                Intent intent = new Intent (Intent.ACTION_VIEW, Uri.parse (("https://github.com/IzzatZahirin?tab=repositories")));
                startActivity (intent);
            }
        });

        btnToItemList.setOnClickListener (new View.OnClickListener () {
            public void onClick(View v) {
                Intent intent=new Intent(MainActivity.this,ItemListActivity.class);
                startActivity (intent);
            }
        });
    }
}

