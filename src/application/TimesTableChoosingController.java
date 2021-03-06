package application;

import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import javafx.event.EventHandler;
import javafx.fxml.*;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

public class TimesTableChoosingController implements StageBuilder{
	public static Stage stage;
	public List<String> scoreList;
	
	@FXML
	Button times2;
	@FXML
	Button times3;
	@FXML
	Button times4;
	@FXML
	Button times5;
	@FXML
	Button times6;
	@FXML
	Button times7;
	@FXML
	Button times8;
	@FXML
	Button times9;
	@FXML
	Button times10;
	@FXML
	Button times11;
	@FXML
	Button times12;
	@FXML
	Button back;
	@FXML
	Label highscore;
	
	private int check = 0;
	
	@FXML
	public void initialize() {
		scoreList = new ArrayList<>();
		ScoreManager scoreManager = new ScoreManager();
		EventHandler<MouseEvent> event1 = new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent event) {
				if(event.getTarget() == back) {
					back.setText("N O O O ! !");
					back.setStyle("-fx-text-fill: #ff0000; -fx-background-color: #000000");
				}
				else if(event.getTarget().getClass() == times2.getClass()) {
					try {
						scoreList = scoreManager.readScore();
					} catch (FileNotFoundException e) {
						e.printStackTrace();
					}
					Button target = (Button) event.getSource();
					String text = target.getText().trim();
					target.setText("          " + text);
					highscore.setText(scoreList.get(Integer.parseInt(text) - 2));
				}
			}
		};
		
		EventHandler<MouseEvent> event2 = new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent event) {
				if(event.getTarget() == back) {
					back.setText("Back to Home");
					back.setStyle("-fx-text-fill: #ffffff; -fx-background-color: #000000");
				}
				else if(event.getTarget().getClass() == times2.getClass()) {
					Button target = (Button) event.getSource();
					String text = target.getText().trim();
					target.setText(text);
					highscore.setText("??");
				}
			}
		};
		
		EventHandler<MouseEvent> event3 = new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent event) {
				Button target = (Button) event.getSource();
				String text = target.getText().trim();
				GameController.times = Integer.parseInt(text);
				if(check == 0) handlePlay();
			}
		};
		
		times2.addEventHandler(MouseEvent.MOUSE_ENTERED_TARGET, event1);
		times2.addEventHandler(MouseEvent.MOUSE_EXITED_TARGET, event2);
		times2.addEventHandler(MouseEvent.MOUSE_CLICKED, event3);
		
		times3.addEventHandler(MouseEvent.MOUSE_ENTERED_TARGET, event1);
		times3.addEventHandler(MouseEvent.MOUSE_EXITED_TARGET, event2);
		times3.addEventHandler(MouseEvent.MOUSE_CLICKED, event3);
		
		times4.addEventHandler(MouseEvent.MOUSE_ENTERED_TARGET, event1);
		times4.addEventHandler(MouseEvent.MOUSE_EXITED_TARGET, event2);
		times4.addEventHandler(MouseEvent.MOUSE_CLICKED, event3);
		
		times5.addEventHandler(MouseEvent.MOUSE_ENTERED_TARGET, event1);
		times5.addEventHandler(MouseEvent.MOUSE_EXITED_TARGET, event2);
		times5.addEventHandler(MouseEvent.MOUSE_CLICKED, event3);
		
		times6.addEventHandler(MouseEvent.MOUSE_ENTERED_TARGET, event1);
		times6.addEventHandler(MouseEvent.MOUSE_EXITED_TARGET, event2);
		times6.addEventHandler(MouseEvent.MOUSE_CLICKED, event3);
		
		times7.addEventHandler(MouseEvent.MOUSE_ENTERED_TARGET, event1);
		times7.addEventHandler(MouseEvent.MOUSE_EXITED_TARGET, event2);
		times7.addEventHandler(MouseEvent.MOUSE_CLICKED, event3);
		
		times8.addEventHandler(MouseEvent.MOUSE_ENTERED_TARGET, event1);
		times8.addEventHandler(MouseEvent.MOUSE_EXITED_TARGET, event2);
		times8.addEventHandler(MouseEvent.MOUSE_CLICKED, event3);
		
		times9.addEventHandler(MouseEvent.MOUSE_ENTERED_TARGET, event1);
		times9.addEventHandler(MouseEvent.MOUSE_EXITED_TARGET, event2);
		times9.addEventHandler(MouseEvent.MOUSE_CLICKED, event3);
		
		times10.addEventHandler(MouseEvent.MOUSE_ENTERED_TARGET, event1);
		times10.addEventHandler(MouseEvent.MOUSE_EXITED_TARGET, event2);
		times10.addEventHandler(MouseEvent.MOUSE_CLICKED, event3);
		
		times11.addEventHandler(MouseEvent.MOUSE_ENTERED_TARGET, event1);
		times11.addEventHandler(MouseEvent.MOUSE_EXITED_TARGET, event2);
		times11.addEventHandler(MouseEvent.MOUSE_CLICKED, event3);
		
		times12.addEventHandler(MouseEvent.MOUSE_ENTERED_TARGET, event1);
		times12.addEventHandler(MouseEvent.MOUSE_EXITED_TARGET, event2);
		times12.addEventHandler(MouseEvent.MOUSE_CLICKED, event3);
		
		back.addEventHandler(MouseEvent.MOUSE_ENTERED_TARGET, event1);
		back.addEventHandler(MouseEvent.MOUSE_EXITED_TARGET, event2);
	}
	
	public void handleBack() {
		destroy();
		stage = new Stage();
		build(stage, "HomeUI.fxml");
	}
	
	public void handlePlay() {
		check++;
		destroy();
		stage = new Stage();
		build(stage, "GameUI.fxml");
	}

	@Override
	public void destroy() {
		if(homeIsShower()) HomeController.stage.close();
		else if (boardIsShower()) BoardController.stage.close();
		HomeController.timesTableChoosingStage = true;
	}
}
