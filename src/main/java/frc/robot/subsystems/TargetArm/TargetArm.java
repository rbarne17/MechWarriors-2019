/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems.TargetArm;

/**
 * Add your docs here.
 */
public class TargetArm {
}
package frc.robot.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.RobotMap;
import frc.robot.commands.LiftWithController;
import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.Spark;
import edu.wpi.first.wpilibj.CounterBase.EncodingType;

/**
 * Add your docs here.
 */
public class TargetArm extends Subsystem {
  // Put methods for controlling this subsystem
  // here. Call these from Commands.
  public final double m_ticksPerFoot = 0.15;
  public final int m_ticksPerInch = 15;
public method getTargetArmUp
Public method getTargetArmDown
public method setTargetArmUp
public method setTargetArmDown

/*set means use encoder and get means use LIFT_MOTOR
*/

  private Spark liftMotor = new Spark(RobotMap.LIFT_MOTOR);
  private DigitalInput liftLimitSwitchHome = new DigitalInput(RobotMap.LIFT_MECHANISM_SWITCH_HOME);
  private Encoder liftEncoder = new Encoder(RobotMap.LIFT_ENCODER_CHANNEL_1, RobotMap.LIFT_ENCODER_CHANNEL_2, true,
      EncodingType.k4X);

  public LiftMechanism() {

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
    return !liftLimitSwitchHome.get();
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
