package piyush.project.parser;

/**
 * Created by devil jin on 5/23/2017.
 */
public class StringToNumberConverter implements IStringToNumberConverter {

    @Override
    public Number[] convertToNumber(String[] stringArray) {

        Number[] numberArray = new Number[stringArray.length];

        for(int i=0; i< stringArray.length;i++) {
            numberArray[i] = Integer.valueOf(stringArray[i]);
        }

        return numberArray;
    }
}
