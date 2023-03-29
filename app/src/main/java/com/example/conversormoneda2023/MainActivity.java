package com.example.conversormoneda2023;

import android.content.Context;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import com.example.conversormoneda2023.databinding.ActivityMainBinding;


public class MainActivity extends AppCompatActivity {

   ActivityMainBinding binding;
    MainActivityViewModel mv;

    Context context;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        mv = ViewModelProvider.AndroidViewModelFactory.getInstance(getApplication()).create(MainActivityViewModel.class);
        context = getApplicationContext();
        mv.GetValorConversion().observe(this, new Observer<Double>() {
            @Override
            public void onChanged(Double conversion) {
                binding.tvConversion.setText(conversion+"");
            }
        });

        mv.GetRaddioButtonSelect().observe(this, new Observer<Boolean>() {
            @Override
            public void onChanged(Boolean aBoolean) {
                binding.etEuros.setText("");
                binding.etDolares.setText("");

                binding.etEuros.setEnabled(aBoolean);
                binding.etDolares.setEnabled(!aBoolean);
            }
        });


        binding.rbEurosADolares.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mv.desactivar(binding.rbEurosADolares.getText().toString());
            }
        });
        binding.rbDolaresAEuros.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mv.desactivar(binding.rbDolaresAEuros.getText().toString());
            }
        });

        binding.btnConvertir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mv.Calcular(binding.etEuros.getText().toString(), binding.etDolares.getText().toString());
            }
        });
    }
}