package thinkinOO.adapter;

/**
 * Created by 高崇 on 2017/6/28.
 */
public class Hotel {
    private DBSocketInterface dbSocketInterface;
    public Hotel(){};
    public Hotel(DBSocketInterface dbSocketInterface){
        this.dbSocketInterface=dbSocketInterface;
    }
    public void setSocket(DBSocketInterface dbSocketInterface){
        this.dbSocketInterface=dbSocketInterface;
    }
    public  void charge(){
        dbSocketInterface.powerWithTwoRound();
    }
}
