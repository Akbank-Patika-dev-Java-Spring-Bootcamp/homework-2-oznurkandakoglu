package com.example.homework2.mapper;

import com.example.homework2.dto.user.UserDTO;
import com.example.homework2.dto.user.UserSaveRequest;
import com.example.homework2.entity.User;
import com.example.homework2.enums.UserType;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-05-23T22:32:44+0300",
    comments = "version: 1.5.1.Final, compiler: javac, environment: Java 17.0.7 (Oracle Corporation)"
)
public class UserMapperImpl implements UserMapper {

    @Override
    public User convertToUser(UserSaveRequest request) {
        if ( request == null ) {
            return null;
        }

        User user = new User();

        user.setUsername( request.username() );
        user.setPassword( request.password() );
        user.setPhoneNumber( request.phoneNumber() );
        user.setEmail( request.email() );
        user.setUserType( request.userType() );

        return user;
    }

    @Override
    public UserDTO convertToUserDTO(User user) {
        if ( user == null ) {
            return null;
        }

        Long id = null;
        String username = null;
        String phoneNumber = null;
        String password = null;
        String email = null;
        UserType userType = null;

        id = user.getId();
        username = user.getUsername();
        phoneNumber = user.getPhoneNumber();
        password = user.getPassword();
        email = user.getEmail();
        userType = user.getUserType();

        UserDTO userDTO = new UserDTO( id, username, phoneNumber, password, email, userType );

        return userDTO;
    }

    @Override
    public List<UserDTO> convertToUserDTOList(List<User> userList) {
        if ( userList == null ) {
            return null;
        }

        List<UserDTO> list = new ArrayList<UserDTO>( userList.size() );
        for ( User user : userList ) {
            list.add( convertToUserDTO( user ) );
        }

        return list;
    }
}
