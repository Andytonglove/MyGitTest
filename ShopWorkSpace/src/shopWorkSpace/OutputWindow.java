package shopWorkSpace;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

import java.io.File;
import java.io.IOException;
//import java.io.*;
//import java.util.*;
import java.awt.event.WindowAdapter;

public class OutputWindow extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3147979497962917324L;


	public OutputWindow() {
//		super("��������ص������ϵͳ V1.0");
		JFrame jf=new JFrame("��������ص������ϵͳ V1.1");
		jf.setSize(860,600);//640ͼƬ̫����
		jf.setLocationRelativeTo(null);
		jf.setResizable(false); 
		jf.setVisible(true);
		jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());//windowsUI
		}catch(Exception e){
			System.out.println("����������ɳ��ִ���");
			System.exit(0);
		}
		
		//jar����ҪͼƬ·�������⣬֮���ٶ��İɣ�
		//�����ǣ���this.getClass().getResource("/image/pic1_1.jpg")����������Ȼ����������\���ܵ��Գɹ������鷳
		/*
		 * java.net.URL imgURL = GUITest.class.getResource("/image/pic1_1.jpg");
		 * ImageIcon img1 = new ImageIcon(imgURL);
		 * */
		//ԭ����·��Ϊ��"src\\images\\pic1_1.jpg"
		//���վ��������Զ����ļ��о���·����ʽ��ȡ�������������ˣ���"D:\\src\\images\\pic1_1.png"
		//ʧ�ܣ�Image imgg = Toolkit.getDefaultToolkit().getImage(getClass().getResource("/images/pic1_1.jpg"));
		
		String dir=System.getProperty("user.dir");   //��ȡ��ǰ·��
			
		ImageIcon ig = new ImageIcon(dir+"\\src\\images\\pic1_1.jpg");//����ͼ��//TODO PICPATH
		Image im = ig.getImage();
		jf.setIconImage(im);
		
		ImageIcon img = new ImageIcon(dir+"\\src\\images\\pic3.jpg");//Ҫ���õı���ͼƬ//TODO PICPATH
		JLabel imgLabel = new JLabel(img);//������ͼ���ڱ�ǩ�
		//jf.getLayeredPane().add(imgLabel, new Integer(Integer.MIN_VALUE));->The constructor Integer(int) is deprecated since version 9
		jf.getLayeredPane().add(imgLabel,Integer.valueOf(Integer.MIN_VALUE));
		imgLabel.setBounds(0, 0, img.getIconWidth(), img.getIconHeight());	
		imgLabel.setOpaque(true);
		
		JPanel p=new JPanel();
		jf.setContentPane(p);//���
		p.setOpaque(false);
		
		JMenuBar menubar1=new JMenuBar();
		jf.setJMenuBar(menubar1);//�˵���
		//�˵���
 		JMenu menu1=new JMenu("ѡ��");
		JMenu menu2=new JMenu("����");
     	JMenu menu3=new JMenu("�鿴");
     	JMenu menu4=new JMenu("����");
		menubar1.add(menu1);
		menubar1.add(menu2);
		menubar1.add(menu3);
		menubar1.add(menu4);
		
 		//�����Ӳ˵���
 		ImageIcon imageIcon_menu=new ImageIcon(dir+"\\src\\images\\newnewpic1_1.png");//TODO PICPATH
		JMenuItem item1=new JMenuItem("ѡ�����",imageIcon_menu);
		JMenuItem item2=new JMenuItem("�ύ����",imageIcon_menu);
     	JMenuItem item3=new JMenuItem("������Ϣ",imageIcon_menu);
     	JMenuItem item4=new JMenuItem("���ӻ�չʾ",imageIcon_menu);
     	JMenuItem item5=new JMenuItem("ʹ���ĵ�",imageIcon_menu);
     	JMenuItem item6=new JMenuItem("������Ŀ",imageIcon_menu);
     	JMenuItem item7=new JMenuItem("��������",imageIcon_menu);   //��Ϊ�����ʷ��¼
     	JMenuItem item8=new JMenuItem("�����ϴ�",imageIcon_menu);
     	JMenuItem item9=new JMenuItem("�����ټ�",imageIcon_menu);
     	menu1.add(item1);
     	menu1.addSeparator();
     	menu1.add(item2);
     	menu1.addSeparator();
     	menu1.add(item3);
     	menu2.add(item4);
     	menu2.addSeparator();
     	menu2.add(item5);
     	menu3.add(item6);
 		menu4.add(item7);
     	menu4.addSeparator();
 		menu4.add(item8);
     	menu4.addSeparator();
 		menu4.add(item9);
     	
 		/*�ѹ������ĵ��˵��������ˣ���������ۺÿ�*/
// 		//��������������
// 		ImageIcon imageIcon_button=new ImageIcon("src\\images\\newnewpic1_1.png");
//	    JButton button1 = new JButton("�����ʷ��¼",imageIcon_button);
// 		JButton button2 = new JButton("�����ϴ�",imageIcon_button);
// 		JButton button3 = new JButton("�����ټ�",imageIcon_button);
// 		//�������������󣬲����������μ���
//	    JToolBar bar = new JToolBar();
// 		bar.add(button1);   
// 		bar.add(button2);        
// 		bar.add(button3);
 		
		//������аڷŹ��������ı�����Ӳ˵�
//		p.setLayout(new BorderLayout());
// 		p.add("North",bar);
		p.setLayout(null);
 		
     	JTextArea textArea=new JTextArea();
//		textArea.setLineWrap(true);
//		textArea.setSize(200,200);
//      p.add("South",textArea);
        p.add(textArea);
        textArea.setBounds(0, 510, 360, 200);//860*600->setBounds(x,y,width,height);
        textArea.setOpaque(false);
        textArea.setEditable(false);//���ɱ༭
        textArea.setForeground(Color.BLUE);
        textArea.setFont(new Font("����",Font.PLAIN,16));//24����̫����
        
    	//������Ϣ����д�رմ���windowClosing������Ϊ�ڲ��࡭��
        class MyWindowListener extends WindowAdapter{
        	public void windowClosing(WindowEvent e) {
        		super.windowClosing(e);
        		textArea.setText(null);
        	}
        }
        
//      DefaultCaret caret = (DefaultCaret)textArea.getCaret();
//      caret.setUpdatePolicy(DefaultCaret.ALWAYS_UPDATE);
//		JScrollPane scrollPane = new JScrollPane(textArea);//��ӹ�����
//		scrollPane.setBounds(0, 500, 330, 200);
//		p.add(scrollPane);
        //�ı�����Զ���������ʧ���ҳ󣬲�����
        
 		ImageIcon imageIcon_button=new ImageIcon(dir+"\\src\\images\\newphotoforbutton_1.png");//TODO PICPATH
        JButton jb1=new JButton("ѡ����̵ص�(C)",imageIcon_button);
        p.add(jb1);
        jb1.setBounds(225,190,160,140);//860*600->setBounds(x:335,y:200,width:160,height:120);
//        jb1.setOpaque(false);//���ڵ�
        jb1.setFont(new Font("����", Font.PLAIN, 20));
        jb1.setForeground(Color.black);
        jb1.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));   //��������ʽ
//        jb1.setBorderPainted(false);//ȥ�߿�
        jb1.setContentAreaFilled(false);//͸��
        /*http://tools.jb51.net/static/colorpicker/*/
        jb1.setBackground(new Color(240,255,255));//��ɫ����Ҫ��͸���ڵ�һ�����ݣ���͸����һ��ֻ�б߿�new Color(240,255,255)ǳɫϵ
        jb1.setOpaque(true);//�ڵ�
        jb1.setBorder(BorderFactory.createRaisedBevelBorder());//͹��ť
        jb1.setVerticalTextPosition(SwingConstants.BOTTOM);//�ı����λ������
        jb1.setHorizontalTextPosition(SwingConstants.CENTER);
        jb1.setMnemonic(java.awt.event.KeyEvent.VK_C);//Alt+c������ݼ�
        
        jb1.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
                //ѡ����̵ص㰴ť
        		JFrame jfb1=new JFrame();
        		jfb1.setTitle("ѡ����̵ص�");
        		jfb1.setSize(820,660);
        		jfb1.setLocationRelativeTo(null);
        		jfb1.setResizable(false); 
        		jfb1.setVisible(true);
        		jfb1.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
//        		ImageIcon ig = new ImageIcon("src\\images\\pic1_1.jpg");
        		Image im = ig.getImage();
        		jfb1.setIconImage(im);
        		ImageIcon img = new ImageIcon(dir+"\\src\\images\\smallbaidumapfor2places_21.png");//TODO PICPATH
        		JLabel imgLabel = new JLabel(img);
        		jfb1.getLayeredPane().add(imgLabel,Integer.valueOf(Integer.MIN_VALUE));
        		imgLabel.setBounds(0, 0, img.getIconWidth(), img.getIconHeight());	
        		imgLabel.setOpaque(true);
        		
        		JPanel pt11=new JPanel();
        		jfb1.setContentPane(pt11);//���
        		pt11.setOpaque(false);
         		pt11.setLayout(null);//���ֹ�����
         		
         		//11������·
                JButton jb11=new JButton("");
                pt11.add(jb11);
                jb11.setBounds(50,20,355,520);//820*660window����ఴť
                jb11.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
                jb11.setBorderPainted(false);
                jb11.setContentAreaFilled(false);
                jb11.setOpaque(false);
                jb11.setBorder(BorderFactory.createRaisedBevelBorder());
//                jb11.setFont(new Font("����", Font.PLAIN, 30));
//                jb11.setForeground(Color.black);
                jb11.setMnemonic(java.awt.event.KeyEvent.VK_K);
                //ȥ�߿򣬳�ȥ����Ŀ򣬲���ӡ�߿�
                jb11.setBorder(null);
                jb11.setBorderPainted(false);
                jb11.setFocusPainted(false);
                //�ı���ʾ��
                JTextField jf11=new JTextField();
                jf11.setLocation(80, 540);
                jf11.setSize(300, 40);
                jf11.setText("ѡ���ѯ������·����(K)");
                pt11.add(jf11);
                jf11.setOpaque(false);
                jf11.setEditable(false);
                jf11.setForeground(Color.black);
                jf11.setFont(new Font("����",Font.PLAIN,24));
                jf11.setBorder(null);
                jf11.setEnabled(false);
                //11����
                jb11.addActionListener(new ActionListener() {
                	public void actionPerformed(ActionEvent e) {
//                		jfb1.remove(pt11);
//                	    jfb1.validate(); 
//                	    jfb1.repaint();   //prefer to write this always.
//                		JPanel pt11_new=new JPanel();
//                		jfb1.setContentPane(pt11_new);
                		jfb1.dispose();
                		try {
                			// TODO ���ӻ���ҳ
                    		JOptionPane.showMessageDialog(null,"������·�ı������ѯ��������ѵõ���\n"
                    				+ "������·�ж����б�����������5��\n"
                    				+ "��ģ����ʣ��ɿ�����������Ϊ��0��\n"
                    				+ "�ýֵ��г����󲻴���������ѡ��Ŷ��\n"
                    				+ "�������ڽ�������web�п��ӻ�������һ�����"
                    				,"����ѡַ����",JOptionPane.PLAIN_MESSAGE,imageIcon_menu);
                    		
                			Desktop.getDesktop().open(new File(dir+"\\src\\������+���ӻ�.html"));
                			//Runtime.getRuntime().exec("rundll32 url.dll,FileProtocolHandler https://map.baidu.com/@12725215.099926004,3559238.3320428324,15.6z");
                		} catch (IOException e1) {
                			e1.printStackTrace();
                		}
                	}
                });
                
         		//12���߸���
                JButton jb12=new JButton("");
                pt11.add(jb12);
                jb12.setBounds(410,80,355,520);//820*660window���Ҳఴť
                jb12.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
                jb12.setBorderPainted(false);
                jb12.setContentAreaFilled(false);
                jb12.setOpaque(false);
                jb12.setBorder(BorderFactory.createRaisedBevelBorder());
//                jb12.setFont(new Font("����", Font.PLAIN, 30));
//                jb12.setForeground(Color.black);
                jb12.setMnemonic(java.awt.event.KeyEvent.VK_L);
                //ȥ�߿򣬳�ȥ����Ŀ򣬲���ӡ�߿�
                jb12.setBorder(null);
                jb12.setBorderPainted(false);
                jb12.setFocusPainted(false);
                //�ı���ʾ��
                JTextField jf12=new JTextField();
                jf12.setLocation(430, 40);
                jf12.setSize(350, 40);
                jf12.setText("ѡ���ѯ����·�򳡽ֵ���(L)");
                pt11.add(jf12);
                jf12.setOpaque(false);
                jf12.setEditable(false);
                jf12.setForeground(Color.black);
                jf12.setFont(new Font("����",Font.PLAIN,24));
                jf12.setBorder(null);
                jf12.setEnabled(false);
                //12����
                jb12.addActionListener(new ActionListener() {
                	public void actionPerformed(ActionEvent e) {
                		jfb1.dispose();
                		try {
                    		JOptionPane.showMessageDialog(null,"������·�ı������ѯ��������ѵõ���\n"
                    				+ "����·�����������б�����������4��\n"
                    				+ "�򳡽ָ����������б�����������3��\n"
                    				+ "��ģ����ʣ��ɿ�����������Ϊ��0��\n"
                    				+ "�ýֵ��г����󲻴���������ѡ��Ŷ��\n"
                    				+ "�������ڽ�������web�п��ӻ�������һ�����"
                    				,"����ѡַ����",JOptionPane.PLAIN_MESSAGE,imageIcon_menu);
                    		JOptionPane.showMessageDialog(null,"��������������ϵͳ�ɵã�\n"
                    				+ "������ѯ��ĸ������·���пɿ������������1��\n"
                    				+ "���ýֵ��г�ʣ���г�������������ѡ��Ŷ��"
                    				,"������������ѡַ����",JOptionPane.PLAIN_MESSAGE,imageIcon_menu);
                			// TODO ���ӻ���ҳ
                			Desktop.getDesktop().open(new File(dir+"\\src\\������+���ӻ�.html"));
                			//Runtime.getRuntime().exec("rundll32 url.dll,FileProtocolHandler https://map.baidu.com/@12725215.099926004,3559238.3320428324,15.6z");
                		} catch (IOException e1) {
                			e1.printStackTrace();
                		}

                	}
                });
                
        	}
        });

        
        JButton jb2=new JButton("�����������(I)",imageIcon_button);
        p.add(jb2);
        jb2.setBounds(445,190,160,140);
        jb2.setOpaque(false);
        jb2.setFont(new Font("����", Font.PLAIN, 20));
        jb2.setForeground(Color.black);
        jb2.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        jb2.setBorder(BorderFactory.createRaisedBevelBorder());
        jb2.setContentAreaFilled(false);
        jb2.setBackground(new Color(207,226,243));//new Color(176,226,255)��ɫϵ��(207,226,243)
        jb2.setOpaque(true);
        jb2.setBorder(BorderFactory.createRaisedBevelBorder());
        jb2.setVerticalTextPosition(SwingConstants.BOTTOM);
        jb2.setHorizontalTextPosition(SwingConstants.CENTER);
        jb2.setMnemonic(java.awt.event.KeyEvent.VK_I);
        
        jb2.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		
        		Object oo=JOptionPane.showInputDialog(null,"������ֵ�Ԥ������������\n","����������",
        				JOptionPane.PLAIN_MESSAGE,imageIcon_menu,null,"��������");
        		Object oo2=JOptionPane.showInputDialog(null,"������ֵ����б���������\n","��������Ŀ����",
        				JOptionPane.PLAIN_MESSAGE,imageIcon_menu,null,"��������");
        		try {
            		String str1=oo.toString();
            		int strnum=Integer.parseInt(str1);
            		String str2=oo2.toString();
            		int strnum2=Integer.parseInt(str2);
            		
            		//��ģ���ݴ���
            		double ans=0;
            		if(strnum<=500) {
            			ans=1-strnum2;
            			if(ans<=0) ans=0;
            			int ans1=(int)(ans);
                		JOptionPane.showMessageDialog(null,"�����������������õ���Ԥ�ڿɹ���������\n"
                				+ "��������Ԥ��ʣ���������ԼΪ"+ans1+"��\n"
                			    + "������������������/���ݽ��٣��������ܴ����������ѡ��\n"
                				+ "����������̿ɲ鿴������Ϣʾ��"
                				,"����������",JOptionPane.PLAIN_MESSAGE,imageIcon_menu);
            		}else if(strnum<=1000 && strnum>500){
            			ans=3-strnum2;
            			if(ans<=0) ans=0;
            			int ans1=(int)(ans);
                		JOptionPane.showMessageDialog(null,"�����������������õ���Ԥ�ڿɹ���������\n"
                				+ "��������Ԥ��ʣ���������ԼΪ"+ans1+"��\n"
                				+ "����������̿ɲ鿴������Ϣʾ��"
                				,"����������",JOptionPane.PLAIN_MESSAGE,imageIcon_menu);
            		}else if(strnum>1000) {
                		ans=(strnum-1000)*0.39468/300+3-strnum2;
            			int ans1=(int)(ans)+1;
            			if(ans<0.5) {
                    		JOptionPane.showMessageDialog(null,"�����������������õ���Ԥ�ڿɹ���������\n"
                    				+ "��������Ԥ��ʣ���������ԼΪ"+ans1+"��\n"
                    			    + "��������չǱ���ϵͣ������ѡ��\n"
                    				+ "����������̿ɲ鿴������Ϣʾ��"
                    				,"����������",JOptionPane.PLAIN_MESSAGE,imageIcon_menu);
            			}else {
                    		JOptionPane.showMessageDialog(null,"�����������������õ���Ԥ�ڿɹ���������\n"
                    				+ "��������Ԥ��ʣ���������ԼΪ"+ans1+"��\n"
                    				+ "����������̿ɲ鿴������Ϣʾ��"
                    				,"����������",JOptionPane.PLAIN_MESSAGE,imageIcon_menu);
            			}

            		}
            		
            		
        		}catch(Exception ee){
        			
            		JOptionPane.showMessageDialog(null,"����δ�������ݻ����벻�Ϸ�\n"
            				+ "����ת�����ݿ�������������ṩ����ʾ��"
            				,"����������",JOptionPane.PLAIN_MESSAGE,imageIcon_menu);
            		
            		JFrame fr22=new JFrame();
            		fr22.setTitle("��������ģ��������ʾ��");
            		fr22.setSize(505,540);
            		fr22.setLocationRelativeTo(null);
            		fr22.setResizable(false); 
            		fr22.setVisible(true);
            		fr22.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
//            		ImageIcon ig = new ImageIcon("src\\images\\pic1_1.jpg");
            		Image im = ig.getImage();
            		fr22.setIconImage(im);
            		
            		ImageIcon img = new ImageIcon(dir+"\\src\\images\\sourceriver1all.png");//TODO PICPATH
            		JLabel imgLabel = new JLabel(img);
            		fr22.getLayeredPane().add(imgLabel,Integer.valueOf(Integer.MIN_VALUE));
            		imgLabel.setBounds(0, 0, img.getIconWidth(), img.getIconHeight());	
            		imgLabel.setOpaque(true);
            		
            		JPanel p22=new JPanel();
            		fr22.setContentPane(p22);//���
            		p22.setOpaque(false);
             		p22.setLayout(null);
             		
                 	JTextArea textArea22=new JTextArea();
            		textArea22.setLineWrap(true);
            		textArea22.setBounds(10, 480, 520, 20);
            		textArea22.setSize(520,20);
                    p22.add(textArea22);
                    textArea22.setOpaque(false);
                    textArea22.setForeground(Color.RED);
                    textArea22.setFont(new Font("����",Font.BOLD,16));
                    textArea22.setText("��ģ��������һ�����Ϸ����ֿɵ���鿴����ʾ������ģ�ĵ�");
                    textArea22.setEditable(false);
                    textArea22.setEnabled(false);
                    
                    JButton jb22=new JButton("");
                    p22.add(jb22);
                    jb22.setBounds(0,0,505,520);
                    jb22.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
                    jb22.setBorderPainted(false);
                    jb22.setContentAreaFilled(false);
                    jb22.setOpaque(false);
                    jb22.setBorder(BorderFactory.createRaisedBevelBorder());
                    jb22.setMnemonic(java.awt.event.KeyEvent.VK_K);
                    jb22.setBorder(null);
                    jb22.setBorderPainted(false);
                    jb22.setFocusPainted(false);
                    
                    jb22.addActionListener(new ActionListener() {
                    	public void actionPerformed(ActionEvent e) {
                    		String filepath=dir+"\\src\\������tj.xlsx";
                            try {
                                File file = new File(filepath);
                                Desktop.getDesktop().open(file); // �������ڱ���������ע��Ĺ���Ӧ�ó��򣬴��ļ�����file��
                            } catch (IOException | NullPointerException eee) { // �쳣����
                                System.err.println(eee);
                            }

                    	}
                    });
            	}
        		      
        	}
        });

        
//        /*TestForWindow*/
//     	JTextArea ta_s=new JTextArea();
//		ta_s.setLineWrap(true);
//		ta_s.setSize(200,200);
//        p.add("Center",ta_s);
//        ta_s.setOpaque(false);
//        ta_s.setForeground(Color.BLACK);
//        ta_s.setFont(new Font("����",Font.BOLD,15));
//        ta_s.setLocation(430, 300);
//        ta_s.append("HELLO WORLD!");

        
//////////////////////////����һ���ָ���//////////////////////////////////////////////
        
		//�˵��еĲ˵���͹������еĹ�������ǰ��������յ�������ķ������ü���
   		//��Ӱ�ť�ĵ�����������������������Ϣ���뵽�ı�����
        
        //ѡ�����
        item1.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		JFrame fr1=new JFrame();
        		fr1.setTitle("ѡ�����");
        		fr1.setSize(300,200);
        		fr1.setLocationRelativeTo(null);
        		fr1.setResizable(false); 
        		fr1.setVisible(true);
        		fr1.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);   		
        		fr1.addWindowListener(new MyWindowListener());
//        		ImageIcon ig = new ImageIcon("src\\images\\pic1_1.jpg");
        		Image im = ig.getImage();
        		fr1.setIconImage(im);
        		
        		ImageIcon img = new ImageIcon(dir+"\\src\\images\\pic4.jpg");//TODO PICPATH
        		JLabel imgLabel = new JLabel(img);
        		fr1.getLayeredPane().add(imgLabel,Integer.valueOf(Integer.MIN_VALUE));
        		imgLabel.setBounds(0, 0, img.getIconWidth(), img.getIconHeight());	
        		imgLabel.setOpaque(true);
        		
        		JPanel p1=new JPanel();
        		fr1.setContentPane(p1);//���
        		p1.setOpaque(false);
         		p1.setLayout(new BorderLayout());
        		
                JButton button11=new JButton("û�ҵ���������ҳ");
                JButton button12=new JButton("�人����");
                
        		JMenuBar menubar_1=new JMenuBar();
        		fr1.setJMenuBar(menubar_1);//�˵���
        		menubar_1.add(button12);
        		menubar_1.add(button11);
        		
//        	    JToolBar bar1 = new JToolBar();
//         		bar1.add(button12);  
//         		bar1.add(button11);   
//         		fr1.add("North",bar1);
//         		bar1.add(button11);
                button11.addActionListener(new ActionListener() {
                	public void actionPerformed(ActionEvent e) {
                		fr1.dispose();
                	}
                });
                button12.addActionListener(new ActionListener() {
                	public void actionPerformed(ActionEvent e) {
                		fr1.dispose();
                		//new OutputWindow();
                	}
                });
                
             	JTextArea textArea1=new JTextArea();
        		textArea1.setLineWrap(true);
        		textArea1.setSize(20,20);
                p1.add("Center",textArea1);
                textArea1.setOpaque(false);
                textArea1.setForeground(Color.RED);
                textArea1.setFont(new Font("����",Font.BOLD,16));
                textArea1.append("Ŀǰֻ֧���人���ֵ��������������С��� ^_^");
                textArea1.setEditable(false);
                
        	}
        });
        //�ύ����
        item2.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		JFrame fr2=new JFrame();
        		fr2.setTitle("�ύ����");
        		fr2.setSize(430,435);
        		fr2.setLocationRelativeTo(null);
        		fr2.setResizable(false); 
        		fr2.setVisible(true);
        		fr2.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        		fr2.addWindowListener(new MyWindowListener());
//        		ImageIcon ig = new ImageIcon("src\\images\\pic1_1.jpg");
        		Image im = ig.getImage();
        		fr2.setIconImage(im);
        		
        		ImageIcon img = new ImageIcon(dir+"\\src\\images\\QRforProject.png");//TODO PICPATH
        		JLabel imgLabel = new JLabel(img);
        		fr2.getLayeredPane().add(imgLabel,Integer.valueOf(Integer.MIN_VALUE));
        		imgLabel.setBounds(0, 0, img.getIconWidth(), img.getIconHeight());	
        		imgLabel.setOpaque(true);
        		
        		JPanel p2=new JPanel();
        		fr2.setContentPane(p2);//���
        		p2.setOpaque(false);
         		p2.setLayout(new BorderLayout());
         		
         		JTextArea t2=new JTextArea();
                t2.setForeground(Color.RED);
                t2.setFont(new Font("����",Font.BOLD,15));
                t2.setSize(img.getIconWidth(), 450-img.getIconHeight());
         		t2.append("   ���������ύ��������Ϊ��Ŀ������ɨ���Ϸ���ά�룡");
                t2.setEditable(false);
         		p2.add("South",t2);
        	}
        });
        
        //������Ϣ
        item3.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		
                Object[] options ={ "�ð���", "ֱ�Ӳ鿴����ʾ������" };  
                int m = JOptionPane.showOptionDialog(null, "���ȿ�����Ŀ��ҳ��", "�鿴",
                		JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE,imageIcon_menu, options, options[0]);  
                if(m!=0) {
                	//ֱ�Ӳ鿴ʵ������
            		JFrame fr22=new JFrame();
            		fr22.setTitle("��������ģ��������");
            		fr22.setSize(505,540);
            		fr22.setLocationRelativeTo(null);
            		fr22.setResizable(false); 
            		fr22.setVisible(true);
            		fr22.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
//            		ImageIcon ig = new ImageIcon("src\\images\\pic1_1.jpg");
            		Image im = ig.getImage();
            		fr22.setIconImage(im);
            		
            		ImageIcon img = new ImageIcon(dir+"\\src\\images\\sourceriver1all.png");//TODO PICPATH
            		JLabel imgLabel = new JLabel(img);
            		fr22.getLayeredPane().add(imgLabel,Integer.valueOf(Integer.MIN_VALUE));
            		imgLabel.setBounds(0, 0, img.getIconWidth(), img.getIconHeight());	
            		imgLabel.setOpaque(true);
            		
            		JPanel p22=new JPanel();
            		fr22.setContentPane(p22);//���
            		p22.setOpaque(false);
             		p22.setLayout(null);
             		
                 	JTextArea textArea22=new JTextArea();
            		textArea22.setLineWrap(true);
            		textArea22.setBounds(10, 480, 520, 20);
            		textArea22.setSize(520,20);
                    p22.add(textArea22);
                    textArea22.setOpaque(false);
                    textArea22.setForeground(Color.RED);
                    textArea22.setFont(new Font("����",Font.BOLD,16));
                    textArea22.setText("��ģ��������һ�����Ϸ����ֿɵ���鿴����ʾ������ģ�ĵ�");
                    textArea22.setEditable(false);
                    textArea22.setEnabled(false);
                    
                    JButton jb22=new JButton("");
                    p22.add(jb22);
                    jb22.setBounds(0,0,505,520);
                    jb22.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
                    jb22.setBorderPainted(false);
                    jb22.setContentAreaFilled(false);
                    jb22.setOpaque(false);
                    jb22.setBorder(BorderFactory.createRaisedBevelBorder());
                    jb22.setMnemonic(java.awt.event.KeyEvent.VK_K);
                    jb22.setBorder(null);
                    jb22.setBorderPainted(false);
                    jb22.setFocusPainted(false);
                    
                    jb22.addActionListener(new ActionListener() {
                    	public void actionPerformed(ActionEvent e) {
                    		String filepath=dir+"\\src\\������tj.xlsx";
                            try {
                                File file = new File(filepath);
                                Desktop.getDesktop().open(file); // �������ڱ���������ע��Ĺ���Ӧ�ó��򣬴��ļ�����file��
                            } catch (IOException | NullPointerException eee) { // �쳣����
                                System.err.println(eee);
                            }

                    	}
                    });
                }else {
                	//�Ȳ鿴��Ŀ��ҳ
            		try {
            			//�ҵ�github��Ŀ��ҳ
            			Runtime.getRuntime().exec("rundll32 url.dll,FileProtocolHandler https://github.com/Andytonglove");
            		} catch (IOException e1) {
            			e1.printStackTrace();
            		}
                }

        	}
        });
        //���̲����������������Ѿ�����Ҫ
//        item3.addKeyListener(new KeyAdapter() {
//            public void keyReleased(KeyEvent e) {
//                if(e.getKeyCode() == KeyEvent.VK_SPACE){
//            		try {
//            			Runtime.getRuntime().exec("rundll32 url.dll,FileProtocolHandler https://www.baidu.com");
//            		} catch (IOException e1) {
//            			e1.printStackTrace();
//            		}
//                }
//            }
//        });
        
        //���ӻ�չʾ����ҳ
        item4.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		try {
        			// TODO ���ӻ���ҳ
        			Desktop.getDesktop().open(new File(dir+"\\src\\������+���ӻ�.html"));
        			//Runtime.getRuntime().exec("rundll32 url.dll,FileProtocolHandler https://map.baidu.com/@12725215.099926004,3559238.3320428324,15.6z");
        		} catch (IOException e1) {
        			e1.printStackTrace();
        		}
        	}
        });
        
        //ʹ���ĵ���������
        item5.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		JFrame fr5=new JFrame();
        		fr5.setTitle("ʹ���ĵ�");
        		fr5.setSize(300,200);
        		fr5.setLocationRelativeTo(null);
        		fr5.setResizable(false); 
        		fr5.setVisible(true);
        		fr5.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        		fr5.addWindowListener(new MyWindowListener());
//        		ImageIcon ig = new ImageIcon("src\\images\\pic1_1.jpg");
        		Image im = ig.getImage();
        		fr5.setIconImage(im);
        		
        		ImageIcon img = new ImageIcon(dir+"\\src\\images\\pic4.jpg");//TODO PICPATH
        		JLabel imgLabel = new JLabel(img);
        		fr5.getLayeredPane().add(imgLabel,Integer.valueOf(Integer.MIN_VALUE));
        		imgLabel.setBounds(0, 0, img.getIconWidth(), img.getIconHeight());	
        		imgLabel.setOpaque(true);
        		
        		JPanel p5=new JPanel();
        		fr5.setContentPane(p5);//���
        		p5.setOpaque(false);
         		p5.setLayout(new BorderLayout());
         		
//        		JMenuBar menubar_5=new JMenuBar();
//        		fr5.setJMenuBar(menubar_5);//�˵���
//                JButton button51=new JButton("������ҳ");
//        		menubar_5.add(button51);
////        	    JToolBar bar5 = new JToolBar();
////         		bar5.add(button51);   
////         		fr5.add("North",bar5);
////         		bar5.add(button51);
//                button51.addActionListener(new ActionListener() {
//                	public void actionPerformed(ActionEvent e) {
//                		fr5.dispose();
//                	}
//                });
                
             	JTextArea textArea5=new JTextArea();
        		textArea5.setLineWrap(true);
        		textArea5.setSize(20,20);
                p5.add("Center",textArea5);
                textArea5.setOpaque(false);
                textArea5.setForeground(Color.RED);
                textArea5.setFont(new Font("����",Font.BOLD,16));
                textArea5.append("   ʹ���ĵ�Ŀǰ���������С��� ^_^");
                textArea5.setEditable(false);
                
        	}
        });
        
        //������Ŀ
        item6.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		JFrame fr6=new JFrame();
        		fr6.setTitle("������Ŀ");
        		fr6.setSize(600,400);
        		fr6.setLocationRelativeTo(null);
        		fr6.setResizable(false); 
        		fr6.setVisible(true);
        		fr6.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); 		
        		fr6.addWindowListener(new MyWindowListener());
//        		ImageIcon ig = new ImageIcon("src\\images\\pic1_1.jpg");//����ͼ��
        		Image im = ig.getImage();
        		fr6.setIconImage(im);
        		
        		JPanel p6=new JPanel();
        		fr6.setContentPane(p6);//���
        		p6.setOpaque(false);
         		p6.setLayout(new BorderLayout());
         		
             	JTextArea textArea6=new JTextArea();
        		textArea6.setLineWrap(true);
        		textArea6.setSize(200,200);
                p6.add("Center",textArea6);
                textArea6.setOpaque(false);
                textArea6.setForeground(Color.RED);
                textArea6.setFont(new Font("����",Font.BOLD,16));
                
             	JTextArea textArea62=new JTextArea();
        		textArea62.setLineWrap(true);
        		textArea62.setSize(200,200);
                p6.add("South",textArea62);
                textArea62.setOpaque(false);
                textArea62.setForeground(Color.BLACK);
                textArea62.setFont(new Font("����",Font.BOLD,12));
                
        		ImageIcon img = new ImageIcon(dir+"\\src\\images\\pic5.jpg");//Ҫ���õı���ͼƬ//TODO PICPATH
        		JLabel imgLabel = new JLabel(img);//������ͼ���ڱ�ǩ�
        		fr6.getLayeredPane().add(imgLabel,Integer.valueOf(Integer.MIN_VALUE));
        		imgLabel.setBounds(0, 0, img.getIconWidth(), img.getIconHeight());	
        		imgLabel.setOpaque(true);
                

                textArea6.append("    ������ΪӰ��ֵ����ܱ����������ĺ������г���С�����ں�������ǿ��Խ��Ƶ���Ϊÿλ�ͻ���ˮ������ġ�"
                		+ "����Ԥѡ������������������������Է�Ϊ���֣�һ������Χ������ס���Ĺ̶���������һ���Ǿ����ýֵ������ˡ�"
                		+ "������ǿ���ͨ������ýֵ������������������������ͨ�����������������ܳ��ܵ��������еı�����������"
                		+ "�����ټ�ȥ���еı�����������ɵó������ֵ��г����ܳ��ܵ��������еı�����������\r\n"
                		+ "    ���ǽ�����һ������������ڿͻ�ѡ���ֵ���ͨ����ȡ�ýֵ���Χ��¥������¥������Ԥ��������ס������"
                		+ "�������ݿ��еõ��ýֵ�����������,����ýֵ�����������������ݸýֵ����еı���������Ϊ�ͻ������ýֵ����г��Ƿ񱥺ͣ�"
                		+ "��δ�������Ϊ�˿��ṩ�ý�ʣ���г���֧�ֵı�����������\r\n"
                		+ "\r\n"
                		+ "\r\n"
                		+ "\r\n"
                		+ "\r\n");
                textArea6.setEditable(false);
                textArea62.append("������Ϣ��\r\n"
                		+ "����汾��ver1.1 Test\r\n"
                		+ "������Ա������");
                textArea62.setEditable(false);
                
        		JMenuBar menubar_6=new JMenuBar();
        		fr6.setJMenuBar(menubar_6);//�˵���
                JButton button61=new JButton("������ҳ");
                JButton button62=new JButton("��Ŀ��ҳ");
                menubar_6.add(button61);
                menubar_6.add(button62);
//        	    JToolBar bar6 = new JToolBar();
//         		bar6.add(button61);   
//         		bar6.add(button62);
//         		fr6.add("North",bar6);
//         		bar6.add(button61);
//         		bar6.add(button62);
         		
                button61.addActionListener(new ActionListener() {
                	public void actionPerformed(ActionEvent e) {
                		fr6.dispose();
                	}
                });
                button62.addActionListener(new ActionListener() {
                	public void actionPerformed(ActionEvent e) {
                		try {
                			//�����ҵ�github��ҳ
                			Runtime.getRuntime().exec("rundll32 url.dll,FileProtocolHandler https://github.com/Andytonglove");
                		} catch (IOException e1) {
                			e1.printStackTrace();
                		}
                	}
                });
         		
        	}
        });


        ActionListener listen = new ActionListener(){
        	public void actionPerformed(ActionEvent e){
        		textArea.setEditable(false);
        		if(e.getSource()==item1)  textArea.setText("������ѡ��������������\n");
        		if(e.getSource()==item2)  textArea.setText("�������ύ��������л����֧�֣�\n");
        		if(e.getSource()==item3)  textArea.setText("�����ڲ鿴������Ϣ��������ʾ������Ŀ��ҳ����\n");
        		if(e.getSource()==item4)  textArea.setText("������ǰ�����ӻ�չʾ��ҳ����\n");
        		if(e.getSource()==item5)  textArea.setText("�����ڲ鿴ʹ���ĵ�����\n");
        		if(e.getSource()==item6)  textArea.setText("�����ڷ��ʹ�����Ŀ����\n");
        		if(e.getSource()==item7)  textArea.setText("");
        		if(e.getSource()==item8)  textArea.setText("�������ϴ����ݣ�ÿһ�����ݶ����ᱻ�˷ѣ�\n");
        		if(e.getSource()==item9)  textArea.append("886��\n");

        	}
        };
        item1.addActionListener(listen);
        item2.addActionListener(listen);
        item3.addActionListener(listen);
        item4.addActionListener(listen);
        item5.addActionListener(listen);
        item6.addActionListener(listen);
        item7.addActionListener(listen);
        item8.addActionListener(listen);
        item9.addActionListener(listen);
        
        //��������������2֮�������------����Ϊ������λ��
        //������1�������ʷ��¼->��������
        item7.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		//textArea.append("�����������ʷ��¼����\n");
                jf.dispose();
        		new OutputWindow();
        	}
        });
        //������2�������ϴ�
        item8.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		JFrame frt2=new JFrame();
        		frt2.setTitle("�����ϴ�");
        		frt2.setSize(400,350);
        		frt2.setLocationRelativeTo(null);
        		frt2.setResizable(false); 
        		frt2.setVisible(true);
        		frt2.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        		frt2.addWindowListener(new MyWindowListener());
//        		ImageIcon ig = new ImageIcon("src\\images\\pic1_1.jpg");
        		Image im = ig.getImage();
        		frt2.setIconImage(im);
        		
        		ImageIcon img = new ImageIcon(dir+"\\src\\images\\pic4.jpg");//TODO PICPATH
        		JLabel imgLabel = new JLabel(img);
        		frt2.getLayeredPane().add(imgLabel,Integer.valueOf(Integer.MIN_VALUE));
        		imgLabel.setBounds(0, 0, img.getIconWidth(), img.getIconHeight());	
        		imgLabel.setOpaque(true);
        		
        		JPanel pt2=new JPanel();
        		frt2.setContentPane(pt2);//���
        		pt2.setOpaque(false);
         		pt2.setLayout(new BorderLayout());
         		
                JButton buttont21=new JButton("������ҳ");
//        	    JToolBar bart2 = new JToolBar();
//         		bart2.add(buttont21);   
//         		frt2.add("North",bart2);
//         		bart2.add(buttont21);
                buttont21.addActionListener(new ActionListener() {
                	public void actionPerformed(ActionEvent e) {
                		frt2.dispose();
                	}
                });
                
        		JMenuBar menubar_8=new JMenuBar();
        		frt2.setJMenuBar(menubar_8);//�˵���
                menubar_8.add(buttont21);
                
             	JTextField textFieldt2=new JTextField();
        		textFieldt2.setSize(20,20);
                pt2.add("Center",textFieldt2);
                textFieldt2.setOpaque(false);
                textFieldt2.setForeground(Color.RED);
                textFieldt2.setFont(new Font("����",Font.BOLD,16));
                textFieldt2.setText("�����������Ŀǰ���������С��� ^_^");
                textFieldt2.setHorizontalAlignment(JTextField.CENTER);
                textFieldt2.setEditable(false);
        	}
        });
        //������3��886
        item9.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
				System.exit(0);
        	}
        });


	}

	
/////////////////////////����һ���ָ���//////////////////////////////////////////////
	
	public static void main(String args[]) {
//		OutputWindow window=new OutputWindow();   //TODO RUN
		new OutputWindow();
		String fozu = 
			    "                   _ooOoo_"+"\n"+
			    "                  o8888888o"+"\n"+
			    "                  88\" . \"88"+"\n"+
			    "                  (| -_- |)"+"\n"+
			    "                  O\\  =  /O"+"\n"+
			    "               ____/`---'\\____"+"\n"+
			    "             .'  \\\\|     |//  `."+"\n"+
			    "            /  \\\\|||  :  |||//  \\"+"\n"+
			    "           /  _||||| -:- |||||-  \\"+"\n"+
			    "           |   | \\\\\\  -  /// |   |"+"\n"+
			    "           | \\_|  ''\\---/''  |   |"+"\n"+
			    "           \\  .-\\__  `-`  ___/-. /"+"\n"+
			    "         ___`. .'  /--.--\\  `. . __"+"\n"+
			    "      .\"\" '<  `.___\\_<|>_/___.'  >'\"\"."+"\n"+
			    "     | | :  `- \\`.;`\\ _ /`;.`/ - ` : | |"+"\n"+
			    "     \\  \\ `-.   \\_ __\\ /__ _/   .-` /  /"+"\n"+
			    "======`-.____`-.___\\_____/___.-`____.-'======"+"\n"+
			    "                   `=---='"+"\n"+
			    "^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^"+"\n"+
			    "                 ���汣��       ����BUG";
		System.out.println(fozu);
	}
	
}
