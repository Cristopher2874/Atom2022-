package frc.robot.Auto.Actions;

import frc.robot.subsystems.Drive;

public class TurnRightAction{
  Drive mAutoDrive = new Drive();
  
  public void finalTurnRightACtion(){
    mAutoDrive.outMotoresAuto(-0.6, -0.6, -0.6, -0.6);
  }
}