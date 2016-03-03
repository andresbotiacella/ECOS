/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package workshop3.Model;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Andy
 */
public class RegressionModel {
    
    private int quantity;
    private double xMean;
    private double yMean;
    private double xSum;
    private double ySum;
    private double xPowSum;
    private double yPowSum;
    private double xySum;
    private ArrayList<Double> xList;
    private ArrayList<Double> yList;
    
    public RegressionModel(String fileName)
    {
        xList = new ArrayList<Double>();
        yList = new ArrayList<Double>();
        getData(fileName);
        Double[] xArray = new Double[]{};
        xArray = xList.toArray(xArray);
        Double[] yArray = new Double[]{};
        yArray = yList.toArray(yArray);
        quantity = xList.size();
        xMean = calculateMean(xList);
        yMean = calculateMean(yList);
        xSum = calculateSum(xArray);
        ySum = calculateSum(yArray);
        xPowSum = calculatePowSum(xArray);
        yPowSum = calculatePowSum(yArray);
        xySum = calculateXYSum(xArray, yArray);
    }
    
    public void getData(String fileName){
        
        ArrayList<String> data = new ArrayList<>();
        // We will be using a try-with-resource block
        try (BufferedReader reader = new BufferedReader(
                new FileReader(fileName))) {
            // Access the data from the file
            // Create a new StringBuilder
            StringBuilder string = new StringBuilder();
            
            // Read line-by-line
            String line = reader.readLine();
            // While there comes a new line, execute this
            while(line != null) {
                // Add these lines to the String builder
                data.add(line);
                // Read the next line
                line = reader.readLine();
            }
        } catch (Exception er) {
            // Since there was an error, you probably want to notify the user
            // For that error. So return the error.
            data = new ArrayList<String>();
        }
        // Return the string read from the file
        for(String l : data)
        {
            String[] values = l.split("-");
            xList.add(Double.parseDouble(values[0]));
            yList.add(Double.parseDouble(values[1]));
        }
    }
    
    public double calculateMean(List<Double> dataList) {
        
        double sum = 0;
        double mean = 0;
        for(Double dataItem : dataList)
        {
            sum = sum + dataItem;
        }
        return sum/dataList.size();
    }
    
    public double calculateSum(Double[] valueArray)
    {
        double sum = 0;
        for (int i = 0; i < valueArray.length; i++)
        {
            sum = sum + valueArray[i]; 
        }
        return sum;
    }
    
    public double calculatePowSum(Double[] valueArray)
    {
        double sum = 0;
        for (int i = 0; i < valueArray.length; i++)
        {
            sum = sum + Math.pow(valueArray[i], 2); 
        }
        return sum;
    }
    
    public double calculateXYSum(Double[] xArray, Double[] yArray)
    {
        //Calculate the sum of the product of each pair of values
        double sum = 0;
        for(int i = 0; i < xArray.length; i++)
        {
            sum = sum + (xArray[i] * yArray[i]);
        }
        return sum;
    }
    
    public double calculateB1Parameter(){
        
        double b1 = 0;
        double top = 0;
        double bottom = 0;
        
        top = xySum - (quantity * xMean * yMean);        
        bottom = xPowSum - (quantity * Math.pow(xMean, 2));
        
        b1 = top / bottom;
        
        return b1;
    }
    
    public double calculateB0Parameter(double b1){
        
        double b0 = 0;
        b0 = yMean - (b1 * xMean);
        
        return b0;
    }
    
    public double calculateRCoefficient()
    {
        double r = 0;
        double top = 0;
        double bottom = 0;
        top = (quantity * xySum) - (xSum * ySum);
        bottom = Math.sqrt(((quantity * xPowSum) - Math.pow(xSum, 2)) * ((quantity * yPowSum) - Math.pow(ySum, 2)));
        r = top / bottom;
        
        return r;
    }
    
    public double calculateLinearRegression(double b0, double b1, double x)
    {
        double y = 0;
        y = b0 + (b1 * x);
        return y;
    }
}
