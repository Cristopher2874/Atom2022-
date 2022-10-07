package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class Turret extends SubsystemBase {
  //Hardware ----------------------------------------------------------------->
  /*Declarar motores, sensores, etc.*/

  //INPUTS ------------------------------------------------------------------>
  /*Leer las entradas de controles*/
  
  //OUTPUTS ----------------------------------------------------------------->
  /*Varibales para la salida a motores o SmartDashBoard*/
    
  //Logic ----------------------------------------------------------------->
  /*Otras variables*/
  //private final RelativeEncoder mTopFeederEncoder = mRightHangerMotor.getEncoder(), mBaseFeEncoder=0;
  //Controlers -------------------------------------------------------------->
  /*Declaracion del control*/

  public Turret() {} //constructor del subsistema

  //------------------// Funciones del subsistema //-------------------------------//

  //funcion principal para cada subsistema
  
  public void feederAction(){/*codigo que mandas llamar en el robot*/}
  
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
