package com.example.husen.mvvm;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;
import android.support.annotation.NonNull;

/**
 * Created by husen on 16/05/18.
 */



public class NameViewModel extends AndroidViewModel {

    private MutableLiveData<String> currentName;
    private MutableLiveData<Integer> currentNum;

    public NameViewModel(@NonNull Application application) {
        super(application);
    }

    public MutableLiveData<String> getCurrentName(){
        if(currentName==null){
            currentName = new MutableLiveData<String>();
        }
        return currentName;
    }

    public MutableLiveData<Integer> getCurrentData() {
        if (currentNum == null) {
            currentNum = new MutableLiveData<Integer>();
        }
        return currentNum;
    }


}
