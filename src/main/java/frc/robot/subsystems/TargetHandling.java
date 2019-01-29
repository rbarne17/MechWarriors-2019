/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.ADXRS450_Gyro;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.Spark;
import edu.wpi.first.wpilibj.CounterBase.EncodingType;
import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.RobotMap;
import frc.robot.commands.DriveWithController;

/**
 * Add your docs here.
 */
public class TargetHandling extends Subsystem {
  // Put methods for controlling this subsystem
  // here. Call these from Commands.
  public final int ticksPerFoot = 166;

  public Spark leftMotor = new Spark(RobotMap.targetHandlingMotorLeft);
  public Spark RightMotor = new Spark(RobotMap.targetHandlingMotorRight);
  public ADXRS450_Gyro gyro = new ADXRS450_Gyro();
  public Encoder leftEncoder = new Encoder(RobotMap.leftEncoderChannel1, RobotMap.leftEncoderChannel2, true,
      EncodingType.k4X);
  public Encoder rightEncoder = new Encoder(RobotMap.leftEncoderChannel1, RobotMap.leftEncoderChannel2, true,
      EncodingType.k4X);

  public TargetHandling() {

    if (gyro != null) {
      gyro.calibrate();
    }

    leftMotor.set(0.0);

    RightMotor.set(0.0);
  }

  public int getEncoderLeft() {
    return leftEncoder.get();
  }

  public int getEncoderRight() {
    return rightEncoder.get();
  }

  public void initDefaultCommand() {

    setDefaultCommand(new DriveWithController());
  }

}
