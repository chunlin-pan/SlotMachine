import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;

@SuppressWarnings("serial")
public class gui extends JFrame {

	protected static final Component gui = null;
	private JButton start_button;
	private JLabel picture1,picture2,picture3,casinoAD1,casinoAD2,casinoAD3;
	private int math1;
	private int math2;
	private int math3;
	private JLabel text1;
	private  Integer money;
	/**���ͤT�Ӷü�
	 * 
	 */
	public void setPicture(){
		math1= (int) (Math.random()* 3);
		math2= (int) (Math.random()* 3);
		math3= (int) (Math.random()* 3);
	}
	/**
	 * 
	 * @return math1 
	 */
	public int getpicture1(){
		return math1;
	}
	/**
	 * 
	 * @return math2
	 */
	public int getpicture2(){
		return math2;
	}
	/**
	 * 
	 * @return math3
	 */
	public int getpicture3(){
		return math3;
	}
	

	Icon  seven=new ImageIcon((getClass().getResource("image/seven-960_720.png")));
	Icon  melon=new ImageIcon((getClass().getResource("image/watermelon-960_720.png")));
	Icon  strawbarry=new ImageIcon((getClass().getResource("image/strawberry-960_720.png")));
	Icon casinoADGIF=new ImageIcon((getClass().getResource("image/giphy.gif")));
	ImageIcon jframeicon=new ImageIcon((getClass().getResource("image/jframe_title.jpg")));
	/**
	 * ����GUI
	 */
	public gui(){
		
		super("���Q");
		setLayout(null);
		
		//�]�wJFrameIcon
		super.setIconImage(jframeicon.getImage());
	    
		//��ܪ�l�w�X
		money=50;
		text1=new JLabel();
		text1.setBounds(170, -35, 1000, 170);
		text1.setText("<html><span style='font-size:100px'>"+"�Ѿl�w�X:"+money+"</span></html>");
		add(text1);
		
		//��ܤU����GIF
		casinoAD1 =new JLabel();
		casinoAD1.setIcon(casinoADGIF);
		casinoAD1.setBounds(175, 500, 720, 360);
		add(casinoAD1);
		
		casinoAD2 =new JLabel();
		casinoAD2.setIcon(casinoADGIF);
		casinoAD2.setBounds(655, 500, 720, 360);
		add(casinoAD2);
		
		casinoAD3 =new JLabel();
		casinoAD3.setIcon(casinoADGIF);
		casinoAD3.setBounds(1135, 500, 720, 360);
		add(casinoAD3);
		
		//�@�}�l����ܤT�i7
		picture1=new JLabel();
		picture1.setIcon(seven);
		picture1.setBounds(100, 100, 400, 400);
		add(picture1);
		
		picture2=new JLabel();
		picture2.setIcon(seven);
		picture2.setBounds(520, 100, 400, 400);
		add(picture2);
		
		picture3=new JLabel();
		picture3.setIcon(seven);
		picture3.setBounds(940, 100, 400, 400);
		add(picture3)
		;
		//���Q?�ʪ����s
		Icon start=new ImageIcon((getClass().getResource("image/start.png")));
		start_button=new JButton(null,start);		
		start_button.setBounds(1460,100,400,400);
		start_button.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {
		    	new Thread(new Runnable(){
		    		public void run(){
		    			try{
		    				Thread.sleep(100);
		    			}catch (InterruptedException e1){}
	                    SwingUtilities.invokeLater(new Runnable(){
	                    	public void run(){
	                    		// ���U���s������檺�ʧ@
				    					    setPicture();
				    					    get_three_image();
	    					    System.out.println(math1+","+math2+","+math3);
	    					    money=money-5;
	    					    text1.setText("<html><span style='font-size:100px'>"+"�Ѿl�w�X:"+money+"</span></html>");
	    					    //���{777����ܤ���
	    						if(math1==math2&&math2==math3&&math3==0)
	    						{
	    							JOptionPane.showMessageDialog(gui, "������!!");
	    							money=money+100;
	    							text1.setText("<html><span style='font-size:100px'>"+"�Ѿl�w�X:"+money+"</span></html>");
	    						}
	    						if(money<=0)
	    						{
	    							JOptionPane.showMessageDialog(gui,"<html><span style='font-size:50px'>"+ "�S���o!  ���z���s�x��50��"+"</span></html>");
	    							money=50;	
	    							text1.setText("<html><span style='font-size:100px'>"+"�Ѿl�w�X:"+money+"</span></html>");
	    						}
	                    	}
	                    });
		    		}
		    	}).start();
		    	
		    }
		}); 
		add(start_button);
	}
	
	/**
	 * ��math1,math2,math3 �M�w�X�T�i��
	 */
	void get_three_image(){
		//�M�w�Ĥ@�i����ܭ��ӹ�
				switch(getpicture1()){
				case 0:
					picture1.setIcon(seven);
					add(picture1);
					break;
				case 1:
					picture1.setIcon(melon);
					add(picture1);
					break;
				case 2:
					picture1.setIcon(strawbarry);
					add(picture1);
					break;
				};
				
				//�M�w�ĤG�i����ܭ��ӹ�
				switch(getpicture2()){
				case 0:
					picture2.setIcon(seven);
					add(picture2);
					break;
				case 1:
					picture2.setIcon(melon);
					add(picture2);
					break;
				case 2:
					picture2.setIcon(strawbarry);
					add(picture2);
					break;
				};
				
				//�M�w��?�i����ܭ��ӹ�
				switch(getpicture3()){
				case 0:
					picture3.setIcon(seven);
					add(picture3);
					break;
				case 1:
					picture3.setIcon(melon);
					add(picture3);
					break;
				case 2:
					picture3.setIcon(strawbarry);
					add(picture3);
					break;
				}
				
	}

}