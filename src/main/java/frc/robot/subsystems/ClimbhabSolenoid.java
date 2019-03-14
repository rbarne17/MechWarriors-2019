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

/**
 * Add your docs here.
 */
public class climbhabSolenoid extends Subsystem {
  // Put methods for controlling this subsystem
  // here. Call these from Commands.
  DoubleSolenoid climbhabSolenoid = null;

  public climbhabSolenoid() {
    climbhabSolenoid = new DoubleSolenoid(RobotMap.CLIMBHAB_SOLENOID_DEPLOY, RobotMap.CLIMBHAB_SOLENOID_RETRACT);
  }

  public boolean getClimbhabSolenoidUp() {
    if (climbhabSolenoid.get() == Value.kForward) {
      return true;
    } else {
      return false;
    }

  }

  public boolean getClimbhabSolenoidDown() {
    if (climbhabSolenoid.get() == Value.kReverse) {
      return true;
    } else {
      return false;
    }
  }


  public void setClimbHabSolenoidUp() {
    climbhabSolenoid.set(Value.kForward);
  }

  public void setClimbHabSolenoidDown() {
    climbhabSolenoid.set(Value.kReverse);
  }

  @Override
  public void initDefaultCommand() {
    // Set the default command for a subsystem here.
    // setDefaultCommand(new MySpecialCommand());

  }

}
