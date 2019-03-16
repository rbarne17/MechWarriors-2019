/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import edu.wpi.first.wpilibj.command.InstantCommand;
import frc.robot.Robot;

public class PositionTargetIntakeDrop extends InstantCommand {

  private Boolean drop;

  public PositionTargetIntakeDrop(boolean drop) {
    super();
    // Use requires() here to declare subsystem dependencies
    // eg. requires(chassis);
    this.drop = drop;
  }

  // Called just before this Command runs the first time
  @Override
  protected void initialize() {
    if (drop) {
      Robot.m_targetintakedrop.setTargetIntakeDropUp();
    } else {
      Robot.m_targetintakedrop.setTargetIntakeDropDown();
    }
  }
}
