package service;

import model.User;

import java.io.IOException;
import java.util.List;

/**
 * Created by igor on 27.1.17.
 */
public interface VoteService {

    void parseCSVVote() throws IOException;
    List<User> parseCSVUser() throws IOException;
    void addUser () throws IOException;
    void addVote () throws IOException;
}
