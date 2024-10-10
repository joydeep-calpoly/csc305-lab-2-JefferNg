package orgjson;

class Person
{
    private final String name;
    private final String[] knownFor;
    private final Award[] awards;

    Person(String name, String[] knownFor, Award[] awards)
    {
        this.name = name;
        this.knownFor = knownFor;
        this.awards = awards;
    }

    public String getName()
    {
        return name;
    }

    public String[] getKnownFor()
    {
        return knownFor;
    }

    public Award[] getAwards()
    {
        return awards;
    }
}
