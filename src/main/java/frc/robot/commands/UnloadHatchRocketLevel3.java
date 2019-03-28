/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;
import frc.robot.RobotMap;

public class UnloadHatchRocketLevel3 extends CommandGroup {
  /**
   * Add your docs here.
   */
  public UnloadHatchRocketLevel3() {
    addParallel(new PositionLift(RobotMap.LIFT_ENCODER_HATCH_ROCKET_LEVEL_3));
    addParallel(new PositionTargetArm(RobotMap.TARGET_ARM_ENCODER_HATCH_ROCKET_LEVEL_3));
    addSequential(new PositionTargetGripper(RobotMap.TARGET_GRIPPER_ENCODER_HIGH));
  }
}
