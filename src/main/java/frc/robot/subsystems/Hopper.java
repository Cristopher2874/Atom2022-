package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;
import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class Hopper extends SubsystemBase {
  //Hardware ----------------------------------------------------------------->
  //private CANSparkMax hopperMotor = new CANSparkMax(Constants.kHopperId, MotorType.kBrushless);
  private TalonSRX hopperMotor = new TalonSRX(Constants.kHopperId);
  
  //OUTPUTS ----------------------------------------------------------------->
  double hopperSpeed = 0;
      
  public Hopper() {}  //constructor del subsistema

  //------------------// Funciones del subsistema //-------------------------------//
  
  public void hopperAction(double inHopperSpeed){ //agregar los limites de arriba y abajo
    hopperSpeed = inHopperSpeed;
    hopperMotor.set(ControlMode.PercentOutput, hopperSpeed);
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
