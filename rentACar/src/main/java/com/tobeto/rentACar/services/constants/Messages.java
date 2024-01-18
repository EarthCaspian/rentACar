package com.tobeto.rentACar.services.constants;

public class Messages {

    public static class User{

        public static String userAddSuccess = "User.userAddSuccess";
        public static String userUpdateSuccess = "User.userUpdateSuccess";
        public static String userDeleteSuccess = "User.userDeleteSuccess";
        public static String getUserNotFoundMessage ="User.getUserNotFoundMessage";
        public static String getUserMailAlreadyExistsMessage="User.getUserMailAlreadyExistsMessage";
    }


    public static class Brand{
        public static String brandAddSuccess = "Brand.brandAddSuccess";
        public static String brandUpdateSuccess = "Brand.brandUpdateSuccess";
        public static String brandDeleteSuccess = "Brand.brandDeleteSuccess";
        public static String getBrandNotFoundMessage ="Brand.getBrandNotFoundMessage";
        public static String getBrandNameAlreadyExistsMessage="Brand.getBrandNameAlreadyExistsMessage";
    }

    public static class Car{
        public static String carAddSuccess = "Car.carAddSuccess";
        public static String carUpdateSuccess = "Car.carUpdateSuccess";
        public static String carDeleteSuccess = "Car.carDeleteSuccess";
        public static String getCarNotFoundMessage ="Car.getCarNotFoundMessage";
        public static String getSameCarPlateMessage="Car.getSameCarPlateMessage";
    }

    public static class Color{
        public static String colorAddSuccess = "Color.colorAddSuccess";
        public static String colorUpdateSuccess = "Color.colorUpdateSuccess";
        public static String colorDeleteSuccess = "Color.colorDeleteSuccess";
        public static String getColorNotFoundMessage ="Color.getColorNotFoundMessage";
        public static String getSameColorNameMessage="Color.getSameColorNameMessage";
    }

    public static class CorporateCustomer{
        public static String corporateCustomerAddSuccess = "CorporateCustomer.corporateCustomerAddSuccess";
        public static String corporateCustomerUpdateSuccess = "CorporateCustomer.corporateCustomerUpdateSuccess";
        public static String corporateCustomerDeleteSuccess = "CorporateCustomer.corporateCustomerDeleteSuccess";
        public static String getCorporateCustomerNotFoundMessage ="CorporateCustomer.getCorporateCustomerNotFoundMessage";
        public static String getSameCorporateCustomerTaxNoMessage="CorporateCustomer.getSameCorporateCustomerTaxNoMessage";
    }


}
