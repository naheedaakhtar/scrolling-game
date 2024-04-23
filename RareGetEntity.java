//A RareGetEntity is a special kind of GetEntity that spawns more infrequently than the regular GetEntity
//When consumed, RareGetEntities restores the PlayerEntity's HP in addition to awarding points
//Otherwise, behaves the same as a regular GetEntity
public class RareGetEntity extends GetEntity{
    
    //Location of image file to be drawn for a RareGetEntity
    private static final String RAREGET_IMAGE_FILE = "assets/present1.png";

    //The point value for colliding with a RareEntity
    private static final int RARE_GET_POINT_VALUE=30;

    
    public RareGetEntity(){
        this(0, 0);        
    }
    
    public RareGetEntity(int x, int y){
        super(x, y, RAREGET_IMAGE_FILE);  
    }

    public int getPointsValue(){
        return RARE_GET_POINT_VALUE;
    }

    public int getDamageValue(){  //Rare Entities dont impact the hp
        return 0;
    }
}
