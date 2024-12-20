
package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.CRServo;
import com.qualcomm.robotcore.hardware.DcMotor;

@Autonomous(name = "AutoFull")
public class AutoFull extends LinearOpMode {
    DcMotor fR;
    DcMotor fL;
    DcMotor rR;
    DcMotor rL;
    DcMotor manipulatorLift;
    DcMotor slide;
    CRServo intake;

    @Override
    public void runOpMode() throws InterruptedException {
        fR = hardwareMap.dcMotor.get("FrontRight");
        fL = hardwareMap.dcMotor.get("FrontLeft");
        rR = hardwareMap.dcMotor.get("RearRight");
        rL = hardwareMap.dcMotor.get("RearLeft");
        manipulatorLift = hardwareMap.dcMotor.get("clawLift");
        //manipulatorLift.setDirection(DcMotor.Direction.REVERSE);
        intake = hardwareMap.crservo.get("intake");
        slide = hardwareMap.dcMotor.get("slide");


        //if (isStopRequested()) return;
        waitForStart();
        while (opModeIsActive()) {

            cubeGrab();
            sleep(30000);

            //encoderMovement(0,0,0,0);
            /*drive(-1600, -1600, 1600, 1600, 0.7);
            sleep(30000);*/
            // Sets ticks for encoders


        }
    }

    public void cubeGrab () {

        intake.setPower(-1);
        sleep(2000);  //prev 2000

        manipulatorLift.setPower(+.55);

        straight(790,.8);
        //+ go straign - go back
        sleep(100);   //prev 1000

        strafe(-1700,.8);
        //+ strafe right - strafe left
        sleep(100);    //prev 1000

        turn(1600,.8);
        //+ turn left - turn right
        sleep(100);     //prev 1000

   /*     straight(50,.8);
        //+ go straign - go back
        sleep(100);   //prev 1000
       //test to see if it needs to go strAIGHT BEFROE DUMP
    */

        slider(-6100,.7);   //prev 6100   test based on spring condition
        sleep(5000);   //prev 5000

        intake.setPower(1);
        sleep(2000);  //prev 2000
        intake.setPower(0);
        sleep(1000);    //prev 1000

        manipulatorLift.setPower(+1);
        sleep(1000);    //prev 1000
        slider(6000,.7);
        sleep(3000);    //prev 1000
        manipulatorLift.setPower(+.2);
        sleep(100);

        //End of first cycle




        straight(200,.8);
        //+ go straign - go back
        sleep(1000);

        turn(-600,.8);
        //+ turn left - turn
        sleep(1000);

        straight(-690,.8);
        //+ go straign - go back
        sleep(1000);

        strafe(875,.8);
        //+ strafe right - strafe left
        sleep(1000);

        straight(100,.8);
        //+ go straign - go back
        sleep(1000);

        intake.setPower(1);
        sleep(1000);

        manipulatorLift.setPower(+.1);

        intake.setPower(-1);
        sleep(2000);
/*
        manipulatorLift.setPower(+.55);

        straight(-300,.8);
        //+ go straign - go back
        sleep(1000);

        strafe(-1000,.8);
        //+ strafe right - strafe left
        sleep(1000);

        straight(600,.8);
        //+ go straign - go back
        sleep(1000);

        turn(1600,.8);
        //+ turn left - turn right
        sleep(1000);

        slider(-6100,.7);
        sleep(5000);

        intake.setPower(1);
        sleep(2000);
        intake.setPower(0);
        sleep(1000);

        manipulatorLift.setPower(+1);
        sleep(1000);
        slider(6000,.7);
        sleep(1000);
        manipulatorLift.setPower(+.2);  */

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
    }

    public void straight(int dir, double power){
        drive(dir,-dir,dir,-dir, power);
    }

    public void strafe(int dir,double power){
        drive(dir,dir,-dir,-dir, power);
    }

    public void turn(int trn,double power){
        drive(trn,trn,trn,trn,power);
    }

    public void slider(int sld, double power){
        slide.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);

        slide.setTargetPosition(sld);

        slide.setPower(power);

        slide.setMode(DcMotor.RunMode.RUN_TO_POSITION);
    }
}