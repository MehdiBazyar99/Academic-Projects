package snake;

import java.awt.EventQueue;
import javax.swing.JFrame;

public class Snake extends JFrame {
    
public static JFrame ex;

    public Snake(int i) {     
        initUI(i);
    }
    
    private void initUI(int i) {
        switch(i)
        {
            case 1: add(new Board1() );
            break;    
            case 2: add(new Board2() );
            break; 
            case 3: add(new Board3() );   
            break;       
            case 4: add(new Board3_2() );         
            break;       
            case 5: add(new Board4() );
            break;  
            case 6: add(new Board5() ); 
            break;  
            case 7: add(new Board6() ); 
            break;
        }
        setResizable(false);
        pack();
        setTitle("Snake");
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    

    public static void Start(int i) {
        
        EventQueue.invokeLater(() -> {
            ex = new Snake(i);
            ex.setVisible(true);
        });
    }
    public static void Start() {
        try{
     ex.dispose();   
    }
        catch(Exception e)
        {
        System.out.println(e);
        }
    }
    }
