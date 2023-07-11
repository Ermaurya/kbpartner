package digi.coders.koibandaapp.Models;

public class HomeCleanServiceModel {
    String mcat_name;
    String discount;
    String main_priz;

    public HomeCleanServiceModel(String mcat_name, String discount, String main_priz) {
        this.mcat_name = mcat_name;
        this.discount = discount;
        this.main_priz = main_priz;
    }

    public String getMcat_name() {
        return mcat_name;
    }

    public void setMcat_name(String mcat_name) {
        this.mcat_name = mcat_name;
    }

    public String getDiscount() {
        return discount;
    }

    public void setDiscount(String discount) {
        this.discount = discount;
    }

    public String getMain_priz() {
        return main_priz;
    }

    public void setMain_priz(String main_priz) {
        this.main_priz = main_priz;
    }
}
