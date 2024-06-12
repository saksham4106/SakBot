package com.saksham.sakbot.commands;

import com.fathzer.soft.javaluator.DoubleEvaluator;
import com.saksham.sakbot.SakBot;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import org.apache.commons.math3.linear.MatrixUtils;
import org.apache.commons.math3.linear.RealMatrix;

public class LinearPairCommand extends Command{
    private final DoubleEvaluator eval = new DoubleEvaluator();

    public LinearPairCommand(){
        super("linear",
                "Calculates value of x,y in a pair of linear equations",
                SakBot.prefix + "linear 1x -5y = 6\n2x + 4y = -3");
    }

    @Override
    public void onCommandExecuted(MessageReceivedEvent event) {
        this.parseCommand(event);
        String equation1 = this.content.split(System.lineSeparator())[0];
        String equation2 = this.content.split(System.lineSeparator())[1];
        String[] split1 = equation1.split("=");
        String[] split2 = equation2.split("=");

        double c = eval.evaluate(split1[1]);
        double f = eval.evaluate(split2[1]);
        double a = eval.evaluate(split1[0].substring(0, split1[0].indexOf("x")));

        StringBuilder temp = new StringBuilder(split1[0].substring(split1[0].indexOf("x") + 1, split1[0].indexOf("y")));
        if(temp.charAt(0) == '+') temp.deleteCharAt(0);

        double b = eval.evaluate(temp.toString());
        double d = eval.evaluate(split2[0].substring(0, split2[0].indexOf("x") ));

        temp = new StringBuilder(split2[0].substring(split2[0].indexOf("x") + 1, split2[0].indexOf("y")));
        if(temp.charAt(0) == '+') temp.deleteCharAt(0);

        double e = eval.evaluate(temp.toString());

        double[][] xyMatrixData = {{a, b}, {d, e}};
        double[][] constantMatrixData = {{c}, {f}};

        RealMatrix xyMatrix = MatrixUtils.createRealMatrix(xyMatrixData);
        RealMatrix constantMatrix = MatrixUtils.createRealMatrix(constantMatrixData);
        RealMatrix outputMatrix = MatrixUtils.inverse(xyMatrix).multiply(constantMatrix);
        event.getChannel().sendMessage("X: " + (float)outputMatrix.getEntry(0, 0) + "\nY: " + (float)outputMatrix.getEntry(1, 0)).queue();
    }
}

