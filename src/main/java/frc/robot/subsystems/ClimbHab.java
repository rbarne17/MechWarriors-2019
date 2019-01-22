/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.DoubleSolenoid.Value;
import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.RobotMap;
import frc.robot.commands.ClimbHab2;

/**
 * Add your docs here.
 */
public class ClimbHab extends Subsystem {
  // Put methods for controlling this subsystem
  // here. Call these from Commands.
  DoubleSolenoid climbHabSolenoid = null;

  public ClimbHab() {
    climbHabSolenoid = new DoubleSolenoid(RobotMap.ClimbHab_Solenoid_Deploy, RobotMap.ClimbHab_Solenoid_Retract);
  }

  @Override
  public void initDefaultCommand() {
    // Set the default command for a subsystem here.
    // setDefaultCommand(new MySpecialCommand());
    setDefaultCommand(new ClimbHab2());
  }

  public void climbHabUp() {
    climbHabSolenoid.set(Value.kForward);
  }

  public void climbHabDown() {
    climbHabSolenoid.set(Value.kReverse);
  }

}
