package com.saksham.sakbot;

import net.dv8tion.jda.api.events.message.MessageReceivedEvent;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public abstract class Command {

    String commandName = "";
    String description = "";
    protected String content = "";
    String inputFormat;

    public String getCommandName() {
        return commandName;
    }

    public String parseCommand(MessageReceivedEvent event){
        List<String> msg = new ArrayList<>(List.of(event.getMessage().getContentRaw().split(" ")));
        msg.remove(0);
        List<String> expression = msg.stream().filter(s -> !s.equals("")).collect(Collectors.toList());
        StringBuilder expr = new StringBuilder();
        for (String s : expression) {
            expr.append(s);
        }
        return expr.toString();
    }
    public abstract void onCommandExecuted(MessageReceivedEvent event);

}
