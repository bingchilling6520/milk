// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.first.wpilibj.Joystick;

/**
 * The Constants class provides a convenient place for teams to hold robot-wide numerical or boolean
 * constants. This class should not be used for any other purpose. All constants should be declared
 * globally (i.e. public static). Do not put anything functional in this class.
 *
 * <p>It is advised to statically import this class (or one of its inner classes) wherever the
 * constants are needed, to reduce verbosity.
 */
public final class Constants {
  public static class CAN_ID {
    public static final int PDP = 0;
    
    // Drivebase (Talon SRX)
    public static final int LEFT_MASTER = 1;
    public static final int LEFT_FOLLOW = 2;
    public static final int RIGHT_MASTER = 3;
    public static final int RIGHT_FOLLOW = 4;

    // Intake
    public static final int INTAKE = 5;
  
    // Flywheel? (Falcon)
    public static final int FALCON1 = 6;
    public static final int FALCON2 = 7;
    public static final int ROTATOR = 8;
  }

  public static class MAPPING {
    // Joystick
    public static Joystick JOY0 = new Joystick(0);

    // Axis
    //public static int JOY0_Y = 0;
    //public static int JOY0_X = 1;
    public static int JOY0_LEFT_Y = 1;
    public static int JOY0_RIGHT_Y = 5;
    public static double JOY0_SENSE = 0.15;

    // Buttons
    public static int REVERSE_BUTTON = 7;
    public static int INTAKE_BUTTON = 5;
    public static int ROTATOR_BUTTON = 8;
    public static int FLYWHEEL_BUTTON = 6;
  }

  public static class SPEED {
    // Drivebase
    public static double DRIVEBASE_LINEAR_SPEED = 0.8;
    public static double DRIVEBASE_ROTATE_SPEED = 0.8;
  
    // Intake
    public static double INTAKE_IN_SPD = -0.7;
    public static double INTAKE_OUT_SPD = 0.7;

    // Rotator
    public static double ROTATOR_SPD1 = 0.4;
    public static double ROTATOR_SPD2 = -0.4;

    // Flywheel
    public static double FLYWHEEL_IN = 0.4;
    public static double FLYWHEEL_OUT = -0.4;
  }
}
