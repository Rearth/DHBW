package sem02.de.dhbw.fx;

import javafx.application.Application;
import javafx.beans.property.StringProperty;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.io.IOException;

public class fxeample extends Application {

    private Stage stage;

    @FXML
    Label content;

    @FXML
    void doClose(ActionEvent e) {
        System.out.println("Closing");
    }

    @Override
    public void start(Stage primaryStage) {
        this.stage = primaryStage;
        stage.setTitle("Demo");
        Parent root = null;

        try {
            root = FXMLLoader.load(getClass().getResource("fxemaple.fxml"));
        } catch (IOException e) {
            e.printStackTrace();
        }

        Scene scene = new Scene(root);

        stage.setScene(scene);
        stage.show();


    }

    public static void main(String[] args) {
        launch(args);
        System.out.println("starting");
    }

    private class FooBar {

        private StringProperty foo;
        private StringProperty bar;

        public FooBar(StringProperty foo, StringProperty bar) {
            this.foo = foo;
            this.bar = bar;
        }

        public String getFoo() {
            return foo.get();
        }

        public StringProperty fooProperty() {
            return foo;
        }

        public void setFoo(String foo) {
            this.foo.set(foo);
        }

        public String getBar() {
            return bar.get();
        }

        public StringProperty barProperty() {
            return bar;
        }

        public void setBar(String bar) {
            this.bar.set(bar);
        }
    }
}
