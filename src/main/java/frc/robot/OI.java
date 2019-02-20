/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.GenericHID.Hand;
import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.buttons.JoystickButton;
import frc.robot.commands.ClimbDownHab2;
import frc.robot.commands.ClimbUpHab2;
import frc.robot.commands.LoadCargoDepot;
import frc.robot.commands.LoadCargoLoadingStation;
import frc.robot.commands.LoadHatchLoadingStation;
import frc.robot.commands.UnloadCargoCargoShip;
import frc.robot.commands.UnloadCargoRocketLevel1;
import frc.robot.commands.UnloadCargoRocketLevel2;
import frc.robot.commands.UnloadCargoRocketLevel3;
import frc.robot.commands.UnloadHatchCargoShip;
import frc.robot.commands.UnloadHatchRocketLevel1;
import frc.robot.commands.UnloadHatchRocketLevel2;
import frc.robot.commands.UnloadHatchRocketLevel3;

/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI {
    //// CREATING BUTTONS
    // One type of button is a joystick button which is any button on a
    //// joystick.
    // You create one by telling it which joystick it's on and which button
    // number it is.
    // Joystick stick = new Joystick(port);
    // Button button = new JoystickButton(stick, buttonNumber);

    // There are a few additional built in buttons you can use. Additionally,
    // by subclassing Button you can create custom triggers and bind those to
    // commands the same as any other Button.

    //// TRIGGERING COMMANDS WITH BUTTONS
    // Once you have a button, it's trivial to bind it to a button in one of
    // three ways:

    // Start the command when the button is pressed and let it run the command
    // until it is finished as determined by it's isFinished method.
    // button.whenPressed(new ExampleCommand());

    // Run the command while the button is being held down and interrupt it once
    // the button is released.
    // button.whileHeld(new ExampleCommand());

    // Start the command when the button is released and let it run the command
    // until it is finished as determined by it's isFinished method.
    // button.whenReleased(new ExampleCommand());
    public Joystick driverControllerJoystick = new Joystick(RobotMap.OI_DRIVER_CONTROLLER_JOYSTICK);
    public XboxController driverControllerXbox = new XboxController(RobotMap.OI_DRIVER_CONTROLLER_XBOX);

    Button D1 = new JoystickButton(driverControllerJoystick, 1);
    Button D2 = new JoystickButton(driverControllerJoystick, 2);
    Button D3 = new JoystickButton(driverControllerJoystick, 3);
    Button D4 = new JoystickButton(driverControllerJoystick, 4);
    Button D5 = new JoystickButton(driverControllerJoystick, 5);
    Button D6 = new JoystickButton(driverControllerJoystick, 6);
    Button D7 = new JoystickButton(driverControllerJoystick, 7);
    Button D8 = new JoystickButton(driverControllerJoystick, 8);
    Button D9 = new JoystickButton(driverControllerJoystick, 9);
    Button D10 = new JoystickButton(driverControllerJoystick, 10);
    Button D11 = new JoystickButton(driverControllerJoystick, 11);
    Button D12 = new JoystickButton(driverControllerJoystick, 12);

    Button xboxAButton = new JoystickButton(driverControllerXbox, 1);
    Button xboxBButton = new JoystickButton(driverControllerXbox, 2);
    Button xboxXButton = new JoystickButton(driverControllerXbox, 3);
    Button xboxYButton = new JoystickButton(driverControllerXbox, 4);
    Button xboxLBumper = new JoystickButton(driverControllerXbox, 5);
    Button xboxRBumper = new JoystickButton(driverControllerXbox, 6);

    public OI() {
        D1.whenPressed(new ClimbUpHab2());
        D2.whenPressed(new ClimbDownHab2());
        D3.whenPressed(new LoadCargoDepot());
        D4.whenPressed(new LoadCargoLoadingStation());
        D5.whenPressed(new LoadHatchLoadingStation());
        D6.whenPressed(new UnloadHatchCargoShip());
        D7.whenPressed(new UnloadCargoCargoShip());
        D8.whenPressed(new UnloadCargoRocketLevel1());
        D9.whenPressed(new UnloadCargoRocketLevel2());
        D10.whenPressed(new UnloadCargoRocketLevel3());
        D11.whenPressed(new UnloadHatchRocketLevel1());
        xboxAButton.whenPressed(new UnloadHatchRocketLevel2());
        xboxBButton.whenPressed(new UnloadHatchRocketLevel3());
    }

    public double getJoystickY() {
        return -driverControllerJoystick.getY();
    }

    public double getJoystickX() {
        return driverControllerJoystick.getX();
    }

    public double getXboxLeftStickX() {
        return driverControllerXbox.getX(Hand.kLeft);
    }

    public double getXboxRightStickX() {
        return driverControllerXbox.getX(Hand.kRight);
    }

    public double getXboxLeftStickY() {
        return driverControllerXbox.getY(Hand.kLeft);
    }

    public double getXboxRightStickY() {
        return driverControllerXbox.getY(Hand.kRight);
    }

    public double getXboxLeftTrigger() {
        return driverControllerXbox.getTriggerAxis(Hand.kLeft);
    }

    public double getXboxRightTrigger() {
        return driverControllerXbox.getTriggerAxis(Hand.kRight);
    }

    public double getXboxTrigger() {
        return getXboxLeftTrigger() - getXboxRightTrigger();
    }

    public double getControllerDriveTrainThrottleValue() {
        return getJoystickY();
    }

    public double getControllerDriveTrainRotationValue() {
        return getJoystickX();
    }

    public double getControllerGripperValue() {

        return Robot.m_oi.getXboxTrigger();
    }

    public double getControllerLiftValue() {

        return Robot.m_oi.getXboxLeftStickY();

    }

}
