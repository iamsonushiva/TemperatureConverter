package TempConvert.sonu;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.util.Optional;

public class myMain extends Application
{

	public static void main(String[] args)
	{
		System.out.println("MAIN"); // Optional
		launch(args);
	}

	@Override
	public void init() throws Exception
	{
		System.out.println("INIT"); // Initialize the Application
		super.init();
	}

	// Mandatory to override Start method
	// Init & Stop are optional to override
	@Override
	public void start(Stage primaryStage) throws Exception
	// Stage is outermost container of App
	{

		System.out.println("START");    // Starts an Application

		// Loader connects MyMain with FXML file
		FXMLLoader loader = new FXMLLoader(getClass().getResource("app_layout.fxml"));
		VBox rootNode = loader.load(); // Loads rootNode as VBox

		MenuBar menuBar = createMenu();
		rootNode.getChildren().add(0, menuBar);

		Scene scene = new Scene(rootNode);

		// Setting the scene
		primaryStage.setScene(scene);
		primaryStage.setTitle("Temperature Converter Tool");
		primaryStage.show(); // To make the App visible to user
	}

	private MenuBar createMenu() {

		// File Menu
		Menu fileMenu = new Menu("File");
		MenuItem newMenuItem = new MenuItem("New");

		newMenuItem.setOnAction(event -> {
			System.out.println("New Menu Item Clicked");

		});

		SeparatorMenuItem separatorMenuItem = new SeparatorMenuItem();
		MenuItem quitMenuItem = new MenuItem("Quit");

		quitMenuItem.setOnAction(event -> {
			Platform.exit();  // Shutdown current application
			System.exit(0);  // Shutdown current Virtual Machine
		});

		fileMenu.getItems().addAll(newMenuItem, separatorMenuItem, quitMenuItem);

		// Help Menu
		Menu helpMenu = new Menu("Help");
		MenuItem aboutApp = new MenuItem("About");

		aboutApp.setOnAction(event -> aboutApp());

		helpMenu.getItems().addAll(aboutApp);

		// Menu Bar
		MenuBar menuBar = new MenuBar();
		menuBar.getMenus().addAll(fileMenu, helpMenu);

		return menuBar;
	}

	public static void aboutApp() {

		Alert alertDialog = new Alert(Alert.AlertType.INFORMATION);
		alertDialog.setTitle("TEMPERATURE CONVERT TOOL");
		alertDialog.setHeaderText("Developer : SHIV SHANKER SINGH");
		alertDialog.setContentText("ABOUT DEVELOPER>>>>>>>>>>>>>>>>>>>>>>>>> " +
				"Hi! I am Shiv Shanker Singh, a Programmer focused on Creativity with simplicity ." +
				" I am an Electronics and Communication Engineer in Hyderabad . " +
				" I have a passionate interest towards programming. " +
				" My hobbies are Gardening , Watching web series and playing Cricket.  " +
				" I am An Active Volunteer too.                                                "+
				"ABOUT APPLICATION>>>>>>>>>>>>>>>>>>>>>>>>"+
				"It is temperature Converting application. " +
				"It converts celsius to Fahrenheit and vise - versa." +
				"Do you want to CONVERT>>>>>> "

		);

		ButtonType yesBtn = new ButtonType("Yes");
		ButtonType noBtn = new ButtonType("No");

		alertDialog.getButtonTypes().setAll(yesBtn, noBtn);

		Optional<ButtonType> clickedBtn = alertDialog.showAndWait();

		if (clickedBtn.isPresent() && clickedBtn.get() == yesBtn)
		{
			System.out.println("Yes Button Clicked !");
		}
		else
		{
			System.out.println("No Button Clicked !");
		}
	}

	@Override
	public void stop() throws Exception {

		System.out.println("STOP"); // Called to shut down the Application
		super.stop();
	}
}


