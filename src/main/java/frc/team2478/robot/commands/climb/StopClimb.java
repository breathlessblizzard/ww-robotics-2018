package frc.team2478.robot.commands.climb;

import edu.wpi.first.wpilibj.command.InstantCommand;
import frc.team2478.robot.Robot;

public class StopClimb extends InstantCommand {

	public StopClimb() {
		requires(Robot.climb);
	}
	
	@Override
	protected void execute() {
		Robot.climb.stopAll();
	}

}
