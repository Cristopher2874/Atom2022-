package frc.robot.Auto.Actions;

import frc.robot.subsystems.Hanger;

public class getHangerEncoderAction{
    Hanger mHanger = new Hanger();

    public double getHangerPosition(){
        double position = mHanger.getHangerEncoder();
        return position;
    }
}
