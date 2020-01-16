/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import frc.robot.RobotMap;
import frc.robot.commands.TargetArmWithController;
import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.command.Subsystem;
import com.ctre.phoenix.motorcontrol.FeedbackDevice;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

public class TargetArm extends Subsystem {

  /*
   * get means use encoder and set means use LIFT_MOTOR
   */

  private WPI_TalonSRX targetArmMotor = new WPI_TalonSRX(RobotMap.TARGET_ARM_MOTOR);

  // Instantiates the physical limit switches, which are plugged into the DIO ports of the RIO.
  // The constructor takes in an integer that represents the port # the switch was plugged into
  private DigitalInput topLimitSwitch = new DigitalInput(RobotMap.TOP_LIM_SWITCH);
  private DigitalInput botLimitSwitch = new DigitalInput(RobotMap.BOT_LIM_SWITCH);

  private final double DEADBAND = 0.08;

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
    return topLimitSwitch.get();
  }

  public boolean getTargetArmLimitSwitchLow() {
    return botLimitSwitch.get();
  }

  public void setTargetArmDirection(double armSpeed, int targetArmTarget) {
    if (getTargetArmEncoder() <= targetArmTarget) {
      setTargetArmUp(armSpeed);
    } else {
      setTargetArmDown(armSpeed);
    }
  }

  public void setTargetArmUp(double armSpeed) {
    // The following code implements the limit switches so you can't drive up or down
    // after you've hit the top or bottom one
    // Commented out because the switches aren't in the right place mechanically
    /*if(topLimitSwitch.get() && armSpeed > 0) armSpeed = 0;
    else if(botLimitSwitch.get() && armSpeed < 0) armSpeed = 0;*/
    if(Math.abs(armSpeed) < DEADBAND) armSpeed = 0;

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
