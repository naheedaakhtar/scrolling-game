public class Ornament extends Entity implements Throwable, Consumable {
    //Speed for throwing object 
    private static final int ORNAMENT_SPEED=30;

    //Image Location for Ornament
    private static final String ORNAMENT_IMAGE="assets/ornament.png";

    //Dimensions of Ornament
    private static final int ORNAMENT_WIDTH=70;
    private static final int ORNAMENT_HEIGHT=70;

    public Ornament(int x,int y){
       super(x,y,ORNAMENT_WIDTH,ORNAMENT_HEIGHT,ORNAMENT_IMAGE);
    }
    public int getThrowSpeed(){
        return ORNAMENT_SPEED;
    }
    public void throwIt(){
        setX(getX()+ORNAMENT_SPEED);
    }

    public int getPointsValue(){
        return 0;
    }

    public int getDamageValue(){
        return -1;
    }
}
