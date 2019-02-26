/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;
import frc.robot.RobotMap;

public class LoadHatchLoadingStation extends CommandGroup {
  /**
   * Add your docs here.
   */
  public LoadHatchLoadingStation() {
    addParallel(new PositionLift(RobotMap.LIFT_ENCODER_LOADING_STATION));
    addParallel(new PositionTargetArm(RobotMap.TARGET_ARM_ENCODER_LOADING_STATION));
    addParallel(new PositionTargetGripper(RobotMap.TARGET_GRIPPER_ENCODER_LOADING_STATION));
  }
}
