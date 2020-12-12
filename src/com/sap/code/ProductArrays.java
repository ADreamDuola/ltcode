package com.sap.code;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;

//public class FileTransferServer {
//  private int port = 10000;
//  private ServerSocket serverSocket;
//  private static String fileName = "/tmp/hello/hello.txt";
//
//  public FileTransferServer() throws IOException {
//    serverSocket = new ServerSocket();
//    serverSocket.bind(new InetSocketAddress(port));
//    System.out.println("服务器已经启动======");
//  }
//
//  private void receieveFile(String filePath) {
//    while (true) {
//      try {
//        Socket socket = null;
//        socket = serverSocket.accept();
//        System.out.println("接收到客户端的连接=====");
//        DataInputStream dis = new DataInputStream(socket.getInputStream());
//        DataOutputStream dos = new DataOutputStream(new FileOutputStream(filePath));
//        byte[] buf = new byte[1027 * 9];
//        int len = 0;
//        while ((len = dis.read(buf)) != -1) {
//          dos.write(buf, 0, len);
//        }
//        dos.flush();
//        System.out.println("文件接受结束======");
//        dis.close();
//        dos.close();
//      } catch (IOException e) {
//        e.printStackTrace();
//      }
//    }
//  }
//
//  public static void main(String[] args) throws IOException {
//    new FileTransferServer().receieveFile(fileName);
//  }
//}


public class ProductArrays {

  static void productSubArrays(int arr[]) {
    int result = 1;
    int n = arr.length;
    for (int i = 0; i < n; i++) {
      int product = 1;
      for (int j = i; j < n; j++) {
        product = product * arr[j];
        result *= product;
      }
    }
    // i =0 时，[10],[10,3],[10,3,7]三中subarry,算出result = 63000
    // i =1 时，[3],[3,7] 算出result= 3969000
    // i =2 时[7],算出最后的result = 27783000
    System.out.println(result + "\n");
  }

  public static void main(String args[]) {
    int arr[] = {10, 3, 7};
    productSubArrays(arr);
  }
}
