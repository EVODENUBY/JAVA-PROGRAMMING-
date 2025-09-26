package com.form;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ShapesMainMenu implements ActionListener {
    JFrame frame;
    JButton rectangleBtn = new JButton("Rectangle");
    JButton triangleBtn = new JButton("Triangle");
    JButton circleBtn = new JButton("Circle");
    JButton squareBtn = new JButton("Square");
    JButton exitBtn = new JButton("Exit");

    //constructor
    public ShapesMainMenu(){
        createWindow();
        setSizeAndLocation();
        addComponentsToFrame();
        addActionEvent();

    }
    private void addActionEvent() {
        circleBtn.addActionListener(this);
        rectangleBtn.addActionListener(this);
        squareBtn.addActionListener(this);
        triangleBtn.addActionListener(this);
        exitBtn.addActionListener(this);
    }

    private void addComponentsToFrame() {
        frame.add(circleBtn);
        frame.add(rectangleBtn);
        frame.add(squareBtn);
        frame.add(triangleBtn);
        frame.add(exitBtn);
    }

    private void setSizeAndLocation() {
        int y=30;
        circleBtn.setBounds(100,y,120,30);
        circleBtn.setCursor(new Cursor(Cursor.HAND_CURSOR));
        circleBtn.setBackground(new Color(33, 99, 182));
        circleBtn.setForeground(Color.white);
        y+=40;
        rectangleBtn.setBounds(100,y,120,30);
        rectangleBtn.setCursor(new Cursor(Cursor.HAND_CURSOR));
        rectangleBtn.setBackground(new Color(33, 99, 182));
        rectangleBtn.setForeground(Color.white);
        y+=40;
        squareBtn.setBounds(100,y,120,30);
        squareBtn.setCursor(new Cursor(Cursor.HAND_CURSOR));
        squareBtn.setBackground(new Color(33, 99, 182));
        squareBtn.setForeground(Color.white);
        y+=40;
        triangleBtn.setBounds(100,y,120,30);
        triangleBtn.setCursor(new Cursor(Cursor.HAND_CURSOR));
        triangleBtn.setBackground(new Color(33, 99, 182));
        triangleBtn.setForeground(Color.white);
        exitBtn.setBounds(100, 190, 120, 30);
    }

    private void createWindow() {
        frame = new JFrame("2D SHAPES PROGRAM");
        frame.setBounds(300,200,350,300);
        frame.getContentPane().setBackground(new Color(206, 206, 203));
        frame.getContentPane().setLayout(null);
        frame.setVisible(true);
        frame.setResizable(false);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }


    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==circleBtn){
            new CircleShape();
        } else if (e.getSource()==rectangleBtn) {
            new RectangleShape();

        }else if (e.getSource()==squareBtn) {
            new SquareShape();

        }else if (e.getSource()==triangleBtn) {
            new TriangleShape();
        } else if (e.getSource() == exitBtn) {
            JOptionPane.showMessageDialog(frame, "Exiting... Goodbye!");
            System.exit(0);
        }
    }

    public static  void main(String[]args){
        new ShapesMainMenu();
    }
}

//Classes for shapes
class  CircleShape{
    public CircleShape(){
        String radius = JOptionPane.showInputDialog(null,"Enter Radius of circle");
        if(radius !=null){
            double r = Double.parseDouble(radius);
            double area = Math.PI*r*r;
            double perimeter = 2*Math.PI*r;
            JOptionPane.showMessageDialog(null,"Circle \n Radius: "+r+"\nArea: "+area+"\nCircumference: "+perimeter);
        }
    }
}

class  RectangleShape{
    public RectangleShape(){
        String length = JOptionPane.showInputDialog(null,"Enter length of Rectangle");
        String width = JOptionPane.showInputDialog(null,"Enter Width of Rectangle");
        if(length !=null && width!=null){
            double l = Double.parseDouble(length);
            double w= Double.parseDouble(width);
            double area = l*w;
            double perimeter = 2*(l+w);
            JOptionPane.showMessageDialog(null,"Rectangle \nArea: "+area+"\nPerimeter: "+perimeter);
        }
    }
}
class  SquareShape{
    public SquareShape(){
        String side = JOptionPane.showInputDialog(null,"Enter Side of Square");
        if(side !=null){
            double s = Double.parseDouble(side);
            double area = s*s;
            double perimeter = 4*s;
            JOptionPane.showMessageDialog(null,"Square \nArea: "+area+"\nPerimeter: "+perimeter);
        }
    }
}
class  TriangleShape{
    public TriangleShape(){
        String base = JOptionPane.showInputDialog(null,"Enter base of Triangle");
        String height = JOptionPane.showInputDialog(null,"Enter Height of Triangle");
        String hypothenus = JOptionPane.showInputDialog(null,"Enter Hypothenus of Triangle");
        if(base!=null && height!=null && hypothenus!=null){
            double b = Double.parseDouble(base);
            double h = Double.parseDouble(height);
            double hy = Double.parseDouble(hypothenus);
            double area = (b*h)/2;
            double perimeter = b+h+hy;
            JOptionPane.showMessageDialog(null,"Triangle \nArea: "+area+"\nCircumference: "+perimeter);
        }
    }
}
