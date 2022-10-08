package frc.robot.subsystems;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class Shooter extends SubsystemBase{
    
    //Hardware ----------------------------------------------------------------->
    private CANSparkMax motor1 = new CANSparkMax(Constants.kShooter1Id, MotorType.kBrushless);
    private CANSparkMax motor2 = new CANSparkMax(Constants.kShooter2Id, MotorType.kBrushless);

    //INPUTS ------------------------------------------------------------------>
    boolean shooterActive = false; 

    public Shooter() {} //constructor del subsistema

    //------------------// Funciones del subsistema //-------------------------------//

    //Funcion para disparar
    public void shoot(boolean inShooterActive){
        shooterActive = inShooterActive;
        if (shooterActive){
        motor1.set(Constants.kShooterDemand);
        motor2.set(-Constants.kShooterDemand);
        }
        else{
        motor1.set(0);
        motor2.set(0);
        }
        }

    //Funcion para poner salidas a SmartDashBoard 
    public void FeederLogsOutput(){/*codigo para dar salidas a SmartDashBoard*/
        SmartDashboard.putBoolean("Shooter Active", shooterActive);
        SmartDashboard.putNumber("ShooterM1 Speed", motor1.get());
        SmartDashboard.putNumber("ShooterM2 Speed", motor2.get());
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


