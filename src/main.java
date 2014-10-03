import java.awt.Desktop;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URL;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.WindowConstants;
import javax.swing.table.DefaultTableModel;

import twitter4j.Query;
import twitter4j.QueryResult;
import twitter4j.Status;
import twitter4j.Twitter;
import twitter4j.TwitterException;
import twitter4j.TwitterFactory;




public class main implements ActionListener{
	//Object data;
	JTextField txtContent = new JTextField();
	Frame frame = new Frame("FromAnon");
	 Twitter twitter = TwitterFactory.getSingleton();
	 String[] tweets = new String[10];
	
	 DefaultTableModel model = new DefaultTableModel();
	 
	 
	public main(){
		 
		//frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		model.addColumn("Tweets",tweets);
		frame.setBounds(0, 0, 321, 75);
		frame.setLayout(null);
	//	frame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		
	    txtContent.setBounds(5, 25, 250, 25);
	    txtContent.setVisible(true);
	    frame.add(txtContent);

    JButton btnTweet = new JButton("Tweet");

	    btnTweet.setBounds(250, 25, 70, 25);
	    btnTweet.addActionListener(this);
	    btnTweet.setVisible(true);
	    frame.add(btnTweet);
	  
	 
	    JButton btnOpen = new JButton("Open Feed");
	    btnOpen.setBounds(5,50,310, 25);
	    btnOpen.addActionListener(this);
	    frame.add(btnOpen);
	    frame.setVisible(true);
	   
	    
	}
	
	public static void main(String[] args){
		System.out.println("starting");
		main run = new main();
		
	}
	
	  public void actionPerformed(ActionEvent e) {
		  try {
			    String action =  e.getActionCommand();
			    
			    if(action.equals("Tweet")){
				Status status = twitter.updateStatus(txtContent.getText());
			    }
			    
			    if(action.equals("Open Feed")){
			    	openWebpage("https://twitter.com/TweetFromAnon");
			    	
			    }
			} catch (TwitterException ee) {
				// TODO Auto-generated catch block
				ee.printStackTrace();
			}
		  
		    // The factory instance is re-useable and thread safe.
		  //  Twitter twitter = TwitterFactory.getSingleton();

		  
  }
	  
	  public static void openWebpage(String urlString) {
		    try {
		        Desktop.getDesktop().browse(new URL(urlString).toURI());
		    } catch (Exception e) {
		        e.printStackTrace();
		    }
		}
	
	
}

