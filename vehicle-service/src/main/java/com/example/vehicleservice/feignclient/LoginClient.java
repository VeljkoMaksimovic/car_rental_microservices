package com.example.vehicleservice.feignclient;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient("login-service")
public interface LoginClient {
    @GetMapping(value = "/havePermission/{perm}", headers = {"Username={sender}"})
    Boolean checkPerm(@PathVariable("sender") String sender, @PathVariable("perm") String perm);

    @GetMapping(value = "/user/role/{username}")
    String getRole(@PathVariable("username") String username);
	
    @GetMapping(value = "/getUserType", headers = {"Username={sender}"})
    Boolean getUserType(@PathVariable("sender") String sender);
}
