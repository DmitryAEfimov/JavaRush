package com.javarush.test.level13.lesson11.bonus03;

public abstract class AbstractRobot implements Attackable, Defensable
{
    private String name;
    private int hitCount;

    protected AbstractRobot(String name)
    {
        this.name = name;
    }

    protected String getName()
    {
        return name;
    }

    public BodyPart attack() {
        BodyPart attackedBodyPart = null;
        if (this instanceof Robot) {
            hitCount = ((Robot) this).getHitCount() + 1;

            if (hitCount == 1) {
                attackedBodyPart = BodyPart.ARM;
            } else if (hitCount == 2) {
                attackedBodyPart = BodyPart.CHEST;
            } else if (hitCount == 3) {
                attackedBodyPart = BodyPart.HEAD;
            } else if (hitCount == 4) {
                hitCount = 0;
                attackedBodyPart = BodyPart.LEG;
            }
        }
        return attackedBodyPart;
    }

    public BodyPart defense()
    {
        BodyPart defencedBodyPart = null;
        if (this instanceof Robot) {
            hitCount = ((Robot) this).getHitCount() + 1;

            if (hitCount == 1) {
                defencedBodyPart = BodyPart.HEAD;
            } else if (hitCount == 2) {
                defencedBodyPart = BodyPart.LEG;
            } else if (hitCount == 3) {
                defencedBodyPart = BodyPart.ARM;
            } else if (hitCount == 4) {
                hitCount = 0;
                defencedBodyPart = BodyPart.CHEST;
            }
        }
        return defencedBodyPart;
    }
}
