package frc.team2478.robot.commands.autonomous;

import edu.wpi.first.wpilibj.command.Command;
import frc.team2478.robot.Constants;
import frc.team2478.robot.Robot;

public class RackCubeAuto extends Command {

	public RackCubeAuto() {
		requires(Robot.feed);
		requires(Robot.shooter);
	}
	
	@Override
	protected void execute() {
		Robot.feed.runAtPercentage(-Constants.ShooterRig.FEED_PERCENT_SPEED);
		Robot.shooter.runAtPercentage(-Constants.ShooterRig.SHOOTER_PERCENT_SPEED);
	}
	
	@Override
	protected void interrupted() {
		this.end();
	}
	
	@Override
	protected void end() {
		Robot.feed.stop();
		Robot.shooter.stop();
	}
	
	@Override
	protected boolean isFinished() {
		return !Robot.feed.isCubeLoaded();
	}

}
