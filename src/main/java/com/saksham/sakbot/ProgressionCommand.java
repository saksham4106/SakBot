package com.saksham.sakbot;

import net.dv8tion.jda.api.events.message.MessageReceivedEvent;

public class ProgressionCommand extends Command{

    public ProgressionCommand(){
        this.commandName = "progression";
        this.description = "Calculates the Sum and Nth term of an AP";
        this.inputFormat = SakBot.prefix + commandName + " a=10; d=10; n=20";
    }

    private String getValue(String pair){
        return pair.substring(pair.indexOf("=") + 1);
    }
    @Override
    public void onCommandExecuted(MessageReceivedEvent event) {
        this.content = parseCommand(event);
        double start = 0, end = 0, num = 0, sum = 0, nth_term = 0, diff = 0f;
        String[] values = this.content.split(";");
        StringBuilder toFind = new StringBuilder("adnslt");
        for (String value : values) {
            if(value.startsWith("a=")){
                toFind.deleteCharAt(toFind.indexOf("a"));
                start = Double.parseDouble(getValue(value));
            }else if(value.startsWith("d=")){
                toFind.deleteCharAt(toFind.indexOf("d"));
                diff = Double.parseDouble(getValue(value));
            }else if(value.startsWith("n=")){
                toFind.deleteCharAt(toFind.indexOf("n"));
                num = Double.parseDouble(getValue(value));
            }else if(value.startsWith("s=")){
                toFind.deleteCharAt(toFind.indexOf("s"));
                sum = Double.parseDouble(getValue(value));
            }else if(value.startsWith("l=")){
                toFind.deleteCharAt(toFind.indexOf("l"));
                end = Double.parseDouble(getValue(value));
            }else if(value.startsWith("t=")){
                toFind.deleteCharAt(toFind.indexOf("t"));
                nth_term = Double.parseDouble(getValue(value));
            }
        }
        String missing = toFind.toString();
        if(missing.contains("t")){
            if(!(missing.contains("a") || missing.contains("n") || missing.contains("d"))){
                nth_term = start + (num - 1) * diff;
                toFind.deleteCharAt(toFind.indexOf("t"));
                missing = toFind.toString();
            }
        }

        if(missing.contains("s")){
            if(!(missing.contains("a") || missing.contains("n"))){
                if(!missing.contains("d")){
                    sum = (num/2) * (2 * start + (num - 1) * diff);

                }else if(!missing.contains("l")){
                    sum = ((start + end) / 2) * num;
                }
            }
        }

        event.getChannel().sendMessage("Nth Term: " + nth_term + "\nSum of AP: " + sum).queue();

    }
}