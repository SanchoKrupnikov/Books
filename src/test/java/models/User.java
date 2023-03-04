package models;

import lombok.Data;

import java.util.List;

@Data
public class User {
        public String userID;
        public String username;
        public List<Book> books;
}
