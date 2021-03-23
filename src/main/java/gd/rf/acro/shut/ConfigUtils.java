package gd.rf.acro.shut;

import net.fabricmc.loader.api.FabricLoader;
import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ConfigUtils {

    public static Map<String,String> config = new HashMap<>();


    public static Map<String,String> loadConfigs()
    {
        File file = new File(FabricLoader.getInstance().getConfigDirectory().getPath() + "/Shut/config.acfg");
        try {
            List<String> lines = FileUtils.readLines(file,"utf-8");
            lines.forEach(line->
            {
                if(line.charAt(0)!='#')
                {
                    String noSpace = line.replace(" ","");
                    String[] entry = noSpace.split("=");
                    config.put(entry[0],entry[1]);
                }
            });
        } catch (IOException e) {
            e.printStackTrace();
        }
        return config;
    }
    public static void dontReload()
    {
        File file = new File(FabricLoader.getInstance().getConfigDirectory().getPath() + "/Shut/config.acfg");
        try {
            List<String> lines = FileUtils.readLines(file,"utf-8");
            lines.remove("doReload=true");
            lines.add("doReload=false");
            generateConfigs(lines);
        }catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void generateConfigs(List<String> input)
    {
        File file = new File(FabricLoader.getInstance().getConfigDirectory().getPath() + "/Shut/config.acfg");

        try {
            FileUtils.writeLines(file,input);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static Map<String,String> checkConfigs()
    {
        if(new File(FabricLoader.getInstance().getConfigDirectory().getPath() + "/Shut/config.acfg").exists())
        {
            return loadConfigs();
        }
        generateConfigs(makeDefaults());
        return loadConfigs();
    }

    private static List<String> makeDefaults()
    {
        List<String> defaults = new ArrayList<>();
        defaults.add("music=0");
        defaults.add("neutral=1");
        defaults.add("records=1");
        defaults.add("players=1");
        defaults.add("voice=1");
        defaults.add("ambient=1");
        defaults.add("hostile=1");
        defaults.add("weather=1");
        defaults.add("master=1");
        defaults.add("blocks=1");
        defaults.add("doReload=true");



        return defaults;
    }

}
