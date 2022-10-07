package frc.robot.subsystems;

import com.revrobotics.RelativeEncoder;
import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMax.SoftLimitDirection;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class Hanger extends SubsystemBase {
  //Hardware ----------------------------------------------------------------->
  private CANSparkMax hangerMotor = new CANSparkMax(5, MotorType.kBrushless);
  private RelativeEncoder relativeHopperEncoder; //declaracion del encoder para saber la posicion del motor

  //OUTPUTS ----------------------------------------------------------------->
  double hopperSpeed = 0;
  private double hopperPosition = 0; //para leer el encoder
    
  public Hanger() {
    hangerMotor.enableSoftLimit(SoftLimitDirection.kForward, true); //declaracion del limite para el hopper
    hangerMotor.setSoftLimit(SoftLimitDirection.kForward, (float) Constants.kHangerHighPosition); // Ymax
    hangerMotor.enableSoftLimit(SoftLimitDirection.kReverse, true); //limite inferior
    hangerMotor.setSoftLimit(SoftLimitDirection.kReverse, (float) Constants.kHangerLowPosition); //Ymin
    
    relativeHopperEncoder = hangerMotor.getEncoder(); //llamada del encoder del NEO
    
    hopperPosition = relativeHopperEncoder.getPosition(); //entrada de la posicion del motor
  }  //constructor del subsistema

  //------------------// Funciones del subsistema //-------------------------------//
  
  public void hopperAction(double inHopperSpeed){ //agregar los limites de arriba y abajo
    hopperSpeed = inHopperSpeed;
    hangerMotor.set(hopperSpeed);
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
