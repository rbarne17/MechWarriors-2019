/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import frc.robot.commands.ClimbDownHab2;
import frc.robot.commands.ClimbUpHab2;
import frc.robot.commands.LoadCargoDepot;
import frc.robot.commands.LoadCargoLoadingStation;
import frc.robot.commands.LoadHatchLoadingStation;
import frc.robot.commands.PositionClimbHab;
import frc.robot.commands.PositionLift;
import frc.robot.commands.PositionTargetArm;
import frc.robot.commands.PositionTargetGripper;
import frc.robot.commands.PositionTargetPuller;
import frc.robot.commands.PositionTargetPusherPuller;
import frc.robot.commands.UnloadCargoCargoShip;
import frc.robot.commands.UnloadCargoRocketLevel1;
import frc.robot.commands.UnloadCargoRocketLevel2;
import frc.robot.commands.UnloadCargoRocketLevel3;
import frc.robot.commands.UnloadHatchCargoShip;
import frc.robot.commands.UnloadHatchRocketLevel1;
import frc.robot.commands.UnloadHatchRocketLevel2;
import frc.robot.commands.UnloadHatchRocketLevel3;

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
                SmartDashboard.putData("TargetGripper Hatch",
                                new PositionTargetGripper(RobotMap.TARGET_GRIPPER_ENCODER_HATCH));

                // TargetPuller
                SmartDashboard.putData("TargetPuller Pull", new PositionTargetPuller(1.0));

                // TargetPusherPuller
                SmartDashboard.putData("TargetPusherPuller Push", new PositionTargetPusherPuller(1.0, true));
                SmartDashboard.putData("TargetPusherPuller Pull", new PositionTargetPusherPuller(1.0, false));

                // ClimbHab
                SmartDashboard.putData("ClimbHab Up", new PositionClimbHab(true));
                SmartDashboard.putData("ClimbHab Down", new PositionClimbHab(false));

                // Command Groups
                SmartDashboard.putData("Climb Hab Down 2", new ClimbDownHab2());
                SmartDashboard.putData("Climb Hab Up 2", new ClimbUpHab2());
                SmartDashboard.putData("Load Cargo Depot", new LoadCargoDepot());
                SmartDashboard.putData("Load Cargo Loading Station", new LoadCargoLoadingStation());
                SmartDashboard.putData("Load Hatch Loading Station", new LoadHatchLoadingStation());
                SmartDashboard.putData("Unload Cargo Cargo Ship", new UnloadCargoCargoShip());
                SmartDashboard.putData("Unload Cargo Rocket Level 1", new UnloadCargoRocketLevel1());
                SmartDashboard.putData("Unload Cargo Rocket Level 2", new UnloadCargoRocketLevel2());
                SmartDashboard.putData("Unload Cargo Rocket Level 3", new UnloadCargoRocketLevel3());
                SmartDashboard.putData("Unload Hatch Cargo Ship", new UnloadHatchCargoShip());
                SmartDashboard.putData("Unload Hatch Rocket Level 1", new UnloadHatchRocketLevel1());
                SmartDashboard.putData("Unload Hatch Rocket Level 2", new UnloadHatchRocketLevel2());
                SmartDashboard.putData("Unload Hatch Rocket Level 3", new UnloadHatchRocketLevel3());

        }

        public void teleopPeriodic()

        {
                // ClimbHab
                SmartDashboard.putBoolean("ClimbHabUp", Robot.m_climbhab.getClimbHabUp());
                SmartDashboard.putBoolean("ClimbHabDown", Robot.m_climbhab.getClimbHabDown());

                // DriveTrain
                SmartDashboard.putNumber("PercentThrottle", Robot.m_oi.getControllerDriveTrainThrottleValue());
                SmartDashboard.putNumber("PercentRotation", Robot.m_oi.getControllerDriveTrainRotationValue());
                SmartDashboard.putNumber("ACTUALPercentThrottle",
                                Robot.m_drivetrain.scalingSpeed(Robot.m_oi.getControllerDriveTrainThrottleValue()));
                SmartDashboard.putNumber("ACTUALPercentRotation",
                                Robot.m_drivetrain.scalingSpeed(Robot.m_oi.getControllerDriveTrainRotationValue()));

                // Lift
                SmartDashboard.putNumber("LiftControllerValue", Robot.m_oi.getControllerLiftValue());
                SmartDashboard.putNumber("LiftEncoder", Robot.m_lift.getLiftEncoder());
                SmartDashboard.putBoolean("LiftCargoShip",
                                Robot.m_lift.getLiftEncoder() == RobotMap.LIFT_ENCODER_CARGO_SHIP);
                SmartDashboard.putBoolean("LiftDepot", Robot.m_lift.getLiftEncoder() == RobotMap.LIFT_ENCODER_DEPOT);
                SmartDashboard.putBoolean("LiftLoadingStation",
                                Robot.m_lift.getLiftEncoder() == RobotMap.LIFT_ENCODER_LOADING_STATION);
                SmartDashboard.putBoolean("LiftRocketLevel1",
                                Robot.m_lift.getLiftEncoder() == RobotMap.LIFT_ENCODER_ROCKET_LEVEL_1);
                SmartDashboard.putBoolean("LiftRocketLevel2",
                                Robot.m_lift.getLiftEncoder() == RobotMap.LIFT_ENCODER_ROCKET_LEVEL_2);
                SmartDashboard.putBoolean("LiftRocketLevel3",
                                Robot.m_lift.getLiftEncoder() == RobotMap.LIFT_ENCODER_ROCKET_LEVEL_3);

                // TargetArm
                SmartDashboard.putNumber("TargetArmEncoder", Robot.m_targetarm.getTargetArmEncoder());
                SmartDashboard.putBoolean("TargetArmCargoShip",
                                Robot.m_targetarm.getTargetArmEncoder() == RobotMap.TARGET_ARM_ENCODER_CARGO_SHIP);
                SmartDashboard.putBoolean("TargetArmDepot",
                                Robot.m_targetarm.getTargetArmEncoder() == RobotMap.TARGET_ARM_ENCODER_DEPOT);
                SmartDashboard.putBoolean("TargetArmLoadingStation",
                                Robot.m_targetarm.getTargetArmEncoder() == RobotMap.TARGET_ARM_ENCODER_LOADING_STATION);
                SmartDashboard.putBoolean("TargetArmRocketLevel1",
                                Robot.m_targetarm.getTargetArmEncoder() == RobotMap.TARGET_ARM_ENCODER_ROCKET_LEVEL_1);
                SmartDashboard.putBoolean("TargetArmRocketLevel2",
                                Robot.m_targetarm.getTargetArmEncoder() == RobotMap.TARGET_ARM_ENCODER_ROCKET_LEVEL_2);
                SmartDashboard.putBoolean("TargetArmRocketLevel3",
                                Robot.m_targetarm.getTargetArmEncoder() == RobotMap.TARGET_ARM_ENCODER_ROCKET_LEVEL_3);

                // TargetGripper
                SmartDashboard.putNumber("TargetGripperEncoder", Robot.m_targetgripper.getTargetGripperEncoder());
                SmartDashboard.putBoolean("TargetGripperDown", Robot.m_targetgripper.getTargetGripperLimitSwitchLow());
                SmartDashboard.putBoolean("TargetGripperUp", Robot.m_targetgripper.getTargetGripperLimitSwitchHigh());
                SmartDashboard.putBoolean("TargetGripperHatch", (Robot.m_targetgripper
                                .getTargetGripperEncoder() >= (RobotMap.TARGET_GRIPPER_ENCODER_HATCH
                                                - RobotMap.TARGET_GRIPPER_ENCODER_DEADBAND / 2)
                                && Robot.m_targetgripper
                                                .getTargetGripperEncoder() <= (RobotMap.TARGET_GRIPPER_ENCODER_HATCH
                                                                - RobotMap.TARGET_GRIPPER_ENCODER_DEADBAND / 2)));
                // TargetPuller
                SmartDashboard.putBoolean("TargetPullerPull", Robot.m_targetpuller.getTargetPullerPull());

                // TargetPusherPuller
                SmartDashboard.putBoolean("TargetPusherPullerPush",
                                Robot.m_targetpusherpuller.getTargetPusherPullerPush());
                SmartDashboard.putBoolean("TargetPusherPullerPull",
                                Robot.m_targetpusherpuller.getTargetPusherPullerPull());

        }
}
