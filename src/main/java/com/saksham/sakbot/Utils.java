package com.saksham.sakbot;


import net.dv8tion.jda.api.entities.channel.middleman.MessageChannel;

public class Utils {

    public static void sendMessage(String message, MessageChannel channel){

        channel.sendMessage(message).queue();
    }
}
