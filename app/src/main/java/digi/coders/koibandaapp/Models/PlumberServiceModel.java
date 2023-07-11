package digi.coders.koibandaapp.Models;

public class PlumberServiceModel {

    //private String mcat_id;
    private String mcat_name;
   // private String file_img;
    private String discount;
    private String main_priz;

    public PlumberServiceModel(String mcat_name,String discount, String main_priz) {
       // this.mcat_id = mcat_id;
        this.mcat_name = mcat_name;
       // this.file_img = file_img;
        this.discount = discount;
        this.main_priz = main_priz;
    }
//
//    public String getMcat_id() {
//        return mcat_id;
//    }

//    public void setMcat_id(String mcat_id) {
//        this.mcat_id = mcat_id;
//    }

    public String getMcat_name() {
        return mcat_name;
    }

    public void setMcat_name(String mcat_name) {
        this.mcat_name = mcat_name;
    }

//    public String getFile_img() {
//        return file_img;
//    }
//
//    public void setFile_img(String file_img) {
//        this.file_img = file_img;
//    }

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
