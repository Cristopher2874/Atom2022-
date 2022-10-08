package frc.robot.subsystems;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.PneumaticsModuleType;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class Intake extends SubsystemBase {
  //Hardware ----------------------------------------------------------------->
  private final Solenoid piston1 = new Solenoid(PneumaticsModuleType.CTREPCM, Constants.kIntakeSolenoidId1);
  private final Solenoid piston2 = new Solenoid(PneumaticsModuleType.CTREPCM, Constants.kIntakeSolenoidId2);
  private CANSparkMax intakeMotor = new CANSparkMax(Constants.kIntakeId, MotorType.kBrushless);

  //INPUTS ------------------------------------------------------------------>
  boolean intakeForward = false; 
  boolean intakeReverse = false;
  
  public Intake() {
    piston1.close();
    piston2.close();
  } //constructor del subsistema

  //------------------// Funciones del subsistema //-------------------------------//

  public void takeIn(boolean inTakeIn){
    intakeForward = inTakeIn;
    if (intakeForward){
    piston1.set(false);
    piston2.set(false);
    intakeMotor.set(Constants.kIntakeDemand);
    }
    else{
      piston1.set(true);
      piston2.set(true);
      intakeMotor.set(0);
    }
}

//sacar pelotas
public void takeOut(boolean inTakeOut){
    intakeReverse = inTakeOut;
    if (intakeForward){
      piston1.set(true);
      piston2.set(true);
      intakeMotor.set(-Constants.kIntakeDemand);
    }
    else{
      piston1.set(false);
      piston2.set(false);
      intakeMotor.set(0);
      }
  }
  //Funcion para poner salidas a SmartDashBoard 
  public void IntakeLogsOutput(){/*codigo para dar salidas a SmartDashBoard*/}
    
  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }

  @Override
  public void simulationPeriodic() {
    // This method will be called once per scheduler run during simulation
  }
}
