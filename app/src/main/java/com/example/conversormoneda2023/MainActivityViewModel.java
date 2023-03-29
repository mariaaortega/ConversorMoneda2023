package com.example.conversormoneda2023;

import android.app.Application;
import android.content.Context;
import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

public class MainActivityViewModel extends AndroidViewModel {

    private Context context;
    private MutableLiveData<Double> valorConversion;
    private MutableLiveData<Boolean> raddioButtonSelect;

    public MainActivityViewModel(@NonNull Application application) {
        super(application);
        this.context = application.getApplicationContext();
    }
    public LiveData<Double> GetValorConversion(){
        if(valorConversion == null)
        {
            valorConversion = new MutableLiveData<>();
        }
        return valorConversion;
    }

    public LiveData<Boolean>GetRaddioButtonSelect(){
        if(raddioButtonSelect == null)
        {
            raddioButtonSelect = new MutableLiveData<>();
        }
        return raddioButtonSelect;
    }

    public void desactivar(String x){
        if(x.equalsIgnoreCase("Euros a Dólares"))
        {
            raddioButtonSelect.setValue(true);
        }
        else
        {
            raddioButtonSelect.setValue(false);
        }
    }
    public void ConversorDolarAEuro(Double dolar){
        try
        {
            valorConversion.setValue(dolar*0.92);
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
    }
    public void ConversorEuroADolar(Double euro){
        try
        {
            valorConversion.setValue(euro*1.08);
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
    }
    public void Calcular(String euros, String dolares){
        System.out.println(dolares.length());
        System.out.println(euros.length());
        if(euros.length() > 0)
        {
            ConversorEuroADolar(Double.parseDouble(euros));
        }
        if(dolares.length() > 0)
        {
            ConversorDolarAEuro(Double.parseDouble(dolares));
        }
    }
}
