package com.javarush.task.task20.task2002;

import java.io.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

/* 
Читаем и пишем в файл: JavaRush
*/
public class Solution {
    public static void main(String[] args) {
        //you can find your_file_name.tmp in your TMP directory or fix outputStream/inputStream according to your real file location
        //вы можете найти your_file_name.tmp в папке TMP или исправьте outputStream/inputStream в соответствии с путем к вашему реальному файлу
        try {
            File your_file_name = File.createTempFile("your_file_name", null);
            OutputStream outputStream = new FileOutputStream(your_file_name);
            InputStream inputStream = new FileInputStream(your_file_name);

            JavaRush javaRush = new JavaRush();
            //initialize users field for the javaRush object here - инициализируйте поле users для объекта javaRush тут
            javaRush.save(outputStream);
            outputStream.flush();

            JavaRush loadedObject = new JavaRush();
            loadedObject.load(inputStream);
            //check here that javaRush object equals to loadedObject object - проверьте тут, что javaRush и loadedObject равны

            outputStream.close();
            inputStream.close();

        } catch (IOException e) {
            //e.printStackTrace();
            System.out.println("Oops, something wrong with my file");
        } catch (Exception e) {
            //e.printStackTrace();
            System.out.println("Oops, something wrong with save/load method");
        }
    }

    public static class JavaRush {
        public List<User> users = new ArrayList<>();

        DateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy", Locale.ENGLISH);

        public void save(OutputStream outputStream) throws Exception {
            //implement this method - реализуйте этот метод
            if (users.size() > 0) {
                PrintWriter printWriter = new PrintWriter(outputStream);
                for (User user : users) {
                    //begin write in new file
                    printWriter.println("@");
                    //write name in new line
                    String firstName = user.getFirstName();

                    if (firstName == null) {
                        firstName = "noName";
                    }

                    printWriter.println(firstName);
                    //write last name in new line
                    String lastName = user.getLastName();

                    if (lastName == null) {
                        lastName = "noLastname";
                    }

                    printWriter.println(lastName);
                    //write birthday in new line
                    printWriter.println(dateFormat.format(user.getBirthDate()));
                    //write sex in new line(true/ false)
                    printWriter.println(String.valueOf(user.isMale()));
                    //write country in new line
                    printWriter.println(user.getCountry());
                }
                printWriter.close();
            } else {
                return;
            }
        }

        public void load(InputStream inputStream) throws Exception {
            //implement this method - реализуйте этот метод
            if (users.size() > 0) {
                BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
                while (reader.ready()) {
                    String newUser = reader.readLine();

                    //create new user
                    if (newUser.equals("@")) {
                        User user = new User();
                        String name = reader.readLine();
                        //read from file and set name to user
                        if (name.equals("noName")) {
                            name = null;
                        }
                        user.setFirstName(name);
                        //read from file and set lastname to user
                        String lastName = reader.readLine();
                        if (lastName.equals("noLastname")) {
                            lastName = null;
                        }
                        user.setLastName(lastName);
                        //read from file and set birthday
                        user.setBirthDate(dateFormat.parse(reader.readLine()));
                        //read from file and set sex
                        if (reader.readLine().equals("true")) {
                            user.setMale(true);
                        } else user.setMale(false);
                        //read from file and set country
                        user.setCountry(User.Country.valueOf(reader.readLine()));
                        //add user to list
                        users.add(user);
                    }
                }
            } else {
                return;
            }
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            JavaRush javaRush = (JavaRush) o;

            return users != null ? users.equals(javaRush.users) : javaRush.users == null;

        }

        @Override
        public int hashCode() {
            return users != null ? users.hashCode() : 0;
        }
    }
}
