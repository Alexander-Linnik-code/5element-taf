package by.itacademy.linnik.pagesapi;


import java.util.Objects;

public class Body {
    private String phone;

    public Body(String phone) {
        this.phone = phone;
    }

    public String getPhone() {
        return phone;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Body body = (Body) o;
        return Objects.equals(phone, body.phone);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(phone);
    }

    @Override
    public String toString() {
        return "Body{" +
                "phone='" + phone + '\'' +
                '}';
    }
}
