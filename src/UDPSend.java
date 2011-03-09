import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.Socket;
import java.net.SocketAddress;

public class UDPSend {
  public static void main(String args[]) {
    try {
      String host = "systemintegration.dyndns.org";
      int port = 90;
      Socket requestSocket = new Socket("localhost",port);
      System.out.println(requestSocket.isBound());
      byte[] message = "Java and Support".getBytes();
      // Get the internet address of the specified host
      InetAddress address = InetAddress.getByName(host);
      
      // Initialize a datagram packet with data and address
      DatagramPacket packet = new DatagramPacket(message, message.length, address, port);

      // Create a datagram socket, send the packet through it, close it.
      DatagramSocket dsocket = new DatagramSocket();
      dsocket.send(packet);
      dsocket.close();
    } catch (Exception e) {
      System.err.println(e);
    }
  }
}