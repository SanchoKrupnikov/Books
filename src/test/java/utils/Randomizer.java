package utils;

import java.util.Random;

public class Randomizer {

    private final static String LAT_SCHEME = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
    private final static Integer StringLenght = 10;

    private static String getRandomString(Integer StringLenght, String schemeName) {

        StringBuilder stringBuilder = new StringBuilder();
        Random rnd = new Random();
        while (stringBuilder.length() < StringLenght) {
            int index = (int) (rnd.nextFloat() * schemeName.length());
            stringBuilder.append(schemeName.charAt(index));
        }
        return stringBuilder.toString();
    }

    public static String getLat(int stringLenght) {
        return getRandomString(stringLenght, LAT_SCHEME);
    }

    public static int getRandomNumber (){
        int randNumb = (int) (Math.random()*20);
        System.out.println("Random number: " + randNumb);
        return randNumb;
    }


}
