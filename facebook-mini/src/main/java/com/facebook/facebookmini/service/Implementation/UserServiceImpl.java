package com.facebook.facebookmini.service.Implementation;

import com.facebook.facebookmini.entity.AppUser;
import com.facebook.facebookmini.repository.UserRepository;
import com.facebook.facebookmini.service.UserService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    // Constructor injection for UserRepository
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public Optional<AppUser> getUser(Long id) {
        Optional<AppUser> myUser = userRepository.findById(id);
        if(myUser.isPresent()){
            AppUser appUser = myUser.get();
        }
        return Optional.empty();
    }

    @Override
    public void SignUpAppUser(AppUser appUser) {

         userRepository.save(appUser);

    }

    @Override
    public Optional <AppUser> LoginAppUser(String email, String password) {
//        public class AppUserServiceImpl implements AppUserService {
        Optional<AppUser> optionalAppUser = userRepository.findByEmail(email);
        if(optionalAppUser.isPresent()){
            AppUser appUser = optionalAppUser.get();
            if(appUser.getPassword().equals(password)){
                return optionalAppUser;
            }
        }
        return Optional.empty();
}

    @Override
    public List<AppUser> getAllUsers() {
        List<AppUser> allUsers = userRepository.findAll();
        return allUsers;
    }
}
