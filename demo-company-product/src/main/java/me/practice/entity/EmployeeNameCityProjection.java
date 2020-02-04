package me.practice.entity;

public interface EmployeeNameCityProjection {
    
	String getName();
    AddressCityProjection getAddress();
    
    public interface AddressCityProjection {
        String getCity();
    }
}
