package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.DistanceSensor;
import com.qualcomm.robotcore.hardware.Gamepad;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.hardware.TouchSensor;

import org.firstinspires.ftc.robotcore.external.navigation.DistanceUnit;

@TeleOp
public class CodingCampTankDrive1 extends LinearOpMode {

    DcMotor rightFrontMotor, leftFrontMotor, rightRearMotor, leftRearMotor;
    Servo testServo;
    TouchSensor testTouchSensor;
    DistanceSensor testDistanceSensor;

    @Override
    public void runOpMode() throws InterruptedException {

        rightFrontMotor = hardwareMap.dcMotor.get("frontRightMotor");
        leftFrontMotor = hardwareMap.dcMotor.get("frontLeftMotor");
        rightRearMotor = hardwareMap.dcMotor.get("backRightMotor");
        leftRearMotor = hardwareMap.dcMotor.get("backLeftMotor");

        rightRearMotor.setDirection(DcMotorSimple.Direction.REVERSE);
        rightFrontMotor.setDirection(DcMotorSimple.Direction.REVERSE);

        testServo = hardwareMap.servo.get("TestServo");

        testTouchSensor = hardwareMap.touchSensor.get("TestTouchSensor");
        testDistanceSensor = hardwareMap.get(DistanceSensor.class, "TestDistanceSensor");

        telemetry.addData("Robot Status: ", "Initialized");
        telemetry.update();
        waitForStart();

        while (opModeIsActive()) {
            rightFrontMotor.setPower(this.gamepad1.right_stick_y);
            rightRearMotor.setPower(this.gamepad1.right_stick_y);

            leftFrontMotor.setPower(this.gamepad1.left_stick_y);
            leftRearMotor.setPower(this.gamepad1.left_stick_y);
        }
    }
}