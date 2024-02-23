import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class Car extends Vehicle{

    private int fuelConsumption;
    private int gasTankCapacity;
    Car() {

    }
    Car(String brand, String model, String plateNumber) {
        super(brand, model, plateNumber);
    }

    Car(String brand) {
        super(brand);
    }


    public enum FuelKind{
        Дизел,
        Бензин,
        Газ
    }
    private int horsePower;
    public enum transmissionKind{
        Ръчна,
        Автоматична
    }
    private int yearOfManufacturer;
    private int dateOfRegistration;
    private int dateOfInsurance;
    private int dateOfTechnicalReview;
    private int dateOfNextTyreChange;
    private int kilometersForNextOilChange;
    public int getFuelConsumption() {

        return fuelConsumption;
    }

    public void setFuelConsumption(int fuelConsumption) {
        this.fuelConsumption = fuelConsumption;
    }

    public int getGasTankCapacity() {

        return gasTankCapacity;
    }

    public void setGasTankCapacity(int gasTankCapacity) {
        this.gasTankCapacity = gasTankCapacity;
    }

    public int getHorsePower() {

        return horsePower;
    }

    public void setHorsePower(int horsePower) {
        this.horsePower = horsePower;
    }


    public int getYearOfManufacturer() {

        return yearOfManufacturer;
    }

    public void setYearOfManufacturer(int yearOfManufacturer) {
        this.yearOfManufacturer = yearOfManufacturer;
    }

    public int getDateOfRegistration() {

        return dateOfRegistration;
    }

    public void setDateOfRegistration(int dateOfRegistration) {
        this.dateOfRegistration = dateOfRegistration;
    }

    public int getDateOfInsurance() {

        return dateOfInsurance;
    }

    public void setDateOfInsurance(int dateOfInsurance) {
        this.dateOfInsurance = dateOfInsurance;
    }

    public int getDateOfTechnicalReview() {

        return dateOfTechnicalReview;
    }

    public void setDateOfTechnicalReview(int dateOfTechnicalReview) {
        this.dateOfTechnicalReview = dateOfTechnicalReview;
    }

    public int getDateOfNextTyreChange() {

        return dateOfNextTyreChange;
    }

    public void setDateOfNextTyreChange(int dateOfNextTyreChange) {
        this.dateOfNextTyreChange = dateOfNextTyreChange;
    }

    public int getKilometersForNextOilChange() {

        return kilometersForNextOilChange;
    }

    public void setKilometersForNextOilChange(int kilometersForNextOilChange) {
        this.kilometersForNextOilChange = kilometersForNextOilChange;
    }



}
