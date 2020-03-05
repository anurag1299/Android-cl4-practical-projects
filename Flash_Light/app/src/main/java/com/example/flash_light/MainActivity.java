package com.example.flash_light;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.pm.PackageManager;
import android.hardware.camera2.CameraAccessException;
import android.hardware.camera2.CameraManager;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

@RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
public class MainActivity extends AppCompatActivity {

    private  final int CAMERA_REQUEST_CODE = 2;
    boolean hasCameraFlash = false;
    boolean isFlashOn = false;
    ImageView Flash;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        hasCameraFlash = getPackageManager().hasSystemFeature(PackageManager.FEATURE_CAMERA_FLASH);
        Flash = (ImageView) findViewById(R.id.Flash);
        Flash.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                askPermission(Manifest.permission.CAMERA,CAMERA_REQUEST_CODE);
            }
        });
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    private void flashLight(){
        if(hasCameraFlash){
            if(isFlashOn){
                Flash.setImageResource(R.drawable.btn_off);
                    flashLightOff();

                isFlashOn = false;
            }else{
                Flash.setImageResource(R.drawable.btn_on);
                flashLightOn();
                isFlashOn = true;
            }
        }else{
            Toast.makeText(MainActivity.this,"Flash Not Available", Toast.LENGTH_SHORT).show();
        }
    }


    private void flashLightOff(){
        CameraManager cameraManager = (CameraManager)getSystemService(Context.CAMERA_SERVICE);
        try{
            String cameraId = cameraManager.getCameraIdList()[0];

                cameraManager.setTorchMode(cameraId,false);

        }catch (CameraAccessException e){}
    }



    private void flashLightOn(){
        CameraManager cameraManager = (CameraManager)getSystemService(Context.CAMERA_SERVICE);
        try{
            String cameraId = cameraManager.getCameraIdList()[0];
            cameraManager.setTorchMode(cameraId,true);

        }catch (CameraAccessException e){}
    }


    private  void askPermission(String permission, int requestCode){
        if(ContextCompat.checkSelfPermission(this,permission) != PackageManager.PERMISSION_GRANTED){
            ActivityCompat.requestPermissions(this, new String[]{permission},requestCode);
        }else{
            flashLight();
        }
    }
}
