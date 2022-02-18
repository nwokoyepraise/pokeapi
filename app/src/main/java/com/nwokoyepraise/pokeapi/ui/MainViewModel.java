package com.nwokoyepraise.pokeapi.ui;

import android.app.Application;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.MutableLiveData;

import com.nwokoyepraise.pokeapi.data.MainRepository;

public class MainViewModel extends AndroidViewModel {

    private MainRepository mainRepository;

    public MainViewModel(@NonNull Application application) {
        super(application);
        mainRepository = new MainRepository(getApplication().getBaseContext());
    }

    public void setResponse(String value) {
        mainRepository.setData(value);
    }

    public MutableLiveData<String> getResponse() {
        MutableLiveData <String> mString = new MutableLiveData<>();
        mainRepository.getData(new MainRepository.VolleyCallback() {
            @Override
            public void onSuccessResponse(String result) {
                mString.postValue(result);
                return;
            }
        });
        return mString;
    }
}
