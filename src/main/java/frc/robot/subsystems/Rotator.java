// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.NeutralMode;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

import static frc.robot.Constants.CAN_ID.*;

public class Rotator extends SubsystemBase {
  private WPI_TalonSRX rotator = new WPI_TalonSRX(ROTATOR);

  /** Creates a new Rotator. */
  public Rotator() {
    rotator.setNeutralMode(NeutralMode.Brake);
  }

  public void rotate(double speed) {
    rotator.set(speed);
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
    SmartDashboard.putNumber("rotator talon temp", rotator.getTemperature());
  }
}
