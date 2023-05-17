import javax.swing.SwingUtilities;

public class App {
    public static void main(String[] args) throws Exception {
       
        //Runs frame
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new MyFrame();
            }
        });

    }
}
