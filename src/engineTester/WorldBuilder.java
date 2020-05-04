//Author: VividerAphid
package engineTester;

import entities.Entity;
import java.util.ArrayList;
import java.util.List;
import models.RawModel;
import models.TexturedModel;
import org.lwjgl.util.vector.Vector3f;
import renderEngine.Loader;
import renderEngine.OBJLoader;
import textures.ModelTexture;

public class WorldBuilder {
    public Entity[] buildWorld(int width, int height, int depth, Loader loader){
        RawModel[] models = new RawModel[2];
        models[0] = OBJLoader.loadObjModel("cube", loader);
        models[1] = OBJLoader.loadObjModel("simpletree-flat", loader);
        
        ModelTexture[] textures = new ModelTexture[3];
        textures[0] = new ModelTexture(loader.loadTexture("grass"));
        textures[1] = new ModelTexture(loader.loadTexture("sand"));
        
        List<Entity> worldList = new ArrayList<Entity>();
        
        
        //Make Base level
        for(int z = -(depth/2); z <= (depth/2); z++){
            for(int x = -(width/2); x <= (width/2); x++){
               worldList.add(new Entity(new TexturedModel(models[0], textures[0]), new Vector3f(x, -1, z), 0, 0, 0, 1));
            }         
        }
        
        //Make "mountains"
        
        
        Entity[] world = new Entity[worldList.size()];
        for(int i = 0; i < worldList.size(); i++){
            world[i] = worldList.get(i);
        }
        return world;
    }
}