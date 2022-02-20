package com.saksham.sakbot;

import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;

import java.awt.*;

public class ListCommands extends Command{

    public ListCommands(){
        this.commandName = "list";
        this.description = "Lists all commands";
        this.inputFormat = SakBot.prefix + commandName;
    }
    @Override
    public void onCommandExecuted(MessageReceivedEvent event) {
        EmbedBuilder eb = new EmbedBuilder()
                .setColor(new Color(0x80acff));

        StringBuilder text = new StringBuilder();
        SakBot.commands.forEach(command -> {
            text.append(command.commandName).append("\n");
        });
        eb.addField("List of Commands", text.toString(), false);
        event.getChannel().sendMessageEmbeds(eb.build()).queue();
    }
}
