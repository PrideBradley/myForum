package forum.service;

import forum.dataSet.User;

public interface DBService {

    void save(Object data);

    User getUserByLogin(String login);
}