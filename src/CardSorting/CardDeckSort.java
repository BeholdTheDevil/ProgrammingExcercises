package CardSorting;

import Datastructures.CustomLists.CustomArrayList;

import java.math.BigInteger;

/**
 * Created by anton on 2017-03-30.
 */
public class CardDeckSort {

    static Card[] deck;
    final static int COLOR = -50;
    final static int VALUE = -51;
    static long nano;
    static int tests = 100000;

    public static void main(String[] args) {
        //testBubbleSort(COLOR);
        //testBinaryTree(COLOR);
        //testBubbleSort(VALUE);
        testSelectionSort(VALUE);
        //testMergeSort(VALUE);
        //testInsertionSort();
    }


    /*private static void testInsertionSort() {
        CustomArrayList<long[]> insertionSortTestResults = new CustomArrayList<>();
        for(int i = 0; i < tests; i++) {
            createRandomDeck();
            nano = System.nanoTime();
            insertionSortTestResults.add(insertionSort());
        }

        averageResults(insertionSortTestResults, COLOR);
    }

    private static long[] insertionSort() {

    }*/


    private static void testBubbleSort(int sortBy) {
        CustomArrayList<long[]> bubbleSortTestResults = new CustomArrayList<>();
        for(int i = 0; i < tests; i++) {
            createRandomDeck();
            nano = System.nanoTime();
            bubbleSortTestResults.add(bubbleSort(sortBy));
        }

        averageResults(bubbleSortTestResults, sortBy);
    }

    private static long[] bubbleSort(int sortBy) {
        Card[] sortedDeck = new Card[deck.length];
        System.arraycopy(deck, 0, sortedDeck, 0, deck.length);

        long comparisons = 0;

        for(int i = 0; i < sortedDeck.length; i++) {
            int a = i;
            if(sortBy == COLOR) {
                while(a-1 >= 0 && sortedDeck[a].color < sortedDeck[a-1].color) {
                    comparisons++;
                    swap(sortedDeck, a, a-1);
                    a -= 1;
                }
                while(a-1 >= 0 && sortedDeck[a].color == sortedDeck[a-1].color && sortedDeck[a].value < sortedDeck[a-1].value) {
                    comparisons++;
                    swap(sortedDeck, a, a-1);
                    a -= 1;
                }
            } else if(sortBy == VALUE) {
                while(a-1 >= 0 && sortedDeck[a].color < sortedDeck[a-1].color) {
                    comparisons++;
                    swap(sortedDeck, a, a-1);
                    a -= 1;
                }
                while(a-1 >= 0 && sortedDeck[a].value < sortedDeck[a-1].value) {
                    comparisons++;
                    swap(sortedDeck, a, a-1);
                    a -= 1;
                }
            }
        }
        return new long[]{System.nanoTime() - nano, comparisons};
    }

    private static void swap(Card[] sortedDeck, int a, int b) {
        Card temp = sortedDeck[a];
        sortedDeck[a] = sortedDeck[b];
        sortedDeck[b] = temp;
    }



    private static void testSelectionSort(int sortBy) {
        CustomArrayList<long[]> selectionSortTestResults = new CustomArrayList<>();
        for(int i = 0; i < tests; i++) {
            createRandomDeck();
            nano = System.nanoTime();
            selectionSortTestResults.add(selectionSort(sortBy));
        }

        averageResults(selectionSortTestResults, sortBy);
    }

    private static long[] selectionSort(int sortBy) {
        Card[] sortedDeck = new Card[deck.length];

        for(int i = 0; i < deck.length; i++) {
            if(deck[i].value == 0 && deck[i].color == 0) {
                //swap(deck, 0, i);
                sortedDeck[0] = deck[i];
            }
        }

        Card currentLowest = sortedDeck[0];

        long comparisons = 0;
        boolean change;

        for(int i = 1; i < deck.length; i++) {
            change = true;
            for(Card c : deck) {
                comparisons++;
                if(((sortBy == COLOR && sortByColor(currentLowest, c)) || (sortBy == VALUE && sortByValue(currentLowest, c))) && change) {
                    currentLowest = c;
                    //change = false;
                    //break;
                }
            }
            sortedDeck[i] = currentLowest;
        }
        long newNano = System.nanoTime();
        //printDeck(deck, sortBy);
        return new long[]{newNano - nano, comparisons};
    }



    private static void testBinaryTree(int sortBy) {
        CustomArrayList<long[]> binaryTreeTestResults = new CustomArrayList<>();
        for(int i = 0; i < tests; i++) {
            createRandomDeck();
            nano = System.nanoTime();
            binaryTreeTestResults.add(binaryTreeInsertion(sortBy));
        }
    }

    private static long[] binaryTreeInsertion(int sortBy) {
        Tree tree = new Tree(sortBy);

        for(Card c : deck) {
            tree.add(c);
        }

        long newNano = System.nanoTime();
        tree.list();
        return new long[]{newNano - nano, 0};
    }



    private static void testMergeSort(int sortBy) {
        CustomArrayList<long[]> mergeSortTestResult = new CustomArrayList<>();
        for(int i = 0; i < tests; i++) {
            createRandomDeck();
            nano = System.nanoTime();
            mergeSortTestResult.add(mergeSort(sortBy));
        }
    }

    private static long[] mergeSort(int sortBy) {
        Card[] mergedDeck = sort(deck);
        printDeck(mergedDeck, sortBy);
        return new long[]{0, 0};
    }

    private static Card[] sort(Card[] mergeDeck) {
        if(mergeDeck.length > 2) {
            int newLength = mergeDeck.length/2;
            Card[] a = new Card[newLength];
            Card[] b = new Card[mergeDeck.length-newLength];

            for(int i = 0; i < newLength; i++) {
                a[i] = mergeDeck[i];
            }
            for(int j = 0; j < mergeDeck.length-newLength; j++) {
                b[j] = mergeDeck[j+newLength];
            }

            a = sort(a);
            b = sort(b);

            if(a[newLength-1].value < b[0].value) {
                for(int i = 0; i < mergeDeck.length; i++) {
                    if(i < newLength) mergeDeck[i] = a[i];
                    else mergeDeck[i] = b[i-newLength];
                }
            } else {
                for(int i = 0; i < mergeDeck.length; i++) {
                    if(i < mergeDeck.length - newLength) mergeDeck[i] = b[i];
                    else mergeDeck[i] = a[i-b.length];
                }
            }

            sortDeck(mergeDeck);
            return mergeDeck;
        } else {
            sortDeck(mergeDeck);
            return mergeDeck;
        }
    }

    private static void sortDeck(Card[] mergeDeck) {
        for(int i = 0; i < mergeDeck.length; i++) {
            for(int j = 0; j < mergeDeck.length; j++) {
                if(mergeDeck[j].value < mergeDeck[i].value || (mergeDeck[j].value == mergeDeck[i].value && mergeDeck[j].color < mergeDeck[i].color)) {
                    swap(mergeDeck, i, j);
                }
            }
        }
    }


    private static boolean sortByColor(Card lowest, Card toCompare) {
        if(lowest != null && toCompare != null) {
            if(lowest.value < 12) {
                if(toCompare.color == lowest.color && toCompare.value < lowest.value) return true;
            } else {
                if(toCompare.color < lowest.color && toCompare.value == 0) return true;
            }
        }
        return false;
    }

    private static boolean sortByValue(Card lowest, Card toCompare) {
        if(lowest.color < 3) {
            if(toCompare.value == lowest.value && toCompare.color < lowest.color) {
                return true;
            }
        } else {
            if(toCompare.value < lowest.value && toCompare.color == 0) {
                return true;
            }
        }
        return false;
    }



    private static void createRandomDeck() {
        deck = new Card[52];
        CustomArrayList<Card> cards = new CustomArrayList<>();

        for(int i = 0; i < 13; i++) {
            for(int j = 0; j < 4; j++) {
                cards.add(new Card(j, i));
            }
        }

        for(int i = 0; i < deck.length; i++) {
            Card c;
            int randomIndex;
            do {
                randomIndex = (int)Math.floor(Math.random()*52);
                c = cards.get(randomIndex);
            } while(c == null);
            deck[i] = c;
            cards.set(randomIndex, null);
        }
    }

    private static void averageResults(CustomArrayList<long[]> selectionSortTestResults, int sortBy) {
        long averageComparisons = 0;
        BigInteger averageTime = BigInteger.ZERO;
        long[] current;
        for(int i = 0; i < selectionSortTestResults.size(); i++) {
            current = selectionSortTestResults.get(i);
            averageTime = averageTime.add(BigInteger.valueOf(current[0]));
            averageComparisons += current[1];
        }

        BigInteger[] divideAndRemainder = averageTime.divideAndRemainder(BigInteger.valueOf(selectionSortTestResults.size() * 1000L));
        String remainder = divideAndRemainder[1].toString();
        while (remainder.length() < 3) {
            remainder = "0" + remainder;
        }
        System.out.println("Testresults for " + selectionSortTestResults.size() + " tests with decksize " + deck.length + " sorted by " + (sortBy == -50 ? " color" : " value"));
        System.out.println("Average time: " + divideAndRemainder[0] + "." + remainder + "μs");
        System.out.println("Average number of comparisons: " + averageComparisons/selectionSortTestResults.size());
    }

    private static void printDeck(Card[] deckToPrint, int sortBy) {
        for(int i = 1; i < deckToPrint.length+1; i++) {
            if(deckToPrint[i-1] != null) {
                System.out.print(deckToPrint[i-1].name);
                if(sortBy == COLOR && i % 13 == 0) {
                    System.out.print("\n");
                } else if(sortBy == VALUE && i % 4 == 0) {
                    System.out.print("\n");
                } else if(sortBy == 0 && i % 6 == 0) {
                    System.out.print("\n");
                } else {
                    System.out.print(" -> ");
                }
            }
        }
        System.out.println("\n");
    }
}
