/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Robot;
import frc.robot.RobotMap;

public class GripHatchTargetGripper extends Command {
  public GripHatchTargetGripper() {
    // Use requires() here to declare subsystem dependencies
    // eg. requires(chassis);
  }

  // Called just before this Command runs the first time
  @Override
  protected void initialize() {
  }

  // Called repeatedly when this Command is scheduled to run
  @Override
  protected void execute() {
    Robot.m_targetgripper.setTargetGripperDirection(RobotMap.TARGET_GRIPPER_SPEED,RobotMap.TARGET_GRIPPER_ENCODER_HATCH_LOW);

  }

  // Make this return true when this Command no longer needs to run execute()
  @Override
  protected boolean isFinished() {
    return (Robot.m_targetgripper.getTargetGripperEncoder() >= RobotMap.TARGET_GRIPPER_ENCODER_HATCH_LOW && Robot.m_targetgripper.getTargetGripperEncoder() <= RobotMap.TARGET_GRIPPER_ENCODER_HATCH_HIGH
    );
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
