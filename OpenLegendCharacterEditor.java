// STECH Java Programming Class
// Final Project:  OpenLegendCharacterEditor.java

// created by Robin G. Blaine on 10/09/2017 through 10/??/2017

/* * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *

	  A GUI program to create and edit a character for the open source tabletop roleplaying game, Open Legend
		
 * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * */


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


public class OpenLegendCharacterEditor extends Application {
	@Override
	public void start(Stage primaryStage) {
		
		// the main pane
		BorderPane pane = new BorderPane();
		
		// pane for names; goes in the top field of the main pane
		HBox paneForNames = new HBox();
		TextField tfCharacterName = new TextField("Character Name:");
		TextField tfPlayerName    = new TextField("Player Name:");
		paneForNames.getChildren().addAll(tfCharacterName, tfPlayerName);
		
		pane.setTop(paneForNames);
		
		// pane for attributes; goes in the left field of the main pane
		VBox paneForAttributes = new VBox();
		
		// 1st item in VBox pane for attributes
		Label lbAttributes = new Label("Attributes");
		
		// pane for physical attributes; 2nd item in VBox pane for attributes
		VBox paneForPhysicalAttributes = new VBox();
		
		// 1st item in VBox pane for physical attributes
		Label lbPhysicalAttributes = new Label("Physical Attributes");
		
		// agility attribute pane; 2nd item in VBox pane for physical attributes
		HBox paneForAgility = new HBox();
		TextField   tfAgilityCost  = new TextField();
		TextField   tfAgilityValue = new TextField();
		TextField   tfAgilityDice  = new TextField();
		RadioButton rbAgility      = new RadioButton("Agility");
		paneForAgility.getChildren().addAll(tfAgilityCost, rbAgility, tfAgilityValue, tfAgilityDice);
		
		// fortitude attribute pane; 3rd item in VBox pane for physical attributes
		HBox paneForFortitude = new HBox();
		TextField   tfFortitudeCost  = new TextField();
		TextField   tfFortitudeValue = new TextField();
		TextField   tfFortitudeDice  = new TextField();
		RadioButton rbFortitude      = new RadioButton("Fortitude");
		paneForFortitude.getChildren().addAll(tfFortitudeCost, rbFortitude, tfFortitudeValue, tfFortitudeDice);
		
		// might attribute pane; 4th item in the VBox pane for physical attributes
		HBox paneForMight = new HBox();
		TextField   tfMightCost  = new TextField();
		TextField   tfMightValue = new TextField();
		TextField   tfMightDice  = new TextField();
		RadioButton rbMight      = new RadioButton("Might");
		paneForMight.getChildren().addAll(tfMightCost, rbMight, tfMightValue, tfMightDice);
		
		// add items to pane for physical attributes
		paneForPhysicalAttributes.getChildren().addAll(
			lbPhysicalAttributes,
			paneForAgility,
			paneForFortitude,
			paneForMight);
		
		// pane for mental attributes; 3rd item in VBox pane for attributes
		VBox paneForMentalAttributes = new VBox();
		Label lbMentalAttributes = new Label("Mental Attributes");	// 1st item in VBox pane for mental attributes
		
		// learning attribute pane; 2nd item in VBox pane for mental attributes
		HBox paneForLearning = new HBox();
		TextField   tfLearningCost  = new TextField();
		TextField   tfLearningValue = new TextField();
		TextField   tfLearningDice  = new TextField();
		RadioButton rbLearning      = new RadioButton("Learning");
		paneForLearning.getChildren().addAll(tfLearningCost, rbLearning, tfLearningValue, tfLearningDice);
		
		// logic attribute pane; 3rd item in VBox pane for mental attributes
		HBox paneForLogic = new HBox();
		TextField   tfLogicCost  = new TextField();
		TextField   tfLogicValue = new TextField();
		TextField   tfLogicDice  = new TextField();
		RadioButton rbLogic      = new RadioButton("Logic");
		paneForLogic.getChildren().addAll(tfLogicCost, rbLogic, tfLogicValue, tfLogicDice);
		
		// perception attribute pane; 4th item in VBox pane for mental attributes
		HBox paneForPerception = new HBox();
		TextField   tfPerceptionCost  = new TextField();
		TextField   tfPerceptionValue = new TextField();
		TextField   tfPerceptionDice  = new TextField();
		RadioButton rbPerception      = new RadioButton("Perception");
		paneForPerception.getChildren().addAll(tfPerceptionCost, rbPerception, tfPerceptionValue, tfPerceptionDice);
		
		// will pane; 5th item in VBox pane for mental attributes
		HBox paneForWill = new HBox();
		TextField   tfWillCost  = new TextField();
		TextField   tfWillValue = new TextField();
		TextField   tfWillDice  = new TextField();
		RadioButton rbWill      = new RadioButton("Will");
		paneForWill.getChildren().addAll(tfWillCost, rbWill, tfWillValue, tfWillDice);
		
		// add items to pane for mental attributes
		paneForMentalAttributes.getChildren().addAll(
			lbMentalAttributes,
			paneForLearning,
			paneForLogic,
			paneForPerception,
			paneForWill);
		
		// pane for social attributes; 4th item in VBox pane for attributes
		VBox paneForSocialAttributes = new VBox();
		
		// 1st item in pane for social attributes
		Label lbSocialAttributes = new Label("Social Attributes");
		
		// deception attribute pane; 2nd item in VBox pane for social attributes
		HBox paneForDeception = new HBox();
		TextField   tfDeceptionCost  = new TextField();
		TextField   tfDeceptionValue = new TextField();
		TextField   tfDeceptionDice  = new TextField();
		RadioButton rbDeception      = new RadioButton("Deception");
		paneForDeception.getChildren().addAll(tfDeceptionCost, rbDeception, tfDeceptionValue, tfDeceptionDice);
		
		// persuasion attribute pane; 3rd item in VBox pane for social attributes
		HBox paneForPersuasion = new HBox();
		TextField   tfPersuasionCost  = new TextField();
		TextField   tfPersuasionValue = new TextField();
		TextField   tfPersuasionDice  = new TextField();
		RadioButton rbPersuasion      = new RadioButton("Persuasion");
		paneForPersuasion.getChildren().addAll(tfPersuasionCost, rbPersuasion, tfPersuasionValue, tfPersuasionDice);
		
		// presence attribute pane; 4th item in VBox pane for social attributes
		HBox paneForPresence = new HBox();
		TextField   tfPresenceCost  = new TextField();
		TextField   tfPresenceValue = new TextField();
		TextField   tfPresenceDice  = new TextField();
		RadioButton rbPresence      = new RadioButton("Presence");
		paneForPresence.getChildren().addAll(tfPresenceCost, rbPresence, tfPresenceValue, tfPresenceDice);
		
		// add items to pane for social attributes
		paneForSocialAttributes.getChildren().addAll(
			lbSocialAttributes,
			paneForDeception,
			paneForPersuasion,
			paneForPresence);
		
		// pane for extraordinary attributes; 5th item in VBox pane for attributes
		VBox paneForExtraordinaryAttributes = new VBox();
		
		// 1st item in pane for extraordinary attributes
		Label lbExtraordinaryAttributes = new Label("Extraordinary Attributes");
		
		// alteration attribute; 2nd item in pane for extraordinary attributes
		HBox paneForAlteration = new HBox();
		TextField   tfAlterationCost  = new TextField();
		TextField   tfAlterationValue = new TextField();
		TextField   tfAlterationDice  = new TextField();
		RadioButton rbAlteration      = new RadioButton("Alteration");
		paneForAlteration.getChildren().addAll(tfAlterationCost, rbAlteration, tfAlterationValue, tfAlterationDice);
		
		// creation attribute; 3rd item in pane for extraordinary attributes
		HBox paneForCreation = new HBox();
		TextField   tfCreationCost  = new TextField();
		TextField   tfCreationValue = new TextField();
		TextField   tfCreationDice  = new TextField();
		RadioButton rbCreation      = new RadioButton("Creation");
		paneForCreation.getChildren().addAll(tfCreationCost, rbCreation, tfCreationValue, tfCreationDice);
		
		// energy attribute; 4th item in pane for extraordinary attributes
		HBox paneForEnergy = new HBox();
		TextField   tfEnergyCost  = new TextField();
		TextField   tfEnergyValue = new TextField();
		TextField   tfEnergyDice  = new TextField();
		RadioButton rbEnergy      = new RadioButton("Energy");
		paneForEnergy.getChildren().addAll(tfEnergyCost, rbEnergy, tfEnergyValue, tfEnergyDice);
		
		// entropy attribute; 5th item in pane for extraordinary attributes
		HBox paneForEntropy = new HBox();
		TextField   tfEntropyCost  = new TextField();
		TextField   tfEntropyValue = new TextField();
		TextField   tfEntropyDice  = new TextField();
		RadioButton rbEntropy      = new RadioButton("Entropy");
		paneForEntropy.getChildren().addAll(tfEntropyCost, rbEntropy, tfEntropyValue, tfEntropyDice);
		
		// influence attribute; 6th item in pane for extraordinary attributes
		HBox paneForInfluence = new HBox();
		TextField   tfInfluenceCost  = new TextField();
		TextField   tfInfluenceValue = new TextField();
		TextField   tfInfluenceDice  = new TextField();
		RadioButton rbInfluence      = new RadioButton("Influence");
		paneForInfluence.getChildren().addAll(tfInfluenceCost, rbInfluence, tfInfluenceValue, tfInfluenceDice);
		
		// movement attribute; 7th item in pane for extraordinary attributes
		HBox paneForMovement = new HBox();
		TextField   tfMovementCost  = new TextField();
		TextField   tfMovementValue = new TextField();
		TextField   tfMovementDice  = new TextField();
		RadioButton rbMovement      = new RadioButton("Movement");
		paneForMovement.getChildren().addAll(tfMovementCost, rbMovement, tfMovementValue, tfMovementDice);
		
		// prescience attribute; 8th item in pane for extraordinary attributes
		HBox paneForPrescience = new HBox();
		TextField   tfPrescienceCost  = new TextField();
		TextField   tfPrescienceValue = new TextField();
		TextField   tfPrescienceDice  = new TextField();
		RadioButton rbPrescience      = new RadioButton("Prescience");
		paneForPrescience.getChildren().addAll(tfPrescienceCost, rbPrescience, tfPrescienceValue, tfPrescienceDice);
		
		// protection attribute; 9th item in pane for extraordinary attributes
		HBox paneForProtection = new HBox();
		TextField   tfProtectionCost  = new TextField();
		TextField   tfProtectionValue = new TextField();
		TextField   tfProtectionDice  = new TextField();
		RadioButton rbProtection      = new RadioButton("Protection");
		paneForProtection.getChildren().addAll(tfProtectionCost, rbProtection, tfProtectionValue, tfProtectionDice);
		
		// add items to pane for extraordinary attributes
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
		
		// pane for attribute point display and controls
		HBox paneForAttributeControls = new HBox();
		TextField tfAttributePoints = new TextField("40 / 40");
		Button btIncreaseAttribute = new Button("Increase +");
		Button btDecreaseAttribute = new Button("Decrease -");
		paneForAttributeControls.getChildren().addAll(tfAttributePoints, btIncreaseAttribute, btDecreaseAttribute);
		
		// add items to pane for attributes
		paneForAttributes.getChildren().addAll(
			lbAttributes,
			paneForPhysicalAttributes,
			paneForMentalAttributes,
			paneForSocialAttributes,
			paneForExtraordinaryAttributes,
			paneForAttributeControls);
		
		// place pane for attributes in the left field of the main pane
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
		
		
/* * * * * previous program stuff begin * * * * */
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
/* * * * * previous program stuff end * * * * */
		
		
		// Create a scene and place it in the stage
		Scene scene = new Scene(pane, 1900, 1000);
		primaryStage.setTitle("OpenLegendCharacterEditor");
		primaryStage.setScene(scene);
		primaryStage.show();
				
	}	// end start
	
	public class OLCharacter {
		private String characterName;
		private String playerName;
		private String characterBio;
		private String characterImage;
		private int agility;
		private int fortitude;
		private int might;
		private int learning;
		private int logic;
		private int perception;
		private int will;
		private int deception;
		private int persuasion;
		private int presence;
		private int alteration;
		private int creation;
		private int energy;
		private int entropy;
		private int influence;
		private int movement;
		private int prescience;
		private int protection;
		private int attributePointsMaximum = 40;
		private int attributePointsAvailable = 40;
		private int toughnessDefense = 10;
		private int guardDefense = 10;
		private int resolveDefense = 10;
		private int hitPoints = 10;
		private int speed = 30;
		
		// default constructor
		public OLCharacter() {
			
		}	// end default constructor
		
		// return characterName
		public String getCharacterName() {
			return characterName;
		}	// end getCharacterName
		
		// set characterName
		public void setCharacterName(String name) {
			this.characterName = name;
		}	// end setCharacterName
		
		// return playerName
		public String getPlayerName() {
			return playerName;
		}	// end getPlayerName
		
		// set playerName
		public void setPlayerName(String name) {
			this.playerName = name;
		}	// end setPlayerName
		
		// get characterBio
		public String getCharacterBio() {
			return characterBio;
		}	// end getCharacterBio
		
		// set characterBio
		public void setCharacterBio(String bio) {
			this.characterBio = bio;
		}	// end setCharacterBio
		
		// get characterImage
		public String getCharacterImage() {
			return characterImage;
		}	// end getCharacterImage
		
		// set characterImage
		public void setCharacterImage(String imageAddress) {
			this.characterImage = imageAddress;
		}	// end setCharacterImage
		
		// get agility
		public int getAgility() {
			return agility;
		}	// end getAgility
		
		// set agility
		public int setAgility(int value) {
			this.agility = value;
		}	// end setAgility
		
		// get fortitude
		public int getFortitude() {
			return fortitude;
		}	// end getFortitude
		
		// set fortitude
		public int setForitude(int value) {
			this.fortitude = value;
		}	// end setFortitude
		
		// get might
		public int getMight() {
			return might;
		}	// end getMight
		
		// set might
		public int setMight(int value) {
			this.Might = value;
		}	// end setMight
		
		// get learning
		public int getLearning() {
			return learning;
		}	// end getLearning
		
		// set learning
		public int setLearning(int value) {
			this.learning = value;
		}	// end setLearning
		
		// get logic
		public int getLogic() {
			return logic;
		}	// end getLogic
		
		// set logic
		public int setLogic(int value) {
			this.logic = value;
		}	// end setLogic
		
		// get perception
		public int getPerception() {
			return perception;
		}	// end getPerception
		
		// set perception
		public int setPerception(int value) {
			this.perception = value;
		}	// end setPerception
		
		// get will
		public int getWill() {
			return will;
		}	// end getWill
		
		// set will
		public int setWill(int value) {
			this.will = value;
		}	// end setWill
		
		// get deception
		public int getDeception() {
			return deception;
		}	// end getDeception
		
		// set deception
		public int setDeception(int value) {
			this.deception = value;
		}	// end setDeception
		
		// get persuasion
		public int getPersuasion() {
			return persuasion;
		}	// end getPersuasion
		
		// set persuasion
		public int setPersuasion(int value) {
			this.persuasion = value;
		}	// end setPersuasion
		
		// get presence
		public int getPresence() {
			return presence;
		}	// end getPresence
		
		// set presence
		public int setPresence(int value) {
			this.presence = value;
		}	// end setPresence
		
		// get alteration
		public int getAlteration() {
			return alteration;
		}	// end getAlteration
		
		// set alteration
		public int setAlteration(int value) {
			this.alteration = value;
		}	// end setAlteration
		
		// get creation
		public int getCreation() {
			return creation;
		}	// end getCreation
		
		// set creation
		public int setCreation(int value) {
			this.creation = value;
		}	// end setCreation
		
		// get energy
		public int getEnergy() {
			return energy;
		}	// end getEnergy
		
		// set energy
		public int setEnergy(int value) {
			this.energy = value;
		}	// end setEnergy
		
		// get entropy
		public int getEntropy() {
			return entropy;
		}	// end getEntropy
		
		// set entropy
		public int setEntropy(int value) {
			this.entropy = value;
		}	// end setEntropy
		
		// get influence
		public int getInfluence() {
			return influence;
		}	// end getInfluence
		
		// set influence
		public int setInfluence(int value) {
			this.influence = value;
		}	// end setInfluence
		
		// get movement
		public int getMovement() {
			return movement;
		}	// end getMovement
		
		// set movement
		public int setMovement(int value) {
			this.movement = value;
		}	// end setMovement
		
		// get prescience
		public int getPrescience() {
			return prescience;
		}	// end getPrescience
		
		// set prescience
		public int setPrescience(int value) {
			this.prescience = value;
		}	// end setPrescience
		
		// get Protection
		public int getProtection() {
			return Protection;
		}	// end getProtection
		
		// set Protection
		public int setProtection(int value) {
			this.Protection = value;
		}	// end setProtection
		
		
		
		
	}	// end OpenLegendCharacterSheet class
	
	public static void main(String[] args) {
		launch(args);
	}	// end main	
	
}	// end OpenLegendCharacterEditor
