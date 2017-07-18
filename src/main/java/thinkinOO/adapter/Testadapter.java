package thinkinOO.adapter;

/**
 * Created by 高崇 on 2017/6/28.
 */
public class Testadapter {
    public static void main(String[] args) {
        DBSocketInterface dbSocket = new DBSocket();
        GBScoketInterface gbScoket = new GBScoket();
        Hotel hotel= new Hotel(dbSocket);
        hotel.charge();
        SocketAdapter socketAdapter;
        socketAdapter = new SocketAdapter(gbScoket);
        hotel.setSocket(socketAdapter);
        hotel.charge();
    }
}
