package frc.robot.Auto.Actions;

import frc.robot.subsystems.Drive;
import frc.robot.subsystems.Hanger;

public class MoveForwardAction{
  Drive mAutoDrive = new Drive();
  Hanger mHangerAuto = new Hanger();
  
  public void finalMoveForwardACtion(){
    mAutoDrive.outMotoresAuto(0.3, 0.3, -0.3, -0.3);
    mAutoDrive.getOdometry();
    mHangerAuto.getHangerEncoder();
  }
}