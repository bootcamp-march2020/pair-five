package familytree;

import jdk.jshell.PersistentSnippet;

import java.util.List;
import java.util.stream.Collectors;

public class RelationshipTree {

    Person basePerson;

    public RelationshipTree(Person basePerson) {
        this.basePerson = basePerson;
    }

    public Person getMarried(Person spouse) {
        this.basePerson.setMarried(true);
        this.basePerson.setSpouse(spouse);
        return basePerson;
    }

    public Person assignSiblings(Person sibling) {
        this.basePerson.setIsSiblings(true);
        this.basePerson.getSiblings().add(sibling);
        return basePerson;
    }

    public Person giveBirth(Person children, Person spouse) {
        this.basePerson.setHasChildren(true);
        this.basePerson.getChildren().add(children);
        if (spouse.getSex().equals(Sex.FEMALE)) {
            this.assignMother(spouse,children);
            this.assignFather(this.basePerson, children);
        } else {
            this.assignMother(this.basePerson, children);
            this.assignFather(spouse,children);
        }
        return basePerson;
    }

    public String getPaternalUncle(Person person) {
        Person father = person.getFather();
        if (father.isSiblings()) {
            List<Person> fatherSiblings = father.getSiblings();
            List<Person> parentalUncles = fatherSiblings.stream().filter(p -> !p.getSex().equals(Sex.MALE)).collect(Collectors.toList());
            String name = "";
            for (Person uncles :
                    parentalUncles) {
                name = name+" "+uncles.getName() + ", ";
            }
            return name;
        } else {
            return "No Parental Uncle";
        }
    }

    private void assignFather(Person father,Person child) {
        child.setFather(father);
    }

    private void assignMother(Person mother,Person child) {
        child.setMother(mother);
    }


}
