package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;

import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class Drive extends SubsystemBase {
  public final TalonSRX mMotor1FrontRight = new TalonSRX(6);
  public final TalonSRX mMotor2BackRight = new TalonSRX(1);
  public final TalonSRX mMotor3FrontLeft = new TalonSRX(4);
  public final TalonSRX mMotor4BackLeft = new TalonSRX(2);
  
  double throttle;
  double turn;
  double leftPwm = 0;
  double rightPwm = 0;
  double leftTrigger = 0;
  double rightTrigger =0;
  boolean rampActive = true;
  double quickmove = 0;
  
  private final XboxController control = new XboxController(0);

  public Drive() {}

  public void mainDrive(){
    throttle = control.getRawAxis(1);
    turn = control.getRawAxis(4);
    rightTrigger = control.getRawAxis(3);
    leftTrigger = control.getRawAxis(2);
    quickmove = rightTrigger - leftTrigger;

    quickmove = Math.abs(quickmove) < 0.15 ? 0 : rightTrigger - leftTrigger;
    rightTrigger = Math.abs(rightTrigger) < 0.15 ? 0 : control.getRawAxis(3);
    leftTrigger = Math.abs(leftTrigger) < 0.15 ? 0 : control.getRawAxis(2);
    turn = Math.abs(turn) < 0.15 ? 0 : control.getRawAxis(4);
    throttle = Math.abs(throttle) < 0.15 ? 0 : control.getRawAxis(1);

    if(throttle>=0){
      leftPwm = (throttle) - turn;
      rightPwm = (throttle) + turn;
    }
    else{
      leftPwm = (throttle) + turn;
      rightPwm = (throttle) - turn;
    }

    if((leftTrigger != 0) || (rightTrigger != 0)){
      mMotor1FrontRight.set(ControlMode.PercentOutput, quickmove);
      mMotor2BackRight.set(ControlMode.PercentOutput, quickmove);
      mMotor3FrontLeft.set(ControlMode.PercentOutput, quickmove);
      mMotor4BackLeft.set(ControlMode.PercentOutput, quickmove);
    }
    else{
      mMotor1FrontRight.set(ControlMode.PercentOutput, rightPwm);
      mMotor2BackRight.set(ControlMode.PercentOutput, rightPwm);
      mMotor3FrontLeft.set(ControlMode.PercentOutput, -leftPwm);
      mMotor4BackLeft.set(ControlMode.PercentOutput, -leftPwm); 
    }
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }

  @Override
  public void simulationPeriodic() {
    // This method will be called once per scheduler run during simulation
  }
}
