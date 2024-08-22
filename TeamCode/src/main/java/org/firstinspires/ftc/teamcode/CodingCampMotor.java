package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;

@TeleOp
public class CodingCampMotor extends LinearOpMode {

    DcMotor testMotor;

    @Override
    public void runOpMode() throws InterruptedException {

        testMotor = hardwareMap.dcMotor.get("TestMotor");
        telemetry.addData("Robot Status: ", "Initialized");
        telemetry.update();
        waitForStart();

        testMotor.setPower(0.5);
        sleep(2000);
        testMotor.setPower(0);
    }
}
