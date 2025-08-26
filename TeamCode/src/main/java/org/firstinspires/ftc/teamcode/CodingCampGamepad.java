package org.firstinspires.ftc.teamcode;

import androidx.core.math.MathUtils;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Gamepad;
import com.qualcomm.robotcore.hardware.Servo;

@TeleOp
public class CodingCampGamepad extends LinearOpMode {

    DcMotor testMotor;
    Servo testServo;

    @Override
    public void runOpMode() throws InterruptedException {

        testMotor = hardwareMap.dcMotor.get("TestMotor");
        testServo = hardwareMap.servo.get("TestServo");
        telemetry.addData("Robot Status: ", "Initialized");
        telemetry.update();
        waitForStart();

        while (opModeIsActive()) {
            double leftStickY = this.gamepad1.left_stick_y;
            telemetry.addData("leftStickY: ", leftStickY);
            if (leftStickY < 0.2 && leftStickY > -0.2) {
                leftStickY = 0;
            }
            testMotor.setPower(leftStickY);

            if (this.gamepad1.a) {
                testServo.setPosition(1);
            } else if (this.gamepad1.b) {
                testServo.setPosition(0);
            }
            telemetry.update();
        }
    }

    /*public void moveMotorToPos(int encoderPos) {
        while (testMotor.getCurrentPosition() < encoderPos) {
            testMotor.setPower(0.5);
        }
        testMotor.setPower(0);
    }*/
}