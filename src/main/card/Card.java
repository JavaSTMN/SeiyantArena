package main.card;

import main.effects.IEffect;
import main.effects.IUndoable;

import java.util.ArrayList;

public abstract class Card {
    private int manaCost;
    private String name;
    private ArrayList<IEffect> effects;
    private ArrayList<IUndoable> undoables;

    public Card(String name, int manaCost) {
        this.name = name;
        this.manaCost = manaCost;

        effects = new ArrayList<IEffect>();
        undoables = new ArrayList<IUndoable>();
    }
    public String getName() {
        return name;
    }

    public int getManaCost() {
        return manaCost;
    }

    public void addEffect(IEffect effect) {
        effects.add(effect);
    }

    public void addUndoableEffect(IUndoable undoableEffect) {
        undoables.add(undoableEffect);
    }
}