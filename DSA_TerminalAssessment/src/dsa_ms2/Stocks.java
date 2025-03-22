/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dsa_ms2;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
/**
 *
 * @author Aira Joie Piopongco
 */
public class Stocks {
    private String dateEntered;
    private String stockLabel;
    private String brand;
    private String engineNumber;
    private String status;

    //for stocks to be added
    public Stocks (String brand, String engineNumber) {
        this.dateEntered = new SimpleDateFormat("yyyy-MM-dd").format(new Date());
        this.stockLabel = "New";
        this.brand = brand;
        this.engineNumber = engineNumber;
        this.status = "On-hand";
    }

    //for existing stocks in the inventoryData csv
    public Stocks(String dateEntered, String stockLabel, String brand, String engineNumber, String status) {
        this.dateEntered = formatDate(dateEntered); 
        this.stockLabel = stockLabel;
        this.brand = brand;
        this.engineNumber = engineNumber;
        this.status = status;
    }
    
    private String formatDate(String date) {
        SimpleDateFormat inputFormat = new SimpleDateFormat("MM/dd/yyyy");
        SimpleDateFormat outputFormat = new SimpleDateFormat("yyyy-MM-dd");
        try {
            Date parsedDate = inputFormat.parse(date);
            return outputFormat.format(parsedDate);
        } catch (ParseException e) {
            return date;
        }
    }

    public String getDateEntered() {
        return dateEntered;
    }

    public String getStockLabel() {
        return stockLabel;
    }

    public String getBrand() {
        return brand;
    }

    public String getEngineNumber() {
        return engineNumber;
    }

    public String getStatus() {
        return status;
    }

    public void setDateEntered(String dateEntered) {
        this.dateEntered = dateEntered;
    }

    public void setStockLabel(String stockLabel) {
        this.stockLabel = stockLabel;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public void setEngineNumber(String engineNumber) {
        this.engineNumber = engineNumber;
    }
    
    public void setStatus(String status) {
        this.status = status;
    }
}
