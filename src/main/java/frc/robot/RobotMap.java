/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

/**
 * The RobotMap is a mapping from the ports sensors and actuators are wired into
 * to a variable name. This provides flexibility changing wiring, makes checking
 * the wiring easier and significantly reduces the number of magic numbers
 * floating around.
 */
public class RobotMap {

  // OI
  public static final int OI_DRIVER_CONTROLLER_JOYSTICK = 0;
  public static final int OI_DRIVER_CONTROLLER_XBOX = 1;

  // PWM
  public static final int DRIVETRAIN_LEFT_SPARK = 0;
  public static final int DRIVETRAIN_RIGHT_SPARK = 1;

  // DIO
  public static final int TOP_LIM_SWITCH = 1;
  public static final int BOT_LIM_SWITCH = 0;

  // Solenoid valves
  public static final int CLIMBHAB_SOLENOID_1_DEPLOY = 0;
  public static final int CLIMBHAB_SOLENOID_1_RETRACT = 1;
  public static final int CLIMBHAB_SOLENOID_2_DEPLOY = 2;
  public static final int CLIMBHAB_SOLENOID_2_RETRACT = 3;
  public static final int TARGET_INTAKE_DROP_DEPLOY = 4;
  public static final int TARGET_INTAKE_DROP_RETRACT = 5;

  // CAN
  public static final int CLIMBHAB_SOLENOID = 1;
  public static final int POWER_DISTRIBUTION_BOARD = 2;
  public static final int LIFT_MECHANISM_MOTOR = 5;
  public static final int TARGET_ARM_MOTOR = 6;
  public static final int TARGET_GRIPPER_MOTOR = 7;
  public static final int TARGET_PULLER_MOTOR = 8;
  public static final int TARGET_PUSHER_PULLER_MOTOR = 9;

  // Encoder targets
  // Lift
  public static final int LIFT_ENCODER_LOW = 0;
  public static final int LIFT_ENCODER_HIGH = 0;
  public static final int LIFT_ENCODER_CARGO_SHIP = 0;
  public static final int LIFT_ENCODER_DEPOT = 0;
  public static final int LIFT_ENCODER_LOADING_STATION = 0;
  public static final int LIFT_ENCODER_HATCH_ROCKET_LEVEL_1 = 353065;
  public static final int LIFT_ENCODER_HATCH_ROCKET_LEVEL_2 = 752000;
  public static final int LIFT_ENCODER_HATCH_ROCKET_LEVEL_3 = 745959;
  public static final int LIFT_ENCODER_CARGO_ROCKET_LEVEL_1 = 690473;
  public static final int LIFT_ENCODER_CARGO_ROCKET_LEVEL_2 = 4000;
  public static final int LIFT_ENCODER_CARGO_ROCKET_LEVEL_3 = 785303;
  public static final int LIFT_ENCODER_ENCODER_DEADBAND = 50;
  // TargetArm
  public static final int TARGET_ARM_ENCODER_LOW = 0;
  public static final int TARGET_ARM_ENCODER_HIGH = 0;
  public static final int TARGET_ARM_ENCODER_DEPOT = 0;
  public static final int TARGET_ARM_ENCODER_LOADING_STATION = 0;
  public static final int TARGET_ARM_ENCODER_CARGO_SHIP = 0;
  public static final int TARGET_ARM_ENCODER_HATCH_ROCKET_LEVEL_1 = 122201;
  public static final int TARGET_ARM_ENCODER_HATCH_ROCKET_LEVEL_2 = 413643;
  public static final int TARGET_ARM_ENCODER_HATCH_ROCKET_LEVEL_3 = 899030;
  public static final int TARGET_ARM_ENCODER_CARGO_ROCKET_LEVEL_1 = 106346;
  public static final int TARGET_ARM_ENCODER_CARGO_ROCKET_LEVEL_2 = 798882;
  public static final int TARGET_ARM_ENCODER_CARGO_ROCKET_LEVEL_3 = 1068370;
  public static final int TARGET_ARM_ENCODER_DEADBAND = 50;
  // TargetGripper
  public static final int TARGET_GRIPPER_ENCODER_LOW = 0;
  public static final int TARGET_GRIPPER_ENCODER_HIGH = 1825;
  public static final int TARGET_GRIPPER_ENCODER_HATCH = 1450;
  public static final int TARGET_GRIPPER_ENCODER_DEADBAND = 50;

  // Motor speeds
  public static final double LIFT_SPEED = .5;
  public static final double TARGET_PULLER_SPEED = .5;
  public static final double TARGET_PUSHER_PULLER_SPEED = .5;
  public static final double TARGET_GRIPPER_SPEED = .5;
  public static final double TARGET_ARM_SPEED = .5;

}