package com.p2m.sdialer;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.p2m.sdialer.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {
    private static final int CALL_REQUESTCODE=101;
    ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding= ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        getSupportActionBar().hide();

        if (ContextCompat.checkSelfPermission(MainActivity.this, Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED){
            ActivityCompat.requestPermissions(MainActivity.this,new String[]{Manifest.permission.CALL_PHONE},CALL_REQUESTCODE);
        }else {
            init();
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull @org.jetbrains.annotations.NotNull String[] permissions, @NonNull @org.jetbrains.annotations.NotNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if (requestCode == CALL_REQUESTCODE){
            if (grantResults.length>0 && grantResults[0]==RESULT_OK){
                init();
            }else {

            }
        }
    }

    private void init(){
        binding.one.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                binding.phonenumberTV.setText(binding.phonenumberTV.getText().toString()+"1");
            }
        });

        binding.zero.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                binding.phonenumberTV.setText(binding.phonenumberTV.getText().toString()+"0");
            }
        });

        binding.two.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                binding.phonenumberTV.setText(binding.phonenumberTV.getText().toString()+"2");
            }
        });

        binding.three.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                binding.phonenumberTV.setText(binding.phonenumberTV.getText().toString()+"3");
            }
        });

        binding.four.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                binding.phonenumberTV.setText(binding.phonenumberTV.getText().toString()+"4");
            }
        });

        binding.five.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                binding.phonenumberTV.setText(binding.phonenumberTV.getText().toString()+"5");
            }
        });

        binding.six.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                binding.phonenumberTV.setText(binding.phonenumberTV.getText().toString()+"6");
            }
        });

        binding.seven.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                binding.phonenumberTV.setText(binding.phonenumberTV.getText().toString()+"7");
            }
        });

        binding.eight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                binding.phonenumberTV.setText(binding.phonenumberTV.getText().toString()+"8");
            }
        });

        binding.nine.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                binding.phonenumberTV.setText(binding.phonenumberTV.getText().toString()+"9");
            }
        });

        binding.star.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                binding.phonenumberTV.setText(binding.phonenumberTV.getText().toString()+"*");
            }
        });

        binding.hash.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                binding.phonenumberTV.setText(binding.phonenumberTV.getText().toString()+"#");
            }
        });

        binding.backspaceBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String val= binding.phonenumberTV.getText().toString();
                if (val.length()>0){
                    val= val.substring(0,val.length()-1);
                }
                binding.phonenumberTV.setText(val);
            }
        });

        binding.phonenumberTV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        binding.sim1Call.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                makePhoneCall();
            }
        });

        binding.sim2Call.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                makePhoneCall();
            }
        });
    }

    private void makePhoneCall() {
        String number= binding.phonenumberTV.getText().toString();
        String dial= "tel:"+number;
        startActivity(new Intent(Intent.ACTION_CALL, Uri.parse(dial)));
    }
}