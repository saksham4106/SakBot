package com.saksham.sakbot.events;

import com.saksham.sakbot.SakBot;
import com.saksham.sakbot.Utils;
import net.dv8tion.jda.api.entities.User;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import org.jetbrains.annotations.NotNull;

import java.util.Locale;


public class MessageEventListener extends ListenerAdapter {
    @Override
    public void onMessageReceived(@NotNull MessageReceivedEvent event) {
        SakBot.commands.forEach(command -> {
            if(event.getMessage().getContentRaw().split(" ")[0].equals(SakBot.prefix + command.getCommandName())){
                command.onCommandExecuted(event);
            }
        });
        String form = event.getMessage().getContentDisplay().split(" ")[0];
        if(form.equals(SakBot.prefix + "lifegoal")){
            Utils.sendMessage("https://cdn.discordapp.com/attachments/867775105463091260/947350757777219666/unknown.png", event.getChannel());
        }else if(form.equals(SakBot.prefix + "catgirl")){
            Utils.sendMessage("https://cdn.discordapp.com/attachments/947205643260002304/947205691234467920/aadishcatgirl.png", event.getChannel());
        }else if(form.equals(SakBot.prefix + "haha")){
            Utils.sendMessage("hahahahahahahahahahahahahahahahahahahahahahahahahahahahahahahahahahahahahahahahahahahahahahahahahahahahahahahahahahahahahahahahahahahahahahahahahahahahahahahahahahahahahahahahahahahahahahahahahahahahahahahahahahahahahahahahahahahahahahahahahahahahahahahahahahahahahahahahahahahahahahahahahahahahahahahahahahahahahahahahahahahahahahahahahahahahahahahahahahahahahahahahahahahahahahahahahahahahahahahahahahahahahahahahahahahahahahahahahahahahahahahahahahahahahahahahahahahahahahahahahahahahahahahahahahahahahahahahahahahahahahahahahahahahahahahahahahahahahahahahahahahahahahahahahahahahahahahahahahahahahahahahahahahahahahahahahahahahahahahahahahahahahahahahahahahahahahahahahahahahahahahahahahahahahahahahahahahahahahahahahahahahahahahahahahahahahahahahahahahahahahahahahahahahahahahahahahahahahahahahahahahahahahahahahahahahahahahahahahahahahahahahahahahahahahahahahahahahahahahahahahahahahahahahahahahahahahahahahahahahahahahahahahahahahahahahahahahahahahahahahahahahahahahahahahahahahahahahahahahahahahahahahahahahahahahahahahahahahahahahahahahahahahahahahahahahahahahahahahahahahahahahahahahahahahahahahahahahahahahahahahahahahahahahahahahahahahahahahahahahahahahahahahahahahahahahahahahahahahahahahahahahahahahahahahahahahahahahahahahahahahahahahahahahahahahahahahahahahahahahahahahahahahahahahahahahahahahahahahahahahahahahahahahahahahahahahahahahahahahahahahahahahahahahahahahahahahahahahahahahahahahahahahahahahahahahahahahahahahahahahahahahahahahahahahahahahahahahahahahahahahahahahahahahahahahahahahahahahahahahahahahahahahahahahahahahahahahahahahahahahahahahahahahahahahahahahahahahahahahahahahahahahahahahahahahahahahahahahahahahahahahahahahahahahahahahahahahahahahahahahahahahahahahahahahahahahahahahahahahahahahahahahahahahahahahahahahahahahahahahahahahahahahahahahahahahahahahahahahahahahahahahahahahahahahahahahahahahahahahahahahahahahahahahahahahahahahahahahahahahahahahahahahahahahahahahahahahahahahahahahahahahahahahahahahahahahahahahahahahahahahahahahahahahahahahahahahahahahahahaha", event.getChannel());
        }
        String message = event.getMessage().getContentDisplay().toLowerCase(Locale.ROOT);
        if(event.getMessage().getMentions().getUsers().contains(User.fromId("754547138406514788"))){
            if(message.split(" ").length == 3){
                if(message.split(" ")[1].equals("prefix-set")) {
                    SakBot.prefix = message.split(" ")[2];
                }
            }
            event.getChannel().sendMessage("boop").queue();
            if(message.contains("query_prefix")) event.getChannel().sendMessage("Prefix is currently set to: " + SakBot.prefix
            + "\n do `@SakBot prefix-set new_prefix` to change it!").queue();
        }
        if(message.contains("hmm")){
            event.getMessage().addReaction(event.getGuild().getEmojisByName("hmmmm", true).get(0)).queue();
        }


    }
}
