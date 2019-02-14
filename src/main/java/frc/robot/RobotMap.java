/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import edu.wpi.first.wpilibj.DigitalSource;

/**
 * The RobotMap is a mapping from the ports sensors and actuators are wired into
 * to a variable name. This provides flexibility changing wiring, makes checking
 * the wiring easier and significantly reduces the number of magic numbers
 * floating around.
 */
public class RobotMap {

  // OI
  public static final int OI_DRIVER_CONTROLLER = 0;

  // PWM
  public static final int DRIVETRAIN_LEFT_SPARK = 0;
  public static final int DRIVETRAIN_RIGHT_SPARK = 1;

  // DIO
  public static final int LEFT_ENCODER_CHANNEL_1 = 0;
  public static final int LEFT_ENCODER_CHANNEL_2 = 1;
  public static final int RIGHT_ENCODER_CHANNEL_1 = 2;
  public static final int RIGHT_ENCODER_CHANNEL_2 = 3;
  public static final int LIFT_MECHANISM_SWITCH_HOME = 4;

  public static final int LIFT_ENCODER_CHANNEL_1 = 5;
  public static final int LIFT_ENCODER_CHANNEL_2 = 6;

  public static final DigitalSource TARGET_GRIPPER_ENCODER_CHANNEL_1 = null;

  public static final DigitalSource TARGET_GRIPPER_ENCODER_CHANNEL_2 = null;

  public static final int TARGET_GRIPPER_ENCODER_UP = 0;

  public static final int TARGET_GRIPPER_ENCODER_DOWN = 0;

  public static final int TARGET_GRIPPER_ENCODER_HATCH_LOWER = 0;

  public static final int TARGET_GRIPPER_ENCODER_HATCH_UPPER = 0;

  // CAN
  public static final DigitalSource TARGET_ARM_ENCODER_CHANNEL_1 = null;

  public static final DigitalSource TARGET_ARM_ENCODER_CHANNEL_2 = null;

  public static final int CLIMBHAB_SOLENOID_DEPLOY = 0;

  public static final int TARGET_ARM_ENCODER_UP = 0;

  public static final int TARGET_ARM_ENCODER_DOWN = 0;

  public static final int CLIMBHAB_SOLENOID_RETRACT = 1;

  public static final int POWER_DISTRIBUTION_BOARD = 2;

  public static final int LIFT_MECHANISM_MOTOR = 5;

  public static final int TARGET_ARM_MOTOR = 6;

  public static final int TARGET_GRIPPER_MOTOR = 7;

  public static final int TARGET_PULLER_MOTOR = 8;

  public static final int TARGET_PUSHER_PULLER_MOTOR = 9;
}

 

  

 

  











