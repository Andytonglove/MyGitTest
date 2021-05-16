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
//		super("便利店调控地理分析系统 V1.0");
		JFrame jf=new JFrame("便利店调控地理分析系统 V1.1");
		jf.setSize(860,600);//640图片太长了
		jf.setLocationRelativeTo(null);
		jf.setResizable(false); 
		jf.setVisible(true);
		jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());//windowsUI
		}catch(Exception e){
			System.out.println("程序外观生成出现错误！");
			System.exit(0);
		}
		
		//jar包需要图片路径的问题，之后再二改吧：
		//方法是：类this.getClass().getResource("/image/pic1_1.jpg")，但是我依然无论有无首\不能调试成功，很麻烦
		/*
		 * java.net.URL imgURL = GUITest.class.getResource("/image/pic1_1.jpg");
		 * ImageIcon img1 = new ImageIcon(imgURL);
		 * */
		//原调试路径为："src\\images\\pic1_1.jpg"
		//最终决定还是以独立文件夹绝对路径形式读取！！！烦死我了，即"D:\\src\\images\\pic1_1.png"
		//失败：Image imgg = Toolkit.getDefaultToolkit().getImage(getClass().getResource("/images/pic1_1.jpg"));
		
		String dir=System.getProperty("user.dir");   //获取当前路径
			
		ImageIcon ig = new ImageIcon(dir+"\\src\\images\\pic1_1.jpg");//设置图标//TODO PICPATH
		Image im = ig.getImage();
		jf.setIconImage(im);
		
		ImageIcon img = new ImageIcon(dir+"\\src\\images\\pic3.jpg");//要设置的背景图片//TODO PICPATH
		JLabel imgLabel = new JLabel(img);//将背景图放在标签里。
		//jf.getLayeredPane().add(imgLabel, new Integer(Integer.MIN_VALUE));->The constructor Integer(int) is deprecated since version 9
		jf.getLayeredPane().add(imgLabel,Integer.valueOf(Integer.MIN_VALUE));
		imgLabel.setBounds(0, 0, img.getIconWidth(), img.getIconHeight());	
		imgLabel.setOpaque(true);
		
		JPanel p=new JPanel();
		jf.setContentPane(p);//面板
		p.setOpaque(false);
		
		JMenuBar menubar1=new JMenuBar();
		jf.setJMenuBar(menubar1);//菜单棒
		//菜单项
 		JMenu menu1=new JMenu("选项");
		JMenu menu2=new JMenu("帮助");
     	JMenu menu3=new JMenu("查看");
     	JMenu menu4=new JMenu("更多");
		menubar1.add(menu1);
		menubar1.add(menu2);
		menubar1.add(menu3);
		menubar1.add(menu4);
		
 		//建立子菜单项
 		ImageIcon imageIcon_menu=new ImageIcon(dir+"\\src\\images\\newnewpic1_1.png");//TODO PICPATH
		JMenuItem item1=new JMenuItem("选择地区",imageIcon_menu);
		JMenuItem item2=new JMenuItem("提交反馈",imageIcon_menu);
     	JMenuItem item3=new JMenuItem("更多信息",imageIcon_menu);
     	JMenuItem item4=new JMenuItem("可视化展示",imageIcon_menu);
     	JMenuItem item5=new JMenuItem("使用文档",imageIcon_menu);
     	JMenuItem item6=new JMenuItem("关于项目",imageIcon_menu);
     	JMenuItem item7=new JMenuItem("重新启动",imageIcon_menu);   //本为清除历史记录
     	JMenuItem item8=new JMenuItem("数据上传",imageIcon_menu);
     	JMenuItem item9=new JMenuItem("残忍再见",imageIcon_menu);
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
     	
 		/*把工具条改到菜单项里面了，界面更美观好看*/
// 		//建立工具条按键
// 		ImageIcon imageIcon_button=new ImageIcon("src\\images\\newnewpic1_1.png");
//	    JButton button1 = new JButton("清除历史记录",imageIcon_button);
// 		JButton button2 = new JButton("数据上传",imageIcon_button);
// 		JButton button3 = new JButton("残忍再见",imageIcon_button);
// 		//建立工具条对象，并将按键依次加入
//	    JToolBar bar = new JToolBar();
// 		bar.add(button1);   
// 		bar.add(button2);        
// 		bar.add(button3);
 		
		//在面板中摆放工具条、文本框和子菜单
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
        textArea.setEditable(false);//不可编辑
        textArea.setForeground(Color.BLUE);
        textArea.setFont(new Font("楷体",Font.PLAIN,16));//24字体太大了
        
    	//其他信息：重写关闭窗口windowClosing方法作为内部类……
        class MyWindowListener extends WindowAdapter{
        	public void windowClosing(WindowEvent e) {
        		super.windowClosing(e);
        		textArea.setText(null);
        	}
        }
        
//      DefaultCaret caret = (DefaultCaret)textArea.getCaret();
//      caret.setUpdatePolicy(DefaultCaret.ALWAYS_UPDATE);
//		JScrollPane scrollPane = new JScrollPane(textArea);//添加滚动条
//		scrollPane.setBounds(0, 500, 330, 200);
//		p.add(scrollPane);
        //文本框的自动滚动条老失败且丑，不做了
        
 		ImageIcon imageIcon_button=new ImageIcon(dir+"\\src\\images\\newphotoforbutton_1.png");//TODO PICPATH
        JButton jb1=new JButton("选择店铺地点(C)",imageIcon_button);
        p.add(jb1);
        jb1.setBounds(225,190,160,140);//860*600->setBounds(x:335,y:200,width:160,height:120);
//        jb1.setOpaque(false);//免遮挡
        jb1.setFont(new Font("楷体", Font.PLAIN, 20));
        jb1.setForeground(Color.black);
        jb1.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));   //添加鼠标样式
//        jb1.setBorderPainted(false);//去边框
        jb1.setContentAreaFilled(false);//透明
        /*http://tools.jb51.net/static/colorpicker/*/
        jb1.setBackground(new Color(240,255,255));//颜色，需要和透明遮挡一起内容，和透明在一起只有边框，new Color(240,255,255)浅色系
        jb1.setOpaque(true);//遮挡
        jb1.setBorder(BorderFactory.createRaisedBevelBorder());//凸起按钮
        jb1.setVerticalTextPosition(SwingConstants.BOTTOM);//文本相对位置设置
        jb1.setHorizontalTextPosition(SwingConstants.CENTER);
        jb1.setMnemonic(java.awt.event.KeyEvent.VK_C);//Alt+c触发快捷键
        
        jb1.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
                //选择店铺地点按钮
        		JFrame jfb1=new JFrame();
        		jfb1.setTitle("选择店铺地点");
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
        		jfb1.setContentPane(pt11);//面板
        		pt11.setOpaque(false);
         		pt11.setLayout(null);//布局管理器
         		
         		//11江汉北路
                JButton jb11=new JButton("");
                pt11.add(jb11);
                jb11.setBounds(50,20,355,520);//820*660window，左侧按钮
                jb11.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
                jb11.setBorderPainted(false);
                jb11.setContentAreaFilled(false);
                jb11.setOpaque(false);
                jb11.setBorder(BorderFactory.createRaisedBevelBorder());
//                jb11.setFont(new Font("楷体", Font.PLAIN, 30));
//                jb11.setForeground(Color.black);
                jb11.setMnemonic(java.awt.event.KeyEvent.VK_K);
                //去边框，除去焦点的框，不打印边框
                jb11.setBorder(null);
                jb11.setBorderPainted(false);
                jb11.setFocusPainted(false);
                //文本提示框
                JTextField jf11=new JTextField();
                jf11.setLocation(80, 540);
                jf11.setSize(300, 40);
                jf11.setText("选择查询江汉北路地区(K)");
                pt11.add(jf11);
                jf11.setOpaque(false);
                jf11.setEditable(false);
                jf11.setForeground(Color.black);
                jf11.setFont(new Font("楷体",Font.PLAIN,24));
                jf11.setBorder(null);
                jf11.setEnabled(false);
                //11监听
                jb11.addActionListener(new ActionListener() {
                	public void actionPerformed(ActionEvent e) {
//                		jfb1.remove(pt11);
//                	    jfb1.validate(); 
//                	    jfb1.repaint();   //prefer to write this always.
//                		JPanel pt11_new=new JPanel();
//                		jfb1.setContentPane(pt11_new);
                		jfb1.dispose();
                		try {
                			// TODO 可视化网页
                    		JOptionPane.showMessageDialog(null,"江汉北路的便利店查询分析结果已得到！\n"
                    				+ "江汉北路中段已有便利店数量：5家\n"
                    				+ "建模分析剩余可开店铺数建议为：0家\n"
                    				+ "该街道市场需求不大，请您谨慎选择哦！\n"
                    				+ "您可以在接下来的web中可视化看到这一结果！"
                    				,"店铺选址建议",JOptionPane.PLAIN_MESSAGE,imageIcon_menu);
                    		
                			Desktop.getDesktop().open(new File(dir+"\\src\\互联网+可视化.html"));
                			//Runtime.getRuntime().exec("rundll32 url.dll,FileProtocolHandler https://map.baidu.com/@12725215.099926004,3559238.3320428324,15.6z");
                		} catch (IOException e1) {
                			e1.printStackTrace();
                		}
                	}
                });
                
         		//12六高附近
                JButton jb12=new JButton("");
                pt11.add(jb12);
                jb12.setBounds(410,80,355,520);//820*660window，右侧按钮
                jb12.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
                jb12.setBorderPainted(false);
                jb12.setContentAreaFilled(false);
                jb12.setOpaque(false);
                jb12.setBorder(BorderFactory.createRaisedBevelBorder());
//                jb12.setFont(new Font("楷体", Font.PLAIN, 30));
//                jb12.setForeground(Color.black);
                jb12.setMnemonic(java.awt.event.KeyEvent.VK_L);
                //去边框，除去焦点的框，不打印边框
                jb12.setBorder(null);
                jb12.setBorderPainted(false);
                jb12.setFocusPainted(false);
                //文本提示框
                JTextField jf12=new JTextField();
                jf12.setLocation(430, 40);
                jf12.setSize(350, 40);
                jf12.setText("选择查询澳门路球场街地区(L)");
                pt11.add(jf12);
                jf12.setOpaque(false);
                jf12.setEditable(false);
                jf12.setForeground(Color.black);
                jf12.setFont(new Font("楷体",Font.PLAIN,24));
                jf12.setBorder(null);
                jf12.setEnabled(false);
                //12监听
                jb12.addActionListener(new ActionListener() {
                	public void actionPerformed(ActionEvent e) {
                		jfb1.dispose();
                		try {
                    		JOptionPane.showMessageDialog(null,"江汉北路的便利店查询分析结果已得到！\n"
                    				+ "澳门路附近地区已有便利店数量：4家\n"
                    				+ "球场街附近地区已有便利店数量：3家\n"
                    				+ "建模分析剩余可开店铺数建议为：0家\n"
                    				+ "该街道市场需求不大，请您谨慎选择哦！\n"
                    				+ "您可以在接下来的web中可视化看到这一结果！"
                    				,"店铺选址建议",JOptionPane.PLAIN_MESSAGE,imageIcon_menu);
                    		JOptionPane.showMessageDialog(null,"由智能搜索分析系统可得：\n"
                    				+ "您所查询点的附近香港路尚有可开设店铺余量：1家\n"
                    				+ "但该街道市场剩余市场不大，请您谨慎选择哦！"
                    				,"智能搜索店铺选址建议",JOptionPane.PLAIN_MESSAGE,imageIcon_menu);
                			// TODO 可视化网页
                			Desktop.getDesktop().open(new File(dir+"\\src\\互联网+可视化.html"));
                			//Runtime.getRuntime().exec("rundll32 url.dll,FileProtocolHandler https://map.baidu.com/@12725215.099926004,3559238.3320428324,15.6z");
                		} catch (IOException e1) {
                			e1.printStackTrace();
                		}

                	}
                });
                
        	}
        });

        
        JButton jb2=new JButton("输入街区人流(I)",imageIcon_button);
        p.add(jb2);
        jb2.setBounds(445,190,160,140);
        jb2.setOpaque(false);
        jb2.setFont(new Font("楷体", Font.PLAIN, 20));
        jb2.setForeground(Color.black);
        jb2.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        jb2.setBorder(BorderFactory.createRaisedBevelBorder());
        jb2.setContentAreaFilled(false);
        jb2.setBackground(new Color(207,226,243));//new Color(176,226,255)深色系，(207,226,243)
        jb2.setOpaque(true);
        jb2.setBorder(BorderFactory.createRaisedBevelBorder());
        jb2.setVerticalTextPosition(SwingConstants.BOTTOM);
        jb2.setHorizontalTextPosition(SwingConstants.CENTER);
        jb2.setMnemonic(java.awt.event.KeyEvent.VK_I);
        
        jb2.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		
        		Object oo=JOptionPane.showInputDialog(null,"请输入街道预期日人流量：\n","人流量输入",
        				JOptionPane.PLAIN_MESSAGE,imageIcon_menu,null,"在这输入");
        		Object oo2=JOptionPane.showInputDialog(null,"请输入街道已有便利店数：\n","便利店数目输入",
        				JOptionPane.PLAIN_MESSAGE,imageIcon_menu,null,"在这输入");
        		try {
            		String str1=oo.toString();
            		int strnum=Integer.parseInt(str1);
            		String str2=oo2.toString();
            		int strnum2=Integer.parseInt(str2);
            		
            		//建模数据处理
            		double ans=0;
            		if(strnum<=500) {
            			ans=1-strnum2;
            			if(ans<=0) ans=0;
            			int ans1=(int)(ans);
                		JOptionPane.showMessageDialog(null,"根据您输入人流量得到的预期可供店铺数：\n"
                				+ "该区域内预期剩余店铺数大约为"+ans1+"家\n"
                			    + "该区域日人流量较少/数据较少，分析可能存在误差，请谨慎选择！\n"
                				+ "具体分析过程可查看更多信息示例"
                				,"人流量分析",JOptionPane.PLAIN_MESSAGE,imageIcon_menu);
            		}else if(strnum<=1000 && strnum>500){
            			ans=3-strnum2;
            			if(ans<=0) ans=0;
            			int ans1=(int)(ans);
                		JOptionPane.showMessageDialog(null,"根据您输入人流量得到的预期可供店铺数：\n"
                				+ "该区域内预期剩余店铺数大约为"+ans1+"家\n"
                				+ "具体分析过程可查看更多信息示例"
                				,"人流量分析",JOptionPane.PLAIN_MESSAGE,imageIcon_menu);
            		}else if(strnum>1000) {
                		ans=(strnum-1000)*0.39468/300+3-strnum2;
            			int ans1=(int)(ans)+1;
            			if(ans<0.5) {
                    		JOptionPane.showMessageDialog(null,"根据您输入人流量得到的预期可供店铺数：\n"
                    				+ "该区域内预期剩余店铺数大约为"+ans1+"家\n"
                    			    + "但该区域发展潜力较低，请谨慎选择！\n"
                    				+ "具体分析过程可查看更多信息示例"
                    				,"人流量分析",JOptionPane.PLAIN_MESSAGE,imageIcon_menu);
            			}else {
                    		JOptionPane.showMessageDialog(null,"根据您输入人流量得到的预期可供店铺数：\n"
                    				+ "该区域内预期剩余店铺数大约为"+ans1+"家\n"
                    				+ "具体分析过程可查看更多信息示例"
                    				,"人流量分析",JOptionPane.PLAIN_MESSAGE,imageIcon_menu);
            			}

            		}
            		
            		
        		}catch(Exception ee){
        			
            		JOptionPane.showMessageDialog(null,"您还未输入数据或输入不合法\n"
            				+ "将跳转至数据库分析界面向您提供分析示例"
            				,"人流量分析",JOptionPane.PLAIN_MESSAGE,imageIcon_menu);
            		
            		JFrame fr22=new JFrame();
            		fr22.setTitle("人流量建模分析数据示例");
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
            		fr22.setContentPane(p22);//面板
            		p22.setOpaque(false);
             		p22.setLayout(null);
             		
                 	JTextArea textArea22=new JTextArea();
            		textArea22.setLineWrap(true);
            		textArea22.setBounds(10, 480, 520, 20);
            		textArea22.setSize(520,20);
                    p22.add(textArea22);
                    textArea22.setOpaque(false);
                    textArea22.setForeground(Color.RED);
                    textArea22.setFont(new Font("宋体",Font.BOLD,16));
                    textArea22.setText("建模部分数据一览，上方部分可点击查看部分示例区域建模文档");
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
                    		String filepath=dir+"\\src\\人流量tj.xlsx";
                            try {
                                File file = new File(filepath);
                                Desktop.getDesktop().open(file); // 启动已在本机桌面上注册的关联应用程序，打开文件对象file。
                            } catch (IOException | NullPointerException eee) { // 异常处理
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
//        ta_s.setFont(new Font("楷体",Font.BOLD,15));
//        ta_s.setLocation(430, 300);
//        ta_s.append("HELLO WORLD!");

        
//////////////////////////我是一条分割线//////////////////////////////////////////////
        
		//菜单中的菜单项和工具条中的工具项就是按键，按照点击按键的方法设置监听
   		//添加按钮的点击动作监听器，并把相关信息输入到文本区域
        
        //选择地区
        item1.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		JFrame fr1=new JFrame();
        		fr1.setTitle("选择地区");
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
        		fr1.setContentPane(p1);//面板
        		p1.setOpaque(false);
         		p1.setLayout(new BorderLayout());
        		
                JButton button11=new JButton("没找到，返回首页");
                JButton button12=new JButton("武汉地区");
                
        		JMenuBar menubar_1=new JMenuBar();
        		fr1.setJMenuBar(menubar_1);//菜单棒
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
                textArea1.setFont(new Font("宋体",Font.BOLD,16));
                textArea1.append("目前只支持武汉部分地区，正在完善中…… ^_^");
                textArea1.setEditable(false);
                
        	}
        });
        //提交反馈
        item2.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		JFrame fr2=new JFrame();
        		fr2.setTitle("提交反馈");
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
        		fr2.setContentPane(p2);//面板
        		p2.setOpaque(false);
         		p2.setLayout(new BorderLayout());
         		
         		JTextArea t2=new JTextArea();
                t2.setForeground(Color.RED);
                t2.setFont(new Font("宋体",Font.BOLD,15));
                t2.setSize(img.getIconWidth(), 450-img.getIconHeight());
         		t2.append("   加入我们提交反馈或者为项目贡献请扫描上方二维码！");
                t2.setEditable(false);
         		p2.add("South",t2);
        	}
        });
        
        //更多信息
        item3.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		
                Object[] options ={ "好啊！", "直接查看分析示例……" };  
                int m = JOptionPane.showOptionDialog(null, "想先看看项目首页吗？", "查看",
                		JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE,imageIcon_menu, options, options[0]);  
                if(m!=0) {
                	//直接查看实例分析
            		JFrame fr22=new JFrame();
            		fr22.setTitle("人流量建模分析数据");
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
            		fr22.setContentPane(p22);//面板
            		p22.setOpaque(false);
             		p22.setLayout(null);
             		
                 	JTextArea textArea22=new JTextArea();
            		textArea22.setLineWrap(true);
            		textArea22.setBounds(10, 480, 520, 20);
            		textArea22.setSize(520,20);
                    p22.add(textArea22);
                    textArea22.setOpaque(false);
                    textArea22.setForeground(Color.RED);
                    textArea22.setFont(new Font("宋体",Font.BOLD,16));
                    textArea22.setText("建模部分数据一览，上方部分可点击查看部分示例区域建模文档");
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
                    		String filepath=dir+"\\src\\人流量tj.xlsx";
                            try {
                                File file = new File(filepath);
                                Desktop.getDesktop().open(file); // 启动已在本机桌面上注册的关联应用程序，打开文件对象file。
                            } catch (IOException | NullPointerException eee) { // 异常处理
                                System.err.println(eee);
                            }

                    	}
                    });
                }else {
                	//先查看项目首页
            		try {
            			//我的github项目首页
            			Runtime.getRuntime().exec("rundll32 url.dll,FileProtocolHandler https://github.com/Andytonglove");
            		} catch (IOException e1) {
            			e1.printStackTrace();
            		}
                }

        	}
        });
        //键盘操作，存在问题且已经不需要
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
        
        //可视化展示：网页
        item4.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		try {
        			// TODO 可视化网页
        			Desktop.getDesktop().open(new File(dir+"\\src\\互联网+可视化.html"));
        			//Runtime.getRuntime().exec("rundll32 url.dll,FileProtocolHandler https://map.baidu.com/@12725215.099926004,3559238.3320428324,15.6z");
        		} catch (IOException e1) {
        			e1.printStackTrace();
        		}
        	}
        });
        
        //使用文档：完善中
        item5.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		JFrame fr5=new JFrame();
        		fr5.setTitle("使用文档");
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
        		fr5.setContentPane(p5);//面板
        		p5.setOpaque(false);
         		p5.setLayout(new BorderLayout());
         		
//        		JMenuBar menubar_5=new JMenuBar();
//        		fr5.setJMenuBar(menubar_5);//菜单棒
//                JButton button51=new JButton("返回首页");
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
                textArea5.setFont(new Font("宋体",Font.BOLD,16));
                textArea5.append("   使用文档目前正在完善中…… ^_^");
                textArea5.setEditable(false);
                
        	}
        });
        
        //关于项目
        item6.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		JFrame fr6=new JFrame();
        		fr6.setTitle("关于项目");
        		fr6.setSize(600,400);
        		fr6.setLocationRelativeTo(null);
        		fr6.setResizable(false); 
        		fr6.setVisible(true);
        		fr6.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); 		
        		fr6.addWindowListener(new MyWindowListener());
//        		ImageIcon ig = new ImageIcon("src\\images\\pic1_1.jpg");//设置图标
        		Image im = ig.getImage();
        		fr6.setIconImage(im);
        		
        		JPanel p6=new JPanel();
        		fr6.setContentPane(p6);//面板
        		p6.setOpaque(false);
         		p6.setLayout(new BorderLayout());
         		
             	JTextArea textArea6=new JTextArea();
        		textArea6.setLineWrap(true);
        		textArea6.setSize(200,200);
                p6.add("Center",textArea6);
                textArea6.setOpaque(false);
                textArea6.setForeground(Color.RED);
                textArea6.setFont(new Font("宋体",Font.BOLD,16));
                
             	JTextArea textArea62=new JTextArea();
        		textArea62.setLineWrap(true);
        		textArea62.setSize(200,200);
                p6.add("South",textArea62);
                textArea62.setOpaque(false);
                textArea62.setForeground(Color.BLACK);
                textArea62.setFont(new Font("楷体",Font.BOLD,12));
                
        		ImageIcon img = new ImageIcon(dir+"\\src\\images\\pic5.jpg");//要设置的背景图片//TODO PICPATH
        		JLabel imgLabel = new JLabel(img);//将背景图放在标签里。
        		fr6.getLayeredPane().add(imgLabel,Integer.valueOf(Integer.MIN_VALUE));
        		imgLabel.setBounds(0, 0, img.getIconWidth(), img.getIconHeight());	
        		imgLabel.setOpaque(true);
                

                textArea6.append("    我们认为影响街道承受便利店数量的核心是市场大小，而在宏观上我们可以近似地认为每位客户流水是相近的。"
                		+ "经过预选便利店所在切面的人流量可以分为两种，一种是周围社区的住户的固定客流，另一种是经过该街道的行人。"
                		+ "因此我们可以通过估算该街道的人流量来估算客流量，再通过客流量来估算其能承受的正常运行的便利店数量，"
                		+ "而后再减去已有的便利店数量便可得出这条街的市场还能承受的正常运行的便利店数量。\r\n"
                		+ "    我们将开发一个软件，其能在客户选定街道后通过爬取该街道周围的楼盘数，楼层数来预估社区的住户数，"
                		+ "并从数据库中得到该街道的行人流量,计算该街道的总人流量而后根据该街道已有的便利店数量为客户分析该街道的市场是否饱和，"
                		+ "若未饱和其可为顾客提供该街剩余市场能支持的便利店数量。\r\n"
                		+ "\r\n"
                		+ "\r\n"
                		+ "\r\n"
                		+ "\r\n");
                textArea6.setEditable(false);
                textArea62.append("开发信息：\r\n"
                		+ "软件版本：ver1.1 Test\r\n"
                		+ "开发人员：……");
                textArea62.setEditable(false);
                
        		JMenuBar menubar_6=new JMenuBar();
        		fr6.setJMenuBar(menubar_6);//菜单棒
                JButton button61=new JButton("返回首页");
                JButton button62=new JButton("项目首页");
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
                			//导到我的github首页
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
        		if(e.getSource()==item1)  textArea.setText("您正在选择搜索地区……\n");
        		if(e.getSource()==item2)  textArea.setText("您正在提交反馈，感谢您的支持！\n");
        		if(e.getSource()==item3)  textArea.setText("您正在查看更多信息，将访问示例和项目首页……\n");
        		if(e.getSource()==item4)  textArea.setText("您正在前往可视化展示网页……\n");
        		if(e.getSource()==item5)  textArea.setText("您正在查看使用文档……\n");
        		if(e.getSource()==item6)  textArea.setText("您正在访问关于项目……\n");
        		if(e.getSource()==item7)  textArea.setText("");
        		if(e.getSource()==item8)  textArea.setText("您正在上传数据，每一份数据都不会被浪费！\n");
        		if(e.getSource()==item9)  textArea.append("886！\n");

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
        
        //工具栏：核心是2之后会扩充------》改为更多栏位了
        //主工具1：清除历史记录->重新启动
        item7.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		//textArea.append("您正在清除历史记录……\n");
                jf.dispose();
        		new OutputWindow();
        	}
        });
        //主工具2：数据上传
        item8.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		JFrame frt2=new JFrame();
        		frt2.setTitle("数据上传");
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
        		frt2.setContentPane(pt2);//面板
        		pt2.setOpaque(false);
         		pt2.setLayout(new BorderLayout());
         		
                JButton buttont21=new JButton("返回首页");
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
        		frt2.setJMenuBar(menubar_8);//菜单棒
                menubar_8.add(buttont21);
                
             	JTextField textFieldt2=new JTextField();
        		textFieldt2.setSize(20,20);
                pt2.add("Center",textFieldt2);
                textFieldt2.setOpaque(false);
                textFieldt2.setForeground(Color.RED);
                textFieldt2.setFont(new Font("宋体",Font.BOLD,16));
                textFieldt2.setText("功能与服务器目前正在完善中…… ^_^");
                textFieldt2.setHorizontalAlignment(JTextField.CENTER);
                textFieldt2.setEditable(false);
        	}
        });
        //主工具3：886
        item9.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
				System.exit(0);
        	}
        });


	}

	
/////////////////////////这是一条分割线//////////////////////////////////////////////
	
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
			    "                 佛祖保佑       永无BUG";
		System.out.println(fozu);
	}
	
}
