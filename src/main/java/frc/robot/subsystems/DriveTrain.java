/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;
import edu.wpi.first.wpilibj.Spark;
import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import frc.robot.RobotMap;
import frc.robot.commands.DriveArcade;
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
  //Spark 
  leftFrontSpark = new Spark(RobotMap.DRIVETRAIN_LEFT_SPARK);
  leftBackSpark = new Spark(RobotMap.DRIVETRAIN_LEFT_SPARK);
  rightFrontSpark = new Spark(RobotMap.DRIVETRAIN_LEFT_SPARK);
  rightBackSpark = new Spark(RobotMap.DRIVETRAIN_LEFT_SPARK);

    SpeedControllerGroup leftMotors = new SpeedControllerGroup(leftFrontSpark, leftBackSpark);
    SpeedControllerGroup rightMotors = new SpeedControllerGroup(rightFrontSpark, rightBackSpark);
  
  differentialDrive = new DifferentialDrive(leftMotors, rightMotors);
  

  


  }
 
  public void arcadeDrive(double moveSpeed, double rotateSpeed){
    differentialDrive.arcadeDrive(moveSpeed, rotateSpeed);
  }



  @Override
  public void initDefaultCommand() {
    // Set the default command for a subsystem here.
    // setDefaultCommand(new MySpecialCommand());
    setDefaultCommand(new DriveArcade());
  }
}
