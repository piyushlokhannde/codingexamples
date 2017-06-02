package piyush.project.parser;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by devil jin on 5/18/2017.
 */
public class StringParser implements IStringParser {

    private String defaultDelimiter = ",|\n";

    @Override
    public String[] parseString(String input) {

        String  delimiter = defaultDelimiter;
        if(input.trim().startsWith("//")) {
           Pattern pattern = Pattern.compile("(//)(.*?)(\n)");
           Matcher matcher = pattern.matcher(input.trim());
           if(matcher.find()) {
               delimiter =  matcher.group(2);
              input= input.substring(matcher.end(), input.length());
               delimiter = this.createDelimiterWithQuote(delimiter);
           }
       }

      String[] stringNumArray =  input.trim().split(delimiter);
        return  stringNumArray;
    }

    private String createDelimiterWithQuote(String delimiterString) {
        Pattern pattern = Pattern.compile("(\\[(.*?)\\])");
        Matcher matcher = pattern.matcher(delimiterString.trim());
        String tempString = null;

        while(matcher.find()) {
            if(tempString != null ) {
                tempString += "|"+ Pattern.quote(matcher.group(2));
            } else  {
                tempString = Pattern.quote(matcher.group(2));
            }

        }
        if(tempString != null) {
            delimiterString = tempString;
        } else {
            delimiterString = Pattern.quote(delimiterString);
        }

        return delimiterString;
    }
}
