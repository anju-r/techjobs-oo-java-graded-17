package org.launchcode.techjobs.oo;

import org.junit.Test;

import static org.junit.Assert.*;

public class JobTest {
    //TODO: Create your unit tests here
    @Test
    public void testSettingJobId(){
        Job job1 = new Job();
        Job job2 = new Job();
        int job1Id = job1.getId();
        int job2Id = job2.getId();

        assertNotEquals(job1Id, job2Id);
    }
    @Test
    public void testJobConstructorSetsAllFields(){
        Job job1 = new Job("Product Tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));
        assertEquals("Product Tester", job1.getName());
        assertEquals("ACME", job1.getEmployer().toString());
        assertEquals("Desert", job1.getLocation().toString());
        assertEquals("Quality control", job1.getPositionType().toString());
        assertEquals("Persistence", job1.getCoreCompetency().toString());
        assertTrue(job1.getName() instanceof String);
        assertTrue(job1.getEmployer() instanceof Employer);
        assertTrue(job1.getLocation() instanceof Location);
        assertTrue(job1.getPositionType() instanceof PositionType);
        assertTrue(job1.getCoreCompetency() instanceof CoreCompetency);

    }
    @Test
    public void testJobsForEquality(){
        Job job1 = new Job("Product Tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));
        Job job2 = new Job("Product Tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));
        //assertFalse(job1.equals(job2));
        assertNotEquals(job1, job2);
    }
    @Test
    public void testToStringStartsAndEndsWithNewLine(){
        Job job1 = new Job("Product Tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));

        String testString = System.lineSeparator() + "ID: "+job1.getId()+"\n"+"Product Tester: " + job1.getName()+"\n"+"Employer: "+ job1.getEmployer()+"\n"+
                "Location: "+ job1.getLocation()+"\n"+"Position Type: "+job1.getPositionType()+"\n"+"Core Competency: "+job1.getCoreCompetency()+"\n"+System.lineSeparator();

        //assertEquals(testString, job1);
        String start = String.valueOf(job1.toString().charAt(0));
        String end = String.valueOf(job1.toString().charAt(job1.toString().length()-1));
        assertEquals("\n",start);
        assertEquals("\n", end);


    }
    @Test
    public void testToStringContainsCorrectLabelsAndData(){
        Job job1 = new Job("Product Tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));
        String testString = "\n" + "ID: "+job1.getId()+"\n"+"Name: " + job1.getName()+"\n"+"Employer: "+ job1.getEmployer()+"\n"+
                "Location: "+ job1.getLocation()+"\n"+"Position Type: "+job1.getPositionType()+"\n"+"Core Competency: "+job1.getCoreCompetency()+"\n";
        assertEquals(testString, job1.toString());

    }
    @Test
    public void testToStringHandlesEmptyField(){
        Job job1 = new Job("", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));
        assertEquals("Data not available", job1.getName());

    }

}
