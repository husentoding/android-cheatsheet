package com.example.husen.mvvm;

import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;

/**
 * Created by husen on 16/05/18.
 */



public class NameViewModel extends ViewModel {

    private MutableLiveData<String> currentName;

    public MutableLiveData<String> getCurrentName(){
        if(currentName==null){
            currentName = new MutableLiveData<String>();
        }
        return currentName;
    }


}
