/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.RobotMap;
import frc.robot.commands.LiftWithController;

import com.ctre.phoenix.motorcontrol.FeedbackDevice;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.Spark;
import edu.wpi.first.wpilibj.CounterBase.EncodingType;

/**
 * Add your docs here.
 */
public class Lift extends Subsystem {
  // Put methods for controlling this subsystem
  // here. Call these from Commands.
  private WPI_TalonSRX liftMotor = new WPI_TalonSRX(RobotMap.LIFT_MECHANISM_MOTOR);

  public Lift() {
    liftMotor.configSelectedFeedbackSensor(FeedbackDevice.CTRE_MagEncoder_Absolute);
    liftMotor.setSelectedSensorPosition(0);
    liftMotor.set(0.0);

  }

  public int getEncoderLift() {
    // Return Encoder Values Need to be fixed
    return liftMotor.getSelectedSensorPosition();
  }
  public void setLiftUp(double liftSpeed) {
    liftMotor.set(liftSpeed);
  }
  public void setLiftDown(double liftSpeed) {
    liftMotor.set(-liftSpeed);
  }

  public boolean liftAtHome() {
    // limit switches return false when triggered
    return (getEncoderLift() <= RobotMap.LIFT_MECHANISM_ENCODER_HOME);
  }

  public void liftReset() {
    liftMotor.set(0);
    liftMotor.setSelectedSensorPosition(0);
  }

  private void encoderReset() {
    
    liftMotor.setSelectedSensorPosition(0);
  }

  @Override
  protected void initDefaultCommand() {
    // TODO Auto-generated method stub
    setDefaultCommand(new LiftWithController());

  }

}
