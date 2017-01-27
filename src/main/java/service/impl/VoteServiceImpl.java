package service.impl;

import com.opencsv.CSVReader;
import model.User;
import model.Vote;
import org.springframework.stereotype.Service;
import service.VoteService;

import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
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

    public List<Vote> parseCSVVote() throws IOException {

        CSVReader reader = new CSVReader(new FileReader(FILES_VOTE), ',');
        List<Vote> votes = new ArrayList<Vote>();
        List<String[]> records = reader.readAll();
        Iterator<String[]> iterator = records.iterator();
        iterator.next();
        while(iterator.hasNext()){
            String[] record = iterator.next();
            Vote vote = new Vote();
            vote.setId(Long.valueOf(record[0]));
            vote.setNameVote(record[1].replaceAll(" ", ""));
            vote.setCountYes(Long.valueOf(record[2].replaceAll(" ", "")));
            vote.setCountNo(Long.valueOf(record[3].replaceAll(" ", "")));
            vote.setCheckVote(Boolean.parseBoolean(record[4].replaceAll(" ", "")));
            votes.add(vote);
        }
        reader.close();
        return votes;
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
            user.setName(record[1].replaceAll(" ", ""));
            user.setCount(Long.valueOf(record[2].replaceAll(" ", "")));
            users.add(user);
        }
        reader.close();
        return users;
    }

    public User addUser(User user) throws IOException {
        FileWriter writer = new FileWriter(FILES_USER, true);
        BufferedWriter bufferWriter = new BufferedWriter(writer);
        String text = "\n" + user.getId() + ", " + user.getName() + ", " + user.getCount();
        bufferWriter.write(text);
        bufferWriter.close();
        return user;
    }

    public Vote addVote(Vote vote) throws IOException {
        FileWriter writer = new FileWriter(FILES_VOTE, true);
        BufferedWriter bufferWriter = new BufferedWriter(writer);
        String text = "\n" + vote.getId() + ", " + vote.getNameVote() + ", " + vote.getCountYes() + ", "
                + vote.getCountNo() + "," + vote.isCheckVote();
        bufferWriter.write(text);
        bufferWriter.close();
        return vote;
    }

    public User getUser(Long id) throws IOException {
        List<User> users = parseCSVUser();
        if (users != null){
            for (int i = 0;i<users.size();i++){
                if (id.equals(users.get(i).getId())){
                    User user = new User();
                    user = users.get(i);
                    return user;
                }
            }
        }
        return null;
    }

    public Vote getVote(Long id) throws IOException {
        List<Vote> votes = parseCSVVote();
        if (votes != null){
            for (int i = 0;i<votes.size();i++){
                if (id.equals(votes.get(i).getId())){
                    Vote vote = new Vote();
                    vote = votes.get(i);
                    return vote;
                }
            }
        }
        return null;
    }
}
