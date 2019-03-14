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
public class TargetIntakeDrop extends Subsystem {
  // Put methods for controlling this subsystem
  // here. Call these from Commands.
   DoubleSolenoid TargetIntakeDropSolenoid = null;
public TargetIntakeDrop() {
    TargetIntakeDropSolenoid = new DoubleSolenoid(RobotMap.TARGET_INTAKE_DROP_DEPLOY, RobotMap.TARGET_INTAKE_DROP_RETRACT);
  }

  public boolean getTargetIntakeDropUp() {
    if (TargetIntakeDropSolenoid.get() == Value.kForward) {
      return true;
    } else {
      return false;
    }

  }

  public boolean getTargetIntakeDropDown() {
    if (TargetIntakeDropSolenoid.get() == Value.kReverse) {
      return true;
    } else {
      return false;
    }
  }


  public void setTargetIntakeDropUp() {
    TargetIntakeDropSolenoid.set(Value.kForward);
  }

  public void setTargetIntakeDropDown() {
    TargetIntakeDropSolenoid.set(Value.kReverse);
  }


  @Override
  public void initDefaultCommand() {
    // Set the default command for a subsystem here.
    // setDefaultCommand(new MySpecialCommand());
  }
}
