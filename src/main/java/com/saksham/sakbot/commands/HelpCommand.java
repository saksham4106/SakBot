package com.saksham.sakbot.commands;

import com.saksham.sakbot.SakBot;
import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;

import java.awt.Color;
import java.util.Locale;
import java.util.stream.Collectors;

public class HelpCommand extends Command{

    public HelpCommand(){
        super("help",
                "Get info of commands",
                SakBot.prefix + "help commandName" );

    }

    @Override
    public void onCommandExecuted(MessageReceivedEvent event) {
        parseCommand(event);
        EmbedBuilder eb = new EmbedBuilder()
                .setColor(new Color(0x80acff));

        String commandName = this.content;
        Command commandInst = SakBot.commands.
                stream().filter(command -> command.commandName.equals(commandName)).collect(Collectors.toList()).get(0);
        eb.setTitle(commandInst.commandName.toUpperCase(Locale.ROOT));
        eb.addField(commandInst.description + "\n", "**USAGE**: " + commandInst.inputFormat, false);
        event.getChannel().sendMessageEmbeds(eb.build()).queue();
    }
}
