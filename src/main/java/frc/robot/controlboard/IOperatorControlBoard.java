package frc.robot.controlboard;

public interface IOperatorControlBoard {
    boolean getIntake();

    //ADD
    boolean getIntakeInverted();

    boolean getFeeder();
    
    boolean getShooter();

    boolean getAutoAimMode(); 

    boolean getHangerFirstUp();

    boolean getHangerDown();

    boolean getHangerSequence();

    double getHoodSpeed();

    double getTurretSpeed();

    double getTurretX();

    double getTurretY();

    int getTurretJump();
}