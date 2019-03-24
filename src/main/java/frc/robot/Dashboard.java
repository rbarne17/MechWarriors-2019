/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import edu.wpi.first.wpilibj.shuffleboard.Shuffleboard;
import edu.wpi.first.wpilibj.shuffleboard.ShuffleboardTab;
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
        ShuffleboardTab subsystemsTab;
        ShuffleboardTab driveTrainTab;
        ShuffleboardTab liftTab;
        ShuffleboardTab targetArmTab;
        ShuffleboardTab targetGripperTab;
        ShuffleboardTab targetPullerTab;
        ShuffleboardTab targetPusherPullerTab;
        ShuffleboardTab climbHabTab;
        ShuffleboardTab commandGroupsTab;

        public Dashboard() {
                subsystemsTab = Shuffleboard.getTab("Subsystems");
                driveTrainTab = Shuffleboard.getTab("DriveTrain");
                liftTab = Shuffleboard.getTab("Lift");
                targetArmTab = Shuffleboard.getTab("TargetArm");
                targetGripperTab = Shuffleboard.getTab("TargetGripper");
                targetPullerTab = Shuffleboard.getTab("TargetPuller");
                targetPusherPullerTab = Shuffleboard.getTab("TargetPusherPuller");
                climbHabTab = Shuffleboard.getTab("ClimbHab");
                commandGroupsTab = Shuffleboard.getTab("Command Groups");
        }

        public void robotInit() {

                // subsystems display

                subsystemsTab.add("DriveTrain", Robot.m_drivetrain);
                subsystemsTab.add("Lift", Robot.m_lift);
                subsystemsTab.add("TargetGripper", Robot.m_targetgripper);
                subsystemsTab.add("TargetArm", Robot.m_targetarm);
                subsystemsTab.add("ClimbHab", Robot.m_climbhab);
                subsystemsTab.add("Eyes", Robot.m_eyes);

                // Lift

                liftTab.add("Lift Cargo Ship", new PositionLift(RobotMap.LIFT_ENCODER_CARGO_SHIP));
                liftTab.add("Lift Depot", new PositionLift(RobotMap.LIFT_ENCODER_DEPOT));
                liftTab.add("Lift Loading Station", new PositionLift(RobotMap.LIFT_ENCODER_LOADING_STATION));
                liftTab.add("Lift Rocket Level 1", new PositionLift(RobotMap.LIFT_ENCODER_ROCKET_LEVEL_1));
                liftTab.add("Lift Rocket Level 2", new PositionLift(RobotMap.LIFT_ENCODER_ROCKET_LEVEL_2));
                liftTab.add("Lift Rocket Level 3", new PositionLift(RobotMap.LIFT_ENCODER_ROCKET_LEVEL_3));

                // TargetArm
                targetArmTab.add("TargetArm Up", new PositionTargetArm(RobotMap.TARGET_ARM_ENCODER_HIGH));
                targetArmTab.add("TargetArm Down", new PositionTargetArm(RobotMap.TARGET_ARM_ENCODER_LOW));

                // TargetGripper
                targetGripperTab.add("TargetGripper Up",
                                new PositionTargetGripper(RobotMap.TARGET_GRIPPER_ENCODER_HIGH));
                targetGripperTab.add("TargetGripper Down",
                                new PositionTargetGripper(RobotMap.TARGET_GRIPPER_ENCODER_LOW));
                targetGripperTab.add("TargetGripper Hatch", new PositionTargetGripper(
                                RobotMap.TARGET_GRIPPER_ENCODER_HATCH_LOW, RobotMap.TARGET_GRIPPER_ENCODER_HIGH));

                // TargetPuller
                targetPullerTab.add("TargetPuller Pull", new PositionTargetPuller(1.0));

                // TargetPusherPuller
                targetPusherPullerTab.add("TargetPusherPuller Push", new PositionTargetPusherPuller(1.0, true));
                targetPusherPullerTab.add("TargetPusherPuller Pull", new PositionTargetPusherPuller(1.0, false));

                // ClimbHab
                climbHabTab.add("ClimbHab Up", new PositionClimbHab(true));
                climbHabTab.add("ClimbHab Down", new PositionClimbHab(false));

                // Command Groups
                commandGroupsTab.add("Climb Hab Down 2", new ClimbDownHab2());
                commandGroupsTab.add("Climb Hab Up 2", new ClimbUpHab2());
                commandGroupsTab.add("Load Cargo Depot", new LoadCargoDepot());
                commandGroupsTab.add("Load Cargo Loading Station", new LoadCargoLoadingStation());
                commandGroupsTab.add("Load Hatch Loading Station", new LoadHatchLoadingStation());
                commandGroupsTab.add("Unload Cargo Cargo Ship", new UnloadCargoCargoShip());
                commandGroupsTab.add("Unload Cargo Rocket Level 1", new UnloadCargoRocketLevel1());
                commandGroupsTab.add("Unload Cargo Rocket Level 2", new UnloadCargoRocketLevel2());
                commandGroupsTab.add("Unload Cargo Rocket Level 3", new UnloadCargoRocketLevel3());
                commandGroupsTab.add("Unload Hatch Cargo Ship", new UnloadHatchCargoShip());
                commandGroupsTab.add("Unload Hatch Rocket Level 1", new UnloadHatchRocketLevel1());
                commandGroupsTab.add("Unload Hatch Rocket Level 2", new UnloadHatchRocketLevel2());
                commandGroupsTab.add("Unload Hatch Rocket Level 3", new UnloadHatchRocketLevel3());

        }

        public void teleopPeriodic()

        {
                // ClimbHab
                climbHabTab.add("ClimbHabUp", Robot.m_climbhab.getClimbHabUp());
                climbHabTab.add("ClimbHabDown", Robot.m_climbhab.getClimbHabDown());

                // DriveTrain
                driveTrainTab.add("PercentThrottle", Robot.m_oi.getControllerDriveTrainThrottleValue());
                driveTrainTab.add("PercentRotation", Robot.m_oi.getControllerDriveTrainRotationValue());
                driveTrainTab.add("ACTUALPercentThrottle",
                                Robot.m_drivetrain.scalingSpeed(Robot.m_oi.getControllerDriveTrainThrottleValue()));
                driveTrainTab.add("ACTUALPercentRotation",
                                Robot.m_drivetrain.scalingSpeed(Robot.m_oi.getControllerDriveTrainRotationValue()));

                // Lift
                liftTab.add("LiftControllerValue", Robot.m_oi.getControllerLiftValue());
                liftTab.add("LiftEncoder", Robot.m_lift.getLiftEncoder());
                liftTab.add("LiftCargoShip",
                                Robot.m_lift.getLiftEncoder() == RobotMap.LIFT_ENCODER_CARGO_SHIP);
                liftTab.add("LiftDepot", Robot.m_lift.getLiftEncoder() == RobotMap.LIFT_ENCODER_DEPOT);
                liftTab.add("LiftLoadingStation",
                                Robot.m_lift.getLiftEncoder() == RobotMap.LIFT_ENCODER_LOADING_STATION);
                liftTab.add("LiftRocketLevel1",
                                Robot.m_lift.getLiftEncoder() == RobotMap.LIFT_ENCODER_ROCKET_LEVEL_1);
                liftTab.add("LiftRocketLevel2",
                                Robot.m_lift.getLiftEncoder() == RobotMap.LIFT_ENCODER_ROCKET_LEVEL_2);
                liftTab.add("LiftRocketLevel3",
                                Robot.m_lift.getLiftEncoder() == RobotMap.LIFT_ENCODER_ROCKET_LEVEL_3);

                // TargetArm
                targetArmTab.add("TargetArmEncoder", Robot.m_targetarm.getTargetArmEncoder());
                targetArmTab.add("TargetArmCargoShip",
                                Robot.m_targetarm.getTargetArmEncoder() == RobotMap.TARGET_ARM_ENCODER_CARGO_SHIP);
                targetArmTab.add("TargetArmDepot",
                                Robot.m_targetarm.getTargetArmEncoder() == RobotMap.TARGET_ARM_ENCODER_DEPOT);
                targetArmTab.add("TargetArmLoadingStation",
                                Robot.m_targetarm.getTargetArmEncoder() == RobotMap.TARGET_ARM_ENCODER_LOADING_STATION);
                targetArmTab.add("TargetArmRocketLevel1",
                                Robot.m_targetarm.getTargetArmEncoder() == RobotMap.TARGET_ARM_ENCODER_ROCKET_LEVEL_1);
                targetArmTab.add("TargetArmRocketLevel2",
                                Robot.m_targetarm.getTargetArmEncoder() == RobotMap.TARGET_ARM_ENCODER_ROCKET_LEVEL_2);
                targetArmTab.add("TargetArmRocketLevel3",
                                Robot.m_targetarm.getTargetArmEncoder() == RobotMap.TARGET_ARM_ENCODER_ROCKET_LEVEL_3);

                // TargetGripper
                targetGripperTab.add("TargetGripperEncoder", Robot.m_targetgripper.getTargetGripperEncoder());
                targetGripperTab.add("TargetGripperDown", Robot.m_targetgripper.getTargetGripperLimitSwitchLow());
                targetGripperTab.add("TargetGripperUp", Robot.m_targetgripper.getTargetGripperLimitSwitchHigh());
                targetGripperTab.add("TargetGripperHatch", (Robot.m_targetgripper
                                .getTargetGripperEncoder() >= RobotMap.TARGET_GRIPPER_ENCODER_HATCH_LOW
                                && Robot.m_targetgripper
                                                .getTargetGripperEncoder() <= RobotMap.TARGET_GRIPPER_ENCODER_HATCH_HIGH));
                // TargetPuller
                targetPullerTab.add("TargetPullerPull", Robot.m_targetpuller.getTargetPullerPull());

                // TargetPusherPuller
                targetPusherPullerTab.add("TargetPusherPullerPush",
                                Robot.m_targetpusherpuller.getTargetPusherPullerPush());
                targetPusherPullerTab.add("TargetPusherPullerPull",
                                Robot.m_targetpusherpuller.getTargetPusherPullerPull());

        }
}
