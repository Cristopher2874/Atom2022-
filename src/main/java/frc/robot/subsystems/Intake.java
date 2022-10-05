/*package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;

import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class Intake extends SubsystemBase {
    private final Solenoid piston1 = new Solenoid(PneumaticsModuleType.CTREPCM, 0);
    private final Solenoid piston2 = new Solenoid(PneumaticsModuleType.CTREPCM, 1);
    
    private final XboxController control2 = new XboxController(1);

    private CANSparkMax motor1 = new CANSparkMax(1, MotorType.kBrushless);
    private CANSparkMax motor2 = new CANSparkMax(2, MotorType.kBrushless);
    private CANSparkMax motor3 = new CANSparkMax(3, MotorType.kBrushless);

    double velMotor1 = 0;
    double velMotor2 = 0;
    double velMotor3 = 0;

  public Intake() {}

  public void mainIntake(){
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
}*/
