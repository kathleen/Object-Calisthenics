package com.theladders.avital.oc.user;


import com.theladders.avital.oc.jobApplications.JobApplications;
import com.theladders.avital.oc.jobs.JobManager;
import com.theladders.avital.oc.jobs.PostedJobs;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.Calendar;


/**
 * Created by atzubeli on 6/17/14.
 */
public class EmployerTest {

    Employer employer;

    PostedJobs jobs = new PostedJobs();

    JobManager manager = new JobManager(jobs, new JobApplications());

    Name theladders, software, designer;


    @Before
    public void initialize(){

        theladders = new Name("theladders");

        software = new Name("software");

        designer = new Name("designer");


        employer = new Employer(theladders, manager);

        Calendar calendar = Calendar.getInstance();

        System.out.println(calendar.getTime());

    }

    @Test
    public void postJobTest(){

        employer.postATSJob(software);

        employer.postATSJob(designer);


        Assert.assertTrue(jobs.readAll(employer).getSize() == 2);

    }

    @Test
    public void viewPostedJobsTest(){

        employer.postJREQJob(software);

        employer.postJREQJob(designer);

        Assert.assertTrue(employer.viewPostedJobs().getSize()==2);

    }

}
