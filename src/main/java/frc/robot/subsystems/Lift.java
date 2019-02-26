/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.RobotMap;
import frc.robot.commands.LiftWithController;

import com.ctre.phoenix.motorcontrol.FeedbackDevice;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

/**
 * Add your docs here.
 */
public class Lift extends Subsystem {
  // Put methods for controlling this subsystem
  // here. Call these from Commands.
  private WPI_TalonSRX liftMotor = new WPI_TalonSRX(RobotMap.LIFT_MECHANISM_MOTOR);
  private DigitalInput liftLimitSwitchLow = new DigitalInput(RobotMap.LIFT_LIMIT_SWITCH_LOW);
  private DigitalInput liftLimitSwitchHigh = new DigitalInput(RobotMap.LIFT_LIMIT_SWITCH_HIGH);
  private boolean liftDirectionUp;
  private boolean liftDirectionDown;

  public Lift() {
    liftMotor.configSelectedFeedbackSensor(FeedbackDevice.CTRE_MagEncoder_Absolute);
    stopLiftMotor();
    resetLiftEncoder();

  }

  public int getLiftEncoder() {
    // Return Encoder Values Need to be fixed
    return liftMotor.getSelectedSensorPosition();
  }

  public boolean getLiftLimitSwitchLow() {
    return liftLimitSwitchLow.get();
  }

  public boolean getLiftLimitSwitchHigh() {
    return liftLimitSwitchHigh.get();
  }

  public boolean getLiftDirectionUp() {
    // true for Up, false for Down
    return liftDirectionUp;
  }

  public boolean getLiftDirectionDown() {
    return liftDirectionDown;
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
    liftDirectionUp = true;
    liftDirectionDown = !liftDirectionUp;
  }

  public void setLiftDown(double liftSpeed) {
    liftMotor.set(-liftSpeed);
    liftDirectionDown = true;
    liftDirectionUp = !liftDirectionDown;

  }

  public void resetLiftEncoder() {
    liftMotor.setSelectedSensorPosition(0);
  }

  public void stopLiftMotor() {
    liftMotor.set(0);
    if (getLiftLimitSwitchLow()) {
      resetLiftEncoder();
    }
  }

  @Override
  protected void initDefaultCommand() {
    // TODO Auto-generated method stub
    setDefaultCommand(new LiftWithController());

  }

}
