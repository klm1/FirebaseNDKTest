package com.example.firebasendktest;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;

import com.example.firebasendktest.databinding.ActivityMainBinding;
import com.example.native_library.NativeMethods;

public class MainActivity extends AppCompatActivity {
    private ActivityMainBinding binding;

    // Used to load the 'native-lib' library on application startup.
    static {
        System.loadLibrary("native-lib");
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);

        binding.buttonManagedCrash.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                throw new RuntimeException("Test Managed Crash"); // Force a crash
            }
        });

        binding.buttonNativeCrash.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                NativeMethods.crashFromJNI(); // Force a crash in native code
            }
        });

        // Example of a call to a native method
        //TextView tv = findViewById(R.id.sample_text);
        binding.sampleText.setText(NativeMethods.stringFromJNI());
    }
}