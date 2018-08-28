import java.awt.*;
import java.awt.event.*;
 
import javax.swing.*;
 
import javax.swing.JOptionPane;

@SuppressWarnings("serial")
public class LogSign extends JFrame {
 
   public LogSign() {
 
        setTitle("MyStats - Ekran logowania");
        setSize(600,300);
        setResizable(false);
        setLocationRelativeTo(null);
        initComponents();
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        
        
  }
 
           JPanel panel = new JPanel();
 
    public void initComponents()
    {
 
          JButton  PrzyciskZamknij = new JButton ("Zamknij");
          JButton  PrzyciskZaloguj = new JButton ("Zaloguj");
          JButton  PrzyciskZarejestruj = new JButton ("Zarejestruj");
          JLabel  Login= new JLabel("Login: ");
          JLabel  Haslo = new JLabel("Has³o: ");
          JTextField LoginUzytkownika = new JTextField(6);
          JPasswordField HasloUzytkownika = new JPasswordField(6);
          PrzyciskZamknij.setSize(90, 30);
          PrzyciskZaloguj.setSize(90, 30);
          PrzyciskZarejestruj.setSize(110, 30);
          Login.setSize(100,30);
          Haslo.setSize(100,30);
          LoginUzytkownika.setSize(100,30);
          HasloUzytkownika.setSize(100,30);
          PrzyciskZamknij.setLocation(getWidth()-190,getHeight()-100);
          PrzyciskZaloguj.setLocation(getWidth()-310,getHeight()-100);
          PrzyciskZarejestruj.setLocation(getWidth()-430,getHeight()-100);
          Login.setLocation(getWidth()-300,getHeight()-220);
          Haslo.setLocation(getWidth()-300,getHeight()-180);
          LoginUzytkownika.setLocation(getWidth()-250,getHeight()-220);
          HasloUzytkownika.setLocation(getWidth()-250,getHeight()-180);
          panel.setLayout(null);
          panel.add(PrzyciskZamknij);
          panel.add(PrzyciskZaloguj);
          panel.add(PrzyciskZarejestruj);
          panel.add(Login);
          panel.add(Haslo);
          panel.add(LoginUzytkownika);
          panel.add(HasloUzytkownika);
          PrzyciskZamknij.setToolTipText("Zamknij Program.");
          PrzyciskZaloguj.setToolTipText("Zaloguj siê.");
          PrzyciskZarejestruj.setToolTipText("Zarejestruj siê.");
          LoginUzytkownika.setToolTipText("Podaj swój login.");
          HasloUzytkownika.setToolTipText("Podaj swoje has³o.");
          this.getContentPane().add(panel);
          PrzyciskZamknij.addActionListener(new ButtonZamknij());
          
          Write W=new Write(); // zeby miec caly czas ten sam obiekt i ten sam plik json, a w nim 
          // stala liste user'ow
          Read R=new Read();
          
          //Z klas¹ anonimow¹:
          PrzyciskZaloguj.addActionListener(new ActionListener() 
          {
        	  
              @Override
              public void actionPerformed(ActionEvent e) 
              {
                  String user = LoginUzytkownika.getText();
                  String pass = HasloUzytkownika.getText();
                  W.writeNewOne(user, pass);
               // + jsonowe sprawdzanie
   
                  if(R.readAndCheck(user, pass))
                  {
                	//daj znac, ze przeszlo
                	  JOptionPane.showMessageDialog(null, "Zalogowano");//System.exit(0);
                  }               	              	  
                  else
                  {
                  	//daj znac, ze przeszlo
                  	  JOptionPane.showMessageDialog(null, "Nieprawid³owy login lub haslo");//System.exit(0);  
                  }
              }            
            });
          
			PrzyciskZarejestruj.addActionListener(new ActionListener() 
			{
        	  
              @Override
              public void actionPerformed(ActionEvent e) 
              {
                  String user = LoginUzytkownika.getText();
                  String pass = HasloUzytkownika.getText();
                  W.writeNewOne(user, pass);  
                  
                  if(R.readAndCheck(user, pass))
                  {
                	//daj znac, ze przeszlo
                	  JOptionPane.showMessageDialog(null, "Taki uzytkownik juz istnieje");//System.exit(0);  
                  }               	              	  
                  else
                  {
                  	//daj znac, ze przeszlo
                	  JOptionPane.showMessageDialog(null, "Zarejestrowano nowego uzytkownika");//System.exit(0);  
                  }
              }
   
            });
 
    }
 
     //akcja przy przycisku zamknij   
    private class ButtonZamknij implements ActionListener
    {
        public void actionPerformed(ActionEvent e)
        {
            System.exit(0);
        }
    }
 
    
 
    public static void main(String[] args) {
 
       EventQueue.invokeLater(new Runnable() {
         public void run() {
             LogSign EkranLogowania = new LogSign();
            EkranLogowania.setVisible(true);
            Toolkit t = Toolkit.getDefaultToolkit();
            Dimension d = t.getScreenSize();
            EkranLogowania.setLocation((d.width/4), (d.height/4));
 
            // EkranLogowania.setBounds(d.width/4, d.height/4,500 ,300);
            
            
         } 
        });
    }
}