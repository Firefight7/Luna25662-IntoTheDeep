package org.firstinspires.ftc.teamcode;
import android.graphics.Canvas;
import android.graphics.Point;


import org.firstinspires.ftc.robotcore.internal.camera.calibration.CameraCalibration;
import org.firstinspires.ftc.vision.VisionProcessor;
import org.opencv.core.Core;
import org.opencv.core.Mat;
import org.opencv.core.Rect;
import org.opencv.core.Scalar;
import org.opencv.imgproc.Imgproc;


public class ColorProcessor implements VisionProcessor{

    Rect Middle_Rectangle;

    Mat hsvMat = new Mat();
    Mat lowMat = new Mat();
    Mat highMat = new Mat();
    Mat detectMat = new Mat();



    Scalar lowerRedThresholdlow = new Scalar(0,125,125);
    Scalar lowerRedThresholdHigh = new Scalar(10,125,125);

    Scalar higherRedThresholdlow = new Scalar(165,125,125);
    Scalar higherRedThresholdHigh = new Scalar(180,255,255);

    double middleThreshold = 0.1;
    int objPos = 0;



    @Override
    public void init(int width, int height, CameraCalibration calibration) {
        Middle_Rectangle = new Rect();

        new Point(0,0);
        new  Point(3, 3);

//lower bound is red,0-20,
// upper bound is red,340-360 for hue
// value for v is 65-100%
// value for saturation is 100-70%
// Hue is 0-180 in open cv
// saturation is 0-255 in open cv




    }

    @Override
    public Object processFrame(Mat frame, long captureTimeNanos) {
        Imgproc.cvtColor(frame, hsvMat, Imgproc.COLOR_RGB2HSV);

        Core.inRange(hsvMat, lowerRedThresholdlow,lowerRedThresholdHigh,lowMat);
        Core.inRange(hsvMat, lowerRedThresholdlow,lowerRedThresholdHigh,highMat);

        Core.bitwise_or(lowMat,highMat,detectMat);

        double middlePercentage = (Core.sumElems(detectMat.submat(Middle_Rectangle)).val[0]/255)/Middle_Rectangle.area();

        if (middlePercentage > middlePercentage){
            objPos = 1;
        }
        else objPos =0;


        return null;


    }
    @Override
    public void onDrawFrame(Canvas canvas, int onscreenWidth, int onscreenHeight, float scaleBmpPxToCanvasPx, float scaleCanvasDensity, Object userContext) {


    }
}
