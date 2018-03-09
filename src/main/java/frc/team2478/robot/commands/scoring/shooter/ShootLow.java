package frc.team2478.robot.commands.scoring.shooter;

import edu.wpi.first.wpilibj.command.Command;
import frc.team2478.robot.Robot;
import frc.team2478.robot.util.enums.ShotHeight;

public class ShootLow extends Command {

	public ShootLow() {
		requires(Robot.shooter);
	}
	
	@Override
	protected void execute() {
		Robot.shooter.setCurrrentTarget(ShotHeight.MID);
		Robot.shooter.shootForCurrentTarget();
	}
	
	@Override
	protected boolean isFinished() {
		return false;
	}

	@Override
	protected void end() {
		Robot.shooter.stop();
	}
	
}
