package frc.robot.subsystems;

import edu.wpi.first.wpilibj.XboxController;
import com.revrobotics.RelativeEncoder;
import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class Hopper extends SubsystemBase {
  //Hardware ----------------------------------------------------------------->
  /*Declarar motores, sensores, etc.*/
  private CANSparkMax motor1H = new CANSparkMax(1, MotorType.kBrushless);

  //INPUTS ------------------------------------------------------------------>
  /*Leer las entradas de controles*/
  double leftTrigger;
  double rightTrigger;
  // los triggers necesitan de getTrigger
  //OUTPUTS ----------------------------------------------------------------->
  /*Varibales para la salida a motores o SmartDashBoard*/
  double hopperSpeed = 0;
  
    
  //Logic ----------------------------------------------------------------->
  /*Otras variables*/
  //private final RelativeEncoder mTopFeederEncoder = mRightHangerMotor.getEncoder(), mBaseFeEncoder=0;
  //Controlers -------------------------------------------------------------->
  /*Declaracion del control*/
  private final XboxController OpController = new XboxController(0);

  public Hopper() {}  //constructor del subsistema

  //------------------// Funciones del subsistema //-------------------------------//

  //funcion principal para cada subsistema
  
  public void feederAction(double inLeftTrigger, double inRightTrigger){
    hopperSpeed = inRightTrigger - inLeftTrigger;
    motor1H.set(hopperSpeed);
  }
  
  //Funcion para poner salidas a SmartDashBoard 
public void FeederLogsOutput(){/*codigo para dar salidas a SmartDashBoard*/}
    
  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }

  @Override
  public void simulationPeriodic() {
    // This method will be called once per scheduler run during simulation
  }
}
