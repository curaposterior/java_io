package studentbook.studentbookgui;

import java.io.*;

import static studentbook.studentbookgui.StartApplication.main_class;

public class ClassContainerSerialization {

    public static void save() throws IOException { //saves the state of main_class container
        FileOutputStream fileOut = new FileOutputStream("class_container.ser");
        ObjectOutputStream out = new ObjectOutputStream(fileOut);
        out.writeObject(main_class);
        out.close();
        fileOut.close();
    }
}
