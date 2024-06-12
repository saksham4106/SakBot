package com.saksham.sakbot.commands;

import net.dv8tion.jda.api.events.message.MessageReceivedEvent;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public abstract class Command {

    public String commandName;
    public String description;
    protected String content;
    public String inputFormat;

    public Command(String commandName, String description, String inputFormat){
        this.commandName = commandName;
        this.description = description;
        this.inputFormat = inputFormat;
    }

    public String getCommandName() {
        return commandName;
    }

    public void parseCommand(MessageReceivedEvent event){
        List<String> msg = new ArrayList<>(List.of(event.getMessage().getContentRaw().split(" ")));
        msg.remove(0);
        List<String> expression = msg.stream().filter(s -> !s.isEmpty()).collect(Collectors.toList());
        StringBuilder expr = new StringBuilder();
        for (String s : expression) {
            expr.append(s);
        }
        this.content = expr.toString();
    }
    public abstract void onCommandExecuted(MessageReceivedEvent event);

}
