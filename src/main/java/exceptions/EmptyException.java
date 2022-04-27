package exceptions;

import utils.Constants;

public class EmptyException extends Exception {

    String message;
    String errorOut = Constants.EMPTY_NAME_MSG;

    public EmptyException(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return "EmptyException{" +
                "message='" + message + '\'' +
                ", errorOut='" + errorOut + '\'' +
                '}';
    }
}
