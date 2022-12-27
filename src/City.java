public class City {
    private String cityName;
    private String geographicDistrict;
    private String streetList;

    public String toString() {
     String cityContent;
     cityContent = "The name of the city is: " + this.cityName +
             "The geographic district is: " + this.geographicDistrict +
             "The name of the street is: " + this.streetList;
     return cityContent;
    }

}
