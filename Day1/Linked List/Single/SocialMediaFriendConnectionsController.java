
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class User {
    int userId;
    String name;
    int age;
    List<Integer> friendIds; // List of Friend IDs
    User next;

    public User(int userId, String name, int age) {
        this.userId = userId;
        this.name = name;
        this.age = age;
        this.friendIds = new ArrayList<>();
        this.next = null;
    }
}


class SocialMedia {
    private User head = null;

    // Add a new user to the system
    public void addUser(int userId, String name, int age) {
        User newUser = new User(userId, name, age);
        if (head == null) {
            head = newUser;
        } else {
            User current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = newUser;
        }
        System.out.println("User added: " + name + " (ID: " + userId + ")");
    }

    // Find a user by User ID
    private User findUserById(int userId) {
        User current = head;
        while (current != null) {
            if (current.userId == userId) {
                return current;
            }
            current = current.next;
        }
        return null;
    }

    // Add a friend connection between two users
    public void addFriendConnection(int userId1, int userId2) {
        User user1 = findUserById(userId1);
        User user2 = findUserById(userId2);

        if (user1 == null || user2 == null) {
            System.out.println("One or both users not found.");
            return;
        }

        if (!user1.friendIds.contains(userId2)) {
            user1.friendIds.add(userId2);
            user2.friendIds.add(userId1);
            System.out.println("Friend connection added between " + user1.name + " and " + user2.name);
        } else {
            System.out.println("They are already friends.");
        }
    }

    // Remove a friend connection
    public void removeFriendConnection(int userId1, int userId2) {
        User user1 = findUserById(userId1);
        User user2 = findUserById(userId2);

        if (user1 == null || user2 == null) {
            System.out.println("One or both users not found.");
            return;
        }

        if (user1.friendIds.contains(userId2)) {
            user1.friendIds.remove((Integer) userId2);
            user2.friendIds.remove((Integer) userId1);
            System.out.println("Friend connection removed between " + user1.name + " and " + user2.name);
        } else {
            System.out.println("They are not friends.");
        }
    }

    // Find mutual friends between two users
    public void findMutualFriends(int userId1, int userId2) {
        User user1 = findUserById(userId1);
        User user2 = findUserById(userId2);

        if (user1 == null || user2 == null) {
            System.out.println("One or both users not found.");
            return;
        }

        List<Integer> mutualFriends = new ArrayList<>();
        for (int friendId : user1.friendIds) {
            if (user2.friendIds.contains(friendId)) {
                mutualFriends.add(friendId);
            }
        }

        System.out.println("Mutual Friends between " + user1.name + " and " + user2.name + ":");
        if (mutualFriends.isEmpty()) {
            System.out.println("None");
        } else {
            for (int friendId : mutualFriends) {
                User friend = findUserById(friendId);
                System.out.println("- " + friend.name + " (ID: " + friendId + ")");
            }
        }
    }

    // Display all friends of a specific user
    public void displayFriends(int userId) {
        User user = findUserById(userId);

        if (user == null) {
            System.out.println("User not found.");
            return;
        }

        System.out.println("Friends of " + user.name + ":");
        if (user.friendIds.isEmpty()) {
            System.out.println("No friends.");
        } else {
            for (int friendId : user.friendIds) {
                User friend = findUserById(friendId);
                System.out.println("- " + friend.name + " (ID: " + friendId + ")");
            }
        }
    }

    // Search for a user by Name or User ID
    public void searchUser(String nameOrId) {
        try {
            int userId = Integer.parseInt(nameOrId);
            User user = findUserById(userId);
            if (user != null) {
                System.out.println("User Found: " + user.name + " (ID: " + userId + ", Age: " + user.age + ")");
            } else {
                System.out.println("User not found.");
            }
        } catch (NumberFormatException e) {
            User current = head;
            while (current != null) {
                if (current.name.equalsIgnoreCase(nameOrId)) {
                    System.out.println("User Found: " + current.name + " (ID: " + current.userId + ", Age: " + current.age + ")");
                    return;
                }
                current = current.next;
            }
            System.out.println("User not found.");
        }
    }

    // Count the number of friends for each user
    public void countFriends() {
        User current = head;
        while (current != null) {
            System.out.println(current.name + " has " + current.friendIds.size() + " friends.");
            current = current.next;
        }
    }
}



public class SocialMediaFriendConnectionsController {
    public static void main(String[] args) {
        SocialMedia sm = new SocialMedia();
        Scanner scanner = new Scanner(System.in);

        // Example Usage
        sm.addUser(1, "anil", 25);
        sm.addUser(2, "priya", 30);
        sm.addUser(3, "Rahul", 22);
        sm.addUser(4, "sunil", 28);

        sm.addFriendConnection(1, 2);
        sm.addFriendConnection(1, 3);
        sm.addFriendConnection(2, 4);

        sm.displayFriends(1);
        sm.displayFriends(2);

        sm.findMutualFriends(1, 2);

        sm.removeFriendConnection(1, 2);
        sm.displayFriends(1);
        sm.displayFriends(2);

        sm.searchUser("Alice");
        sm.searchUser("3");

        sm.countFriends();
    }
}
