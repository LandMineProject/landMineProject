package com.mrjaffesclass.apcs.mvc.template;

import com.mrjaffesclass.apcs.messenger.*;
import java.util.Random;
/**
 * The model represents the data that the app uses.
 * @author Roger Jaffe
 * @version 1.0
 */
public class Model implements MessageHandler {
  private final Messenger mvcMessaging;

  // Model's data variables
  private int score;
  private int lives;
  private int[] mines = randomizeMines();
  
  public Model(Messenger messages) {
    mvcMessaging = messages;
  }
  public void init() {
    mvcMessaging.subscribe("view:changeButton", this);
    setScore(0);
    setLives(3); 
  }
  
  @Override
  public void messageHandler(String messageName, Object messagePayload) {
    if (messagePayload != null) {
      System.out.println("MSG: received by model: "+messageName+" | "+messagePayload.toString());
    } else {
      System.out.println("MSG: received by model: "+messageName+" | No data sent");
    }
    MessagePayload payload = (MessagePayload)messagePayload;
    int number = payload.getNumber();
    boolean mine = payload.getBoolean();
    
    
      if(mine == true)
      {
          if(number == mines[0] || number == mines[1] || number == mines[2] || number == mines[3] || number == mines[4] || number == mines[5] || number == mines[6] || number == mines[7] || number == mines[8] || number == mines[9]  )
          {
              setLives(getLives() - 1);
              mvcMessaging.notify("model:BOMB!", number, true);    
          }
          else 
          {
          setScore(getScore() + 1);
          mvcMessaging.notify("model:safe", number, true);
          
          }
      }    
     }
  public int getScore() {
    return score;
  }
  public void setScore(int v) {
   lives = v;
    if(score >= 0)
    {
    mvcMessaging.notify("model:scorechanged", score, true);
    }
    
  }
  public int getLives() {
    return lives;
  }
  public void setLives(int v) {
    lives = v;
    if(score >= 0)
    {
    mvcMessaging.notify("model:liveschanged", lives, true);
    }
  }
  public  int[] randomizeMines()
  {
      int[] a = new int[10];
      for ( int i = 0; i < 10; i++) 
      {
        a[i] = (int)(Math.random()*63);//note, this generates numbers from [0,9]
        for (int j = 0; j < i; j++) 
        {
         if (a[i] == a[j]) 
         {
           i--; 
           break;
         }
        }  
      }
      return a;
  } 
}

