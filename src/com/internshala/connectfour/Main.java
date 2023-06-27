package com.internshala.connectfour;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.util.Optional;

public class Main extends Application {
    private Controller controller;
    @Override
    public void start(Stage primaryStage) throws Exception{
        FXMLLoader loader = new FXMLLoader(getClass().getResource("game.fxml"));


        GridPane rootGridPane = loader.load();
        controller = loader.getController();
        controller.createPlayground();

        MenuBar menuBar = createMenu();
        menuBar.prefWidthProperty().bind(primaryStage.widthProperty());

        Pane menuPane = (Pane) rootGridPane.getChildren().get(0);
        menuPane.getChildren().add(menuBar);

        Scene scene = new Scene(rootGridPane);

        primaryStage.setScene(scene);
        primaryStage.setTitle("Connect Four");
        primaryStage.getIcons().add(new Image("com/internshala/connectfour/icon1.png"));
        primaryStage.setResizable(false);
        primaryStage.show();
    }

private MenuBar createMenu()
{
	//File menu

	Menu fileMenu = new Menu("File");


	MenuItem newGame = new MenuItem("New Game");
	newGame.setOnAction(event -> controller.resetGame());

	MenuItem restGame = new MenuItem("Reset game");
	restGame.setOnAction(event ->controller. resetGame());

	SeparatorMenuItem separatorMenu = new SeparatorMenuItem();
	MenuItem exitGame = new MenuItem("Exit Game");
	exitGame.setOnAction(event -> exitGame());

    fileMenu.getItems().addAll(newGame,restGame,separatorMenu,exitGame);

    //Help menu
	Menu helpMenu = new Menu("Help");

	MenuItem aboutGame = new MenuItem("About Game");
	aboutGame.setOnAction(event -> aboutConnect4());

	SeparatorMenuItem separator = new SeparatorMenuItem();
	MenuItem aboutme = new MenuItem("About me");
	aboutme.setOnAction(event -> aboutMe());


	helpMenu.getItems().addAll(aboutGame,separator,aboutme);

	MenuBar menuBar = new MenuBar();
	menuBar.getMenus().addAll(fileMenu,helpMenu);

	return menuBar;
}

	private void aboutMe() {
		/*Alert alert = new Alert(Alert.AlertType.INFORMATION);
		alert.setTitle("About Developer");
		alert.setHeaderText("G Karthik");
		alert.setContentText("I Love Games");
		alert.show(); */

		Alert alertDialog  =new Alert(Alert.AlertType.INFORMATION);
		alertDialog.setTitle(" Connect Four Desktop Application");
		alertDialog.setHeaderText("About The Developer");

		VBox vBox = new VBox();
		Hyperlink linkedinLink = new Hyperlink("LinkedIn");
		linkedinLink.setOnAction(e->{
			getHostServices().showDocument("https://www.linkedin.com/in/ramueega07/");

		});
		Hyperlink github = new Hyperlink("GitHub");
		github.setOnAction(e->{
			getHostServices().showDocument("https://github.com/ramueega07");

		});

		vBox.getChildren().addAll(
				new javafx.scene.control.Label("My name is RAMA KRISHNA. " +
						"I'm a Data Science Aspirant in VJIT "),
				new javafx.scene.control.Label("My field of interest includes building new Web Technologies and Products, Machine Learning, and " +
						"areas related to artificial intelligence and data science."),
				new javafx.scene.control.Label("I live in Hyderabad."),
				//new javafx.scene.control.Label("I love to drink coffee."),
				//new javafx.scene.control.Label("I like swimming.\n"),
				new javafx.scene.control.Label("Connect Me Through..!"),
				linkedinLink,
				github
		);
		alertDialog.getDialogPane().setContent(vBox);
		ButtonType okBtn = new ButtonType("OK");
		alertDialog.getButtonTypes().setAll(/*yesBtn,noBTn*/okBtn);

		Optional<ButtonType> clickBtn =  alertDialog.showAndWait();


		}


	private void aboutConnect4() {
    	Alert alert = new Alert(Alert.AlertType.INFORMATION);
    	alert.setTitle("About Connect Four Game");
    	alert.setHeaderText("How to play");
    	alert.setContentText("Connect Four is a two-player connection game in which the players first choose a color and" +
			                 " then take turns dropping colored discs from the top into a seven-column, six-row vertically " +
			                 "suspended grid. The pieces fall straight down, occupying the next available space within the " +
			                 "column.The objective of the game is to be the first to form a horizontal, vertical, or diagonal" +
			                 "line of four of one's own discs.Connect Four is a solved game. The first player can always win " +
			                 "by playing the right moves.");
    	alert.show();
	}

	private void exitGame() {
		Platform.exit();
		System.exit(0);
	}

	private void resetGame() {

	}

	public static void main(String[] args) {
        launch(args);
    }
}
