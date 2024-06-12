package com.saksham.sakbot.commands;

import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.utils.FileUpload;

import java.io.File;
import java.util.Collections;

public class RandomCommand extends Command{

    public RandomCommand() {
        super("random", "does whatever temporary thing I want to test", "ok");
    }

    @Override
    public void onCommandExecuted(MessageReceivedEvent event) {
        event.getChannel().sendFiles(Collections.singleton(FileUpload.fromData(new File("b.png")))).queue();
    }
}
