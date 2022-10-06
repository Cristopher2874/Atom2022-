package frc.robot.controlboard;


// Clase para juntar las clases de los controlles
public class ControlBoard implements IControlBoard {
    private static ControlBoard mInstance = null;

    public static ControlBoard getInstance() {
        if (mInstance == null) {
            mInstance = new ControlBoard();
        }

        return mInstance;
    }

    private final IDriverControlBoard mDriverControlBoard;
    private final IOperatorControlBoard mOperatorControlBoard;

    private ControlBoard() {
        mDriverControlBoard =  DriverControlBoard.getInstance();
        mOperatorControlBoard = OperatorControlBoard.getInstance();
    }

    @Override
    public double getVelocityX() {
        return mDriverControlBoard.getVelocityX();
    }

    @Override
    public double getVelocityY() {
        return mDriverControlBoard.getVelocityY();
    }

    @Override
    public double getDirectThrottle() {
        return mDriverControlBoard.getDirectThrottle();
    }

    @Override
    public double getTurn() {
        return mDriverControlBoard.getTurn();
    }

    @Override
    public boolean getInverted() {
        return mDriverControlBoard.getInverted();
    }

    @Override
    public boolean getIntake() {
        return mOperatorControlBoard.getIntake();
    }
    //ADD
    @Override
    public boolean getIntakeInverted() {
        return mOperatorControlBoard.getIntakeInverted();
    }

    @Override
    public boolean getAutoAimMode(){
        return mOperatorControlBoard.getAutoAimMode();
    }

    @Override
    public boolean getFeeder(){
        return mOperatorControlBoard.getFeeder();
    }

    @Override
    public boolean getShooter() {
        return mOperatorControlBoard.getShooter();
    }

    @Override
    public boolean getHangerFirstUp(){
        return mOperatorControlBoard.getHangerFirstUp();
    }

    @Override
    public boolean getHangerDown(){
        return mOperatorControlBoard.getHangerDown();   
    }

    @Override
    public boolean getHangerSequence(){
        return mOperatorControlBoard.getHangerSequence();
    }

    @Override
    public double getHoodSpeed() {
        return mOperatorControlBoard.getHoodSpeed();
    }

    @Override
    public double getTurretSpeed() {
        return mOperatorControlBoard.getTurretSpeed();
    }

    @Override
    public double getTurretX() {
        return mOperatorControlBoard.getTurretX();
    }

    @Override
    public double getTurretY() {
        return mOperatorControlBoard.getTurretY();
    }

    @Override
    public int getTurretJump() {
        return mOperatorControlBoard.getTurretJump();
    }
}