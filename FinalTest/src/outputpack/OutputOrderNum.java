package outputpack;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.util.*;
import javax.swing.*;

public class OutputOrderNum {
	public OutputOrderNum() {
		JFrame jf=new JFrame("数据处理应用");
		jf.setSize(860,600);
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
		
		String dir=System.getProperty("user.dir");//获取相对路径
		//设置图标
		ImageIcon ig = new ImageIcon(dir+"\\src\\images\\inter.png");
		Image im = ig.getImage();
		jf.setIconImage(im);
		
		//设置背景
		ImageIcon img = new ImageIcon(dir+"\\src\\images\\back.jpg");
		JLabel imgLabel = new JLabel(img);//将背景图放在标签里
		jf.getLayeredPane().add(imgLabel,Integer.valueOf(Integer.MIN_VALUE));
		imgLabel.setBounds(0, 0, img.getIconWidth(), img.getIconHeight());	
		imgLabel.setOpaque(true);
		
		JPanel p=new JPanel();
		jf.setContentPane(p);//面板
		p.setLayout(null);//自由布局
		p.setOpaque(false);
		
		//菜单棒
		JMenuBar menubar1=new JMenuBar();
		jf.setJMenuBar(menubar1);

		//菜单项
 		ImageIcon imageIcon_menu=new ImageIcon(dir+"\\src\\images\\intersmall.png");//菜单图标
 		JMenu menu1=new JMenu("数据生成");
		JMenu menu2=new JMenu("数据排序");
     	JMenu menu3=new JMenu("数据查询");
     	JMenu menu4=new JMenu("其他");
		menubar1.add(menu1);
		menubar1.add(menu2);
		menubar1.add(menu3);
		menubar1.add(menu4);
		
 		//建立子菜单项
		JMenuItem item1=new JMenuItem("数据生成与选择",imageIcon_menu);
		JMenuItem item2=new JMenuItem("查看生成文件",imageIcon_menu);   //menu1
     	JMenuItem item3=new JMenuItem("冒泡排序法",imageIcon_menu);
     	JMenuItem item4=new JMenuItem("快速排序法",imageIcon_menu);
     	JMenuItem item5=new JMenuItem("折半插入/黄金分割排序法",imageIcon_menu);
     	JMenuItem item6=new JMenuItem("归并排序法",imageIcon_menu);
		JMenuItem item7=new JMenuItem("查看排序文件与结论",imageIcon_menu);   //menu2
     	JMenuItem item8=new JMenuItem("顺序查找数据",imageIcon_menu);
     	JMenuItem item9=new JMenuItem("折半查找数据",imageIcon_menu);
     	JMenuItem item10=new JMenuItem("哈希索引查找数据",imageIcon_menu);
     	JMenuItem item11=new JMenuItem("重新生成数据",imageIcon_menu);   //menu3
     	JMenuItem item12=new JMenuItem("残忍再见",imageIcon_menu);
     	JMenuItem item13=new JMenuItem("项目主页",imageIcon_menu);
     	JMenuItem item14=new JMenuItem("关于项目",imageIcon_menu);   //menu4
     	menu1.add(item1);
     	menu1.addSeparator();
     	menu1.add(item2);
     	menu2.add(item3);
     	menu2.addSeparator();
     	menu2.add(item4);
     	menu2.addSeparator();
     	menu2.add(item5);
     	menu2.addSeparator();
     	menu2.add(item6);
     	menu2.addSeparator();
     	menu2.add(item7);
 		menu3.add(item8);
     	menu3.addSeparator();
 		menu3.add(item9);
     	menu3.addSeparator();
 		menu3.add(item10);
     	menu3.addSeparator();
 		menu3.add(item11);
 		menu4.add(item12);
     	menu4.addSeparator();
 		menu4.add(item13);
     	menu4.addSeparator();
 		menu4.add(item14);
 		
 		//一个行动提示文本框
     	JTextArea textArea=new JTextArea();
        p.add(textArea);
        textArea.setSize(330,450);
        textArea.setBounds(0, 510, 360, 450);
        textArea.setOpaque(false);
        textArea.setEditable(false);
        textArea.setForeground(Color.BLUE);
        textArea.setFont(new Font("楷体",Font.PLAIN,16));
        
        //左侧按键
 		ImageIcon imageIcon_button=new ImageIcon(dir+"\\src\\images\\photoforbutton_1.png");
        JButton jb1=new JButton("数据生成和排序",imageIcon_button);
        p.add(jb1);
        jb1.setBounds(225,190,160,140);//860*600->setBounds(x:335,y:200,width:160,height:120);
        jb1.setFont(new Font("楷体", Font.PLAIN, 20));
        jb1.setForeground(Color.black);
        jb1.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));   //添加鼠标样式
        jb1.setContentAreaFilled(false);//透明
        jb1.setBackground(new Color(207,226,243));//颜色，需要和透明遮挡一起内容，和透明在一起只有边框
        jb1.setOpaque(true);//遮挡
        jb1.setBorder(BorderFactory.createRaisedBevelBorder());//凸起按钮
        jb1.setVerticalTextPosition(SwingConstants.BOTTOM);//文本相对位置设置
        jb1.setHorizontalTextPosition(SwingConstants.CENTER);
        
        jb1.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		JOptionPane.showMessageDialog(null,"如要进行数据生成请点击菜单栏第一栏“数据生成”\n"
        				+ "如要进行数据排序请点击菜单栏第二栏“数据排序”\n"
        				+ "由于处理操作数据量较大，部分排序操作可能需要较长等待时间，见谅！\n\n"
        				+ "这里给出处理10,0000数据量，本程序排序速度的结论：\n"
        				+ "快速排序>>归并排序>>>>>插入排序>>选择排序>>冒泡排序"
        				,"操作提示",JOptionPane.PLAIN_MESSAGE,imageIcon_menu);                
        	}
        });
        
        //右侧按键
        JButton jb2=new JButton("数据查询",imageIcon_button);
        p.add(jb2);
        jb2.setBounds(445,190,160,140);
        jb2.setOpaque(false);
        jb2.setFont(new Font("楷体", Font.PLAIN, 20));
        jb2.setForeground(Color.black);
        jb2.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        jb2.setBorder(BorderFactory.createRaisedBevelBorder());
        jb2.setContentAreaFilled(false);
        jb2.setBackground(new Color(207,226,243));
        jb2.setOpaque(true);
        jb2.setBorder(BorderFactory.createRaisedBevelBorder());
        jb2.setVerticalTextPosition(SwingConstants.BOTTOM);
        jb2.setHorizontalTextPosition(SwingConstants.CENTER);
        
        jb2.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		JOptionPane.showMessageDialog(null,"如要进行数据查询请点击菜单栏第三栏“数据查询”\n"
        				+ "如要进行主页访问或退出软件请点击菜单栏第四栏“退出”\n"
        				+ "由于处理操作数据量较大，部分操作可能需要较长等待时间，见谅！\n\n"
        				+ "特别的，其中，数据查询将给出您输入的数字在排序后文件中的位置和出现次数，\n"
        				+ "所以请先对数据进行生成、选择和排序后再进行查找！"
        				,"操作提示",JOptionPane.PLAIN_MESSAGE,imageIcon_menu);
        	}
        });
        
        String []FiletextPath={"\\text.txt"};   //作为文件读取使用的路径
        
        //创建一个进度条并设置参数
        final JProgressBar progressBar = new JProgressBar();
        p.add(progressBar);
        progressBar.setBounds(330, 500, 180, 15);
        progressBar.setIndeterminate(true);   //模糊模式
        progressBar.setVisible(false);   //利用转换是否可见来显示，效果一般，依然会卡             		
        /*
        //重新生成数据或者排序写入文件运行时间较长，本考虑加上一个JProgressBar进度条利用多线程来显示
        progressBar.setMinimum(0);
        progressBar.setMaximum(100);
        int[] currentProgress = {0};
		progressBar.setValue(currentProgress[0]);   //设置当前进度值
        progressBar.setStringPainted(true);   //绘制百分比文本（进度条中间显示的百分数）
        new Timer(500, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                currentProgress[0]++;
                if (currentProgress[0] > 100) {
                    currentProgress[0] = 0;
                }
                progressBar.setValue(currentProgress[0]);
            }
        }).start();
        */
        
/////////////////////我是一条分割线，下方是部分监听/////////////////////////////////
        
        //方法一生成数据，分隔符为空格->数据生成和选择
        item1.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
                Object[] options ={ "就使用提供的已有数据文件~", "还是重新生成随机数据文件吧~" };
                progressBar.setVisible(true);   //开始显示进度条
                int m = JOptionPane.showOptionDialog(null, "是否选择已有数据文件作为处理对象？\n"
                		+ "如果您不做任何操作就关闭窗口，\n则视为您希望使用已经预先重新生成过的随机数据文件^^\n"
                		+ "这样能够节约一些重新生成文件的等待时间（大约7秒）！", "选择使用数据",
                		JOptionPane.YES_NO_OPTION, 
                		JOptionPane.QUESTION_MESSAGE,imageIcon_menu, options, options[0]);
                if(m==0) {
                	FiletextPath[0]="\\data 2021.txt";
                }else if(m==1) {
                	long startTime =  System.currentTimeMillis();
            		for(int i=0;i<100000;i++) {
            			int a=new Random().nextInt(100000-0)+0;
            			try {
            				File f=new File("text.txt");
            				if(f.exists()) {
            					//System.out.println("文件存在");
            				}else {
            					//System.out.println("文件不存在");
            					f.createNewFile();
            				}
            				BufferedWriter output = new BufferedWriter(new FileWriter(f,true));
            				output.write(a+" ");
            				output.close();
            			} catch (IOException e1) {
            				e1.printStackTrace();
            			}
            		}
            		long endTime =  System.currentTimeMillis();
            		long usedTime = (endTime-startTime)/1000;
            		
            		JOptionPane.showMessageDialog(null,"数据已经生成！\n"
            				+ "10万条数值数据已经保存在“text.txt”文件中\n"
            				+ "生成数据并保存到文件用时"+usedTime+"秒\n"
            				+ "数据较多，等待时间可能较长，见谅！"
            				,"保存成功",JOptionPane.PLAIN_MESSAGE,imageIcon_menu);
                }else {
                	FiletextPath[0]="\\text.txt";
                }
                progressBar.setVisible(false);   //结束显示进度条
        	}
        });
        
        //查看生成文件
        item2.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		String dir=System.getProperty("user.dir");   //获取当前路径
        		String filepath=dir+FiletextPath[0];
                try {
                    File file = new File(filepath);
                    Desktop.getDesktop().open(file);   // 启动已在本机桌面上注册的关联应用程序，打开文件对象file。
                } catch (Exception e2) { 
                	// 异常处理
            		JOptionPane.showMessageDialog(null,"文件未生成或未找到，请重新生成！"
            				,"错误",JOptionPane.PLAIN_MESSAGE,imageIcon_menu);
                    System.err.println(e2);
                }

        	}
        });
        
        
        //冒泡排序法
        item3.addActionListener(new ActionListener() { 	
        	public void actionPerformed(ActionEvent e) {
        		int data[] = new int[100001];
        		//读取数据到数组
        		String dir=System.getProperty("user.dir");   //获取当前路径
        		String filepath=dir+FiletextPath[0];
        		MyreadFileNum(filepath,data,100000);
        		
            	long startTime =  System.currentTimeMillis();
            	//冒泡排序法
            	for(int k=0;k<100000;k++) {
            		for(int m=k+1;m<100000;m++) {
            			if(data[k]>data[m]) {
            				int temp=data[k];
            				data[k]=data[m];
            				data[m]=temp;
            			}
            		}
            	}
        		long endTime =  System.currentTimeMillis();
        		long usedTime = (endTime-startTime);
        		
        		//开始写入文件
            	long startTime2 =  System.currentTimeMillis();
        		MyWriteFileNum("OrderNum.txt",data,100000);
        		long endTime2 =  System.currentTimeMillis();
        		long usedTime2 = (endTime2-startTime2)/1000;

        		JOptionPane.showMessageDialog(null,"排序已经完成！\n"
        				+ "排序后的数据已经重新保存在“OrderNum.txt”文件中\n"
        				+ "冒泡排序法用时"+usedTime+"毫秒\n"
        				+ "排序后数据写入文件用时"+usedTime2+"秒\n"
        				+ "处理10,0000数据量，冒泡排序平均用时9s\n"
        				+ "本排序复杂度较高，排序时间非常长！"
        				,"结果",JOptionPane.PLAIN_MESSAGE,imageIcon_menu);
        	}
        });
        
        //快速排序法
        item4.addActionListener(new ActionListener() { 	
        	public void actionPerformed(ActionEvent e) {
        		int data[] = new int[100001];
        		//读取数据到数组
        		String dir=System.getProperty("user.dir");   //获取当前路径
        		String filepath=dir+FiletextPath[0];
        		MyreadFileNum(filepath,data,100000);
        		
            	long startTime =  System.currentTimeMillis();
            	//快速排序法
            	quickSort(data, 0, 100000);
        		long endTime =  System.currentTimeMillis();
        		long usedTime = (endTime-startTime);
        		
        		//开始写入文件
            	long startTime2 =  System.currentTimeMillis();
        		MyWriteFileNum("OrderNum.txt",data,100000);
        		long endTime2 =  System.currentTimeMillis();
        		long usedTime2 = (endTime2-startTime2)/1000;

        		JOptionPane.showMessageDialog(null,"排序已经完成！\n"
        				+ "排序后的数据已经重新保存在“OrderNum.txt”文件中\n"
        				+ "快速排序法用时"+usedTime+"毫秒\n"
        				+ "排序后数据写入文件用时"+usedTime2+"秒\n"
        				+ "处理10,0000数据量，冒泡排序平均用时0-1s\n"
        				+ "本排序排序速度非常快！"
        				,"结果",JOptionPane.PLAIN_MESSAGE,imageIcon_menu);
        	}
        });
        
        //折半插入/黄金分割排序法
        item5.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
                Object[] options ={ "选择折半插入排序", "选择黄金分割排序" };  
                int m = JOptionPane.showOptionDialog(null, "折半排序 or 黄金分隔排序？", "选择",
                		JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE,
                		imageIcon_menu, options, options[0]);  
        		
        		int data[] = new int[100001];
        		//读取数据到数组
        		String dir=System.getProperty("user.dir");   //获取当前路径
        		String filepath=dir+FiletextPath[0];
        		MyreadFileNum(filepath,data,100000);
        		
        		int flag=1;
            	//折半插入/黄金分割排序法
            	long startTime =  System.currentTimeMillis();
            	if(m==0) {
            		halfsort(data);
            	}else if(m==1) {
            		GoldenSectionSort(data);
            	}else {
            		//啥都不干，等待关闭窗口，不执行下列语句
            		flag=0;
            	}
        		long endTime =  System.currentTimeMillis();
        		long usedTime = (endTime-startTime);
        		
        		if(flag==1) {
            		//开始写入文件
                	long startTime52 =  System.currentTimeMillis();
            		MyWriteFileNum("OrderNum.txt",data,100000);
            		long endTime52 =  System.currentTimeMillis();
            		long usedTime52 = (endTime52-startTime52)/1000;

                	if(m==0) {
                		JOptionPane.showMessageDialog(null,"排序已经完成！\n"
                				+ "排序后的数据已经重新保存在“OrderNum.txt”文件中\n"
                				+ "折半插入排序法用时"+usedTime+"毫秒\n"
                				+ "排序后数据写入文件用时"+usedTime52+"秒\n"
                				+ "处理10,0000数据量，折半插入排序平均用时1s+\n"
                				+ "本排序排序较快！"
                				,"结果",JOptionPane.PLAIN_MESSAGE,imageIcon_menu);
                	}else if(m==1) 
                	{
                		JOptionPane.showMessageDialog(null,"排序已经完成！\n"
                				+ "排序后的数据已经重新保存在“OrderNum.txt”文件中\n"
                				+ "黄金分割排序法用时"+usedTime+"毫秒\n"
                				+ "排序后数据写入文件用时"+usedTime52+"秒\n"
                				+ "处理10,0000数据量，黄金分割排序平均用时1s+\n"
                				+ "本排序排序较快！"
                				,"结果",JOptionPane.PLAIN_MESSAGE,imageIcon_menu);
                	}
        		}

        	}
        });
        
        //归并排序法
        item6.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		int data[] = new int[100001];
        		//读取数据到数组
        		String dir=System.getProperty("user.dir");   //获取当前路径
        		String filepath=dir+FiletextPath[0];
        		MyreadFileNum(filepath,data,100000);
        		
            	long startTime =  System.currentTimeMillis();
            	//归并排序法
            	mergeSort(data,0,100000);
        		long endTime =  System.currentTimeMillis();
        		long usedTime = (endTime-startTime);
        		
        		//开始写入文件
            	long startTime2 =  System.currentTimeMillis();
        		MyWriteFileNum("OrderNum.txt",data,100000);
        		long endTime2 =  System.currentTimeMillis();
        		long usedTime2 = (endTime2-startTime2)/1000;

        		JOptionPane.showMessageDialog(null,"排序已经完成！\n"
        				+ "排序后的数据已经重新保存在“OrderNum.txt”文件中\n"
        				+ "归并排序法用时"+usedTime+"毫秒\n"
        				+ "排序后数据写入文件用时"+usedTime2+"秒\n"
        				+ "处理10,0000数据量，归并排序平均用时0-1s\n"
        				+ "本排序排序速度非常快！"
        				,"结果",JOptionPane.PLAIN_MESSAGE,imageIcon_menu);
        	}
        });
        
        //排序后的文档
        item7.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		JOptionPane.showMessageDialog(null,"结论：\n"
        				+ "处理10,0000数据量，排序速度：\n"
        				+ "快速排序>>归并排序>>>>>插入排序>>选择排序>>冒泡排序"
        				,"结论",JOptionPane.PLAIN_MESSAGE,imageIcon_menu);
        		
        		String dir=System.getProperty("user.dir");   //获取当前路径
        		String filepath=dir+"\\OrderNum.txt";
                try {
                    File file = new File(filepath);
                    Desktop.getDesktop().open(file);   // 启动已在本机桌面上注册的关联应用程序，打开文件对象file。
                } catch (Exception e11) { 
                	// 异常处理
            		JOptionPane.showMessageDialog(null,"文件未生成或未找到，请重新生成！"
            				,"错误",JOptionPane.PLAIN_MESSAGE,imageIcon_menu);
                    System.err.println(e11);
                }
        	}
        });
        
        //输入顺序查询数据
        item8.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		String dir=System.getProperty("user.dir");   //获取当前路径
        		String filepath=dir+"\\OrderNum.txt";
        		int data[] = new int[100001];
        		MyreadFileNum(filepath,data,100000);
        		
        		try {
            		Object os=JOptionPane.showInputDialog(null,"请输入您想在文件中顺序查找的数字：\n","顺序查找数字输入",
            				JOptionPane.PLAIN_MESSAGE,imageIcon_menu,null,"在这输入数字");
            		String str=os.toString();   //类型转换成字符串和数字
            		int numForSearch=Integer.parseInt(str);
            		//查找
                	long startTime =  System.currentTimeMillis();
            		int i=0;
            		int j=0;
            		//设定最小差值的统计，在没有找到时可以输出最接近的数
            		int minDifference = Math.abs(data[0] - numForSearch);
            		int minIndex = 0;
            		for(i=0;i<100000;i++) {
            			if(Math.abs(data[i] - numForSearch)<minDifference) {
            				minIndex=i;
            				minDifference=Math.abs(data[i] - numForSearch);
            			}
            			if(data[i]==numForSearch) {
                    		long endTime =  System.currentTimeMillis();
                    		long usedTime = (endTime-startTime);
                    		j++;
                    		
                    		JOptionPane.showMessageDialog(null,"您所查询的数字存在！\n"
                    				+ "数字"+numForSearch+"第"+j+"次出现的位置是排序后文件中的第"+(i+1)+"个\n"
                    				+ "顺序查找花费查询时间为"+usedTime+"毫秒。"
                    				,"顺序查找",JOptionPane.PLAIN_MESSAGE,imageIcon_menu);
                    		continue;
            			}
            		}
            		if(i==100000 && j!=0) {
                		JOptionPane.showMessageDialog(null,"您所查询的数字"+numForSearch
                				+"在文件中总共出现了"+j+"次"
                				,"查找总数",JOptionPane.PLAIN_MESSAGE,imageIcon_menu);
            		}
            		if(i==100000 && j==0) {
                		long endTime =  System.currentTimeMillis();
                		long usedTime = (endTime-startTime);
                		JOptionPane.showMessageDialog(null,"很遗憾，已经很努力的再找了┭┮﹏┭┮\n"
                				+ "但是您所查询的数字"+numForSearch+"在本次随机生成的数据文件中不存在！\n"
                				+ "顺序查找花费查询时间为"+usedTime+"毫秒。\n"
                				+ "\n但我们找到了与您想查询的数字最接近的数字和它的位置！^^\n"
                				+ "这个数字是："+data[minIndex]+"，它出现的位置是排序后文件中的第"+(minIndex+1)+"个。"
                				,"顺序查找",JOptionPane.PLAIN_MESSAGE,imageIcon_menu);
            		}
            		
        		}catch (NumberFormatException eee) {
        			eee.printStackTrace();
            		JOptionPane.showMessageDialog(null,"您输入的不是数字或者数字格式不对，请重新输入！"
            				,"顺序查找",JOptionPane.PLAIN_MESSAGE,imageIcon_menu);
        		}catch (Exception eeee) {
        			eeee.printStackTrace();
        		}

        	}
        });
        
        //输入折半查询数据
        item9.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		String dir=System.getProperty("user.dir");   //获取当前路径
        		String filepath=dir+"\\OrderNum.txt";
        		int data[] = new int[100001];
        		MyreadFileNum(filepath,data,100000);
        		//开始计时
            	long startTime =  System.currentTimeMillis();
            	try {
            		Object os=JOptionPane.showInputDialog(null,"请输入您想在文件中折半查找的数字：\n","折半查找数字输入",
            				JOptionPane.PLAIN_MESSAGE,imageIcon_menu,null,"在这输入数字");
            		String str=os.toString();   //类型转换成字符串和数字
            		int numForSearch=Integer.parseInt(str);
            		//查找
                	int index=binarySearch(data,numForSearch);
            		long endTime =  System.currentTimeMillis();
            		long usedTime = (endTime-startTime);
            		
                	if(data[index-1]==numForSearch) {
                		JOptionPane.showMessageDialog(null,"您所查询的数字存在！\n"
                				+ "数字"+numForSearch+"第1次出现的位置是排序后文件中的第"+index+"个\n"
                				+ "折半查找花费查询时间为"+usedTime+"毫秒。"
                				,"折半查找",JOptionPane.PLAIN_MESSAGE,imageIcon_menu);
                	}else {
                		JOptionPane.showMessageDialog(null,"很遗憾，已经很努力的再找了┭┮﹏┭┮\n"
                				+ "但是您所查询的数字"+numForSearch+"在本次随机生成的数据文件中不存在！\n"
                				+ "折半查找花费查询时间为"+usedTime+"毫秒。\n"
                				+ "\n但我们找到了与您想查询的数字最接近的数字和它的位置！^^\n"
                				+ "这个数字是："+data[index-1]+"，它出现的位置是排序后文件中的第"+index+"个。"
                				,"折半查找",JOptionPane.PLAIN_MESSAGE,imageIcon_menu);
                	}
                	
            	}catch (NumberFormatException eee) {
        			eee.printStackTrace();
            		JOptionPane.showMessageDialog(null,"您输入的不是数字或者数字格式不对，请重新输入！"
            				,"折半查找",JOptionPane.PLAIN_MESSAGE,imageIcon_menu);
        		}catch (Exception eeee) {
        			eeee.printStackTrace();
        		}
        	}
        });
        
        //索引查找！！！->哈希查找
        item10.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		JOptionPane.showMessageDialog(null,"哈希索引查找目前还在完善中233\n先试试别的查找方法吧！"
        				,"哈希索引查找",JOptionPane.PLAIN_MESSAGE,imageIcon_menu);  		

        	}
        });
        
        //重新生成数据
        item11.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
                Object[] options ={ "确定", "取消" };
                progressBar.setVisible(true);   //开始显示进度条
                int m = JOptionPane.showOptionDialog(null, "您确定要重新生成数据文件吗？\n"
                		, "确认",JOptionPane.YES_NO_OPTION, 
                		JOptionPane.QUESTION_MESSAGE,imageIcon_menu, options, options[0]);
                
                if(m==0) {
                    long startTime =  System.currentTimeMillis();
                    for(int i=0;i<100000;i++) {
                    	int a=new Random().nextInt(100000-0)+0;
                    	try {
                    		File f=new File("text.txt");
                    		if(f.exists()) {
                    			//System.out.println("文件存在");
                    		}else {
                    			//System.out.println("文件不存在");
                    			f.createNewFile();
                    		}
                    		BufferedWriter output = new BufferedWriter(new FileWriter(f,true));
                    		output.write(a+" ");
                    		output.close();
                    	} catch (IOException e1) {
                    		e1.printStackTrace();
                    	}
                    }
                    long endTime =  System.currentTimeMillis();
                    long usedTime = (endTime-startTime)/1000;

                    JOptionPane.showMessageDialog(null,"数据已经生成！\n"
                    		+ "10万条数值数据已经保存在“text.txt”文件中\n"
                    		+ "生成数据并保存到文件用时"+usedTime+"秒\n"
                    		+ "数据较多，等待时间可能较长，见谅！"
                    		,"保存成功",JOptionPane.PLAIN_MESSAGE,imageIcon_menu);
                }else {
                    progressBar.setVisible(false);
                }
                progressBar.setVisible(false);   //结束显示进度条
        	}
        });
        
        //886!
        item12.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
				System.exit(0);
        	}
        });
        
        //项目主页
        item13.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		try {
        			//我的github项目首页
        			Runtime.getRuntime().exec("rundll32 url.dll,FileProtocolHandler https://github.com/Andytonglove");
        		} catch (IOException e1) {
        			e1.printStackTrace();
        		}
        	}
        });
        
        //关于项目
        item14.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		JFrame fr6=new JFrame();
        		fr6.setTitle("关于项目");
        		fr6.setSize(300,220);
        		fr6.setLocationRelativeTo(null);
        		fr6.setResizable(false); 
        		fr6.setVisible(true);
        		fr6.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        		fr6.setIconImage(im);
        		JLabel imgLabel = new JLabel(img);//将背景图放在标签里。
        		fr6.getLayeredPane().add(imgLabel,Integer.valueOf(Integer.MIN_VALUE));
        		imgLabel.setBounds(0, 0, img.getIconWidth(), img.getIconHeight());	
        		imgLabel.setOpaque(true);
        		
        		JPanel p6=new JPanel();
        		fr6.setContentPane(p6);//面板
        		p6.setOpaque(false);
         		p6.setLayout(new BorderLayout());
         		
             	JTextArea textArea6=new JTextArea();
        		textArea6.setLineWrap(true);
        		textArea6.setSize(250,220);
                p6.add("Center",textArea6);
                textArea6.setOpaque(false);
                textArea6.setForeground(Color.RED);
                textArea6.setFont(new Font("仿宋",Font.BOLD,18));    

                textArea6.setEditable(false);
                textArea6.append("本Java程序开发信息：\n\n"
                		+ "本程序主要实现对10万数据量数据的随机生成、"
                		+ "文件读写以及排序查找，并比较了算法的时间复杂度。\n"
                		+ "软件版本：Version 1.0\n"
                		+ "开发设计：关子安 黄一格 林雨淇\n"
                		+ "开发工具：Java GUI");
                textArea6.setEditable(false);
                
        	}
        });
        
        //左下角文本提示框
        ActionListener listen = new ActionListener(){
        	public void actionPerformed(ActionEvent e){
        		textArea.setEditable(false);
        		if(e.getSource()==item1)  textArea.setText("正在进行数据生成和选择……\n");
        		if(e.getSource()==item2)  textArea.setText("即将打开生成的数据文件……\n");
        		if(e.getSource()==item3)  textArea.setText("正在以冒泡（交换）排序法对数据进行排序！\n");
        		if(e.getSource()==item4)  textArea.setText("正在以快速排序法对数据进行排序！\n");
        		if(e.getSource()==item5)  textArea.setText("正在以折半插入/黄金分割排序法对数据进行排序！\n");
        		if(e.getSource()==item6)  textArea.setText("正在以归并排序法对数据进行排序！\n");
        		if(e.getSource()==item7)  textArea.setText("即将打开排序生成的的数据文件……\n");
        		if(e.getSource()==item8)  textArea.setText("您选择在输入数据进行顺序查找……");
        		if(e.getSource()==item9)  textArea.setText("您选择在输入数据进行折半查找……\n");
        		if(e.getSource()==item10)  textArea.setText("您选择进行哈希索引查找数据！！！\n");
        		if(e.getSource()==item11)  textArea.setText("正在进行重新生成数据文档……\n");
        		if(e.getSource()==item12)  textArea.setText("886！\n");
        		if(e.getSource()==item13)  textArea.setText("即将访问本项目GitHub项目主页……\n");
        		if(e.getSource()==item14)  textArea.setText("即将访问本项目相关信息！\n");

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
        item10.addActionListener(listen);
        item11.addActionListener(listen);
        item12.addActionListener(listen);
        item13.addActionListener(listen);
        item14.addActionListener(listen);
	}
	
/////////////////////我是一条分割线，下方是部分函数/////////////////////////////////
	
	//以空格为分隔符读取文件，调用nextInt
    public static void MyreadFileNum(String fileName,int num[],int sum) {
		File file = new File(fileName);
		try {
			Scanner s = new Scanner(file);
			for(int i=0;i<sum;i++) {
				num[i] = s.nextInt();
			}
			s.close();
		}catch(Exception ee) {
			System.out.println("节点基本信息文件未找到");
    		JOptionPane.showMessageDialog(null,"节点基本信息文件未找到");
			System.exit(0);
		}
    }
    
    //以空格为分隔符写入文件
    public static void MyWriteFileNum(String fileName,int data[],int sum) {
		try {
			FileWriter fw = new FileWriter("OrderNum.txt");
			String str = "";
			for(int j=0;j<sum;j++){
				str += data[j] + " ";
			}
			fw.write(str);
			fw.flush();
			fw.close();
		}catch(Exception eee) {
			eee.printStackTrace();
		}
    }
    
    //快速排序
    public static void quickSort(int[] arr,int low,int high){
        int i,j,temp,t;
        if(low>high){
            return;
        }
        i=low;
        j=high;
        //temp就是基准位
        temp = arr[low];
 
        while (i<j) {
            //先看右边，依次往左递减
            while (temp<=arr[j]&&i<j) {
                j--;
            }
            //再看左边，依次往右递增
            while (temp>=arr[i]&&i<j) {
                i++;
            }
            //如果满足条件则交换
            if (i<j) {
                t = arr[j];
                arr[j] = arr[i];
                arr[i] = t;
            }
 
        }
        //最后将基准为与i和j相等位置的数字交换
         arr[low] = arr[i];
         arr[i] = temp;
        //递归调用左半数组
        quickSort(arr, low, j-1);
        //递归调用右半数组
        quickSort(arr, j+1, high);
    }
    
    //折半插入排序
	public static void halfsort(int[] array) {
		int low, high, mid;
		int tmp, j;
		
		for (int i = 1; i < array.length; i++) {
			tmp = array[i];
			low = 0;
			high = i - 1;
			while (low <= high) {
				mid = low + (high - low) / 2;
				if (array[mid] > tmp)
					high = mid - 1;
				else
					low = mid + 1;
			}

			for (j = i - 1; j > high; j--) {
				array[j + 1] = array[j];
			}
			array[high + 1] = tmp;
		}
	}
	
    //黄金分割排序
	public static void GoldenSectionSort(int[] array) {
		int low, high, mid;
		int tmp, j;
		
		for (int i = 1; i < array.length; i++) {
			tmp = array[i];
			low = 0;
			high = i - 1;
			while (low <= high) {
				mid = (int)(low + (high - low) * 0.6180339887);
				if (array[mid] > tmp)
					high = mid - 1;
				else
					low = mid + 1;
			}

			for (j = i - 1; j > high; j--) {
				array[j + 1] = array[j];
			}
			array[high + 1] = tmp;
		}
	}
	
	//归并排序
	public static void merge(int[] a, int s, int m, int e) {
		// 初始化一个从起始s到终止e的一个数组
		int[] temp = new int[(e - s) + 1];   // 左起始指针
		int l = s;   // 右起始指针
		int r = m + 1;
		int i = 0;
		// 将s-e这段数据在逻辑上一分为二,l-m为一个左边的数组,r-e为一个右边的数组,两边都是有序的
		// 从两边的第一个指针开始遍历,将其中小的那个值放在temp数组中
		while (l <= m && r <= e) {
			if (a[l] < a[r]) {
				temp[i++] = a[l++];
			} else {
				temp[i++] = a[r++];
			}
		}
		// 将两个数组剩余的数放到temp中
		while (l <= m) {
			temp[i++] = a[l++];
		}
		while (r <= e) {
			temp[i++] = a[r++];
		}
		// 将temp数组覆盖原数组
		for (int n = 0; n < temp.length; n++) {
			a[s + n] = temp[n];
		}
	}
	public static void mergeSort(int[] a,int s,int e){
		int m = (s + e) / 2;
		if (s < e){
			mergeSort(a,s,m);
			mergeSort(a,m+1,e);
			//归并
			merge(a,s,m,e);
		}
	}
	
	//折半查找
    public static int binarySearch(int[] arr, int key) {
        int low = 0;
        int high = arr.length - 1;
        int minindex=0;
        int minDifference = Math.abs(arr[0]-key);
        
        while (low <= high) { //必须为 '<=' 否则无法匹配到指定的key；
            int mid = (low + high) / 2;

            if (arr[mid] == key) {
                return (mid + 1);
            } else if (arr[mid] > key) {
                high = mid - 1;
                if(Math.abs(arr[mid]-key)<minDifference) {
                	minDifference=Math.abs(arr[mid]-key);
                	minindex=mid;
                }
            } else if (arr[mid] < key) {
                low = mid + 1;
                if(Math.abs(key-arr[mid])<minDifference) {
                	minDifference=Math.abs(arr[mid]-key);
                	minindex=mid;
                }
            }
        }
        return minindex+1;
    }
    
    
/////////////////////我是一条分割线，下方是主函数/////////////////////////////////
	
	//主函数！！！
	public static void main(String args[]) {
		new OutputOrderNum();
		
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