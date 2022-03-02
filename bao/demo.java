package bao;
import java.io.*;

public class demo {
    public static void main(String[] args) throws IOException {
        //创建复制文件位置
        File file = new File("D:\\临时测试\\复制位置");
        String name = file.getName();//获取文件夹名字
        File file1 = new File("D:\\临时测试\\复制位置\\位置",name);//创建文件夹粘贴位置
        if(!file1.exists()){
            file1.mkdir();//判断文件夹是否存在，不存在就创建一个新的文件夹
        }
        File[] files = file.listFiles();
        for(File s:files){
            String name1 = s.getName();
            File file2 = new File(file1,name1);
            fuzhishuju(file,file2);
        }
    }
    public static void fuzhishuju(File file,File file1) throws IOException {
        BufferedInputStream fos = new BufferedInputStream(new FileInputStream(file));
        BufferedOutputStream fis = new BufferedOutputStream(new FileOutputStream(file1));
        int len;
        byte[] bytes = new byte[1024];
        while((len=fos.read(bytes))!=-1){
            fis.write(bytes,0,len);
        }
        fos.close();
        fis.close();

    }
}
