package com.game.main;

/**
 * Created by Overlord Main on 06/05/2016.
 */
public class Debug {


    /**
     * This function is used to print out only specific diagnostic information from the
     * system, the verbosity level is graded from 0 - 7 and depending on how much info the
     * user wants to see can be modified in this class.
     * 0 -
     * 1 -
     * 2 -
     * 3 -
     * 4 -
     * 5 -
     * 6 -
     * 7 -
     *
     */

    public static void print(int debugtype, String message){

        boolean debugactive = true;
        int     verbosity   = 1;


        if(!debugactive){
            System.out.println("Debug State Inactive");
            return;
        }

        if(verbosity >= debugtype){
            System.out.println(message);
        }



    }

}

