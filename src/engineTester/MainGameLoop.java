//Author: VividerAphid
package engineTester;

import entities.Camera;
import entities.Entity;
import entities.Light;
import org.lwjgl.opengl.Display;
import renderEngine.DisplayManager;
import renderEngine.Loader;
import models.RawModel;
import models.TexturedModel;
import org.lwjgl.util.vector.Vector3f;
import renderEngine.MasterRenderer;
import renderEngine.OBJLoader;
import renderEngine.EntityRenderer;
import shaders.StaticShader;
import terrains.Terrain;
import textures.ModelTexture;

public class MainGameLoop {

    public static void main(String[] args) {
        DisplayManager.createDisplay();

        Loader loader = new Loader();

        //Test data     
//        float[] vertices = {
//            -0.5f, 0.5f, -0.5f, //0
//            -0.5f, -0.5f, -0.5f, //1
//            0.5f, -0.5f, -0.5f, //2
//            0.5f, 0.5f, -0.5f, //3
//            -0.5f, 0.5f, 0.5f, //4
//            -0.5f, -0.5f, 0.5f, //5
//            0.5f, -0.5f, 0.5f, //6
//            0.5f, 0.5f, 0.5f, //7
//            0.5f, 0.5f, -0.5f, //8
//            0.5f, -0.5f, -0.5f, //9
//            0.5f, -0.5f, 0.5f, //10
//            0.5f, 0.5f, 0.5f, //11
//            -0.5f, 0.5f, -0.5f, //12
//            -0.5f, -0.5f, -0.5f, //13
//            -0.5f, -0.5f, 0.5f, //14
//            -0.5f, 0.5f, 0.5f, //15
//            -0.5f, 0.5f, 0.5f, //16
//            -0.5f, 0.5f, -0.5f, //17
//            0.5f, 0.5f, -0.5f, //18
//            0.5f, 0.5f, 0.5f, //19 
//            -0.5f, -0.5f, 0.5f, //20
//            -0.5f, -0.5f, -0.5f, //21
//            0.5f, -0.5f, -0.5f, //22
//            0.5f, -0.5f, 0.5f //23
//        };
//    float[] textureCoords = {
//            0, 0,
//            0, 1,
//            1, 1,
//            1, 0,
//            0, 0,
//            0, 1,
//            1, 1,
//            1, 0,
//            0, 0,
//            0, 1,
//            1, 1,
//            1, 0,
//            0, 0,
//            0, 1,
//            1, 1,
//            1, 0,
//            0, 0,
//            0, 1,
//            1, 1,
//            1, 0,
//            0, 0,
//            0, 1,
//            1, 1,
//            1, 0
//        };
//
//        int[] indices = {
//            0, 1, 3,
//            3, 1, 2,
//            4, 5, 7,
//            7, 5, 6,
//            8, 9, 11,
//            11, 9, 10,
//            12, 13, 15,
//            15, 13, 14,
//            16, 17, 19,
//            19, 17, 18,
//            20, 21, 23,
//            23, 21, 22
//        };
//        
//        float[] normals = {
//            0.0f, 0.0f, -1.0f,
//            0.0f, 0.0f, -1.0f,
//            0.0f, 0.0f, 0.0f,
//            0.0f, 0.0f, 0.0f,
//            0.0f, 0.0f, 1.0f,
//            0.0f, 0.0f, 1.0f,
//            0.0f, 0.0f, 0.0f,
//            0.0f, 0.0f, 0.0f,
//            0.0f, 0.0f, 0.0f,
//            0.0f, 0.0f, 0.0f,
//            0.0f, 0.0f, 0.0f,
//            0.0f, 0.0f, 0.0f
//        };

        //RawModel model = loader.loadToVAO(vertices, textureCoords, normals, indices);
        RawModel model = OBJLoader.loadObjModel("simpletree-flat", loader);
        ModelTexture texture = new ModelTexture(loader.loadTexture("sand"));
        texture.setShineDamper(10);
        texture.setReflectivity(1);
        TexturedModel staticModel = new TexturedModel(model, texture);
        Entity entity = new Entity(staticModel, new Vector3f(0, 0, -5), 0, 0, 0, 1);
        Terrain terrain = new Terrain(0, 0, loader, new ModelTexture(loader.loadTexture("grass")));
        Terrain terrain2 = new Terrain(1, 0, loader, new ModelTexture(loader.loadTexture("grass")));
        //Entity entity2 = new Entity(staticModel, new Vector3f(0, 0, -7), 0, 0, 0, 1);
        //Entity entity2 = new Entity(staticModel, new Vector3f(-5, 0, 5), 0, 0, 0, 1);
        //WorldBuilder bld = new WorldBuilder();
        //Entity[] world = bld.buildWorld(25,3,25,loader);
        //System.out.println(world.toString());
        Light light = new Light(new Vector3f(0,20,0), new Vector3f(1,1,1));
        //Light light2 = new Light(new Vector3f(10,0,-5), new Vector3f(1,1,1));

        Camera camera = new Camera();

        MasterRenderer renderer = new MasterRenderer();        
        
        while (!Display.isCloseRequested()) {
            camera.move();
            renderer.processTerrain(terrain);
            renderer.processTerrain(terrain2);
            renderer.processEntity(entity);
            
            renderer.render(light, camera);
            DisplayManager.updateDisplay();
        }
        renderer.cleanUp();
        loader.cleanUp();
        DisplayManager.closeDisplay();
    }
}
