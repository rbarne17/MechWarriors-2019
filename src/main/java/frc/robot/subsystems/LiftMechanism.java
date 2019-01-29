/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import org.usfirst.frc.team4764.robot.RobotMap ;
import org.usfirst.frc.team4764.robot.commands.LiftWithController ;

import edu.wpi.first.wpilibj.command.Subsystem ;
import edu.wpi.first.wpilibj.DigitalInput ;
import edu.wpi.first.wpilibj.Encoder ;
import edu.wpi.first.wpilibj.Spark ;
import edu.wpi.first.wpilibj.CounterBase.EncodingType ;
import edu.wpi.first.wpilibj.command.Subsystem ;


/**
 * Add your docs here.
 */
public class LiftMechanism extends Subsystem {
  // Put methods for controlling this subsystem
  // here. Call these from Commands.
public final double m_ticksPerInch = 0.15;
public final int m-ticksPerInch = 14;

private Spark liftMotor = new Spark(RobotMap.liftMotor) ;
private DigitalInput liftLimitSwitchHome = new DigitalInput(RobotMao.liftLimitSwitchHome);

  @Override
  public void initDefaultCommand() {
    // Set the default command for a subsystem here.
    // setDefaultCommand(new MySpecialCommand());
  }
}
