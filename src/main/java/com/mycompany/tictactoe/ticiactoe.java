/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.tictactoe;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.util.Scanner;
import java.net.*;
import javax.swing.JFrame;
import java.io.*;
import javax.imageio.ImageIO;
import javax.swing.JPanel;

public class ticiactoe implements Runnable{
private String ip = "localhost";
private int port = 22222;
private Scanner scanner = new Scanner(System.in);

private JFrame frame;
private final int WIDTH = 506;
private final int HEIGHT = 527;
private Thread thread;

private Painter painter;
private Socket socket;
private DataOutputStream dos;
private DataInputStream dis;

private ServerSocket serverSocket;

private BufferedImage board;
private BufferedImage redX;
private BufferedImage blueX;
private BufferedImage redCircle;
private BufferedImage blueCircle;

private String[] spaces = new String[9];

private boolean yourTurn = false;
private boolean circle = true;
private boolean accepted = false;
private boolean unableToCommunicateWithOpponent = false;
private boolean won = false;
private boolean enemyWon = false;
private boolean tie = false;

private int lengthOfSpace = 160;
private int errors = 0;
private int firstSpot = -1;
private int secondSpot = -1;

private Font font = new Font("Verdana", Font.BOLD, 32);
private Font smallerFont = new Font("Verdana", Font.BOLD, 20);
private Font largerFont = new Font("Verdana", Font.BOLD, 50);

private String waitingString = "Waiting for another player";
private String unableToCommunicateWithOpponentString = "Unable to communicate with opponent.";
private String wonString = "You won!";
private String enemyWonString = "Opponent won!";

public ticiactoe() {
    System.out.println("Please input the IP: ");
    ip = scanner.nextLine();
    System.out.println("Please input the port: ");
    port = scanner.nextInt();
    while(port < 1 || port > 65535) {
    System.out.println("The port you entered was invalid, please input another port: ");
    port  =scanner.nextInt();
    }
    loadImages();
    
    painter  =  new Painter();
     painter.setPreferredSize(new Dimension(WIDTH, HEIGHT));
    }

private void loadImages() {
try { 
    BufferedImage board = ImageIO.read(getClass().getResourceAsStream("/board.png"));
    BufferedImage redX = ImageIO.read(getClass().getResourceAsStream("/redx.png"));
    BufferedImage redCircle = ImageIO.read(getClass().getResourceAsStream("/redCircle.png"));
    BufferedImage bluex = ImageIO.read(getClass().getResourceAsStream("/bluex.png"));
    BufferedImage blueCircle = ImageIO.read(getClass().getResourceAsStream("/blueCircle.png"));
} catch (IOException e) {
    e.printStackTrace();
}
}
public void run() {
  while(true) {
    tick();
    painter.repaint();
      
    if(!circle & !accepted) {
    listenForServerRequest();
}
}
}
private void render(Graphics g) {
}
private void tick() {
    if(errors >10) unableToCommunicateWithOpponent = true;
}
private void checkForwin() {
}
private void checkForEnemywin() {
}
private void checkforTie() {
}
private void listenForServerRequest() {
		Socket socket = null;
		try {
			socket = serverSocket.accept();
			dos = new DataOutputStream(socket.getOutputStream());
			dis = new DataInputStream(socket.getInputStream());
                    boolean accepted = true;
			System.out.println("CLIENT HAS REQUESTED TO JOIN, AND WE HAVE ACCEPTED");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

private boolean connect() {
		try {
			socket = new Socket(ip, port);
			dos = new DataOutputStream(socket.getOutputStream());
			dis = new DataInputStream(socket.getInputStream());
                    boolean accepted = true;
		} catch (IOException e) {
			System.out.println("Unable to connect to the address: " + ip + ":" + port + " | Starting a server");
			return false;
		}
		System.out.println("Successfully connected to the server.");
		return true;
	}

 @SuppressWarnings ("unused")
public static void main(String[] args) {
    ticiactoe ticiactoe = new ticiactoe(); 
}

private class Painter extends JPanel implements MouseListener{ 
        private static final long  serialVersionUID = 1L;
        public Painter() {
        setFocusable(true);
        requestFocus();
        setBackground(Color.WHITE);
        addMouseListener(this);
}

        @Override
        public void mouseClicked(MouseEvent e) {
            throw new UnsupportedOperationException("Not supported yet."); 
        }

        @Override
        public void mousePressed(MouseEvent e) {
            throw new UnsupportedOperationException("Not supported yet."); 
        }

        @Override
        public void mouseReleased(MouseEvent e) {
            throw new UnsupportedOperationException("Not supported yet."); 
        }

        @Override
        public void mouseEntered(MouseEvent e) {
            throw new UnsupportedOperationException("Not supported yet."); 
        }

        @Override
        public void mouseExited(MouseEvent e) {
            throw new UnsupportedOperationException("Not supported yet."); 
        }
        
    
}
}