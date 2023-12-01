package MiniProject;

public class Customer {
    private int accNo;
    private String nic;
    String fname, lname, dob, tel;

    public void setAcc(int accNo) {
        this.accNo = accNo;
    }

    public int getAcc(){
        return accNo;
    }

    public void setNic(String nic) {
        this.nic = nic;
    }

    public String getNic() {
        return nic;
    }


}
