public class UserService {

    public User createUser (String username, String password, String name){
        User user = new User();
        user.setUsername(username);
        user.setPassword(password);
        user.setName(name);
        return user;
    }

    public String[] parseText(String input){
        String[] userInfo = input.split(",");
        return  userInfo;
    }
}
