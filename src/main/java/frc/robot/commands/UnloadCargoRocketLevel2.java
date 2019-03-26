/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;
import frc.robot.RobotMap;

public class UnloadCargoRocketLevel2 extends CommandGroup {
  /**
   * Add your docs here.
   */
  public UnloadCargoRocketLevel2() {
    addParallel(new PositionTargetPusherPuller(1.00,false)); 
    addParallel(new PositionTargetPuller(1.00));
    addParallel(new PositionLift(RobotMap.LIFT_ENCODER_ROCKET_LEVEL_2));
    addParallel(new PositionTargetArm(RobotMap.TARGET_ARM_ENCODER_ROCKET_LEVEL_2));
  }
}
