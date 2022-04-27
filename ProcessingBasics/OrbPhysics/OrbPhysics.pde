    ArrayList<Orb>orbList;
    Orb center = new Orb(500, 400, 0, 0, 20);
    boolean background;
    int MODE;
    int GRAVITY = 0;
    int ORBIT = 1;
    
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
      }
      center.display();
      for (Orb o : orbList) {
        o.move();
        o.display();
        center.attract(o);
      }
      fill(0);
      text(frameRate, 20, 20);
      text(orbList.size(), 20, 40);
    }
    void keyPressed(){
      if (keyCode == BACKSPACE){
        orbList = new ArrayList<Orb>();
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
          MODE = GRAVITY;
        }
      }
    }
