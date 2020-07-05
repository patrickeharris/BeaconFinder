import Anvil.CompressedStreamTools;
import Anvil.NBTTagCompound;
import Anvil.NBTTagList;
import MCR.RegionFileCache;
import java.io.BufferedWriter;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import org.json.JSONObject;

public class Main
{
  public static void main(String[] args) throws IOException { readSignsAnvil(); }



  
  public static void readSignsAnvil() throws IOException {
    File folder = new File("region");
    File[] listOfFiles = folder.listFiles();
    File output = new File("output.txt");
    BufferedWriter writer = new BufferedWriter(new FileWriter(output));
    
    for (int f = 0; f < listOfFiles.length; f++) {
      
      for (int x = 0; x < 32; x++) {
        
        for (int z = 0; z < 32; z++) {
          
          DataInputStream dataInputStream = RegionFileCache.getChunkInputStream(listOfFiles[f], x, z);
          
          if (dataInputStream != null) {
            
            NBTTagCompound nbttagcompund = new NBTTagCompound();
            nbttagcompund = CompressedStreamTools.read(dataInputStream);
            
            NBTTagCompound nbttagcompund2 = new NBTTagCompound();
            nbttagcompund2 = nbttagcompund.getCompoundTag("Level");

            
            NBTTagList nbttaglist = nbttagcompund2.getTagList("TileEntities", 10);
            
            for (int i = 0; i < nbttaglist.tagCount(); i++) {
              
              NBTTagCompound entity = nbttaglist.getCompoundTagAt(i);
              
              if (entity.hasKey("Levels")) {
                
                writer.write("Chunk [" + x + ", " + z + "]\t(" + entity.getInteger("x") + ", " + entity.getInteger("y") + ", " + entity.getInteger("z") + ")\t");
                
                String text2 = String.valueOf(entity.getInteger("Levels"));
                writer.write("Levels: " + text2);
                JSONObject json1 = null;
                JSONObject json2 = null;
                JSONObject json3 = null;
                JSONObject json4 = null;
                
                String[] signLines = { text2 };
                
                JSONObject[] objects = { json1, json2, json3, json4 };















































                
                writer.newLine();
              } 
            } 
          } 
        } 
      } 
    } 














    
    writer.close();
  }
}
