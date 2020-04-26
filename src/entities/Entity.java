//Author: VividerAphid
package entities;

import models.TexturedModel;
import org.lwjgl.util.vector.Vector3f;

public class Entity {
    private TexturedModel model;
    private Vector3f positionl;
    private float rotX, rotY, rotZ;
    private float scale;

    public Entity(TexturedModel model, Vector3f positionl, float rotX, float rotY, float rotZ, float scale) {
        this.model = model;
        this.positionl = positionl;
        this.rotX = rotX;
        this.rotY = rotY;
        this.rotZ = rotZ;
        this.scale = scale;
    }

    public TexturedModel getModel() {
        return model;
    }

    public void setModel(TexturedModel model) {
        this.model = model;
    }

    public Vector3f getPositionl() {
        return positionl;
    }

    public void setPositionl(Vector3f positionl) {
        this.positionl = positionl;
    }

    public float getRotX() {
        return rotX;
    }

    public void setRotX(float rotX) {
        this.rotX = rotX;
    }

    public float getRotY() {
        return rotY;
    }

    public void setRotY(float rotY) {
        this.rotY = rotY;
    }

    public float getRotZ() {
        return rotZ;
    }

    public void setRotZ(float rotZ) {
        this.rotZ = rotZ;
    }

    public float getScale() {
        return scale;
    }

    public void setScale(float scale) {
        this.scale = scale;
    }
    
}