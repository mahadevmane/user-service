package org.open.user.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Department {
    private long departmentId;
    private String departmentName;
    private String address;
    private String departmentCode;
}
