/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import frc.robot.commands.ClimbHabDown;
import frc.robot.commands.ClimbHabUp;
import frc.robot.commands.TargetGripperDown;
import frc.robot.commands.TargetGripperHatch;
import frc.robot.commands.TargetGripperUp;

/**
 * Add your docs here.
 */
public class Dashboard {

    public void robotInit() {
        // subsystems display
        SmartDashboard.putData(Robot.m_drivetrain);
        SmartDashboard.putData(Robot.m_liftmechanism);
        SmartDashboard.putData(Robot.m_targetgripper);
        SmartDashboard.putData(Robot.m_climbhab);

        // commands test
        // TargetGripper
        SmartDashboard.putData("TargetGripper Up", new TargetGripperUp());
        SmartDashboard.putData("TargetGripper Down", new TargetGripperDown());
        SmartDashboard.putData("TargetGripper Hatch", new TargetGripperHatch());
        // ClimbHab
        SmartDashboard.putData("ClimbHab Up", new ClimbHabUp());
        SmartDashboard.putData("ClimbHab Down", new ClimbHabDown());

    }

    public void teleopPeriodic()

    {
        // DriveTrain
        SmartDashboard.putNumber("Percent Throttle", Robot.m_oi.getControllerDriveTrainThrottleValue());
        SmartDashboard.putNumber("Percent Rotation", Robot.m_oi.getControllerDriveTrainRotationValue());
        // SmartDashboard.putNumber("GyroHeading", Robot.m_drivetrain.getHeading());
        SmartDashboard.putNumber("ACTUAL Percent Throttle",
                Robot.m_drivetrain.scalingSpeed(Robot.m_oi.getControllerDriveTrainThrottleValue()));
        SmartDashboard.putNumber("ACTUAL Percent Rotation",
                Robot.m_drivetrain.scalingSpeed(Robot.m_oi.getControllerDriveTrainRotationValue()));

        // LiftMechanism
        SmartDashboard.putNumber("Lift Encoder", Robot.m_liftmechanism.getEncoderLift());
        SmartDashboard.putBoolean("LiftAtHome", Robot.m_liftmechanism.liftAtHome());
        SmartDashboard.putNumber("LiftControllerValue", Robot.m_oi.getControllerLiftValue());

        // TargetGripper
        SmartDashboard.putBoolean("TargetGripperDown", Robot.m_targetgripper.getTargetGripperDown());
        SmartDashboard.putBoolean("TargetGripperUp", Robot.m_targetgripper.getTargetGripperUp());
        SmartDashboard.putBoolean("TargetGripperHatch", Robot.m_targetgripper.getTargetGripperHatch());

        // ClimbHab
        // SmartDashboard.putBoolean("ClimbHabUp", Robot.m_climbhab.getClimbHabUp());
        // SmartDashboard.putBoolean("ClimbHapDown", Robot.m_climbhab.getClimbHabDown());

    }
}
