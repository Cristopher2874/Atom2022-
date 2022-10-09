package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class LogsOutput extends SubsystemBase {
  //Drive mDrive = new Drive();
  //Intake mIntake = new Intake();  
  Shooter mShooter = new Shooter();
  public LogsOutput() {} //constructor del subsistema

  //------------------// Funciones del subsistema //-------------------------------//

  //funcion principal para cada subsistema
  
  public void MasterLosgsOutputs(){
    //mDrive.DriveLogsOutput(); //Llamar las funciones de output de cada subsistema
    mShooter.ShooterLogsOutput();
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
