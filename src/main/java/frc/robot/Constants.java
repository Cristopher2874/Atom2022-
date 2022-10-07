package frc.robot;

public final class Constants {
    //Drive Subsistem
    public static final double kDriveRampDeltaSpeed = 0.1;
    public static final double kDriveSensitivity = 0.8;
    public static final int kDriveRightFrontId = 6;
    public static final int kDriveLeftFrontId = 4;
    public static final int kDriveRightBackId = 1;
    public static final int kDriveLeftBackId = 2;
    
    //Control Board
    public static final int kDriverControlPort = 0;
    public static final int kOperatorControlPort = 1;
    public static final double kJoystickDeadband = 0.15;

    //Intake Subsistem
    public static final int kIntakeId = 1;
    public static final double kIntakeDemand = 0.9;
    public static final int kIntakeSolenoid1 = 0;
    public static final int kIntakeSolenoid2 = 1;

    //Hopper
    public static final int kHopperId = 2;
    public static final double kHopperHighPosition = 100;
    public static final double kHopperLowPosition = 0;
}
