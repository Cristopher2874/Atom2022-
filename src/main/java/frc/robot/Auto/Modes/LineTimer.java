package frc.robot.Auto.Modes;

import frc.robot.Auto.Actions.GetTimeAction;
import frc.robot.Auto.Actions.MoveForwardAction;
import frc.robot.Auto.Actions.StopAction;

public class LineTimer{
  MoveForwardAction mForwardAction = new MoveForwardAction();
  StopAction mStopAction = new StopAction();
  GetTimeAction mGetTimeAction = new GetTimeAction();
  
  public void finalLineTimer(){
    if(mGetTimeAction.getAbsoluteTimer()-mGetTimeAction.getRelativeTimer()<3){
        mForwardAction.finalMoveForwardACtion();
      }
    else mStopAction.finalStopAction();
  }
}