package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;

@Autonomous
public class LunaAuto extends LinearOpMode {
    DcMotor Fr;
    DcMotor Fl;
    DcMotor Rr;
    DcMotor Rl;

    @Override
    public void runOpMode() throws InterruptedException {
        Fr = hardwareMap.dcMotor.get("FrontRight");
        Fl = hardwareMap.dcMotor.get("FrontLeft");
        Rr = hardwareMap.dcMotor.get("RearRight");
        Rl = hardwareMap.dcMotor.get("RearLeft");

        waitForStart();

        Fr.setPower(1);
        Fl.setPower(1);
        Rr.setPower(1);
        Rl.setPower(1);
        sleep(1000);
        Fr.setPower(0);
        Fl.setPower(0);
        Rr.setPower(0);
        Rl.setPower(0);

        if (isStopRequested()) return;

        while (opModeIsActive()) {


        }
    }
}
