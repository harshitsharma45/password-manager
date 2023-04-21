import java.awt.*;
import javax.swing.*;
import java.io.*;
import java.util.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.border.LineBorder;
class login extends JFrame
{
    public static Dimension size = Toolkit.getDefaultToolkit().getScreenSize();
    public static int windowwidth = (int)size.getWidth();
    public static int windowheight = (int)size.getHeight();
    login()
    {
        System.out.println(windowwidth+""+windowheight);
        setLocation(windowwidth/2-400,windowheight/2-200);
        setSize(800,400);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setLayout(null);

        JButton home=new JButton("home");
        home.setBounds(windowwidth-140,20,100,30);
        home.setBorderPainted(false);
        home.setFocusPainted(false);
        home.setBackground(new Color(0xFF5C5C));
        home.setForeground(new Color(0xffffff));
        home.setFont(new Font("Arial",Font.BOLD,15));
        add(home);
        home.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                home.setBackground(new Color(0xFF0C0C));

            }

            @Override
            public void mouseExited(MouseEvent e) {
                home.setBackground(new Color(0xFF5C5C));

            }
        });
        home.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
               // new home();
                dispose();
            }
        });

        JLabel user=new JLabel("username");
        user.setBounds(windowwidth/2-100,200,200,30);
        user.setFont(new Font("Arial",Font.BOLD,15));
        user.setForeground(new Color(0xFF5C5C));
        add(user);

        JTextField ui=new JTextField();
        ui.setBounds(windowwidth/2-100,230,250,40);
        ui.setFont(new Font("Arial",Font.PLAIN,15));
        ui.setForeground(new Color(0xFF5C5C));
        ui.setOpaque(false);
        ui.setBorder(new LineBorder(new Color(0xFF5C5C),2));
        add(ui);

        ui.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                ui.setBorder(new LineBorder(new Color(0xFF0C0C),2));
            }
        });


        JLabel pass =new JLabel("password");
        pass.setBounds(windowwidth/2-100,280,200,30);
        pass.setFont(new Font("Arial",Font.BOLD,15));
        pass.setForeground(new Color(0xFF5C5C));
        add(pass);


        JTextField i=new JPasswordField();
        ((JPasswordField) i).setEchoChar('*');
        i.setBounds(windowwidth/2-100,310,250,40);
        i.setFont(new Font("Arial",Font.PLAIN,15));
        i.setForeground(new Color(0xFF5C5C));
        i.setOpaque(false);
        i.setBorder(new LineBorder(new Color(0xFF5C5C),2));
        add(i);

        i.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                i.setBorder(new LineBorder(new Color(0xFF0C0C),2));
            }
        });


        JButton lg=new JButton("login");
        lg.setBounds(windowwidth/2-100,380,250,30);
        lg.setBackground(new Color(0xFF0C0C));
        lg.setForeground(new Color(0xFFFFFF));
        lg.setFont(new Font("Arial",Font.BOLD,18));
        lg.setFocusable(false);
        lg.setBorderPainted(false);
        add(lg);

        lg.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                File file=new File("C:\\Users\\Jaidev\\Pictures\\walpapers\\database.txt");
                Scanner sc = null;
                try {
                    sc = new Scanner(file);
                } catch (FileNotFoundException ex) {
                    throw new RuntimeException(ex);
                }

                // we just need to use \\Z as delimiter
                sc.useDelimiter("\\Z");
                String info=sc.next();
                char infonew[]=info.toCharArray();
                int en=0,un=0;
                int count=0;
                for(int i=1;i<infonew.length-2;i++)
                {
                    if(infonew[i]==',')
                    {
                        count++;
                        if(count==1)
                        {
                            en=i;
                        }
                        if(count==2)
                        {
                            un=i;
                            break;
                        }
                    }
                }
                String emailentered="";
                for(int i=1;i<en;i++)
                {
                    emailentered+=infonew[i];
                }
                String usernameentered="";
                for(int i=en+1;i<un;i++)
                {
                    usernameentered+=infonew[i];
                }
                String passwordentered="";
                for(int i=un+1;i<infonew.length-2;i++)
                {
                    passwordentered+=infonew[i];
                }
                System.out.println(emailentered+","+usernameentered+","+passwordentered);
                if(ui.getText().equals("jashwanth") && i.getText().equals("123"))
                {
                    new PasswordManagerGUI();
                    dispose();
                }
                else
                {
                    JOptionPane.showMessageDialog(null,"wrong username or password");
                }
            }
        });




        ImageIcon img =new ImageIcon("S:\\java\\pwdma10.jpg");

        JLabel bg=new JLabel(img);
        bg.setBounds(0,0,windowwidth,windowheight);
        add(bg);

        setVisible(true);
    }
public static void main(String[] args){new login();}
}
