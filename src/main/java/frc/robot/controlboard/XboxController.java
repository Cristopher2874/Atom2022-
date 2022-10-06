// ✓
package frc.robot.controlboard;

import frc.robot.Constants;
import lib.util.Util;

import edu.wpi.first.wpilibj.Joystick;

public class XboxController {
    private final Joystick mController;

    public enum Side {
        LEFT, RIGHT
    }

    public enum Axis {
        X, Y
    }

    public enum Button {
        A(1), B(2), X(3), Y(4), LB(5), RB(6), BACK(7), START(8), L_JOYSTICK(9), R_JOYSTICK(10);

        public final int id;

        Button(int id) {
            this.id = id;
        }
    }

    XboxController(int port) {
        mController = new Joystick(port);
    }

    double getJoystick(Side side, Axis axis) {
        double deadband = Constants.kJoystickDeadband;

        boolean left = side == Side.LEFT;
        boolean y = axis == Axis.Y;
        // multiplies by -1 if y-axis (inverted normally)
        return Util.handleDeadband((y ? -1 : 1) * mController.getRawAxis((left ? 0 : 4) + (y ? 1 : 0)), deadband);
    }

    double getTrigger(Side side) {
        double deadband = Constants.kJoystickDeadband;
        return Util.handleDeadband(mController.getRawAxis(side == Side.LEFT ? 2 : 3), deadband);
    }

    boolean getButton(Button button) {
        return mController.getRawButton(button.id);
    }

    boolean getButtonReleased(Button button){
        return mController.getRawButtonReleased(button.id);
    }

    int getDPad() {
        return mController.getPOV();
    }

}