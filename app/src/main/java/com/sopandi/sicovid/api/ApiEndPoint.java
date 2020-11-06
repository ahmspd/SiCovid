package com.sopandi.sicovid.api;

import com.sopandi.sicovid.model.CountryModel;
import com.sopandi.sicovid.model.RingkasanModel;
import com.sopandi.sicovid.model.RiwayatModel;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface ApiEndPoint {
    @GET(Api.END_POINT_WORLD_HISTORY)
    Call<List<RiwayatModel>> getHistoryList(@Path("date") String date);

    @GET(Api.END_POINT_SUMMARY_WORLD)
    Call<RingkasanModel> getSummaryWorld();

    @GET(Api.END_POINT_IDH)
    Call<CountryModel> getSummaryIdn();
}
