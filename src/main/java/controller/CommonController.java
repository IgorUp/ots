package controller;

import model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import service.VoteService;

import java.io.IOException;
import java.util.List;

/**
 * Created by igor on 27.1.17.
 */
@Controller
@ComponentScan("service")
public class CommonController {

    @Autowired
     private VoteService voteService;

    /**
     * Работа с пользователем
     *
     */
    @RequestMapping(value = "/users", method = RequestMethod.GET)
    @ResponseBody
    private List<User> list() {
        List<User> list = null;
        try {
            list = voteService.parseCSVUser();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return list;
    }

    @RequestMapping(value = "/users/{id}", method = RequestMethod.GET)
    @ResponseBody
    private User get(@PathVariable Long id) throws IOException {
        return voteService.getUser(id);
    }


    @RequestMapping(value = "/user", method = RequestMethod.POST)
    @ResponseBody
    private User create(@RequestBody User user) {
        if (user != null){
            try {
                return voteService.addUser(user);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return null;
    }
}
