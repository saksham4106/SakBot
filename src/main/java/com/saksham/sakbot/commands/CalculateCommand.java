package com.saksham.sakbot.commands;

import com.fathzer.soft.javaluator.DoubleEvaluator;
import com.saksham.sakbot.SakBot;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;


public class CalculateCommand extends Command{
    public CalculateCommand(){
        super("eval",
                "Evaluates a String Expression",
                SakBot.prefix + "eval (4 * 5) - 45 + 34 * sin(PI/6)");
    }
    @Override
    public void onCommandExecuted(MessageReceivedEvent event) {
        parseCommand(event);
        DoubleEvaluator eval = new DoubleEvaluator();
        event.getChannel().sendMessage("Value is: " + eval.evaluate(this.content)).queue();

    }
}
