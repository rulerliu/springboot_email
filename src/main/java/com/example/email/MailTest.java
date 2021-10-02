package com.example.email;

import cn.hutool.core.collection.CollUtil;
import cn.hutool.extra.mail.MailAccount;
import cn.hutool.extra.mail.MailUtil;

import java.io.File;
import java.io.FileOutputStream;

/**
 * @Description: <br>
 * @Date: Created in 2019/8/30 <br>
 * @Author: chenjianwen
 */
public class MailTest {

    public static void main(String[] args) {
        try {
            MailAccount account = new MailAccount();
            account.setHost("smtp.gd.chinamobile.com");
            account.setPort(465);
            account.setAuth(true);
            account.setFrom("liuwenqiang@shsnc.com");
            account.setUser("imap.gd.chinamobile.com");
            account.setPass("993"); //密码
            File file = contentToFile("gdfasdfsdafads");
            MailUtil.send(account, CollUtil.newArrayList("18529103439@163.com", "liuwenqiang@shsnc.com"), "测试", "", false, file);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static File contentToFile(String content) {
        try {
            String a = System.getProperty("java.io.tmpdir")+File.separator;
            File txt = new File(a + "log1.txt");
            if (!txt.exists()) {
                txt.createNewFile();
            }
            byte bytes[] = new byte[512];
            bytes = content.getBytes();
            int b = bytes.length;   //是字节的长度，不是字符串的长度
            FileOutputStream fos = new FileOutputStream(txt);
            fos.write(bytes, 0, b);
            return txt;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

}