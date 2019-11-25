package main.events;

import main.card.Card;

public interface IHandListener {
    void onDrawCard(Card card, boolean fullHand);
    void onPlayCard(Card card);
}
