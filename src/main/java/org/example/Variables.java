package org.example;
import java.util.ArrayList;

public class Variables {//co do rozmiarów lasu - potrzeba testów czy na pewno sie nie wywala, i przy jakim najwikszym rozmiarze są sensowne czasy realizacji symulacji
    public static int FOREST_WIDTH = 10; // Szerokość lasu
    public static int FOREST_HEIGHT = 5; // Wysokość lasu
    public static final int MUSHROOMS = 10;//liczba grzybkow to jest
    public static final double PERCENT_OF_TOXIC = 100;
    public static final double PERCENT_OF_HALLUCINATION = 0;
    public static final int beginnerPickers = 5;
    public static final int intermediatePickers = 0;
    public static final int advancedPickers = 0;
    public static int NONTOXIC_MUSH = MUSHROOMS*(100-(int)PERCENT_OF_HALLUCINATION-(int) PERCENT_OF_TOXIC)/100;//liczba zdrowych grzybow
    public static int TOXIC_MUSH = Variables.MUSHROOMS*(int)Variables.PERCENT_OF_TOXIC/100;//liczba grzybow toxic
    public static int HALLUCIN_MUSH = Variables.MUSHROOMS*(int)Variables.PERCENT_OF_HALLUCINATION/100;//liczba grzybow hallucynogennych
    public static ArrayList<ArrayList<String>> BOARD = new ArrayList<ArrayList<String>>();//tutaj przechowyway jest las z wszystkimi polami
    public static ArrayList<Beginner_mushroom_picker> beginnersList = new ArrayList<>();//przechowuje beginnerów
    public static ArrayList<Intermediate_mushroom_picker> intermediateList = new ArrayList<>();//przechowuje intermediateów
    public static ArrayList<Advanced_mushroom_picker> advancedList = new ArrayList<>();//przechowuje advancedow
    public static ArrayList<Nontoxic_mushroom> nontoxicMushroomList = new ArrayList<>();//przechowuje grzyby nontoxic
    public static ArrayList<Toxic_mushroom>  toxicMushroomList= new ArrayList<>();//przechowuje grzyby trujace
    public static ArrayList<Hallucination_mushroom> hallucinationMushroomList = new ArrayList<>();//przechowuje grzyby hallucination

}
