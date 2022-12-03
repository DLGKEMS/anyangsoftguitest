package testpack2;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class mygram extends JFrame {
    public mygram(){
        JFrame myGUI = new JFrame();
        myGUI.setSize(960, 720);
        myGUI.setTitle("등록");
        setTitle("Null Container Sample");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        GraphicExample2 sr = new GraphicExample2();
        sr.fc();
    }}