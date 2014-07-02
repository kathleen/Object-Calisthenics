package com.theladders.avital.oc.user;

import com.theladders.avital.oc.print.ApplicationsPrinter;
import com.theladders.avital.oc.print.ConsoleCountPrinter;
import com.theladders.avital.oc.print.ListPrinter;

/**
 * Created by atzubeli on 6/13/14.
 */
public class Name {

    private String name;

    public Name(String name){

        this.name = name;

    }

    public String toString() {

        return name;
    }


    public void print(ApplicationsPrinter printer) {

        printer.print(name);
    }

    public void print(ConsoleCountPrinter printer){

        printer.print(name);

    }
    public void print(ListPrinter printer){

        printer.print(name);

    }




}
