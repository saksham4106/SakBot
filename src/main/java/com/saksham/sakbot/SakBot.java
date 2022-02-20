package com.saksham.sakbot;

import com.saksham.sakbot.events.MessageEventListener;
import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;


import javax.security.auth.login.LoginException;
import java.util.ArrayList;
import java.util.List;

public class SakBot {
    public static List<Command> commands = new ArrayList<>();
    public static String prefix = "st_";
    public static JDA jda;

    public static void main(String[] args) throws LoginException {
        jda = JDABuilder.createDefault(Token.getToken()).build();
        registerCommands();
        jda.addEventListener(new MessageEventListener());
    }

    private static void registerCommands(){
        commands.add(new CalculateCommand());
        commands.add(new ProgressionCommand());
        commands.add(new QuadraticCommand());
        commands.add(new LinearPairCommand());
        commands.add(new ListCommands());
        commands.add(new HelpCommand());
    }

}
