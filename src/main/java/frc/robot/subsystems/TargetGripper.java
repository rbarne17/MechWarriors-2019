/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.FeedbackDevice;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.RobotMap;

/**
 * Add your docs here.
 */
public class TargetGripper extends Subsystem {

  private WPI_TalonSRX targetGripperMotor = new WPI_TalonSRX(RobotMap.TARGET_GRIPPER_MOTOR);

  @Override
  public void initDefaultCommand() {
    // Set the default command for a subsystem here.
    // setDefaultCommand(new MySpecialCommand());
  }

  public TargetGripper() {
    targetGripperMotor.set(0.0);
    targetGripperMotor.configSelectedFeedbackSensor(FeedbackDevice.CTRE_MagEncoder_Absolute);
    targetGripperMotor.setSelectedSensorPosition(0);
  }

  public void setTargetGripperDirection(double gripperSpeed, int targetGripperTarget) {
    if (getTargetGripperEncoder() < targetGripperTarget) {
      setTargetGripperUp(gripperSpeed);
    } else {
      setTargetGripperDown(gripperSpeed);
    }
  }

  public void setTargetGripperUp(double gripperSpeed) {
    targetGripperMotor.set(gripperSpeed);
  }

  public void setTargetGripperDown(double gripperSpeed) {
    targetGripperMotor.set(-gripperSpeed);
  }

  public int getTargetGripperEncoder() {

    return targetGripperMotor.getSelectedSensorPosition();

  }

  public void targetGripperReset() {

    targetGripperMotor.set(0.0);
    targetGripperMotor.setSelectedSensorPosition(0);

  }

}
