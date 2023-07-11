package digi.coders.koibandaapp.Models;

public class VendorRegModel {

    String name;
    String email;
    String  mobile;
   String vender_type;
   String vender_service;
   String vender_adhar;

    public VendorRegModel(String name, String email, String mobile, String vender_type, String vender_service, String vender_adhar) {
        this.name = name;
        this.email = email;
        this.mobile = mobile;
        this.vender_type = vender_type;
        this.vender_service = vender_service;
        this.vender_adhar = vender_adhar;
    }

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

    public String getVender_type() {
        return vender_type;
    }

    public void setVender_type(String vender_type) {
        this.vender_type = vender_type;
    }

    public String getVender_service() {
        return vender_service;
    }

    public void setVender_service(String vender_service) {
        this.vender_service = vender_service;
    }

    public String getVender_adhar() {
        return vender_adhar;
    }

    public void setVender_adhar(String vender_adhar) {
        this.vender_adhar = vender_adhar;
    }
}
