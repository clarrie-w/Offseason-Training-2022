// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;

import com.revrobotics.CANSparkMax;
// import com.revrobotics.CANSparkMax.ControlType;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;
import com.revrobotics.RelativeEncoder;
import com.revrobotics.SparkMaxPIDController;

// implementation of drive train
public class DriveSubsystem extends SubsystemBase {
  CANSparkMax L1motor;
  RelativeEncoder L1encoder;
  SparkMaxPIDController L1controller;
  CANSparkMax L2motor;
  RelativeEncoder L2encoder;
  SparkMaxPIDController L2controller;
  CANSparkMax R1motor;
  RelativeEncoder R1encoder;
  SparkMaxPIDController R1controller;
  CANSparkMax R2motor;
  RelativeEncoder R2encoder;
  SparkMaxPIDController R2controller;

  // constructor setting initial values of instance variables
  public DriveSubsystem() {
    L1motor = new CANSparkMax(0, MotorType.kBrushless);
    L1encoder = L1motor.getEncoder();
    L1controller = L1motor.getPIDController();

    L2motor = new CANSparkMax(1, MotorType.kBrushless);
    L2encoder = L2motor.getEncoder();
    L2controller = L2motor.getPIDController();

    R1motor = new CANSparkMax(2, MotorType.kBrushless);
    R1encoder = R1motor.getEncoder();
    R1controller = R1motor.getPIDController();
    
    R2motor = new CANSparkMax(3, MotorType.kBrushless);
    R2encoder = R2motor.getEncoder();
    R2controller = R2motor.getPIDController();
  }

  // feed percent voltage power into both sides of drive train
  // mapping individual talons to voltage 
  public void TankDrive(double Left, double Right) {
    L1motor.set(Left);
    L2motor.set(Left);
    R1motor.set(Right);
    R2motor.set(Right);
  }

  // wrapper function that allows for turning in tank drive
  public void ArcadeDrive(double speed, double turn) {
    TankDrive(speed - turn, speed + turn);
  }
}
