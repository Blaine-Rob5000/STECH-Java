// STECH Java programming class
// LabelWithGraphic
// created by Robin G. Blaine

// imports
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.collections.FXCollections;
import javafx.scene.Scene;
import javafx.scene.control.ListView;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.SelectionMode;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;


public class ListViewDemo extends Application {
	private String[] flagTitles = {
		"Canada",
		"China",
		"Denmark",
		"France",
		"Germany",
		"India",
		"Norway",
		"United Kingdom",
		"United States of America"
	};
	
	private ImageView[] ImageViews = {
		new ImageView("http://www.cs.armstrong.edu/liang/intro10e/book/image/ca.gif"),
		new ImageView("http://www.cs.armstrong.edu/liang/intro10e/book/image/china.gif"),
		new ImageView("http://www.cs.armstrong.edu/liang/intro10e/book/image/denmark.gif"),
		new ImageView("http://www.cs.armstrong.edu/liang/intro10e/book/image/fr.gif"),
		new ImageView("http://www.cs.armstrong.edu/liang/intro10e/book/image/germany.gif"),
		new ImageView("http://www.cs.armstrong.edu/liang/intro10e/book/image/india.gif"),
		new ImageView("http://www.cs.armstrong.edu/liang/intro10e/book/image/norway.gif"),
		new ImageView("http://www.cs.armstrong.edu/liang/intro10e/book/image/uk.gif"),
		new ImageView("http://www.cs.armstrong.edu/liang/intro10e/book/image/us.gif"),
	};
	
	@Override
	public void start(Stage primaryStage) {
		ListView<String> lv = new ListView<> (FXCollections.observableArrayList(flagTitles));
		lv.setPrefSize(400, 400);
		lv.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
		
		FlowPane imagePane = new FlowPane(10, 10);
		BorderPane pane = new BorderPane();
		pane.setLeft(new ScrollPane(lv));
		pane.setCenter(imagePane);
		
		lv.getSelectionModel().selectedItemProperty().addListener(
			ov -> {
				imagePane.getChildren().clear();
				for (Integer i: lv.getSelectionModel().getSelectedIndices()) {
					imagePane.getChildren().add(ImageViews[i]);
				}
			}
		);
		
		// Create a scene and place it in the stage
		Scene scene = new Scene(pane, 900, 320);
		primaryStage.setTitle("ListViewDemo");
		primaryStage.setScene(scene);
		primaryStage.show();
			
	}	// end start
	
	public static void main(String[] args) {
		launch(args);
	}	// end main
	
}	// end ListViewDemo