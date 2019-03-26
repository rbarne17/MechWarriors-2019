/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import frc.robot.RobotMap;
import frc.robot.commands.TargetArmWithController;
import edu.wpi.first.wpilibj.command.Subsystem;
import com.ctre.phoenix.motorcontrol.FeedbackDevice;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

public class TargetArm extends Subsystem {

  /*
   * get means use encoder and set means use LIFT_MOTOR
   */

  private WPI_TalonSRX targetArmMotor = new WPI_TalonSRX(RobotMap.TARGET_ARM_MOTOR);

  public TargetArm() {
    targetArmMotor.configSelectedFeedbackSensor(FeedbackDevice.QuadEncoder);
    stopTargetArm();
  }

  protected void initDefaultCommand() {
    setDefaultCommand(new TargetArmWithController());
  }

  public int getTargetArmEncoder() {
    return targetArmMotor.getSelectedSensorPosition();
  }

  public boolean getTargetArmLimitSwitchHigh() {
    return targetArmMotor.getSensorCollection().isFwdLimitSwitchClosed();
  }

  public boolean getTargetArmLimitSwitchLow() {
    return targetArmMotor.getSensorCollection().isRevLimitSwitchClosed();
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

  public void resetTargetArmEncoder() {
    targetArmMotor.setSelectedSensorPosition(0);
  }

  public void stopTargetArm() {
    targetArmMotor.set(0.0);
  }

}
