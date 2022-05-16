
    static int SPRING = 2;
    static float SPRING_LENGTH = 50;
    static float SPRING_DAMPEN = 0.990;
    static float SPRING_CONSTANT = 0.015;
    static int MODE = SPRING;
    static float GRAVITY = 0.35;
    OrbList orbs;
    void setup() {
      size(1000, 800);
      orbs = new OrbList();
    }
    void mouseClicked() {
      orbs.add(new OrbNode(mouseX,mouseY,0,0,30));
    }
    void draw() {
      background(255);
      orbs.processAll();
      orbs.display();
    }

    void keyPressed(){
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
