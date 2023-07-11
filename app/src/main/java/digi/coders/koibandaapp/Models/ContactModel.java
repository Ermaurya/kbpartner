package digi.coders.koibandaapp.Models;

public class ContactModel {
    String name;
    String email;
    String mobile;
    String servicetype;
    String servicetime;
    String address;

    public ContactModel(String name, String email, String mobile, String servicetype, String servicetime, String address) {
        this.name = name;
        this.email = email;
        this.mobile = mobile;
        this.servicetype = servicetype;
        this.servicetime = servicetime;
        this.address = address;
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

    public String getServicetype() {
        return servicetype;
    }

    public void setServicetype(String servicetype) {
        this.servicetype = servicetype;
    }

    public String getServicetime() {
        return servicetime;
    }

    public void setServicetime(String servicetime) {
        this.servicetime = servicetime;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
