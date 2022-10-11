package frc.robot.Auto.Modes;

import frc.robot.Auto.Actions.GetTimeAction;
import frc.robot.Auto.Actions.MoveBackAction;
import frc.robot.Auto.Actions.StopAction;
import frc.robot.subsystems.Drive;

public class ReverseTimer{
  Drive mAutoDrive = new Drive();
  MoveBackAction mBackAction = new MoveBackAction();
  StopAction mStopAction = new StopAction();
  GetTimeAction mGetTimeAction = new GetTimeAction();
  
  public void finalLineTimer(){
    if(mGetTimeAction.getAbsoluteTimer()-mGetTimeAction.getRelativeTimer()<3){
        mBackAction.finalMoveBackACtion();
    }
    else mStopAction.finalStopAction();
  }
}