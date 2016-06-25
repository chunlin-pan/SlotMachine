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
	/**產生三個亂數
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
	 * 產生GUI
	 */
	public gui(){
		
		super("拉霸");
		setLayout(null);
		
		//設定JFrameIcon
		super.setIconImage(jframeicon.getImage());
	    
		//顯示初始籌碼
		money=50;
		text1=new JLabel();
		text1.setBounds(170, -35, 1000, 170);
		text1.setText("<html><span style='font-size:100px'>"+"剩餘籌碼:"+money+"</span></html>");
		add(text1);
		
		//顯示下方賭場GIF
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
		
		//一開始顯顯示三張7
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
		//拉霸啓動的按鈕
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
	                    		// 按下按鈕之後執行的動作
				    					    setPicture();
				    					    get_three_image();
	    					    System.out.println(math1+","+math2+","+math3);
	    					    money=money-5;
	    					    text1.setText("<html><span style='font-size:100px'>"+"剩餘籌碼:"+money+"</span></html>");
	    					    //當初現777時顯示中獎
	    						if(math1==math2&&math2==math3&&math3==0)
	    						{
	    							JOptionPane.showMessageDialog(gui, "中獎拉!!");
	    							money=money+100;
	    							text1.setText("<html><span style='font-size:100px'>"+"剩餘籌碼:"+money+"</span></html>");
	    						}
	    						if(money<=0)
	    						{
	    							JOptionPane.showMessageDialog(gui,"<html><span style='font-size:50px'>"+ "沒錢囉!  為您重新儲值50元"+"</span></html>");
	    							money=50;	
	    							text1.setText("<html><span style='font-size:100px'>"+"剩餘籌碼:"+money+"</span></html>");
	    						}
	                    	}
	                    });
	                    	
		    		}
		    		/*public void run(){
			    		// 按下按鈕之後執行的動作
					    setPicture();
					    get_three_image();
					    System.out.println(math1+","+math2+","+math3);
					    money=money-10;
					    //當初現777時顯示中獎
						if(math1==math2&&math2==math3&&math3==0)
						{
							JOptionPane.showMessageDialog(gui, "中獎拉!!");
							money=money+100;
						}
						if(money<=0)
						{
							text1.setText("<html><span style='font-size:100px'>"+"剩餘籌碼:"+money+"</span></html>");
							JOptionPane.showMessageDialog(gui, "沒錢囉!  為您重新儲值50元");
							money=50;					
						}
						
		    		}*/	
		    	}).start();
		    	
		    }
		}); 
		add(start_button);
	}
	
	/**
	 * 由math1,math2,math3 決定出三張圖
	 */
	void get_three_image(){
		//決定第一張圖顯示哪個圖
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
				
				//決定第二張圖顯示哪個圖
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
				
				//決定第参張圖顯示哪個圖
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
/*	private class buttonHandler implements ActionListener{
		public void actionPerformed(ActionEvent event){
			slot_machine.setPicture();
			get_three_image();
		}
	}*/

}