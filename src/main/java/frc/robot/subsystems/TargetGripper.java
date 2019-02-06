/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.PWMSpeedController;
import edu.wpi.first.wpilibj.Spark;
import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.RobotMap;

/**
 * Add your docs here.
 */
public class TargetGripper extends Subsystem {
  private static final PWMSpeedController rightMotor = null;
  // Put methods for controlling this subsystem
  // here. Call these from Commands.
public final int ticksperfoot = 166;
public Spark targetGripperMotor = new Spark(RobotMap.TARGET_GRIPPER_SPARK);
  private PWMSpeedController leftMotor;

  @Override
  public void initDefaultCommand() {
    // Set the default command for a subsystem here.
    // setDefaultCommand(new MySpecialCommand());
  }public TargetGripper() {
	leftMotor.set(0.0);

  rightMotor.set(0.0);

 

  }
  public void setTargetGripperUp(double gripperSpeed){
    targetGripperMotor.set(gripperSpeed);
  }
  public void setTargetGripperDown(double gripperSpeed){
    targetGripperMotor.set(-gripperSpeed);
  }
  public boolean getTargetGripperUp(){
    return true;
  }
  public boolean getTargetGripperDown(){
    return true;
  }
  public boolean getTargetGripperHatch(){
    return true;
  }


  }


    
  }
