/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package neuralnetwork;

/**
 *
 * @author selahattincincin
 */
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Scanner;

public class NeuralNetwork {
    public static double calculate(double i){
        i = ((i*347)+220) * Math.PI;
        i = Math.cos(i);
        return i;
    }
    private static double round(double value, int places) {
    if (places < 0) throw new IllegalArgumentException();
 
    BigDecimal bd = new BigDecimal(Double.toString(value));
    bd = bd.setScale(places, RoundingMode.HALF_UP);
    return bd.doubleValue();
}

    public static void main(String[] args) {
        double[] gelen = {0,0};
        double[] weights1 = {0.712,0.355,0.262,0.112,0.855,0.468};
        double[] hidden1 = {0,0,0};
        double[] weights2 = {0.116,0.329,0.708};
        double output= 0;
        Scanner reader = new Scanner(System.in);
        System.out.println("Data 1");
        gelen[0] = reader.nextDouble();
        System.out.println("Data 2");
        gelen[1] = reader.nextDouble();
        hidden1[1] = calculate(gelen[0]) * weights1[1];
               int x=0;  
        for(int i=0 ;i <3;i++){
                hidden1[i] += (calculate(gelen[0])* weights1[x]) 
                              + (calculate(gelen[1])* weights1[x+3]);
            x++;
            System.out.println("hidden "+ x+ "\t" +round(hidden1[i],4));
        }
        for(int j = 0;j<3;j++){
            output += ((calculate(hidden1[j]))* weights2[j]) ;
        }

        
        System.out.println(output);
        
    }
    
}