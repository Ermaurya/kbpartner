package digi.coders.koibandaapp.Models;

public class RegisterModel {

    String name;
    String email;
    String mobile;
    String password;
    String street_name;
    String pin_code;
    String state_name;
    String city_name;
    String land_mark;
    String type_of_address;
    String address;


    public RegisterModel(String name, String email, String mobile, String password, String street_name, String pin_code, String state_name, String city_name, String land_mark, String type_of_address,String address) {
        this.name = name;
        this.email = email;
        this.mobile = mobile;
        this.password = password;
        this.street_name = street_name;
        this.pin_code = pin_code;
        this.state_name = state_name;
        this.city_name = city_name;
        this.land_mark = land_mark;
        this.type_of_address = type_of_address;
        this.address = address;
    }

//    public RegisterModel(String name, String email, String mobile, String password) {
//        this.name = name;
//        this.email = email;
//        this.mobile = mobile;
//        this.password = password;
//
//
//    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }


    public String getStreet_name() {
        return street_name;
    }

    public void setStreet_name(String street_name) {
        this.street_name = street_name;
    }

    public String getPin_code() {
        return pin_code;
    }

    public void setPin_code(String pin_code) {
        this.pin_code = pin_code;
    }

    public String getState_name() {
        return state_name;
    }

    public void setState_name(String state_name) {
        this.state_name = state_name;
    }

    public String getCity_name() {
        return city_name;
    }

    public void setCity_name(String city_name) {
        this.city_name = city_name;
    }

    public String getLand_mark() {
        return land_mark;
    }

    public void setLand_mark(String land_mark) {
        this.land_mark = land_mark;
    }

    public String getType_of_address() {
        return type_of_address;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setType_of_address(String type_of_address) {
        this.type_of_address = type_of_address;



    }



}
