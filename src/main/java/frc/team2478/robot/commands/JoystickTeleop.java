package frc.team2478.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import frc.team2478.robot.Robot;

/**
 * When called, robot will drive normally using the Y-axes of both joysticks.
 */
public class JoystickTeleop extends Command {
	
    public JoystickTeleop() {
    	requires(Robot.drivetrain);
    	requires(Robot.encoders);
    }

    protected void initialize() {
    }

    protected void execute() {
    	Robot.drivetrain.tankDriveSquared(Robot.oi.getLeftY(), Robot.oi.getRightY());
    	Robot.encoders.printEncoderData();
    	System.out.print(Robot.gyro.getAngle());
    }

    protected boolean isFinished() {
        return false;
    }

    protected void end() {
    }

    protected void interrupted() {
    	this.end();
    }
}