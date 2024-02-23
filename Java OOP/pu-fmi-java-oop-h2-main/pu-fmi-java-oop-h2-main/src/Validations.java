public class Validations extends GetGUIElements {

    Car car;
    public Validations(Car car) {this.car = car;}
    public Boolean checkKindOfVehicle(){
        if (this.car.getKindOfVehicle().length()<100){
            return true;
        }else{
            return false;
        }
    }
    public Boolean checkBrand(){
        if (this.car.getBrand().length()<20){
            return true;
        }else{
            return false;
        }
    }

    public Boolean checkModel(){
        if (this.car.getModel().length()<20){
            return true;
        }else{
            return false;
        }
    }

    public Boolean checkPlateNumber(){

        if (this.car.getPlateNumber().length()<10){
            //System.out.println(this.car.getPlateNumber());
            return true;
        }else {

            return false;
        }
    }
    public Boolean checkFuelConsumption(){
        if (this.car.getFuelConsumption()>0){
            return true;
        }else {
            return false;
        }
}

    public Boolean checkGasTankCapacity(){
        if (this.car.getGasTankCapacity()>0){
            return true;
        }else {
            return false;
        }
    }

    public Boolean checkHorsePower(){
        if (this.car.getHorsePower()>0){
            return true;
        }else {
            return false;
        }
    }

    public Boolean checkYearOfManufacturer(){
        if (this.car.getYearOfManufacturer()>0&&this.car.getYearOfManufacturer()<2022){
            return true;
        }else {
            return false;
        }
    }

    public Boolean checkDateOfRegistration(){
        if (this.car.getDateOfRegistration()>0&&this.car.getDateOfRegistration()<2022){
            return true;
        }else {
            return false;
        }
    }
    public Boolean checkDateOfInsurance(){
        if (this.car.getDateOfInsurance()>0&&this.car.getDateOfInsurance()<2022){
            return true;
        }else {
            return false;
        }
    }

    public Boolean checkDateOfTechnicalReview(){
        if (this.car.getDateOfTechnicalReview()>0&&this.car.getDateOfTechnicalReview()<2022){
            return true;
        }else {
            return false;
        }
    }

    public Boolean checkDateOfNextTyreChange(){
        if (this.car.getDateOfNextTyreChange()>0&&this.car.getDateOfNextTyreChange()<2022){
            return true;
        }else {
            return false;
        }
    }

    public Boolean checkKilometersForNextOilChange(){
        if (this.car.getKilometersForNextOilChange()>0){
            return true;
        }else {
            return false;
        }
    }

    public void runAllValidations(){

        checkKindOfVehicle();
        checkBrand();
        checkModel();
        checkPlateNumber();
        checkFuelConsumption();
        checkGasTankCapacity();
        checkHorsePower();
        checkYearOfManufacturer();
        checkDateOfRegistration();
        checkDateOfInsurance();
        checkDateOfTechnicalReview();
        checkDateOfNextTyreChange();
        checkKilometersForNextOilChange();

    }

}
