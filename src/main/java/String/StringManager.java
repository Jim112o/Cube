package String;

import com.google.gson.Gson;

import java.io.*;
import java.nio.charset.StandardCharsets;

public class StringManager {

    private Strings strings;

    public StringManager(String language){
        File file = new File("src\\main\\resources\\languages\\strings_"+ language + ".json");
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
