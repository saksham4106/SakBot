package com.saksham.sakbot.commands;

import com.fathzer.soft.javaluator.DoubleEvaluator;
import com.saksham.sakbot.SakBot;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;

public class QuadraticCommand extends Command{

    private final DoubleEvaluator eval = new DoubleEvaluator();

    public QuadraticCommand(){
        super("quadratic",
                "Calculates the roots of the given quadratic equation",
                SakBot.prefix + "quadratic a=1; b=5; c=6" );
    }

    private String getValue(String pair){
        return pair.substring(pair.indexOf("=") + 1);
    }

    @Override
    public void onCommandExecuted(MessageReceivedEvent event) {
        this.parseCommand(event);
        double a = 0, b = 0, c = 0;
        String[] values = this.content.split(";");
        for (String value : values) {
            if(value.startsWith("a=")){
                a = eval.evaluate(getValue(value));
            }else if(value.startsWith("b=")){
                b = eval.evaluate(getValue(value));
            }else if(value.startsWith("c=")){
                c = eval.evaluate(getValue(value));
            }
        }

        double discriminant = Math.pow(b, 2) - 4 * a * c;
        if(discriminant < 0) {
            event.getChannel().sendMessage("Roots are Complex!").queue();
        }
        else{
            double root1 = (-b + Math.sqrt(discriminant)) / 2 * a;
            double root2 = (-b - Math.sqrt(discriminant)) / 2 * a;
            event.getChannel().sendMessage("Equation: " + a +"x^2 + " + b + "x + " + c + "\n" + "Root1: " + root1 + "\nRoot2: " +  root2).queue();
        }
    }
}
