package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;

@Autonomous(name = "LunaAuto")
public class LunaAuto extends LinearOpMode {
    DcMotor fR;
    DcMotor fL;
    DcMotor rR;
    DcMotor rL;
    DcMotor manipulatorLift;

    @Override
    public void runOpMode() throws InterruptedException {
        fR = hardwareMap.dcMotor.get("FrontRight");
        fL = hardwareMap.dcMotor.get("FrontLeft");
        rR = hardwareMap.dcMotor.get("RearRight");
        rL = hardwareMap.dcMotor.get("RearLeft");
        manipulatorLift = hardwareMap.dcMotor.get("clawLift");
        manipulatorLift.setDirection(DcMotor.Direction.REVERSE);

        //if (isStopRequested()) return;

        while (opModeIsActive()) {

            drive(-547,547,-547,547, 0.7);
            // Sets ticks for encoders
            manipulatorLift.setPower(-.25);

        }
    }
    public void drive(int rB, int lB, int rF, int lF, double power) {

        rR.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        rL.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        fR.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        fL.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);

        rR.setTargetPosition(rB);
        rL.setTargetPosition(lB);
        fR.setTargetPosition(rF);
        fL.setTargetPosition(lF);

        rR.setPower(power);
        rL.setPower(power);
        fR.setPower(power);
        fL.setPower(power);

        rR.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        rL.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        fR.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        fL.setMode(DcMotor.RunMode.RUN_TO_POSITION);

        // Blocking While Loop: doesn't break until all 4 motors have stopped moving
        // Sets power of motors to 0 after the loop breaks
        while (opModeIsActive() && (rR.isBusy() || rL.isBusy() || fR.isBusy() || fL.isBusy())) {
        }

        rR.setPower(0);
        rL.setPower(0);
        fR.setPower(0);
        fL.setPower(0);
        //test to see if sleep works
        sleep(100);
    }
}
