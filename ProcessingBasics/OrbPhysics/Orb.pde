    public class Orb{
      float x,y;
      float xSpeed,ySpeed;
      float radius;
      color c;

      public Orb(float x_,float y_,float xSpeed_, float ySpeed_, float radius_ ){
        x = x_;
        y = y_;
        xSpeed = xSpeed_;
        ySpeed = ySpeed_;
        radius = radius_;
        //random color... why not.
        c = color(random(255),random(255),random(255));
      }


      void display(){
        //Part 1:
        //draw a ellipse at the x,y position, with the correct radius.
        //make sure it is the correct color
        //make sure you read the parameters of ellipse, so that you have the correct size.
        //radius is NOT one of the parameters of ellipse by default.
        fill(c);
        ellipse(x, y, radius * 2, radius * 2);
        line(x, y, x + (5 * xSpeed), y + (5 * ySpeed));
      }

      void move(){
        //PART 2
        //change the x based on the xSpeed
        //change the y based on the ySpeed
        x += xSpeed;
        y += ySpeed;
        
        if (MODE == GRAVITY){
          //PART 3
          //Change the speed when you collide with the end of the screen (all 4 sides)
          if (x+radius >= width || x-radius < 0){
            xSpeed *= -1;
          }
          if (y+radius >= height || y-radius < 0){
            ySpeed *= -1;
          }
        }
        if (gravity){
          //Part 4
          //Add a small adjustment for gravity. Gravity is a ySpeed acceleration...
          //You don't need a variable for this if every object experiences the same
          //gravitational constant (find the value that looks nice experimentally, 9.8 will not work well).
          ySpeed += 0.15;
        }
      }
      void attract(Orb other){
        /*
        dx (xspeed) will be modified as follows:
        dx += x_distance / distance
        Later you can update this by incorporating a gravitational constant and squaring the distance as follows:
        constant of 20
        dx += G * x_distance / (distance * distance)
        */
        float distance = dist(this.x, this.y, other.x, other.y);
        other.xSpeed += 20 * (this.x - other.x) / (distance * distance);
        other.ySpeed += 20 * (this.y - other.y) / (distance * distance);
      }
      void attractSpring(Orb other){
        float distance = dist(this.x, this.y, other.x, other.y);
        other.xSpeed += (distance - STRING_LENGTH)*(SPRING_CONSTANT)*(this.x - other.x)/distance;
        other.ySpeed += (distance - STRING_LENGTH)*(SPRING_CONSTANT)*(this.y - other.y)/distance;
      }
    }
