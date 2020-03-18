package familytree;

import java.util.ArrayList;
import java.util.List;

enum Sex{
    MALE, FEMALE;
}
public class Person {
    private String name;
    private Sex sex;
    private boolean isMarried;
    private Person spouse;
    private boolean isSiblings;
    private Person father;
    private Person mother;
    private List<Person> siblings= new ArrayList<Person>();
    private boolean hasChildren;
    private List<Person> children= new ArrayList<Person>();

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Sex getSex() {
        return sex;
    }

    public void setSex(Sex sex) {
        this.sex = sex;
    }

    public boolean isMarried() {
        return isMarried;
    }

    public void setMarried(boolean married) {
        isMarried = married;
    }

    public Person getSpouse() {
        return spouse;
    }

    public void setSpouse(Person spouse) {
        this.spouse = spouse;
    }

    public boolean isSiblings() {
        return isSiblings;
    }

    public void setIsSiblings(boolean isSiblings) {
        this.isSiblings = isSiblings;
    }

    public List<Person> getSiblings() {
        return siblings;
    }

    public void setSiblings(List<Person> siblings) {
        this.siblings = siblings;
    }

    public boolean isHasChildren() {
        return hasChildren;
    }

    public void setHasChildren(boolean hasChildren) {
        this.hasChildren = hasChildren;
    }

    public List<Person> getChildren() {
        return children;
    }

    public void setChildren(List<Person> children) {
        this.children = children;
    }

    public Person(String name, Sex sex) {
        this.name = name;
        this.sex = sex;
    }

    public Person getFather() {
        return father;
    }

    public void setFather(Person father) {
        this.father = father;
    }

    public Person getMother() {
        return mother;
    }

    public void setMother(Person mother) {
        this.mother = mother;
    }
}
