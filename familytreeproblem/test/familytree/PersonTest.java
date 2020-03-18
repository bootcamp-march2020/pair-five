package familytree;

import org.junit.Assert;
import org.junit.Test;

public class PersonTest {

    @Test
    public void testPersonDomainModel(){
        Person personObj= new Person("Karthik", Sex.MALE);
        Assert.assertEquals("Karthik", personObj.getName());
        Assert.assertEquals("MALE", personObj.getSex().toString());

        Person personObj1= new Person("Priya", Sex.FEMALE);
        Assert.assertEquals("Priya", personObj1.getName());
        Assert.assertEquals("FEMALE", personObj1.getSex().toString());
    }
}
