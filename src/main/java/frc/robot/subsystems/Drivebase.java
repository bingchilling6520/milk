// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.NeutralMode;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

import static frc.robot.Constants.CAN_ID.*;
import static frc.robot.Constants.MAPPING.*;
import static frc.robot.Constants.SPEED.*;

public class Drivebase extends SubsystemBase {
  // Talon
  private WPI_TalonSRX leftMaster = new WPI_TalonSRX(LEFT_MASTER);
  private WPI_TalonSRX leftFollow = new WPI_TalonSRX(LEFT_FOLLOW);
  private WPI_TalonSRX rightMaster = new WPI_TalonSRX(RIGHT_MASTER);
  private WPI_TalonSRX rightFollow = new WPI_TalonSRX(RIGHT_FOLLOW);

  // Drivetrain class
  private DifferentialDrive drivebase;

  /** Creates a new Drivebase. */
  public Drivebase() {
    // Init brake mode
    leftMaster.setNeutralMode(NeutralMode.Brake);
    leftFollow.setNeutralMode(NeutralMode.Brake);
    rightMaster.setNeutralMode(NeutralMode.Brake);
    rightFollow.setNeutralMode(NeutralMode.Brake);

    // Inverse right motors
    rightMaster.setInverted(true);
    rightFollow.setInverted(true);

    // Set follow
    leftFollow.follow(leftMaster);
    rightFollow.follow(rightMaster);

    // Create differential drive instance
    drivebase = new DifferentialDrive(leftMaster, rightMaster);
  }

  /**
   * Return the value if value > sense (not noise), else return 0
   * @param value the axis value, in double
   * @return value if value > sense, else 0
   */
  private double filter(double value) {
    if (Math.abs(value) > JOY0_SENSE) {
      return value;
    } else {
      return 0;
    }
  }

  /**
   * Drive the drivebase, in tank mode
   * @param linearSpeed up/down speed, in double, -1 to 1. Forward is positive.
   * @param rotateSpeed left/right speed, in double, -1 to 1. Left is positive.
  */
  public void drive(double linearSpeed, double rotateSpeed) {
    drivebase.arcadeDrive(filter(linearSpeed) * DRIVEBASE_LINEAR_SPEED, filter(rotateSpeed) * DRIVEBASE_LINEAR_SPEED);
  }

  /**
   * Drive the drivebase manually, using left and right (for example ps4/5/logitech)
   * @param leftSpeed left wheel speed
   * @param rightSpeed right wheel speed
   */
  public void drive_manually(double leftSpeed, double rightSpeed) {
    leftMaster.set(filter(leftSpeed) * DRIVEBASE_LINEAR_SPEED);
    rightMaster.set(filter(rightSpeed) * DRIVEBASE_LINEAR_SPEED);
  }

  @Override
  public void periodic() {
    SmartDashboard.putNumber("leftMaster temp", leftMaster.getTemperature());
    SmartDashboard.putNumber("leftFollow temp", leftFollow.getTemperature());
    SmartDashboard.putNumber("rightMaster temp", rightMaster.getTemperature());
    SmartDashboard.putNumber("rightFollow temp", rightFollow.getTemperature());
  }
}
