package cse360assignment02;

public class AddingMachine {
    private int total;
    private String record;
    
    public AddingMachine() {
        total = 0; // not needed - included for clarity
        record = String.valueOf(total);
    }
    public int getTotal(){
        /**
         * The getter for this method.
         */
        return total;
    }
    public void add (int value) {
        /**
         * Adding a value to the total.
         */
        total += value;
        record = record + " + " + String.valueOf(value);
    }
    public void subtract (int value) {
        /**
         * Subtracting a value from the total.
         */
        total = total - value;
        record = record + " - " + String.valueOf(value);
    }
    public String toString() {
        /**
         * Returning the String version of the total.
         */

        return record;
    }
    public void clear() {
        /**
         * Clearing the memory.
         */
        total = 0;
        record = String.valueOf(total);
    }
}