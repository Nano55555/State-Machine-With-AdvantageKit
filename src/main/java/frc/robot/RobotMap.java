package frc.robot;


import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.XboxController;
import frc.robot.lib.interfaces.GyroIO;
import frc.robot.lib.interfaces.GyroPigeon2;
import frc.robot.lib.interfaces.Swerve;
import frc.robot.lib.interfaces.SwerveModuleFalcon500;
import frc.robot.lib.interfaces.SwerveModuleIO;
import frc.robot.lib.interfaces.SwerveModuleSim;
import frc.robot.subsystems.drive.DrivetrainStateMachine;

public class RobotMap {

    /* state machine instances */
    public static DrivetrainStateMachine drivetrainStateMachine;

    /* Interface instances */
    public static Swerve swerve; 
   
    /* Xbox controllers */
    public static XboxController manipulatorController;
    public static XboxController driverController;

    public static void init() {

        switch(Constants.currentMode){
            case REAL:
                swerve = new Swerve(
                new GyroPigeon2(Constants.CAN_IDS.PIDGEON),
                new SwerveModuleFalcon500(Constants.SWERVE.Mod0.constants),
                new SwerveModuleFalcon500(Constants.SWERVE.Mod1.constants),
                new SwerveModuleFalcon500(Constants.SWERVE.Mod2.constants),
                new SwerveModuleFalcon500(Constants.SWERVE.Mod3.constants));
                Timer.delay(1.0);
                swerve.resetModulesToAbsolute();
                swerve.gyro.zeroGyro();
                break;
            case REPLAY:
            swerve = new Swerve(
                new GyroIO(){},
                new SwerveModuleIO(){},
                new SwerveModuleIO(){},
                new SwerveModuleIO(){},
                new SwerveModuleIO(){});
            case SIM:
                new Swerve(
                new GyroIO(){},
                new SwerveModuleSim(){},
                new SwerveModuleSim(){},
                new SwerveModuleSim(){},
                new SwerveModuleSim(){});
                break;
            default:
                break;
    
    }
        /* By pausing init for a second before setting module offsets, we avoid a bug with inverting motors.
        * See https://github.com/Team364/BaseFalconSwerve/issues/8 for more info. */
        manipulatorController = new XboxController(1);
        driverController = new XboxController(0);
        drivetrainStateMachine = new DrivetrainStateMachine();
    }
}
