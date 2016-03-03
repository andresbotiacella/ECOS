
import java.util.HashMap;
import java.util.ArrayList;
import java.util.Map;
import static spark.Spark.*;
import spark.template.freemarker.FreeMarkerEngine;
import spark.ModelAndView;
import static spark.Spark.get;
import com.heroku.sdk.jdbc.DatabaseUrl;

import workshop3.Controller.*;


/**
 *
 * @author Andy
 */
public class Main {

/**
 * @method main
 * 
 */
    public static void main(String[] args) {
        
        //Test Case 1
        RegressionController controllerTest1 = new RegressionController("List1.txt");
        double b1Test1 = controllerTest1.calculateB1Parameter();
        double b0Test1 = controllerTest1.calculateB0Parameter(b1Test1);
        double rTest1 = controllerTest1.calculateRCoefficient();
        double rPowTest1 = Math.pow(rTest1, 2);
        double yTest1 = controllerTest1.calculateLinearRegression(b0Test1, b1Test1, 386);
        
        System.out.println("Test Case 1 - Regression between estimated proxy size and actual added and modified size:");
        System.out.println("b0: " + b0Test1);
        System.out.println("b1: " + b1Test1);
        System.out.println("r: " + rTest1);
        System.out.println("r2: " + rPowTest1);
        System.out.println("y: " + yTest1);
        
        
        //Test Case 2
        RegressionController controllerTest2 = new RegressionController("List2.txt");
        double b1Test2 = controllerTest2.calculateB1Parameter();
        double b0Test2 = controllerTest2.calculateB0Parameter(b1Test2);
        double rTest2 = controllerTest2.calculateRCoefficient();
        double rPowTest2 = Math.pow(rTest2, 2);
        double yTest2 = controllerTest2.calculateLinearRegression(b0Test2, b1Test2, 386);
        
        System.out.println("Test Case 2 - Regression between estimated proxy size and actual development time:");
        System.out.println("b0: " + b0Test2);
        System.out.println("b1: " + b1Test2);
        System.out.println("r: " + rTest2);
        System.out.println("r2: " + rPowTest2);
        System.out.println("y: " + yTest2);
        
        
        //Test Case 3
        RegressionController controllerTest3 = new RegressionController("List3.txt");
        double b1Test3 = controllerTest3.calculateB1Parameter();
        double b0Test3 = controllerTest3.calculateB0Parameter(b1Test3);
        double rTest3 = controllerTest3.calculateRCoefficient();
        double rPowTest3 = Math.pow(rTest3, 2);
        double yTest3 = controllerTest3.calculateLinearRegression(b0Test3, b1Test3, 386);
        
        System.out.println("Test Case 3 - Regression between plan and actual added and modified size:");
        System.out.println("b0: " + b0Test3);
        System.out.println("b1: " + b1Test3);
        System.out.println("r: " + rTest3);
        System.out.println("r2: " + rPowTest3);
        System.out.println("y: " + yTest3);
        
        
        //Test Case 4
        RegressionController controllerTest4 = new RegressionController("List4.txt");
        double b1Test4 = controllerTest4.calculateB1Parameter();
        double b0Test4 = controllerTest4.calculateB0Parameter(b1Test4);
        double rTest4 = controllerTest4.calculateRCoefficient();
        double rPowTest4 = Math.pow(rTest4, 2);
        double yTest4 = controllerTest4.calculateLinearRegression(b0Test4, b1Test4, 386);
        
        System.out.println("Test Case 4 - Regression between plan added and modified size and actual development time:");
        System.out.println("b0: " + b0Test4);
        System.out.println("b1: " + b1Test4);
        System.out.println("r: " + rTest4);
        System.out.println("r2: " + rPowTest4);
        System.out.println("y: " + yTest4);
    }

}