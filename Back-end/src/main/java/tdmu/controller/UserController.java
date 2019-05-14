package tdmu.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tdmu.model.User;
import tdmu.service.UserService;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/user")
public class UserController {

    /*@Autowired
    private JwtService jwtService;*/
    @Autowired
    private UserService userService;

    /*@RequestMapping(value = "/login", method = RequestMethod.POST)
    public ResponseEntity<String> login(HttpServletRequest request, @RequestBody User user) {
        String result = "";
        HttpStatus httpStatus = null;
        try {
            if (userService.checkLogin(user)) {
                result = jwtService.generateTokenLogin(user.getUsername());
                httpStatus = HttpStatus.OK;
            } else {
                result = "Wrong userId and password";
                httpStatus = HttpStatus.BAD_REQUEST;
            }
        } catch (Exception ex) {
            result = "Server Error";
            httpStatus = HttpStatus.INTERNAL_SERVER_ERROR;
        }
        return new ResponseEntity<String>(result, httpStatus);
    }*/

    @CrossOrigin
    @RequestMapping(value = "/{username}", method = RequestMethod.GET)
    public User findByUsername(@PathVariable String username) {
        return userService.findByUsername(username);
    }

    @CrossOrigin
    @RequestMapping(value = "rating/{userid}/{phoneid}/{score}", method = RequestMethod.POST)
    public void rating(@PathVariable Long userid, @PathVariable Long phoneid, @PathVariable Long score) {
        userService.rating(userid, phoneid, score);
    }
}
