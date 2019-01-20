package frc.robot.subsystems;

import edu.wpi.first.wpilibj.PIDOutput;
import frc.robot.Robot;
import frc.robot.RobotMap;

public class RotateOut implements PIDOutput{
    public RotateOut(){

    }
    public void pidWrite(double output){
        if(Robot.isVisioning){
            RobotMap.drive.arcadeDrive(0.3, output); 
        } else {
            RobotMap.drive.arcadeDrive(0, output);
        }
    }
}
