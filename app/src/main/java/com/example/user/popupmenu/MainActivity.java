package com.example.user.popupmenu;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.PopupMenu;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
   Button bt;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        bt = (Button) findViewById(R.id.button);

    }

    public void btonclick(View view) {
        PopupMenu popup=new PopupMenu(MainActivity.this,bt);
        popup.getMenuInflater().inflate(R.menu.pop, (Menu) popup.getMenu());
        popup.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                int id = item.getItemId();
                if (id == R.id.cam) {
                    Intent cameraIntent = new Intent(android.provider.MediaStore.ACTION_IMAGE_CAPTURE);

                    startActivity(cameraIntent);

                } else if (id == R.id.webb) {
                    Intent intent = new Intent();
                    intent.setAction(Intent.ACTION_VIEW);
                    intent.addCategory(Intent.CATEGORY_BROWSABLE);
                    intent.setData(Uri.parse("http://www.yourURL.com"));
                    startActivity(intent);

                } else if (id == R.id.phn) {
                    Intent i = new Intent(Intent.ACTION_DIAL);

                    startActivity(i);

                }
                else if(id==R.id.sms)

                {
               //     String phoneNumber = "+880xxxxxxxxxx";

                    Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("sms:" ));

                    startActivity(intent);

                }
               return false;
            }
            });popup.show();
        }
}

