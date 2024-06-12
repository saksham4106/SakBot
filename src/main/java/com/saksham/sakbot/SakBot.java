package com.saksham.sakbot;

import com.saksham.sakbot.commands.*;
import com.saksham.sakbot.events.MessageEventListener;
import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.requests.GatewayIntent;
import org.scilab.forge.jlatexmath.TeXConstants;
import org.scilab.forge.jlatexmath.TeXFormula;

import javax.security.auth.login.LoginException;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class SakBot {
    public static List<Command> commands = new ArrayList<>();
    public static String prefix = "-";
    public static JDA jda;

    public static void main(String[] args) throws LoginException {
        String latex = "";
        TeXFormula formula = new TeXFormula(latex);

        formula.createPNG(TeXConstants.STYLE_TEXT, 100, "b.png", null, Color.white);

//        jda = JDABuilder.createDefault(Token.getToken()).build();
        jda = JDABuilder.createLight(Token.getToken(), GatewayIntent.GUILD_MESSAGES, GatewayIntent.GUILD_MEMBERS,
                GatewayIntent.GUILD_EMOJIS_AND_STICKERS, GatewayIntent.MESSAGE_CONTENT)
                        .addEventListeners(new MessageEventListener())
                                .build();
        registerCommands();
//        jda.addEventListener(new MessageEventListener());
    }

    private static void registerCommands(){
        commands.add(new CalculateCommand());
        commands.add(new ProgressionCommand());
        commands.add(new QuadraticCommand());
        commands.add(new LinearPairCommand());
        commands.add(new ListCommands());
        commands.add(new HelpCommand());
        commands.add(new CoordinateCommand());
        commands.add(new FactorCommand());
        commands.add(new NumberConversionCommand());
        commands.add(new Command("catgirl", "", "") {
            @Override
            public void onCommandExecuted(MessageReceivedEvent event) {
            }
        });
        commands.add(new RandomCommand());
    }

}
