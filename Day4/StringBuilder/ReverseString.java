public class ReverseString{
    public static void main(String[] args) {
        //Input String
        String input = "StringBuilder";
        //Call the method to reverse the string
        String reverse = reverse(input);
        //Print reverse String
        System.out.println(reverse);
    }
    public static String reverse(String str){
        //String BUilder Object
        StringBuilder sb = new StringBuilder(str);
        //reverse the string using stringbuilder reverse Method
        sb.reverse();
        // Convert the StringBuilder back to a String and return it
        return sb.toString();
    }
}