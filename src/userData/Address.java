package userData;

import java.util.Map;

public class Address {

    private String street;

    private String suite;

    private String city;

    private String zipcode;

    private Geo geo;


    public Address() {

    }

    public Address(String street, String suite, String city,
                   String zipcode, Geo geo, Map<String, Object> additionalProperties) {
        this.street = street;
        this.suite = suite;
        this.city = city;
        this.zipcode = zipcode;
        this.geo = geo;

    }

    public String getStreet() {
        return street;
    }


    public void setStreet(String street) {
        this.street = street;
    }

    public Address withStreet(String street) {
        this.street = street;
        return this;
    }

    public String getSuite() {
        return suite;
    }


    public void setSuite(String suite) {
        this.suite = suite;
    }

    public Address withSuite(String suite) {
        this.suite = suite;
        return this;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public Address withCity(String city) {
        this.city = city;
        return this;
    }


    public String getZipcode() {
        return zipcode;
    }


    public void setZipcode(String zipcode) {
        this.zipcode = zipcode;
    }

    public Address withZipcode(String zipcode) {
        this.zipcode = zipcode;
        return this;
    }


    public Geo getGeo() {
        return geo;
    }


    public void setGeo(Geo geo) {
        this.geo = geo;
    }

    public Address withGeo(Geo geo) {
        this.geo = geo;
        return this;
    }


    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(Address.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
        sb.append("street");
        sb.append('=');
        sb.append(((this.street == null) ? "<null>" : this.street));
        sb.append(", \n");
        sb.append("suite");
        sb.append('=');
        sb.append(((this.suite == null) ? "<null>" : this.suite));
        sb.append(", \n");
        sb.append("city");
        sb.append('=');
        sb.append(((this.city == null) ? "<null>" : this.city));
        sb.append(", \n");
        sb.append("zipcode");
        sb.append('=');
        sb.append(((this.zipcode == null) ? "<null>" : this.zipcode));
        sb.append(", \n");
        sb.append("geo");
        sb.append('=');
        sb.append(((this.geo == null) ? "<null>" : this.geo));
        sb.append(", \n");
        if (sb.charAt((sb.length() - 1)) == ',') {
            sb.setCharAt((sb.length() - 1), ']');
        } else {
            sb.append(']');
        }
        return sb.toString();
    }

}