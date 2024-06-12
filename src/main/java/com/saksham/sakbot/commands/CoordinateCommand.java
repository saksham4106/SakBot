package com.saksham.sakbot.commands;

import com.saksham.sakbot.SakBot;
import com.saksham.sakbot.Utils;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;

import java.util.Arrays;

public class CoordinateCommand extends Command{

    public CoordinateCommand(){
        super("coord",

                "A plethora of coordinate geometry related commands \n" +
                        "dist (Calculates distance between two points) \n" +
                        "triangle_area (Calculates area of a triangle in 2D space)",

                SakBot.prefix + "coord dist (1, 2),(5, 6)\n" +
                        "triangle_area (1, 2), (2, 3), (5, 6)"
        );
    }

    @Override
    public void onCommandExecuted(MessageReceivedEvent event) {
        parseCommand(event);
        if (this.content.startsWith("dist") || (this.content.startsWith("|") && this.content.endsWith("|"))){
            String[] equation = this.content.replaceFirst("(dist)", "").replaceAll("[|]", "").split("\\),\\(");
            String[] coord1 = equation[0].replaceFirst("[)(]", "").split(",");
            String[] coord2 = equation[1].replaceFirst("[()]", "").split(",");
            if(coord1.length == coord2.length){
                if(coord1.length == 2){
                    float dist = (float)Math.sqrt(Math.pow(Float.parseFloat(coord2[0]) - Float.parseFloat(coord1[0]), 2) +
                            Math.pow(Float.parseFloat(coord2[1]) - Float.parseFloat(coord1[1]), 2));
                    Utils.sendMessage("Distance between two points is: " + dist, event.getChannel());
                }else if(coord1.length == 3){
                    float dist = (float)Math.sqrt(Math.pow(Float.parseFloat(coord2[0]) - Float.parseFloat(coord1[0]), 2) +
                            Math.pow(Float.parseFloat(coord2[1]) - Float.parseFloat(coord1[1]), 2) +
                            Math.pow(Float.parseFloat(coord2[2]) - Float.parseFloat(coord1[2]), 2));
                    Utils.sendMessage("Distance between 3 points is: " + dist, event.getChannel());
                }
            }else{
                Utils.sendMessage("Error: Unmatched coordinate systems", event.getChannel());
            }
        }else if(this.content.startsWith("triangle_area")){
            String[] equation = this.content.replaceFirst("(triangle_area)", "").split("\\),\\(");
            String[] coord1 = equation[0].replaceFirst("[()]", "").split(",");
            String[] coord2 = equation[1].replaceFirst("[()]", "").split(",");
            String[] coord3 = equation[2].replaceFirst("[()]", "").split(",");
            if((coord1.length == coord2.length) && (coord2.length == coord3.length)){
                if(coord1.length == 2){
                    float area = (float) (0.5 * (Float.parseFloat(coord1[0]) * (Float.parseFloat(coord2[1]) - Float.parseFloat(coord3[1])) +
                            Float.parseFloat(coord2[0]) * (Float.parseFloat(coord3[1]) - Float.parseFloat(coord1[1])) +
                            Float.parseFloat(coord3[0]) * (Float.parseFloat(coord1[1]) - Float.parseFloat(coord2[1]))));
                    Utils.sendMessage("Area of Triangle: " + area, event.getChannel());
                }
            }
        }else if(this.content.startsWith("slope")){
            String[] equation = this.content.replaceFirst("(slope)", "").split("\\),\\(");
            double[] coord1 = parsePoint(equation[0]);
            double[] coord2 = parsePoint(equation[1]);
            if(coord1.length == coord2.length){
                float slope =  (float)((coord2[1] - coord1[1]) / (coord2[0] - coord1[0]));
                Utils.sendMessage("Slope of the line is: " + slope + "\n" +
                        "Angle of the line is: " + Math.toDegrees(Math.atan(slope)), event.getChannel());
            }
        }
    }

    private double[] parsePoint(String str) {
        return Arrays.stream(str.replaceAll("[()]", "").split(",")).mapToDouble(Float::parseFloat).toArray();
    }




}
