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
public class climbhabSolenoid2 extends Subsystem {
  // Put methods for controlling this subsystem
  // here. Call these from Commands.
  DoubleSolenoid climbhabSolenoid2 = null;

  public climbhabSolenoid2() {
    climbhabSolenoid2 = new DoubleSolenoid(RobotMap.CLIMBHAB_SOLENOID_2_DEPLOY, RobotMap.CLIMBHAB_SOLENOID_2_RETRACT);
  }

  public boolean getClimbhabSolenoid2Up() {
    if (climbhabSolenoid2.get() == Value.kForward) {
      return true;
    } else {
      return false;
    }

  }

  public boolean getClimbhabSolenoid2Down() {
    if (climbhabSolenoid2.get() == Value.kReverse) {
      return true;
    } else {
      return false;
    }
  }


  public void setClimbHabSolenoid2Up() {
    climbhabSolenoid2.set(Value.kForward);
  }

  public void setClimbHabSolenoid2Down() {
    climbhabSolenoid2.set(Value.kReverse);
  }

  @Override
  public void initDefaultCommand() {
    // Set the default command for a subsystem here.
    // setDefaultCommand(new MySpecialCommand());

  }

}
