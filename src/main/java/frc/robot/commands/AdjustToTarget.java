/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Locale;
import frc.robot.RobotMap;
import frc.robot.subsystems.Vision;

public class AdjustToTarget extends Command {
  
  
  private final Vision v = new Vision();
  private final double MAX_DEVIATION = 10;
  
  private double angle = v.getVisionAngle();
  private double counter = 0;
  
  // public AdjustToTarget() {
  //   v = new Vision();
  //   angle = v.getVisionAngle();
  // }

  // Called just before this Command runs the first time
  @Override
  protected void initialize() {
    RobotMap.rotator.setSetpoint(angle);
    RobotMap.rotator.enable();
  }

  // Called repeatedly when this Command is scheduled to run
  @Override
  protected void execute() {
    angle = v.getVisionAngle();
    
    if(RobotMap.rotator.getError() > 2){
      counter++;

      if(counter > Locale.VISION_MAX_COUNTER){  
        if(angle > MAX_DEVIATION){
          RobotMap.rotator.setSetpoint(angle);
        }
      
      }
    }
  }

  // Make this return true when this Command no longer needs to run execute()
  @Override
  protected boolean isFinished() {
    return false;
  }

  // Called once after isFinished returns true
  @Override
  protected void end() {
    RobotMap.rotator.disable();
  }

  // Called when another command which requires one or more of the same
  // subsystems is scheduled to run
  @Override
  protected void interrupted() {

  }
}
