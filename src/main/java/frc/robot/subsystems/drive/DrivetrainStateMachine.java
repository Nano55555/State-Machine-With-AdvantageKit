package frc.robot.subsystems.drive;

import frc.robot.lib.statemachine.StateMachine;

public class DrivetrainStateMachine extends StateMachine {

    public static TeleopState teleopSwerve = new TeleopState();
    public static AutoState autoState = new AutoState();

    public DrivetrainStateMachine() {
        teleopSwerve.build();
        autoState.build();

        setCurrentState(autoState);
    }
    
}
