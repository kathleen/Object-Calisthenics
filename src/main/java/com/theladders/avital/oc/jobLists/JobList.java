package com.theladders.avital.oc.jobLists;

import com.theladders.avital.oc.collections.CollectionPrinter;
import com.theladders.avital.oc.collections.CollectionWrapper;
import com.theladders.avital.oc.jobs.ATSJob;

import java.util.ArrayList;

/**
 * Created by atzubeli on 5/28/14.
 */
public class JobList implements CollectionWrapper<ATSJob> {

    private ArrayList<ATSJob> jobs = new ArrayList<ATSJob>();

    public boolean exists(ATSJob job){

        return jobs.contains(job);
    }

    public void addJob(ATSJob job){

        jobs.add(job);
    }

    public void removeJob(ATSJob job){

        jobs.remove(job);
    }

    public JobList readAll(){

        return this;
    }

    public int getSize(){

        return jobs.size();
    }




    public void printCollection(CollectionPrinter printer){

        printer.print(jobs);

    }



}
