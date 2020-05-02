//Author: VividerAphid
package entities;

import org.lwjgl.input.Keyboard;
import org.lwjgl.util.vector.Vector3f;

public class Camera {
    private Vector3f position = new Vector3f(0,0,0);
    private float pitch;
    private float yaw;
    private float roll;
    
    public Camera(){}
    
    public void move(){
        if(Keyboard.isKeyDown(17)){ //W
            position.z -=0.02f;
        }
        if(Keyboard.isKeyDown(31)){ //S
            position.z +=0.02f;
        }
        if(Keyboard.isKeyDown(30)){ //A
            position.x -=0.02f;
        }
        if(Keyboard.isKeyDown(32)){ //D
            position.x +=0.02f;
        }
        if(Keyboard.isKeyDown(42)){ //LSHIFT
            position.y -=0.02f;
        }
        if(Keyboard.isKeyDown(57)){ //SPACE
            position.y +=0.02f;
        }
        if(Keyboard.isKeyDown(200)){ //UP
            pitch -=0.5f;
        }
        if(Keyboard.isKeyDown(208)){ //DOWN
            pitch +=0.5f;
        }
        if(Keyboard.isKeyDown(203)){ //LEFT
            yaw -=0.5f;
        }
        if(Keyboard.isKeyDown(205)){ //RIGHT
            yaw +=0.5f;
        }
    }

    public Vector3f getPosition() {
        return position;
    }

    public float getPitch() {
        return pitch;
    }

    public float getYaw() {
        return yaw;
    }

    public float getRoll() {
        return roll;
    }
    
}