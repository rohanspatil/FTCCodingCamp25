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
public class CodingCampDistanceSensor extends LinearOpMode {

    DcMotor testMotor;
    Servo testServo;
    DistanceSensor testDistanceSensor;

    @Override
    public void runOpMode() throws InterruptedException {

        testMotor = hardwareMap.dcMotor.get("TestMotor");
        testServo = hardwareMap.servo.get("TestServo");
        testDistanceSensor = hardwareMap.get(DistanceSensor.class, "TestDistanceSensor");
        telemetry.addData("Robot Status: ", "Initialized");
        telemetry.update();
        waitForStart();

        while (opModeIsActive()) {
            telemetry.addData("Distance: ", testDistanceSensor.getDistance(DistanceUnit.CM));
            if (testDistanceSensor.getDistance(DistanceUnit.CM) < 10) {
                testMotor.setPower(0.5);
            } else {
                testMotor.setPower(0);
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