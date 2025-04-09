package kata.calcul_taxes.service;

public class Utils {
    public static double round05(double value){
        return Math.ceil(value*20) / 20.0 ;
    }

    public static double round(double value){
        return Math.round(value*100) / 100.0 ;
    }
}
