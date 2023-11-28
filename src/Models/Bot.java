package Models;

import Strategies.BotPlayingStrategies.BotPlayingStrategy;
import Strategies.BotPlayingStrategies.BotPlayingStrategyFactory;

public class Bot extends Player{
    private  BotDifficultyLevel botDifficultyLevel;
    private BotPlayingStrategy botPlayingStrategy;
    public Bot(Symbol symbol, String name, long id,  BotDifficultyLevel botDifficultyLevel) {
        super(symbol, name, id, PlayerType.BOT);
        this.botDifficultyLevel = botDifficultyLevel;
        this.botPlayingStrategy = BotPlayingStrategyFactory.getBotPlayingStrategyFromFactory(botDifficultyLevel);
    }

    public BotDifficultyLevel getBotDifficultyLevel() {
        return botDifficultyLevel;
    }

    public void setBotDifficultyLevel(BotDifficultyLevel botDifficultyLevel) {
        this.botDifficultyLevel = botDifficultyLevel;
    }

    @Override
    public Move makeMove(Board board) {
        Move move = this.botPlayingStrategy.makeMove(board);
        move.setPlayer(this);
        return move;
    }
}
