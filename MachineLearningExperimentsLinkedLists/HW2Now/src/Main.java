//package com.company;
import java.sql.SQLOutput;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.*;

public class Main {

    public static void main(String [] args)
    {
        /*Days are starting from day 1. If day's value is 0 or smaller than it, exception will be thrown. Please beware.*/
        ExperimentList mainList = new ExperimentList();
        System.out.println("*************************************************************");
        System.out.println("*************************************************************");
        System.out.println("TESTING addExp METHOD.");
        System.out.println("*************************************************************");
        System.out.println("*************************************************************");

        Experiment exp1 = new Experiment("SetupAlpha", 1, "12:02",true, (float)0.3);
        Experiment exp2 = new Experiment("SetupBravo", 2, "12:02",true, (float)0.3);
        Experiment exp3 = new Experiment("SetupCharlie", 2, "12:02",true, (float)0.3);
        Experiment exp4 = new Experiment("SetupDelta", 1, "12:02",true, (float)0.3);
        Experiment exp5 = new Experiment("SetupEcho", 3, "12:02",true, (float)0.3);
        Experiment exp6 = new Experiment("M4A1", 2, "12:02",true, (float)0.3);
        Experiment exp7 = new Experiment("AK-47", 3, "12:02",true, (float)0.3);
        Experiment exp8 = new Experiment("Grooza", 4, "12:02",true, (float)0.3);
        Experiment exp9 = new Experiment("AUG", 5, "12:02",true, (float)0.3);
        Experiment exp10 = new Experiment("AWP", 1, "12:02",true, (float)0.3);

        mainList.addExp(exp1);
        System.out.println(mainList);
        mainList.addExp(exp2);
        System.out.println(mainList);
        mainList.addExp(exp3);
        System.out.println(mainList);
        mainList.addExp(exp4);
        System.out.println(mainList);
        mainList.addExp(exp5);
        System.out.println(mainList);
        mainList.addExp(exp6);
        System.out.println(mainList);
        mainList.addExp(exp7);
        System.out.println(mainList);
        mainList.addExp(exp8);
        System.out.println(mainList);
        mainList.addExp(exp9);
        System.out.println(mainList);
        mainList.addExp(exp10);
        System.out.println(mainList);
        System.out.println("*************************************************************");
        System.out.println("*************************************************************");
        System.out.println("TESTING getExp METHOD.");
        System.out.println("*************************************************************");
        System.out.println("*************************************************************");


        Experiment test1;
        Experiment test2;
        Experiment test3;
        Experiment test4;
        Experiment test5;
        System.out.println("Getting 1. index from 2.day..");
        test1 = mainList.getExp(2,1);
        System.out.println(test1);
        System.out.println("Getting 1. index from 1.day..");
        test2 = mainList.getExp(1,1);
        System.out.println(test2);
        System.out.println("Getting 2. index from 1.day..");
        test3 = mainList.getExp(1,2);
        System.out.println(test3);
        System.out.println("Getting 2. index from 3.day..");
        test4 = mainList.getExp(3,2);
        System.out.println(test4);
        System.out.println("Getting 1. index from 4.day..");
        test5 = mainList.getExp(4,1);
        System.out.println(test5);

        System.out.println("*************************************************************");
        System.out.println("*************************************************************");
        System.out.println("TESTING setExp METHOD.");
        System.out.println("*************************************************************");
        System.out.println("*************************************************************");

        test1 = new Experiment("Alphaville", 1, "12:02",true, (float)0.3);
        test2 = new Experiment("A ha", 2, "12:02",true, (float)0.3);
        test3 = new Experiment("Modern Talking", 2, "12:02",true, (float)0.3);
        test4 = new Experiment("Dollardesene", 1, "12:02",true, (float)0.3);
        test5 = new Experiment("K-391", 3, "12:02",true, (float)0.3);
        System.out.println("Getting 1. index from 2.day..");
        mainList.setExp(2,1, test1);
        System.out.println(mainList.getExp(2,1));
        System.out.println("Getting 1. index from 1.day..");
        mainList.setExp(1,1, test2);
        System.out.println(mainList.getExp(1,1));
        System.out.println("Setting 2. index from 1.day..");
        mainList.setExp(1,2,test3);
        System.out.println(mainList.getExp(3,2));
        System.out.println("Setting 2. index from 3.day..");
        mainList.setExp(3,2,test4);
        System.out.println(mainList.getExp(3,1));
        System.out.println("Setting 1. index from 4.day..");
        mainList.setExp(4,1, test5);
        System.out.println(mainList.getExp(4,1));
        /*Original list may be damaged here since I'm adding independent day values randomly.*/

        System.out.println("*************************************************************");
        System.out.println("*************************************************************");
        System.out.println("TESTING removeExp METHOD.");
        System.out.println("*************************************************************");
        System.out.println("*************************************************************");

        ExperimentList mainList2 = new ExperimentList();
        mainList2.addExp(exp1);
        System.out.println(mainList);
        mainList2.addExp(exp2);
        System.out.println(mainList);
        mainList2.addExp(exp3);
        System.out.println(mainList);
        mainList2.addExp(exp4);
        System.out.println(mainList);
        mainList2.addExp(exp5);
        System.out.println(mainList);
        mainList2.addExp(exp6);
        System.out.println(mainList);
        mainList2.addExp(exp7);
        System.out.println(mainList);
        mainList2.addExp(exp8);
        System.out.println(mainList);
        mainList2.addExp(exp9);
        System.out.println(mainList);
        mainList2.addExp(exp10);

        System.out.println("Printing original list.");
        System.out.println(mainList2);

        System.out.println("Now removing 0.index of 1.day and printing list.");
        mainList2.removeExp(1,0);
        System.out.println("Printing the list after changes");
        System.out.println(mainList2);
        System.out.println("Now removing 1.index of 4.day and printing list.");
        mainList2.removeExp(4,1);
        System.out.println("Printing the list after changes");
        System.out.println(mainList2);
        System.out.println("Now removing 2.index of 3.day and printing list.");
        mainList2.removeExp(3,2);
        System.out.println("Printing the list after changes");
        System.out.println(mainList2);

        System.out.println("*************************************************************");
        System.out.println("*************************************************************");
        System.out.println("TESTING listExp METHOD.");
        System.out.println("*************************************************************");
        System.out.println("*************************************************************");
        /*New list will be created because some of members should have different completed boolean values.*/

        ExperimentList listExperiment = new ExperimentList();
        exp3.setCompleted(false);
        exp2.setCompleted(false);
        exp5.setCompleted(false);
        listExperiment.addExp(exp1);
        listExperiment.addExp(exp2);
        listExperiment.addExp(exp3);
        listExperiment.addExp(exp4);
        listExperiment.addExp(exp5);

        System.out.println("Printing 5 element list before any operations");
        System.out.println(listExperiment);
        System.out.println();
        System.out.println("Now only printing completed ones with specific day value (2). ");
        listExperiment.listExp(2);
        System.out.println("Now only printing completed ones with specific day value (1). ");
        listExperiment.listExp(1);


        System.out.println("*************************************************************");
        System.out.println("*************************************************************");
        System.out.println("TESTING removeDay METHOD.");
        System.out.println("*************************************************************");
        System.out.println("*************************************************************");

        System.out.println("Printing original list.");
        System.out.println(listExperiment);
        System.out.println("Now removing all day1 experiments.");
        listExperiment.removeDay(1);
        System.out.println("Printing after changes");
        System.out.println(listExperiment);
        System.out.println("Now removing all day3 experiments.");
        listExperiment.removeDay(3);
        System.out.println("Printing after changes");
        System.out.println(listExperiment);

        System.out.println("*************************************************************");
        System.out.println("*************************************************************");
        System.out.println("TESTING orderExperiments METHOD.");
        System.out.println("*************************************************************");
        System.out.println("*************************************************************");

        System.out.println("Creating non-ordered list for orderExperiments method.");
        ExperimentList sortedList = new ExperimentList();
        ExperimentList unsortedList = new ExperimentList();
        unsortedList.addExp(exp1);
        unsortedList.addExp(exp2);
        unsortedList.addExp(exp3);
        unsortedList.addExp(exp4);
        unsortedList.addExp(exp5);
        unsortedList.addExp(exp6);
        unsortedList.addExp(exp7);
        unsortedList.addExp(exp8);
        unsortedList.addExp(exp9);

        System.out.println("Printing non-ordered list before sorting.");

        System.out.println(unsortedList);

        System.out.println("Now printing the sorted list.");
        sortedList.setHead(unsortedList.orderExperiments());
        System.out.println(sortedList);

        System.out.println("*************************************************************");
        System.out.println("*************************************************************");
        System.out.println("TESTING Iterator functions...");
        System.out.println("*************************************************************");
        System.out.println("*************************************************************");

        Iterator itr =  sortedList.iterator();
        while(itr.hasNext()) {
            System.out.println(itr.next().toString());
        }
        System.out.println("*************************************************************");
        System.out.println("*************************************************************");
        System.out.println("TESTING orderDay functions...");
        System.out.println("*************************************************************");
        System.out.println("*************************************************************");

        Experiment testExp1 = new Experiment("Setup1", 1, "12:43", true, (float)4.2);
        Experiment testExp2 = new Experiment("Setup2", 2, "12:31", true, (float)3.2);
        Experiment testExp3 = new Experiment("Setup3", 2, "12:44", true, (float)2.2);
        Experiment testExp4 = new Experiment("Setup4", 2, "10:23", true, (float)2.3);
        Experiment testExp5 = new Experiment("Setup5", 1, "12:43", true, (float)0.2);
        Experiment testExp6 = new Experiment("Setup6", 1, "13:43", true, (float)1.1);
        Experiment testExp7 = new Experiment("Setup7", 1, "12:43", true, (float)0.1);
        Experiment testExp8 = new Experiment("Setup8", 1, "11:23", true, (float)0.02);
        ExperimentList lastTest = new ExperimentList();
        lastTest.addExp(testExp1);
        lastTest.addExp(testExp2);
        lastTest.addExp(testExp3);
        lastTest.addExp(testExp4);
        lastTest.addExp(testExp5);
        lastTest.addExp(testExp6);
        lastTest.addExp(testExp7);
        lastTest.addExp(testExp8);

        System.out.println("Before sorting");
        System.out.println(lastTest);
        System.out.println("After sorting");
        lastTest.orderDay(1);


        System.out.println("*************************************************************");
        System.out.println("*************************************************************");
        System.out.println("ALL TESTS END.");
        System.out.println("*************************************************************");
        System.out.println("*************************************************************");




    }
}

