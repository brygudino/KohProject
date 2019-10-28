public class CustomerEmailException extends Exception
{

   public CustomerEmailException ()
   {
      super ();
   }

   public CustomerEmailException (String message)
   {
      super (message);
   }

   public CustomerEmailException (Throwable cause)
   {
      super (cause);
   }

   public CustomerEmailException (String message, Throwable cause)
   {
      super (message, cause);
   }
}
