import java.util.ArrayList;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class MyFrame extends JFrame{
    private ArrayList<String> itemList;
    private DefaultListModel<String> listModel;
    private JList<String> itemListUI;
    private JTextField inputField;

    public MyFrame() {
        itemList = new ArrayList<>();
        listModel = new DefaultListModel<>();
        itemListUI = new JList<>(listModel);
        inputField = new JTextField(25);

        this.setTitle("TO DO LIST");
        this.setPreferredSize(new Dimension(500, 500));

        //Sets image icon
        ImageIcon image = new ImageIcon("pencil.png");
        this.setIconImage(image.getImage());

        //Changes gui of itemListUI
        itemListUI.setBackground(new Color(173, 216, 230));
        itemListUI.setFont(new Font("LiSong Pro", Font.PLAIN, 30));

        //Adds a button that when pressed, will add whatever is typed to the ArrayList, which is shown to the user at the top
        JButton addButton = new JButton("Add");
        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String input = inputField.getText();
                itemList.add(input);
                listModel.addElement("• " + input);
                inputField.setText("");
            }
        });

        //Adds a delete button that when pressed, will delete whatever item on the list was clicked
        JButton deleteButton = new JButton("Delete");
        deleteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int selectedIndex = itemListUI.getSelectedIndex();
                if (selectedIndex != -1) {
                    itemList.remove(selectedIndex);
                    listModel.remove(selectedIndex);
                }
            }
        });

        //Formats the UI to show list at top and add text field and buttons to the bottom
        setLayout(new BorderLayout());
        add(new JScrollPane(itemListUI), BorderLayout.CENTER);

        //Controls UI of the textfield and two buttons
        JPanel inputPanel = new JPanel();
        inputPanel.setBackground(new Color(148, 148, 148));
        inputPanel.add(inputField);
        inputPanel.add(addButton);
        inputPanel.add(deleteButton);
        add(inputPanel, BorderLayout.SOUTH);

        //Will close when 'X' is pressed and make fram visible on run
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        pack();
        setVisible(true);

    }

}

