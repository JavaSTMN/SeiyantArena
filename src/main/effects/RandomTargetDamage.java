package main.effects;

import main.Game;
import main.PlaySide;
import main.card.Hero;
import main.card.ITarget;
import main.card.Minion;
import main.model.Board;
import main.model.CardContainer;
import main.model.Player;

import java.util.ArrayList;
import java.util.Random;

public class RandomTargetDamage implements IEffect {
    private int targetNumber;
    private int amountDamage;
    private Random random;
    private Game game;

    public RandomTargetDamage(Game game, int amountDamage, int targetNumber) {
        this.game = game;
        this.amountDamage = amountDamage;
        this.targetNumber = targetNumber;

        random = new Random();
    }

    @Override
    public void execute() {
        ArrayList<ITarget> targets = chooseTargets();

        for(int i=0;i<targetNumber;i++) {
            ITarget target = chooseTarget(targets);
            target.takeDamage(amountDamage);

            targets = chooseTargets();
        }
    }

    private ArrayList<ITarget> chooseTargets() {
        Player opponentPlayer = game.getPlayer(PlaySide.WAITING_PLAYER);

        Board opponentBoard = opponentPlayer.getBoard();
        Hero opponentHero = opponentPlayer.getHero();

        ArrayList<ITarget> candidates = new ArrayList<>();
        CardContainer<Minion> minions = opponentBoard.getMinions();

        minions.forEach(x -> {
            if(!x.isDead())
                candidates.add(x);
        });

        candidates.add(opponentHero);

        return candidates;
    }

    private ITarget chooseTarget(ArrayList<ITarget> candidates) {
        int index = random.nextInt(candidates.size());

        return candidates.get(index);
    }
}
