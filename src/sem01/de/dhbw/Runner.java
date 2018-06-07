package sem01.de.dhbw;

import de.dhbw.java.exercise.arrays.Arrays_1;
import de.dhbw.java.exercise.arrays.Arrays_2;
import de.dhbw.java.exercise.io.IO_01;
import de.dhbw.java.exercise.methods.methods;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Scanner;

public class Runner {

    public static void main(String[] args) throws ClassNotFoundException, InvocationTargetException, IllegalAccessException {

        System.out.println("starting");

        IO_01 o = new IO_01();
        Method[] methods = o.getClass().getMethods();

        System.out.println("Select specific method to run?");
        String selected = new Scanner(System.in).nextLine();

        for (Method method : methods) {
            if (method.getName().toLowerCase().endsWith(selected.toLowerCase()) && selected.length() >= 1 && method.getName().startsWith("run")) {
                method.invoke(o, null);
                System.out.println("single method finished");
                return;
            }
        }

        int i = 0;

        for (Method method : methods) {
            if (method.getName().startsWith("run")) {
                System.out.println("starting method #" + i++);
                try {
                    method.invoke(o, null);
                } catch (Exception ex) {
                    System.err.println(ex);
                }
            } else {
                continue;
            }
            System.out.println("Done, press enter to start the next method");
            pause();
        }

    }

    private static void pause() {
        System.out.println("---------------------------");
        new Scanner(System.in).nextLine();
    }

}
