package frc.robot.subsystems;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.PneumaticsModuleType;
import edu.wpi.first.wpilibj.DoubleSolenoid.Value;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class Intake extends SubsystemBase {
  //Hardware ----------------------------------------------------------------->
  private final DoubleSolenoid pistonTest = new DoubleSolenoid(PneumaticsModuleType.CTREPCM, 
    Constants.kIntakeSolenoid1, Constants.kIntakeSolenoid2);
  private CANSparkMax intakeMotor = new CANSparkMax(Constants.kIntakeId, MotorType.kBrushless);

  //INPUTS ------------------------------------------------------------------>
  boolean intakeForward = false; 
  boolean intakeReverse = false; 

  //OUTPUTS ----------------------------------------------------------------->
   
  public Intake() {} //constructor del subsistema

  //------------------// Funciones del subsistema //-------------------------------//

  //comer pelotas
  public void takeIn(boolean inTakeIn){
      intakeForward = inTakeIn;
      if (intakeForward){
      pistonTest.set(Value.kForward); //el double solenoid
      intakeMotor.set(Constants.kIntakeDemand);
      }
      else{
        pistonTest.set(Value.kReverse);
        intakeMotor.set(0);
      }
  }

  //sacar pelotas
  public void takePut(boolean inTakeOut){
      intakeReverse = inTakeOut;
      if (intakeForward){
        pistonTest.set(Value.kForward); //el double solenoid
        intakeMotor.set(-Constants.kIntakeDemand);
      }
      else{
        pistonTest.set(Value.kReverse);
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
