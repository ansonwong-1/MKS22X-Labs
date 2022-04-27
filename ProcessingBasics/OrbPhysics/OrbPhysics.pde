    ArrayList<Orb>orbList;
    Orb center = new Orb(500, 400, 0, 0, 20);
    boolean background;
    boolean gravity = true;
    int MODE;
    final int GRAVITY = 0; //bounce
    final int ORBIT = 1;
    final int SPRING = 2;
    final float SPRING_CONSTANT = 0.005;
    final float SPRING_DAMPEN = 0.995;
    final float STRING_LENGTH = 150;
    
    void setup() {
      size(1000, 800);
      orbList = new ArrayList<Orb>();
      background = true;
      MODE = GRAVITY;
    }
    void mouseClicked() {
      //add a new Orb to the orbList, constructed as follows:
      //The x and y positions are the same as the mouse
      //the radius should be between in the range [20.0,70.0)
      //the xSpeed and ySpeed should be in the range [-3.0,3.0)
      orbList.add(new Orb(mouseX, mouseY, 5, 0, 20));
    }
    void draw() {
      if (background){
        background(255);
      }else{
        fill(255);
        rect(0, 0, 100, 80);
      }
      center.display();
      for (Orb o : orbList) {
        o.move();
        o.display();
        if (MODE == ORBIT){
          center.attract(o);
        }
        if (MODE == SPRING){
          center.attractSpring(o);
        }
      }
      fill(0);
      text(frameRate, 20, 20);
      text(orbList.size(), 20, 40);
      if (MODE == GRAVITY){
        text("Gravity", 20, 60);
      }
      else if (MODE == ORBIT){
        text("Orbit", 20, 60);
      }
      else if (MODE == SPRING){
        text("Spring", 20, 60);
      }
    }

    void keyPressed(){
      if (keyCode == BACKSPACE){
        orbList = new ArrayList<Orb>();
      }
      if (key == 'g'){
        if (gravity){
          gravity = false;
        }else{
          gravity = true;
        }
      }
      if (key == 'b'){
        if (background){
          background = false;
        }else{
          background = true;
        }
      }
      if (key == ' '){
        if (MODE == GRAVITY){
          MODE = ORBIT;
        }
        else if (MODE == ORBIT){
          MODE = SPRING;
        }
        else if (MODE == SPRING){
          MODE = GRAVITY;
        }
      }
    }
