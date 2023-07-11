package digi.coders.koibandaapp.Interfaces;

import com.google.gson.JsonObject;

import digi.coders.koibandaapp.Models.ContactModel;
import digi.coders.koibandaapp.Models.LoginResponse;
import digi.coders.koibandaapp.Models.RegisterModel;
import digi.coders.koibandaapp.Models.RoWaterSendDataModel;
import digi.coders.koibandaapp.Models.VendorRegModel;
import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface ApiServices {
@FormUrlEncoded
    @POST("register.php")
    Call<RegisterModel> registerData(@Field("name") String name,@Field("email") String email,@Field("mobile") String mobile,@Field("password") String password);


    @FormUrlEncoded
    @POST("login.php")
    Call<LoginResponse> loginData(@Field("email") String email, @Field("password") String password);

    @FormUrlEncoded
    @POST("contact.php")
    Call<ContactModel> contactData(@Field("name") String name,@Field("email") String email,@Field("mobile") String mobile,@Field("servicetype") String servicetype,@Field("servicetime") String servicetime,@Field("address") String address);

    @FormUrlEncoded
    @POST("vendorRegister.php")
    Call<VendorRegModel> vendorData(@Field("name") String name,@Field("email") String email,@Field("mobile") String mobile,@Field("vender_type") String vender_type,@Field("vender_service")String vender_service,@Field("vender_adhar") String vender_adhar,@Field("vender_address") String vender_address);


    @FormUrlEncoded
    @POST("updateaddress.php")
    Call<RegisterModel> updateAddress(@Field("name") String name,@Field("email")String email,@Field("mobile") String mobile,@Field("street_name") String street_name,@Field("pin_code") String pin_code,@Field("state_name") String state_name,@Field("city_name") String city_name,@Field("land_mark") String land_mark,@Field("type_of_address") String type_of_address,@Field("address") String address);

    @FormUrlEncoded
    @POST("updateaddress.php")
    Call<RegisterModel> updateProfile(@Field("name") String name,@Field("email") String email,@Field("mobile") String mobile);

    @FormUrlEncoded
    @POST("booking_servies.php")
    Call<RoWaterSendDataModel> updateRoWaterSendData(@Field("email") String email, @Field("total_amount") String total_amount, @Field("slectec_ser") String slectec_ser, @Field("quantity") String quantity, @Field("date") String date, @Field("payment") String payment);

    @FormUrlEncoded
    @POST("updateaddress.php")
    Call<RegisterModel> updateRoWaterAddress(@Field("email") String email,@Field("name") String name,@Field("mobile") String mobile,@Field("address") String address);

    //call plumber api
    @GET("custmerapi/plumbingapi.php")
    Call<JsonObject> getPlumberService();

    @GET("custmerapi/acrepairapi.php")
    Call<JsonObject> getElectricService();

    @GET("custmerapi/cleaningapi.php")
    Call<JsonObject> getHomeCleanService();

    @GET("custmerapi/paintersapi.php")
    Call<JsonObject> getHomePaintService();

}
