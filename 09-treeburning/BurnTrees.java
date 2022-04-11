import java.util.*;
public class BurnTrees{
  private int[][] map;
  private int ticks;
  private static final int TREE = 2;
  private static final int FIRE = 1;
  private static final int ASH = 3;
  private static final int SPACE = 0;
  private Frontier frontier;

  /*Determine if the simulation is still burning
   *@return false if any fires are still burning, true otherwise
   */
  public boolean done(){
    //YOU MUST IMPLEMENT THIS METHOD
    //(BEFORE WRITING ANY CODE READ ALL OF THE CODE AND SEE HOW IT FITS TOGETHER)
    //HINT: do not check the board for fire which is an n^2 operation
    return frontier.size() == 0;//placeholder for compilation purposes
  }


  /*This is the core of the simulation. All of the logic for advancing to the next round goes here.
   *All existing fires spread new fires, and turn to ash
   *new fires should remain fire, and not spread.
   */
  public void tick(){
    ticks++;//leave this here.
    int initSize = frontier.size();
    for(int j = 0; j < initSize; j++){
      int[] burned = frontier.remove();
      int y = burned[0];
      int x = burned[1];
      map[y][x] = ASH;
      if (x - 1 >= 0 && map[y][x - 1] == TREE){
        map[y][x - 1] = FIRE;
        frontier.add(new int[]{y, x - 1});
      }
      if (y - 1 >= 0 && map[y - 1][x] == TREE){
        map[y - 1][x] = FIRE;
        frontier.add(new int[]{y-1, x});
      }
      if(x + 1 < map[0].length && map[y][x+1] == TREE){
        map[y][x+1]=FIRE;
        frontier.add(new int[]{y,x+1});
      }
      if(y + 1 < map.length && map[y+1][x] == TREE){
        map[y+1][x]=FIRE;
        frontier.add(new int[]{y+1,x});
      }
    }


    //YOU MUST IMPLEMENT THE REST OF THIS METHOD
    //(BEFORE WRITING ANY CODE READ ALL OF THE CODE AND SEE HOW IT FITS TOGETHER)
  }

  /***********************YOU MIGHT UPDATE THIS**************************/

  /*Initialize the simulation.
   *If you add more instance variables you can add more here,
   *otherwise it is complete
   */
  public BurnTrees(int width,int height, double density){
    map = new int[height][width];
    frontier = new Frontier();
    for(int r=0; r<map.length; r++ ){
      for(int c=0; c<map[r].length; c++ ){
        if(Math.random() < density){
           map[r][c]=TREE;
         }
       }
     }
     start();//set the left column on fire.
  }


  /*
   *Sets the trees in the left column of the forest on fire
   */
  public void start(){
    //If you add more instance variables you can add more here,
    //otherwise it is complete.
    for(int i = 0; i < map.length; i++){
      if(map[i][0]==TREE){
        frontier.add(new int[]{i, 0});
        map[i][0]=FIRE;
      }
    }
  }



    public static void main(String[]args){
      int WIDTH = 20;
      int HEIGHT = 20;
      int DELAY = 200;
      double DENSITY = .7;

      if(args.length > 1){
        WIDTH = Integer.parseInt(args[0]);
        HEIGHT = Integer.parseInt(args[1]);
        DENSITY = Double.parseDouble(args[2]);
      }
      if(args.length > 3){
        DELAY = Integer.parseInt(args[3]);
      }
      // BurnTrees b = new BurnTrees(WIDTH,HEIGHT,DENSITY);
      //
      //
      // int ans = b.animate(DELAY);//animate all screens
      // System.out.println(ans);//print the final answer
      if (args.length == 0){
        WIDTH = 100;
        HEIGHT = 100;
        System.out.println("100 reps for a 100 x 100 board");
        System.out.println("Density     Average Time (in ticks)");
        String trow = "";
        int percent = 5;
        for (double i = 0.05; i < 1; i+= 0.05){

          double avg = 0;
          int b = 0;
          for (int j = 0; j < 100; j++){
            BurnTrees c = new BurnTrees(WIDTH, HEIGHT, i);
            avg+= c.run();
          }
          if(percent == 5){
            trow = percent + "%          " + (avg/100.0);
          }else{
            trow = percent + "%         " + (avg/100.0);
          }
            System.out.println(trow);
            percent+= 5;
        }
        System.out.println();
        System.out.println();
        System.out.println("Density     Average Time (in ticks)");
        trow = "";
        percent = 60;
        for (double i = 0.60; i < 0.71; i+= 0.01){
          double avg = 0;
          int b = 0;
          for (int j = 0; j < 100; j++){
            BurnTrees c = new BurnTrees(WIDTH, HEIGHT, i);
            avg+= c.run();
          }
          if(percent < 10){
            trow = percent + "%          " + (avg/100.0);
          }else{
            trow = percent + "%         " + (avg/100.0);
          }
            System.out.println(trow);
            percent+= 1;
        }
      }
      //int ans = b.outputAll();//print all screens one after another
      //System.out.println(ans);//print the final answer
    }




  /***********************DO NOT UPDATE THINGS BELOW HERE**************************/

  /*DO NOT UPDATE THIS
   *PLEASE READ SO YOU SEE HOW THE SIMULATION IS SUPPOSED TO WORK!!!
   */
  public int run(){
    while(!done()){
      tick();
    }
    return getTicks();
  }


  /*DO NOT UPDATE THIS*/
  public int getTicks(){
    return ticks;
  }

  /*DO NOT UPDATE THIS*/
  public String toString(){
    StringBuilder builder = new StringBuilder();
    for (int i = 0; i < map.length; i++) {
      for (int c = 0; c < map[i].length; c++) {
        if(map[i][c]==SPACE)
          builder.append(" ");
        else if(map[i][c]==TREE)
          builder.append("@");
        else if(map[i][c]==FIRE)
          builder.append("w");
        else if(map[i][c]==ASH)
          builder.append(".");
      }
      builder.append("\n");
    }
    return builder.toString();
  }

  /*DO NOT UPDATE THIS*/
  public String toStringColor(){
    StringBuilder builder = new StringBuilder();
    for (int i = 0; i < map.length; i++) {
      for (int c = 0; c < map[i].length; c++) {
        if(map[i][c]==0)
          builder.append(" ");
        else if(map[i][c]==2)
          builder.append(Text.color(Text.GREEN)+"@");
        else if(map[i][c]==1)
          builder.append(Text.color(Text.RED)+"w");
        else if(map[i][c]==3)
          builder.append(Text.color(Text.DARK)+".");
      }
      builder.append("\n"+Text.RESET);
    }
    return builder.toString()+ticks+"\n";
  }

  /*DO NOT UPDATE THIS*/
  public int animate(int delay) {
    System.out.print(Text.CLEAR_SCREEN);
    System.out.println(Text.go(1,1)+toStringColor());
    Text.wait(delay);
    while(!done()){
      tick();
      System.out.println(Text.go(1,1)+toStringColor());
      Text.wait(delay);
    }
    return getTicks();
  }

  /*DO NOT UPDATE THIS*/
  public int outputAll(){
    System.out.println(toString());
    while(!done()){
      tick();
      System.out.println(toString());
    }
    return getTicks();
  }


}
