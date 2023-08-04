// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.lib.interfaces;

import frc.robot.RobotMap;

/** Add your docs here. */
public class SwerveModuleSim implements SwerveModuleIO {

    @Override
    public void updateInputs(SwerveModuleIOInputs inputs) {
         inputs.driveMotorSensorPos = RobotMap.driverController.getLeftY();
    }
  
}
