package service;

import model.User;
import model.Vote;

import java.io.IOException;
import java.util.List;

/**
 * Created by igor on 27.1.17.
 */
public interface VoteService {

    /**
     * в описании задания про БД и front-end не написано. Для более наглядной работы использую CSV файл.
     *
     */


    /**
     * Чтение файла vote.csv
     * @return Списк голосований
     * @throws IOException
     */
    List<Vote> parseCSVVote() throws IOException;

    /**
     * Чтение файла user.csv
     * @return Список пользователей
     * @throws IOException
     */
    List<User> parseCSVUser() throws IOException;

    /**
     *  Добавление Пользователя
     * @param user
     * @return
     * @throws IOException
     */
    User addUser (User user) throws IOException;

    /**
     *  Добавление Голосования
     * @param vote
     * @return
     * @throws IOException
     */
    Vote addVote (Vote vote) throws IOException;

    /**
     *  Поиск Пользователя
     * @param id
     * @return
     * @throws IOException
     */
    User getUser(Long id) throws IOException;

    /**
     *  Поиск Голосования
     * @param id
     * @return
     * @throws IOException
     */
    Vote getVote(Long id) throws IOException;

    /**
     *  Удаление Пользователя (так же можно по id)
     * @param user
     * @return
     */
    User deleteUser(User user);

    /**
     *  Удаление голосования физически не будет, голосование просто будет закрываться за что и отвечает checkVote
     * @param vote
     * @return
     */
    Vote deleteVote(Vote vote);
}
