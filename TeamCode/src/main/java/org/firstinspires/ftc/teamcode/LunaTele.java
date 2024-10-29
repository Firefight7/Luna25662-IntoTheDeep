package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
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
    Servo wheel;
    Servo spin;


    public void init(){

        fR = hardwareMap.dcMotor.get("FrontRight");
        fL = hardwareMap.dcMotor.get("FrontLeft");
        rR = hardwareMap.dcMotor.get("RearRight");
        rL = hardwareMap.dcMotor.get("RearLeft");
        manipulatorLift = hardwareMap.dcMotor.get("clawLift");
        slide = hardwareMap.dcMotor.get("slide");
        wheel = hardwareMap.servo.get("wheel");
        spin = hardwareMap.servo.get("turn");

        
        //fR.setDirection(DcMotor.Direction.REVERSE);
        rR.setDirection(DcMotor.Direction.REVERSE);
        manipulatorLift.setDirection((DcMotorSimple.Direction.REVERSE));

    }

    public void loop(){
        // slide.setTargetPosition(1000);

        double forward = 0.8 * gamepad1.left_stick_y;
        double strafe = 0.8 * gamepad1.left_stick_x;
        double turn = 0.8 * gamepad1.right_stick_x;
        double lift =  0.55 * gamepad2.left_stick_y;
        double slider = gamepad2.right_stick_y;

        fR.setPower(forward+strafe+turn);
        fL.setPower(forward-strafe-turn);
        rR.setPower(forward-strafe+turn);
        rL.setPower(forward+strafe-turn);

        manipulatorLift.setPower(lift);
        slide.setPower(slider);


       /* if (gamepad2.a) {
            wheel.setPosition(.3);
        }
        if (gamepad2.x) {
            wheel.setPosition(.5);
        }
         */

        while (gamepad2.a) {
            wheel.setPosition(1);

        }



        if  (gamepad2.dpad_right) {
            spin.setPosition(0.1);
        }
        if (gamepad2.dpad_left) {
            spin.setPosition(.8);
        }
        if (gamepad2.dpad_down) {
            spin.setPosition(.5);
        }

    }
}

