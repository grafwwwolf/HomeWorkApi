package ru.home.service;

import ru.home.service.drivers.DBConnection;
import ru.home.service.interfaces.AuthenticationService;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class AuthenticationServiceImpl implements AuthenticationService {

    private List<UserEntity> userEntityList;
    private static Connection connection;
    private static Statement statement;

    public AuthenticationServiceImpl() {
        this.userEntityList = new ArrayList<>();
        userEntityList.add(new UserEntity("grafwwwolf", "password", "grafwwwolf"));
        userEntityList.add(new UserEntity("robertrath", "password", "robertrath"));
        userEntityList.add(new UserEntity("markel", "password", "markel"));
    }

    @Override
    public void start() {
        try {
            connection = DBConnection.getConnection();
            statement = DBConnection.getStatement();
        } catch (SQLException e) {
            e.printStackTrace();
            DBConnection.closeConnection();
        }
        System.out.println("Authentication service start");
    }

    @Override
    public void stop() {
        System.out.println("Authentication service stop");
        DBConnection.closeConnection();
    }

//    @Override
//    public String getNickNameByLoginAndPassword(String login, String password) {
//        for (UserEntity userEntity: userEntityList) {
//            if (userEntity.login.equals(login) && userEntity.password.equals(password)) {
//                return userEntity.nickName;
//            }
//        }
//        return null;
//    }

    @Override
    public String getNickNameByLoginAndPassword(String login, String password) {
        try {
            return DBConnection.getNickNameByLoginAndPassword(login, password);
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    private class UserEntity {
        private String login;
        private String password;
        private String nickName;

        public UserEntity(String login, String password, String nickName) {
            this.login = login;
            this.password = password;
            this.nickName = nickName;
        }
    }
}
//