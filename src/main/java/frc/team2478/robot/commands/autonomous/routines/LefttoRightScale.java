package frc.team2478.robot.commands.autonomous.routines;

import edu.wpi.first.wpilibj.command.CommandGroup;
import edu.wpi.first.wpilibj.command.WaitCommand;
import frc.team2478.robot.Constants;
import frc.team2478.robot.commands.autonomous.AutonomoDriveStraight;
import frc.team2478.robot.commands.autonomous.AutonomoDriveTurn;
import frc.team2478.robot.commands.pneumatics.LowerHood;
import frc.team2478.robot.commands.pneumatics.RaiseHood;
import frc.team2478.robot.commands.scoring.StopAllScoringMotors;
import frc.team2478.robot.commands.scoring.feed.RunFeedAtDefault;
import frc.team2478.robot.commands.scoring.shooter.RunShooterAtVelocity;

public class LefttoRightScale extends CommandGroup {
	
	public LefttoRightScale() {
		addParallel(new LowerHood());
		addSequential(new AutonomoDriveStraight(200));
		addSequential(new AutonomoDriveTurn(90));
		addSequential(new AutonomoDriveStraight(265));
		addSequential(new AutonomoDriveTurn(-90));
		addSequential(new AutonomoDriveStraight(70));
		addParallel(new RunShooterAtVelocity(Constants.ShooterRig.AUTO_SPEED));
		addParallel(new RaiseHood());
		addSequential(new AutonomoDriveTurn(-90));
		addParallel(new RunFeedAtDefault());
		addSequential(new WaitCommand(2));
		addSequential(new StopAllScoringMotors());
	}

}