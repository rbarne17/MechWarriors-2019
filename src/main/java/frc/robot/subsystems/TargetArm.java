/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import frc.robot.RobotMap;
import edu.wpi.first.wpilibj.command.Subsystem;
import com.ctre.phoenix.motorcontrol.FeedbackDevice;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

/**
 * Add your docs here.
 */
public class TargetArm extends Subsystem {

  /*
   * set means use encoder and get means use LIFT_MOTOR
   */

  private WPI_TalonSRX targetArmMotor = new WPI_TalonSRX(RobotMap.TARGET_ARM_MOTOR);

  public TargetArm() {
    targetArmMotor.configSelectedFeedbackSensor(FeedbackDevice.CTRE_MagEncoder_Absolute);
    targetArmMotor.setSelectedSensorPosition(0);
    targetArmMotor.set(0.0);

  }

  public int getTargetArmEncoder() {
    // Return Encoder Values Need to be fixed
    return targetArmMotor.getSelectedSensorPosition();
  }

  // Controls speed and direction of the robot.
  // -1 = full reverse; 1 = full forward

  public void resetTargetArm() {
    targetArmMotor.set(0.0);
    resetTargetArmEncoder();

  }

  private void resetTargetArmEncoder() {
    targetArmMotor.setSelectedSensorPosition(0);
  }

  @Override
  protected void initDefaultCommand() {
    // TODO Auto-generated method stub

  }

  public void setTargetArmDirection(double armSpeed, int targetArmTarget) {
    if (getTargetArmEncoder() <= targetArmTarget) {
      setTargetArmUp(armSpeed);
    } else {
      setTargetArmDown(armSpeed);
    }
  }

  public void setTargetArmUp(double armSpeed) {
    targetArmMotor.set(armSpeed);

  }

  public void setTargetArmDown(double armSpeed) {
    targetArmMotor.set(-armSpeed);

  }

}
