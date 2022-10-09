package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;
import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class Shooter extends SubsystemBase{
    
    //Hardware ----------------------------------------------------------------->
    //private CANSparkMax motor1 = new CANSparkMax(Constants.kShooter1Id, MotorType.kBrushless);
    //private CANSparkMax motor2 = new CANSparkMax(Constants.kShooter2Id, MotorType.kBrushless);
    private TalonSRX shooterMotor = new TalonSRX(Constants.kShooter1Id);
    //INPUTS ------------------------------------------------------------------>
    boolean shooterActive = false; 

    public Shooter() {} //constructor del subsistema

    //------------------// Funciones del subsistema //-------------------------------//

    //Funcion para disparar
    public void shoot(boolean inShooterActive){
        shooterActive = inShooterActive;
        if (shooterActive){
            shooterMotor.set(ControlMode.PercentOutput, Constants.kShooterDemand);
        
        }
        else{
            shooterMotor.set(ControlMode.PercentOutput,0);
        
        }
    }

    //Funcion para poner salidas a SmartDashBoard 
    public void ShooterLogsOutput(){/*codigo para dar salidas a SmartDashBoard*/
        SmartDashboard.putBoolean("Shooter Active", shooterActive);
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


