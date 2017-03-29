/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ohtu.data_access;

import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import ohtu.domain.User;

/**
 *
 * @author mlyra
 */
public class FileUserDAO implements UserDao {
    
    private List<User> users;
    private File file;
    private Scanner scanner;
    
    public FileUserDAO() {
        users = new ArrayList<User>();
        file = new File("salasanat.txt");
        try {
            scanner = new Scanner(file);
        } catch (Exception e) {
            System.out.println("Tiedoston lukeminen epäonnistui. Virhe: " + e.getMessage());
        }
        
        while (scanner.hasNextLine()) {
            String username = scanner.nextLine();
            String password = scanner.nextLine();
            users.add(new User(username, password));
        }        
    }
    
    public void writeFile(String username, String password) throws Exception {
        FileWriter writer = new FileWriter(file, true);
        writer.write(username + "\n");
        writer.write(password + "\n");
        writer.close();
    }    

    @Override
    public List<User> listAll() {
        return users;
    }

    @Override
    public User findByName(String name) {
        for (User user : users) {
            if (user.getUsername().equals(name)) {
                return user;
            }
        }

        return null;
    }

    @Override
    public void add(User user) {
        users.add(user);
        try {
            this.writeFile(user.getUsername(), user.getPassword());
        } catch (Exception e) {
            System.out.println("Tiedostoon kirojittamisessa ongelmia. Virhe: " + e.getMessage());
                }
    }
    
    public void setUsers(List<User> users) {
        this.users = users;
    }
    
    public List<User> getUsers() {
        return users;
    }
    
}
