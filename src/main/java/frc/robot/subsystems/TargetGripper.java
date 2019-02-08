/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.Encoder;

import edu.wpi.first.wpilibj.Spark;
import edu.wpi.first.wpilibj.CounterBase.EncodingType;
import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.RobotMap;

/**
 * Add your docs here.
 */
public class TargetGripper extends Subsystem {

  // Put methods for controlling this subsystem
  // here. Call these from Commands.
  public final int ticksperfoot = 166;
  public Spark targetGripperMotor = new Spark(RobotMap.TARGET_GRIPPER_SPARK);
  private Encoder targetGripperEncoder = new Encoder(RobotMap.TARGET_GRIPPER_ENCODER_CHANNEL_1,
      RobotMap.TARGET_GRIPPER_ENCODER_CHANNEL_2, true, EncodingType.k4X);

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
    if (targetGripperEncoder.get() > RobotMap.TARGET_GRIPPER_ENCODER_HATCH_UPPER) {
      setTargetGripperDown(gripperSpeed);
    } else {
      setTargetGripperUp(gripperSpeed);
    }
  }

  public boolean getTargetGripperUp() {
    return targetGripperEncoder.get() >= RobotMap.TARGET_GRIPPER_ENCODER_UP;
  }

  public boolean getTargetGripperDown() {
    return targetGripperEncoder.get() <= 0.0;
  }

  public boolean getTargetGripperHatch() {
    int targetGripperPosition = targetGripperEncoder.get();
    return (RobotMap.TARGET_GRIPPER_ENCODER_HATCH_LOWER <= targetGripperPosition
        && targetGripperPosition <= RobotMap.TARGET_GRIPPER_ENCODER_HATCH_UPPER);
  }

}
