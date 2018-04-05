package com.company;
import org.apache.commons.cli.*;

import java.util.Collections;

public class Main {

    public static void main(String[] args) {
        Counter counter=Main.commandParser(args);
    }

    public static Counter commandParser(String[] args) {
        Options opt=new Options();
        opt.addOption(Option.builder("c").optionalArg(true).hasArgs().build());
        opt.addOption(Option.builder("w").optionalArg(true).hasArgs().build());
        opt.addOption(Option.builder("l").optionalArg(true).hasArgs().build());
        opt.addOption(Option.builder("o").hasArg().build());
        opt.addOption(Option.builder("s").hasArg(false).build());
        opt.addOption(Option.builder("a").optionalArg(true).hasArgs().build());
        opt.addOption(Option.builder("e").hasArg().build());
        opt.addOption(new Option("h", false, "help"));
        CommandLineParser parser = new DefaultParser();
        Counter counter=new Counter();
        String[] params;
        try {
            CommandLine cmd = parser.parse(opt, args);
            if (cmd.hasOption("c")) {
                counter.getOptlist().add("c");
                if ((params=cmd.getOptionValues("c"))!=null)
                    Collections.addAll(counter.getFilelist(),params);
            }
            if (cmd.hasOption("w")) {
                counter.getOptlist().add("w");
                if ((params=cmd.getOptionValues("c"))!=null)
                    Collections.addAll(counter.getFilelist(),params);
            }
            if (cmd.hasOption("l")) {
                counter.getOptlist().add("l");
                if ((params=cmd.getOptionValues("l"))!=null)
                    Collections.addAll(counter.getFilelist(),params);
            }
            if (cmd.hasOption("o")) {
                counter.getOptlist().add("o");
                if ((params=cmd.getOptionValues("o"))!=null)
                    counter.setOutFileName(params[0]);
            }
            if (cmd.hasOption("a")) {
                counter.getOptlist().add("a");
                if ((params=cmd.getOptionValues("a"))!=null)
                    Collections.addAll(counter.getFilelist(),params);
            }
            if (cmd.hasOption("e")) {
                counter.getOptlist().add("e");
                if ((params=cmd.getOptionValues("e"))!=null)
                    counter.setStopFileName(params[0]);
            }
            if (cmd.hasOption("s")) {
                counter.getOptlist().add("s");
            }
        }catch (ParseException e){
            System.out.println("Incorrect Command: "+e.getMessage());
        }
        return counter;
    }
}
