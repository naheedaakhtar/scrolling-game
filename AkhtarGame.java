import java.awt.*;
import java.awt.event.*;
import java.util.*;
import java.util.Random;

public class AkhtarGame extends SimpleGame{
    // Splash Screen and Background Images
    private static final String CHRISTMAS_BACKGROUND="assets/christmas.png";
    private static final String GAME_RULES="assets/intro.gif";

    //Create the final boss
    protected static Villian santa;


    //Coordinates for Santa Entity to Appear
    private static final int SANTA_WIDTH=825;
    private static final int SANTA_HEIGHT=290;

    //Power boost count
    int powerThrow;

     // COUNT THE KEY_THROWS
     protected int throwcount;




    protected void preGame(){
        
        this.setBackgroundImage(CHRISTMAS_BACKGROUND);
        this.setSplashImage(GAME_RULES);
        super.preGame();
       
    }
    protected void updateGame(){ 
        spawnSanta(); //Creates a new Santa 
        super.updateGame();
        setTitleText("HP:"+" "+player.getHP()+","+" Score: "+score+","+"Special Throws: "+powerThrow); 
        if (!(santa==null)){ //Only move the santa once it exists
            throwEntities(); //Allows you to throw entities
            moveSanta();
            setTitleText("HP:"+" "+player.getHP()+","+" Score: "+score+", Santa HP: "+santa.getHP()+","+"Special Throws: "+powerThrow);        
        }
    }

    protected void spawnSanta(){
        if((super.score>=150)&&((santa==null))){ 
            santa= new Villian(SANTA_WIDTH,SANTA_HEIGHT);
            super.displayList.add(santa);
        }
    }

    //throws the ornament
    protected void throwEntities(){ 
        for (int i=0; i< displayList.size();i++){ //Throw Each Ornament
            if ((displayList.get(i) instanceof Throwable)){
                if (displayList.get(i) instanceof Ornament){
                    ((Ornament)(displayList.get(i))).throwIt();
                    if (santa.isCollidingWith((Ornament)(displayList.get(i)))){
                        if (!(displayList.get(i) instanceof Villian)){
                            handleSantaCollision((Throwable)displayList.get(i));
                    }
                }
                }
                else if (displayList.get(i) instanceof SpecialOrnament){
                    ((SpecialOrnament)(displayList.get(i))).throwIt();
                    if (santa.isCollidingWith((SpecialOrnament)(displayList.get(i)))){
                        if (!(displayList.get(i) instanceof Villian)){
                            handleSantaCollision((Throwable)displayList.get(i));
                    }
                }
            }
            
        }
    }
}
    //Checks to see if santa collides with anything
    protected void handleSantaCollision(Throwable bullet){
        if (bullet instanceof Ornament){
            displayList.remove((Ornament)bullet);
            int santaHPChange= ((Ornament)bullet).getDamageValue();
            santa.modifyHP(santaHPChange);
        }
        else if (bullet instanceof SpecialOrnament){
            displayList.remove((SpecialOrnament)bullet);
            int santaHPChange= ((SpecialOrnament)bullet).getDamageValue();
            santa.modifyHP(santaHPChange);
        }
        if (santa.getHP()==0){
            displayList.remove(santa);
        }
    }

    protected void handlePlayerCollision(Consumable collidedWith){
        super.handlePlayerCollision(collidedWith);
        if (collidedWith instanceof RareGetEntity){
            powerThrow++;
        }
    }

    protected void handleKeyPress(int key){
        super.handleKeyPress(key);
        if (getSplashImage() != null){
            if (key == ADVANCE_SPLASH_KEY){
                super.setSplashImage(null);   
            return;
            }
        }
        else if ((key==KEY_THROW) & (santa!=null)){ //Feature added for creative game
            Entity throwing= new Ornament(player.getX()+player.getWidth()+5,player.getY());
            displayList.add(throwing);
            throwcount++;
        }
        else if ((key==KEY_THROWSPECIAL) & (powerThrow>0) & (santa!=null)){
            Entity specialthrow= new SpecialOrnament(player.getX()+player.getWidth()+5,player.getY());
            displayList.add(specialthrow);
            powerThrow--; //reduces the special throws when you throw one
        }
    }

    protected boolean isGameOver(){
        if ((score>=SCORE_TO_WIN) && (santa.getHP()<=0)){
            return true;
        }
        else if (player.getHP()==0){
            return true;
        }
        else{
            return false;
        }
    }
  
    protected void moveSanta(){
        int toMove= rand.nextInt(20);
        if ((toMove<10) &(!(santa.getY()<0))){
            santa.MoveSantaUp();
        }
        else if ((toMove>10) & (!(santa.getY()+santa.getHeight()>getWindowHeight()))){
            santa.MoveSantaDown();
        }
    }
}

  