package gui;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.image.Image;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;
import javafx.scene.paint.Color;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import logic.Pair;

import java.io.File;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class Controller implements Initializable {


    @FXML
    private MenuBar menuBar;

    @FXML
    private MenuItem mOpen;

    @FXML
    private VBox vBoxControlls;

    @FXML
    private HBox baseH;

    @FXML
    private Canvas cvsField;

    @FXML
    private VBox baseV;

    @FXML
    private Canvas cvsGoal;

    @FXML
    private ChoiceBox<?> choiceWurfart;

    @FXML
    private VBox vBoxCvs;

    @FXML
    private Label labelWurfart;


    private GraphicsContext gc;

    private List<Pair<Integer>> points;

    private final int CIRCLE_RADIUS = 5;
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        this.points = new ArrayList<>();
        this.gc = this.cvsField.getGraphicsContext2D();
        setEvents();
        bindSize();
        initCanvases();
    }

    private void initCanvases(){
        this.cvsField.getGraphicsContext2D().drawImage(new Image("/gui/img/Feld.jpg",300,300,true,false),0,0);
        this.cvsGoal.getGraphicsContext2D().drawImage(new Image("/gui/img/Tor.jpg",300,300,true,false),0,0);
    }

    private void setEvents(){
        this.mOpen.setOnAction(actionEvent -> {
            System.out.println("Hallo");
            FileChooser fc = new FileChooser();
            fc.setTitle("Lade Bild");
            File f = fc.showOpenDialog(new Stage());
            Image img = new Image(f.toURI().toString());
            this.cvsField.setWidth(img.getWidth());
            this.cvsField.setHeight(img.getHeight());
            this.cvsField.getGraphicsContext2D().drawImage(img,0,0);
        });




        this.cvsField.setOnMousePressed(me -> {
            System.out.println(me.getEventType());
            this.gc.setFill(Color.RED);
            this.gc.fillOval(me.getX()-this.CIRCLE_RADIUS,me.getY()-this.CIRCLE_RADIUS,this.CIRCLE_RADIUS*2,this.CIRCLE_RADIUS*2);
            this.points.add(new Pair<Integer>((int)me.getX(),(int)me.getY()));
        });
        this.cvsField.setOnMouseClicked(me -> {
        });

        this.cvsField.setOnMouseDragged(me -> {
            System.out.println(me.getEventType());
            System.out.println(me.getX() + " " + me.getY());
        });
        this.cvsField.setOnMouseReleased(me ->{
            this.gc.setFill(Color.RED);
            this.gc.fillOval(me.getX()-this.CIRCLE_RADIUS,me.getY()-this.CIRCLE_RADIUS,this.CIRCLE_RADIUS*2,this.CIRCLE_RADIUS*2);
            Pair<Integer> p1 = this.points.get(this.points.size()-1);
            this.points.add(new Pair<>((int)me.getX(),(int)me.getY()));
            this.gc.setStroke(Color.RED);
            this.gc.setLineWidth(3);
            this.gc.strokeLine(p1.getLeft(),p1.getRight(),me.getX(),me.getY());
        });
    }


    private void bindSize(){
        this.baseH.prefWidthProperty().bind(baseV.widthProperty());
        this.menuBar.prefWidthProperty().bind(baseV.widthProperty());
        this.baseH.prefHeightProperty().bind(baseV.heightProperty().multiply(0.95));
        this.menuBar.prefHeightProperty().bind(baseV.heightProperty().multiply(0.05));
        this.cvsField.setHeight(300);
        this.cvsField.setWidth(300);
        this.cvsGoal.setWidth(300);
        this.cvsGoal.setHeight(300);
    }
}