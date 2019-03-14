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
  public static final int DRIVETRAIN_LEFT_ENCODER_CHANNEL_1 = 0;
  public static final int DRIVETRAIN_LEFT_ENCODER_CHANNEL_2 = 1;
  public static final int DRIVETRAIN_RIGHT_ENCODER_CHANNEL_1 = 2;
  public static final int DRIVETRAIN_RIGHT_ENCODER_CHANNEL_2 = 3;
  public static final int LIFT_LIMIT_SWITCH_LOW = 4;
  public static final int LIFT_LIMIT_SWITCH_HIGH = 5;
  public static final int TARGET_ARM_MOTOR_LIMIT_SWITCH_LOW = 6;
  public static final int TARGET_ARM_MOTOR_LIMIT_SWITCH_HIGH = 7;
  public static final int TARGET_ARM_LIMIT_SWITCH_LOW = 8;
  public static final int TARGET_ARM_LIMIT_SWITCH_HIGH = 9;
  public static final int TARGET_GRIPPER_LIMIT_SWITCH_LOW = 0;
  public static final int TARGET_GRIPPER_LIMIT_SWITCH_HIGH = 0;

  // Solenoid valves
  public static final int CLIMBHAB_SOLENOID_1_DEPLOY = 0;
  public static final int CLIMBHAB_SOLENOID_1_RETRACT = 1;
  public static final int CLIMBHAB_SOLENOID_2_DEPLOY = 0;
  public static final int CLIMBHAB_SOLENOID_2_RETRACT = 0;
  public static final int TARGET_INTAKE_DROP_DEPLOY = 0;
  public static final int TARGET_INTAKE_DROP_RETRACT = 0;

  // CAN
  public static final int CLIMBHAB_SOLENOID = 1;
  public static final int POWER_DISTRIBUTION_BOARD = 2;
  public static final int LIFT_MECHANISM_MOTOR = 5;
  public static final int TARGET_ARM_MOTOR = 6;
  public static final int TARGET_GRIPPER_MOTOR = 7;
  public static final int TARGET_PULLER_MOTOR = 8;
  public static final int TARGET_PUSHER_PULLER_MOTOR = 9;

  // Encoder values
  public static final int TARGET_ARM_ENCODER_HIGH = 0;
  public static final int TARGET_ARM_ENCODER_LOW = 0;
  public static final int LIFT_ENCODER_CARGO_SHIP = 0;
  public static final int LIFT_ENCODER_DEPOT = 0;
  public static final int LIFT_ENCODER_LOADING_STATION = 0;
  public static final int LIFT_ENCODER_ROCKET_LEVEL_1 = 0;
  public static final int LIFT_ENCODER_ROCKET_LEVEL_2 = 0;
  public static final int LIFT_ENCODER_ROCKET_LEVEL_3 = 0;
  public static final int TARGET_GRIPPER_ENCODER_HIGH = 0;
  public static final int TARGET_GRIPPER_ENCODER_LOW = 0;
  public static final int TARGET_GRIPPER_ENCODER_HATCH_LOW = 0;
  public static final int TARGET_GRIPPER_ENCODER_HATCH_HIGH = 0;
  public static final int TARGET_GRIPPER_ENCODER_DEPOT = 0;
  public static final int TARGET_GRIPPER_ENCODER_LOADING_STATION = 0;
  public static final int TARGET_GRIPPER_ENCODER_CARGO_SHIP = 0;
  public static final int TARGET_GRIPPER_ENCODER_ROCKET_LEVEL_1 = 0;
  public static final int TARGET_GRIPPER_ENCODER_ROCKET_LEVEL_2 = 0;
  public static final int TARGET_GRIPPER_ENCODER_ROCKET_LEVEL_3 = 0;
  public static final int TARGET_ARM_ENCODER_DEPOT = 0;
  public static final int TARGET_ARM_ENCODER_LOADING_STATION = 0;
  public static final int TARGET_ARM_ENCODER_CARGO_SHIP = 0;
  public static final int TARGET_ARM_ENCODER_ROCKET_LEVEL_1 = 0;
  public static final int TARGET_ARM_ENCODER_ROCKET_LEVEL_2 = 0;
  public static final int TARGET_ARM_ENCODER_ROCKET_LEVEL_3 = 0;

  // Motor speeds
  public static final double LIFT_SPEED = .5;
  public static final double TARGET_PULLER_SPEED = .5;
  public static final double TARGET_PUSHER_PULLER_SPEED = .5;
  public static final double TARGET_GRIPPER_SPEED = .5;
  public static final double TARGET_ARM_SPEED = .5;

}