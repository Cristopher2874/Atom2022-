package frc.robot.Auto.Modes;

import frc.robot.Auto.Actions.MoveForwardAction;
import frc.robot.Auto.Actions.StopAction;
import frc.robot.Auto.Actions.TurnLeftAction;
import frc.robot.Auto.Actions.moveHangerAction;
import frc.robot.subsystems.Drive;
import frc.robot.subsystems.Hanger;

public class HangerUp{
  Hanger mHanger = new Hanger();
  moveHangerAction mHangerAction = new moveHangerAction();
  Drive mAutoDrive = new Drive();
  MoveForwardAction mForwardAction = new MoveForwardAction();
  StopAction mStopAction = new StopAction();
  TurnLeftAction mTurnLeft = new TurnLeftAction();
  double drivePosition = 0;
    
  public void finalHangerUp(){
    double drivePosition = mAutoDrive.getDriveEncoder();
    mHangerAction.getMoveHanger(3000,0.5);
    if(drivePosition < 10){
      mForwardAction.finalMoveForwardACtion();
    }else if(drivePosition >= 10){
      mTurnLeft.finalTurnLeftACtion();
    }else if(drivePosition >= 15){
      mForwardAction.finalMoveForwardACtion();
    }else if(drivePosition > 25){
      mStopAction.finalStopAction();
    }
    mHangerAction.getMoveHanger(1000, 0.5);
  }
}