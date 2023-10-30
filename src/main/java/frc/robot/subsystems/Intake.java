// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.NeutralMode;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

import static frc.robot.Constants.CAN_ID.*;

public class Intake extends SubsystemBase {
  private WPI_TalonSRX intake = new WPI_TalonSRX(INTAKE);

  /** Creates a new Intake. */
  public Intake() {
    intake.setNeutralMode(NeutralMode.Brake);
  }
  
  /**
   * Spin intake
   * @param speed double, spin speed
   */
  public void spin(double speed) {
    intake.set(speed);
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
    SmartDashboard.putNumber("intake talon temp", intake.getTemperature());
  }
}
