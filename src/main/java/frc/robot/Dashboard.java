/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import frc.robot.commands.PositionClimbHab;
import frc.robot.commands.PositionLift;
import frc.robot.commands.PositionTargetArm;
import frc.robot.commands.PositionTargetGripper;
import frc.robot.commands.PositionTargetPuller;
import frc.robot.commands.PositionTargetPusherPuller;

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
                SmartDashboard.putData(Robot.m_eyes);

                // Lift
                SmartDashboard.putData("Lift Cargo Ship", new PositionLift(RobotMap.LIFT_ENCODER_CARGO_SHIP));
                SmartDashboard.putData("Lift Depot", new PositionLift(RobotMap.LIFT_ENCODER_DEPOT));
                SmartDashboard.putData("Lift Loading Station", new PositionLift(RobotMap.LIFT_ENCODER_LOADING_STATION));
                SmartDashboard.putData("Lift Rocket Level 1", new PositionLift(RobotMap.LIFT_ENCODER_ROCKET_LEVEL_1));
                SmartDashboard.putData("Lift Rocket Level 2", new PositionLift(RobotMap.LIFT_ENCODER_ROCKET_LEVEL_2));
                SmartDashboard.putData("Lift Rocket Level 3", new PositionLift(RobotMap.LIFT_ENCODER_ROCKET_LEVEL_3));

                // TargetArm
                SmartDashboard.putData("TargetArm Up", new PositionTargetArm(RobotMap.TARGET_ARM_ENCODER_HIGH));
                SmartDashboard.putData("TargetArm Down", new PositionTargetArm(RobotMap.TARGET_ARM_ENCODER_LOW));

                // TargetGripper
                SmartDashboard.putData("TargetGripper Up",
                                new PositionTargetGripper(RobotMap.TARGET_GRIPPER_ENCODER_HIGH));
                SmartDashboard.putData("TargetGripper Down",
                                new PositionTargetGripper(RobotMap.TARGET_GRIPPER_ENCODER_LOW));
                SmartDashboard.putData("TargetGripper Hatch", new PositionTargetGripper(
                                RobotMap.TARGET_GRIPPER_ENCODER_HATCH_LOW, RobotMap.TARGET_GRIPPER_ENCODER_HIGH));

                // TargetPuller
                SmartDashboard.putData("TargetPuller Pull", new PositionTargetPuller(1.0));

                // TargetPusherPuller
                SmartDashboard.putData("TargetPusherPuller Push", new PositionTargetPusherPuller(1.0,true));
                SmartDashboard.putData("TargetPusherPuller Pull", new PositionTargetPusherPuller(1.0,true));

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
                SmartDashboard.putNumber("LiftControllerValue", Robot.m_oi.getControllerLiftValue());
                SmartDashboard.putNumber("Lift Encoder", Robot.m_lift.getLiftEncoder());
                SmartDashboard.putBoolean("Lift Low", Robot.m_lift.getLiftLimitSwitchLow());
                SmartDashboard.putBoolean("Lift Cargo Ship", Robot.m_lift.getLiftEncoder() == RobotMap.LIFT_ENCODER_CARGO_SHIP);
                SmartDashboard.putBoolean("Lift Depot", Robot.m_lift.getLiftEncoder() == RobotMap.LIFT_ENCODER_DEPOT);
                SmartDashboard.putBoolean("Lift Loading Station", Robot.m_lift.getLiftEncoder() == RobotMap.LIFT_ENCODER_LOADING_STATION);
                SmartDashboard.putBoolean("Lift Rocket Level 1", Robot.m_lift.getLiftEncoder() == RobotMap.LIFT_ENCODER_ROCKET_LEVEL_1);
                SmartDashboard.putBoolean("Lift Rocket Level 2", Robot.m_lift.getLiftEncoder() == RobotMap.LIFT_ENCODER_ROCKET_LEVEL_2);
                SmartDashboard.putBoolean("Lift Rocket Level 3", Robot.m_lift.getLiftEncoder() == RobotMap.LIFT_ENCODER_ROCKET_LEVEL_3);
                

                // TargetGripper
                SmartDashboard.putBoolean("TargetGripperDown", Robot.m_targetgripper.getTargetGripperLimitSwitchLow());
                SmartDashboard.putBoolean("TargetGripperUp", Robot.m_targetgripper.getTargetGripperLimitSwitchHigh());
                SmartDashboard.putBoolean("TargetGripperHatch", (Robot.m_targetgripper
                                .getTargetGripperEncoder() >= RobotMap.TARGET_GRIPPER_ENCODER_HATCH_LOW
                                && Robot.m_targetgripper
                                                .getTargetGripperEncoder() <= RobotMap.TARGET_GRIPPER_ENCODER_HATCH_HIGH));

        }
}
