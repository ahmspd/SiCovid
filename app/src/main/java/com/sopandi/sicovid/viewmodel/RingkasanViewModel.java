package com.sopandi.sicovid.viewmodel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.sopandi.sicovid.api.ApiEndPoint;
import com.sopandi.sicovid.api.ApiService;
import com.sopandi.sicovid.model.RingkasanModel;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class RingkasanViewModel extends ViewModel {
    private MutableLiveData<RingkasanModel> mutableLiveData = new MutableLiveData<>();

    public void setSummaryWorldData(){
        Retrofit retrofit = ApiService.getRetrofitService();
        ApiEndPoint apiEndPoint = retrofit.create(ApiEndPoint.class);
        Call<RingkasanModel> call = apiEndPoint.getSummaryWorld();
        call.enqueue(new Callback<RingkasanModel>() {
            @Override
            public void onResponse(Call<RingkasanModel> call, Response<RingkasanModel> response) {
                mutableLiveData.setValue(response.body());
            }

            @Override
            public void onFailure(Call<RingkasanModel> call, Throwable t) {

            }
        });
    }

    public LiveData<RingkasanModel> getSummaryWorldData(){
        return mutableLiveData;
    }
}
