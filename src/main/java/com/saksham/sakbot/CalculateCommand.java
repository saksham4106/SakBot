package com.saksham.sakbot;

import com.fathzer.soft.javaluator.DoubleEvaluator;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;

public class CalculateCommand extends Command{
    public CalculateCommand(){
        this.commandName = "eval";
        this.description = "Evaluates a String Expression";
        this.inputFormat = SakBot.prefix + commandName + " (4 * 5) - 45 + 34 * sin(PI/6)";
    }
    @Override
    public void onCommandExecuted(MessageReceivedEvent event) {
        this.content = parseCommand(event);
        DoubleEvaluator eval = new DoubleEvaluator();
        event.getChannel().sendMessage("Value is: " + eval.evaluate(this.content)).queue();
    }
}
