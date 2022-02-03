package String;

import com.google.gson.Gson;

import java.io.*;
import java.nio.charset.StandardCharsets;

import static Systems.Systems.MAC;
import static Systems.Systems.getOS;

public class MoveCodeManager {

    private Codes code;

    public MoveCodeManager(){
        String fileName = "src\\main\\resources\\Data\\MoveCode.json";
        if(getOS() == MAC){
            fileName = "src/main/resources/Data/MoveCode.json";
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
        code = new Gson().fromJson(reader, Codes.class);
    }

    public Codes getCode(){
        return code;
    }

}
