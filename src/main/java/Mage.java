public class Mage extends Character {
    private int mana;
    private static final int CAST_SPELL_MANA_COST = 10;
    private static final int CAST_SPELL_DAMAGE = 20;
    private static final int HEAL_MANA_COST = 15;
    private static final int HEAL_AMOUNT = 20;


    public Mage(String name, int health, int mana) {
        super(name, health);
        this.mana = mana;
    }

    public int getMana() {
        return this.mana;
    }

    public void consumeMana(int cost) {
        if(this.mana < cost) {
            throw new InsufficientManaException(this.name + " no tiene maná suficiente");
        }
        this.mana -= cost;
    }

    public void castSpell(Character target) {
//        if (target != null && target.isAlive()) {
//            if (this.mana - CAST_SPELL_COST >= 0) {
//                this.mana -= CAST_SPELL_COST;
//                target.receiveDamage(20);
//                target.status = Status.POISONED;
//            } else {
//                throw new InsufficientManaException(this.name + " no tiene maná suficiente");
//            }
//        } else {
//            if (target == null) {
//                throw new InvalidTargetException("No se puede realizar una acci&oacute;n a un objetivo nulo");
//            }
//            if (!target.isAlive()) {
//                throw new CharacterAlreadyDeadException(target.name + " ya está muerto");
//            }
//        }
        super.validateTarget(target);
        consumeMana(CAST_SPELL_MANA_COST);
        target.receiveDamage(CAST_SPELL_DAMAGE);
        target.status = Status.POISONED;
    }

    public void heal(Character target) {
//        if (target != null && target.isAlive()) {
//            if (this.mana - 15 >= 0) {
//                target.health += 20;
//            } else {
//                throw new InsufficientManaException(this.name + " no tiene maná suficiente");
//            }
//        } else {
//            if (target == null) {
//                throw new InvalidTargetException("No se puede realizar una acción a un objetivo nulo");
//            }
//            if (!target.isAlive()) {
//                throw new CharacterAlreadyDeadException(target.name + " ya está muerto");
//            }
//        }
        super.validateTarget(target);
        consumeMana(HEAL_MANA_COST);
        target.health += HEAL_AMOUNT;
    }

}
