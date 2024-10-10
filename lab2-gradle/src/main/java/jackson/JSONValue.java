package jackson;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

class JSONValue
{
    private final String name;
    private final List<String> knownFor;
    private final List<Award> awards;

    @JsonCreator
    private JSONValue(@JsonProperty("name") String name, @JsonProperty("knownFor") List<String> knownFor, @JsonProperty("awards") List<Award> awards)
    {
        this.name = name;
        this.knownFor = knownFor;
        this.awards = awards;
    }

    public String getName()
    {
        return name;
    }

    public List<String> getKnownFor()
    {
        return knownFor;
    }

    public List<Award> getAwards()
    {
        return awards;
    }

    static class Award
    {
        private final String name;
        private final int year;

        @JsonCreator
        private Award(@JsonProperty("name") String name, @JsonProperty("year") int year)
        {
            this.name = name;
            this.year = year;
        }

        public String getName()
        {
            return name;
        }

        public int getYear()
        {
            return year;
        }
    }
}
