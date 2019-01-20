/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.RobotMap;
import frc.robot.subsystems.Vision;

public class AdjustToTarget extends Command {
  Vision v;
  double angle;
  double counter = 0;
  final double MAX_DEVIATION = 10;
  public AdjustToTarget() {
    // Use requires() here to declare subsystem dependencies
    // eg. requires(chassis);
    v = new Vision();
    angle = v.getVisionAngle();

  }

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
    // accounts for actual perspective vs perceived perspective
    if(RobotMap.rotator.getError() > 2){
      counter++;
      if(counter > 1000){
        if(angle > MAX_DEVIATION){
          // sets setpoint to new angle
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
