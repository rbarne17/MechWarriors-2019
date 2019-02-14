/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.RobotMap;

/**
 * Add your docs here.
 */
public class TargetGripper extends Subsystem {
  // Put methods for controlling this subsystem
  // here. Call these from Commands.
  public final int ticksperfoot = 166;
  private WPI_TalonSRX targetGripperMotor = new WPI_TalonSRX(RobotMap.TARGET_GRIPPER_MOTOR);
  private Encoder targetGripperEncoder = new Encoder(RobotMap.TARGET_GRIPPER_ENCODER_CHANNEL_1,
      RobotMap.TARGET_GRIPPER_ENCODER_CHANNEL_2);

  @Override
  public void initDefaultCommand() {
    // Set the default command for a subsystem here.
    // setDefaultCommand(new MySpecialCommand());
  }

  public TargetGripper() {
    targetGripperMotor.set(0.0);
  }

  public void setTargetGripperUp(double gripperSpeed) {
    targetGripperMotor.set(gripperSpeed);
  }

  public void setTargetGripperDown(double gripperSpeed) {
    targetGripperMotor.set(-gripperSpeed);
  }

  public void setTargetGripperHatch(double gripperSpeed) {
    if (getTargetGripperEncoder() < RobotMap.TARGET_GRIPPER_ENCODER_HATCH_LOWER) {
      setTargetGripperUp(gripperSpeed);
    } else {
      setTargetGripperDown(gripperSpeed);
    }
  }

  public boolean getTargetGripperUp() {
    if (getTargetGripperEncoder() >= RobotMap.TARGET_GRIPPER_ENCODER_UP) {
      return true;
    } else {
      return false;
    }
  }

  public boolean getTargetGripperDown() {
    if (getTargetGripperEncoder() <= RobotMap.TARGET_GRIPPER_ENCODER_DOWN) {
      return true;
    } else {
      return false;
    }
  }

  public boolean getTargetGripperHatch() {
    if (getTargetGripperEncoder() >= RobotMap.TARGET_GRIPPER_ENCODER_HATCH_LOWER
        && getTargetGripperEncoder() <= RobotMap.TARGET_GRIPPER_ENCODER_HATCH_UPPER) {
      return true;
    } else {
      return false;
    }
  }

  public int getTargetGripperEncoder() {
    return targetGripperEncoder.get();

  }

}
