package frc.robot.subsystems.drive;
import edu.wpi.first.math.MathUtil;
import edu.wpi.first.math.geometry.Translation2d;
import frc.robot.Constants;
import frc.robot.RobotMap;
import frc.robot.lib.statemachine.State;

public class TeleopState extends State {

    // // Translation Constraints
    // private final TrapezoidProfile.Constraints m_Constraints =
    //     new TrapezoidProfile.Constraints(1, 1);

    // private TrapezoidProfile.State m_setpoint = new TrapezoidProfile.State();

    public TeleopState() {}

    @Override
    public void build() {}

    @Override
    public void init(State prevState) {}

    @Override
    public void execute() {
        double translationVal = -1.0 * MathUtil.applyDeadband(-RobotMap.driverController.getRawAxis(Constants.DriverControls.TRANSLATION_VAL) , Constants.STICK_DEADBAND);
        double strafeVal = -1.0 * MathUtil.applyDeadband(-RobotMap.driverController.getRawAxis(Constants.DriverControls.STRAFE_VAL), Constants.STICK_DEADBAND);
        double rotationVal = MathUtil.applyDeadband(-RobotMap.driverController.getRawAxis(Constants.DriverControls.ROTATION_VAL), Constants.STICK_DEADBAND);

        

        // Logger.getInstance().recordOutput("INPUT", translationVal);

        // TrapezoidProfile.State m_goal = new TrapezoidProfile.State(translationVal, 0.0);
        // // Create a motion profile with the given maximum velocity and maximum
        // // acceleration constraints for the next setpoint, the desired goal, and the
        // // current setpoint.
        // var profile = new TrapezoidProfile(m_Constraints, m_goal, m_setpoint);

        // // Retrieve the profiled setpoint for the next timestep. This setpoint moves
        // // toward the goal while obeying the constraints.
        // m_setpoint = profile.calculate(0.02);

        // translationVal = m_setpoint.position;

        
        // Logger.getInstance().recordOutput("OUTPUT", translationVal);

        RobotMap.swerve.drive(
            new Translation2d(translationVal, strafeVal).times(Constants.SWERVE.MAX_SPEED), 
            rotationVal * Constants.SWERVE.MAX_ANGULAR_VELOCITY, 
            true,
            true
        );
        
       
        
    }

    @Override
    public void exit(State nextState) {
        RobotMap.swerve.drive(
            new Translation2d(0, 0).times(Constants.SWERVE.MAX_SPEED), 
            0 * Constants.SWERVE.MAX_ANGULAR_VELOCITY, 
            true, 
            true
        );
    }
}
