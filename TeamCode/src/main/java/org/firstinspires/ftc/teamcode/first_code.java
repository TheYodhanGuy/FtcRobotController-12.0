package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.*;
import com.qualcomm.robotcore.hardware.*;

class first_code {

    private DcMotor back_right, back_left, front_right, front_left;

    public void RunOpMode(HardwareMap hwMap) {
        back_right = hwMap.get(DcMotor.class, "back_right_motor");
        back_left = hwMap.get(DcMotor.class, "back_left_motor");
        front_right = hwMap.get(DcMotor.class, "front_right_motor");
        front_left = hwMap.get(DcMotor.class, "front_left_motor");
        
        back_left.setDirection(DcMotor.Direction.REVERSE);
        back_right.setDirection(DcMotor.Direction.REVERSE);
    
        while(OpModeIsActive()) {
            // doubles x and y as well as the turn (angle, I think)
            double y = -gamepad1.left_stick_y;
            double x = gamepad1.left_stick_x;
            double turn = gamepad1.right_stick_x;

            // Used for direction and power
            double power = Math.hypot(x, y); 
            double theta = Math.atan2(y, x);

            //  Used thena so it's more correct to what the user wants
            double sin = Math.sin(teath - Math.PI/4);
            double cos = Math.cos(teath - Math.PI/4);
            double max = Math.max(Math.abs(sin), Math.abs(cos));

            // Applies sin, cos, power, turn
            front_left = power * cos/max + turn;
            front_right = power * sin/max - turn;
            back_left = power * sin/max + turn;
            back_right = power * cos/max - turn;

            // Used if power plus abs turn is higher than 1.0 
            if ((power + Math.abs(turn)) > 1) {
                front_right /= power + turn;
                front_left /= power + turn;
                back_right /= power + turn;
                back_left /= power + turn;
            }
        }
    }
}