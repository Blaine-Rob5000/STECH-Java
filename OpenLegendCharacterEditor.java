// STECH Java Programming Class
// Final Project:  OpenLegendCharacterEditor.java

// created by Robin G. Blaine on 10/9/17

/* * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *

	A GUI program to create and edit a character for the open source tabletop roleplaying game, Open Legend
		
 * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * */


// imports
import javafx.application.Application;
import javafx.stage.Stage;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;

import javafx.geometry.Insets;
import javafx.geometry.Pos;

import javafx.image.ImageView;

import javafx.scene.Scene;

import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;

import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.layout.Pane;

import 


public class OpenLegendCharacterEditor extends Application {
	@Override
	public void start(Stage primaryStage) {
		BorderPane pane = new BorderPane();
		
		HBox paneForNames = new HBox();
		TextField tfCharacterName = new TextField("Character Name:");
		TextField tfPlayerName    = new TextField("Player Name:");
		paneForNames.getChildren().addAll(tfCharacterName, tfPlayerName);
		
		pane.setTop(paneForNames);
		
		VBox paneForAttributes = new VBox();
		Label lbAttributes = new Label("Attributes");
			
		VBox paneForPhysicalAttributes = new VBox();
		Label lbPhysicalAttributes = new Label("Physical Attributes");
		
		HBox paneForAgility = new HBox();
		TextField   tfAgilityCost  = new TextField();
		TextField   tfAgilityValue = new TextField();
		TextField   tfAgilityDice  = new TextField();
		RadioButton rbAgility      = new RadioButton("Agility");
		paneForAgility.getChildren().addAll(tfAgilityCost, rbAgility, tfAgilityValue, tfAgilityDice);
		
		HBox paneForFortitude = new HBox();
		TextField   tfFortitudeCost  = new TextField();
		TextField   tfFortitudeValue = new TextField();
		TextField   tfFortitudeDice  = new TextField();
		RadioButton rbFortitude      = new RadioButton("Fortitude");
		paneForFortitude.getChildren().addAll(tfFortitudeCost, rbFortitude, tfFortitudeValue, tfFortitudeDice);
		
		HBox paneForMight = new HBox();
		TextField   tfMightCost  = new TextField();
		TextField   tfMightValue = new TextField();
		TextField   tfMightDice  = new TextField();
		RadioButton rbMight      = new RadioButton("Might");
		paneForMight.getChildren().addAll(tfMightCost, rbMight, tfMightValue, tfMightDice);
		
		paneForPhysicalAttributes.getChildren().addAll(
			lbPhysicalAttributes,
			paneForAgility,
			paneForFortitude,
			paneForMight);
		
		VBox paneForMentalAttributes = new VBox();
		Label lbMentalAttributes = new Label("Mental Attributes");
		
		HBox paneForLearning = new HBox();
		TextField   tfLearningCost  = new TextField();
		TextField   tfLearningValue = new TextField();
		TextField   tfLearningDice  = new TextField();
		RadioButton rbLearning      = new RadioButton("Learning");
		paneForLearning.getChildren().addAll(tfLearningCost, rbLearning, tfLearningValue, tfLearningDice);
		
		HBox paneForLogic = new HBox();
		TextField   tfLogicCost  = new TextField();
		TextField   tfLogicValue = new TextField();
		TextField   tfLogicDice  = new TextField();
		RadioButton rbLogic      = new RadioButton("Logic");
		paneForLogic.getChildren().addAll(tfLogicCost, rbLogic, tfLogicValue, tfLogicDice);
		
		HBox paneForPerception = new HBox();
		TextField   tfPerceptionCost  = new TextField();
		TextField   tfPerceptionValue = new TextField();
		TextField   tfPerceptionDice  = new TextField();
		RadioButton rbPerception      = new RadioButton("Perception");
		paneForPerception.getChildren().addAll(tfPerceptionCost, rbPerception, tfPerceptionValue, tfPerceptionDice);
		
		HBox paneForWill = new HBox();
		TextField   tfWillCost  = new TextField();
		TextField   tfWillValue = new TextField();
		TextField   tfWillDice  = new TextField();
		RadioButton rbWill      = new RadioButton("Will");
		paneForWill.getChildren().addAll(tfWillCost, rbWill, tfWillValue, tfWillDice);

		paneForMentalAttributes.getChildren().addAll(
			lbMentalAttributes,
			paneForLearning,
			paneForLogic,
			paneForPerception,
			paneForWill);
		
		VBox paneForSocialAttributes = new VBox();
		Label lbSocialAttributes = new Label("Social Attributes");
		
		HBox paneForDeception = new HBox();
		TextField   tfDeceptionCost  = new TextField();
		TextField   tfDeceptionValue = new TextField();
		TextField   tfDeceptionDice  = new TextField();
		RadioButton rbDeception      = new RadioButton("Deception");
		paneForDeception.getChildren().addAll(tfDeceptionCost, rbDeception, tfDeceptionValue, tfDeceptionDice);
		
		HBox paneForPersuasion = new HBox();
		TextField   tfPersuasionCost  = new TextField();
		TextField   tfPersuasionValue = new TextField();
		TextField   tfPersuasionDice  = new TextField();
		RadioButton rbPersuasion      = new RadioButton("Persuasion");
		paneForPersuasion.getChildren().addAll(tfPersuasionCost, rbPersuasion, tfPersuasionValue, tfPersuasionDice);
		
		HBox paneForPresence = new HBox();
		TextField   tfPresenceCost  = new TextField();
		TextField   tfPresenceValue = new TextField();
		TextField   tfPresenceDice  = new TextField();
		RadioButton rbPresence      = new RadioButton("Presence");
		paneForPresence.getChildren().addAll(tfPresenceCost, rbPresence, tfPresenceValue, tfPresenceDice);
		
		paneForSocialAttributes.getChildren().addAll(
			lbSocialAttributes,
			paneForDeception,
			paneForPersuasion,
			paneForPresence);
		
		VBox paneForExtraordinaryAttributes = new VBox();
		Label lbExtraordinaryAttributes = new Label("Extraordinary Attributes");
		
		HBox paneForAlteration = new HBox();
		TextField   tfAlterationCost  = new TextField();
		TextField   tfAlterationValue = new TextField();
		TextField   tfAlterationDice  = new TextField();
		RadioButton rbAlteration      = new RadioButton("Alteration");
		paneForAlteration.getChildren().addAll(tfAlterationCost, rbAlteration, tfAlterationValue, tfAlterationDice);
		
		HBox paneForCreation = new HBox();
		TextField   tfCreationCost  = new TextField();
		TextField   tfCreationValue = new TextField();
		TextField   tfCreationDice  = new TextField();
		RadioButton rbCreation      = new RadioButton("Creation");
		paneForCreation.getChildren().addAll(tfCreationCost, rbCreation, tfCreationValue, tfCreationDice);
		
		HBox paneForEnergy = new HBox();
		TextField   tfEnergyCost  = new TextField();
		TextField   tfEnergyValue = new TextField();
		TextField   tfEnergyDice  = new TextField();
		RadioButton rbEnergy      = new RadioButton("Energy");
		paneForEnergy.getChildren().addAll(tfEnergyCost, rbEnergy, tfEnergyValue, tfEnergyDice);
		
		HBox paneForEntropy = new HBox();
		TextField   tfEntropyCost  = new TextField();
		TextField   tfEntropyValue = new TextField();
		TextField   tfEntropyDice  = new TextField();
		RadioButton rbEntropy      = new RadioButton("Entropy");
		paneForEntropy.getChildren().addAll(tfEntropyCost, rbEntropy, tfEntropyValue, tfEntropyDice);
		
		HBox paneForInfluence = new HBox();
		TextField   tfInfluenceCost  = new TextField();
		TextField   tfInfluenceValue = new TextField();
		TextField   tfInfluenceDice  = new TextField();
		RadioButton rbInfluence      = new RadioButton("Influence");
		paneForInfluence.getChildren().addAll(tfInfluenceCost, rbInfluence, tfInfluenceValue, tfInfluenceDice);
		
		HBox paneForMovement = new HBox();
		TextField   tfMovementCost  = new TextField();
		TextField   tfMovementValue = new TextField();
		TextField   tfMovementDice  = new TextField();
		RadioButton rbMovement      = new RadioButton("Movement");
		paneForMovement.getChildren().addAll(tfMovementCost, rbMovement, tfMovementValue, tfMovementDice);
		
		HBox paneForPrescience = new HBox();
		TextField   tfPrescienceCost  = new TextField();
		TextField   tfPrescienceValue = new TextField();
		TextField   tfPrescienceDice  = new TextField();
		RadioButton rbPrescience      = new RadioButton("Prescience");
		paneForPrescience.getChildren().addAll(tfPrescienceCost, rbPrescience, tfPrescienceValue, tfPrescienceDice);
		
		HBox paneForProtection = new HBox();
		TextField   tfProtectionCost  = new TextField();
		TextField   tfProtectionValue = new TextField();
		TextField   tfProtectionDice  = new TextField();
		RadioButton rbProtection      = new RadioButton("Protection");
		paneForProtection.getChildren().addAll(tfProtectionCost, rbProtection, tfProtectionValue, tfProtectionDice);
		
		paneForExtraordinaryAttributes.getChildren().addAll(
			lbExtraordinaryAttributes,
			paneForAlteration,
			paneForCreation,
			paneForEnergy,
			paneForEntropy,
			paneForInfluence,
			paneForMovement,
			paneForPrescience,
			paneForProtection);
		
		HBox paneForAttributeControls = new HBox();
		TextField tfAttributePoints = new TextField("40 / 40");
		Button btIncreaseAttribute = new Button("Increase +");
		Button btDecreaseAttribute = new Button("Decrease -");
		paneForAttributeControls.getChildren().addAll(tfAttributePoints, btIncreaseAttribute, btDecreaseAttribute);
		
		paneForAttributes.getChildren().addAll(
			lbAttributes,
			paneForPhysicalAttributes,
			paneForMentalAttributes,
			paneForSocialAttributes,
			paneForExtraordinaryAttributes,
			paneForAttributeControls);
		
		pane.setLeft(paneForAttributes);
		
		// Create a ToggleGroup for the attribute selection radio buttons
		ToggleGroup attributeToggleGroup = new ToggleGroup();
		rbAgility.setToggleGroup(attributeToggleGroup);
		rbFortitude.setToggleGroup(attributeToggleGroup);
		rbMight.setToggleGroup(attributeToggleGroup);
		rbLearning.setToggleGroup(attributeToggleGroup);
		rbLogic.setToggleGroup(attributeToggleGroup);
		rbPerception.setToggleGroup(attributeToggleGroup);
		rbWill.setToggleGroup(attributeToggleGroup);
		rbDeception.setToggleGroup(attributeToggleGroup);
		rbPersuasion.setToggleGroup(attributeToggleGroup);
		rbPresence.setToggleGroup(attributeToggleGroup);
		rbAlteration.setToggleGroup(attributeToggleGroup);
		rbCreation.setToggleGroup(attributeToggleGroup);
		rbEnergy.setToggleGroup(attributeToggleGroup);
		rbEntropy.setToggleGroup(attributeToggleGroup);
		rbInfluence.setToggleGroup(attributeToggleGroup);
		rbMovement.setToggleGroup(attributeToggleGroup);
		rbPrescience.setToggleGroup(attributeToggleGroup);
		rbProtection.setToggleGroup(attributeToggleGroup);
		
		rbCircle.setOnAction(e -> {
			if (rbCircle.isSelected()) {
				paneForShapes.getChildren().clear();
				paneForShapes.getChildren().add(circle);
				if (chkFill.isSelected()) {
					circle.setFill(Color.RED);
				}
				else {
					circle.setFill(Color.WHITE);
				}
			}
		});
		
		rbEllipse.setOnAction(e -> {
			if (rbEllipse.isSelected()) {
				paneForShapes.getChildren().clear();
				paneForShapes.getChildren().add(ellipse);
				if (chkFill.isSelected()) {
					ellipse.setFill(Color.RED);
				}
				else {
					ellipse.setFill(Color.WHITE);
				}
			}
		});
		
		rbRectangle.setOnAction(e -> {
			if (rbRectangle.isSelected()) {
				paneForShapes.getChildren().clear();
				paneForShapes.getChildren().add(rectangle);
				if (chkFill.isSelected()) {
					rectangle.setFill(Color.RED);
				}
				else {
					rectangle.setFill(Color.WHITE);
				}
			}
		});
		
		chkFill.setOnAction(e ->{
			if (chkFill.isSelected()) {
				circle.setFill(Color.RED);
				ellipse.setFill(Color.RED);
				rectangle.setFill(Color.RED);
			}
			else {
				circle.setFill(Color.WHITE);
				ellipse.setFill(Color.WHITE);
				rectangle.setFill(Color.WHITE);			}
		});
		
		// Create a scene and place it in the stage
		Scene scene = new Scene(pane, 500, 350);
		primaryStage.setTitle("Exercise16_2");
		primaryStage.setScene(scene);
		primaryStage.show();
				
	}	// end start
	
	public static void main(String[] args) {
		launch(args);
	}	// end main	
	
}	// end OpenLegendCharacterEditor
