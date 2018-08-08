package cn.liliu.marry.entity;

import java.io.Serializable;

public class User implements Serializable{
    public String group_id;
    public String mime_name;
    public String mime_year;
    public String mime_area;
    public String mime_sex;
    public String mime_wx_num;
    public String mime_interest;
    public String your_year;
    public String your_area;
    public String your_interest;

    public String getGroup_id() {
        return group_id;
    }

    public void setGroup_id(String group_id) {
        this.group_id = group_id;
    }

    public String getMime_name() {
        return mime_name;
    }

    public void setMime_name(String mime_name) {
        this.mime_name = mime_name;
    }

    public String getMime_year() {
        return mime_year;
    }

    public void setMime_year(String mime_year) {
        this.mime_year = mime_year;
    }

    public String getMime_area() {
        return mime_area;
    }

    public void setMime_area(String mime_area) {
        this.mime_area = mime_area;
    }

    public String getMime_sex() {
        return mime_sex;
    }

    public void setMime_sex(String mime_sex) {
        this.mime_sex = mime_sex;
    }

    public String getMime_wx_num() {
        return mime_wx_num;
    }

    public void setMime_wx_num(String mime_wx_num) {
        this.mime_wx_num = mime_wx_num;
    }

    public String getMime_interest() {
        return mime_interest;
    }

    public void setMime_interest(String mime_interest) {
        this.mime_interest = mime_interest;
    }

    public String getYour_year() {
        return your_year;
    }

    public void setYour_year(String your_year) {
        this.your_year = your_year;
    }

    public String getYour_area() {
        return your_area;
    }

    public void setYour_area(String your_area) {
        this.your_area = your_area;
    }

    public String getYour_interest() {
        return your_interest;
    }

    public void setYour_interest(String your_interest) {
        this.your_interest = your_interest;
    }

    public User(String group_id, String mime_name, String mime_year, String mime_area, String mime_sex, String mime_wx_num, String mime_interest, String your_year, String your_area, String your_interest) {
        this.group_id = group_id;
        this.mime_name = mime_name;
        this.mime_year = mime_year;
        this.mime_area = mime_area;
        this.mime_sex = mime_sex;
        this.mime_wx_num = mime_wx_num;
        this.mime_interest = mime_interest;
        this.your_year = your_year;
        this.your_area = your_area;
        this.your_interest = your_interest;
    }

    @Override
    public String toString() {
        return "User{" +
                "group_id='" + group_id + '\'' +
                ", mime_name='" + mime_name + '\'' +
                ", mime_year='" + mime_year + '\'' +
                ", mime_area='" + mime_area + '\'' +
                ", mime_sex='" + mime_sex + '\'' +
                ", mime_wx_num='" + mime_wx_num + '\'' +
                ", mime_interest='" + mime_interest + '\'' +
                ", your_year='" + your_year + '\'' +
                ", your_area='" + your_area + '\'' +
                ", your_interest='" + your_interest + '\'' +
                '}';
    }
}
