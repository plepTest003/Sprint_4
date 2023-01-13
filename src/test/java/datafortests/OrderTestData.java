package datafortests;

public class OrderTestData {
    private String userName;
    private String userSurname;
    private String address;
    private String metroStation;
    private String phoneNumber;
    private String orderDate ;
    private String orderComment;

    public String getUserName() {
        return userName;
    }

    public String getUserSurname() {
        return userSurname;
    }
    public String getAddress() {
        return address;
    }

    public String getMetroStation() {
        return metroStation;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getOrderDate() {
        return orderDate;
    }

    public String getOrderComment() {
        return orderComment;
    }

    public OrderTestData(String userName, String userSurname, String address, String metroStation, String phoneNumber) {
        this.userName = userName;
        this.userSurname = userSurname;
        this.address = address;
        this.metroStation = metroStation;
        this.phoneNumber = phoneNumber;
    }
    public OrderTestData(String orderDate, String orderComment) {
        this.orderDate = orderDate;
        this.orderComment = orderComment;
    }
}
