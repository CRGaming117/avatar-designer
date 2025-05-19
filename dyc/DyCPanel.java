package dyc;

import java.awt.*;
import java.awt.event.*;
import java.io.*;
import javax.swing.*;
import java.util.*;

public class DyCPanel extends JPanel {
  private int w, h;
  private int l;
  private String name = "";
  private JPanel mP, oP, cP, iP, t2, hP, sP, tP, bP;
  private JRadioButton hair, skin, top, bottom, info;
  private JRadioButton st1, st2, st3, st4;
  private JRadioButton hc1, hc2, hc3, hc4, hc5, nh, sh, lh;
  private JRadioButton ls, ss, tc1, tc2, tc3, tc4, tc5, tc6, tcf;
  private JRadioButton bc1, bc2, bc3, bc4, bc5, bc6, bcf;
  private ButtonGroup hcGroup;
  private Color skinColor, hairColor, topColor, bottomColor, favColor, armColor;
  private JTextField nameField, r, g, b;
  private ArrayList<JLabel> texts;
  private ArrayList<Integer> rgb;
  private Scanner fS;

  public DyCPanel(int w, int h) throws FileNotFoundException {
    this.w = w;
    this.h = h;
    setPreferredSize(new Dimension(w, h));
    this.setBackground(new Color(0, 100, 200));
    rgb = new ArrayList<Integer>();
    fS = new Scanner(new File("Colors"));
    int i = 0;
    while (fS.hasNextInt()) {
      rgb.add(fS.nextInt());
      i++;
    }
    cP = new JPanel();
    cP.setPreferredSize(new Dimension(590, 490));
    cP.setBackground(new Color(25, 125, 225));
    mP = new MainPanel();
    mP.setPreferredSize(new Dimension(275, 480));
    mP.setBackground(new Color(0, 175, 255));
    skinColor = Color.white;
    hairColor = skinColor;
    topColor = skinColor;
    armColor = skinColor;
    bottomColor = skinColor;
    favColor = skinColor;
    oP = new JPanel();
    oP.setPreferredSize(new Dimension(295, 480));
    oP.setBackground(new Color(50, 150, 250));
    iP = new JPanel();
    iP.setPreferredSize(new Dimension(285, 470));
    iP.setBackground(new Color(50, 150, 250));
    sP = new JPanel();
    sP.setPreferredSize(new Dimension(285, 470));
    sP.setBackground(new Color(50, 150, 250));
    hP = new JPanel();
    hP.setPreferredSize(new Dimension(285, 470));
    hP.setBackground(new Color(50, 150, 250));
    tP = new JPanel();
    tP.setPreferredSize(new Dimension(285, 470));
    tP.setBackground(new Color(50, 150, 250));
    bP = new JPanel();
    bP.setPreferredSize(new Dimension(285, 470));
    bP.setBackground(new Color(50, 150, 250));
    TabButtonListener tabListener = new TabButtonListener();
    texts = new ArrayList<JLabel>();
    info = new JRadioButton("Info", true);
    info.setPreferredSize(new Dimension(50, 20));
    info.setBackground(new Color(0, 175, 255));
    info.addActionListener(tabListener);
    skin = new JRadioButton("Skin");
    skin.setPreferredSize(new Dimension(50, 20));
    skin.setBackground(new Color(0, 175, 255));
    skin.addActionListener(tabListener);
    hair = new JRadioButton("Hair");
    hair.setPreferredSize(new Dimension(50, 20));
    hair.setBackground(new Color(0, 175, 255));
    hair.addActionListener(tabListener);
    top = new JRadioButton("Top");
    top.setPreferredSize(new Dimension(50, 20));
    top.setBackground(new Color(0, 175, 255));
    top.addActionListener(tabListener);
    bottom = new JRadioButton("Bottom");
    bottom.setPreferredSize(new Dimension(67, 20));
    bottom.setBackground(new Color(0, 175, 255));
    bottom.addActionListener(tabListener);
    ButtonGroup tabs = new ButtonGroup();
    tabs.add(info);
    tabs.add(skin);
    tabs.add(hair);
    tabs.add(top);
    tabs.add(bottom);
    texts.add(new JLabel("Name:"));// text 0
    nameField = new JTextField(name);
    nameField.setPreferredSize(new Dimension(275, 25));
    nameField.addActionListener(new Function());
    texts.add(new JLabel("Favorite Color: "));// text 1
    r = new JTextField("255");
    r.setPreferredSize(new Dimension(50, 25));
    r.addActionListener(new Function());
    g = new JTextField("255");
    g.setPreferredSize(new Dimension(50, 25));
    g.addActionListener(new Function());
    b = new JTextField("255");
    b.setPreferredSize(new Dimension(50, 25));
    b.addActionListener(new Function());
    t2 = new JPanel();
    t2.setPreferredSize(new Dimension(25, 25));
    t2.setBackground(Color.white);
    iP.add(texts.get(0));
    iP.add(nameField);
    iP.add(texts.get(1));
    iP.add(r);
    iP.add(g);
    iP.add(b);
    iP.add(t2);
    texts.add(new JLabel("Skin Tone:"));// text 2
    ColorListener skinListener = new ColorListener();
    st1 = new JRadioButton();
    st1.setPreferredSize(new Dimension(275, 50));
    st1.setBackground(new Color(rgb.get(0), rgb.get(1), rgb.get(2)));
    st1.addActionListener(skinListener);
    st2 = new JRadioButton();
    st2.setPreferredSize(new Dimension(275, 50));
    st2.setBackground(new Color(rgb.get(3), rgb.get(4), rgb.get(5)));
    st2.addActionListener(skinListener);
    st3 = new JRadioButton();
    st3.setPreferredSize(new Dimension(275, 50));
    st3.setBackground(new Color(rgb.get(6), rgb.get(7), rgb.get(8)));
    st3.addActionListener(skinListener);
    st4 = new JRadioButton();
    st4.setPreferredSize(new Dimension(275, 50));
    st4.setBackground(new Color(rgb.get(9), rgb.get(10), rgb.get(11)));
    st4.addActionListener(skinListener);
    ButtonGroup skinTones = new ButtonGroup();
    skinTones.add(st1);
    skinTones.add(st2);
    skinTones.add(st3);
    skinTones.add(st4);
    sP.add(texts.get(2));
    sP.add(st1);
    sP.add(st2);
    sP.add(st3);
    sP.add(st4);
    texts.add(new JLabel("Hair Color:"));// text 3
    ColorListener hairListener = new ColorListener();
    l = 20;
    nh = new JRadioButton("None", true);
    nh.setPreferredSize(new Dimension(275, 25));
    nh.setBackground(new Color(50, 150, 250));
    nh.addActionListener(hairListener);
    sh = new JRadioButton("Short Hair");
    sh.setPreferredSize(new Dimension(275, 25));
    sh.setBackground(new Color(50, 150, 250));
    sh.addActionListener(hairListener);
    lh = new JRadioButton("Long Hair");
    lh.setPreferredSize(new Dimension(275, 25));
    lh.setBackground(new Color(50, 150, 250));
    lh.addActionListener(hairListener);
    ButtonGroup hairLength = new ButtonGroup();
    hairLength.add(nh);
    hairLength.add(sh);
    hairLength.add(lh);
    hc1 = new JRadioButton();
    hc1.setPreferredSize(new Dimension(275, 50));
    hc1.setBackground(new Color(rgb.get(12), rgb.get(13), rgb.get(14)));
    hc1.addActionListener(hairListener);
    hc2 = new JRadioButton();
    hc2.setPreferredSize(new Dimension(275, 50));
    hc2.setBackground(new Color(rgb.get(15), rgb.get(16), rgb.get(17)));
    hc2.addActionListener(hairListener);
    hc3 = new JRadioButton();
    hc3.setPreferredSize(new Dimension(275, 50));
    hc3.setBackground(new Color(rgb.get(18), rgb.get(19), rgb.get(20)));
    hc3.addActionListener(hairListener);
    hc4 = new JRadioButton();
    hc4.setPreferredSize(new Dimension(275, 50));
    hc4.setBackground(new Color(rgb.get(21), rgb.get(22), rgb.get(23)));
    hc4.addActionListener(hairListener);
    hc5 = new JRadioButton();
    hc5.setPreferredSize(new Dimension(275, 50));
    hc5.setBackground(Color.black);
    hc5.addActionListener(hairListener);
    hcGroup = new ButtonGroup();
    hcGroup.add(hc1);
    hcGroup.add(hc2);
    hcGroup.add(hc3);
    hcGroup.add(hc4);
    hcGroup.add(hc5);
    hP.add(texts.get(3));
    hP.add(nh);
    hP.add(sh);
    hP.add(lh);
    hP.add(hc1);
    hP.add(hc2);
    hP.add(hc3);
    hP.add(hc4);
    hP.add(hc5);
    texts.add(new JLabel("Top Clothing:"));// text 4
    ColorListener topListener = new ColorListener();
    ls = new JRadioButton("Long Sleeve", true);
    ls.setPreferredSize(new Dimension(275, 25));
    ls.setBackground(new Color(50, 150, 250));
    ls.addActionListener(topListener);
    ss = new JRadioButton("Short Sleeve");
    ss.setPreferredSize(new Dimension(275, 25));
    ss.setBackground(new Color(50, 150, 250));
    ss.addActionListener(topListener);
    ButtonGroup sleeveGroup = new ButtonGroup();
    sleeveGroup.add(ls);
    sleeveGroup.add(ss);
    tc1 = new JRadioButton();
    tc1.setPreferredSize(new Dimension(130, 50));
    tc1.setBackground(Color.red);
    tc1.addActionListener(topListener);
    tc2 = new JRadioButton();
    tc2.setPreferredSize(new Dimension(130, 50));
    tc2.setBackground(Color.orange);
    tc2.addActionListener(topListener);
    tc3 = new JRadioButton();
    tc3.setPreferredSize(new Dimension(130, 50));
    tc3.setBackground(Color.yellow);
    tc3.addActionListener(topListener);
    tc4 = new JRadioButton();
    tc4.setPreferredSize(new Dimension(130, 50));
    tc4.setBackground(Color.green);
    tc4.addActionListener(topListener);
    tc5 = new JRadioButton();
    tc5.setPreferredSize(new Dimension(130, 50));
    tc5.setBackground(Color.blue);
    tc5.addActionListener(topListener);
    tc6 = new JRadioButton();
    tc6.setPreferredSize(new Dimension(130, 50));
    tc6.setBackground(Color.magenta);
    tc6.addActionListener(topListener);
    tcf = new JRadioButton("Custom");
    tcf.setPreferredSize(new Dimension(130, 50));
    tcf.setBackground(favColor);
    tcf.addActionListener(topListener);
    ButtonGroup topGroup = new ButtonGroup();
    topGroup.add(tc1);
    topGroup.add(tc2);
    topGroup.add(tc3);
    topGroup.add(tc4);
    topGroup.add(tc5);
    topGroup.add(tc6);
    topGroup.add(tcf);
    tP.add(texts.get(4));
    tP.add(ls);
    tP.add(ss);
    tP.add(tc1);
    tP.add(tc2);
    tP.add(tc3);
    tP.add(tc4);
    tP.add(tc5);
    tP.add(tc6);
    tP.add(tcf);
    texts.add(new JLabel("Bottom Clothing:"));// text 5
    texts.add(new JLabel());
    texts.get(6).setPreferredSize(new Dimension(275, 1));
    ColorListener bottomListener = new ColorListener();
    bc1 = new JRadioButton();
    bc1.setPreferredSize(new Dimension(130, 50));
    bc1.setBackground(Color.red);
    bc1.addActionListener(topListener);
    bc2 = new JRadioButton();
    bc2.setPreferredSize(new Dimension(130, 50));
    bc2.setBackground(Color.orange);
    bc2.addActionListener(topListener);
    bc3 = new JRadioButton();
    bc3.setPreferredSize(new Dimension(130, 50));
    bc3.setBackground(Color.yellow);
    bc3.addActionListener(topListener);
    bc4 = new JRadioButton();
    bc4.setPreferredSize(new Dimension(130, 50));
    bc4.setBackground(Color.green);
    bc4.addActionListener(topListener);
    bc5 = new JRadioButton();
    bc5.setPreferredSize(new Dimension(130, 50));
    bc5.setBackground(Color.blue);
    bc5.addActionListener(topListener);
    bc6 = new JRadioButton();
    bc6.setPreferredSize(new Dimension(130, 50));
    bc6.setBackground(Color.magenta);
    bc6.addActionListener(topListener);
    bcf = new JRadioButton("Custom");
    bcf.setPreferredSize(new Dimension(130, 50));
    bcf.setBackground(favColor);
    bcf.addActionListener(topListener);
    ButtonGroup bottomGroup = new ButtonGroup();
    bottomGroup.add(bc1);
    bottomGroup.add(bc2);
    bottomGroup.add(bc3);
    bottomGroup.add(bc4);
    bottomGroup.add(bc5);
    bottomGroup.add(bc6);
    bottomGroup.add(bcf);
    bP.add(texts.get(5));
    bP.add(texts.get(6));
    bP.add(bc1);
    bP.add(bc2);
    bP.add(bc3);
    bP.add(bc4);
    bP.add(bc5);
    bP.add(bc6);
    bP.add(bcf);
    oP.add(info);
    oP.add(skin);
    oP.add(hair);
    oP.add(top);
    oP.add(bottom);
    oP.add(iP);
    oP.add(sP);
    oP.add(hP);
    oP.add(tP);
    oP.add(bP);
    cP.add(mP);
    cP.add(oP);
    this.add(cP);
  }

  private class MainPanel extends JPanel {
    public void paintComponent(Graphics g) {
      super.paintComponent(g);
      g.setColor(hairColor);
      g.fillRect(70, 80, 120, l);// back hair
      g.setColor(skinColor);
      g.fillOval(70, 40, 120, 110);// head
      g.fillRect(110, 140, 40, 20);// neck
      g.fillOval(35, 300, 30, 30);// left hand
      g.fillOval(195, 300, 30, 30);// right hand
      g.setColor(topColor);
      g.fillRect(70, 160, 120, 165);// body
      g.fillArc(35, 160, 70, 120, 90, 90);// left shoulder
      g.fillArc(155, 160, 70, 120, 0, 90);// right shoulder
      g.setColor(armColor);
      g.fillRect(35, 220, 30, 95);// left arm
      g.fillRect(195, 220, 30, 95);// right arm
      g.setColor(bottomColor);
      g.fillRect(70, 325, 50, 120);// left leg
      g.fillRect(140, 325, 50, 120);// right leg
      g.fillArc(50, 415, 40, 60, 0, 180);// left foot
      g.fillArc(170, 415, 40, 60, 0, 180);// right foot
      g.setColor(hairColor);
      g.fillArc(70, 30, 120, 100, 0, 180);// front hair
    }
  }

  private class Function implements ActionListener {
    public void actionPerformed(ActionEvent e) {
      if (e.getSource() == nameField) {
        name = nameField.getText();
        nameField.setText(name);
      } else if (e.getSource() == r || e.getSource() == g || e.getSource() == b) {
        if (Integer.parseInt(r.getText()) > 255)
          r.setText("255");
        else if (Integer.parseInt(g.getText()) > 255)
          g.setText("255");
        else if (Integer.parseInt(b.getText()) > 255)
          b.setText("255");
        if (Integer.parseInt(r.getText()) < 0)
          r.setText("0");
        else if (Integer.parseInt(g.getText()) < 0)
          g.setText("0");
        else if (Integer.parseInt(b.getText()) < 0)
          b.setText("0");
        favColor = new Color(Integer.parseInt(r.getText()), Integer.parseInt(g.getText()),
            Integer.parseInt(b.getText()));
        t2.setBackground(favColor);
        tcf.setBackground(favColor);
        bcf.setBackground(favColor);
      }
    }
  }

  private class TabButtonListener implements ActionListener {
    public void actionPerformed(ActionEvent e) {
      if (info.isSelected()) {
        iP.setVisible(true);
        sP.setVisible(false);
        hP.setVisible(false);
        tP.setVisible(false);
        bP.setVisible(false);
      } else if (skin.isSelected()) {
        sP.setVisible(true);
        iP.setVisible(false);
        hP.setVisible(false);
        tP.setVisible(false);
        bP.setVisible(false);
      } else if (hair.isSelected()) {
        hP.setVisible(true);
        iP.setVisible(false);
        sP.setVisible(false);
        tP.setVisible(false);
        bP.setVisible(false);
      } else if (top.isSelected()) {
        tP.setVisible(true);
        iP.setVisible(false);
        sP.setVisible(false);
        hP.setVisible(false);
        bP.setVisible(false);
      } else if (bottom.isSelected()) {
        bP.setVisible(true);
        iP.setVisible(false);
        sP.setVisible(false);
        hP.setVisible(false);
        tP.setVisible(false);
      }
      oP.repaint();
    }
  }

  private class ColorListener implements ActionListener {
    public void actionPerformed(ActionEvent e) {
      if (e.getSource() == st1)
        skinColor = new Color(rgb.get(0), rgb.get(1), rgb.get(2));
      else if (e.getSource() == st2)
        skinColor = new Color(rgb.get(3), rgb.get(4), rgb.get(5));
      else if (e.getSource() == st3)
        skinColor = new Color(rgb.get(6), rgb.get(7), rgb.get(8));
      else if (e.getSource() == st4)
        skinColor = new Color(rgb.get(9), rgb.get(10), rgb.get(11));
      if (e.getSource() == sh)
        l = 20;
      else if (e.getSource() == lh)
        l = 100;
      else if (e.getSource() == nh) {
        l = 20;
        hairColor = skinColor;
        sh.setSelected(false);
        hcGroup.clearSelection();
      }
      if (e.getSource() == hc1)
        hairColor = new Color(rgb.get(12), rgb.get(13), rgb.get(14));
      else if (e.getSource() == hc2)
        hairColor = new Color(rgb.get(15), rgb.get(16), rgb.get(17));
      else if (e.getSource() == hc3)
        hairColor = new Color(rgb.get(18), rgb.get(19), rgb.get(20));
      else if (e.getSource() == hc4)
        hairColor = new Color(rgb.get(21), rgb.get(22), rgb.get(23));
      else if (e.getSource() == hc5)
        hairColor = Color.black;
      if (e.getSource() == tc1)
        topColor = tc1.getBackground();
      else if (e.getSource() == tc2)
        topColor = tc2.getBackground();
      else if (e.getSource() == tc3)
        topColor = tc3.getBackground();
      else if (e.getSource() == tc4)
        topColor = tc4.getBackground();
      else if (e.getSource() == tc5)
        topColor = tc5.getBackground();
      else if (e.getSource() == tc6)
        topColor = tc6.getBackground();
      else if (e.getSource() == tcf)
        topColor = favColor;
      if (ls.isSelected())
        armColor = topColor;
      else if (ss.isSelected())
        armColor = skinColor;
      if (e.getSource() == bc1)
        bottomColor = bc1.getBackground();
      else if (e.getSource() == bc2)
        bottomColor = bc2.getBackground();
      else if (e.getSource() == bc3)
        bottomColor = bc3.getBackground();
      else if (e.getSource() == bc4)
        bottomColor = bc4.getBackground();
      else if (e.getSource() == bc5)
        bottomColor = bc5.getBackground();
      else if (e.getSource() == bc6)
        bottomColor = bc6.getBackground();
      else if (e.getSource() == bcf)
        bottomColor = favColor;
      mP.repaint();
    }
  }
}
