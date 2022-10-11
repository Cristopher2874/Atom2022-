package frc.robot.Auto.Actions;

import frc.robot.subsystems.Drive;

public class StopAction {
    Drive mDriveAuto = new Drive();

    public void finalStopAction(){
        mDriveAuto.outMotoresAuto(0, 0, 0, 0);
    }
}
