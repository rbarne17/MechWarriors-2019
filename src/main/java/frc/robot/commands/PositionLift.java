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
  private boolean liftDirectionUp;
  private boolean liftDirectionDown;

  public PositionLift(int unloadHatchCargoShip) {
    this.liftPositionLow = unloadHatchCargoShip;
    this.liftPositionHigh = unloadHatchCargoShip;
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
    liftDirectionUp = Robot.m_lift.getLiftDirectionUp();
    liftDirectionDown = !liftDirectionUp;
  }

  // Make this return true when this Command no longer needs to run execute()
  @Override
  protected boolean isFinished() {
    if ((Robot.m_lift.getLiftLimitSwitchLow() && liftDirectionDown)
        || (Robot.m_lift.getLiftLimitSwitchHigh() && liftDirectionUp)) {
      return true;
    } else if (liftPositionHigh == liftPositionLow) {
      return (Robot.m_lift.getLiftEncoder() == liftPositionLow);
    } else {
      return ((Robot.m_lift.getLiftEncoder() >= liftPositionLow && Robot.m_lift.getLiftEncoder() <= liftPositionHigh));
    }

  }

  // Called once after isFinished returns true
  @Override
  protected void end() {
      Robot.m_lift.stopLiftMotor();
    
  }

  // Called when another command which requires one or more of the same
  // subsystems is scheduled to run
  @Override
  protected void interrupted() {
  }
}
