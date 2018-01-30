/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.team2478.robot;

import frc.team2478.robot.commands.AutonomoGroupTest;
import frc.team2478.robot.subsystems.CameraSubsystem;
import frc.team2478.robot.subsystems.DrivetrainSubsystem;
import frc.team2478.robot.subsystems.MotionSensorsSubsystem;
import frc.team2478.robot.util.DashboardHandler;
import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.command.Scheduler;

public class Robot extends TimedRobot {
	
	public static OI oi;

	public static final DrivetrainSubsystem drivetrain = new DrivetrainSubsystem();
	public static final MotionSensorsSubsystem motionSensors = new MotionSensorsSubsystem();
	public static final CameraSubsystem limelight = new CameraSubsystem();
	
	@Override
	public void robotInit() {
		oi = new OI();
		drivetrain.init();
		motionSensors.init();
		limelight.init();
	}
	
	@Override
	public void robotPeriodic() {
		if (DashboardHandler.getResetButton()) {
			DashboardHandler.putAutonomoWidgets();
			DashboardHandler.putResetButton();
		}
	}

	@Override
	public void disabledInit() {
		DashboardHandler.putResetButton();
		Scheduler.getInstance().removeAll();
	}

	@Override
	public void disabledPeriodic() {}

	@Override
	public void autonomousInit() {
		new AutonomoGroupTest(DashboardHandler.getDist1(),
							  DashboardHandler.getDist2(),
							  DashboardHandler.getTurn1(),
							  DashboardHandler.getTurn2()).start();
	}

	@Override
	public void autonomousPeriodic() {
		Scheduler.getInstance().run();
	}

	@Override
	public void teleopInit() {}

	@Override
	public void teleopPeriodic() {
		Scheduler.getInstance().run();
	}

	@Override
	public void testInit() {}
	
	@Override
	public void testPeriodic() {}
}