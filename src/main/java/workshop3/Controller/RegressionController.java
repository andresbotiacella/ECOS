/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package workshop3.Controller;

import java.util.ArrayList;
import workshop3.Model.*;

/**
 *
 * @author Andy
 */
public class RegressionController {
    
    RegressionModel model;
    
    public RegressionController(String fileName)
    {
        model = new RegressionModel(fileName);
    }
    
    public double calculateB1Parameter() {
        try
        {
            return model.calculateB1Parameter();
        } catch (Exception er) {
            return 0;
        }
    }
    
    public double calculateB0Parameter(double b1) {
        try
        {
            return model.calculateB0Parameter(b1);
        } catch (Exception er) {
            return 0;
        }
    }
    
    public double calculateRCoefficient() {
        try
        {
            return model.calculateRCoefficient();
        } catch (Exception er) {
            return 0;
        }
    }
    
    public double calculateLinearRegression(double b0, double b1, double x) {
        try
        {
            return model.calculateLinearRegression(b0, b1, x);
        } catch (Exception er) {
            return 0;
        }
    } 
    
}
