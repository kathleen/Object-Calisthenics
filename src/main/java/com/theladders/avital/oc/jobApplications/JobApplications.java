package com.theladders.avital.oc.jobApplications;

import com.theladders.avital.oc.jobLists.JobList;
import com.theladders.avital.oc.jobs.Job;
import com.theladders.avital.oc.print.AggregateCount;
import org.joda.time.LocalDate;

import java.util.*;

/**
* Created by atzubeli on 5/22/14.
*/
public class JobApplications{

    private Map<Job, ApplicationsList> applications = new HashMap<>();

    public void createJobKey(Job job){

        if (!applications.containsKey(job))

            applications.put(job, new ApplicationsList());

    }

    public boolean contains(Job job){

        return applications.containsKey(job);
    }

    public void addApplication(Job job, JobApplication application){

        ApplicationsList list = applications.get(job);

        list.addApplication(application);

    }

    public JobList getAllJobsByEmployer(){

        Set<Job> jobSet = applications.keySet();

        List<Job> jobList = new ArrayList<>(jobSet);

        return new JobList(jobList);

    }

    public ApplicationsList getByJob(Job job){

        return applications.get(job);
    }

    public ApplicationsList getByJobAndDate(Job job, LocalDate date){

        ApplicationsList list = applications.get(job);

        return list.filteredByDate(date);

    }

    public ApplicationsList getByDate(LocalDate date){

        ApplicationsList resultList = new ApplicationsList();

        for (Job job : applications.keySet())
        {
            ApplicationsList list = applications.get(job);

            resultList = resultList.combinedWith(list.filteredByDate(date));
        }

        return resultList;
    }

    public ApplicationsList getAllApplications(){

        ApplicationsList resultList = new ApplicationsList();

        for (Job job : applications.keySet())
        {
            ApplicationsList list = applications.get(job);

            resultList = resultList.combinedWith(list);
        }
        return resultList;

    }

    public int numberOfJobs(){

        return applications.size();
    }

    public AggregateCount getAggregateCount(){

        AggregateCount aggregateCount = new AggregateCount();

        for (Job job : applications.keySet())
        {
            ApplicationsList list = applications.get(job);

            aggregateCount.add(job, list.size());

        }

        return aggregateCount;

    }

}
