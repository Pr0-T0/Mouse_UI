package com.example.mouseuitest;

import java.nio.ByteBuffer;

public class SignalSender {
    public static void sendMouseData(int x, int y, boolean leftButton, boolean rightButton){
        Messagesender task = new Messagesender("192.168.1.3",7800);
        byte[] data = createMouseData(x, y, leftButton, rightButton);
        task.execute(data);
    }
    private static byte[] createMouseData(int x, int y, boolean leftButton, boolean rightButton){
        ByteBuffer buffer = ByteBuffer.allocate(13);
        buffer.putInt(x);
        buffer.putInt(y);
        buffer.put(leftButton ? (byte) 1 : (byte) 0);
        buffer.put(rightButton ? (byte) 1 : (byte) 0);
        return buffer.array();
    }
    /*private static void readMouseData(byte[] data) {
        ByteBuffer buffer = ByteBuffer.wrap(data);
        int x = buffer.getInt();
        int y = buffer.getInt();
        boolean leftButton = buffer.get() != 0;
        boolean rightButton = buffer.get() != 0;
        System.out.println("x cods:"+x +",y cods:"+y);
        System.out.println("left button :" +leftButton+ ",right button :" +rightButton);
    }*/

}
