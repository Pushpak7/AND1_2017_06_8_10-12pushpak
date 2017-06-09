package com.example.intentandintentfilters;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void onOkay(View view){

        allApps();
    }



    private void our() {
                Intent intent = new Intent();
                intent.setAction("com.codekul.action.RED");
                intent.addCategory("com.codekul.category.RGB");
                intent.setData(Uri.parse("http://codekul.com"));
                startActivity(intent);
            }

            private void allApps() {
                Intent intent = new Intent();
                intent.setAction(Intent.ACTION_MAIN);
                intent.addCategory(Intent.CATEGORY_LAUNCHER);
                startActivity(intent);
            }

            private void dialpad() {
                Intent intent = new Intent(Intent.ACTION_DIAL);
                startActivity(intent);
          }

            private void call() {
                Intent intent = new Intent(Intent.ACTION_CALL);
                intent.setData(Uri.parse("tel://9422148799"));

                        if (ActivityCompat.checkSelfPermission(this,
                               Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
                        return;
                   }
                startActivity(intent);
           }

            private void view() {
                Intent intent = new Intent(Intent.ACTION_VIEW);
                intent.setData(Uri.parse("http://codekul.com"));
                startActivity(intent);
            }

}
