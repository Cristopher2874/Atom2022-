package frc.robot.Auto.Actions;

import frc.robot.subsystems.Hanger;

public class moveHangerAction{
    Hanger mHanger = new Hanger();

    public void getMoveHanger(double posicion, double speed){
        double position = mHanger.getHangerEncoder();
        if(posicion > (position + 50) || posicion > (position - 50)){
            mHanger.hopperAction(-speed);
        }else if(posicion < (position + 50) || posicion < (position - 50)){
            mHanger.hopperAction(-speed);
        }else{
            mHanger.hopperAction(0);
        }
    }
}
