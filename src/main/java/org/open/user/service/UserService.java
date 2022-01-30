package org.open.user.service;

import lombok.extern.slf4j.Slf4j;
import org.open.user.entity.User;
import org.open.user.repository.UserRepository;
import org.open.user.vo.Department;
import org.open.user.vo.UserDepartment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.Optional;

@Service
@Slf4j
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public User saveUser(User user) {
        log.info("Inside saveUser method");
        return userRepository.save(user);
    }

    public UserDepartment getUserWithDepartment(long userId) {
        log.info("Inside getUserWithDepartment method");
        Optional<User> optionalUser = userRepository.findById(userId);
        return optionalUser.map(this::findDepartmentOfUser).orElseGet(UserDepartment::new);
    }

    private UserDepartment findDepartmentOfUser(User user) {
        log.info("Inside findDepartmentOfUser method");

        Department department = WebClient.create("http://localhost:9000/departments/")
                .get()
                .uri(uriBuilder -> uriBuilder.path(String.valueOf(user.getDepartmentId())).build())
                .retrieve()
                .bodyToMono(Department.class)
                .block();

        return new UserDepartment(user, department);
    }
}
