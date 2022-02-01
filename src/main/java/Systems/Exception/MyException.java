package Systems.Exception;

public class MyException extends Exception{

    private final long serialVersionUID = 1L;

    // コンストラクタ
    public MyException(String msg){
        super(msg);
    }
}
