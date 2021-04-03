package ejvr;

public class Main {
    public static final double[] RAINFALL = {370.6,352.1,370.9,255.5,69.1,26.1,19.7,9.5,6.4,14.9,56.7,194.6}; //mm
    public static double max_water_capacity = 3000; //L
    public static double carsPerMonth = (365.0/12.0) * 10.0;
    public static double waterPerCar = 40; //L
    public static double collectorTotalArea = 113;
    public static double waterRecycled = 0.928;
    public static void main(String[] args){
        double currentCapacity = max_water_capacity;
        double collectorArea = collectorTotalArea;
        int month = 0;
        for (double rainwater:RAINFALL) {
            month++;
            System.out.println("--- Month: " + month + " ----");
            if(currentCapacity < max_water_capacity){
                double waterAdded = (collectorArea * (rainwater / 1000.0)) * 1000.0;
                if((waterAdded + currentCapacity) < max_water_capacity){
                    currentCapacity = currentCapacity + waterAdded;
                    System.out.println("Water added: " + waterAdded);
                } else {
                    currentCapacity = max_water_capacity;
                    System.out.println("Filled tank...");
                }
            } else {
                currentCapacity = max_water_capacity;
                System.out.println("Tank was full...");
            }

            double waterUsed = (carsPerMonth * waterPerCar) * (1 - waterRecycled);

            System.out.println("Water used: " + waterUsed);
            
            currentCapacity -= waterUsed;
            System.out.println("Current Capacity: " + currentCapacity);
        }
    }
}
