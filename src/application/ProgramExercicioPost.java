package application;

import entities.Comment;
import entities.Post;

import java.io.PrintStream;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class ProgramExercicioPost {
    public static void main(String[] args) throws ParseException {
        PrintStream show = System.out;
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyy HH:mm:ss");

        Comment c1 = new Comment("Have a nice trip!");
        Comment c2 = new Comment("Wow that's awesome!");
        //variavel p1 do tipo Post recebendo um novo Posto(new Post)
        Post p1 = new Post(sdf.parse("21/06/2018 13:05:44"),
                "Traveling to New Zealand",
                "I'm going to visit this wonderful country!",
                12);

        p1.addComment(c1);
        p1.addComment(c2);

        c1 = new Comment("Good night");
        c1 = new Comment("May the Force be with you");

        Post p2 = new Post(sdf.parse("28/07/2018 23:14:19"),
                "Good night guys",
                "See you tomorrow",
                5);

        p2.addComment(c1);
        p2.addComment(c2);

        show.println(p1);
        show.println(p2);
    }
}
