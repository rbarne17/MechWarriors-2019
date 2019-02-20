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
  private int liftPositionLow = 0;
  private int liftPositionHigh = -1;

  public PositionLift(int liftPosition) {
    this.liftPositionLow = liftPosition;
    // Use requires() here to declare subsystem dependencies
    // eg. requires(chassis);
  }

  public PositionLift(int positionLiftLow, int positionLiftHigh) {
    this.liftPositionLow = positionLiftLow;
    this.liftPositionHigh = positionLiftHigh;
  }

  // Called just before this Command runs the first time
  @Override
  protected void initialize() {
  }

  // Called repeatedly when this Command is scheduled to run
  @Override
  protected void execute() {
    Robot.m_lift.setLiftDirection(RobotMap.LIFT_SPEED, liftPositionLow);

  }

  // Make this return true when this Command no longer needs to run execute()
  @Override
  protected boolean isFinished() {
    if (liftPositionHigh == -1) {
      return (Robot.m_targetgripper.getTargetGripperEncoder() == liftPositionLow);
    } else {
      return (Robot.m_targetgripper.getTargetGripperEncoder() >= liftPositionLow
          && Robot.m_targetgripper.getTargetGripperEncoder() <= liftPositionHigh);
    }

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
