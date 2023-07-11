package digi.coders.koibandaapp.RetrofitClasses;

import digi.coders.koibandaapp.Interfaces.ApiServices;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitClient {
    public static ApiServices getClient(){

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://forexmillionersclub.com/koi/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        ApiServices apiServices = retrofit.create(ApiServices.class);
        return apiServices;
    }

}
