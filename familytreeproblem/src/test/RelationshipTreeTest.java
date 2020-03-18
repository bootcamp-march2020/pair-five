package test;

import familytree.Person;
import familytree.RelationshipTree;
import familytree.Sex;
import org.junit.Assert;
import org.junit.Test;

public class RelationshipTreeTest {

    @Test
    public void testRelationshipTreeForAssignSibilings(){
        Person firstKing= new Person("King Shan", Sex.MALE);
        RelationshipTree relationshipTree=new RelationshipTree(firstKing);
        Person sibling1=new Person("Ramu", Sex.MALE);
         Person result= relationshipTree.assignSiblings(sibling1);
        Assert.assertTrue(result.isSiblings());
    }

    @Test
    public void testRelationshipTreeForGetMarried(){
        Person firstKing= new Person("King Shan", Sex.MALE);
        RelationshipTree relationshipTree=new RelationshipTree(firstKing);
        Person queen= new Person("Queen Anga", Sex.FEMALE);
        Person result=relationshipTree.getMarried(queen);
        Assert.assertTrue(result.isMarried());
        Assert.assertEquals("Queen Anga",result.getSpouse().getName());
    }

    @Test
    public void testRelationshipTreeForGiveBirth(){
        Person firstKing= new Person("King Shan", Sex.MALE);
        Person queen= new Person("Queen Anga", Sex.FEMALE);
        RelationshipTree relationshipTree=new RelationshipTree(firstKing);
        Person baby= new Person("Chit", Sex.MALE);
        Person result= relationshipTree.giveBirth(baby, queen);
        Assert.assertTrue(result.isHasChildren());
        Assert.assertEquals("Chit",result.getChildren().get(0).getName());
        Assert.assertEquals("Queen Anga", result.getMother().getName());
        Assert.assertEquals("King Shan", result.getFather().getName());
    }

    @Test
    public void testRelationshipTreeForParentalUncles(){
        Person dithra = new Person("Dithra", Sex.FEMALE);
        Person jaya=new Person("Jaya", Sex.MALE);
        //keeping dithra as base
        RelationshipTree relationshipTree=new RelationshipTree(dithra);
        Person baby= new Person("Yodhan", Sex.MALE);


        Person dithraSiblings= new Person("Tritha" , Sex.FEMALE);
        relationshipTree.assignSiblings(dithraSiblings);

        Person dithraSiblings1=new Person("Vritha", Sex.MALE);
        relationshipTree.assignSiblings(dithraSiblings1);

        relationshipTree.giveBirth(baby, jaya);

        System.out.println(baby.getFather().getName());
        System.out.println(baby.getFather());
        System.out.println(relationshipTree.getPaternalUncle(baby));


    }

}
