package service;

import model.User;
import model.Vote;

import java.io.IOException;
import java.util.List;

/**
 * Created by igor on 27.1.17.
 */
public interface VoteService {

    List<Vote> parseCSVVote() throws IOException;
    List<User> parseCSVUser() throws IOException;
    User addUser (User user) throws IOException;
    Vote addVote (Vote vote) throws IOException;
    User getUser(Long id) throws IOException;
    Vote getVote(Long id) throws IOException;
}
