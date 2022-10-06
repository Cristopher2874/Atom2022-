// ✓
package frc.robot.controlboard;

public interface IDriverControlBoard {
    double getVelocityX();

    double getVelocityY();

    double getDirectThrottle();

    double getTurn();

    boolean getInverted();

    boolean getIntake();
}