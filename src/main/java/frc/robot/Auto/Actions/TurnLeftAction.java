package frc.robot.Auto.Actions;

import frc.robot.subsystems.Drive;

public class TurnLeftAction{
  Drive mAutoDrive = new Drive();
  
  public void finalTurnLeftACtion(){
    mAutoDrive.outMotoresAuto(0.6, 0.6, 0.6, 0.6);
  }
}