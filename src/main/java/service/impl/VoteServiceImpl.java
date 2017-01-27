package service.impl;

import com.opencsv.CSVReader;
import model.User;
import model.Vote;
import org.springframework.stereotype.Service;
import service.VoteService;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Created by igor on 26.1.17.
 */
@Service
public class VoteServiceImpl implements VoteService {

    private static final String FILES_USER = "user.csv";
    private static final String FILES_VOTE = "vote.csv";

    public void parseCSVVote() throws IOException {

        CSVReader reader = new CSVReader(new FileReader(FILES_VOTE), ',');
        List<Vote> votes = new ArrayList<Vote>();
        List<String[]> records = reader.readAll();
        Iterator<String[]> iterator = records.iterator();
        iterator.next();
        while(iterator.hasNext()){
            String[] record = iterator.next();
            Vote vote = new Vote();
            vote.setId(Long.valueOf(record[0]));
            vote.setNameVote(record[1]);
            vote.setCountYes(Long.valueOf(record[2]));
            vote.setCountNo(Long.valueOf(record[3]));
            vote.setCheckVote(Boolean.parseBoolean(record[4]));
            votes.add(vote);
        }
        reader.close();
    }

    public List<User> parseCSVUser() throws IOException {

        CSVReader reader = new CSVReader(new FileReader(FILES_USER), ',');
        List<User> users = new ArrayList<User>();
        List<String[]> records = reader.readAll();
        Iterator<String[]> iterator = records.iterator();
        iterator.next();
        while(iterator.hasNext()){
            String[] record = iterator.next();
            User user = new User();
            user.setId(Long.valueOf(record[0]));
            user.setName(record[1]);
            user.setCount(Long.valueOf(record[2].replaceAll(" ", "")));
            users.add(user);
        }
        reader.close();
        return users;
    }

    public void addUser() throws IOException {

    }

    public void addVote() throws IOException {

    }


}
