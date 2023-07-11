package digi.coders.koibandaapp.Models;

public class RoWaterModel {
    int waterImg;
    String waterName;
    String waterLitter;
    String waterPrice;

    public RoWaterModel(int waterImg, String waterName, String waterLitter, String waterPrice) {
        this.waterImg = waterImg;
        this.waterName = waterName;
        this.waterLitter = waterLitter;
        this.waterPrice = waterPrice;
    }

    public int getWaterImg() {
        return waterImg;
    }

    public void setWaterImg(int waterImg) {
        this.waterImg = waterImg;
    }

    public String getWaterName() {
        return waterName;
    }

    public void setWaterName(String waterName) {
        this.waterName = waterName;
    }

    public String getWaterLitter() {
        return waterLitter;
    }

    public void setWaterLitter(String waterLitter) {
        this.waterLitter = waterLitter;
    }

    public String getWaterPrice() {
        return waterPrice;
    }

    public void setWaterPrice(String waterPrice) {
        this.waterPrice = waterPrice;
    }
}
