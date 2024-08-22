package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DistanceSensor;
import com.qualcomm.robotcore.hardware.Gamepad;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.hardware.TouchSensor;

import org.firstinspires.ftc.robotcore.external.navigation.DistanceUnit;

@TeleOp
public class CodingCampTankDrive2 extends LinearOpMode {

    DcMotor rightFrontMotor, leftFrontMotor, rightRearMotor, leftRearMotor;
    Servo testServo;
    Gamepad testGamepad;
    TouchSensor testTouchSensor;
    DistanceSensor testDistanceSensor;

    @Override
    public void runOpMode() throws InterruptedException {

        rightFrontMotor = hardwareMap.dcMotor.get("RightFrontMotor");
        leftFrontMotor = hardwareMap.dcMotor.get("leftFrontMotor");
        rightRearMotor = hardwareMap.dcMotor.get("RightRearMotor");
        leftRearMotor = hardwareMap.dcMotor.get("LeftRearMotor");

        testServo = hardwareMap.servo.get("TestServo");

        testTouchSensor = hardwareMap.touchSensor.get("TestTouchSensor");
        testDistanceSensor = hardwareMap.get(DistanceSensor.class, "TestDistanceSensor");

        telemetry.addData("Robot Status: ", "Initialized");
        telemetry.update();
        waitForStart();

        while (opModeIsActive()) {
            rightFrontMotor.setPower(testGamepad.left_stick_y-testGamepad.right_stick_x-testGamepad.left_stick_x);
            rightRearMotor.setPower(testGamepad.left_stick_y-testGamepad.right_stick_x+testGamepad.left_stick_x);

            leftFrontMotor.setPower(-testGamepad.left_stick_y+testGamepad.right_stick_x+testGamepad.left_stick_x);
            leftRearMotor.setPower(-testGamepad.left_stick_y+testGamepad.right_stick_x-testGamepad.left_stick_x);
        }
    }
}