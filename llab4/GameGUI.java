package llab4;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;


public class GameGUI extends JFrame{
    int x = 0, y = 0;
    private JButton ACMilan = new JButton("AC Milan");              //прописываю кнопки и строки
    private JButton RealMadrid = new JButton("Real Madrid");
    private JLabel Result = new JLabel("Result: 0 X 0");
    private JLabel LastScorer = new JLabel("Last Scorer: N/A");
    private Label Winner = new Label("Winner: DRAW");

    public GameGUI(){
        super("GAME");                                              //располагаю их в окне
        this.setBounds(200, 200, 400, 130);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Container container = this.getContentPane();
        container.setLayout(new GridLayout(3, 2, 2, 2));
        container.add(ACMilan);
        container.add(RealMadrid);
        container.add(LastScorer);
        container.add(Result);
        container.add(Winner);
        ButtonGroup buttonGroup = new ButtonGroup();
        ACMilan.addActionListener(new ButtonOption1());
        RealMadrid.addActionListener(new ButtonOption2());
    }
                                                                        //изменения при нажатии кнопок
    class ButtonOption1 implements ActionListener {
        public void actionPerformed(ActionEvent Event) {
            x++;
            LastScorer.setText("Last Scorer: AC Milan");
            Result.setText("Result: " + String.valueOf(x) + " X " + String.valueOf(y));
            Winner(x,y);
        }
    }

    class ButtonOption2 implements ActionListener {
        public void actionPerformed(ActionEvent Event) {
            y++;
            LastScorer.setText("Last Scorer: Real Madrid");
            Result.setText("Result: " + String.valueOf(x) + " X " + String.valueOf(y));
            Winner(x,y);
        }
    }

    public void Winner (int x,int y) {
        if (x>y) {
            Winner.setText("Winner: AC Milan");
        }
        if (x<y) {
            Winner.setText("Winner: Real Madrid");
        }
        if (x==y) {
            Winner.setText("Winner: DRAW");
        }
    }
}
