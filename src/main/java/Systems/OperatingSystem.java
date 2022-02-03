package Systems;

public class OperatingSystem {

    static final String osName = System.getProperty("os.name").toLowerCase();

    public static boolean isMac() {
        return osName.startsWith("mac");
    }

    public static boolean isWindows() {
        return osName.startsWith("windows");
    }

}
