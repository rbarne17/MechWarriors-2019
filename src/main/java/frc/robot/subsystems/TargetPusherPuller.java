\/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 * Add your docs here.
 */
public class TargetPusherPuller extends Subsystem {
  // Put methods for controlling this subsystem
  // here. Call these from Commands.
  private Spark liftMotor = new Spark(RobotMap.LIFT_MOTOR);
  private DigitalInput liftLimitSwitchHome = new DigitalInput(RobotMap.LIFT_MECHANISM_SWITCH_HOME);
  // private Encoder liftEncoder = new Encoder(RobotMap.LIFT_ENCODER_CHANNEL_1,
  // RobotMap.LIFT_ENCODER_CHANNEL_2, true,
  // EncodingType.k4X);

  public void setTargetPusherPullerPull(double pullerTarget) {

  }

  public void setTargetPusherPullerPush(double pushTarget) {

  }

  @Override
  public void initDefaultCommand() {
    // Set the default command for a subsystem here.
    // setDefaultCommand(new MySpecialCommand());
  }
}
