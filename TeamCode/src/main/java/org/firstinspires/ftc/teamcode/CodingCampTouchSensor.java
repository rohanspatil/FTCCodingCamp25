package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Gamepad;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.hardware.TouchSensor;

@TeleOp
public class CodingCampTouchSensor extends LinearOpMode {

    DcMotor testMotor;
    Servo testServo;
    Gamepad testGamepad;
    TouchSensor testTouchSensor;

    @Override
    public void runOpMode() throws InterruptedException {

        testMotor = hardwareMap.dcMotor.get("TestMotor");
        testServo = hardwareMap.servo.get("TestServo");
        testTouchSensor = hardwareMap.touchSensor.get("TestTouchSensor");
        telemetry.addData("Robot Status: ", "Initialized");
        telemetry.update();
        waitForStart();

        while (opModeIsActive()) {
            if (testTouchSensor.isPressed()) {
                testMotor.setPower(0.5);
            } else {
                testMotor.setPower(0);
            }
        }
    }

    public void moveMotorToPos(int encoderPos) {
        while (testMotor.getCurrentPosition() < encoderPos) {
            testMotor.setPower(0.5);
        }
        testMotor.setPower(0);
    }
}