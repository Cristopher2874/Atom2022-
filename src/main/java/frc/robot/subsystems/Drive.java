// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;

import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class Drive extends SubsystemBase {
  /** Creates a new ExampleSubsystem. */

    private final XboxController control = new XboxController(0);
    
    public final TalonSRX mMotor1FrontRight = new TalonSRX(6);
    public final TalonSRX mMotor2BackRight = new TalonSRX(1);
    public final TalonSRX mMotor3FrontLeft = new TalonSRX(4);
    public final TalonSRX mMotor4BackLeft = new TalonSRX(2);

    double rightDemand;
    double leftDemand;
    double turn;
    double quickTurn;
    double throttle;
    double leftPwm = 0;
    double rightPwm = 0;
    boolean rampActive = true;

  public Drive() {}

  public void mainDrive(){
    rightDemand = control.getRawAxis(3);
    leftDemand = control.getRawAxis(2);       
    turn = control.getRawAxis(0);
    quickTurn = control.getRawAxis(4);

    quickTurn = Math.abs(quickTurn) < 0.15 ? 0 : control.getRawAxis(4);
    rightDemand = Math.abs(rightDemand) < 0.15 ? 0 : control.getRawAxis(3);
    leftDemand = Math.abs(leftDemand) < 0.15 ? 0 : control.getRawAxis(2);

    turn = Math.abs(turn) < 0.15 ? 0 : control.getRawAxis(0);

    throttle = rightDemand - leftDemand;
    throttle = Math.abs(throttle) < 0.15 ? 0 : rightDemand - leftDemand;

    if(throttle>=0){
      leftPwm = (throttle) - turn;
      rightPwm = (throttle) + turn;
    }
    else{
      leftPwm = (throttle) + turn;
      rightPwm = (throttle) - turn;
    }

    if(quickTurn != 0){
      mMotor1FrontRight.set(ControlMode.PercentOutput, quickTurn);
      mMotor2BackRight.set(ControlMode.PercentOutput, quickTurn);
      mMotor3FrontLeft.set(ControlMode.PercentOutput, quickTurn);
      mMotor4BackLeft.set(ControlMode.PercentOutput, quickTurn);
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
