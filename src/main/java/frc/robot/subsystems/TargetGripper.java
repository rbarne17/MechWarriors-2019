/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.FeedbackDevice;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.RobotMap;
import frc.robot.commands.TargetGripperWithController;

/**
 * Add your docs here.
 */
public class TargetGripper extends Subsystem {

  private WPI_TalonSRX targetGripperMotor = new WPI_TalonSRX(RobotMap.TARGET_GRIPPER_MOTOR);
  private boolean targetGripperDirectionUp;
  private boolean targetGripperDirectionDown;
  private DigitalInput targetGripperLimitSwitchLow = new DigitalInput(RobotMap.TARGET_GRIPPER_LIMIT_SWITCH_LOW);
  private DigitalInput targetGripperLimitSwitchHigh = new DigitalInput(RobotMap.TARGET_GRIPPER_LIMIT_SWITCH_HIGH);

  public boolean getTargetGripperDirectionUp() {
    return targetGripperDirectionUp;
  }

  public boolean getTargetGripperDirectionDown() {
    return targetGripperDirectionDown;
  }

  public boolean getTargetGripperLimitSwitchLow() {
    return targetGripperLimitSwitchLow.get();

  }

  public boolean getTargetGripperLimitSwitchHigh() {
    return targetGripperLimitSwitchHigh.get();
  }

  @Override
  public void initDefaultCommand() {
    // Set the default command for a subsystem here.
    // setDefaultCommand(new MySpecialCommand());
    setDefaultCommand(new TargetGripperWithController());
  }

  public TargetGripper() {
    targetGripperMotor.set(-.25);
    targetGripperMotor.configSelectedFeedbackSensor(FeedbackDevice.QuadEncoder);
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
    targetGripperDirectionUp = true;
    targetGripperDirectionDown = !targetGripperDirectionUp;
  }

  public void setTargetGripperDown(double gripperSpeed) {
    targetGripperMotor.set(-gripperSpeed);
    targetGripperDirectionDown = true;
    targetGripperDirectionUp = !targetGripperDirectionDown;
  }

  public int getTargetGripperEncoder() {

    return targetGripperMotor.getSelectedSensorPosition();

  }

  public void stopTargetGripper() {

    targetGripperMotor.set(0.0);
    targetGripperMotor.setSelectedSensorPosition(0);
    if (getTargetGripperLimitSwitchLow()) {
      resetTargetGripperEncoder();
    }
  }

  public void resetTargetGripperEncoder() {
    targetGripperMotor.setSelectedSensorPosition(0);

  }
}
