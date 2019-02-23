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
  private DigitalInput liftLimitSwitchHome = new DigitalInput(RobotMap.LIFT_LIMIT_SWITCH_HOME);
  private boolean liftDirectionUp;

  public Lift() {
    liftMotor.configSelectedFeedbackSensor(FeedbackDevice.CTRE_MagEncoder_Absolute);
    liftMotor.setSelectedSensorPosition(0);
    liftMotor.set(0.0);

  }

  public int getLiftEncoder() {
    // Return Encoder Values Need to be fixed
    return liftMotor.getSelectedSensorPosition();
  }

  public boolean getLiftLimitSwitchHome() {
    return liftLimitSwitchHome.get();
  }

  public boolean getLiftDirectionUp() {
    // true for Up, false for Down
    return liftDirectionUp;
  }

  public void setLiftDirection(double liftSpeed, int liftTarget) {
    if (getLiftEncoder() > liftTarget) {
      liftDirectionUp = true;
      setLiftUp(liftSpeed);
    } else {
      liftDirectionUp = false;
      setLiftDown(liftSpeed);
    }
  }

  public void setLiftUp(double liftSpeed) {
    liftMotor.set(liftSpeed);
  }

  public void setLiftDown(double liftSpeed) {
    liftMotor.set(-liftSpeed);
  }

  public void resetLift() {
    liftMotor.set(0);
    liftMotor.setSelectedSensorPosition(0);
  }

  public void stopLift() {
    liftMotor.set(0);
  }

  @Override
  protected void initDefaultCommand() {
    // TODO Auto-generated method stub
    setDefaultCommand(new LiftWithController());

  }

}
