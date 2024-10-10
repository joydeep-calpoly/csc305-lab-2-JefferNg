package jackson;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.io.File;

class JacksonDriver
{
    public static void main(String[] args)
    {
        ObjectMapper mapper = new ObjectMapper();
        try
        {
            File file = new File("src/main/resources/input1.json");
            JSONValue jsonValue = mapper.readValue(file, JSONValue.class);
            System.out.println(jsonValue.getName());
            System.out.println("\nKnown For: ");
            for (String s: jsonValue.getKnownFor())
            {
                System.out.println(s);
            }
            System.out.println("\nAwards: ");
            for (JSONValue.Award a: jsonValue.getAwards())
            {
                System.out.print(a.getName());
                System.out.println(", " + a.getYear());
            }

        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }
}
