package frc.robot.controlboard;

import frc.robot.Constants;

public class OperatorControlBoard implements IOperatorControlBoard {

    private static OperatorControlBoard mInstance = null;

    public static OperatorControlBoard getInstance() {
        if (mInstance == null) {
            mInstance = new OperatorControlBoard();
        }

        return mInstance;
    }

    private final XboxController mController;

    private OperatorControlBoard() {
        mController = new XboxController(Constants.kOperatorControlPort);
    }

    @Override
    public boolean getIntake() {
        return mController.getButton(XboxController.Button.B);
    }
    //ADD
    @Override
    public boolean getIntakeInverted() {
        return mController.getButton(XboxController.Button.A);
    }

    @Override
    public boolean getAutoAimMode(){
        return mController.getButtonReleased(XboxController.Button.Y);
    }

    @Override
    public boolean getFeeder() {
        return mController.getTrigger(XboxController.Side.RIGHT) > 0.5;
    }

    @Override
    public boolean getShooter() {
        return mController.getButtonReleased(XboxController.Button.RB);
    }

    @Override
    public boolean getHangerFirstUp(){
        return mController.getButton(XboxController.Button.START) &&  mController.getButton(XboxController.Button.X);
    }

    @Override
    public boolean getHangerDown(){
        return mController.getButton(XboxController.Button.START) &&  mController.getButton(XboxController.Button.A);
    }

    @Override
    public boolean getHangerSequence(){
        return mController.getButton(XboxController.Button.START) &&  mController.getButton(XboxController.Button.BACK);
    }

    @Override
    public double getHoodSpeed() {
        return mController.getJoystick(XboxController.Side.RIGHT, XboxController.Axis.Y);
    }

    @Override
    public double getTurretSpeed() {
        return mController.getJoystick(XboxController.Side.RIGHT, XboxController.Axis.X);
    }

    @Override
    public double getTurretX(){
        return mController.getJoystick(XboxController.Side.LEFT, XboxController.Axis.X);
    }

    @Override
    public double getTurretY(){
        return mController.getJoystick(XboxController.Side.LEFT, XboxController.Axis.Y);
    }

    @Override
    public int getTurretJump(){
        return mController.getDPad();
    }
}