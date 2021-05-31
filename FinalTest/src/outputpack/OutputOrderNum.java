package outputpack;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.util.*;
import javax.swing.*;

public class OutputOrderNum {
	public OutputOrderNum() {
		JFrame jf=new JFrame("���ݴ���Ӧ��");
		jf.setSize(860,600);
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
		
		String dir=System.getProperty("user.dir");//��ȡ���·��
		//����ͼ��
		ImageIcon ig = new ImageIcon(dir+"\\src\\images\\inter.png");
		Image im = ig.getImage();
		jf.setIconImage(im);
		
		//���ñ���
		ImageIcon img = new ImageIcon(dir+"\\src\\images\\back.jpg");
		JLabel imgLabel = new JLabel(img);//������ͼ���ڱ�ǩ��
		jf.getLayeredPane().add(imgLabel,Integer.valueOf(Integer.MIN_VALUE));
		imgLabel.setBounds(0, 0, img.getIconWidth(), img.getIconHeight());	
		imgLabel.setOpaque(true);
		
		JPanel p=new JPanel();
		jf.setContentPane(p);//���
		p.setLayout(null);//���ɲ���
		p.setOpaque(false);
		
		//�˵���
		JMenuBar menubar1=new JMenuBar();
		jf.setJMenuBar(menubar1);

		//�˵���
 		ImageIcon imageIcon_menu=new ImageIcon(dir+"\\src\\images\\intersmall.png");//�˵�ͼ��
 		JMenu menu1=new JMenu("��������");
		JMenu menu2=new JMenu("��������");
     	JMenu menu3=new JMenu("���ݲ�ѯ");
     	JMenu menu4=new JMenu("����");
		menubar1.add(menu1);
		menubar1.add(menu2);
		menubar1.add(menu3);
		menubar1.add(menu4);
		
 		//�����Ӳ˵���
		JMenuItem item1=new JMenuItem("����������ѡ��",imageIcon_menu);
		JMenuItem item2=new JMenuItem("�鿴�����ļ�",imageIcon_menu);   //menu1
     	JMenuItem item3=new JMenuItem("ð������",imageIcon_menu);
     	JMenuItem item4=new JMenuItem("��������",imageIcon_menu);
     	JMenuItem item5=new JMenuItem("�۰����/�ƽ�ָ�����",imageIcon_menu);
     	JMenuItem item6=new JMenuItem("�鲢����",imageIcon_menu);
		JMenuItem item7=new JMenuItem("�鿴�����ļ������",imageIcon_menu);   //menu2
     	JMenuItem item8=new JMenuItem("˳���������",imageIcon_menu);
     	JMenuItem item9=new JMenuItem("�۰��������",imageIcon_menu);
     	JMenuItem item10=new JMenuItem("��ϣ������������",imageIcon_menu);
     	JMenuItem item11=new JMenuItem("������������",imageIcon_menu);   //menu3
     	JMenuItem item12=new JMenuItem("�����ټ�",imageIcon_menu);
     	JMenuItem item13=new JMenuItem("��Ŀ��ҳ",imageIcon_menu);
     	JMenuItem item14=new JMenuItem("������Ŀ",imageIcon_menu);   //menu4
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
 		
 		//һ���ж���ʾ�ı���
     	JTextArea textArea=new JTextArea();
        p.add(textArea);
        textArea.setSize(330,450);
        textArea.setBounds(0, 510, 360, 450);
        textArea.setOpaque(false);
        textArea.setEditable(false);
        textArea.setForeground(Color.BLUE);
        textArea.setFont(new Font("����",Font.PLAIN,16));
        
        //��ఴ��
 		ImageIcon imageIcon_button=new ImageIcon(dir+"\\src\\images\\photoforbutton_1.png");
        JButton jb1=new JButton("�������ɺ�����",imageIcon_button);
        p.add(jb1);
        jb1.setBounds(225,190,160,140);//860*600->setBounds(x:335,y:200,width:160,height:120);
        jb1.setFont(new Font("����", Font.PLAIN, 20));
        jb1.setForeground(Color.black);
        jb1.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));   //��������ʽ
        jb1.setContentAreaFilled(false);//͸��
        jb1.setBackground(new Color(207,226,243));//��ɫ����Ҫ��͸���ڵ�һ�����ݣ���͸����һ��ֻ�б߿�
        jb1.setOpaque(true);//�ڵ�
        jb1.setBorder(BorderFactory.createRaisedBevelBorder());//͹��ť
        jb1.setVerticalTextPosition(SwingConstants.BOTTOM);//�ı����λ������
        jb1.setHorizontalTextPosition(SwingConstants.CENTER);
        
        jb1.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		JOptionPane.showMessageDialog(null,"��Ҫ�����������������˵�����һ�����������ɡ�\n"
        				+ "��Ҫ�����������������˵����ڶ�������������\n"
        				+ "���ڴ�������������ϴ󣬲����������������Ҫ�ϳ��ȴ�ʱ�䣬���£�\n\n"
        				+ "�����������10,0000�������������������ٶȵĽ��ۣ�\n"
        				+ "��������>>�鲢����>>>>>��������>>ѡ������>>ð������"
        				,"������ʾ",JOptionPane.PLAIN_MESSAGE,imageIcon_menu);                
        	}
        });
        
        //�Ҳఴ��
        JButton jb2=new JButton("���ݲ�ѯ",imageIcon_button);
        p.add(jb2);
        jb2.setBounds(445,190,160,140);
        jb2.setOpaque(false);
        jb2.setFont(new Font("����", Font.PLAIN, 20));
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
        		JOptionPane.showMessageDialog(null,"��Ҫ�������ݲ�ѯ�����˵��������������ݲ�ѯ��\n"
        				+ "��Ҫ������ҳ���ʻ��˳���������˵������������˳���\n"
        				+ "���ڴ�������������ϴ󣬲��ֲ���������Ҫ�ϳ��ȴ�ʱ�䣬���£�\n\n"
        				+ "�ر�ģ����У����ݲ�ѯ�������������������������ļ��е�λ�úͳ��ִ�����\n"
        				+ "�������ȶ����ݽ������ɡ�ѡ���������ٽ��в��ң�"
        				,"������ʾ",JOptionPane.PLAIN_MESSAGE,imageIcon_menu);
        	}
        });
        
        String []FiletextPath={"\\text.txt"};   //��Ϊ�ļ���ȡʹ�õ�·��
        
        //����һ�������������ò���
        final JProgressBar progressBar = new JProgressBar();
        p.add(progressBar);
        progressBar.setBounds(330, 500, 180, 15);
        progressBar.setIndeterminate(true);   //ģ��ģʽ
        progressBar.setVisible(false);   //����ת���Ƿ�ɼ�����ʾ��Ч��һ�㣬��Ȼ�Ῠ             		
        /*
        //�����������ݻ�������д���ļ�����ʱ��ϳ��������Ǽ���һ��JProgressBar���������ö��߳�����ʾ
        progressBar.setMinimum(0);
        progressBar.setMaximum(100);
        int[] currentProgress = {0};
		progressBar.setValue(currentProgress[0]);   //���õ�ǰ����ֵ
        progressBar.setStringPainted(true);   //���ưٷֱ��ı����������м���ʾ�İٷ�����
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
        
/////////////////////����һ���ָ��ߣ��·��ǲ��ּ���/////////////////////////////////
        
        //����һ�������ݣ��ָ���Ϊ�ո�->�������ɺ�ѡ��
        item1.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
                Object[] options ={ "��ʹ���ṩ�����������ļ�~", "��������������������ļ���~" };
                progressBar.setVisible(true);   //��ʼ��ʾ������
                int m = JOptionPane.showOptionDialog(null, "�Ƿ�ѡ�����������ļ���Ϊ�������\n"
                		+ "����������κβ����͹رմ��ڣ�\n����Ϊ��ϣ��ʹ���Ѿ�Ԥ���������ɹ�����������ļ�^^\n"
                		+ "�����ܹ���ԼһЩ���������ļ��ĵȴ�ʱ�䣨��Լ7�룩��", "ѡ��ʹ������",
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
            					//System.out.println("�ļ�����");
            				}else {
            					//System.out.println("�ļ�������");
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
            		
            		JOptionPane.showMessageDialog(null,"�����Ѿ����ɣ�\n"
            				+ "10������ֵ�����Ѿ������ڡ�text.txt���ļ���\n"
            				+ "�������ݲ����浽�ļ���ʱ"+usedTime+"��\n"
            				+ "���ݽ϶࣬�ȴ�ʱ����ܽϳ������£�"
            				,"����ɹ�",JOptionPane.PLAIN_MESSAGE,imageIcon_menu);
                }else {
                	FiletextPath[0]="\\text.txt";
                }
                progressBar.setVisible(false);   //������ʾ������
        	}
        });
        
        //�鿴�����ļ�
        item2.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		String dir=System.getProperty("user.dir");   //��ȡ��ǰ·��
        		String filepath=dir+FiletextPath[0];
                try {
                    File file = new File(filepath);
                    Desktop.getDesktop().open(file);   // �������ڱ���������ע��Ĺ���Ӧ�ó��򣬴��ļ�����file��
                } catch (Exception e2) { 
                	// �쳣����
            		JOptionPane.showMessageDialog(null,"�ļ�δ���ɻ�δ�ҵ������������ɣ�"
            				,"����",JOptionPane.PLAIN_MESSAGE,imageIcon_menu);
                    System.err.println(e2);
                }

        	}
        });
        
        
        //ð������
        item3.addActionListener(new ActionListener() { 	
        	public void actionPerformed(ActionEvent e) {
        		int data[] = new int[100001];
        		//��ȡ���ݵ�����
        		String dir=System.getProperty("user.dir");   //��ȡ��ǰ·��
        		String filepath=dir+FiletextPath[0];
        		MyreadFileNum(filepath,data,100000);
        		
            	long startTime =  System.currentTimeMillis();
            	//ð������
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
        		
        		//��ʼд���ļ�
            	long startTime2 =  System.currentTimeMillis();
        		MyWriteFileNum("OrderNum.txt",data,100000);
        		long endTime2 =  System.currentTimeMillis();
        		long usedTime2 = (endTime2-startTime2)/1000;

        		JOptionPane.showMessageDialog(null,"�����Ѿ���ɣ�\n"
        				+ "�����������Ѿ����±����ڡ�OrderNum.txt���ļ���\n"
        				+ "ð��������ʱ"+usedTime+"����\n"
        				+ "���������д���ļ���ʱ"+usedTime2+"��\n"
        				+ "����10,0000��������ð������ƽ����ʱ9s\n"
        				+ "�������ӶȽϸߣ�����ʱ��ǳ�����"
        				,"���",JOptionPane.PLAIN_MESSAGE,imageIcon_menu);
        	}
        });
        
        //��������
        item4.addActionListener(new ActionListener() { 	
        	public void actionPerformed(ActionEvent e) {
        		int data[] = new int[100001];
        		//��ȡ���ݵ�����
        		String dir=System.getProperty("user.dir");   //��ȡ��ǰ·��
        		String filepath=dir+FiletextPath[0];
        		MyreadFileNum(filepath,data,100000);
        		
            	long startTime =  System.currentTimeMillis();
            	//��������
            	quickSort(data, 0, 100000);
        		long endTime =  System.currentTimeMillis();
        		long usedTime = (endTime-startTime);
        		
        		//��ʼд���ļ�
            	long startTime2 =  System.currentTimeMillis();
        		MyWriteFileNum("OrderNum.txt",data,100000);
        		long endTime2 =  System.currentTimeMillis();
        		long usedTime2 = (endTime2-startTime2)/1000;

        		JOptionPane.showMessageDialog(null,"�����Ѿ���ɣ�\n"
        				+ "�����������Ѿ����±����ڡ�OrderNum.txt���ļ���\n"
        				+ "����������ʱ"+usedTime+"����\n"
        				+ "���������д���ļ���ʱ"+usedTime2+"��\n"
        				+ "����10,0000��������ð������ƽ����ʱ0-1s\n"
        				+ "�����������ٶȷǳ��죡"
        				,"���",JOptionPane.PLAIN_MESSAGE,imageIcon_menu);
        	}
        });
        
        //�۰����/�ƽ�ָ�����
        item5.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
                Object[] options ={ "ѡ���۰��������", "ѡ��ƽ�ָ�����" };  
                int m = JOptionPane.showOptionDialog(null, "�۰����� or �ƽ�ָ�����", "ѡ��",
                		JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE,
                		imageIcon_menu, options, options[0]);  
        		
        		int data[] = new int[100001];
        		//��ȡ���ݵ�����
        		String dir=System.getProperty("user.dir");   //��ȡ��ǰ·��
        		String filepath=dir+FiletextPath[0];
        		MyreadFileNum(filepath,data,100000);
        		
        		int flag=1;
            	//�۰����/�ƽ�ָ�����
            	long startTime =  System.currentTimeMillis();
            	if(m==0) {
            		halfsort(data);
            	}else if(m==1) {
            		GoldenSectionSort(data);
            	}else {
            		//ɶ�����ɣ��ȴ��رմ��ڣ���ִ���������
            		flag=0;
            	}
        		long endTime =  System.currentTimeMillis();
        		long usedTime = (endTime-startTime);
        		
        		if(flag==1) {
            		//��ʼд���ļ�
                	long startTime52 =  System.currentTimeMillis();
            		MyWriteFileNum("OrderNum.txt",data,100000);
            		long endTime52 =  System.currentTimeMillis();
            		long usedTime52 = (endTime52-startTime52)/1000;

                	if(m==0) {
                		JOptionPane.showMessageDialog(null,"�����Ѿ���ɣ�\n"
                				+ "�����������Ѿ����±����ڡ�OrderNum.txt���ļ���\n"
                				+ "�۰����������ʱ"+usedTime+"����\n"
                				+ "���������д���ļ���ʱ"+usedTime52+"��\n"
                				+ "����10,0000���������۰��������ƽ����ʱ1s+\n"
                				+ "����������Ͽ죡"
                				,"���",JOptionPane.PLAIN_MESSAGE,imageIcon_menu);
                	}else if(m==1) 
                	{
                		JOptionPane.showMessageDialog(null,"�����Ѿ���ɣ�\n"
                				+ "�����������Ѿ����±����ڡ�OrderNum.txt���ļ���\n"
                				+ "�ƽ�ָ�������ʱ"+usedTime+"����\n"
                				+ "���������д���ļ���ʱ"+usedTime52+"��\n"
                				+ "����10,0000���������ƽ�ָ�����ƽ����ʱ1s+\n"
                				+ "����������Ͽ죡"
                				,"���",JOptionPane.PLAIN_MESSAGE,imageIcon_menu);
                	}
        		}

        	}
        });
        
        //�鲢����
        item6.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		int data[] = new int[100001];
        		//��ȡ���ݵ�����
        		String dir=System.getProperty("user.dir");   //��ȡ��ǰ·��
        		String filepath=dir+FiletextPath[0];
        		MyreadFileNum(filepath,data,100000);
        		
            	long startTime =  System.currentTimeMillis();
            	//�鲢����
            	mergeSort(data,0,100000);
        		long endTime =  System.currentTimeMillis();
        		long usedTime = (endTime-startTime);
        		
        		//��ʼд���ļ�
            	long startTime2 =  System.currentTimeMillis();
        		MyWriteFileNum("OrderNum.txt",data,100000);
        		long endTime2 =  System.currentTimeMillis();
        		long usedTime2 = (endTime2-startTime2)/1000;

        		JOptionPane.showMessageDialog(null,"�����Ѿ���ɣ�\n"
        				+ "�����������Ѿ����±����ڡ�OrderNum.txt���ļ���\n"
        				+ "�鲢������ʱ"+usedTime+"����\n"
        				+ "���������д���ļ���ʱ"+usedTime2+"��\n"
        				+ "����10,0000���������鲢����ƽ����ʱ0-1s\n"
        				+ "�����������ٶȷǳ��죡"
        				,"���",JOptionPane.PLAIN_MESSAGE,imageIcon_menu);
        	}
        });
        
        //�������ĵ�
        item7.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		JOptionPane.showMessageDialog(null,"���ۣ�\n"
        				+ "����10,0000�������������ٶȣ�\n"
        				+ "��������>>�鲢����>>>>>��������>>ѡ������>>ð������"
        				,"����",JOptionPane.PLAIN_MESSAGE,imageIcon_menu);
        		
        		String dir=System.getProperty("user.dir");   //��ȡ��ǰ·��
        		String filepath=dir+"\\OrderNum.txt";
                try {
                    File file = new File(filepath);
                    Desktop.getDesktop().open(file);   // �������ڱ���������ע��Ĺ���Ӧ�ó��򣬴��ļ�����file��
                } catch (Exception e11) { 
                	// �쳣����
            		JOptionPane.showMessageDialog(null,"�ļ�δ���ɻ�δ�ҵ������������ɣ�"
            				,"����",JOptionPane.PLAIN_MESSAGE,imageIcon_menu);
                    System.err.println(e11);
                }
        	}
        });
        
        //����˳���ѯ����
        item8.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		String dir=System.getProperty("user.dir");   //��ȡ��ǰ·��
        		String filepath=dir+"\\OrderNum.txt";
        		int data[] = new int[100001];
        		MyreadFileNum(filepath,data,100000);
        		
        		try {
            		Object os=JOptionPane.showInputDialog(null,"�������������ļ���˳����ҵ����֣�\n","˳�������������",
            				JOptionPane.PLAIN_MESSAGE,imageIcon_menu,null,"������������");
            		String str=os.toString();   //����ת�����ַ���������
            		int numForSearch=Integer.parseInt(str);
            		//����
                	long startTime =  System.currentTimeMillis();
            		int i=0;
            		int j=0;
            		//�趨��С��ֵ��ͳ�ƣ���û���ҵ�ʱ���������ӽ�����
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
                    		
                    		JOptionPane.showMessageDialog(null,"������ѯ�����ִ��ڣ�\n"
                    				+ "����"+numForSearch+"��"+j+"�γ��ֵ�λ����������ļ��еĵ�"+(i+1)+"��\n"
                    				+ "˳����һ��Ѳ�ѯʱ��Ϊ"+usedTime+"���롣"
                    				,"˳�����",JOptionPane.PLAIN_MESSAGE,imageIcon_menu);
                    		continue;
            			}
            		}
            		if(i==100000 && j!=0) {
                		JOptionPane.showMessageDialog(null,"������ѯ������"+numForSearch
                				+"���ļ����ܹ�������"+j+"��"
                				,"��������",JOptionPane.PLAIN_MESSAGE,imageIcon_menu);
            		}
            		if(i==100000 && j==0) {
                		long endTime =  System.currentTimeMillis();
                		long usedTime = (endTime-startTime);
                		JOptionPane.showMessageDialog(null,"���ź����Ѿ���Ŭ���������˩ѩҩn�ѩ�\n"
                				+ "����������ѯ������"+numForSearch+"�ڱ���������ɵ������ļ��в����ڣ�\n"
                				+ "˳����һ��Ѳ�ѯʱ��Ϊ"+usedTime+"���롣\n"
                				+ "\n�������ҵ����������ѯ��������ӽ������ֺ�����λ�ã�^^\n"
                				+ "��������ǣ�"+data[minIndex]+"�������ֵ�λ����������ļ��еĵ�"+(minIndex+1)+"����"
                				,"˳�����",JOptionPane.PLAIN_MESSAGE,imageIcon_menu);
            		}
            		
        		}catch (NumberFormatException eee) {
        			eee.printStackTrace();
            		JOptionPane.showMessageDialog(null,"������Ĳ������ֻ������ָ�ʽ���ԣ����������룡"
            				,"˳�����",JOptionPane.PLAIN_MESSAGE,imageIcon_menu);
        		}catch (Exception eeee) {
        			eeee.printStackTrace();
        		}

        	}
        });
        
        //�����۰��ѯ����
        item9.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		String dir=System.getProperty("user.dir");   //��ȡ��ǰ·��
        		String filepath=dir+"\\OrderNum.txt";
        		int data[] = new int[100001];
        		MyreadFileNum(filepath,data,100000);
        		//��ʼ��ʱ
            	long startTime =  System.currentTimeMillis();
            	try {
            		Object os=JOptionPane.showInputDialog(null,"�������������ļ����۰���ҵ����֣�\n","�۰������������",
            				JOptionPane.PLAIN_MESSAGE,imageIcon_menu,null,"������������");
            		String str=os.toString();   //����ת�����ַ���������
            		int numForSearch=Integer.parseInt(str);
            		//����
                	int index=binarySearch(data,numForSearch);
            		long endTime =  System.currentTimeMillis();
            		long usedTime = (endTime-startTime);
            		
                	if(data[index-1]==numForSearch) {
                		JOptionPane.showMessageDialog(null,"������ѯ�����ִ��ڣ�\n"
                				+ "����"+numForSearch+"��1�γ��ֵ�λ����������ļ��еĵ�"+index+"��\n"
                				+ "�۰���һ��Ѳ�ѯʱ��Ϊ"+usedTime+"���롣"
                				,"�۰����",JOptionPane.PLAIN_MESSAGE,imageIcon_menu);
                	}else {
                		JOptionPane.showMessageDialog(null,"���ź����Ѿ���Ŭ���������˩ѩҩn�ѩ�\n"
                				+ "����������ѯ������"+numForSearch+"�ڱ���������ɵ������ļ��в����ڣ�\n"
                				+ "�۰���һ��Ѳ�ѯʱ��Ϊ"+usedTime+"���롣\n"
                				+ "\n�������ҵ����������ѯ��������ӽ������ֺ�����λ�ã�^^\n"
                				+ "��������ǣ�"+data[index-1]+"�������ֵ�λ����������ļ��еĵ�"+index+"����"
                				,"�۰����",JOptionPane.PLAIN_MESSAGE,imageIcon_menu);
                	}
                	
            	}catch (NumberFormatException eee) {
        			eee.printStackTrace();
            		JOptionPane.showMessageDialog(null,"������Ĳ������ֻ������ָ�ʽ���ԣ����������룡"
            				,"�۰����",JOptionPane.PLAIN_MESSAGE,imageIcon_menu);
        		}catch (Exception eeee) {
        			eeee.printStackTrace();
        		}
        	}
        });
        
        //�������ң�����->��ϣ����
        item10.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		JOptionPane.showMessageDialog(null,"��ϣ��������Ŀǰ����������233\n�����Ա�Ĳ��ҷ����ɣ�"
        				,"��ϣ��������",JOptionPane.PLAIN_MESSAGE,imageIcon_menu);  		

        	}
        });
        
        //������������
        item11.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
                Object[] options ={ "ȷ��", "ȡ��" };
                progressBar.setVisible(true);   //��ʼ��ʾ������
                int m = JOptionPane.showOptionDialog(null, "��ȷ��Ҫ�������������ļ���\n"
                		, "ȷ��",JOptionPane.YES_NO_OPTION, 
                		JOptionPane.QUESTION_MESSAGE,imageIcon_menu, options, options[0]);
                
                if(m==0) {
                    long startTime =  System.currentTimeMillis();
                    for(int i=0;i<100000;i++) {
                    	int a=new Random().nextInt(100000-0)+0;
                    	try {
                    		File f=new File("text.txt");
                    		if(f.exists()) {
                    			//System.out.println("�ļ�����");
                    		}else {
                    			//System.out.println("�ļ�������");
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

                    JOptionPane.showMessageDialog(null,"�����Ѿ����ɣ�\n"
                    		+ "10������ֵ�����Ѿ������ڡ�text.txt���ļ���\n"
                    		+ "�������ݲ����浽�ļ���ʱ"+usedTime+"��\n"
                    		+ "���ݽ϶࣬�ȴ�ʱ����ܽϳ������£�"
                    		,"����ɹ�",JOptionPane.PLAIN_MESSAGE,imageIcon_menu);
                }else {
                    progressBar.setVisible(false);
                }
                progressBar.setVisible(false);   //������ʾ������
        	}
        });
        
        //886!
        item12.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
				System.exit(0);
        	}
        });
        
        //��Ŀ��ҳ
        item13.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		try {
        			//�ҵ�github��Ŀ��ҳ
        			Runtime.getRuntime().exec("rundll32 url.dll,FileProtocolHandler https://github.com/Andytonglove");
        		} catch (IOException e1) {
        			e1.printStackTrace();
        		}
        	}
        });
        
        //������Ŀ
        item14.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		JFrame fr6=new JFrame();
        		fr6.setTitle("������Ŀ");
        		fr6.setSize(300,220);
        		fr6.setLocationRelativeTo(null);
        		fr6.setResizable(false); 
        		fr6.setVisible(true);
        		fr6.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        		fr6.setIconImage(im);
        		JLabel imgLabel = new JLabel(img);//������ͼ���ڱ�ǩ�
        		fr6.getLayeredPane().add(imgLabel,Integer.valueOf(Integer.MIN_VALUE));
        		imgLabel.setBounds(0, 0, img.getIconWidth(), img.getIconHeight());	
        		imgLabel.setOpaque(true);
        		
        		JPanel p6=new JPanel();
        		fr6.setContentPane(p6);//���
        		p6.setOpaque(false);
         		p6.setLayout(new BorderLayout());
         		
             	JTextArea textArea6=new JTextArea();
        		textArea6.setLineWrap(true);
        		textArea6.setSize(250,220);
                p6.add("Center",textArea6);
                textArea6.setOpaque(false);
                textArea6.setForeground(Color.RED);
                textArea6.setFont(new Font("����",Font.BOLD,18));    

                textArea6.setEditable(false);
                textArea6.append("��Java���򿪷���Ϣ��\n\n"
                		+ "��������Ҫʵ�ֶ�10�����������ݵ�������ɡ�"
                		+ "�ļ���д�Լ�������ң����Ƚ����㷨��ʱ�临�Ӷȡ�\n"
                		+ "����汾��Version 1.0\n"
                		+ "������ƣ����Ӱ� ��һ�� �����\n"
                		+ "�������ߣ�Java GUI");
                textArea6.setEditable(false);
                
        	}
        });
        
        //���½��ı���ʾ��
        ActionListener listen = new ActionListener(){
        	public void actionPerformed(ActionEvent e){
        		textArea.setEditable(false);
        		if(e.getSource()==item1)  textArea.setText("���ڽ����������ɺ�ѡ�񡭡�\n");
        		if(e.getSource()==item2)  textArea.setText("���������ɵ������ļ�����\n");
        		if(e.getSource()==item3)  textArea.setText("������ð�ݣ����������򷨶����ݽ�������\n");
        		if(e.getSource()==item4)  textArea.setText("�����Կ������򷨶����ݽ�������\n");
        		if(e.getSource()==item5)  textArea.setText("�������۰����/�ƽ�ָ����򷨶����ݽ�������\n");
        		if(e.getSource()==item6)  textArea.setText("�����Թ鲢���򷨶����ݽ�������\n");
        		if(e.getSource()==item7)  textArea.setText("�������������ɵĵ������ļ�����\n");
        		if(e.getSource()==item8)  textArea.setText("��ѡ�����������ݽ���˳����ҡ���");
        		if(e.getSource()==item9)  textArea.setText("��ѡ�����������ݽ����۰���ҡ���\n");
        		if(e.getSource()==item10)  textArea.setText("��ѡ����й�ϣ�����������ݣ�����\n");
        		if(e.getSource()==item11)  textArea.setText("���ڽ����������������ĵ�����\n");
        		if(e.getSource()==item12)  textArea.setText("886��\n");
        		if(e.getSource()==item13)  textArea.setText("�������ʱ���ĿGitHub��Ŀ��ҳ����\n");
        		if(e.getSource()==item14)  textArea.setText("�������ʱ���Ŀ�����Ϣ��\n");

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
	
/////////////////////����һ���ָ��ߣ��·��ǲ��ֺ���/////////////////////////////////
	
	//�Կո�Ϊ�ָ�����ȡ�ļ�������nextInt
    public static void MyreadFileNum(String fileName,int num[],int sum) {
		File file = new File(fileName);
		try {
			Scanner s = new Scanner(file);
			for(int i=0;i<sum;i++) {
				num[i] = s.nextInt();
			}
			s.close();
		}catch(Exception ee) {
			System.out.println("�ڵ������Ϣ�ļ�δ�ҵ�");
    		JOptionPane.showMessageDialog(null,"�ڵ������Ϣ�ļ�δ�ҵ�");
			System.exit(0);
		}
    }
    
    //�Կո�Ϊ�ָ���д���ļ�
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
    
    //��������
    public static void quickSort(int[] arr,int low,int high){
        int i,j,temp,t;
        if(low>high){
            return;
        }
        i=low;
        j=high;
        //temp���ǻ�׼λ
        temp = arr[low];
 
        while (i<j) {
            //�ȿ��ұߣ���������ݼ�
            while (temp<=arr[j]&&i<j) {
                j--;
            }
            //�ٿ���ߣ��������ҵ���
            while (temp>=arr[i]&&i<j) {
                i++;
            }
            //������������򽻻�
            if (i<j) {
                t = arr[j];
                arr[j] = arr[i];
                arr[i] = t;
            }
 
        }
        //��󽫻�׼Ϊ��i��j���λ�õ����ֽ���
         arr[low] = arr[i];
         arr[i] = temp;
        //�ݹ�����������
        quickSort(arr, low, j-1);
        //�ݹ�����Ұ�����
        quickSort(arr, j+1, high);
    }
    
    //�۰��������
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
	
    //�ƽ�ָ�����
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
	
	//�鲢����
	public static void merge(int[] a, int s, int m, int e) {
		// ��ʼ��һ������ʼs����ֹe��һ������
		int[] temp = new int[(e - s) + 1];   // ����ʼָ��
		int l = s;   // ����ʼָ��
		int r = m + 1;
		int i = 0;
		// ��s-e����������߼���һ��Ϊ��,l-mΪһ����ߵ�����,r-eΪһ���ұߵ�����,���߶��������
		// �����ߵĵ�һ��ָ�뿪ʼ����,������С���Ǹ�ֵ����temp������
		while (l <= m && r <= e) {
			if (a[l] < a[r]) {
				temp[i++] = a[l++];
			} else {
				temp[i++] = a[r++];
			}
		}
		// ����������ʣ������ŵ�temp��
		while (l <= m) {
			temp[i++] = a[l++];
		}
		while (r <= e) {
			temp[i++] = a[r++];
		}
		// ��temp���鸲��ԭ����
		for (int n = 0; n < temp.length; n++) {
			a[s + n] = temp[n];
		}
	}
	public static void mergeSort(int[] a,int s,int e){
		int m = (s + e) / 2;
		if (s < e){
			mergeSort(a,s,m);
			mergeSort(a,m+1,e);
			//�鲢
			merge(a,s,m,e);
		}
	}
	
	//�۰����
    public static int binarySearch(int[] arr, int key) {
        int low = 0;
        int high = arr.length - 1;
        int minindex=0;
        int minDifference = Math.abs(arr[0]-key);
        
        while (low <= high) { //����Ϊ '<=' �����޷�ƥ�䵽ָ����key��
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
    
    
/////////////////////����һ���ָ��ߣ��·���������/////////////////////////////////
	
	//������������
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
			    "                 ���汣��       ����BUG";
		System.out.println(fozu);
	}
	
	
}