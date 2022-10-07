package frc.robot.subsystems;

import com.revrobotics.RelativeEncoder;
import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMax.SoftLimitDirection;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class Hopper extends SubsystemBase {
  //Hardware ----------------------------------------------------------------->
  private CANSparkMax hopperMotor = new CANSparkMax(Constants.kHopperId, MotorType.kBrushless);
  private RelativeEncoder relativeHopperEncoder; //declaracion del encoder para saber la posicion del motor

  //OUTPUTS ----------------------------------------------------------------->
  /*Varibales para la salida a motores o SmartDashBoard*/
  double hopperSpeed = 0;
  private double hopperPosition = 0; //para leer el encoder
    
  public Hopper() {
    hopperMotor.enableSoftLimit(SoftLimitDirection.kForward, true); //declaracion del limite para el hopper
    hopperMotor.setSoftLimit(SoftLimitDirection.kForward, (float) Constants.kHopperHighPosition); // Ymax
    hopperMotor.enableSoftLimit(SoftLimitDirection.kReverse, true); //limite inferior
    hopperMotor.setSoftLimit(SoftLimitDirection.kReverse, (float) Constants.kHopperLowPosition); //Ymin
    
    relativeHopperEncoder = hopperMotor.getEncoder(); //llamada del encoder del NEO
    
    hopperPosition = relativeHopperEncoder.getPosition(); //entrada de la posicion del motor
  }  //constructor del subsistema

  //------------------// Funciones del subsistema //-------------------------------//

  //funcion principal para cada subsistema
  
  public void hopperAction(double inHopperSpeed){ //agregar los limites de arriba y abajo
    hopperSpeed = inHopperSpeed;
    hopperMotor.set(hopperSpeed);
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