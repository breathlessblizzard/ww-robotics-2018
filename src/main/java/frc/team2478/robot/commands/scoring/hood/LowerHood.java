package frc.team2478.robot.commands.scoring.hood;

import edu.wpi.first.wpilibj.command.Command;
import frc.team2478.robot.Robot;
import frc.team2478.robot.util.enums.Mode;


public class LowerHood extends Command {
	
	private int count = 0;

	/**
	* Retracts pistons to lower hood down.
	* @author Josh
	*/
	public LowerHood() {
		requires(Robot.pneumatics);
	}
	
	@Override
	protected void execute() {
		Robot.pneumatics.setHoodPiston(Mode.REVERSE);
		count++;
	}
	
	@Override
	protected void end() {
		Robot.pneumatics.setHoodPiston(Mode.OFF);
	}

	@Override
	protected boolean isFinished() {
		return count > 5;
	}
	
	@Override
	protected void interrupted() {
		this.end();
	}
}
