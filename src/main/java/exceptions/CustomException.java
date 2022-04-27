package exceptions;

public class CustomException extends Exception {

    String message;
    public CustomException(String message) {
       this.message = message;
    }
    @Override
    public String toString() {
        return "CustomException with message=" + message;
    }
}
