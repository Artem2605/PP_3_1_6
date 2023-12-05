package org.example.dao;

import org.example.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.*;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import java.util.List;

@Component
public class MyRepository {

    private final String URL = "http://94.198.50.185:7081/api/users";
    private final HttpHeaders myHeaders = new HttpHeaders();
    private final RestTemplate restTemplate;

    @Autowired
    public MyRepository(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public List<User> getListOfUsers() {
        ResponseEntity<List<User>> responseEntity =
                restTemplate.exchange(URL, HttpMethod.GET, null,
                        new ParameterizedTypeReference<List<User>>() {
                        });
        HttpHeaders headers = responseEntity.getHeaders();
        String sessionID = headers.getFirst(headers.SET_COOKIE);
        myHeaders.add("Cookie", sessionID);
        myHeaders.setContentType(MediaType.APPLICATION_JSON);
        return responseEntity.getBody();
    }

//    public String getUser(Long id) {
//        HttpEntity<String> userHttpEntity = new HttpEntity<>(myHeaders);
//        return restTemplate.exchange(URL + "/" + id, HttpMethod.GET, userHttpEntity, String.class).getBody();
//    }

    public void saveUser(User user) {
        HttpEntity<User> userHttpEntity = new HttpEntity<>(user, myHeaders);
        String key = restTemplate.exchange(URL, HttpMethod.POST, userHttpEntity, String.class).getBody();
        System.out.println(key);
    }

    public void updateUser(User user) {
        HttpEntity<User> userHttpEntity = new HttpEntity<>(user, myHeaders);
        String key = restTemplate.exchange(URL, HttpMethod.PUT, userHttpEntity, String.class).getBody();
        System.out.println(key);
    }

    public void deleteUser(Long id) {
        HttpEntity<User> userHttpEntity = new HttpEntity<>(myHeaders);
        String key = restTemplate.exchange(URL + "/" + id, HttpMethod.DELETE, userHttpEntity, String.class).getBody();
        System.out.println(key);
    }
}