public class CustomerEmail
{
   public static final String EMAIL_STUB = "@my.email";

   private String name;
   private String id;

   public CustomerEmail ()
   {
      name = "";
      id   = "";
   }

   public CustomerEmail (String name, String id)
                        throws CustomerEmailException
   {
      // Remove before and after spaces, tabs.
      name = name.trim ();
      id   = id.trim ();

      if (name.length () == 0)
      {
         //(null, "Error: name cannot be blank.");
         throw new CustomerEmailException ("Error: name cannot be blank.");
      }

      else if (id.length () == 0)
      {
         // (null, "Error: Id cannot be blank.")
         throw new CustomerEmailException ("Error: Id cannot be blank.");
      }

      else
      {
         // If everything is okay, set class data to the values passed in.
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

} // public class CustomerEmail
