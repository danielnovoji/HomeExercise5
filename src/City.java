public class City {
    private String cityName;

    private String geographicDistrict;

    public String getCityName() {
        return cityName;
    }

    public String getGeographicDistrict() {
        return geographicDistrict;
    }

    public String getStreetList() {
        return streetList;
    }

    private String streetList;

    public City(String cityName, String geographicDistrict, String streetList) {
        this.cityName = cityName;
        this.geographicDistrict = geographicDistrict;
        this.streetList = streetList;
    }

    public String toString() {
        String cityContent;
        cityContent = "The name of the city is: " + this.cityName +
                "The geographic district is: " + this.geographicDistrict +
                "The name of the street is: " + this.streetList;
        return cityContent;
    }

}
