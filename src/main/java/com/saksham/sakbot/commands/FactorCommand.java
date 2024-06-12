package com.saksham.sakbot.commands;

import com.saksham.sakbot.SakBot;
import com.saksham.sakbot.Utils;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;

public class FactorCommand extends Command{

    public FactorCommand() {
        super("factor",
                "A collection of Factors related commands\n" +
                        "lcm num1 num2",
                SakBot.prefix + "factor lcm 1, 2");
    }

    @Override
    public void onCommandExecuted(MessageReceivedEvent event) {
         parseCommand(event);
         if(content.startsWith("lcm")){
             String[] equation = content.replaceFirst("(lcm)", "").split(",");
             int num1 = Integer.parseInt(equation[0]);
             int num2 = Integer.parseInt(equation[1]);
             Utils.sendMessage("LCM is " + calculateLCM(num1, num2), event.getChannel());
         }else if(content.startsWith("hcf")){
             String[] equation = content.replaceFirst("(hcf)", "").split(",");
             int num1 = Integer.parseInt(equation[0]);
             int num2 = Integer.parseInt(equation[1]);
             Utils.sendMessage("HCF is " + calculateHCF(num1, num2), event.getChannel());
         }else{
             Utils.sendMessage("Factors are " + listFactors(Integer.parseInt(this.content)), event.getChannel());
         }
    }

    private int calculateLCM(int num1, int num2){
        for(int i = Math.max(num1, num2); i < num1 * num2; i++){
            if(i % num1 == 0 && i % num2 == 0){
                return i;
            }
        }
        return num1 * num2;
    }

    private int calculateHCF(int num1, int num2){
        for(int i = 1; i <= Math.max(num1, num2); i++){
            if(num1 % i == 0 && num2 % i == 0 && i != 1){
                return i;
            }
        }
        return 1;
    }

    private String listFactors(int num){
        StringBuilder factors = new StringBuilder();
        for(int i = 1; i <= num; i++){
            if(num % i == 0){
                factors.append(i).append(", ");
            }
        }
        factors.setCharAt(factors.length() - 1, ' ');
        return factors.toString();
    }
}
