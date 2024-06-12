package com.saksham.sakbot.commands;

import com.saksham.sakbot.Utils;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;

public class NumberConversionCommand extends Command{

    public NumberConversionCommand(){
        super("num", "", "");
    }
    @Override
    public void onCommandExecuted(MessageReceivedEvent event) {
        parseCommand(event);
        if(content.startsWith("binary")){
            String num = content.replaceFirst("(binary)", "");
            int number;
            if (num.matches("-?[0-9a-fA-F]+")){
                number = Integer.parseInt(num, 16);
            }else {
                number = Integer.parseInt(num);
            }
            Utils.sendMessage(Integer.toBinaryString(number), event.getChannel());
        }else if(content.startsWith("decimal")){
            String num = content.replaceFirst("(decimal)", "");
            int number;
            if (num.matches("-?[0-9a-fA-F]+")){
                number = Integer.parseInt(num, 16);
            }else {
                number = Integer.parseInt(num, 2);
            }
            Utils.sendMessage("" + number, event.getChannel());
        }else if(content.startsWith("hex")){
            String num = content.replaceFirst("(hex)", "");
            int number = Integer.parseInt(num);
            Utils.sendMessage(Integer.toHexString(number), event.getChannel());
        }
    }
}
