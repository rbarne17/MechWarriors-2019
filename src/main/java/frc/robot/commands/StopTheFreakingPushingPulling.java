/*
 * With love from 3140 Flagship <3
 */
package frc.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Robot;

public class StopTheFreakingPushingPulling extends Command {
  public StopTheFreakingPushingPulling() {
    requires(Robot.m_targetpusherpuller);
  }

  // Called repeatedly when this Command is scheduled to run
  @Override
  protected void execute() {
    Robot.m_targetpusherpuller.setTargetPusherPullerPush(0);
  }

  // Make this return true when this Command no longer needs to run execute()
  @Override
  protected boolean isFinished() {
    return true;
  }

}
