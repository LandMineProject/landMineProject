package com.mrjaffesclass.apcs.mvc.template;

/**
 * This is the message payload class.  Instantiate this class when sending
 * field / value message data for the up/down buttons
 * 
 * @author Roger Jaffe
 * @version 1.0
 */
public class MessagePayload {
  
  private final int field;
  private final boolean direction;
  
  /**
   * Class constructor
   * @param _field Text field 1 or 2
   * @param _direction Direction (Constants.UP or Constants.DOWN)
   */
  public MessagePayload(int _field, boolean _direction) {
    field = _field;
    direction = _direction;
  }
  
  /**
   * Getter method for the direction
   * @return Field value
   */
  public boolean getBoolean() {
    return direction;
  }
  
  /**
   * Getter method for the 
   * @return 
   */
  public int getNumber() {
    return field;
  }
  
}
