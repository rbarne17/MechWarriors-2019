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
public class DriveTrain extends Subsystem {
  // Put methods for controlling this subsystem
  // here. Call these from Commands.
  Spark leftFrontSpark = null;
  Spark leftBackSpark = null;
  Spark rightFrontSpark =  null;
  Spark rightBackSpark = null;
  
  DifferentialDrive differentialDrive = null;

  public DriveTrain(){
  //Talon
  leftFrontSpark = new Spark(RobotMap.DRIVETRAIN_LEFT_SPARK);
  leftBackSpark = new Spark(RobotMap.DRIVETRAIN_LEFT_SPARK);
  rightFrontSpark = new Spark(RobotMap.DRIVETRAIN_LEFT_SPARK);
  rightBackSpark = new Spark(RobotMap.DRIVETRAIN_LEFT_SPARK);

  SpeedControllerGroup leftMotors = new SpeedControllerGroup(leftFrontSpark, leftBackSpark);
  SpeedControllerGroup speedControllerGroup = new SpeedControllerGroup(rightFrontSpark, rightBackSpark);
  
  differentialDrive = new DifferentialDrive(leftMotors, rightMotors);
  

  


  }

  @Override
  public void initDefaultCommand() {
    // Set the default command for a subsystem here.
    // setDefaultCommand(new MySpecialCommand());
  }
}
