import org.json.simple.JSONObject;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileWriter;
import java.io.Writer;
import java.awt.Color;
import javax.swing.ImageIcon;
class B extends JFrame implements ActionListener{
    
JLabel jl1, jl2, jl3, jl4, jl5;
JTextField roll_no, name, batch, section;
JRadioButton jb1, jb2;
JButton b1, b2;
ImageIcon i1; 
public B(){
        
                       setSize(420, 420);
                       setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                       setLayout(new FlowLayout());// search it
                       getContentPane().setBackground(Color.LIGHT_GRAY);
                       setTitle("Student Registration form");
            i1= new ImageIcon("image.png");
                       setIconImage(i1.getImage());
        jb1 = new JRadioButton("Male: ");
        jb2 = new JRadioButton("Female: ");
      
        roll_no = new JTextField(30);
        name = new JTextField(30);
        batch = new JTextField(30);
        section = new JTextField(30);

        jl1 = new JLabel("Name: ");
        jl2 = new JLabel("Roll No:");
        jl3 = new JLabel("Batch: ");
        jl4 = new JLabel("Section: ");
        jl5 = new JLabel("Gender: ");
        b1 = new JButton("Save");
        b2 = new JButton("Print");
        

        add(jl1);   add(name);
        add(jl2);   add(roll_no);       System.out.println();
        add(jl3);   add(batch);         System.out.println();
        add(jl4);   add(section);       System.out.println();

        add(jb1);    add(jb2);
        add(b1);     add(b2);
        
        ButtonGroup bg = new ButtonGroup();
        bg.add(jb1);      bg.add(jb2);

        b1.addActionListener(this);
        b2.addActionListener(this);
        setVisible(true);
    }
    @SuppressWarnings("unchecked")
    @Override
    public void actionPerformed(ActionEvent e) {
        Writer writer;
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("First_Name", name.getText());
        jsonObject.put("Roll Number: ", roll_no.getText());
        jsonObject.put("Batch: ", batch.getText());
        jsonObject.put("Section: ", section.getText());
        if(jb1.isSelected()) {
            jsonObject.put("Gender: ", jb1.getText());
        } else {
            jsonObject.put("Gender: ", jb2.getText());
        }

        if(e.getSource()==b1) {
            try {
                writer = new FileWriter("Task.json");
                writer.write(jsonObject.toJSONString());
                try{
                    if(jb1.isSelected()) {
                        jsonObject.put("Gender: ", jb1.getText());
                    }
                    else {
                        jsonObject.put("Gender: ", jb2.getText());
                    }
                }
                catch (Exception ie){
                    ie.printStackTrace();
                }

                writer.close();
            } catch (Exception ie) {
                ie.printStackTrace();
            }
        }
        else if(e.getSource()==b2) {
            System.out.println(name.getText());
            System.out.println(roll_no.getText());
            System.out.println(batch.getText());
            System.out.println(section.getText());
            if (jb1.isSelected())
                System.out.println("Male");
            else
                System.out.println("Female");
        }
    }
}

public class labtask11 {
    
    public static void main(String[] args) {

        new B();

    }
}