package com.moneyMaster.Money_Master_WebWizard.service;

import com.moneyMaster.Money_Master_WebWizard.exceptions.UserNotFoundException;
import com.moneyMaster.Money_Master_WebWizard.model.CurrentUser;
import com.moneyMaster.Money_Master_WebWizard.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    private final PasswordEncoder passwordEncoder;

    private static final Logger LOGGER = LoggerFactory.getLogger(UserServiceImpl.class);

    @Override
    public CurrentUser saveUser(CurrentUser user) {
        if (userRepository.findByUsername(user.getUsername()) == null){
            return userRepository.save(new CurrentUser(
                    user.getUsername(),
                    passwordEncoder.encode(user.getPassword()),
                    user.getName(),
                    user.getMobileNumber(),
                    user.getRole()
            ));
        } else {
            throw new RuntimeException("User already exist");
        }
    }

    @Override
    public List<CurrentUser> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public CurrentUser getUser(int id) {

        CurrentUser user = userRepository.findById(id)
                .orElseThrow(() -> new UserNotFoundException());
        LOGGER.info(user.toString());
        return user;
    }
}
