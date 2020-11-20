package session_16.bai_tap;

import java.io.*;

public class CopyFileExample {
    public static void main(String[] args) throws IOException {
//        InputStream inputStream = null;
//        OutputStream outputStream = null;
//        try{
//            inputStream = new FileInputStream(new File("D:\\java\\source.txt"));
//            outputStream = new FileOutputStream(new File("D:\\java\\target.txt"));
//            int length;
//            byte[] buffer = new byte[1024];
//            while ((length = inputStream.read(buffer)) > 0){
//                outputStream.write(buffer, 0 , length);
//            }
//            System.out.println("copy thành công");
//        }catch (IOException e){
//            e.printStackTrace();
//        }finally {
//            inputStream.close();
//            outputStream.close();
//        }
        try (BufferedReader br = new BufferedReader(new FileReader("D:\\\\java\\\\source.txt"))) {
            try (BufferedWriter bw = new BufferedWriter(new FileWriter("D:\\\\java\\\\target.txt"))) {
                String text = null;
                while ((text = br.readLine()) != null) {
                    System.out.println(text);
                    bw.write(text);
                    bw.newLine();
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("Error: " + e.getMessage());
        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
