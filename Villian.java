public class Villian extends Entity{

    //Image File
    private static final String SANTA_IMAGE= "assets/santa_noback.png";
    // Dimensions of Santa
    private static final int PLAYER_WIDTH=75;
    private static final int PLAYER_HEIGHT=75;
    
    //Default Movement Speed
    private static final int DEFAULT_MOVEMENT_SPEED=10;

    //Starting hit points
    private static int STARTING_HP=10;

    //current speed 
    private int santaSpeed;

    // current hp
    private int hp;

    public Villian(){
        this(300,60);
    }

    public Villian(int x, int y){
        super(x,y,PLAYER_WIDTH, PLAYER_HEIGHT,SANTA_IMAGE);
        this.hp=STARTING_HP;
        this.santaSpeed=DEFAULT_MOVEMENT_SPEED;
    }

    public void MoveSantaUp(){
        int newSantaY= this.getY()-this.getMovementSpeed();
        setY(newSantaY);
    }

    public void MoveSantaDown(){
        int newSantaYD= this.getY()+this.getMovementSpeed();
        setY(newSantaYD);
    }

    public int getMovementSpeed(){
        return this.santaSpeed;
    }

    public int getHP(){
        return hp;
    }

    public boolean setHP(int newHP){
        this.hp= newHP;
        return(this.hp>0);
    }

    public boolean modifyHP(int change){
        this.hp+=change;
        return (this.hp>0);
    }

    }