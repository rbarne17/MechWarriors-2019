/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import frc.robot.RobotMap;
import frc.robot.commands.TargetGripperWithController;
import edu.wpi.first.wpilibj.command.Subsystem;
import com.ctre.phoenix.motorcontrol.FeedbackDevice;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

public class TargetGripper extends Subsystem {

  /*
   * get means use encoder and set means use LIFT_MOTOR
   */

  private WPI_TalonSRX targetGripperMotor = new WPI_TalonSRX(RobotMap.TARGET_GRIPPER_MOTOR);

  public TargetGripper() {
    targetGripperMotor.configSelectedFeedbackSensor(FeedbackDevice.QuadEncoder);
    stopTargetGripper();
  }

  public void initDefaultCommand() {
    setDefaultCommand(new TargetGripperWithController());
  }

  public int getTargetGripperEncoder() {
    return targetGripperMotor.getSelectedSensorPosition();
  }

  public boolean getTargetGripperLimitSwitchLow() {
    return targetGripperMotor.getSensorCollection().isRevLimitSwitchClosed();
  }

  public boolean getTargetGripperLimitSwitchHigh() {
    return targetGripperMotor.getSensorCollection().isFwdLimitSwitchClosed();
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

  public void resetTargetGripperEncoder() {
    targetGripperMotor.setSelectedSensorPosition(0);
  }

  public void stopTargetGripper() {
    targetGripperMotor.set(0.0);
  }

}
