package orgjson;

import org.json.*;
import java.io.*;

class Driver
{
    public static void main(String[] args)
    {
        try
        {
            FileReader file = new FileReader("src/main/resources/input1.json");
            JSONTokener token = new JSONTokener(file);
            JSONObject jsonObj = new JSONObject(token);
            JSONArray knownForsJSON = jsonObj.getJSONArray("knownFor");
            JSONArray awardsJSON = jsonObj.getJSONArray("awards");
            String personName = jsonObj.getString("name");
            String[] knownFors = new String[knownForsJSON.length()];
            Award[] awards = new Award[awardsJSON.length()];

//            fills Award array
            for (int i = 0; i < awards.length; i++)
            {
                awards[i] = new Award(awardsJSON.getJSONObject(i).getString("name"), awardsJSON.getJSONObject(i).getInt("year"));
            }
//            fills KnownFor array
            for (int i = 0; i < knownFors.length; i++)
            {
                knownFors[i] = knownForsJSON.getString(i);
            }

            Person p = new Person(personName, knownFors, awards);

            StringBuilder sb = new StringBuilder();
//            fill string builder in reverse order
            for (Award a: p.getAwards())
            {
                sb.insert(0, a.getYear());
                sb.insert(0, ", ");
                sb.insert(0, a.getName());
                sb.insert(0, "\n");
            }
            sb.insert(0, "\n\nAwards:");
            for (String s: p.getKnownFor())
            {
                sb.insert(0, s);
                sb.insert(0, "\n");
            }
            sb.insert(0, "\n\nKnown For:");

            sb.insert(0, p.getName());
            System.out.println(sb);
        }
        catch (FileNotFoundException e)
        {
            System.out.println("File not found");
        }
    }
}
