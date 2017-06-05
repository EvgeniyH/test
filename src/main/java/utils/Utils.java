package utils;

import beans.User;

import java.io.*;

/**
 * Created by Jenya on 05.06.2017.
 */
public class Utils {
    private static String fileName = "";
    private static String text = "";

    public static void write(String name, Object o) {
        File file = new File(name);

        try {
            fileName = name;
            exists(fileName);

            PrintWriter out = new PrintWriter(file.getAbsoluteFile());

            try {
                if(o instanceof String) {
                    text = (String) o;
                    out.print(text);
                } else if(o instanceof User) {
                    User user = (User) o;
                    text = "|"+user.getId()+"|"+user.getFio()+"|"+user.getDate()+"|"+"\n";
                    out.print(text);
                }

            } finally {
                out.close();
            }
        } catch(IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void update(Object o, String name) throws FileNotFoundException {
        try {
            fileName = name;
            String newText = "";
            if (o instanceof String) {
                newText = (String) o;
            } else if (o instanceof User) {
                User user = (User) o;
                newText = "|" + user.getId() + "|" + user.getFio() + "|" + user.getDate() + "|" + "\n";
            }
            exists(fileName);
            StringBuilder sb = new StringBuilder();
            String oldFile = read();
            sb.append(oldFile);
            sb.append(newText);
            write(fileName, sb.toString());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void exists(String fileName) throws FileNotFoundException {
        File file = new File(fileName);
        if (!file.exists()){
            throw new FileNotFoundException(file.getName());
        }
    }

    public static String read() throws FileNotFoundException {
        //Этот спец. объект для построения строки
        StringBuilder sb = new StringBuilder();

        File file = new File(fileName);

        exists(fileName);

        try {
            //Объект для чтения файла в буфер
            BufferedReader in = new BufferedReader(new FileReader( file.getAbsoluteFile()));
            try {
                //В цикле построчно считываем файл
                String s;
                while ((s = in.readLine()) != null) {
                    sb.append(s);
                    sb.append("\n");
                }
            } finally {
                //Также не забываем закрыть файл
                in.close();
            }
        } catch(IOException e) {
            throw new RuntimeException(e);
        }

        //Возвращаем полученный текст с файла
        return sb.toString();
    }
}
