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
import frc.robot.commands.ClimbDownClimbHab;
import frc.robot.commands.ClimbUpClimbHab;

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
    public Joystick driverController = new Joystick(RobotMap.OI_DRIVER_CONTROLLER);
    XboxController xbox = new XboxController(1);

    Button D1 = new JoystickButton(driverController, 1);
    Button D2 = new JoystickButton(driverController, 2);
    Button D3 = new JoystickButton(driverController, 3);
    Button D4 = new JoystickButton(driverController, 4);
    Button D5 = new JoystickButton(driverController, 5);
    Button D6 = new JoystickButton(driverController, 6);
    Button D7 = new JoystickButton(driverController, 7);
    Button D8 = new JoystickButton(driverController, 8);
    Button D9 = new JoystickButton(driverController, 9);
    Button D10 = new JoystickButton(driverController, 10);
    Button D11 = new JoystickButton(driverController, 11);
    Button D12 = new JoystickButton(driverController, 12);

    Button xboxAButton = new JoystickButton(xbox, 1);
    Button xboxBButton = new JoystickButton(xbox, 2);
    Button xboxXButton = new JoystickButton(xbox, 3);
    Button xboxYButton = new JoystickButton(xbox, 4);
    Button xboxLBumper = new JoystickButton(xbox, 5);
    Button xboxRBumper = new JoystickButton(xbox, 6);

    public OI() {
        D1.whenPressed(new ClimbUpClimbHab());
        D2.whenPressed(new ClimbDownClimbHab());
    }

    public double getJoystickY() {
        return -driverController.getY();
    }

    public double getJoystickX() {
        return driverController.getX();
    }

    public double getXboxLeftStickX() {
        return xbox.getX(Hand.kLeft);
    }

    public double getXboxRightStickX() {
        return xbox.getX(Hand.kRight);
    }

    public double getXboxLeftStickY() {
        return xbox.getY(Hand.kLeft);
    }

    public double getXboxRightStickY() {
        return xbox.getY(Hand.kRight);
    }

    public double getXboxLeftTrigger() {
        return xbox.getTriggerAxis(Hand.kLeft);
    }

    public double getXboxRightTrigger() {
        return xbox.getTriggerAxis(Hand.kRight);
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
