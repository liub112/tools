package com.lfxfs.tools.core;

import com.lfxfs.tools.core.generator.ModelFileGenerator;

import java.lang.reflect.InvocationTargetException;

public class Initialization/* extends Application*/ {

//    @Override
//    public void start(Stage primaryStage) throws Exception {
//        Parent root = FXMLLoader.load(ArrearsController.class.getClass().getClassLoader().getResource("Arrears.fxml"));
//        primaryStage.setTitle("Hello World");
//        primaryStage.setScene(new Scene(root, 300, 275));
//        primaryStage.show();
//    }


//    public static void main(String[] args) {
//        launch(args);
//    }

    public static void main(String[] args) {
        Generator generator = null;
        try {
            generator = new Generator();
            generator.output();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
    }
}

