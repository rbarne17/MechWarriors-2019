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
public class ClimbHab extends Subsystem {
  // Put methods for controlling this subsystem
  // here. Call these from Commands.
  DoubleSolenoid climbHabSolenoid = null;

  public ClimbHab() {
    climbHabSolenoid = new DoubleSolenoid(RobotMap.CLIMBHAB_SOLENOID_DEPLOY, RobotMap.CLIMBHAB_SOLENOID_RETRACT);
  }

  public boolean getClimbHabUp() {
    if (climbHabSolenoid.get() == Value.kForward) {
      return true;
    } else {
      return false;
    }

  }

  public boolean getClimbHabDown() {
    if (climbHabSolenoid.get() == Value.kReverse) {
      return true;
    } else {
      return false;
    }
  }


  public void setclimbHabUp() {
    climbHabSolenoid.set(Value.kForward);
  }

  public void setclimbHabDown() {
    climbHabSolenoid.set(Value.kReverse);
  }

  @Override
  public void initDefaultCommand() {
    // Set the default command for a subsystem here.
    // setDefaultCommand(new MySpecialCommand());

  }

}
