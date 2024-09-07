package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Servo;

@TeleOp(name = "LunaExample")
public class LunaExample extends OpMode {


    DcMotor RrMotor;
    DcMotor RlMotor;
    DcMotor ClawMotor;
    Servo Claw;
    DcMotor TurnTable;


    public void init(){
        RrMotor = hardwareMap.dcMotor.get("RrMotor");
        RlMotor = hardwareMap.dcMotor.get("RlMotor");
        ClawMotor = hardwareMap.dcMotor.get("ClawMotor");
        Claw = hardwareMap.servo.get("Claw");
        TurnTable = hardwareMap.dcMotor.get("TurnTable");

        RrMotor.setDirection(DcMotor.Direction.REVERSE);
        RlMotor.setDirection(DcMotor.Direction.REVERSE);
    }

    public void loop(){
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
        }
    }
}