package frc.team2478.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj.command.Subsystem;
import frc.team2478.robot.interfaces.MotorInterface;

/**
 * Instantiates intake motors, and provides methods for using them.
 */
public class IntakeSubsystem extends Subsystem implements MotorInterface {

	private final int SLAVE_MOTOR = 7;
	private final int MASTER_MOTOR = 8;

	private WPI_TalonSRX masterMotor, slaveMotor;
	
	public IntakeSubsystem() {
		masterMotor = new WPI_TalonSRX(MASTER_MOTOR);
		slaveMotor = new WPI_TalonSRX(SLAVE_MOTOR);
		
		//slaveMotor.setInverted(true);
		slaveMotor.follow(masterMotor);
	}
	
	@Override
	public void setTargetPercentage(double percent) {
		masterMotor.set(ControlMode.PercentOutput, percent);
	}
	
	@Override
	public void stop() {
		masterMotor.stopMotor();
	}
	
	@Override
	protected void initDefaultCommand() {}
}
