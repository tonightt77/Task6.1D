package com.app.demo.beans;


import org.litepal.crud.DataSupport;

import java.io.Serializable;

public class OrderBean extends DataSupport implements Serializable {

    public int id;

    public String o_id; // order id
    public String user_id; // user id
    public String user_name;
    public String title;
    public String content;
    public String img;
    public String user_to;
    public String location;
    public String time;
    public String goodsType;
    public String vehicleType;
    public String weight;
    public String wight;
    public String length;
    public String height;

}
