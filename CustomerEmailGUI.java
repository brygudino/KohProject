import javax.swing.*;
import java.awt.*;
import java.util.LinkedList;

public class CustomerEmailGUI extends JFrame
{
   // Constants:

   // GUI Componet:
   JTextArea  customerTextArea   = new JTextArea ();

   JLabel     idLabel           = new JLabel     ("ID: ");
   JTextField idTextField       = new JTextField (10);
   JLabel     nameLabel         = new JLabel     ("Name: ");
   JTextField nameTextField     = new JTextField (10);

   JButton    addButton         = new JButton ("Add");
   JButton    deleteButton      = new JButton ("Delete");
   JButton    displayAllButton  = new JButton ("Display All");
   JButton    exitButton        = new JButton ("Exit");

   // Class Instance Data:
   private LinkedList<CustomerEmail> CustomerLinkedList = new LinkedList<CustomerEmail> ();

   public CustomerEmailGUI ()
   {
      JPanel flow1Panel = new JPanel (new FlowLayout (FlowLayout.CENTER));
      JPanel flow2Panel = new JPanel (new FlowLayout (FlowLayout.CENTER));
      JPanel gridPanel  = new JPanel (new GridLayout (2, 1));

      customerTextArea.setEditable (false);

      flow1Panel.add (idLabel);
      flow1Panel.add (idTextField);
      flow1Panel.add (nameLabel);
      flow1Panel.add (nameTextField);

      flow2Panel.add (addButton);
      flow2Panel.add (deleteButton);
      flow2Panel.add (displayAllButton);
      flow2Panel.add (exitButton);

      gridPanel.add (flow1Panel);
      gridPanel.add (flow2Panel);

      add (customerTextArea, BorderLayout.CENTER);
      add (gridPanel,       BorderLayout.SOUTH);


      addButton.addActionListener        (event -> addCustomer ());
      displayAllButton.addActionListener (event -> displayAll ());
      exitButton.addActionListener       (event -> exitApplication ());
      deleteButton.addActionListener     (event -> deleteCustomer ());
   }

   private boolean isCustomerIdInLinkedList (String idStr)
   {
      boolean inList = false;

      for (CustomerEmail cust : CustomerLinkedList)
      {
         if (cust.getId ().compareToIgnoreCase (idStr) == 0) //stud
         {
            inList = true;
         }
      }

      return inList;
   }

   private void addCustomer ()
   {
      if (isCustomerIdInLinkedList (idTextField.getText()) == true)
      {
         JOptionPane.showMessageDialog (null, "Error: Customer ID is already in the database.");
      }
      else
      {
         try
         {
        	 CustomerEmail stud = new CustomerEmail (nameTextField.getText(),
                                                  idTextField.getText());

        	 CustomerLinkedList.add (stud);

            displayAll ();

            nameTextField.setText("");
            idTextField.setText("");


         }
         catch (CustomerEmailException error)
         {
            JOptionPane.showMessageDialog (null, error.toString ());
            // myLabel.setText (error.toString ());


         }

      }
   }

   private void deleteCustomer ()
   {
      if (CustomerLinkedList.size() == 0)
      {
         JOptionPane.showMessageDialog (null, "Error: Database is empty.");
      }
      else if (isCustomerIdInLinkedList (idTextField.getText()) == false)
      {
         JOptionPane.showMessageDialog (null, "Error: student ID is not in the database.");
      }
      else
      {
         for (int s = 0; s < CustomerLinkedList.size(); s++)
         {
            String currId = CustomerLinkedList.get (s).getId ();

            if (currId.compareToIgnoreCase (idTextField.getText()) == 0)
            {
            	CustomerLinkedList.remove (s);
            }
         }

         displayAll ();

         nameTextField.setText("");
         idTextField.setText("");
      }
   }

   private void displayAll ()
   {
	   customerTextArea.setText ("");

      for (CustomerEmail cust : CustomerLinkedList) //stud
      {
    	  customerTextArea.append (cust + "\n"); //std
      }
   }

   private void exitApplication ()
   {
      System.exit (0); // All is OK.
   }

   public static void main (String[] args)
   {
	   CustomerEmailGUI app = new CustomerEmailGUI ();
      app.setVisible  (true);
      app.setSize     (500, 310);
      app.setLocation (200, 100);
      app.setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE);
   }
}
