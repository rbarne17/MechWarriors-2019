/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/


package frc.robot.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.RobotMap;
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


/*set means use encoder and get means use LIFT_MOTOR
*/

  private WPI_TalonSRX targetArmMotor = new WPI_TalonSRX(RobotMap.TARGET_ARM_MOTOR);
  private Encoder targetArmEncoder = new Encoder(RobotMap.TARGET_ARM_ENCODER_CHANNEL_1, RobotMap.TARGET_ARM_ENCODER_CHANNEL_2, true,
      EncodingType.k4X);

  public TargetArm() {

    targetArmMotor.set(0.0);

  }

  public int getTargetArmEncoder() {
    // Return Encoder Values Need to be fixed
    return targetArmEncoder.get();
  }

  // Controls speed and direction of the robot.
  // -1 = full reverse; 1 = full forward
  public void targetArmLow(double speed) {
    targetArmMotor.set(speed);

  }

  public void targetArmAdjust(double speed) {
    targetArmMotor.set(speed);

  }

  public boolean targetArmAtHome() {
    // limit switches return false when triggered
    return true;
  }

  public void reset() {
    targetArmAdjust(0.0);
    targetArmEncoderReset();

  }

  private void targetArmEncoderReset() {
    targetArmEncoder.reset();
  }

  @Override
  protected void initDefaultCommand() {
    // TODO Auto-generated method stub

  }
  public boolean getTargetArmUp () {
    if (getTargetArmEncoder () >= RobotMap.TARGET_ARM_ENCODER_UP) {
      return true;
    } else {
      return false;
    }
    }
    public boolean getTargetArmDown () { 
    if (getTargetArmEncoder() <= RobotMap.TARGET_ARM_ENCODER_DOWN) {
      return true;
    } else {
      return false;
    }
    }
    public void setTargetArmUp(double armSpeed) {
    armSpeedMotor.set(armSpeed);
    
    }
    public void setTargetArmDown(double armSpeed) {
    armSpeedMotor.set(armSpeed);
    
    }

}
