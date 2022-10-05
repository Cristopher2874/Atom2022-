package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;

import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class Feeder extends SubsystemBase {
  //Hardware ----------------------------------------------------------------->
  /*Declarar motores, sensores, etc.*/

  //INPUTS ------------------------------------------------------------------>
  /*Leer las entradas de controles*/
  
  //OUTPUTS ----------------------------------------------------------------->
  /*Varibales para la salida a motores o SmartDashBoard*/
    
  //Logic ----------------------------------------------------------------->
  /*Otras variables*/
  
  //Controlers -------------------------------------------------------------->
  /*Declaracion del control*/

  public Feeder() {} //constructor del subsistema

  //------------------// Funciones del subsistema //-------------------------------//

  //funcion principal para cada subsistema
  
  public void feederAction(){/*codigo que mandas llamar en el robot*/}
  
  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }

  @Override
  public void simulationPeriodic() {
    // This method will be called once per scheduler run during simulation
  }
}
