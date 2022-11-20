package userData;

import java.util.Map;

public class Company {


    private String name;

    private String catchPhrase;

    private String bs;

    public Company() {

    }

    public Company(String name, String catchPhrase, String bs) {
        this.name = name;
        this.catchPhrase = catchPhrase;
        this.bs = bs;
    }

    public String getName() {
        return name;
    }


    public void setName(String name) {
        this.name = name;
    }

    public Company withName(String name) {
        this.name = name;
        return this;
    }


    public String getCatchPhrase() {
        return catchPhrase;
    }


    public void setCatchPhrase(String catchPhrase) {
        this.catchPhrase = catchPhrase;
    }

    public Company withCatchPhrase(String catchPhrase) {
        this.catchPhrase = catchPhrase;
        return this;
    }


    public String getBs() {
        return bs;
    }

    public void setBs(String bs) {
        this.bs = bs;
    }

    public Company withBs(String bs) {
        this.bs = bs;
        return this;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(Company.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
        sb.append("name");
        sb.append('=');
        sb.append(((this.name == null) ? "<null>" : this.name));
        sb.append(", \n");
        sb.append("catchPhrase");
        sb.append('=');
        sb.append(((this.catchPhrase == null) ? "<null>" : this.catchPhrase));
        sb.append(", \n");
        sb.append("bs");
        sb.append('=');
        sb.append(((this.bs == null) ? "<null>" : this.bs));
        sb.append(", \n");
        if (sb.charAt((sb.length() - 1)) == ',') {
            sb.setCharAt((sb.length() - 1), ']');
        } else {
            sb.append(']');
        }
        return sb.toString();
    }

}