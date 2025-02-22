package com.turkcell.flightmanagementsystem.service;

import com.turkcell.flightmanagementsystem.core.exception.jwt.JwtService;
import com.turkcell.flightmanagementsystem.dto.user.ChangeUserPasswordDto;
import com.turkcell.flightmanagementsystem.dto.user.CreateUserDto;
import com.turkcell.flightmanagementsystem.dto.user.LoginUserDto;
import com.turkcell.flightmanagementsystem.dto.user.UserListiningDto;
import com.turkcell.flightmanagementsystem.entity.User;
import com.turkcell.flightmanagementsystem.repository.UserRepository;
import com.turkcell.flightmanagementsystem.rules.UserBusinessRules;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;
    private final JwtService jwtService;
    private final RoleService roleService;
    private final UserBusinessRules userBusinessRules;

    public UserServiceImpl(UserRepository userRepository, JwtService jwtService, RoleService roleService, UserBusinessRules userBusinessRules) {
        this.userRepository = userRepository;
        this.userBusinessRules = userBusinessRules;
        bCryptPasswordEncoder=new BCryptPasswordEncoder();
        this.jwtService = jwtService;
        this.roleService = roleService;
    }

    @Override
    public void add(CreateUserDto createUserDto) {
        Optional<User> optionalUser=userRepository.findByEmail(createUserDto.getEmail());
        userBusinessRules.ValidateUser(optionalUser);
        User user=optionalUser.orElse(new User());
        user.setPassword(bCryptPasswordEncoder.encode(createUserDto.getPassword()));
        user.setEmail(createUserDto.getEmail());
        user.setFirstName(createUserDto.getName());
        user.setLastName(createUserDto.getLastName());
        user.setPhoneNumber(createUserDto.getPhoneNumber());
        userRepository.save(user);
   /* User user= userMapper.createUserFromCreateUserDto(createUserDto);
    userRepository.save(user);
*/
    }

    @Override
    public void update(ChangeUserPasswordDto changeUserPasswordDto) {
        Optional<User> optionalUser=userRepository.findByEmail(changeUserPasswordDto.getEmail());
        userBusinessRules.ValidateUser(optionalUser,changeUserPasswordDto);
        User user=optionalUser.get();
        user.setPassword(bCryptPasswordEncoder.encode(changeUserPasswordDto.getNewPassword()));
        user.setUpdatedAt(new Date(System.currentTimeMillis()));

        userRepository.save(user);



    }

    @Override
    public List<UserListiningDto> getAll() {
        List<UserListiningDto> userListiningDtos=userRepository.findAll()
                .stream()
                .map((user -> new UserListiningDto(user.getFirstName(),user.getLastName(),user.getEmail(),user.getPhoneNumber())))
                .toList();
        return userListiningDtos;
    }

    @Override
    public String login(LoginUserDto loginUserDto) {
        Optional<User> optionalUser=userRepository.findByEmail(loginUserDto.getEmail());
        userBusinessRules.ValidateUser(optionalUser,loginUserDto);
        return jwtService.generateToken(loginUserDto.getEmail());
    }

    @Override
    public Optional<User> findById(UUID id) {
        return userRepository.findById(id);
    }
}
