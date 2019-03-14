/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;

/**
 * Add your docs here.
 */
public class ClimbhabSolenoid3 extends Subsystem {
  // Put methods for controlling this subsystem
  // here. Call these from Commands.
  DoubleSolenoid ClimbhabSolenoid3 = null;
public climbhabSolenoid3() {
    climbhabSolenoid3 = new DoubleSolenoid(RobotMap.CLIMBHAB_SOLENOID_3_DEPLOY, RobotMap.CLIMBHAB_SOLENOID_3_RETRACT);
  }

  public boolean getClimbhabSolenoid3Up() {
    if (climbhabSolenoid3.get() == Value.kForward) {
      return true;
    } else {
      return false;
    }

  }

  public boolean getClimbhabSolenoid3Down() {
    if (climbhabSolenoid3.get() == Value.kReverse) {
      return true;
    } else {
      return false;
    }
  }


  public void setClimbHabSolenoid3Up() {
    climbhabSolenoid3.set(Value.kForward);
  }

  public void setClimbHabSolenoid3Down() {
    climbhabSolenoid3.set(Value.kReverse);
  }

  @Override
  public void initDefaultCommand() {
    // Set the default command for a subsystem here.
    // setDefaultCommand(new MySpecialCommand());

  }

}


  
}
