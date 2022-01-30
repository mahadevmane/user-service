package org.open.user.vo;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.open.user.entity.User;

import java.util.Date;

@Data
@NoArgsConstructor
public class UserDepartment {
    private long userId;
    private String firstName;
    private String lastName;
    private Date dob;
    private String gender;
    private String email;
    private Department department;

    public UserDepartment(User user, Department department) {
        this.setUserId(user.getUserId());
        this.setFirstName(user.getFirstName());
        this.setLastName(user.getLastName());
        this.setDob(user.getDob());
        this.setGender(user.getGender());
        this.setEmail(user.getEmail());
        this.setDepartment(department);
    }
}
