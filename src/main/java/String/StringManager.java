package String;

import Systems.Systems;
import com.google.gson.Gson;

import java.io.*;
import java.nio.charset.StandardCharsets;

import static Systems.Systems.MAC;
import static Systems.Systems.WINDOWS;

public class StringManager {

    private Strings strings;

    public StringManager(String language){
        String fileName = "src\\main\\resources\\languages\\strings_"+ language + ".json";
        if(Systems.getOS() == MAC) {
            fileName = "src/main/resources/languages/strings_" + language + ".json";
        }
        File file = new File(fileName);
        InputStream stream = null;
        try {
            stream = new FileInputStream(file);
        } catch (FileNotFoundException e) {
            System.out.println("読み込みエラー");
        }
        if(stream == null){
            System.err.println("ファイル読み込みエラー");
            return;
        }
        Reader reader = new InputStreamReader(stream, StandardCharsets.UTF_8);
        strings = new Gson().fromJson(reader, Strings.class);
    }

    public Strings getStrings(){
        return strings;
    }
}
