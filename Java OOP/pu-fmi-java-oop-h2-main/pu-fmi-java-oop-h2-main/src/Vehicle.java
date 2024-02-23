abstract class Vehicle extends GetGUIElements{

    private String kindOfVehicle;
    private String plateNumber;
    private String brand;
    private String model;

    public Vehicle(){}
    public Vehicle(String brand, String model, String plateNumber) {
        this.brand=brand;
        this.model=model;
        this.plateNumber=plateNumber;
    }

    public Vehicle(String brand) {
        this.brand=brand;
    }


    public String getKindOfVehicle(){return kindOfVehicle;}
    public void setKindOfVehicle(String kindOfVehicle){this.kindOfVehicle=kindOfVehicle;}
    public String getPlateNumber(){return plateNumber;}
    public void setPlateNumber(String plateNumber){this.plateNumber=plateNumber;}
    public String getBrand(){return brand;}
    public void setBrand(String brand){this.brand=brand;}
    public String getModel(){return model;}
    public void setModel(String model){this.model=model;}

}
