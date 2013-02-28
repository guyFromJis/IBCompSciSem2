//Create a class called ImageEditor with the following initial code:

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.image.*;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class ImageEditor extends Application {
    private AnchorPane pane;

    @Override
    public void start(Stage stage) throws Exception {
        stage.setTitle("Image Editor");


        pane = new AnchorPane();
        Scene scene = new Scene(pane);
        stage.setScene(scene);
        stage.setResizable(false);
        stage.show();

        Image im = new Image("galaxies 1920x1200 wallpaper_www.wall321.com_20.jpg");

        stage.setWidth(im.getWidth());
        stage.setHeight(im.getHeight() + 22);

        WritableImage wi = new WritableImage(im.getPixelReader(), 0, 0, (int)im.getWidth(), (int)im.getHeight());
        ImageView iv = new ImageView(wi);

        MenuBar mb = new MenuBar();
        mb.setPrefWidth(stage.getWidth());
        Menu fileMenu = new Menu("File");
        Menu manipMenu = new Menu("Effects");

        MenuItem saturate = new MenuItem("Saturate");
        saturate.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {

            }
        });

                fileMenu.getItems().addAll();
        manipMenu.getItems().addAll(saturate);

        mb.getMenus().addAll(fileMenu, manipMenu);

        pane.getChildren().addAll(iv,mb);


        //Sample Manipulation

        PixelWriter pw = wi.getPixelWriter();
        PixelReader pr = wi.getPixelReader();

        for (int x = 10; x < wi.getWidth() - 10; x++) {
            for (int y = 10; y < wi.getHeight() - 10 ; y++) {
                //Color c = new Color(pr.getColor(x, y).getRed(), 1, pr.getColor(x, y).getBlue(), 1);
                //Color c = pr.getColor(x,y).grayscale();
                Color c = pr.getColor(x,y).saturate().saturate().saturate();
                //Color c = pr.getColor(x,y).invert();
                pw.setColor(x, y, c);
            }
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}

//Add a menu bar with commands to execute different file manipulation operations.