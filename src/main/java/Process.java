import processing.core.PApplet;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Process extends PApplet{

    List<Ball> balls = new ArrayList<>();

    public void settings(){
        size(400, 600);
    }

    public void mouseClicked(){
        //Every time the mouse is clicked, add a new ball to the list
        balls.add(new Ball(floor(random(width)), -20, floor(random(20))));
    }

    public void draw(){
        //color the background black at the start of each frame
        background(0);

        //for each ball in the list, draw it moving down the screen
        balls.forEach(b -> {
            ellipse(b.x, b.y, b.d, b.d);
            b.y += b.d/2; //balls with bigger diameter fall faster
        });

        //remove a ball from the screen if it's past the bottom of the box
        balls = balls.stream()
                     .filter(b -> b.y < height)
                     .collect(Collectors.toList());
    }
}

class Ball {
    Integer x;
    Integer y;
    Integer d;

    public Ball(Integer x, Integer y, Integer diameter) {
        this.x = x;
        this.y = y;
        this.d = diameter;
    }
}
