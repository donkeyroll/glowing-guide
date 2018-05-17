import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Minesweeper extends JFrame implements ActionListener {
   
   // variable - they all are global
   int sizeX=10;
   int sizeY=10;
   ImageIcon pic1= new ImageIcon("block1.png");
   ImageIcon pic2= new ImageIcon("block2.png");
   int map[][]=new int[sizeX][sizeY];
   private JButton btn[][] = new JButton[sizeX][sizeY];       // number of buttons - can be changed

   private Container c;
   private JPanel btnPanel = new JPanel();
   private JPanel southPanel = new JPanel();
   private JButton fillRed = new JButton("aaaa");     //can change aaaa   label on action buttons
   private JButton count = new JButton("bbbb");      //can change bbbb   label on action buttons
   private JButton clear = new JButton("Exit");          //label on action buttons


   public FinalNic()   {   //called once at the beginning
      super( "Minesweeper" );

      btnPanel.setLayout(new GridLayout(btn.length,btn[0].length));
	  southPanel.setLayout(new GridLayout(1,3));

      c = getContentPane();
      c.setLayout( new BorderLayout() );

      // create and add buttons
      for (int i = 0; i < btn.length; i++ ) {
	    for (int j = 0; j < btn[0].length; j++ ) {
          btn[i][j] = new JButton("w");
// to remote the spacing between the image and button's borders
btn[i][j].setMargin(new Insets(0, 0, 0, 0));
	  //can change c   label on grid buttons
          btn[i][j].addActionListener( this );
          btnPanel.add(  btn[i][j] );
		}  
      }
	  fillRed.addActionListener( this );
	  southPanel.add(fillRed);
	  count.addActionListener( this );
	  southPanel.add(count);
	  clear.addActionListener( this );
	  southPanel.add(clear);
	  
	  c.add( southPanel, BorderLayout.SOUTH );
	  c.add( btnPanel, BorderLayout.CENTER  );
      setSize( 600, 600 );                          //size of the window, can be changed
      setVisible(true);
	  printMap();
	  updateScreen();
   }

	//insert functions here
    public void updateScreen(){
	 for (int i = 0; i < btn.length; i++ ) {
	    for (int j = 0; j < btn[0].length; j++ ) {
			
			if (map[i][j]==1){
				// to add a different background
              btn[i][j].setBackground(Color.red);	
		      btn[i][j].setIcon(pic1);
			}	  
		    else 
				btn[i][j].setBackground(Color.blue);
		}
	 }	
	}
	//printing map
    public void printMap(){
	    for (int i = 0; i < btn.length; i++ ) {
			for (int j = 0; j < btn[0].length; j++ ) {
				System.out.print("  "+map[i][j]);                    //can change c   label on grid buttons
			} 
			System.out.println();
		}   
    }
    //if action is performed
    public void actionPerformed( ActionEvent e ){ 
        
		JButton b = (JButton)e.getSource();     // now b is the button we clicked on
				   
		if (b.getText().equals("aaaa")){
		     //   code for button aaaa event goes here.....................
		    JOptionPane.showMessageDialog( null, "You clicked on button aaaa.......", "Button click", JOptionPane.INFORMATION_MESSAGE );
		}
		else if (b.getText().equals("bbbb")){
			//   code for button bbbb event goes here.....................
		    JOptionPane.showMessageDialog( null, "You clicked on button bbbb.......", "Also button click", JOptionPane.INFORMATION_MESSAGE );
		}
		else if (b.getText().equals("Exit")){
		   //   code for button Exit goes here.....................
		    System.exit(0);
		}
		else{
				 //   code for grid buttons clicking event goes here.....................
		    if (b.getText().equals("w")){  //if red - set picture
			    b.setIcon(new ImageIcon("myImg.gif"));
		    } 
		    else if (b.getText().equals("c")){  //if gray - change to red
			    b.setText("w");
			    b.setBackground(Color.red);
		   }  
        }		   
    }// end actionPerformed
         


    public static void main( String args[] ) {
         Minesweeper app = new Minesweeper();

        app.addWindowListener(
         new WindowAdapter() {
            public void windowClosing( WindowEvent e )
            {
               System.exit( 0 );
            }
         }
      );
   } 
}

