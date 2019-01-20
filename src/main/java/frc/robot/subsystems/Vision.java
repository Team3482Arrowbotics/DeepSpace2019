package frc.robot.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.Robot;

public class Vision extends Subsystem{
    public double centerX;
    public double centerY;
    public final double PIXELS_TO_DEGREES = 0.085625;
    public Vision(){

    }
    public void run(){
        centerX = Robot.centerX.getDouble(0.0);
        centerY = Robot.centerY.getDouble(0.0);
    }
    public double getVisionAngle(){
        return centerX * PIXELS_TO_DEGREES;
    }
    public void AdjustToTarget(){
        
    }
    public void initDefaultCommand(){
        
    }
}