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

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.PWMSpeedController;
import edu.wpi.first.wpilibj.CounterBase.EncodingType;

/**
 * Add your docs here.
 */
public class TargetArm extends Subsystem {
  private static final PWMSpeedController armSpeedMotor = null;
// Put methods for controlling this subsystem
  // here. Call these from Commands.
  public final double m_ticksPerFoot = 0.15;
  public final int m_ticksPerInch = 15;
public void getTargetArmUp (double armSpeed) {
armSpeedMotor.set(armSpeed);

}
public void getTargetArmDown (double armSpeed) {
armSpeedMotor.set(armSpeed);
}
public void setTargetArmUp(double armSpeed) {
armSpeedMotor.set(armSpeed);

}
public void setTargetArmDown(double armSpeed) {
armSpeedMotor.set(armSpeed);

}

/*set means use encoder and get means use LIFT_MOTOR
*/

  private WPI_TalonSRX liftMotor = new WPI_TalonSRX(RobotMap.TARGET_ARM_MOTOR);
  private Encoder liftEncoder = new Encoder(RobotMap.TARGET_ARM_ENCODER_CHANNEL_1, RobotMap.TARGET_ARM_ENCODER_CHANNEL_2, true,
      EncodingType.k4X);

  public TargetArm() {

    liftMotor.set(0.0);

  }

  public int getEncoderLift() {
    // Return Encoder Values Need to be fixed
    return liftEncoder.get();
  }

  // Controls speed and direction of the robot.
  // -1 = full reverse; 1 = full forward
  public void LiftLow(double speed) {
    liftMotor.set(speed);

  }

  public void liftAdjust(double speed) {
    liftMotor.set(speed);

  }

  public boolean liftAtHome() {
    // limit switches return false when triggered
    return true;
  }

  public void reset() {
    liftAdjust(0.0);
    encoderReset();

  }

  private void encoderReset() {
    liftEncoder.reset();
  }

  @Override
  protected void initDefaultCommand() {
    // TODO Auto-generated method stub
    setDefaultCommand(new LiftWithController());

  }

}
