package 文件操作;

import org.junit.Test;

import java.io.File;

public class FileTest {

    public static void main(String[] args) {
        File file = new File("C://Users//hao//Desktop//halo");
        FileTest.FileDelete(file);
    }

    @Test
    public static void FileDelete(File file) {

        if (!file.exists()) {
            return;
        }
        String[] child = file.list();
        for (String f : child) {
            File childFile = new File(file, f);
            if (childFile.isDirectory()) {
                FileDelete(childFile);
            }
            childFile.delete();
        }
    }
}
