package frc.robot;

public final class Constants {
    //Drive Subsistem
    public static final double kDriveRampDeltaSpeed = 0.1;
    public static final double kDriveSensitivity = 0.8;
    public static final int kDriveRightFrontId = 8;
    public static final int kDriveLeftFrontId = 9;
    public static final int kDriveRightBackId = 10;
    public static final int kDriveLeftBackId = 11;
    
    //Control Board
    public static final int kDriverControlPort = 0;
    public static final int kOperatorControlPort = 1;
    public static final double kJoystickDeadband = 0.15;

    //Intake Subsistem
    public static final int kIntakeId = 5;
    public static final double kIntakeDemand = 0.9;
    public static final int kIntakeSolenoidId1 = 0;
    public static final int kIntakeSolenoidId2 = 1;

    //Hopper
    public static final int kHopperId = 12;

    //Shooter
    public static final int kShooter1Id = 13; //checar que ids van a ser
    public static final double kShooterDemand = 0.9; //checar

    //Hanger
    public static final int kHangerId = 14;
    public static final double kHangerHighPosition = 100;
    public static final double kHangerLowPosition = 0;
}
