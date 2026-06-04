package com.laboratorio.entity;

import org.json.JSONObject;

public class Rates {
    private double AUD;
    private double BRL;
    private double CAD;
    private double CHF;
    private double CNY;
    private double CZK;
    private double DKK;
    private double GBP;
    private double HKD;
    private double HUF;
    private double IDR;
    private double ILS;
    private double INR;
    private double ISK;
    private double JPY;
    private double KRW;
    private double MXN;
    private double MYR;
    private double NOK;
    private double NZD;
    private double PHP;
    private double PLN;
    private double RON;
    private double SEK;
    private double SGD;
    private double THB;
    private double TRY;
    private double USD;
    private double ZAR;

    public Rates(String jsonEntity){
        JSONObject job=new JSONObject(jsonEntity);
        this.AUD=job.getDouble("AUD");
        this.BRL=job.getDouble("BRL");
        this.CAD=job.getDouble("CAD");
        this.CHF=job.getDouble("CHF");
        this.CNY=job.getDouble("CNY");
        this.CZK=job.getDouble("CZK");
        this.DKK=job.getDouble("DKK");
        this.GBP=job.getDouble("GBP");
        this.HKD=job.getDouble("HKD");
        this.HUF=job.getDouble("HUF");
        this.IDR=job.getDouble("IDR");
        this.ILS=job.getDouble("ILS");
        this.INR=job.getDouble("INR");
        this.ISK=job.getDouble("ISK");
        this.JPY=job.getDouble("JPY");
        this.KRW=job.getDouble("KRW");
        this.MXN=job.getDouble("MXN");
        this.MYR=job.getDouble("MYR");
        this.NOK=job.getDouble("NOK");
        this.NZD=job.getDouble("NZD");
        this.PHP=job.getDouble("PHP");
        this.PLN=job.getDouble("PLN");
        this.RON=job.getDouble("RON");
        this.SEK=job.getDouble("SEK");
        this.SGD=job.getDouble("SGD");
        this.THB=job.getDouble("THB");
        this.TRY=job.getDouble("TRY");
        this.USD=job.getDouble("USD");
        this.ZAR=job.getDouble("ZAR");
    }

    @Override
    public String toString() {
        return "Rates{" +
                "AUD=" + AUD +
                ", BRL=" + BRL +
                ", CAD=" + CAD +
                ", CHF=" + CHF +
                ", CNY=" + CNY +
                ", CZK=" + CZK +
                ", DKK=" + DKK +
                ", GBP=" + GBP +
                ", HKD=" + HKD +
                ", HUF=" + HUF +
                ", IDR=" + IDR +
                ", ILS=" + ILS +
                ", INR=" + INR +
                ", ISK=" + ISK +
                ", JPY=" + JPY +
                ", KRW=" + KRW +
                ", MXN=" + MXN +
                ", MYR=" + MYR +
                ", NOK=" + NOK +
                ", NZD=" + NZD +
                ", PHP=" + PHP +
                ", PLN=" + PLN +
                ", RON=" + RON +
                ", SEK=" + SEK +
                ", SGD=" + SGD +
                ", THB=" + THB +
                ", TRY=" + TRY +
                ", USD=" + USD +
                ", ZAR=" + ZAR +
                '}';
    }
}
