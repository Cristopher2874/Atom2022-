package frc.robot.controlboard;

public interface IOperatorControlBoard {
    boolean getIntake();

    //ADD
    boolean getIntakeInverted();

    double getHopperSpeed ();
    
    boolean getShooter();

    boolean getAutoAimMode(); 

    boolean getHangerFirstUp();

    boolean getHangerDown();

    boolean getHangerSequence();

    double getRightYAxis();

    double getTurretSpeed();

    double getTurretX();

    double getTurretY();

    int getTurretJump();
}