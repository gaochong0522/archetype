package thinkinOO.adapter;

/**
 * Created by 高崇 on 2017/6/28.
 */
public class SocketAdapter implements DBSocketInterface{

    private GBScoketInterface gbSocket;

    public SocketAdapter(GBScoketInterface gbScoket){
        this.gbSocket = gbScoket;
    }
    @Override
    public void powerWithTwoRound() {
        gbSocket.powerWithThreeFlat();
    }
}
