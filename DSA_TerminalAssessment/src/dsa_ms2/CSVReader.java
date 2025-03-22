/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dsa_ms2;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Aira Joie Piopongco
 */
public class CSVReader {

    private List<String[]> inventory;

    public CSVReader(String csvFile) {
        inventory = new ArrayList<>();
        loadDataFromCSV(csvFile);
    }

    private void loadDataFromCSV(String csvFile) {
        try (BufferedReader br = new BufferedReader(new FileReader(csvFile))) {
            String headerLine = br.readLine();
            String firstDataLine = br.readLine();
            String line;
            while ((line = br.readLine()) != null) {
                String[] columns = line.split(",");
                inventory.add(columns);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public List<String[]> getInventoryData() {
        return inventory;
    }

}
