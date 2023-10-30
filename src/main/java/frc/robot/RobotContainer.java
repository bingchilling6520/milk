// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.StartEndCommand;
import edu.wpi.first.wpilibj2.command.button.CommandXboxController;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;
import edu.wpi.first.wpilibj2.command.button.Trigger;
import frc.robot.subsystems.Flywheel;
import frc.robot.subsystems.Intake;
import frc.robot.subsystems.Rotator;

import static frc.robot.Constants.MAPPING.*;
import static frc.robot.Constants.SPEED.*;

/**
 * This class is where the bulk of the robot should be declared. Since Command-based is a
 * "declarative" paradigm, very little robot logic should actually be handled in the {@link Robot}
 * periodic methods (other than the scheduler calls). Instead, the structure of the robot (including
 * subsystems, commands, and trigger mappings) should be declared here.
 */
public class RobotContainer {
  // The robot's subsystems and commands are defined here...
  private Intake m_Intake = new Intake();
  private Flywheel m_Flywheel = new Flywheel();
  private Rotator m_Rotator = new Rotator();

  // Commands
  private Command intakeIn = new StartEndCommand(
  () -> {
    m_Intake.spin(INTAKE_IN_SPD);
  }, () -> {
    m_Intake.spin(0);
  }, m_Intake);
  
  private Command intakeOut = new StartEndCommand(
  () -> {
    m_Intake.spin(INTAKE_OUT_SPD);
  }, () -> {
    m_Intake.spin(0);
  }, m_Intake);

  private Command rotator1 = new StartEndCommand(
  () -> {
    m_Rotator.rotate(ROTATOR_SPD1);
  }, () -> {
    m_Rotator.rotate(0);
  }, m_Rotator);
  
  private Command rotator2 = new StartEndCommand(
  () -> {
    m_Rotator.rotate(ROTATOR_SPD2);
  }, () -> {
    m_Rotator.rotate(0);
  }, m_Rotator);

  private Command flywheelIn = new StartEndCommand(
  () -> {
    m_Flywheel.spin(ROTATOR_SPD1);
  }, () -> {
    m_Flywheel.spin(0);
  }, m_Flywheel);
  
  private Command flywheelOut = new StartEndCommand(
  () -> {
    m_Flywheel.spin(ROTATOR_SPD2);
  }, () -> {
    m_Flywheel.spin(0);
  }, m_Flywheel);

  /** The container for the robot. Contains subsystems, OI devices, and commands. */
  public RobotContainer() {
    // Configure the trigger bindings
    configureBindings();
  }

  /**
   * Use this method to define your trigger->command mappings. Triggers can be created via the
   * {@link Trigger#Trigger(java.util.function.BooleanSupplier)} constructor with an arbitrary
   * predicate, or via the named factories in {@link
   * edu.wpi.first.wpilibj2.command.button.CommandGenericHID}'s subclasses for {@link
   * CommandXboxController Xbox}/{@link edu.wpi.first.wpilibj2.command.button.CommandPS4Controller
   * PS4} controllers or {@link edu.wpi.first.wpilibj2.command.button.CommandJoystick Flight
   * joysticks}.
   */
  private void configureBindings() {
    new JoystickButton(JOY0, INTAKE_IN_BUTTON).whileTrue(intakeIn);
    new JoystickButton(JOY0, INTAKE_OUT_BUTTON).whileTrue(intakeOut);
    new JoystickButton(JOY0, FLYWHEEL_IN_BUTTON).whileTrue(flywheelIn);
    new JoystickButton(JOY0, FLYWHEEL_OUT_BUTTON).whileTrue(flywheelOut);
    new JoystickButton(JOY0, ROTATOR1_BUTTON).whileTrue(rotator1);
    new JoystickButton(JOY0, ROTATOR2_BUTTON).whileTrue(rotator2);
  }

  /**
   * Use this to pass the autonomous command to the main {@link Robot} class.
   *
   * @return the command to run in autonomous
   */
  public Command getAutonomousCommand() {
    // An example command will be run in autonomous
    return null;
  }
}
