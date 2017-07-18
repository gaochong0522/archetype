package thinkinOO.adapter;

import com.sun.corba.se.impl.orbutil.concurrent.Sync;

/**
 * Created by 高崇 on 2017/6/28.
 */
public class DBSocket implements DBSocketInterface {
    @Override
    public void powerWithTwoRound() {
        System.out.println("使用倆项圆头的插孔供电");
    }
}
