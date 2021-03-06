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

public class TargetPusherPuller extends Subsystem {

  private WPI_TalonSRX targetPusherPullerMotor = new WPI_TalonSRX(RobotMap.TARGET_PUSHER_PULLER_MOTOR);

  public void setTargetPusherPullerPull(double pullerTarget) {
    targetPusherPullerMotor.set(pullerTarget);
  }

  public void setTargetPusherPullerPush(double pushTarget) {
    targetPusherPullerMotor.set(-pushTarget);
  }

  public void stopTargetPusherPuller() {
    targetPusherPullerMotor.set(0.0);
  }

  public boolean getTargetPusherPullerPush() {
    return (targetPusherPullerMotor.get() > 0);
  }

  public boolean getTargetPusherPullerPull() {
    return (targetPusherPullerMotor.get() < 0);
  }

  @Override
  public void initDefaultCommand() {
  }
}
