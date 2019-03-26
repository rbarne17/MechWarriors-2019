/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import frc.robot.RobotMap;
import frc.robot.commands.LiftWithController;
import edu.wpi.first.wpilibj.command.Subsystem;
import com.ctre.phoenix.motorcontrol.FeedbackDevice;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

public class Lift extends Subsystem {

  /*
   * get means use encoder and set means use LIFT_MOTOR
   */

  private WPI_TalonSRX liftMotor = new WPI_TalonSRX(RobotMap.LIFT_MECHANISM_MOTOR);

  public Lift() {
    liftMotor.configSelectedFeedbackSensor(FeedbackDevice.QuadEncoder);
    stopLift();
  }

  protected void initDefaultCommand() {
    setDefaultCommand(new LiftWithController());
  }

  public int getLiftEncoder() {
    return liftMotor.getSelectedSensorPosition();
  }

  public boolean getLiftLimitSwitchHigh() {
    return liftMotor.getSensorCollection().isFwdLimitSwitchClosed();
  }

  public boolean getLiftLimitSwitchLow() {
    return liftMotor.getSensorCollection().isRevLimitSwitchClosed();
  }

  public void setLiftDirection(double liftSpeed, int liftTarget) {
    if (getLiftEncoder() > liftTarget) {
      setLiftUp(liftSpeed);
    } else {
      setLiftDown(liftSpeed);
    }
  }

  public void setLiftUp(double liftSpeed) {
    liftMotor.set(liftSpeed);
  }

  public void setLiftDown(double liftSpeed) {
    liftMotor.set(-liftSpeed);
  }

  public void resetLiftEncoder() {
    liftMotor.setSelectedSensorPosition(0);
  }

  public void stopLift() {
    liftMotor.set(0);
  }

}
