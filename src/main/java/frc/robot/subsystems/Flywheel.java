// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.NeutralMode;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonFX;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

import static frc.robot.Constants.CAN_ID.*;

public class Flywheel extends SubsystemBase {
  private WPI_TalonFX falcon1 = new WPI_TalonFX(FALCON1);
  private WPI_TalonFX falcon2 = new WPI_TalonFX(FALCON2);

  /** Creates a new Flywheel. */
  public Flywheel() {
    // Neutral mode
    falcon1.setNeutralMode(NeutralMode.Brake);
    falcon2.setNeutralMode(NeutralMode.Brake);

    // Reverse falcon2 rotation
    falcon2.setInverted(true);
  }

  /**
   * Spin flywheel
   * @param speed double, flywheel spin speed
   */
  public void spin(double speed) {
    falcon1.set(speed);
    falcon2.set(speed);
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
    SmartDashboard.putNumber("falcon1 temp", falcon1.getTemperature());
    SmartDashboard.putNumber("falcon2 temp", falcon2.getTemperature());
  }
}
