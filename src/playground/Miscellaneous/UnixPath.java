package playground.Miscellaneous;

public class UnixPath {

    public static String getPath(String inputPath) {
        String outPath = "";
        String[] dirs = inputPath.split("/");
        int ignore = 0;
        for (int index = dirs.length - 1; index >= 0; index--) {
            if (dirs[index].equals(".."))
                ignore += 1;
            else if (dirs[index].equals("."))
                continue;
            else {
                if (ignore != 0)
                    ignore -= 1;
                else
                    outPath = dirs[index] + "/" + outPath;
            }
        }
        return outPath;
    }

    public static void main(String args[]) {
        System.out.println(UnixPath.getPath("$/home/abc/.././def/./ghi/../."));
    }

}
