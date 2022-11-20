package userData;

import java.util.Map;

public class Geo {

    private String lat;

    private String lng;

    public Geo() {

    }

    public Geo(String lat, String lng) {
        this.lat = lat;
        this.lng = lng;

    }

    public String getLat() {
        return lat;
    }


    public void setLat(String lat) {
        this.lat = lat;
    }

    public Geo withLat(String lat) {
        this.lat = lat;
        return this;
    }


    public String getLng() {
        return lng;
    }


    public void setLng(String lng) {
        this.lng = lng;
    }

    public Geo withLng(String lng) {
        this.lng = lng;
        return this;
    }


    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(Geo.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
        sb.append("lat");
        sb.append('=');
        sb.append(((this.lat == null) ? "<null>" : this.lat));
        sb.append(", \n");
        sb.append("lng");
        sb.append('=');
        sb.append(((this.lng == null) ? "<null>" : this.lng));
        sb.append(", \n");
        if (sb.charAt((sb.length() - 1)) == ',') {
            sb.setCharAt((sb.length() - 1), ']');
        } else {
            sb.append(']');
        }
        return sb.toString();
    }

}