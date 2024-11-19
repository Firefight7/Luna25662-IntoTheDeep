package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.CRServo;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.Servo;


@TeleOp(name = "LunaTeleOp")
public class LunaTele extends OpMode {

    DcMotor fR;
    DcMotor fL;
    DcMotor rR;
    DcMotor rL;
    DcMotor slide;
    DcMotor manipulatorLift;

    CRServo intake;
    CRServo spin;
    //Servo spin;


    public void init(){

        fR = hardwareMap.dcMotor.get("FrontRight");
        fL = hardwareMap.dcMotor.get("FrontLeft");
        rR = hardwareMap.dcMotor.get("RearRight");
        rL = hardwareMap.dcMotor.get("RearLeft");
        manipulatorLift = hardwareMap.dcMotor.get("clawLift");
        slide = hardwareMap.dcMotor.get("slide");
        intake = hardwareMap.crservo.get("intake");
       // spin = hardwareMap.servo.get("turn");
        spin = hardwareMap.crservo.get("turn");

        
        //fR.setDirection(DcMotor.Direction.REVERSE);
        rR.setDirection(DcMotor.Direction.REVERSE);
        manipulatorLift.setDirection(DcMotor.Direction.REVERSE);

    }

    public void loop(){
        // slide.setTargetPosition(1000);

        double forward = 0.8 * gamepad1.left_stick_y;
        double strafe = 0.8 * gamepad1.left_stick_x;
        double turn = 0.8 * gamepad1.right_stick_x;

        double lift =  0.55 * gamepad2.left_stick_y;
        double slider = gamepad2.right_stick_y;


        //double wheel = gamepad2.left_trigger;

        fR.setPower(forward+strafe+turn);
        fL.setPower(forward-strafe-turn);
        rR.setPower(forward-strafe+turn);
        rL.setPower(forward+strafe-turn);

        manipulatorLift.setPower(lift+.15);
        slide.setPower(slider);

//Power for intake
        if (gamepad2.a) {
            intake.setPower(1);
        }
        else if (gamepad2.b) {
            intake.setDirection(CRServo.Direction.REVERSE);
            intake.setPower(-.3);
        }
        else {
            intake.setPower(0);
        }
       /* if (gamepad2.x) {
            intake.setPower(0);
        } */

//Power for spin
        if (gamepad2.y) {
            spin.setPower(.5);
        }
        else if (gamepad2.x) {
            spin.setPower(-.5);
        }
        else {
            spin.setPower(0);
        }

        /* if (gamepad2.y) {
            spin.setPower(0);
        } */

// Position for spin
      /* if  (gamepad2.dpad_right) {
            spin.setPosition(.35);
        }
        if (gamepad2.dpad_left) {
            spin.setPosition(1.25);
        }
        if (gamepad2.dpad_down) {
            spin.setPosition(0.01);
        }*/

    }
}

