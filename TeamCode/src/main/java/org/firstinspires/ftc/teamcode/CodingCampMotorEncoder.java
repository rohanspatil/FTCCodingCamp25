package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Servo;

@TeleOp
public class CodingCampMotorEncoder extends LinearOpMode {

    DcMotor testMotor;
    Servo testServo;

    @Override
    public void runOpMode() throws InterruptedException {

        testMotor = hardwareMap.dcMotor.get("TestMotor");
        testServo = hardwareMap.servo.get("TestServo");
        telemetry.addData("Robot Status: ", "Initialized");
        telemetry.update();
        waitForStart();

        moveMotorToPos(10000);
    }

    public void moveMotorToPos(int encoderPos) {
        testMotor.setPower(0.5);
        while (testMotor.getCurrentPosition() < encoderPos) {
            telemetry.addData("Motor Position: ", testMotor.getCurrentPosition());
            telemetry.update();
        }
        testMotor.setPower(0);
    }
}