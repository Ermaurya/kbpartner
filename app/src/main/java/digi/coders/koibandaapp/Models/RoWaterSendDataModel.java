package digi.coders.koibandaapp.Models;

public class RoWaterSendDataModel {
    String email;
    String total_amount;
    String slectec_ser;
    String quantity;
    String date;
    String payment;

    public RoWaterSendDataModel(String email, String total_amount, String slectec_ser, String quantity, String date, String payment) {
        this.email = email;
        this.total_amount = total_amount;
        this.slectec_ser = slectec_ser;
        this.quantity = quantity;
        this.date = date;
        this.payment = payment;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTotal_amount() {
        return total_amount;
    }

    public void setTotal_amount(String total_amount) {
        this.total_amount = total_amount;
    }

    public String getSlectec_ser() {
        return slectec_ser;
    }

    public void setSlectec_ser(String slectec_ser) {
        this.slectec_ser = slectec_ser;
    }

    public String getQuantity() {
        return quantity;
    }

    public void setQuantity(String quantity) {
        this.quantity = quantity;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getPayment() {
        return payment;
    }

    public void setPayment(String payment) {
        this.payment = payment;
    }
}
