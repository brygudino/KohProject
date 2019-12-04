public class StudentEmail
{
   public static final String EMAIL_STUB = "@my.email";

   private String name;
   private String id;

   public StudentEmail ()
   {
      name = "";
      id   = "";
   }

   public StudentEmail (String name, String id)
                        throws StudentEmailException
   {
      // Remove elading and trailing spaces, tabs.
      name = name.trim ();
      id   = id.trim ();

      if (name.length () == 0)
      {
         //JOptionPane.showMessageDialog (null, "Error: name cannot be blank.");
         throw new StudentEmailException ("Error: name cannot be blank.");
      }

      else if (id.length () == 0)
      {
         //JOptionPane.showMessageDialog (null, "Error: Id cannot be blank.");
         throw new StudentEmailException ("Error: Id cannot be blank.");
      }

      else
      {
         // All is OK, set class data to the values passed in.
         this.name = name;
         this.id   = id;
      }
   }

   public String getName ()
   {
      return name;
   }

   public String getId ()
   {
      return id;
   }

   public void setName (String name)
   {
      this.name = name;
   }

   public void setId (String id)
   {
      this.id = id;
   }

   @Override
   public String toString ()
   {
      return id + "\t" + name + "\t" + id + EMAIL_STUB;
   }

} // public class StudentEmail