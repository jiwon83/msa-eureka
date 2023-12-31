package com.example.eurekaclient.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/user-service")
public class UserController {
  @Autowired
  private DiscoveryClient discoveryClient;

  @GetMapping("/hello")
  public String hello(){
    return "success";
  }
  @RequestMapping("/login")
  public ResponseEntity<String> login(){
    return ResponseEntity.status(HttpStatus.OK).body("success");
  }
  @RequestMapping("/{applicationName}")
  public List<ServiceInstance> serviceInstancesByApplicationName(
          @PathVariable String applicationName) {
    return this.discoveryClient.getInstances(applicationName);
  }

}
