package com.example.email.hutool;

import cn.hutool.core.io.FileUtil;
import cn.hutool.core.io.IoUtil;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;

public class FileTest {

    public static void main(String[] args) {
        test1();
        test2();
    }

    private static void test2() {
        String path = "d:/test.txt";
        String path2 = "d:/test_copy.txt";
        String path3 = "d:/test_rename.txt";
        String path4 = "d:/Projects/test_move.txt";
        if (!FileUtil.exist(path)) {
            FileUtil.touch(path);
        }
        BufferedInputStream is = FileUtil.getInputStream(path);
        FileUtil.copy(path, path2, true);
        FileUtil.rename(FileUtil.file(path2), path3, true);
        FileUtil.move(FileUtil.file(path3), FileUtil.file(path4), true);
        FileUtil.del(path4);
    }

    private static void test1() {
        BufferedInputStream in = FileUtil.getInputStream("d:/test.txt");
        BufferedOutputStream out = FileUtil.getOutputStream("d:/test2.txt");
        long copySize = IoUtil.copy(in, out, IoUtil.DEFAULT_BUFFER_SIZE);
        System.out.println(copySize);
    }

}
