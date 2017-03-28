package ohtu;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import java.util.ArrayList;
import java.util.List;
import static org.junit.Assert.*;
import ohtu.io.*;
import ohtu.data_access.*;
import ohtu.services.*;

public class Stepdefs {
    App app;
    StubIO io;
    UserDao userDao = new InMemoryUserDao();
    AuthenticationService auth = new AuthenticationService(userDao);
    List<String> inputLines = new ArrayList<>();
    
    @Given("^command login is selected$")
    public void command_login_selected() throws Throwable {
        inputLines.add("login");
    }
    
    @Given("^command new user is selected$")
    public void command_new_user_is_selected() throws Throwable {
        inputLines.add("new");
    }
    
    @Given("^user \"([^\"]*)\" with password \"([^\"]*)\" is created$")
    public void command_new_user_created(String username, String password) throws Throwable {
        inputLines.add("new");
        inputLines.add(username);
        inputLines.add(password);
       
        io = new StubIO(inputLines); 
        app = new App(io, auth);
        app.run();
        
    }
    
    @When("^new username \"([^\"]*)\" and password \"([^\"]*)\" are entered$")
    public void a_new_username_and_password_are_entered(String username, String password) throws Throwable {
       inputLines.add(username);
       inputLines.add(password);
       
       io = new StubIO(inputLines); 
       app = new App(io, auth);
       app.run();
    }
    
    @When("^username \"([^\"]*)\" and too short password \"([^\"]*)\" are entered$")
    public void a_username_and_too_short_password_are_entered(String username, String password) throws Throwable {
       inputLines.add(username);
       inputLines.add(password);
       
       io = new StubIO(inputLines); 
       app = new App(io, auth);
       app.run();
    }
    
    @When("^username \"([^\"]*)\" and illegal password \"([^\"]*)\" are entered$")
    public void a_username_and_illegal_password_are_entered(String username, String password) throws Throwable {
       inputLines.add(username);
       inputLines.add(password);
       
       io = new StubIO(inputLines); 
       app = new App(io, auth);
       app.run();
    }
    
    @When("^too short username \"([^\"]*)\" and password \"([^\"]*)\" are entered$")
    public void too_short_username_and_password_are_entered(String username, String password) throws Throwable {
       inputLines.add(username);
       inputLines.add(password);
       
       io = new StubIO(inputLines); 
       app = new App(io, auth);
       app.run();
    }
    
    @When("^taken username \"([^\"]*)\" and password \"([^\"]*)\" are entered$")
    public void taken_username_and_password_are_entered(String username, String password) throws Throwable {
       inputLines.add(username);
       inputLines.add(password);
       
       io = new StubIO(inputLines); 
       app = new App(io, auth);
       app.run();
    }
    
        
    @When("^username \"([^\"]*)\" and password \"([^\"]*)\" are entered$")
    public void a_username_and_password_are_entered(String username, String password) throws Throwable {
       inputLines.add(username);
       inputLines.add(password);
       
       io = new StubIO(inputLines); 
       app = new App(io, auth);
       app.run();
    }

    @When("^username \"([^\"]*)\" and false password \"([^\"]*)\" are entered$")
    public void a_username_and_false_password_are_entered(String username, String password) throws Throwable {
       inputLines.add(username);
       inputLines.add(password);
       
       io = new StubIO(inputLines); 
       app = new App(io, auth);
       app.run();
    }
    
    @When("^nonexistent user \"([^\"]*)\" and password \"([^\"]*)\" are entered$")
    public void a_nonexistent_username_and_password_are_entered(String username, String password) throws Throwable {
       inputLines.add(username);
       inputLines.add(password);
       
       io = new StubIO(inputLines); 
       app = new App(io, auth);
       app.run();
    }    

    @Then("^system will respond with \"([^\"]*)\"$")
    public void system_will_respond_with(String expectedOutput) throws Throwable {
        assertTrue(io.getPrints().contains(expectedOutput));
    }
    
}
