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

public class TargetPushPullWithController extends Command {
  
  boolean targetPusherPullerPush;

  // push if targetPusherPullerPush true; pull if targetPusherPullerPush false
  public TargetPushPullWithController(boolean targetPusherPullerPush) {
    requires(Robot.m_targetpusherpuller);
    this.targetPusherPullerPush = targetPusherPullerPush;

  }

  // Called just before this Command runs the first time
  @Override
  protected void initialize() {
  }

  // Called repeatedly when this Command is scheduled to run
  @Override
  protected void execute() {
    if (targetPusherPullerPush) {
      Robot.m_targetpusherpuller.setTargetPusherPullerPush(RobotMap.TARGET_PUSHER_PULLER_SPEED);
    } else {
      Robot.m_targetpusherpuller.setTargetPusherPullerPull(RobotMap.TARGET_PUSHER_PULLER_SPEED);

    }
  }

  // Make this return true when this Command no longer needs to run execute()
  @Override
  protected boolean isFinished() {
    return true;
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
