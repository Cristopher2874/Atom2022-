package frc.robot;

import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.wpilibj.PneumaticsModuleType;
import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.CommandScheduler;
import frc.robot.controlboard.ControlBoard;
import frc.robot.subsystems.Drive;
import frc.robot.subsystems.Example;
//import frc.robot.subsystems.Intake;
import frc.robot.subsystems.LogsOutput;

public class Robot extends TimedRobot {
  private Command m_autonomousCommand;

  //private RobotContainer m_robotContainer;
    Drive mDrive = new Drive();
    LogsOutput mLogsOutput = new LogsOutput();
    Example mFeeder = new Example();    
    
  //Delcaracion del compresor      
    private final Compressor mCompressor = new Compressor(PneumaticsModuleType.CTREPCM);

  @Override
  public void robotInit() {
    //m_robotContainer = new RobotContainer();  
    mCompressor.enableDigital(); //habilita el compresor 
    mLogsOutput.MasterLosgsOutputs(); //Manda llmar la funcion de Logs
  }

  @Override
  public void robotPeriodic() {
    CommandScheduler.getInstance().run();
  }

  @Override
  public void disabledInit() {}

  @Override
  public void disabledPeriodic() {}

  @Override
  public void autonomousInit() {
    //m_autonomousCommand = m_robotContainer.getAutonomousCommand();

    if (m_autonomousCommand != null) {
      m_autonomousCommand.schedule();
    }
  }

  @Override
  public void autonomousPeriodic() {
    mLogsOutput.MasterLosgsOutputs();
  }

  @Override
  public void teleopInit() {
    if (m_autonomousCommand != null) {
      m_autonomousCommand.cancel();
    }
  }

  @Override
  public void teleopPeriodic() {
    mLogsOutput.MasterLosgsOutputs();
    mDrive.mainDrive( ControlBoard.getInstance().getVelocityY(), ControlBoard.getInstance().getTurn(), 
      ControlBoard.getInstance().getDirectThrottle() );
  }

  @Override
  public void testInit() {
    CommandScheduler.getInstance().cancelAll();
  }

  @Override
  public void testPeriodic() {}

  @Override
  public void simulationInit() {}

  @Override
  public void simulationPeriodic() {}
}
