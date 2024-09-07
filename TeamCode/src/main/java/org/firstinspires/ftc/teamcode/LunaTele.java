package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;


@TeleOp(name = "Luna")
public class LunaTele extends OpMode {

    DcMotor Fr;
    DcMotor Fl;
    DcMotor Rr;
    DcMotor Rl;

    public void init(){

        Fr = hardwareMap.dcMotor.get("FrontRight");
        Fl = hardwareMap.dcMotor.get("FrontLeft");
        Rr = hardwareMap.dcMotor.get("RearRight");
        Rl = hardwareMap.dcMotor.get("RearLeft");

        Fr.setDirection(DcMotor.Direction.REVERSE);
        Rl.setDirection(DcMotor.Direction.REVERSE);

    }

    public void loop(){
        double forward = gamepad1.left_stick_y;
        double strafe = gamepad1.left_stick_x;
        double turn = gamepad2.right_stick_x;

        Fr.setPower(forward-strafe-turn);
        Fl.setPower(forward+strafe+turn);
        Rr.setPower(forward+strafe-turn);
        Rl.setPower(forward-strafe+turn);










        /*
        double forward = gamepad1.left_stick_y;
        double turn = gamepad1.left_stick_x;
        double arm = gamepad2.left_stick_y;
        double turntable = gamepad1.left_trigger;

        ClawMotor.setPower(arm*.5);
        RrMotor.setPower(forward + turn);
        RlMotor.setPower(-forward + turn);
        TurnTable.setPower(turntable);

         if (gamepad2.a){
            Claw.setPosition(1);
        }
        if (gamepad2.b){
            Claw.setPosition(.8);
        }
        if (gamepad2.x){
            Claw.setPosition(.5);
            */

    }
}

