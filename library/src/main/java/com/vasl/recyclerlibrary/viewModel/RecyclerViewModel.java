package com.vasl.recyclerlibrary.viewModel;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import com.vasl.recyclerlibrary.globalEnums.ListStatus;

public class RecyclerViewModel extends ViewModel {
    private MutableLiveData<ListStatus> state = new MutableLiveData<>();

    public MutableLiveData<ListStatus> getState() {
        return state;
    }
}
