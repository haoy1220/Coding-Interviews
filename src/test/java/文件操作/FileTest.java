package 文件操作;

import org.junit.Test;

import java.io.File;
import java.util.PriorityQueue;

public class FileTest {

    public static void main(String[] args) {
        File file = new File("C://Users//hao//Desktop//halo");
        FileTest.FileDelete(file);
    }

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

    @Test
    public void generatorMd() {
        File file = new File("C://Users//hao//Documents//MindMap");
        if (!file.exists()) return;
        PriorityQueue priorityQueue = new PriorityQueue();
        String[] child = file.list();

        for (String f :
                child) {
            File childFile = new File(file, f);
            System.out.println(childFile.getName());;
        }
    }
}
