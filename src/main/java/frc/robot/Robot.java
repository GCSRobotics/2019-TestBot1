/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.Spark;
import edu.wpi.first.wpilibj.Victor;
import edu.wpi.first.wpilibj.Joystick.ButtonType;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;

/**
 * This is a demo program showing the use of the RobotDrive class, specifically
 * it contains the code necessary to operate a robot with tank drive.
 */
public class Robot extends IterativeRobot {
  private DifferentialDrive m_myRobot;
  private Victor m_leftDriveMotor;
  private Victor m_rightDriveMotor;

  private Joystick m_joystick;
  
  private Victor m_pickupMotor;
  private Victor m_throwingMotor;
  

  @Override
  public void robotInit() {
    //Drivetrain
    m_leftDriveMotor = new Victor(0);
    m_rightDriveMotor = new Victor(1);
    m_myRobot = new DifferentialDrive(m_leftDriveMotor, m_rightDriveMotor);

    //Extensions
    m_pickupMotor = new Victor(2);
    m_throwingMotor = new Victor(3);

    //Joysticks
    m_joystick = new Joystick(0);
  }

  @Override
  public void teleopPeriodic() {
    m_myRobot.tankDrive(m_joystick.getRawAxis(0), m_joystick.getRawAxis(1));

    //Operate the pickup
    if (m_joystick.getRawButton(0))
    { 
      //Forward
      m_pickupMotor.set(1); 
    }
    else if (m_joystick.getRawButton(1))
    { 
      //Reverse
      m_pickupMotor.set(-1); 
    }
    else
    { 
      //Stop
      m_pickupMotor.set(0); 
    }

    //Operate the Thrower
    if (m_joystick.getRawButton(2))
    { 
      //Forward
      m_throwingMotor.set(1); 
    }
    else if (m_joystick.getRawButton(3))
    { 
      //Reverse
      m_throwingMotor.set(-1); 
    }
    else
    { 
      //Stop
      m_throwingMotor.set(0); 
    }
  }
}
