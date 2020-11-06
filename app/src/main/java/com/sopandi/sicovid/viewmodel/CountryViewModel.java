package com.sopandi.sicovid.viewmodel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.sopandi.sicovid.api.ApiEndPoint;
import com.sopandi.sicovid.api.ApiService;
import com.sopandi.sicovid.model.CountryModel;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class CountryViewModel extends ViewModel {
    private MutableLiveData<CountryModel> mutableLiveData = new MutableLiveData<>();
    public void setCountryData(){
        Retrofit retrofit = ApiService.getRetrofitService();
        ApiEndPoint apiEndPoint = retrofit.create(ApiEndPoint.class);
        Call<CountryModel> call = apiEndPoint.getSummaryIdn();
        call.enqueue(new Callback<CountryModel>() {
            @Override
            public void onResponse(Call<CountryModel> call, Response<CountryModel> response) {
                mutableLiveData.setValue(response.body());
            }

            @Override
            public void onFailure(Call<CountryModel> call, Throwable t) {

            }
        });
    }

    public LiveData<CountryModel> getCountryData(){
        return mutableLiveData;
    }
}
