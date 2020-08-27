package com.ldxx.vo;

import com.ldxx.bean.Guize;
import com.ldxx.bean.GuizeCar;
import com.ldxx.bean.GuizeLnglat;

import java.util.List;

public class GuizeVo {

    String id;
    String guizeId;
    String time;
    String guizeName;
    String guizeType;
    String pianliJuli;
    List<GuizeCar> plates;
    List<GuizeLnglat> points;

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getGuizeType() {
        return guizeType;
    }

    public void setGuizeType(String guizeType) {
        this.guizeType = guizeType;
    }

    public String getPianliJuli() {
        return pianliJuli;
    }

    public void setPianliJuli(String pianliJuli) {
        this.pianliJuli = pianliJuli;
    }

    public String getGuizeId() {
        return guizeId;
    }

    public void setGuizeId(String guizeId) {
        this.guizeId = guizeId;
    }

    public String getGuizeName() {
        return guizeName;
    }

    public void setGuizeName(String guizeName) {
        this.guizeName = guizeName;
    }

    public List<GuizeCar> getPlates() {
        return plates;
    }

    public void setPlates(List<GuizeCar> plates) {
        this.plates = plates;
    }

    public List<GuizeLnglat> getPoints() {
        return points;
    }

    public void setPoints(List<GuizeLnglat> points) {
        this.points = points;
    }
}
