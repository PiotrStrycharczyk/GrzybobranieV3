package org.example;

public class BeginnerMushroomPicker extends MushroomPicker {


    public BeginnerMushroomPicker(int score, int positionX, int positionY) {
        super(score, positionX, positionY);//za pomocą słowa kluczowego super inicjalizujemy pola z klasy bazowej
    }


    public static void change_position_after_random_walk(int x, int y, int randomX, int randomY){
        for (int i = 0; i < Variables.beginnersList.size(); i++) {//sprawdzamy, który z tych begginerów ma taką pozycję i zmieniamy mu ją
            if (Variables.beginnersList.get(i).positionX == x && Variables.beginnersList.get(i).positionY == y) {
                Variables.beginnersList.get(i).positionX = randomX;
                Variables.beginnersList.get(i).positionY = randomY;
                break;//wychodzimy bo już znaleźliśmy
            }
        }
    }

    public static void interactionWithToxic(int x, int y, int aroundX, int aroundY, int indexOfBeginner){
        for(int k = 0 ; k < Variables.toxicMushroomList.size() ; k++){//skanujemy po całej liście grzybow toxic i czekamy aż pętla natrafi na takowego
            if(Variables.toxicMushroomList.get(k).positionX == aroundX && Variables.toxicMushroomList.get(k).positionY == aroundY){
                Variables.board.get(aroundX).set(aroundY, "X");//ustawienie na planszy, że grzyb toxic jest zjedzony
                Variables.board.get(x).set(y, "X");//ustawienie na planszy, że beginner zginął
                Variables.toxicMushroomList.remove(k);//usunięcie grzyba toxic z arraylisty bo został zjedzony
                Variables.toxicMush--;
                Variables.beginnersList.remove(indexOfBeginner);//usunięcie beginnera z listy bo zginął
                Variables.dead++;//zliczanie umarłych
                break;
            }
        }
    }

    public static void checkTheKind(int x, int y, int indexOfBeginner){
        int aroundX = 0;//tutaj mamy pozycje x wokół postaci
        int aroundY = 0;
        outerLoop:
        for(int i = -1 ;i<=1;i++){
            for (int j = -1; j<=1 ; j++){
                aroundX = x + i;//tutaj mamy pozycję x wokół postaci
                aroundY = y + j;//tutaj mamy pozycję y wokół postaci
                if (aroundX >= 0 && aroundY >= 0 && aroundX < Variables.forestHeight && aroundY < Variables.forestWidth){
                    if(Variables.board.get(aroundX).get(aroundY).equals("H")){
                        //DZIEDZICZENIE
                        interactionWithNontoxic(aroundX, aroundY);//check if nontoxic jest dziedziczone po mushroompickers
                        break outerLoop;
                    }
                    else if(Variables.board.get(aroundX).get(aroundY).equals("P")) {//P to są toxic grzyby
                        interactionWithToxic(x, y, aroundX, aroundY, indexOfBeginner);
                        break outerLoop;
                    }

                }
            }
        }
    }

}

