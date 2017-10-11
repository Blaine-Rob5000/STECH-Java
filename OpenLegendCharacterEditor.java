
// STECH Java Programming Class
// Final Project:  OpenLegendCharacterEditor.java
// created by Robin G. Blaine on 10/09/2017 through 10/??/2017

/* * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *
 *                                                                           *
 *   A GUI program to create and edit a character for the open-source        *
 *       tabletop roleplaying game, Open Legend                              *
 *                                                                           *
 * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * */

// imports
import javafx.application.Application;
import javafx.stage.Stage;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;

import javafx.geometry.Insets;
import javafx.geometry.Pos;

import javafx.scene.Scene;

import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class OpenLegendCharacterEditor extends Application {

    @Override
    public void start(Stage primaryStage) {
        // variables
        String[] attributeDice = new String[]{
            "",
            "1d4",
            "1d6",
            "1d8",
            "1d10",
            "2d6",
            "2d8",
            "2d10",
            "3d8",
            "3d10",
            "4d8"};
        int[] attributeCost = new int[]{0, 1, 3, 6, 10, 15};
        int rbSpacing   = 8;
        int rbPaneWidth = 100;
        int sceneWidth  = 1600;
        int sceneHeight = 800;
        
        // declare constants
        final String AGILITY_DESCRIPTION =
                "Agility:\n\nDodge attacks, move with stealth, perform acrobatics, shoot a bow, pick a pocket";
        final String FORTITUDE_DESCRIPTION =
                "Foritude:\n\nResist poison, shrug off pain, survive in a desert, wear heavy armor";
        final String MIGHT_DESCRIPTION =
                "Might:\n\nSwing a maul, jump over a chasm, break down a door, wrestle a foe to submission";
        final String LEARNING_DESCRIPTION =
                "Learning:\n\nRecall facts about history, arcane magic, the natural world, or any information you picked up from an external source";
        final String LOGIC_DESCRIPTION =
                "Logic:\n\nInnovate a new crafting method, decipher a code, jury-rig a device, get the gist of a language you don’t speak";
        final String PERCEPTION_DESCRIPTION =
                "Perception:\n\nSense ulterior motives, track someone, catch a gut feeling, spot a hidden foe, find a secret door";
        final String WILL_DESCRIPTION =
                "Will:\n\nMaintain your resolve, resist torture, study long hours, stay awake on watch, stave off insanity";
        final String DECEPTION_DESCRIPTION =
                "Deception:\n\nTell a lie, bluff at cards, disguise yourself, spread rumors, swindle a sucker";
        final String PERSUASION_DESCRIPTION =
                "Persuasion:\n\nNegotiate a deal, convince someone, haggle a good price, pry information";
        final String PRESENCE_DESCRIPTION =
                "Presence:\n\nGive a speech, sing a song, inspire an army, exert your force of personality, have luck smile upon you";
        final String ALTERATION_DESCRIPTION =
                "Alteration:\n\nChange shape, alter molecular structures, transmute one material into another";
        final String CREATION_DESCRIPTION =
                "Creation:\n\nChannel higher powers, manifest something from nothing, regenerate, divinely bolster";
        final String ENERGY_DESCRIPTION =
                "Energy:\n\nCreate and control the elements—fire, cold, electricity";
        final String ENTROPY_DESCRIPTION =
                "Entropy:\n\nDisintegrate matter, kill with a word, create undead, sicken others";
        final String INFLUENCE_DESCRIPTION =
                "Influence:\n\nControl the minds of others, speak telepathically, instill fear, create illusory figments, cloak with invisibility";
        final String MOVEMENT_DESCRIPTION =
                "Movement:\n\nTeleport, fly, hasten, telekinetically push";
        final String PRESCIENCE_DESCRIPTION =
                "Prescience:\n\nSee the future, read minds or auras, view from afar, detect magic or evil, communicate with extraplanar entities";
        final String PROTECTION_DESCRIPTION =
                "Protection:\n\nProtect from damage, break supernatural influence, dispel magic, exile extradimensional beings";



        CharacterSheet characterSheet = new CharacterSheet();

        // the main pane
        BorderPane pane = new BorderPane();

        // pane for names; goes in the top field of the main pane
        HBox paneForNames     = new HBox(10);
        TextField tfCharacterName = new TextField();
        tfCharacterName.setPrefWidth(300);
        TextField tfPlayerName = new TextField();
        tfPlayerName.setPrefWidth(300);
        paneForNames.getChildren().addAll(
                new Label("  Character Name:"),
                tfCharacterName,
                new Label("  Player Name:"),
                tfPlayerName);

        pane.setTop(paneForNames);

        // pane for attributes; goes in the left field of the main pane
        VBox paneForAttributes = new VBox();
        
        HBox paneForPhysicalAttributes = new HBox();
        
        VBox paneForPhysicalCosts = new VBox();
        TextField tfAgilityCost   = new TextField();
            tfAgilityCost.setEditable(false);
            tfAgilityCost.setAlignment(Pos.CENTER);
            tfAgilityCost.setPrefWidth(50);
        TextField tfFortitudeCost  = new TextField();
            tfFortitudeCost.setEditable(false);
            tfFortitudeCost.setAlignment(Pos.CENTER);
            tfFortitudeCost.setPrefWidth(50);
        TextField tfMightCost      = new TextField();
            tfMightCost.setEditable(false);
            tfMightCost.setAlignment(Pos.CENTER);
            tfMightCost.setPrefWidth(50);
        paneForPhysicalCosts.getChildren().addAll(
                new Label("  Cost"),
                tfAgilityCost,
                tfFortitudeCost,
                tfMightCost);
        
        VBox paneForPhysicalRBs = new VBox(rbSpacing);
            paneForPhysicalRBs.setPrefWidth(rbPaneWidth);
        RadioButton rbAgility            = new RadioButton(" Agility");
        RadioButton rbFortitude          = new RadioButton(" Fortitude");
        RadioButton rbMight              = new RadioButton(" Might");
        paneForPhysicalRBs.getChildren().addAll(
                new Label("  Attribute"),
                rbAgility,
                rbFortitude,
                rbMight);
        
        VBox paneForPhysicalValues = new VBox();
        TextField tfAgilityValue   = new TextField();
            tfAgilityValue.setEditable(false);
            tfAgilityValue.setAlignment(Pos.CENTER);
            tfAgilityValue.setPrefWidth(50);
        TextField tfFortitudeValue = new TextField();
            tfFortitudeValue.setEditable(false);
            tfFortitudeValue.setAlignment(Pos.CENTER);
            tfFortitudeValue.setPrefWidth(50);
        TextField tfMightValue     = new TextField();
            tfMightValue.setEditable(false);
            tfMightValue.setAlignment(Pos.CENTER);
            tfMightValue.setPrefWidth(50);
        paneForPhysicalValues.getChildren().addAll(
                new Label("  Value"),
                tfAgilityValue,
                tfFortitudeValue,
                tfMightValue);
        
        VBox paneForPhysicalDice   = new VBox();
        TextField tfAgilityDice    = new TextField();
            tfAgilityDice.setEditable(false);
            tfAgilityDice.setAlignment(Pos.CENTER);
            tfAgilityDice.setPrefWidth(50);
        TextField tfFortitudeDice  = new TextField();
            tfFortitudeDice.setEditable(false);
            tfFortitudeDice.setAlignment(Pos.CENTER);
            tfFortitudeDice.setPrefWidth(50);
        TextField tfMightDice      = new TextField();
            tfMightDice.setEditable(false);
            tfMightDice.setAlignment(Pos.CENTER);
            tfMightDice.setPrefWidth(50);
        paneForPhysicalDice.getChildren().addAll(
                new Label("  Dice"),
                tfAgilityDice,
                tfFortitudeDice,
                tfMightDice);

        paneForPhysicalAttributes.getChildren().addAll(
                paneForPhysicalCosts,
                paneForPhysicalRBs,
                paneForPhysicalValues,
                paneForPhysicalDice);

        
        HBox paneForMentalAttributes = new HBox();

        VBox paneForMentalCosts    = new VBox();
        TextField tfLearningCost   = new TextField();
            tfLearningCost.setEditable(false);
            tfLearningCost.setAlignment(Pos.CENTER);
            tfLearningCost.setPrefWidth(50);
        TextField tfLogicCost      = new TextField();
            tfLogicCost.setEditable(false);
            tfLogicCost.setAlignment(Pos.CENTER);
            tfLogicCost.setPrefWidth(50);
        TextField tfPerceptionCost = new TextField();
            tfPerceptionCost.setEditable(false);
            tfPerceptionCost.setAlignment(Pos.CENTER);
            tfPerceptionCost.setPrefWidth(50);
        TextField tfWillCost       = new TextField();
            tfWillCost.setEditable(false);
            tfWillCost.setAlignment(Pos.CENTER);
            tfWillCost.setPrefWidth(50);        
        paneForMentalCosts.getChildren().addAll(
                new Label("  Cost"),
                tfLearningCost,
                tfLogicCost,
                tfPerceptionCost,
                tfWillCost);
        
        VBox paneForMentalRBs    = new VBox(rbSpacing);
            paneForMentalRBs.setPrefWidth(rbPaneWidth);
        RadioButton rbLearning   = new RadioButton(" Learning   ");
        RadioButton rbLogic      = new RadioButton(" Logic      ");
        RadioButton rbPerception = new RadioButton(" Perception ");
        RadioButton rbWill       = new RadioButton(" Will       ");
        paneForMentalRBs.getChildren().addAll(
                new Label("  Attribute"),
                rbLearning,
                rbLogic,
                rbPerception,
                rbWill);
        
        VBox paneForMentalValues    = new VBox();
        TextField tfLearningValue   = new TextField();
            tfLearningValue.setEditable(false);
            tfLearningValue.setAlignment(Pos.CENTER);
            tfLearningValue.setPrefWidth(50);
        TextField tfLogicValue      = new TextField();
            tfLogicValue.setEditable(false);
            tfLogicValue.setAlignment(Pos.CENTER);
            tfLogicValue.setPrefWidth(50);
        TextField tfPerceptionValue = new TextField();
            tfPerceptionValue.setEditable(false);
            tfPerceptionValue.setAlignment(Pos.CENTER);
            tfPerceptionValue.setPrefWidth(50);
        TextField tfWillValue       = new TextField();
            tfWillValue.setEditable(false);
            tfWillValue.setAlignment(Pos.CENTER);
            tfWillValue.setPrefWidth(50);
        paneForMentalValues.getChildren().addAll(
                new Label("  Value"),
                tfLearningValue,
                tfLogicValue,
                tfPerceptionValue,
                tfWillValue);
        
        VBox paneForMentalDice    = new VBox();
        TextField tfLearningDice  = new TextField();
            tfLearningDice.setEditable(false);
            tfLearningDice.setAlignment(Pos.CENTER);
            tfLearningDice.setPrefWidth(50);
        TextField tfLogicDice     = new TextField();
           tfLogicDice.setEditable(false);
            tfLogicDice.setAlignment(Pos.CENTER);
            tfLogicDice.setPrefWidth(50);
        TextField tfPerceptionDice = new TextField();
            tfPerceptionDice.setEditable(false);
            tfPerceptionDice.setAlignment(Pos.CENTER);
            tfPerceptionDice.setPrefWidth(50);
        TextField tfWillDice       = new TextField();
            tfWillDice.setEditable(false);
            tfWillDice.setAlignment(Pos.CENTER);
            tfWillDice.setPrefWidth(50);
        paneForMentalDice.getChildren().addAll(
                new Label("  Dice"),
                tfLearningDice,
                tfLogicDice,
                tfPerceptionDice,
                tfWillDice);

        paneForMentalAttributes.getChildren().addAll(
                paneForMentalCosts,
                paneForMentalRBs,
                paneForMentalValues,
                paneForMentalDice);
        
        
        HBox paneForSocialAttributes = new HBox();
        
        VBox paneForSocialCosts    = new VBox();
        TextField tfDeceptionCost  = new TextField();
            tfDeceptionCost.setEditable(false);
            tfDeceptionCost.setAlignment(Pos.CENTER);
            tfDeceptionCost.setPrefWidth(50);
        TextField tfPersuasionCost = new TextField();
            tfPersuasionCost.setEditable(false);
            tfPersuasionCost.setAlignment(Pos.CENTER);
            tfPersuasionCost.setPrefWidth(50);
        TextField tfPresenceCost   = new TextField();
            tfPresenceCost.setEditable(false);
            tfPresenceCost.setAlignment(Pos.CENTER);
            tfPresenceCost.setPrefWidth(50);
        paneForSocialCosts.getChildren().addAll(
                new Label("  Cost"),
                tfDeceptionCost,
                tfPersuasionCost,
                tfPresenceCost);
        
        VBox paneForSocialRBs    = new VBox(rbSpacing);
            paneForSocialRBs.setPrefWidth(rbPaneWidth);
        RadioButton rbDeception  = new RadioButton(" Deception  ");
        RadioButton rbPersuasion = new RadioButton(" Persuasion ");
        RadioButton rbPresence   = new RadioButton(" Presence   ");
        paneForSocialRBs.getChildren().addAll(
                new Label("  Attribute"),
                rbDeception,
                rbPersuasion,
                rbPresence);
        
        VBox paneForSocialValues    = new VBox();
        TextField tfDeceptionValue  = new TextField();
            tfDeceptionValue.setEditable(false);
            tfDeceptionValue.setAlignment(Pos.CENTER);
            tfDeceptionValue.setPrefWidth(50);
        TextField tfPersuasionValue = new TextField();
            tfPersuasionValue.setEditable(false);
            tfPersuasionValue.setAlignment(Pos.CENTER);
            tfPersuasionValue.setPrefWidth(50);        
        TextField tfPresenceValue  = new TextField();
            tfPresenceValue.setEditable(false);
            tfPresenceValue.setAlignment(Pos.CENTER);
            tfPresenceValue.setPrefWidth(50);        
        paneForSocialValues.getChildren().addAll(
                new Label("  Value"),
                tfDeceptionValue,
                tfPersuasionValue,
                tfPresenceValue);
        
        VBox paneForSocialDice = new VBox();
        TextField tfDeceptionDice = new TextField();
            tfDeceptionDice.setEditable(false);
            tfDeceptionDice.setAlignment(Pos.CENTER);
            tfDeceptionDice.setPrefWidth(50);
        TextField tfPersuasionDice = new TextField();
            tfPersuasionDice.setEditable(false);
            tfPersuasionDice.setAlignment(Pos.CENTER);
            tfPersuasionDice.setPrefWidth(50);
        TextField tfPresenceDice = new TextField();
            tfPresenceDice.setEditable(false);
            tfPresenceDice.setAlignment(Pos.CENTER);
            tfPresenceDice.setPrefWidth(50);
        paneForSocialDice.getChildren().addAll(
                new Label("  Dice"),
                tfDeceptionDice,
                tfPersuasionDice,
                tfPresenceDice);

        paneForSocialAttributes.getChildren().addAll(
                paneForSocialCosts,
                paneForSocialRBs,
                paneForSocialValues,
                paneForSocialDice);

        HBox paneForExtraordinaryAttributes = new HBox();
        
        VBox paneForExtraordinaryCosts = new VBox();
        TextField tfAlterationCost = new TextField();
            tfAlterationCost.setEditable(false);
            tfAlterationCost.setAlignment(Pos.CENTER);
            tfAlterationCost.setPrefWidth(50);        
        TextField tfCreationCost = new TextField();
            tfCreationCost.setEditable(false);
            tfCreationCost.setAlignment(Pos.CENTER);
            tfCreationCost.setPrefWidth(50);
        TextField tfEnergyCost = new TextField();
            tfEnergyCost.setEditable(false);
            tfEnergyCost.setAlignment(Pos.CENTER);
            tfEnergyCost.setPrefWidth(50);
        TextField tfEntropyCost = new TextField();
            tfEntropyCost.setEditable(false);
            tfEntropyCost.setAlignment(Pos.CENTER);
            tfEntropyCost.setPrefWidth(50);
        TextField tfInfluenceCost = new TextField();
            tfInfluenceCost.setEditable(false);
            tfInfluenceCost.setAlignment(Pos.CENTER);
            tfInfluenceCost.setPrefWidth(50);
        TextField tfMovementCost = new TextField();
            tfMovementCost.setEditable(false);
            tfMovementCost.setAlignment(Pos.CENTER);
            tfMovementCost.setPrefWidth(50);
        TextField tfPrescienceCost = new TextField();
            tfPrescienceCost.setEditable(false);
            tfPrescienceCost.setAlignment(Pos.CENTER);
            tfPrescienceCost.setPrefWidth(50);
        TextField tfProtectionCost = new TextField();
            tfProtectionCost.setEditable(false);
            tfProtectionCost.setAlignment(Pos.CENTER);
            tfProtectionCost.setPrefWidth(50);
        paneForExtraordinaryCosts.getChildren().addAll(
                new Label("  Cost"),
                tfAlterationCost,
                tfCreationCost,
                tfEnergyCost,
                tfEntropyCost,
                tfInfluenceCost,
                tfMovementCost,
                tfPrescienceCost,
                tfProtectionCost);
        
        VBox paneForExtraordinaryRBs = new VBox(rbSpacing);
            paneForExtraordinaryRBs.setPrefWidth(rbPaneWidth);
        RadioButton rbAlteration     = new RadioButton(" Alteration ");
        RadioButton rbCreation       = new RadioButton(" Creation   ");
        RadioButton rbEnergy         = new RadioButton(" Energy     ");
        RadioButton rbEntropy        = new RadioButton(" Entropy    ");
        RadioButton rbInfluence      = new RadioButton(" Influence  ");
        RadioButton rbMovement       = new RadioButton(" Movement   ");
        RadioButton rbPrescience     = new RadioButton(" Prescience ");
        RadioButton rbProtection     = new RadioButton(" Protection ");
        paneForExtraordinaryRBs.getChildren().addAll(
                new Label("  Attribute"),
                rbAlteration,
                rbCreation,
                rbEnergy,
                rbEntropy,
                rbInfluence,
                rbMovement,
                rbPrescience,
                rbProtection);
        
        VBox paneForExtraordinaryValues = new VBox();
        TextField tfAlterationValue     = new TextField();
            tfAlterationValue.setEditable(false);
            tfAlterationValue.setAlignment(Pos.CENTER);
            tfAlterationValue.setPrefWidth(50);
        TextField tfCreationValue       = new TextField();
            tfCreationValue.setEditable(false);
            tfCreationValue.setAlignment(Pos.CENTER);
            tfCreationValue.setPrefWidth(50);
        TextField tfEnergyValue         = new TextField();
            tfEnergyValue.setEditable(false);
            tfEnergyValue.setAlignment(Pos.CENTER);
            tfEnergyValue.setPrefWidth(50);
        TextField tfEntropyValue        = new TextField();
            tfEntropyValue.setEditable(false);
            tfEntropyValue.setAlignment(Pos.CENTER);
            tfEntropyValue.setPrefWidth(50);
        TextField tfInfluenceValue      = new TextField();
            tfInfluenceValue.setEditable(false);
            tfInfluenceValue.setAlignment(Pos.CENTER);
            tfInfluenceValue.setPrefWidth(50);
        TextField tfMovementValue       = new TextField();
            tfMovementValue.setEditable(false);
            tfMovementValue.setAlignment(Pos.CENTER);
            tfMovementValue.setPrefWidth(50);
        TextField tfPrescienceValue     = new TextField();
            tfPrescienceValue.setEditable(false);
            tfPrescienceValue.setAlignment(Pos.CENTER);
            tfPrescienceValue.setPrefWidth(50);        
        TextField tfProtectionValue     = new TextField();
            tfProtectionValue.setEditable(false);
            tfProtectionValue.setAlignment(Pos.CENTER);
            tfProtectionValue.setPrefWidth(50);        
        paneForExtraordinaryValues.getChildren().addAll(
                new Label("  Value"),
                tfAlterationValue,
                tfCreationValue,
                tfEnergyValue,
                tfEntropyValue,
                tfInfluenceValue,
                tfMovementValue,
                tfPrescienceValue,
                tfProtectionValue);
        
        VBox paneForExtraordinaryDice = new VBox();
        TextField tfAlterationDice    = new TextField();
            tfAlterationDice.setEditable(false);
            tfAlterationDice.setAlignment(Pos.CENTER);
            tfAlterationDice.setPrefWidth(50);
        TextField tfCreationDice      = new TextField();
            tfCreationDice.setEditable(false);
            tfCreationDice.setAlignment(Pos.CENTER);
            tfCreationDice.setPrefWidth(50);
        TextField tfEnergyDice        = new TextField();
            tfEnergyDice.setEditable(false);
            tfEnergyDice.setAlignment(Pos.CENTER);
            tfEnergyDice.setPrefWidth(50);
        TextField tfEntropyDice       = new TextField();
            tfEntropyDice.setEditable(false);
            tfEntropyDice.setAlignment(Pos.CENTER);
            tfEntropyDice.setPrefWidth(50);
        TextField tfInfluenceDice     = new TextField();
            tfInfluenceDice.setEditable(false);
            tfInfluenceDice.setAlignment(Pos.CENTER);
            tfInfluenceDice.setPrefWidth(50);
        TextField tfMovementDice      = new TextField();
            tfMovementDice.setEditable(false);
            tfMovementDice.setAlignment(Pos.CENTER);
            tfMovementDice.setPrefWidth(50);
        TextField tfPrescienceDice    = new TextField();
            tfPrescienceDice.setEditable(false);
            tfPrescienceDice.setAlignment(Pos.CENTER);
            tfPrescienceDice.setPrefWidth(50);
        TextField tfProtectionDice    = new TextField();
            tfProtectionDice.setEditable(false);
            tfProtectionDice.setAlignment(Pos.CENTER);
            tfProtectionDice.setPrefWidth(50);
        paneForExtraordinaryDice.getChildren().addAll(
                new Label("  Dice"),
                tfAlterationDice,
                tfCreationDice,
                tfEnergyDice,
                tfEntropyDice,
                tfInfluenceDice,
                tfMovementDice,
                tfPrescienceDice,
                tfProtectionDice);

        paneForExtraordinaryAttributes.getChildren().addAll(
                paneForExtraordinaryCosts,
                paneForExtraordinaryRBs,
                paneForExtraordinaryValues,
                paneForExtraordinaryDice);

        // pane for attribute point display and controls
        HBox paneForAttributeControls = new HBox();
        TextField tfAttributePoints   = new TextField("40 / 40");
            tfAttributePoints.setEditable(false);
            tfAttributePoints.setAlignment(Pos.CENTER);
            tfAttributePoints.setPrefWidth(80);
        Button btIncreaseAttribute    = new Button("Increase +");
        Button btDecreaseAttribute    = new Button("Decrease -");
        paneForAttributeControls.getChildren().addAll(
                tfAttributePoints,
                btIncreaseAttribute,
                btDecreaseAttribute);

        // add items to pane for attributes
        paneForAttributes.getChildren().addAll(
                new Label("        Physical Attributes"),
                paneForPhysicalAttributes,
                new Label("        Mental Attributes"),
                paneForMentalAttributes,
                new Label("        Social Attributes"),
                paneForSocialAttributes,
                new Label("        Extraordinary Attributes"),
                paneForExtraordinaryAttributes,
                new Label("  Points"),
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

        
        HBox paneForDescriptions = new HBox(10);

        VBox paneForMessages = new VBox();
        TextArea taDescription = new TextArea();
            taDescription.setEditable(false);
            taDescription.setPrefSize(sceneWidth * .325, sceneHeight * .15);
            taDescription.setWrapText(true);
        ScrollPane spDescription = new ScrollPane(taDescription);
        paneForMessages.getChildren().addAll(
                new Label("Description"),
                spDescription);

        VBox paneForBio = new VBox();
        TextArea taBio = new TextArea();
            taBio.setPrefSize(sceneWidth * .65, sceneHeight * .15);
            taBio.setWrapText(true);
        ScrollPane spBio = new ScrollPane(taBio);
        paneForBio.getChildren().addAll(
                new Label("Character Biography"),
                spBio);

        paneForDescriptions.getChildren().addAll(
                paneForMessages,
                paneForBio);

        pane.setBottom(paneForDescriptions);
        
        
        VBox rightSidePane = new VBox(10);
        
        Pane imagePane = new Pane();
        Image characterImage = new Image("DefaultImage.jpg");
        ImageView characterImageView = new ImageView(characterImage);
            characterImageView.setFitWidth(sceneWidth * .125);
            characterImageView.setFitHeight(sceneHeight * .375);
            characterImageView.setPreserveRatio(true);
            characterImageView.setSmooth(true);
        imagePane.getChildren().add(characterImageView);
        TextField tfImageLocation = new TextField();
            tfImageLocation.setPrefWidth(sceneWidth * .125);
        
        VBox paneForSecondaryStats = new VBox();
        
        HBox paneForToughness = new HBox();
        TextField tfToughnessDefense = new TextField("10");
            tfToughnessDefense.setEditable(false);
            tfToughnessDefense.setAlignment(Pos.CENTER);
            tfToughnessDefense.setPrefWidth(50);
        paneForToughness.getChildren().addAll(
                tfToughnessDefense,
                new Label("  Toughness Defense"));
        
        HBox paneForGuard = new HBox();
        TextField tfGuardDefense = new TextField("10");
            tfGuardDefense.setEditable(false);
            tfGuardDefense.setAlignment(Pos.CENTER);
            tfGuardDefense.setPrefWidth(50);
        paneForGuard.getChildren().addAll(
                tfGuardDefense,
                new Label("  Guard Defense"));
        
        HBox paneForResolve = new HBox();
        TextField tfResolveDefense   = new TextField("10");
            tfResolveDefense.setEditable(false);
            tfResolveDefense.setAlignment(Pos.CENTER);
            tfResolveDefense.setPrefWidth(50);
        paneForResolve.getChildren().addAll(
                tfResolveDefense,
                new Label("  Resolve Defense"));
        
        HBox paneForHitPoints = new HBox();
        TextField tfHitPoints = new TextField("10");
            tfHitPoints.setEditable(false);
            tfHitPoints.setAlignment(Pos.CENTER);
            tfHitPoints.setPrefWidth(50);
        paneForHitPoints.getChildren().addAll(
                tfHitPoints,
                new Label ("  Hit Points"));
        
        HBox paneForSpeed = new HBox();
        TextField tfSpeed = new TextField("30'");
            tfSpeed.setEditable(false);
            tfSpeed.setAlignment(Pos.CENTER);
            tfSpeed.setPrefWidth(50);
        paneForSpeed.getChildren().addAll(
                tfSpeed,
                new Label("  Speed"));
        
        paneForSecondaryStats.getChildren().addAll(
                paneForToughness,
                paneForGuard,
                paneForResolve,
                paneForHitPoints,
                paneForSpeed);
        
        rightSidePane.getChildren().addAll(
                new Label("Character Image"),
                imagePane,
                new Label("Filename"),
                tfImageLocation,
                new Label("\n\n  Secondary Stats"),
                paneForSecondaryStats);
        
        pane.setRight(rightSidePane);
        
        tfImageLocation.setOnMouseClicked(e -> {
            taDescription.setText("Enter the name of an image file...");
        });
        
        tfImageLocation.setOnAction(e -> {
            String imageLocation = tfImageLocation.getText();
            try {
                characterImageView.setImage(new Image(imageLocation));
            } catch (Exception exception) {
                taDescription.setText("Error!  Image not found...");
            };
        });
        
        
        // create handlers for radio buttons
        rbAgility.setOnAction(e -> {
            taDescription.setText(AGILITY_DESCRIPTION);});
        rbFortitude.setOnAction(e -> {
            taDescription.setText(FORTITUDE_DESCRIPTION);});
        rbMight.setOnAction(e -> {
            taDescription.setText(MIGHT_DESCRIPTION);});
        rbLearning.setOnAction(e -> {
            taDescription.setText(LEARNING_DESCRIPTION);});
        rbLogic.setOnAction(e -> {
            taDescription.setText(LOGIC_DESCRIPTION);});
        rbPerception.setOnAction(e -> {
            taDescription.setText(PERCEPTION_DESCRIPTION);});
        rbWill.setOnAction(e -> {
            taDescription.setText(WILL_DESCRIPTION);});
        rbDeception.setOnAction(e -> {
            taDescription.setText(DECEPTION_DESCRIPTION);});
        rbPersuasion.setOnAction(e -> {
            taDescription.setText(PERSUASION_DESCRIPTION);});
        rbPresence.setOnAction(e -> {
            taDescription.setText(PRESENCE_DESCRIPTION);});
        rbAlteration.setOnAction(e -> {
            taDescription.setText(ALTERATION_DESCRIPTION);});
        rbCreation.setOnAction(e -> {
            taDescription.setText(CREATION_DESCRIPTION);});
        rbEnergy.setOnAction(e -> {
            taDescription.setText(ENERGY_DESCRIPTION);});
        rbEntropy.setOnAction(e -> {
            taDescription.setText(ENTROPY_DESCRIPTION);});
        rbInfluence.setOnAction(e -> {
            taDescription.setText(INFLUENCE_DESCRIPTION);});
        rbMovement.setOnAction(e -> {
            taDescription.setText(MOVEMENT_DESCRIPTION);});
        rbPrescience.setOnAction(e -> {
            taDescription.setText(PRESCIENCE_DESCRIPTION);});
        rbProtection.setOnAction(e -> {
            taDescription.setText(PROTECTION_DESCRIPTION);});

        // create handlers for increase/decrease attribute buttons
        btDecreaseAttribute.setOnAction(e -> {
            int value;
            String currentAttributePoints;
            String maximumAttributePoints;
            if (rbAgility.isSelected()) {
                value = characterSheet.getAgility();
                if (value == 0) {
                    taDescription.setText("You cannot lower an attribute below 0...");
                } else {
                    value -= 1;
                    characterSheet.setAgility(value);
                    currentAttributePoints = Integer.toString(characterSheet.getAttributePointsCurrent());
                    maximumAttributePoints = Integer.toString(characterSheet.getAttributePointsMaximum());
                    tfAttributePoints.setText(currentAttributePoints + " / " + maximumAttributePoints);
                    tfAgilityDice.setText(attributeDice[value]);
                    tfGuardDefense.setText(Integer.toString(characterSheet.getGuardDefense()));
                    taDescription.setText(AGILITY_DESCRIPTION);
                    if (value == 0) {
                        tfAgilityCost.setText("");
                        tfAgilityValue.setText("-");
                    } else {
                        tfAgilityCost.setText(Integer.toString(attributeCost[value]));
                        tfAgilityValue.setText(Integer.toString(value));
                    }
                }
            } else if (rbFortitude.isSelected()) {
                value = characterSheet.getFortitude();
                if (value == 0) {
                    taDescription.setText("You cannot lower an attribute below 0...");
                } else {
                    value -= 1;
                    characterSheet.setFortitude(value);
                    currentAttributePoints = Integer.toString(characterSheet.getAttributePointsCurrent());
                    maximumAttributePoints = Integer.toString(characterSheet.getAttributePointsMaximum());
                    tfAttributePoints.setText(currentAttributePoints + " / " + maximumAttributePoints);
                    tfFortitudeDice.setText(attributeDice[value]);
                    tfToughnessDefense.setText(Integer.toString(characterSheet.getToughnessDefense()));
                    tfHitPoints.setText(Integer.toString(characterSheet.getHitPoints()));
                    taDescription.setText(FORTITUDE_DESCRIPTION);
                    if (value == 0) {
                        tfFortitudeCost.setText("");
                        tfFortitudeValue.setText("-");
                    } else {
                        tfFortitudeCost.setText(Integer.toString(attributeCost[value]));
                        tfFortitudeValue.setText(Integer.toString(value));
                    }
                }
            } else if (rbMight.isSelected()) {
                value = characterSheet.getMight();
                if (value == 0) {
                    taDescription.setText("You cannot lower an attribute below 0...");
                } else {
                    value -= 1;
                    characterSheet.setMight(value);
                    currentAttributePoints = Integer.toString(characterSheet.getAttributePointsCurrent());
                    maximumAttributePoints = Integer.toString(characterSheet.getAttributePointsMaximum());
                    tfAttributePoints.setText(currentAttributePoints + " / " + maximumAttributePoints);
                    tfMightDice.setText(attributeDice[value]);
                    tfGuardDefense.setText(Integer.toString(characterSheet.getGuardDefense()));
                    taDescription.setText(MIGHT_DESCRIPTION);
                    if (value == 0) {
                        tfMightCost.setText("");
                        tfMightValue.setText("-");
                    } else {
                        tfMightCost.setText(Integer.toString(attributeCost[value]));
                        tfMightValue.setText(Integer.toString(value));
                    }
                }
            } else if (rbLearning.isSelected()) {
                value = characterSheet.getLearning();
                if (value == 0) {
                    taDescription.setText("You cannot lower an attribute below 0...");
                } else {
                    value -= 1;
                    characterSheet.setLearning(value);
                    currentAttributePoints = Integer.toString(characterSheet.getAttributePointsCurrent());
                    maximumAttributePoints = Integer.toString(characterSheet.getAttributePointsMaximum());
                    tfAttributePoints.setText(currentAttributePoints + " / " + maximumAttributePoints);
                    tfLearningDice.setText(attributeDice[value]);
                    taDescription.setText(LEARNING_DESCRIPTION);
                    if (value == 0) {
                        tfLearningCost.setText("");
                        tfLearningValue.setText("-");
                    } else {
                        tfLearningCost.setText(Integer.toString(attributeCost[value]));
                        tfLearningValue.setText(Integer.toString(value));
                    }
                }
            } else if (rbLogic.isSelected()) {
                value = characterSheet.getLogic();
                if (value == 0) {
                    taDescription.setText("You cannot lower an attribute below 0...");
                } else {
                    value -= 1;
                    characterSheet.setLogic(value);
                    currentAttributePoints = Integer.toString(characterSheet.getAttributePointsCurrent());
                    maximumAttributePoints = Integer.toString(characterSheet.getAttributePointsMaximum());
                    tfAttributePoints.setText(currentAttributePoints + " / " + maximumAttributePoints);
                    tfLogicDice.setText(attributeDice[value]);
                    taDescription.setText(LOGIC_DESCRIPTION);
                    if (value == 0) {
                        tfLogicCost.setText("");
                        tfLogicValue.setText("-");
                    } else {
                        tfLogicCost.setText(Integer.toString(attributeCost[value]));
                        tfLogicValue.setText(Integer.toString(value));
                    }
                }
            } else if (rbPerception.isSelected()) {
                value = characterSheet.getPerception();
                if (value == 0) {
                    taDescription.setText("You cannot lower an attribute below 0...");
                } else {
                    value -= 1;
                    characterSheet.setPerception(value);
                    currentAttributePoints = Integer.toString(characterSheet.getAttributePointsCurrent());
                    maximumAttributePoints = Integer.toString(characterSheet.getAttributePointsMaximum());
                    tfAttributePoints.setText(currentAttributePoints + " / " + maximumAttributePoints);
                    tfPerceptionDice.setText(attributeDice[value]);
                    taDescription.setText(PERCEPTION_DESCRIPTION);
                    if (value == 0) {
                        tfPerceptionCost.setText("");
                        tfPerceptionValue.setText("-");
                    } else {
                        tfPerceptionCost.setText(Integer.toString(attributeCost[value]));
                        tfPerceptionValue.setText(Integer.toString(value));
                    }
                }
            } else if (rbWill.isSelected()) {
                value = characterSheet.getWill();
                if (value == 0) {
                    taDescription.setText("You cannot lower an attribute below 0...");
                } else {
                    value -= 1;
                    characterSheet.setWill(value);
                    currentAttributePoints = Integer.toString(characterSheet.getAttributePointsCurrent());
                    maximumAttributePoints = Integer.toString(characterSheet.getAttributePointsMaximum());
                    tfAttributePoints.setText(currentAttributePoints + " / " + maximumAttributePoints);
                    tfWillDice.setText(attributeDice[value]);
                    tfToughnessDefense.setText(Integer.toString(characterSheet.getToughnessDefense()));
                    tfResolveDefense.setText(Integer.toString(characterSheet.getResolveDefense()));
                    tfHitPoints.setText(Integer.toString(characterSheet.getHitPoints()));
                    taDescription.setText(WILL_DESCRIPTION);
                    if (value == 0) {
                        tfWillCost.setText("");
                        tfWillValue.setText("-");
                    } else {
                        tfWillCost.setText(Integer.toString(attributeCost[value]));
                        tfWillValue.setText(Integer.toString(value));
                    }
                }
            } else if (rbDeception.isSelected()) {
                value = characterSheet.getDeception();
                if (value == 0) {
                    taDescription.setText("You cannot lower an attribute below 0...");
                } else {
                    value -= 1;
                    characterSheet.setDeception(value);
                    currentAttributePoints = Integer.toString(characterSheet.getAttributePointsCurrent());
                    maximumAttributePoints = Integer.toString(characterSheet.getAttributePointsMaximum());
                    tfAttributePoints.setText(currentAttributePoints + " / " + maximumAttributePoints);
                    tfDeceptionDice.setText(attributeDice[value]);
                    taDescription.setText(DECEPTION_DESCRIPTION);
                    if (value == 0) {
                        tfDeceptionCost.setText("");
                        tfDeceptionValue.setText("-");
                    } else {
                        tfDeceptionCost.setText(Integer.toString(attributeCost[value]));
                        tfDeceptionValue.setText(Integer.toString(value));
                    }
                }
            } else if (rbPersuasion.isSelected()) {
                value = characterSheet.getPersuasion();
                if (value == 0) {
                    taDescription.setText("You cannot lower an attribute below 0...");
                } else {
                    value -= 1;
                    characterSheet.setPersuasion(value);
                    currentAttributePoints = Integer.toString(characterSheet.getAttributePointsCurrent());
                    maximumAttributePoints = Integer.toString(characterSheet.getAttributePointsMaximum());
                    tfAttributePoints.setText(currentAttributePoints + " / " + maximumAttributePoints);
                    tfPersuasionDice.setText(attributeDice[value]);
                    taDescription.setText(PERSUASION_DESCRIPTION);
                    if (value == 0) {
                        tfPersuasionCost.setText("");
                        tfPersuasionValue.setText("-");
                    } else {
                        tfPersuasionCost.setText(Integer.toString(attributeCost[value]));
                        tfPersuasionValue.setText(Integer.toString(value));
                    }
                }
            } else if (rbPresence.isSelected()) {
                value = characterSheet.getPresence();
                if (value == 0) {
                    taDescription.setText("You cannot lower an attribute below 0...");
                } else {
                    value -= 1;
                    characterSheet.setPresence(value);
                    currentAttributePoints = Integer.toString(characterSheet.getAttributePointsCurrent());
                    maximumAttributePoints = Integer.toString(characterSheet.getAttributePointsMaximum());
                    tfAttributePoints.setText(currentAttributePoints + " / " + maximumAttributePoints);
                    tfPresenceDice.setText(attributeDice[value]);
                    tfResolveDefense.setText(Integer.toString(characterSheet.getResolveDefense()));
                    tfHitPoints.setText(Integer.toString(characterSheet.getHitPoints()));
                    taDescription.setText(PRESENCE_DESCRIPTION);
                    if (value == 0) {
                        tfPresenceCost.setText("");
                        tfPresenceValue.setText("-");
                    } else {
                        tfPresenceCost.setText(Integer.toString(attributeCost[value]));
                        tfPresenceValue.setText(Integer.toString(value));
                    }
                }
            } else if (rbAlteration.isSelected()) {
                value = characterSheet.getAlteration();
                if (value == 0) {
                    taDescription.setText("You cannot lower an attribute below 0...");
                } else {
                    value -= 1;
                    characterSheet.setAlteration(value);
                    currentAttributePoints = Integer.toString(characterSheet.getAttributePointsCurrent());
                    maximumAttributePoints = Integer.toString(characterSheet.getAttributePointsMaximum());
                    tfAttributePoints.setText(currentAttributePoints + " / " + maximumAttributePoints);
                    tfAlterationDice.setText(attributeDice[value]);
                    taDescription.setText(ALTERATION_DESCRIPTION);
                    if (value == 0) {
                        tfAlterationCost.setText("");
                        tfAlterationValue.setText("-");
                    } else {
                        tfAlterationCost.setText(Integer.toString(attributeCost[value]));
                        tfAlterationValue.setText(Integer.toString(value));
                    }
                }
            } else if (rbCreation.isSelected()) {
                value = characterSheet.getCreation();
                if (value == 0) {
                    taDescription.setText("You cannot lower an attribute below 0...");
                } else {
                    value -= 1;
                    characterSheet.setCreation(value);
                    currentAttributePoints = Integer.toString(characterSheet.getAttributePointsCurrent());
                    maximumAttributePoints = Integer.toString(characterSheet.getAttributePointsMaximum());
                    tfAttributePoints.setText(currentAttributePoints + " / " + maximumAttributePoints);
                    tfCreationDice.setText(attributeDice[value]);
                    taDescription.setText(CREATION_DESCRIPTION);
                    if (value == 0) {
                        tfCreationCost.setText("");
                        tfCreationValue.setText("-");
                    } else {
                        tfCreationCost.setText(Integer.toString(attributeCost[value]));
                        tfCreationValue.setText(Integer.toString(value));
                    }
                }
            } else if (rbEnergy.isSelected()) {
                value = characterSheet.getEnergy();
                if (value == 0) {
                    taDescription.setText("You cannot lower an attribute below 0...");
                } else {
                    value -= 1;
                    characterSheet.setEnergy(value);
                    currentAttributePoints = Integer.toString(characterSheet.getAttributePointsCurrent());
                    maximumAttributePoints = Integer.toString(characterSheet.getAttributePointsMaximum());
                    tfAttributePoints.setText(currentAttributePoints + " / " + maximumAttributePoints);
                    tfEnergyDice.setText(attributeDice[value]);
                    taDescription.setText(ENERGY_DESCRIPTION);
                    if (value == 0) {
                        tfEnergyCost.setText("");
                        tfEnergyValue.setText("-");
                    } else {
                        tfEnergyCost.setText(Integer.toString(attributeCost[value]));
                        tfEnergyValue.setText(Integer.toString(value));
                    }
                }
            } else if (rbEntropy.isSelected()) {
                value = characterSheet.getEntropy();
                if (value == 0) {
                    taDescription.setText("You cannot lower an attribute below 0...");
                } else {
                    value -= 1;
                    characterSheet.setEntropy(value);
                    currentAttributePoints = Integer.toString(characterSheet.getAttributePointsCurrent());
                    maximumAttributePoints = Integer.toString(characterSheet.getAttributePointsMaximum());
                    tfAttributePoints.setText(currentAttributePoints + " / " + maximumAttributePoints);
                    tfEntropyDice.setText(attributeDice[value]);
                    taDescription.setText(ENTROPY_DESCRIPTION);
                    if (value == 0) {
                        tfEntropyCost.setText("");
                        tfEntropyValue.setText("-");
                    } else {
                        tfEntropyCost.setText(Integer.toString(attributeCost[value]));
                        tfEntropyValue.setText(Integer.toString(value));
                    }
                }
            } else if (rbInfluence.isSelected()) {
                value = characterSheet.getInfluence();
                if (value == 0) {
                    taDescription.setText("You cannot lower an attribute below 0...");
                } else {
                    value -= 1;
                    characterSheet.setInfluence(value);
                    currentAttributePoints = Integer.toString(characterSheet.getAttributePointsCurrent());
                    maximumAttributePoints = Integer.toString(characterSheet.getAttributePointsMaximum());
                    tfAttributePoints.setText(currentAttributePoints + " / " + maximumAttributePoints);
                    tfInfluenceDice.setText(attributeDice[value]);
                    taDescription.setText(INFLUENCE_DESCRIPTION);
                    if (value == 0) {
                        tfInfluenceCost.setText("");
                        tfInfluenceValue.setText("-");
                    } else {
                        tfInfluenceCost.setText(Integer.toString(attributeCost[value]));
                        tfInfluenceValue.setText(Integer.toString(value));
                    }
                }
            } else if (rbMovement.isSelected()) {
                value = characterSheet.getMovement();
                if (value == 0) {
                    taDescription.setText("You cannot lower an attribute below 0...");
                } else {
                    value -= 1;
                    characterSheet.setMovement(value);
                    currentAttributePoints = Integer.toString(characterSheet.getAttributePointsCurrent());
                    maximumAttributePoints = Integer.toString(characterSheet.getAttributePointsMaximum());
                    tfAttributePoints.setText(currentAttributePoints + " / " + maximumAttributePoints);
                    tfMovementDice.setText(attributeDice[value]);
                    taDescription.setText(MOVEMENT_DESCRIPTION);
                    if (value == 0) {
                        tfMovementCost.setText("");
                        tfMovementValue.setText("-");
                    } else {
                        tfMovementCost.setText(Integer.toString(attributeCost[value]));
                        tfMovementValue.setText(Integer.toString(value));
                    }
                }
            } else if (rbPrescience.isSelected()) {
                value = characterSheet.getPrescience();
                if (value == 0) {
                    taDescription.setText("You cannot lower an attribute below 0...");
                } else {
                    value -= 1;
                    characterSheet.setPrescience(value);
                    currentAttributePoints = Integer.toString(characterSheet.getAttributePointsCurrent());
                    maximumAttributePoints = Integer.toString(characterSheet.getAttributePointsMaximum());
                    tfAttributePoints.setText(currentAttributePoints + " / " + maximumAttributePoints);
                    tfPrescienceDice.setText(attributeDice[value]);
                    taDescription.setText(PRESCIENCE_DESCRIPTION);
                    if (value == 0) {
                        tfPrescienceCost.setText("");
                        tfPrescienceValue.setText("-");
                    } else {
                        tfPrescienceCost.setText(Integer.toString(attributeCost[value]));
                        tfPrescienceValue.setText(Integer.toString(value));
                    }
                }
            } else if (rbProtection.isSelected()) {
                value = characterSheet.getProtection();
                if (value == 0) {
                    taDescription.setText("You cannot lower an attribute below 0...");
                } else {
                    value -= 1;
                    characterSheet.setProtection(value);
                    currentAttributePoints = Integer.toString(characterSheet.getAttributePointsCurrent());
                    maximumAttributePoints = Integer.toString(characterSheet.getAttributePointsMaximum());
                    tfAttributePoints.setText(currentAttributePoints + " / " + maximumAttributePoints);
                    tfProtectionDice.setText(attributeDice[value]);
                    taDescription.setText(PROTECTION_DESCRIPTION);
                    if (value == 0) {
                        tfProtectionCost.setText("");
                        tfProtectionValue.setText("-");
                    } else {
                        tfProtectionCost.setText(Integer.toString(attributeCost[value]));
                        tfProtectionValue.setText(Integer.toString(value));
                    }
                }
            }
        });

        btIncreaseAttribute.setOnAction(e -> {
            int value;
            int difference;
            String currentAttributePoints;
            String maximumAttributePoints;
            if (rbAgility.isSelected()) {
                value = characterSheet.getAgility();
                if (value == 5) {
                    taDescription.setText("You cannot raise an attribute above 5...");
                } else {
                    difference = (attributeCost[value + 1] - attributeCost[value]);
                    if (difference > characterSheet.getAttributePointsCurrent()) {
                        taDescription.setText("You do not have enough points to do that...");
                    } else {
                        value += 1;
                        characterSheet.setAgility(value);
                        currentAttributePoints = Integer.toString(characterSheet.getAttributePointsCurrent());
                        maximumAttributePoints = Integer.toString(characterSheet.getAttributePointsMaximum());
                        tfAttributePoints.setText(currentAttributePoints + " / " + maximumAttributePoints);
                        tfAgilityCost.setText(Integer.toString(attributeCost[value]));
                        tfAgilityValue.setText(Integer.toString(value));
                        tfAgilityDice.setText(attributeDice[value]);
                        tfGuardDefense.setText(Integer.toString(characterSheet.getGuardDefense()));
                        taDescription.setText(AGILITY_DESCRIPTION);
                    }
                }
            } else if (rbFortitude.isSelected()) {
                value = characterSheet.getFortitude();
                if (value == 5) {
                    taDescription.setText("You cannot raise an attribute above 5...");
                } else {
                    difference = (attributeCost[value + 1] - attributeCost[value]);
                    if (difference > characterSheet.getAttributePointsCurrent()) {
                        taDescription.setText("You do not have enough points to do that...");
                    } else {
                        value += 1;
                        characterSheet.setFortitude(value);
                        currentAttributePoints = Integer.toString(characterSheet.getAttributePointsCurrent());
                        maximumAttributePoints = Integer.toString(characterSheet.getAttributePointsMaximum());
                        tfAttributePoints.setText(currentAttributePoints + " / " + maximumAttributePoints);
                        tfFortitudeCost.setText(Integer.toString(attributeCost[value]));
                        tfFortitudeValue.setText(Integer.toString(value));
                        tfFortitudeDice.setText(attributeDice[value]);
                        tfToughnessDefense.setText(Integer.toString(characterSheet.getToughnessDefense()));
                        tfHitPoints.setText(Integer.toString(characterSheet.getHitPoints()));
                        taDescription.setText(FORTITUDE_DESCRIPTION);
                    }
                }
            } else if (rbMight.isSelected()) {
                value = characterSheet.getMight();
                if (value == 5) {
                    taDescription.setText("You cannot raise an attribute above 5...");
                } else {
                    difference = (attributeCost[value + 1] - attributeCost[value]);
                    if (difference > characterSheet.getAttributePointsCurrent()) {
                        taDescription.setText("You do not have enough points to do that...");
                    } else {
                        value += 1;
                        characterSheet.setMight(value);
                        currentAttributePoints = Integer.toString(characterSheet.getAttributePointsCurrent());
                        maximumAttributePoints = Integer.toString(characterSheet.getAttributePointsMaximum());
                        tfAttributePoints.setText(currentAttributePoints + " / " + maximumAttributePoints);
                        tfMightCost.setText(Integer.toString(attributeCost[value]));
                        tfMightValue.setText(Integer.toString(value));
                        tfMightDice.setText(attributeDice[value]);
                        tfGuardDefense.setText(Integer.toString(characterSheet.getGuardDefense()));
                        taDescription.setText(MIGHT_DESCRIPTION);
                    }
                }
            } else if (rbLearning.isSelected()) {
                value = characterSheet.getLearning();
                if (value == 5) {
                    taDescription.setText("You cannot raise an attribute above 5...");
                } else {
                    difference = (attributeCost[value + 1] - attributeCost[value]);
                    if (difference > characterSheet.getAttributePointsCurrent()) {
                        taDescription.setText("You do not have enough points to do that...");
                    } else {
                        value += 1;
                        characterSheet.setLearning(value);
                        currentAttributePoints = Integer.toString(characterSheet.getAttributePointsCurrent());
                        maximumAttributePoints = Integer.toString(characterSheet.getAttributePointsMaximum());
                        tfAttributePoints.setText(currentAttributePoints + " / " + maximumAttributePoints);
                        tfLearningCost.setText(Integer.toString(attributeCost[value]));
                        tfLearningValue.setText(Integer.toString(value));
                        tfLearningDice.setText(attributeDice[value]);
                        taDescription.setText(LEARNING_DESCRIPTION);
                    }
                }
            } else if (rbLogic.isSelected()) {
                value = characterSheet.getLogic();
                if (value == 5) {
                    taDescription.setText("You cannot raise an attribute above 5...");
                } else {
                    difference = (attributeCost[value + 1] - attributeCost[value]);
                    if (difference > characterSheet.getAttributePointsCurrent()) {
                        taDescription.setText("You do not have enough points to do that...");
                    } else {
                        value += 1;
                        characterSheet.setLogic(value);
                        currentAttributePoints = Integer.toString(characterSheet.getAttributePointsCurrent());
                        maximumAttributePoints = Integer.toString(characterSheet.getAttributePointsMaximum());
                        tfAttributePoints.setText(currentAttributePoints + " / " + maximumAttributePoints);
                        tfLogicCost.setText(Integer.toString(attributeCost[value]));
                        tfLogicValue.setText(Integer.toString(value));
                        tfLogicDice.setText(attributeDice[value]);
                        taDescription.setText(LOGIC_DESCRIPTION);
                    }
                }
            } else if (rbPerception.isSelected()) {
                value = characterSheet.getPerception();
                if (value == 5) {
                    taDescription.setText("You cannot raise an attribute above 5...");
                } else {
                    difference = (attributeCost[value + 1] - attributeCost[value]);
                    if (difference > characterSheet.getAttributePointsCurrent()) {
                        taDescription.setText("You do not have enough points to do that...");
                    } else {
                        value += 1;
                        characterSheet.setPerception(value);
                        currentAttributePoints = Integer.toString(characterSheet.getAttributePointsCurrent());
                        maximumAttributePoints = Integer.toString(characterSheet.getAttributePointsMaximum());
                        tfAttributePoints.setText(currentAttributePoints + " / " + maximumAttributePoints);
                        tfPerceptionCost.setText(Integer.toString(attributeCost[value]));
                        tfPerceptionValue.setText(Integer.toString(value));
                        tfPerceptionDice.setText(attributeDice[value]);
                        taDescription.setText(PERCEPTION_DESCRIPTION);
                    }
                }
            } else if (rbWill.isSelected()) {
                value = characterSheet.getWill();
                if (value == 5) {
                    taDescription.setText("You cannot raise an attribute above 5...");
                } else {
                    difference = (attributeCost[value + 1] - attributeCost[value]);
                    if (difference > characterSheet.getAttributePointsCurrent()) {
                        taDescription.setText("You do not have enough points to do that...");
                    } else {
                        value += 1;
                        characterSheet.setWill(value);
                        currentAttributePoints = Integer.toString(characterSheet.getAttributePointsCurrent());
                        maximumAttributePoints = Integer.toString(characterSheet.getAttributePointsMaximum());
                        tfAttributePoints.setText(currentAttributePoints + " / " + maximumAttributePoints);
                        tfWillCost.setText(Integer.toString(attributeCost[value]));
                        tfWillValue.setText(Integer.toString(value));
                        tfWillDice.setText(attributeDice[value]);
                        tfToughnessDefense.setText(Integer.toString(characterSheet.getToughnessDefense()));
                        tfResolveDefense.setText(Integer.toString(characterSheet.getResolveDefense()));
                        tfHitPoints.setText(Integer.toString(characterSheet.getHitPoints()));
                        taDescription.setText(WILL_DESCRIPTION);
                    }
                }
            } else if (rbDeception.isSelected()) {
                value = characterSheet.getDeception();
                if (value == 5) {
                    taDescription.setText("You cannot raise an attribute above 5...");
                } else {
                    difference = (attributeCost[value + 1] - attributeCost[value]);
                    if (difference > characterSheet.getAttributePointsCurrent()) {
                        taDescription.setText("You do not have enough points to do that...");
                    } else {
                        value += 1;
                        characterSheet.setDeception(value);
                        currentAttributePoints = Integer.toString(characterSheet.getAttributePointsCurrent());
                        maximumAttributePoints = Integer.toString(characterSheet.getAttributePointsMaximum());
                        tfAttributePoints.setText(currentAttributePoints + " / " + maximumAttributePoints);
                        tfDeceptionCost.setText(Integer.toString(attributeCost[value]));
                        tfDeceptionValue.setText(Integer.toString(value));
                        tfDeceptionDice.setText(attributeDice[value]);
                        taDescription.setText(DECEPTION_DESCRIPTION);
                    }
                }
            } else if (rbPersuasion.isSelected()) {
                value = characterSheet.getPersuasion();
                if (value == 5) {
                    taDescription.setText("You cannot raise an attribute above 5...");
                } else {
                    difference = (attributeCost[value + 1] - attributeCost[value]);
                    if (difference > characterSheet.getAttributePointsCurrent()) {
                        taDescription.setText("You do not have enough points to do that...");
                    } else {
                        value += 1;
                        characterSheet.setPersuasion(value);
                        currentAttributePoints = Integer.toString(characterSheet.getAttributePointsCurrent());
                        maximumAttributePoints = Integer.toString(characterSheet.getAttributePointsMaximum());
                        tfAttributePoints.setText(currentAttributePoints + " / " + maximumAttributePoints);
                        tfPersuasionCost.setText(Integer.toString(attributeCost[value]));
                        tfPersuasionValue.setText(Integer.toString(value));
                        tfPersuasionDice.setText(attributeDice[value]);
                        taDescription.setText(PERSUASION_DESCRIPTION);
                    }
                }
            } else if (rbPresence.isSelected()) {
                value = characterSheet.getPresence();
                if (value == 5) {
                    taDescription.setText("You cannot raise an attribute above 5...");
                } else {
                    difference = (attributeCost[value + 1] - attributeCost[value]);
                    if (difference > characterSheet.getAttributePointsCurrent()) {
                        taDescription.setText("You do not have enough points to do that...");
                    } else {
                        value += 1;
                        characterSheet.setPresence(value);
                        currentAttributePoints = Integer.toString(characterSheet.getAttributePointsCurrent());
                        maximumAttributePoints = Integer.toString(characterSheet.getAttributePointsMaximum());
                        tfAttributePoints.setText(currentAttributePoints + " / " + maximumAttributePoints);
                        tfPresenceCost.setText(Integer.toString(attributeCost[value]));
                        tfPresenceValue.setText(Integer.toString(value));
                        tfPresenceDice.setText(attributeDice[value]);
                        tfResolveDefense.setText(Integer.toString(characterSheet.getResolveDefense()));
                        tfHitPoints.setText(Integer.toString(characterSheet.getHitPoints()));
                        taDescription.setText(PRESENCE_DESCRIPTION);
                    }
                }
            } else if (rbAlteration.isSelected()) {
                value = characterSheet.getAlteration();
                if (value == 5) {
                    taDescription.setText("You cannot raise an attribute above 5...");
                } else {
                    difference = (attributeCost[value + 1] - attributeCost[value]);
                    if (difference > characterSheet.getAttributePointsCurrent()) {
                        taDescription.setText("You do not have enough points to do that...");
                    } else {
                        value += 1;
                        characterSheet.setAlteration(value);
                        currentAttributePoints = Integer.toString(characterSheet.getAttributePointsCurrent());
                        maximumAttributePoints = Integer.toString(characterSheet.getAttributePointsMaximum());
                        tfAttributePoints.setText(currentAttributePoints + " / " + maximumAttributePoints);
                        tfAlterationCost.setText(Integer.toString(attributeCost[value]));
                        tfAlterationValue.setText(Integer.toString(value));
                        tfAlterationDice.setText(attributeDice[value]);
                        taDescription.setText(ALTERATION_DESCRIPTION);
                    }
                }
            } else if (rbCreation.isSelected()) {
                value = characterSheet.getCreation();
                if (value == 5) {
                    taDescription.setText("You cannot raise an attribute above 5...");
                } else {
                    difference = (attributeCost[value + 1] - attributeCost[value]);
                    if (difference > characterSheet.getAttributePointsCurrent()) {
                        taDescription.setText("You do not have enough points to do that...");
                    } else {
                        value += 1;
                        characterSheet.setCreation(value);
                        currentAttributePoints = Integer.toString(characterSheet.getAttributePointsCurrent());
                        maximumAttributePoints = Integer.toString(characterSheet.getAttributePointsMaximum());
                        tfAttributePoints.setText(currentAttributePoints + " / " + maximumAttributePoints);
                        tfCreationCost.setText(Integer.toString(attributeCost[value]));
                        tfCreationValue.setText(Integer.toString(value));
                        tfCreationDice.setText(attributeDice[value]);
                        taDescription.setText(CREATION_DESCRIPTION);
                    }
                }
            } else if (rbEnergy.isSelected()) {
                value = characterSheet.getEnergy();
                if (value == 5) {
                    taDescription.setText("You cannot raise an attribute above 5...");
                } else {
                    difference = (attributeCost[value + 1] - attributeCost[value]);
                    if (difference > characterSheet.getAttributePointsCurrent()) {
                        taDescription.setText("You do not have enough points to do that...");
                    } else {
                        value += 1;
                        characterSheet.setEnergy(value);
                        currentAttributePoints = Integer.toString(characterSheet.getAttributePointsCurrent());
                        maximumAttributePoints = Integer.toString(characterSheet.getAttributePointsMaximum());
                        tfAttributePoints.setText(currentAttributePoints + " / " + maximumAttributePoints);
                        tfEnergyCost.setText(Integer.toString(attributeCost[value]));
                        tfEnergyValue.setText(Integer.toString(value));
                        tfEnergyDice.setText(attributeDice[value]);
                        taDescription.setText(ENERGY_DESCRIPTION);
                    }
                }
            } else if (rbEntropy.isSelected()) {
                value = characterSheet.getEntropy();
                if (value == 5) {
                    taDescription.setText("You cannot raise an attribute above 5...");
                } else {
                    difference = (attributeCost[value + 1] - attributeCost[value]);
                    if (difference > characterSheet.getAttributePointsCurrent()) {
                        taDescription.setText("You do not have enough points to do that...");
                    } else {
                        value += 1;
                        characterSheet.setEntropy(value);
                        currentAttributePoints = Integer.toString(characterSheet.getAttributePointsCurrent());
                        maximumAttributePoints = Integer.toString(characterSheet.getAttributePointsMaximum());
                        tfAttributePoints.setText(currentAttributePoints + " / " + maximumAttributePoints);
                        tfEntropyCost.setText(Integer.toString(attributeCost[value]));
                        tfEntropyValue.setText(Integer.toString(value));
                        tfEntropyDice.setText(attributeDice[value]);
                        taDescription.setText(ENTROPY_DESCRIPTION);
                    }
                }
            } else if (rbInfluence.isSelected()) {
                value = characterSheet.getInfluence();
                if (value == 5) {
                    taDescription.setText("You cannot raise an attribute above 5...");
                } else {
                    difference = (attributeCost[value + 1] - attributeCost[value]);
                    if (difference > characterSheet.getAttributePointsCurrent()) {
                        taDescription.setText("You do not have enough points to do that...");
                    } else {
                        value += 1;
                        characterSheet.setInfluence(value);
                        currentAttributePoints = Integer.toString(characterSheet.getAttributePointsCurrent());
                        maximumAttributePoints = Integer.toString(characterSheet.getAttributePointsMaximum());
                        tfAttributePoints.setText(currentAttributePoints + " / " + maximumAttributePoints);
                        tfInfluenceCost.setText(Integer.toString(attributeCost[value]));
                        tfInfluenceValue.setText(Integer.toString(value));
                        tfInfluenceDice.setText(attributeDice[value]);
                        taDescription.setText(INFLUENCE_DESCRIPTION);
                    }
                }
            } else if (rbMovement.isSelected()) {
                value = characterSheet.getMovement();
                if (value == 5) {
                    taDescription.setText("You cannot raise an attribute above 5...");
                } else {
                    difference = (attributeCost[value + 1] - attributeCost[value]);
                    if (difference > characterSheet.getAttributePointsCurrent()) {
                        taDescription.setText("You do not have enough points to do that...");
                    } else {
                        value += 1;
                        characterSheet.setMovement(value);
                        currentAttributePoints = Integer.toString(characterSheet.getAttributePointsCurrent());
                        maximumAttributePoints = Integer.toString(characterSheet.getAttributePointsMaximum());
                        tfAttributePoints.setText(currentAttributePoints + " / " + maximumAttributePoints);
                        tfMovementCost.setText(Integer.toString(attributeCost[value]));
                        tfMovementValue.setText(Integer.toString(value));
                        tfMovementDice.setText(attributeDice[value]);
                        taDescription.setText(MOVEMENT_DESCRIPTION);
                    }
                }
            } else if (rbPrescience.isSelected()) {
                value = characterSheet.getPrescience();
                if (value == 5) {
                    taDescription.setText("You cannot raise an attribute above 5...");
                } else {
                    difference = (attributeCost[value + 1] - attributeCost[value]);
                    if (difference > characterSheet.getAttributePointsCurrent()) {
                        taDescription.setText("You do not have enough points to do that...");
                    } else {
                        value += 1;
                        characterSheet.setPrescience(value);
                        currentAttributePoints = Integer.toString(characterSheet.getAttributePointsCurrent());
                        maximumAttributePoints = Integer.toString(characterSheet.getAttributePointsMaximum());
                        tfAttributePoints.setText(currentAttributePoints + " / " + maximumAttributePoints);
                        tfPrescienceCost.setText(Integer.toString(attributeCost[value]));
                        tfPrescienceValue.setText(Integer.toString(value));
                        tfPrescienceDice.setText(attributeDice[value]);
                        taDescription.setText(PRESCIENCE_DESCRIPTION);
                    }
                }
            } else if (rbProtection.isSelected()) {
                value = characterSheet.getProtection();
                if (value == 5) {
                    taDescription.setText("You cannot raise an attribute above 5...");
                } else {
                    difference = (attributeCost[value + 1] - attributeCost[value]);
                    if (difference > characterSheet.getAttributePointsCurrent()) {
                        taDescription.setText("You do not have enough points to do that...");
                    } else {
                        value += 1;
                        characterSheet.setProtection(value);
                        currentAttributePoints = Integer.toString(characterSheet.getAttributePointsCurrent());
                        maximumAttributePoints = Integer.toString(characterSheet.getAttributePointsMaximum());
                        tfAttributePoints.setText(currentAttributePoints + " / " + maximumAttributePoints);
                        tfProtectionCost.setText(Integer.toString(attributeCost[value]));
                        tfProtectionValue.setText(Integer.toString(value));
                        tfProtectionDice.setText(attributeDice[value]);
                        taDescription.setText(PROTECTION_DESCRIPTION);
                    }
                }
            }
        });

        // Create a scene and place it in the stage
        Scene scene = new Scene(pane, sceneWidth, sceneHeight);
        primaryStage.setTitle("OpenLegendCharacterEditor");
        primaryStage.setScene(scene);
        primaryStage.show();
    }   // end start

    public class CharacterSheet {

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
        private int attributePointsCurrent = 40;
        private int toughnessDefense = 10;
        private int guardDefense = 10;
        private int resolveDefense = 10;
        private int hitPoints = 10;
        private int speed = 30;

        // default constructor
        public CharacterSheet() {

        }   // end default constructor

        // return characterName
        public String getCharacterName() {
            return characterName;
        }	// end getCharacterName

        // set characterName
        public void setCharacterName(String name) {
            this.characterName = name;
        }   // end setCharacterName

        // return playerName
        public String getPlayerName() {
            return playerName;
        }   // end getPlayerName

        // set playerName
        public void setPlayerName(String name) {
            this.playerName = name;
        }   // end setPlayerName

        // get characterBio
        public String getCharacterBio() {
            return characterBio;
        }   // end getCharacterBio

        // set characterBio
        public void setCharacterBio(String bio) {
            this.characterBio = bio;
        }   // end setCharacterBio

        // get characterImage
        public String getCharacterImage() {
            return characterImage;
        }   // end getCharacterImage

        // set characterImage
        public void setCharacterImage(String imageAddress) {
            /* * * verify address is image * * */
            this.characterImage = imageAddress;
        }   // end setCharacterImage

        // get agility
        public int getAgility() {
            return agility;
        }   // end getAgility

        // set agility
        public void setAgility(int value) {
            int valueCost = value * (value + 1) / 2;
            int agilityCost = this.agility * (this.agility + 1) / 2;
            int difference = valueCost - agilityCost;

            if ((value >= 0) && (value <= 5) && (difference <= this.attributePointsCurrent)) {
                this.agility = value;
                this.guardDefense = 10 + agility + might;
                this.attributePointsCurrent -= difference;
            }	// end if
        }   // end setAgility

        // get fortitude
        public int getFortitude() {
            return fortitude;
        }   // end getFortitude

        // set fortitude
        public void setFortitude(int value) {
            int valueCost = value * (value + 1) / 2;
            int fortitudeCost = this.fortitude * (this.fortitude + 1) / 2;
            int difference = valueCost - fortitudeCost;

            if ((value >= 0) && (value <= 5) && (difference <= this.attributePointsCurrent)) {
                this.fortitude = value;
                this.toughnessDefense = 10 + fortitude + will;
                this.hitPoints = 10 + 2 * (fortitude + presence + will);
                this.attributePointsCurrent -= difference;
            }	// end if
        }   // end setFortitude

        // get might
        public int getMight() {
            return might;
        }	// end getMight

        // set might
        public void setMight(int value) {
            int valueCost = value * (value + 1) / 2;
            int mightCost = this.might * (this.might + 1) / 2;
            int difference = valueCost - mightCost;

            if ((value >= 0) && (value <= 5) && (difference <= this.attributePointsCurrent)) {
                this.might = value;
                this.guardDefense = 10 + agility + might;
                this.attributePointsCurrent -= difference;
            }	// end if
        }   // end setMight

        // get learning
        public int getLearning() {
            return learning;
        }   // end getLearning

        // set learning
        public void setLearning(int value) {
            int valueCost = value * (value + 1) / 2;
            int learningCost = this.learning * (this.learning + 1) / 2;
            int difference = valueCost - learningCost;

            if ((value >= 0) && (value <= 5) && (difference <= this.attributePointsCurrent)) {
                this.learning = value;
                this.attributePointsCurrent -= difference;
            }	// end if
        }   // end setLearning

        // get logic
        public int getLogic() {
            return logic;
        }   // end getLogic

        // set logic
        public void setLogic(int value) {
            int valueCost = value * (value + 1) / 2;
            int logicCost = this.logic * (this.logic + 1) / 2;
            int difference = valueCost - logicCost;

            if ((value >= 0) && (value <= 5) && (difference <= this.attributePointsCurrent)) {
                this.logic = value;
                this.attributePointsCurrent -= difference;
            }	// end if
        }   // end setLogic

        // get perception
        public int getPerception() {
            return perception;
        }   // end getPerception

        // set perception
        public void setPerception(int value) {
            int valueCost = value * (value + 1) / 2;
            int perceptionCost = this.perception * (this.perception + 1) / 2;
            int difference = valueCost - perceptionCost;

            if ((value >= 0) && (value <= 5) && (difference <= this.attributePointsCurrent)) {
                this.perception = value;
                this.attributePointsCurrent -= difference;
            }	// end if
        }   // end setPerception

        // get will
        public int getWill() {
            return will;
        }   // end getWill

        // set will
        public void setWill(int value) {
            int valueCost = value * (value + 1) / 2;
            int willCost = this.will * (this.will + 1) / 2;
            int difference = valueCost - willCost;

            if ((value >= 0) && (value <= 5) && (difference <= this.attributePointsCurrent)) {
                this.will = value;
                this.toughnessDefense = 10 + fortitude + will;
                this.resolveDefense = 10 + presence + will;
                this.hitPoints = 10 + 2 * (fortitude + presence + will);
                this.attributePointsCurrent -= difference;
            }	// end if
        }   // end setWill

        // get deception
        public int getDeception() {
            return deception;
        }   // end getDeception

        // set deception
        public void setDeception(int value) {
            int valueCost = value * (value + 1) / 2;
            int deceptionCost = this.deception * (this.deception + 1) / 2;
            int difference = valueCost - deceptionCost;

            if ((value >= 0) && (value <= 5) && (difference <= this.attributePointsCurrent)) {
                this.deception = value;
                this.attributePointsCurrent -= difference;
            }	// end if
        }   // end setDeception

        // get persuasion
        public int getPersuasion() {
            return persuasion;
        }   // end getPersuasion

        // set persuasion
        public void setPersuasion(int value) {
            int valueCost = value * (value + 1) / 2;
            int persuasionCost = this.persuasion * (this.persuasion + 1) / 2;
            int difference = valueCost - persuasionCost;

            if ((value >= 0) && (value <= 5) && (difference <= this.attributePointsCurrent)) {
                this.persuasion = value;
                this.attributePointsCurrent -= difference;
            }	// end if
        }   // end setPersuasion

        // get presence
        public int getPresence() {
            return presence;
        }   // end getPresence

        // set presence
        public void setPresence(int value) {
            int valueCost = value * (value + 1) / 2;
            int presenceCost = this.presence * (this.presence + 1) / 2;
            int difference = valueCost - presenceCost;

            if ((value >= 0) && (value <= 5) && (difference <= this.attributePointsCurrent)) {
                this.presence = value;
                this.resolveDefense = 10 + presence + will;
                this.hitPoints = 10 + 2 * (fortitude + presence + will);
                this.attributePointsCurrent -= difference;
            }	// end if
        }   // end setPresence

        // get alteration
        public int getAlteration() {
            return alteration;
        }   // end getAlteration

        // set alteration
        public void setAlteration(int value) {
            int valueCost = value * (value + 1) / 2;
            int alterationCost = this.alteration * (this.alteration + 1) / 2;
            int difference = valueCost - alterationCost;

            if ((value >= 0) && (value <= 5) && (difference <= this.attributePointsCurrent)) {
                this.alteration = value;
                this.attributePointsCurrent -= difference;
            }	// end if
        }   // end setAlteration

        // get creation
        public int getCreation() {
            return creation;
        }   // end getCreation

        // set creation
        public void setCreation(int value) {
            int valueCost = value * (value + 1) / 2;
            int creationCost = this.creation * (this.creation + 1) / 2;
            int difference = valueCost - creationCost;

            if ((value >= 0) && (value <= 5) && (difference <= this.attributePointsCurrent)) {
                this.creation = value;
                this.attributePointsCurrent -= difference;
            }	// end if
        }   // end setCreation

        // get energy
        public int getEnergy() {
            return energy;
        }   // end getEnergy

        // set energy
        public void setEnergy(int value) {
            int valueCost = value * (value + 1) / 2;
            int energyCost = this.energy * (this.energy + 1) / 2;
            int difference = valueCost - energyCost;

            if ((value >= 0) && (value <= 5) && (difference <= this.attributePointsCurrent)) {
                this.energy = value;
                this.attributePointsCurrent -= difference;
            }	// end if
        }   // end setEnergy

        // get entropy
        public int getEntropy() {
            return entropy;
        }   // end getEntropy

        // set entropy
        public void setEntropy(int value) {
            int valueCost = value * (value + 1) / 2;
            int entropyCost = this.entropy * (this.entropy + 1) / 2;
            int difference = valueCost - entropyCost;

            if ((value >= 0) && (value <= 5) && (difference <= this.attributePointsCurrent)) {
                this.entropy = value;
                this.attributePointsCurrent -= difference;
            }	// end if
        }   // end setEntropy

        // get influence
        public int getInfluence() {
            return influence;
        }   // end getInfluence

        // set influence
        public void setInfluence(int value) {
            int valueCost = value * (value + 1) / 2;
            int influenceCost = this.influence * (this.influence + 1) / 2;
            int difference = valueCost - influenceCost;

            if ((value >= 0) && (value <= 5) && (difference <= this.attributePointsCurrent)) {
                this.influence = value;
                this.attributePointsCurrent -= difference;
            }	// end if
        }   // end setInfluence

        // get movement
        public int getMovement() {
            return movement;
        }   // end getMovement

        // set movement
        public void setMovement(int value) {
            int valueCost = value * (value + 1) / 2;
            int movementCost = this.movement * (this.movement + 1) / 2;
            int difference = valueCost - movementCost;

            if ((value >= 0) && (value <= 5) && (difference <= this.attributePointsCurrent)) {
                this.movement = value;
                this.attributePointsCurrent -= difference;
            }	// end if
        }   // end setMovement

        // get prescience
        public int getPrescience() {
            return prescience;
        }   // end getPrescience

        // set prescience
        public void setPrescience(int value) {
            int valueCost = value * (value + 1) / 2;
            int prescienceCost = this.prescience * (this.prescience + 1) / 2;
            int difference = valueCost - prescienceCost;

            if ((value >= 0) && (value <= 5) && (difference <= this.attributePointsCurrent)) {
                this.prescience = value;
                this.attributePointsCurrent -= difference;
            }	// end if
        }   // end setPrescience

        // get Protection
        public int getProtection() {
            return protection;
        }   // end getProtection

        // set Protection
        public void setProtection(int value) {
            int valueCost = value * (value + 1) / 2;
            int protectionCost = this.protection * (this.protection + 1) / 2;
            int difference = valueCost - protectionCost;

            if ((value >= 0) && (value <= 5) && (difference <= this.attributePointsCurrent)) {
                this.protection = value;
                this.attributePointsCurrent -= difference;
            }	// end if
        }   // end setProtection

        // get attributePointsCurrent
        public int getAttributePointsCurrent() {
            return attributePointsCurrent;
        }	// end getAttributePointsCurrent;

        // get attributePointsMaximum
        public int getAttributePointsMaximum() {
            return attributePointsMaximum;
        }	// end getAttributePointsMaximum
        
        /*
        toughnessDefense = 10 + Fortitude + Will
        guardDefense = 10 + Might + Agility + Armor
        resolveDefense = 10 + Presence + Will
        hitPoints = 10 + 2*Fortitude + 2*Presence + 2*Will
        speed = 30'
        */
        
        // get toughnessDefense
        public int getToughnessDefense() {
            this.toughnessDefense = 10 + fortitude + will;
            return toughnessDefense;
        }   // end getToughnessDefense
        
        // get guardDefense
        public int getGuardDefense() {
            this.guardDefense = 10 + agility + might;
            return guardDefense;
        }   // end getGuardDefense
        
        // get resolveDefense
        public int getResolveDefense() {
            this.resolveDefense = 10 + presence + will;
            return resolveDefense;
        }   // end getResolveDefense
        
        // get hitPoints
        public int getHitPoints() {
            this.hitPoints = 10 + 2 * (fortitude + presence + will);
            return hitPoints;
        }   // end getHitPoints
        
        // get speed
        public int getSpeed() {
            return speed;
        }   // end getSpeed
        
    }	// end characterSheet class

    public static void main(String[] args) {
        launch(args);
    }	// end main	

}	// end OpenLegendCharacterEditor
