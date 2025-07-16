package com.byterupt.subh.model;

import jakarta.persistence.*;

@Entity
@Table(name = "tbl_students")
public class studentDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String first_name;
    private String middle_name;
    private String last_name;
    private String user_name;
    private String password;
    private String dob;
    private String mobile;
    private String email;

    public studentDetails() {}

    public studentDetails(Long id, String first_name, String middle_name, String last_name, String user_name, String password, String dob, String mobile, String email) {
        this.id = id;
        this.first_name = first_name;
        this.middle_name = middle_name;
        this.last_name = last_name;
        this.user_name = user_name;
        this.password = password;
        this.dob = dob;
        this.mobile = mobile;
        this.email = email;
    }

    // Getters and Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getFirstName() { return first_name; }
    public void setFirstName(String firstName) { this.first_name = first_name; }

    public String getMiddleName() { return middle_name; }
    public void setMiddleName(String middleName) { this.middle_name = middle_name; }

    public String getLastName() { return last_name; }
    public void setLastName(String lastName) { this.last_name = last_name; }

    public String getUserName() { return user_name; }
    public void setUserName(String userName) { this.user_name = user_name; }

    public String getPassword() { return password; }
    public void setPassword(String password) { this.password = password; }

    public String getDob() { return dob; }
    public void setDob(String dob) { this.dob = dob; }

    public String getMobile() { return mobile; }
    public void setMobile(String mobile) { this.mobile = mobile; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }
}
