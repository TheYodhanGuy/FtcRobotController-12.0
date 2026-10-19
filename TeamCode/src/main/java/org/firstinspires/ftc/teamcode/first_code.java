package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.hardware.*;

class first_code {
    private DcMotor back_right, back_left, front_right, front_left;

    public void init(HardwareMap hwMap) {
        back_right = hwMap.get(DcMotor.class, "back_right_motor");
        back_left = hwMap.get(DcMotor.class, "back_left_motor");
        front_right = hwMap.get(DcMotor.class, "front_right_motor");
        front_left = hwMap.get(DcMotor.class, "front_left_motor");
        
        back_left.setDirection(DcMotor.Direction.REVERSE);
        front_left.setDirection(DcMotor.Direction.REVERSE);
    }
}