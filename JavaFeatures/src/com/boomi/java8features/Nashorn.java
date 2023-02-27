package com.boomi.java8features;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;
import java.io.FileNotFoundException;
import java.io.FileReader;

public class Nashorn {
    public static void main(String[] args) throws ScriptException, FileNotFoundException {

        ScriptEngineManager scriptEngineManager = new ScriptEngineManager();
        ScriptEngine nashorn = scriptEngineManager.getEngineByName("nashorn");

        nashorn.eval("print('Hello World...!!!')");

        nashorn.eval(new FileReader("src/NashornDemo.js"));
    }
}
