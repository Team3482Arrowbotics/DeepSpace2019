package frc.robot.subsystems;

import edu.wpi.first.wpilibj.PIDOutput;
import frc.robot.Locale;
import frc.robot.Robot;
import frc.robot.RobotMap;

public class RotateOut implements PIDOutput{
    
    public void pidWrite(double output){
        // if(Robot.isVisioning){
        //     RobotMap.drive.arcadeDrive(0.3, output); 
        // } else {
        //     RobotMap.drive.arcadeDrive(0, output);
        // }
        RobotMap.drive.arcadeDrive(Robot.isVisioning ? Locale.ROTATE_OUT_SPEED : 0, output);
    }
}
