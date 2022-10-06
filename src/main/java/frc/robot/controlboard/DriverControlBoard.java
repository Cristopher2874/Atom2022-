// ✓
package frc.robot.controlboard;

import frc.robot.Constants;

public class DriverControlBoard implements IDriverControlBoard {
    private static DriverControlBoard mInstance = null;

    public static DriverControlBoard getInstance() {
        if (mInstance == null) {
            mInstance = new DriverControlBoard();
        }

        return mInstance;
    }

    private final XboxController mController;

    private DriverControlBoard() {
        mController = new XboxController(Constants.kDriverControlPort);
    }

    @Override
    public double getVelocityX() {
        return mController.getJoystick(XboxController.Side.LEFT, XboxController.Axis.X);
    }

    @Override
    public double getVelocityY() {
        return mController.getJoystick(XboxController.Side.LEFT, XboxController.Axis.Y);
    }

    @Override
    public double getDirectThrottle() {
        return mController.getTrigger(XboxController.Side.RIGHT) - mController.getTrigger(XboxController.Side.LEFT);
    }

    @Override
    public double getTurn() {
        return -mController.getJoystick(XboxController.Side.RIGHT, XboxController.Axis.X);
    }

    @Override
    public boolean getInverted() {
        return mController.getButtonReleased(XboxController.Button.Y);
    }

    @Override
    public boolean getIntake() {
        return mController.getButton(XboxController.Button.RB);
    }
}