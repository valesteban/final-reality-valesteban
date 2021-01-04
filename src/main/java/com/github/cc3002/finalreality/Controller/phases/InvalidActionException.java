package com.github.cc3002.finalreality.Controller.phases;
/**
 * A class that creates an Exception when we use a method for the phases where we don´t have to.
 */
public class InvalidActionException extends Exception{
    /**
     * Creates a new InvalidActionException.
     *
     * @param message
     *    the message that we will see when this exception happen.
     */
    public InvalidActionException(String message){
        super(message);
    }
}
