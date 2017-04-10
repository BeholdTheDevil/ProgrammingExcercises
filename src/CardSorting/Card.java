package CardSorting;

/**
 * Created by anton on 2017-04-03.
 */
public class Card {

    int color;
    int value;
    String name;

    Card(int color_, int value_) {
        if((color_ >= 0 && color_ <= 3) && (value_ >= 0 && value_ <= 12)) {
            color = color_;
            value = value_;
        } else {
            throw new IllegalArgumentException("Invalid card color or value (0-3 and 0-12)");
        }

        name = cardToString();
    }

    String cardToString() {
        String[] types = {"Ace", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine", "Ten", "Jack", "Queen", "King"};
        String temp = types[value];

        if(color == 0) {
            temp += " of Hearts";
        } else if(color == 1) {
            temp += " of Diamonds";
        } else if(color == 2) {
            temp += " of Spades";
        } else if(color == 3) {
            temp += " of Clubs";
        }
        return temp;
    }
}