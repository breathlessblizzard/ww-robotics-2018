package frc.team2478.robot.commands.autonomous.routines;

import edu.wpi.first.wpilibj.command.CommandGroup;
import edu.wpi.first.wpilibj.command.WaitCommand;
import frc.team2478.robot.Constants;
import frc.team2478.robot.commands.autonomous.AutonomoDriveStraight;
import frc.team2478.robot.commands.autonomous.AutonomoDriveTurn;
import frc.team2478.robot.commands.pneumatics.LowerHood;
import frc.team2478.robot.commands.pneumatics.RaiseHood;
import frc.team2478.robot.commands.scoring.StopAllScoringMotors;
import frc.team2478.robot.commands.scoring.feed.RunFeedAtPercentage;
import frc.team2478.robot.commands.scoring.shooter.RunShooterAtVelocity;

public class LefttoRightScale extends CommandGroup {
	
	public LefttoRightScale() {
		addParallel(new LowerHood());
		addSequential(new AutonomoDriveStraight(Constants.AutonomoDrive.InchesToClicks(200)));
		addSequential(new AutonomoDriveTurn(90));
		addSequential(new AutonomoDriveStraight(Constants.AutonomoDrive.InchesToClicks(265)));
		addSequential(new AutonomoDriveTurn(-90));
		addSequential(new AutonomoDriveStraight(Constants.AutonomoDrive.InchesToClicks(70)));
		addParallel(new RunShooterAtVelocity(Constants.ShooterRig.MID_SPEED));
		addParallel(new RaiseHood());
		addSequential(new AutonomoDriveTurn(-90));
		addParallel(new RunFeedAtPercentage(Constants.ShooterRig.FEED_PERCENT_SPEED));
		addSequential(new WaitCommand(2));
		addSequential(new StopAllScoringMotors());
	}

}