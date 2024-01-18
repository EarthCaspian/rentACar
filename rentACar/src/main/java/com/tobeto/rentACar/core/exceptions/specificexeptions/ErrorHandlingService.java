package com.tobeto.rentACar.core.exceptions.specificexeptions;

public class ErrorHandlingService {

    public static String getBrandNotFoundMessage(int brandId) {
        return "Brand ID not found: " + brandId;
    }

    public static String getCarNotFoundMessage(int carId) {
        return "Car ID not found: " + carId;
    }

    public static String getColorNotFoundMessage(int colorId) {
        return "Color ID not found: " + colorId;
    }

    public static String getCorporateCustomerNotFoundMessage(int corporateCustomerId) {
        return "CorporateCustomer ID not found: " + corporateCustomerId;
    }

    public static String getCustomerNotFoundMessage(int customerId) {
        return "Customer ID not found: " + customerId;
    }

    public static String getInvoiceNotFoundMessage(int invoiceId) {
        return "Invoice ID not found: " + invoiceId;
    }

    public static String getModelNotFoundMessage(int modelId) {
        return "Model ID not found: " + modelId;
    }

    public static String getRentalNotFoundMessage(int rentalId) {
        return "Rental ID not found: " + rentalId;
    }

    public static String getUserNotFoundMessage(int userId) {
        return "User ID not found: " + userId;
    }

}
