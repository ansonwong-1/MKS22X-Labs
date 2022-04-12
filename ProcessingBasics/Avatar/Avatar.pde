void avatar(int x, int y){
  // body
  fill(20, 200, 20);
  circle(x, y, 100);
  fill(255);
  // eyes
  ellipse(x - 30, y - 30, 20, 30);
  ellipse(x + 30, y - 30, 20, 30);
  fill(0);
  ellipse(x - 30, y - 30, 15, 22.5);
  ellipse(x + 30, y - 30, 15, 22.5);
  // nostrils
  ellipse(x - 15, y + 10, 10, 15);
  ellipse(x + 15, y + 10, 10, 15);
}

int x,y;
int MODE;
void setup(){
   size(800,800);
   MODE = 2;
   x = width/2;
   y = height/2;
}
void draw(){
   background(255);
   x = change(x);
   y = change(y);
   avatar(x,y);
   
}
int change(int value){
  /**
   mode 1: return a random location on the screen.
   mode 2: change value by +1, 0, or -1 randomly
   mode 3: change value by +1 , but if it goes past the end of the screen ,
   wrap back around to the other end of the screen.
  */

  switch(MODE){
   case 1:
     return (int)random(700);
   case 2:
     return value + (int)random(-2, 2);
   case 3:
     if(value == 800){
       return value - 800;
     }else{
       return value + 1;
     }
   default:
     return width/2;
  }
}

void mouseClicked(){
  if(MODE < 3){
    MODE++;
  }else{
    MODE = 0;
  }
}
