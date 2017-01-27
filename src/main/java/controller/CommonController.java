package controller;

import model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
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
}
