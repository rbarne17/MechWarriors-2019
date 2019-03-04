/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.RobotMap;

/**
 * Add your docs here.
 */
public class TargetPuller extends Subsystem {
  // Put methods for controlling this subsystem
  // here. Call these from Commands.
  private WPI_TalonSRX targetPullerMotor = new WPI_TalonSRX(RobotMap.TARGET_PULLER_MOTOR);

  public void setTargetPuller(double pullerTarget) {
    targetPullerMotor.set(pullerTarget);
  }

  public void stopTargetPuller() {
    targetPullerMotor.set(0.0);
  }

  public boolean getTargetPullerPull() {
    return (targetPullerMotor.get() < 0);
  }

  @Override
  public void initDefaultCommand() {
    // Set the default command for a subsystem here.
    // setDefaultCommand(new MySpecialCommand());
  }
}
