package com.laboratorio.entity;

import org.json.JSONObject;

public class Change {
    private double amount;
    private String base;
    private String date;
    private Rates rates;

    public Change(String jsonEntity){
        JSONObject job=new JSONObject(jsonEntity);
        this.amount=job.getDouble("amount");
        this.base=job.getString("base");
        this.date=job.getString("date");
        this.rates=new Rates(job.getJSONObject("rates").toString());
    }

    @Override
    public String toString() {
        return "Change{" +
                "amount=" + amount +
                ", base='" + base + '\'' +
                ", date='" + date + '\'' +
                ", rates=" + rates +
                '}';
    }
}
