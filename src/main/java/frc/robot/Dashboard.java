/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import frc.robot.commands.PositionClimbHab;
import frc.robot.commands.PositionTargetGripper;

/**
 * Add your docs here.
 */
public class Dashboard {

    public void robotInit() {
        // subsystems display
        SmartDashboard.putData(Robot.m_drivetrain);
        SmartDashboard.putData(Robot.m_lift);
        SmartDashboard.putData(Robot.m_targetgripper);
        SmartDashboard.putData(Robot.m_targetarm);
        SmartDashboard.putData(Robot.m_climbhab);

        // TargetGripper
        SmartDashboard.putData("TargetGripper Up", new PositionTargetGripper(RobotMap.TARGET_GRIPPER_ENCODER_HIGH));
        SmartDashboard.putData("TargetGripper Down", new PositionTargetGripper(RobotMap.TARGET_GRIPPER_ENCODER_LOW));
        SmartDashboard.putData("TargetGripper Hatch", new PositionTargetGripper(
                RobotMap.TARGET_GRIPPER_ENCODER_HATCH_LOW, RobotMap.TARGET_GRIPPER_ENCODER_HIGH));
        // ClimbHab
        SmartDashboard.putData("ClimbHab Up", new PositionClimbHab(true));
        SmartDashboard.putData("ClimbHab Down", new PositionClimbHab(false));

    }

    public void teleopPeriodic()

    {
        // DriveTrain
        SmartDashboard.putNumber("Percent Throttle", Robot.m_oi.getControllerDriveTrainThrottleValue());
        SmartDashboard.putNumber("Percent Rotation", Robot.m_oi.getControllerDriveTrainRotationValue());
        SmartDashboard.putNumber("ACTUAL Percent Throttle",
                Robot.m_drivetrain.scalingSpeed(Robot.m_oi.getControllerDriveTrainThrottleValue()));
        SmartDashboard.putNumber("ACTUAL Percent Rotation",
                Robot.m_drivetrain.scalingSpeed(Robot.m_oi.getControllerDriveTrainRotationValue()));

        // Lift
        SmartDashboard.putNumber("Lift Encoder", Robot.m_lift.getLiftEncoder());
        SmartDashboard.putBoolean("LiftAtLow", Robot.m_lift.getLiftLimitSwitchLow());
        SmartDashboard.putNumber("LiftControllerValue", Robot.m_oi.getControllerLiftValue());

        // TargetGripper
        SmartDashboard.putBoolean("TargetGripperDown", Robot.m_targetgripper.getTargetGripperLimitSwitchLow());
        SmartDashboard.putBoolean("TargetGripperUp", Robot.m_targetgripper.getTargetGripperLimitSwitchHigh());
        SmartDashboard.putBoolean("TargetGripperHatch",
                (Robot.m_targetgripper.getTargetGripperEncoder() >= RobotMap.TARGET_GRIPPER_ENCODER_HATCH_LOW
                        && Robot.m_targetgripper
                                .getTargetGripperEncoder() <= RobotMap.TARGET_GRIPPER_ENCODER_HATCH_HIGH));

    }
}
