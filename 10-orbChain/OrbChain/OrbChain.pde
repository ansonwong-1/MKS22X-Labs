
    static int SPRING = 2;
    static float SPRING_LENGTH = 50;
    static float SPRING_DAMPEN = 0.990;
    static float SPRING_CONSTANT = 0.015;
    static int MODE = SPRING;
    static float GRAVITY = 0.35;
    int CLICK_MODE;
    final int ADD = 0;
    final int INSERT = 1;
    final int DELETE = 2;
    OrbList orbs;
    void setup() {
      size(1000, 800);
      orbs = new OrbList();
      CLICK_MODE = ADD;
    }
    void mouseClicked() {
      if (CLICK_MODE == ADD){
        orbs.add(new OrbNode(mouseX,mouseY,0,0,30));
      }
      if (CLICK_MODE == INSERT){
        orbs.add(mouseX, new OrbNode(mouseX,mouseY,0,0,30));
      }
      if (CLICK_MODE == DELETE){ 
        orbs.delete(orbs.getNodeAt(mouseX, mouseY));
      }
      
    }
    void draw() {
      background(255);
      if (CLICK_MODE == ADD){
        text("ADD", 20, 60);
      }
      if (CLICK_MODE == INSERT){
        text("INSERT", 20, 60);
      }
      if (CLICK_MODE == DELETE){
        text("DELETE", 20, 60);
      }
      orbs.processAll();
      orbs.display();
    }

    void keyPressed(){
      if (key == ' '){
        if (CLICK_MODE != 2){
          CLICK_MODE++;
        }else{
          CLICK_MODE = 0;
        }
      }
      if (key == '1'){
        SPRING_CONSTANT *= 1.05;
      }
      if (key == '2'){
        if (SPRING_CONSTANT * 0.95 > 0.0){
          SPRING_CONSTANT *= 0.95;
        }
      }
      if (key == '3'){
        if (SPRING_DAMPEN * 1.05 < 1.0){
          SPRING_DAMPEN *= 1.05;
        }
      }
      if (key == '4'){
        if (SPRING_DAMPEN * 0.95 > 0.0){
          SPRING_DAMPEN *= 0.95;
        }
      }
      if (key == '5'){
        SPRING_LENGTH *= 1.05;
      }
      if (key == '6'){
        if (SPRING_LENGTH * 0.95 > 0.0){
          SPRING_LENGTH *= 0.95;
        }
       }
      if (key == '7'){
        GRAVITY *= 1.05;
      }
      if (key == '8'){
        if (GRAVITY * 0.95 > 0.0){
          GRAVITY *= 0.95;
        }
      }
    }
