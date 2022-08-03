package com.in28minutes.microservices.currencyexchangeservice;

//{
//    "id":10001,
//    "from":"USD",
//    "to":"INR",
//    "conversionMultiple":65.00,
//    "environment":"8000 instance-id"
//}
public class CurrencyExchangeResponse {
   private int id;

   private String from;

   private String to;

   private float conversionMultiple;

   private String environment;

    public CurrencyExchangeResponse(int id, String from, String to, float conversionMultiple, String environment) {
        this.id = id;
        this.from = from;
        this.to = to;
        this.conversionMultiple = conversionMultiple;
        this.environment = environment;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public String getTo() {
        return to;
    }

    public void setTo(String to) {
        this.to = to;
    }

    public float getConversionMultiple() {
        return conversionMultiple;
    }

    public void setConversionMultiple(float conversionMultiple) {
        this.conversionMultiple = conversionMultiple;
    }

    public String getEnvironment() {
        return environment;
    }

    public void setEnvironment(String environment) {
        this.environment = environment;
    }
}
