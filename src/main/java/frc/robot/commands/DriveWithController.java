/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Robot;

public class DriveWithController extends Command {
  public DriveWithController() {
    // Use requires() here to declare subsystem dependencies
    // eg. requires(chassis);
    requires(Robot.m_drivetrain);
  }

  // Called just before this Command runs the first time
  @Override
  protected void initialize() {
  }

  // Called repeatedly when this Command is scheduled to run
  @Override
  protected void execute() {

  // Make this return true when this Command no longer needs to run execute()
  //if (Robot.lift.getEncoderLift() > 1500) {
   // Robot.DriveTrain.driveByArcade((-Robot.operatorInput.getJoystickY()/2), (-Robot.operatorInput.getJoystickX()/2));
  //} else {
    //Robot.DriveTrain.driveByArcade(-Robot.operatorInput.getLiftStickY(), -Robot.operatorInput.getLiftStickX());
  //}
    
  }
  @Override
  protected boolean isFinished() {
    return false;
  }

  // Called once after isFinished returns true
  @Override
  protected void end() {
  }

  // Called when another command which requires one or more of the same
  // subsystems is scheduled to run
  @Override
  protected void interrupted() {
  }
}
