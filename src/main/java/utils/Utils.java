package utils;

import beans.User;

import java.io.*;
import java.sql.Timestamp;
import java.util.*;

/**
 * Created by Jenya on 05.06.2017.
 */
public class Utils {
    private static String text = "";

    private static void write(String name, Object o) {
        File file = new File(name);

        try {
            exists(name);

            PrintWriter out = new PrintWriter(file.getAbsoluteFile());

            try {
                if(o instanceof String) {
                    out.print(o);
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
            String newText = "";
            if (o instanceof String) {
                newText = (String) o;
            } else if (o instanceof User) {
                User user = (User) o;
                newText = user.getId() + ";" + user.getFio() + ";" + user.getDate() + ";" + "\n";
            }
            exists(name);
            StringBuilder sb = new StringBuilder();
            String oldFile = read(name);
            sb.append(oldFile);
            sb.append(newText);
            write(name, sb.toString());
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

    public static List<User> readList(String fileName) throws FileNotFoundException {
        //Этот спец. объект для построения строки
        StringBuilder sb = new StringBuilder();
        List<User> list = new ArrayList<User>();
        User user;
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
                    list.add(getUser(s.split(";")));
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
        Collections.sort(list, new Comparator<User>() {
            @Override
            public int compare(User o1, User o2) {
                return String.valueOf(o1.getId()).compareTo(String.valueOf(o2.getId()));
            }
        });
        return list;
    }

    public static String read(String fileName) throws FileNotFoundException {
        //Этот спец. объект для построения строки
        StringBuilder sb = new StringBuilder();
        List<User> list = new ArrayList<User>();
        User user;
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
                    list.add(getUser(s.split(";")));
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

    private static User getUser(String[] ss) {
        User user = new User();
        try {
            user.setId(Integer.parseInt(ss[0]));
            user.setFio(ss[1]);
            user.setDate(timestamp(ss[2]));
        } catch (Exception e) {
            e.printStackTrace();
        }

        return user;
    }

    private static Timestamp timestamp(String s) {
        return Timestamp.valueOf(s);
    }
}
