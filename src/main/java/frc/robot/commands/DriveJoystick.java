// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Drivebase;

import static frc.robot.Constants.MAPPING.*;

public class DriveJoystick extends CommandBase {
  // Create drivebase subsystem
  Drivebase m_Drivebase = new Drivebase();

  /** Creates a new DriveJoystick. */
  public DriveJoystick() {
    // Use addRequirements() here to declare subsystem dependencies.
    addRequirements(m_Drivebase);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    m_Drivebase.drive(0, 0);
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    double linearSpeed = JOY0.getRawAxis(JOY0_Y);
    double rotateSpeed = JOY0.getRawAxis(JOY0_X);
    m_Drivebase.drive(linearSpeed, rotateSpeed);

    // Or
    /*
    double leftSpeed = JOY0.getRawAxis(JOY0_LEFT_Y);
    double rightSpeed = JOY0.getRawAxis(JOY0_RIGHT_Y);
    m_Drivebase.drive_manually(leftSpeed, rightSpeed);
    */
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    m_Drivebase.drive(0, 0);
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
