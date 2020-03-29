package com.example.newoptinav;

import androidx.appcompat.app.AppCompatActivity;

import android.Manifest;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.gun0912.tedpermission.PermissionListener;
import com.gun0912.tedpermission.TedPermission;

import java.util.List;

public class PermissionActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_permission);
    }

    public void checkPermission(View view) {
        PermissionListener permissionListener = new PermissionListener() {
            @Override
            public void onPermissionGranted() {
                Toast.makeText(PermissionActivity.this, "permission granted", Toast.LENGTH_SHORT).show();
                //setContentView(R.layout.activity_maps);
                startActivity(new Intent(PermissionActivity.this, MapsActivity.class));
            }

            @Override
            public void onPermissionDenied(List<String> deniedPermissions) {
                Toast.makeText(PermissionActivity.this, "permission denied", Toast.LENGTH_SHORT).show();
            }
        };
        //ask for permission
        TedPermission.with(PermissionActivity.this)
                .setPermissionListener(permissionListener)
                .setPermissions(Manifest.permission.ACCESS_FINE_LOCATION)
                .check();
    }
}
