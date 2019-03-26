/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;
import frc.robot.RobotMap;

public class LoadCargoDepot extends CommandGroup {
  /**
   * Add your docs here.
   */
  public LoadCargoDepot() {
   addParallel( new PositionLift(RobotMap.LIFT_ENCODER_DEPOT));
   addParallel(new PositionTargetArm(RobotMap.TARGET_ARM_ENCODER_DEPOT));
   addParallel(new PositionTargetGripper(RobotMap.TARGET_GRIPPER_ENCODER_LOW));
   addSequential(new PositionTargetPuller(1.00));   
   addSequential(new PositionTargetPusherPuller(1.00,false)); 


  }
}
