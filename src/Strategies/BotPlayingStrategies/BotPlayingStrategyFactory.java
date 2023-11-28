package Strategies.BotPlayingStrategies;

import Models.BotDifficultyLevel;

public class BotPlayingStrategyFactory {

    public  static BotPlayingStrategy getBotPlayingStrategyFromFactory(BotDifficultyLevel botDifficultyLevel){
        return new EasyBotPlayingStrategy();
    }
}
