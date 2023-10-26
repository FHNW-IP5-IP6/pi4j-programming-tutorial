package com.pi4j.mvc.simonsaysapp;

import com.pi4j.context.Context;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.pi4j.mvc.util.Pi4JContext;

import com.pi4j.mvc.simonsaysapp.controller.Controller;
import com.pi4j.mvc.simonsaysapp.model.Model;
import com.pi4j.mvc.simonsaysapp.view.pui.PUI;

public class AppStarter {

    private static final Logger LOGGER = LoggerFactory.getLogger(AppStarter.class);

    public static void main(String[] args) {
        Context pi4J = Pi4JContext.createContext();

        Controller controller = new Controller(new Model());
        new PUI(controller, pi4J);

        LOGGER.info("App started");

        // This will ensure Pi4J is properly finished. All I/O instances are
        // released by the system and shutdown in the appropriate
        // manner. It will also ensure that any background
        // threads/processes are cleanly shutdown and any used memory
        // is returned to the system.
        Runtime.getRuntime().addShutdownHook(new Thread(() -> {
            controller.shutdown();
            pi4J.shutdown();
            LOGGER.info("App stopped");
        }));

    }
}
