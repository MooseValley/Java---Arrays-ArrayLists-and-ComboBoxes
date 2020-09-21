import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.*;
import java.util.ArrayList;


class Employee
{
   private String name;
   private int age;

   public Employee (String name, int age)
   {
      this.name = name;
      this.age  = age;
   }

   @Override
   public String toString()
   {
      return "Employee name: " + name + ", age: " + age + ".";
   }
}

public class JavaAddArrayAndArrayListToComboBox extends JFrame
{
   private JLabel    arrayLabel                  = new JLabel ("Array Combobox: ");
   private JComboBox<Employee>  arrayComboBox      = new JComboBox<Employee> ();

   private JLabel    arrayListLabel              = new JLabel ("ArrayList Combobox: ");
   private JComboBox<Employee> arrayListComboBox   = new JComboBox<Employee> ();

   private JButton getComboBoxSelectionsButton   = new JButton ("Get ComboBox Selections");
   private JLabel  arrayOutputLabel              = new JLabel ("");
   private JLabel  arrayListOutputLabel          = new JLabel ("");


   private Employee[] employeesArray = {new Employee ("Moose", 21),
                                        new Employee ("Bella", 17),
                                        new Employee ("Teenie Weenie", 8)};

   private ArrayList<Employee> employeesArrayList = new ArrayList<Employee> ();


   public JavaAddArrayAndArrayListToComboBox ()
   {
      JPanel panel1 = new JPanel (new FlowLayout (FlowLayout.CENTER) );
      JPanel panel2 = new JPanel (new FlowLayout (FlowLayout.CENTER) );
      JPanel panel3 = new JPanel (new FlowLayout (FlowLayout.CENTER) );

      // Build a basic GUI

      panel1.add (arrayLabel);
      panel1.add (arrayComboBox);

      panel2.add (arrayListLabel);
      panel2.add (arrayListComboBox);

      panel3.add (getComboBoxSelectionsButton);

      setLayout (new GridLayout (5, 1) );  // R,C
      add (panel1);
      add (panel2);
      add (panel3);
      add (arrayOutputLabel);
      add (arrayListOutputLabel);

      getComboBoxSelectionsButton.addActionListener (event -> getComboBoxSelections() );

/*
      // *** STRINGS

      // Populate the namesArray and arrayComboBox
      String[] namesArray = {"Moose", "Frankie", "Bella", "Teenie Weenie"};

      for (int k = 0; k < namesArray.length; k++)
      {
         arrayComboBox.addItem (namesArray [k]);
      }


      // Populate the namesArrayList and arrayListComboBox
      ArrayList<String> namesArrayList = new ArrayList<String> ();
      namesArrayList.add ("Samuel");
      namesArrayList.add ("Ben");
      namesArrayList.add ("Boogle");

      for (int k = 0; k < namesArrayList.size(); k++)
      {
         arrayListComboBox.addItem (namesArrayList.get(k));
      }
*/

      // *** EMPLOYEE

      //Employee emp = new Employee ("Moose", 21);
      //System.out.println (emp.toString() );


      for (int k = 0; k < employeesArray.length; k++)
      {
         //arrayComboBox.addItem (employeesArray [k].toString() );
         arrayComboBox.addItem (employeesArray [k]  );
      }




      for (int k = 0; k < employeesArray.length; k++)
      {
         employeesArrayList.add (employeesArray [k] );
      }

      for (int k = 0; k < employeesArrayList.size(); k++)
      {
         //arrayListComboBox.addItem (employeesArrayList.get(k).toString() );
         arrayListComboBox.addItem (employeesArrayList.get(k) );
      }


   }

   private void getComboBoxSelections()
   {
      arrayOutputLabel.setText ("Selected arrayComboBox: " +
          arrayComboBox.getSelectedIndex () + ": " +
          arrayComboBox.getSelectedItem () );

      //Employee selectedEmployee = employeesArray [arrayComboBox.getSelectedIndex ()];
      Employee selectedEmployee = (Employee) arrayComboBox.getSelectedItem ();
      System.out.println ("You Selected: " + selectedEmployee.toString() );



      arrayListOutputLabel.setText ("Selected arrayListComboBox: " +
          arrayListComboBox.getSelectedIndex () + ": " +
          arrayListComboBox.getSelectedItem () );

      //Employee selectedEmployee2 = employeesArrayList.get (arrayComboBox.getSelectedIndex () );
      Employee selectedEmployee2 = (Employee) arrayListComboBox.getSelectedItem ();

      System.out.println ("You Selected: " + selectedEmployee2.toString() );

   }


   public static void main (String[] args)
   {
      JavaAddArrayAndArrayListToComboBox app = new JavaAddArrayAndArrayListToComboBox ();

      app.setTitle ("Java - Add Array and ArrayList to ComboBox");
      app.setSize  (600, 300);
      app.setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE);
      app.setVisible (true);
   }
}
