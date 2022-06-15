// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;
import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;

import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.CommandScheduler;
import frc.robot.subsystems.Drive;

/**
 * The VM is configured to automatically run this class, and to call the functions corresponding to
 * each mode, as described in the TimedRobot documentation. If you change the name of this class or
 * the package after creating this project, you must also update the build.gradle file in the
 * project.
 */
public class Robot extends TimedRobot {
  private Command m_autonomousCommand;

  private RobotContainer m_robotContainer;
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
    
    private final XboxController control = new XboxController(0);

  /**
   * This function is run when the robot is first started up and should be used for any
   * initialization code.
   */
  @Override
  public void robotInit() {
    // Instantiate our RobotContainer.  This will perform all our button bindings, and put our
    // autonomous chooser on the dashboard.
    m_robotContainer = new RobotContainer();
    mMotor1FrontRight.set(ControlMode.PercentOutput, 0);
    mMotor2BackRight.set(ControlMode.PercentOutput, 0);
    mMotor3FrontLeft.set(ControlMode.PercentOutput, 0);
    mMotor4BackLeft.set(ControlMode.PercentOutput, 0);
  }

  /**
   * This function is called every robot packet, no matter the mode. Use this for items like
   * diagnostics that you want ran during disabled, autonomous, teleoperated and test.
   *
   * <p>This runs after the mode specific periodic functions, but before LiveWindow and
   * SmartDashboard integrated updating.
   */
  @Override
  public void robotPeriodic() {
    // Runs the Scheduler.  This is responsible for polling buttons, adding newly-scheduled
    // commands, running already-scheduled commands, removing finished or interrupted commands,
    // and running subsystem periodic() methods.  This must be called from the robot's periodic
    // block in order for anything in the Command-based framework to work.
    CommandScheduler.getInstance().run();
  }

  /** This function is called once each time the robot enters Disabled mode. */
  @Override
  public void disabledInit() {}

  @Override
  public void disabledPeriodic() {}

  /** This autonomous runs the autonomous command selected by your {@link RobotContainer} class. */
  @Override
  public void autonomousInit() {
    m_autonomousCommand = m_robotContainer.getAutonomousCommand();

    // schedule the autonomous command (example)
    if (m_autonomousCommand != null) {
      m_autonomousCommand.schedule();
    }
  }

  /** This function is called periodically during autonomous. */
  @Override
  public void autonomousPeriodic() {}

  @Override
  public void teleopInit() {
    // This makes sure that the autonomous stops running when
    // teleop starts running. If you want the autonomous to
    // continue until interrupted by another command, remove
    // this line or comment it out.
    if (m_autonomousCommand != null) {
      m_autonomousCommand.cancel();
    }
  }

  /** This function is called periodically during operator control. */
  @Override
  public void teleopPeriodic() {
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
  public void testInit() {
    // Cancels all running commands at the start of test mode.
    CommandScheduler.getInstance().cancelAll();
  }

  /** This function is called periodically during test mode. */
  @Override
  public void testPeriodic() {}

  /** This function is called once when the robot is first started up. */
  @Override
  public void simulationInit() {}

  /** This function is called periodically whilst in simulation. */
  @Override
  public void simulationPeriodic() {}
}
