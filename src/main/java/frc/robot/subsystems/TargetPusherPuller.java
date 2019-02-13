/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.Spark;
import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.RobotMap;

/**
 * Add your docs here.
 */
public class TargetPusherPuller extends Subsystem {
  // Put methods for controlling this subsystem
  // here. Call these from Commands.
  private Spark targetPusherPullerMotor = new Spark(RobotMap.TARGET_PUSHER_PULLER_MOTOR);
  

  public void setTargetPusherPullerPull(double pullerTarget) {
    targetPusherPullerMotor.set(pullerTarget);
  }

  public void setTargetPusherPullerPush(double pushTarget) {
    targetPusherPullerMotor.set(-pushTarget);
  }
  public void setTargetPusherPullerOff(){
    targetPusherPullerMotor.set(0.0);
  }

  @Override
  public void initDefaultCommand() {
    // Set the default command for a subsystem here.
    // setDefaultCommand(new MySpecialCommand());
  }
}
