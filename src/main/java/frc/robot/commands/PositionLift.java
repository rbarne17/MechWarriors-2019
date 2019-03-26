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

public class PositionLift extends Command {
  private int liftPosition;
  private int liftPositionLow;
  private int liftPositionHigh;
  private int liftDeadBand = RobotMap.LIFT_ENCODER_ENCODER_DEADBAND;

  public PositionLift(int liftPosition) {
    this.liftPosition = liftPosition;
    this.liftPositionLow = (liftPosition - liftDeadBand/2);
    this.liftPositionHigh = liftPosition + liftDeadBand/2;
  }

  // Called just before this Command runs the first time
  @Override
  protected void initialize() {
  }

  // Called repeatedly when this Command is scheduled to run
  @Override
  protected void execute() {
    Robot.m_lift.setLiftDirection(RobotMap.LIFT_SPEED, liftPosition);
  }

  // Make this return true when this Command no longer needs to run execute()
  @Override
  protected boolean isFinished() {
    return ((Robot.m_lift.getLiftEncoder() >= liftPositionLow && Robot.m_lift.getLiftEncoder() <= liftPositionHigh));
  }

  // Called once after isFinished returns true
  @Override
  protected void end() {
      Robot.m_lift.stopLift();
    
  }

  // Called when another command which requires one or more of the same
  // subsystems is scheduled to run
  @Override
  protected void interrupted() {
  }
}
