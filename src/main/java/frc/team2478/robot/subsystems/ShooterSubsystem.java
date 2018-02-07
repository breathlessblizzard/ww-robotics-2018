package frc.team2478.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.FeedbackDevice;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj.command.Subsystem;
import frc.team2478.robot.interfaces.ShooterInterface;

/**
 * Instantiates shooter motors and sets up Talon PIDs,
 * and provides methods for using or altering them.
 */
public class ShooterSubsystem extends Subsystem implements ShooterInterface {

	public WPI_TalonSRX masterMotor, slaveMotor;
	
	public final int MASTER_MOTOR = 7;
	public final int SLAVE_MOTOR = 8;
	
	public final int PROCESS_ID = 0;
	public final int TIMEOUT_MS = 10;
	
	public ShooterSubsystem() {
		masterMotor = new WPI_TalonSRX(MASTER_MOTOR);
		slaveMotor = new WPI_TalonSRX(SLAVE_MOTOR);
		
		//slaveMotor.setInverted(true);
		slaveMotor.follow(masterMotor);
		
		masterMotor.configSelectedFeedbackSensor(
				FeedbackDevice.QuadEncoder,
				PROCESS_ID,
				TIMEOUT_MS);
		
		masterMotor.setSensorPhase(true);
	}
	
	@Override
	public void setTargetVelocity(double velocity) {
		masterMotor.set(ControlMode.Velocity, velocity);
	}
	
	@Override
	public double getVelocity() {
		return masterMotor.getSelectedSensorVelocity(PROCESS_ID);
	}
	
	@Override
	public double getPosition() {
		return masterMotor.getSelectedSensorPosition(PROCESS_ID);
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
	public void setPID(double p, double i, double d) {
		masterMotor.config_kP(PROCESS_ID, p, TIMEOUT_MS);
		masterMotor.config_kI(PROCESS_ID, i, TIMEOUT_MS);
		masterMotor.config_kD(PROCESS_ID, d, TIMEOUT_MS);
	}
	
	@Override
	public void setFeedForward(double f) {
		masterMotor.config_kF(PROCESS_ID, f, TIMEOUT_MS);		
	}

	@Override
	public void resetEncoder() {
		masterMotor.setSelectedSensorPosition(0, PROCESS_ID, TIMEOUT_MS);
	}

	@Override
	@Deprecated
	public boolean isUsingPid() {
		return true;
	}
	
	@Override
	@Deprecated
	public void setUsingPid(boolean b) {}

	@Override
	protected void initDefaultCommand() {}
}