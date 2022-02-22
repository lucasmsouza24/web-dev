package school.sptech.projeto03.entity;

public class Hero {
    
    // attributes
    private int id;
    private String name;
    private String heroClass;
    private int ranking;

    // getters and setters
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getheroClass() {
        return heroClass;
    }
    public void setheroClass(String heroClass) {
        this.heroClass = heroClass;
    }
    public int getRanking() {
        return ranking;
    }
    public void setRanking(int ranking) {
        this.ranking = ranking;
    }
}
