package com.example.homework2.controller;

import com.example.homework2.controller.contract.UserControllerContract;
import com.example.homework2.dto.user.UserDTO;
import com.example.homework2.dto.user.UserDeleteRequest;
import com.example.homework2.dto.user.UserSaveRequest;
import com.example.homework2.dto.user.UserUpdateRequest;
import com.example.homework2.general.RestResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;

@RestController
@RequestMapping("api/v1/users")
@RequiredArgsConstructor
public class UserController {

    private final UserControllerContract userControllerContract;

    @PostMapping
    public ResponseEntity<RestResponse<UserDTO>> save(@RequestBody UserSaveRequest userSaveRequest){
        UserDTO userDTO = userControllerContract.save(userSaveRequest);
        return ResponseEntity.ok(RestResponse.of(userDTO));
    }

    @GetMapping
    public ResponseEntity<RestResponse<List<UserDTO>>> findAll(){
        List<UserDTO> userDTOList = userControllerContract.findAll();
        return  ResponseEntity.ok(RestResponse.of(userDTOList));
    }

    @DeleteMapping
    public ResponseEntity<RestResponse<String>> delete(@RequestBody UserDeleteRequest userDeleteRequest){
        userControllerContract.delete(userDeleteRequest);
        return ResponseEntity.ok(RestResponse.of("Deleted!"));
    }

    @GetMapping("/{id}")
    public ResponseEntity<RestResponse<UserDTO>> findById(@PathVariable Long id){
        UserDTO userDTO = userControllerContract.findById(id);
        return ResponseEntity.ok(RestResponse.of(userDTO));
    }

    @GetMapping("/username/{username}")
    public ResponseEntity<RestResponse<UserDTO>> findByUsername(@PathVariable String username){
        UserDTO userDTO = userControllerContract.findByUsername(username);
        return ResponseEntity.ok(RestResponse.of(userDTO));
    }

    @PutMapping("/{id}")
    public ResponseEntity<RestResponse<UserDTO>> update(@PathVariable Long id, @RequestBody UserUpdateRequest userUpdateRequest){
        UserDTO userDTO = userControllerContract.update(id, userUpdateRequest);
        return ResponseEntity.ok(RestResponse.of(userDTO));
    }
}
