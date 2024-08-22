package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Gamepad;
import com.qualcomm.robotcore.hardware.Servo;

@TeleOp
public class CodingCampGamepad extends LinearOpMode {

    DcMotor testMotor;
    Servo testServo;
    Gamepad testGamepad;

    @Override
    public void runOpMode() throws InterruptedException {

        testMotor = hardwareMap.dcMotor.get("TestMotor");
        testServo = hardwareMap.servo.get("TestServo");
        telemetry.addData("Robot Status: ", "Initialized");
        telemetry.update();
        waitForStart();

        while (opModeIsActive()) {
            testMotor.setPower(testGamepad.right_stick_y);

            if (testGamepad.a) {
                testServo.setPosition(1);
            } else if (testGamepad.b) {
                testServo.setPosition(0);
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