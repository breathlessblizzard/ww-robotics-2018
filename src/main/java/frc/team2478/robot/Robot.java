/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.team2478.robot;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;
import frc.team2478.robot.commands.AutonomoGroupTest;
import frc.team2478.robot.commands.JoystickAlignment;
import frc.team2478.robot.commands.JoystickTeleop;
import frc.team2478.robot.commands.JoystickTurnLock;
import frc.team2478.robot.subsystems.DriveEncoderSubsystem;
import frc.team2478.robot.subsystems.DrivetrainSubsystem;
import frc.team2478.robot.subsystems.NavxSubsystem;
import frc.team2478.robot.util.ControlHandler;
import frc.team2478.robot.util.ControlHandler.ButtonName;
import frc.team2478.robot.util.DashboardHandler;

public class Robot extends TimedRobot {
	
	public static final int LEFT_JOY = 1;
	public static final int RIGHT_JOY = 0;
	public static final int XBOX = 2;
	
	public static final DriveEncoderSubsystem encoders = new DriveEncoderSubsystem();
	public static final DrivetrainSubsystem drivetrain = new DrivetrainSubsystem();
	public static final NavxSubsystem navx = new NavxSubsystem();
//	private static final LimelightSubsystem limelight = new LimelightSubsystem();
	public static ControlHandler oi;
	
	public static Command teleop;
	
	@Override
	public void robotInit() {
		oi = new ControlHandler(
				new Joystick(LEFT_JOY),
				new Joystick(RIGHT_JOY), 
				new XboxController(XBOX));
		
		oi.whileHeld(ButtonName.RIGHT_THUMB, new JoystickAlignment(oi, drivetrain));
		oi.whileHeld(ButtonName.RIGHT_TRIGGER, new JoystickTurnLock(oi, drivetrain));
//		oi.whileHeld(ButtonName.LEFT_TRIGGER, new CameraAlign(oi, drivetrain, limelight));
		teleop = new JoystickTeleop(oi, drivetrain);
	}
	
	@Override
	public void robotPeriodic() {
		if (DashboardHandler.getResetButton()) {
//			DashboardHandler.putAutonomoWidgets();
			DashboardHandler.putResetButton();
		}
	}

	@Override
	public void disabledInit() {
//		DashboardHandler.putResetButton();
		Scheduler.getInstance().removeAll();
	}

	@Override
	public void disabledPeriodic() {}

	@Override
	public void autonomousInit() {
		// use null detector to prevent injuries
		new AutonomoGroupTest(drivetrain, encoders, navx).start();
	}

	@Override
	public void autonomousPeriodic() {
		Scheduler.getInstance().run();
	}

	@Override
	public void teleopInit() {
		Scheduler.getInstance().removeAll();
		//test this code!
//		new JoystickAlignment(oi, drivetrain).start();
//		new JoystickTeleop(oi, drivetrain).start();
	}

	@Override
	public void teleopPeriodic() {
		Scheduler.getInstance().run();
	}

	@Override
	public void testInit() {}
	
	@Override
	public void testPeriodic() {}
}