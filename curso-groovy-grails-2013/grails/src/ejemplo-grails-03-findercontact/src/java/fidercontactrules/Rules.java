package fidercontactrules;

import findercontact.Person;

public class Rules {

    private int deltaAge;

    private float deltaHeight;

    public Rules() {

        super();
    }

    public Rules(final int deltaAge, final float deltaHeight) {

        super();
        this.deltaAge = deltaAge;
        this.deltaHeight = deltaHeight;
    }

    public boolean isAGoodContact(final Person p, final Person contact) {

        return (Math.abs(p.getAge() - contact.getAge()) <= this.deltaAge)
                && (Math.abs(p.getHeight() - contact.getHeight()) < this.deltaHeight);
    }

    public int getDeltaAge() {

        return this.deltaAge;
    }

    public void setDeltaAge(final int deltaAge) {

        this.deltaAge = deltaAge;
    }

    public float getDeltaHeight() {

        return this.deltaHeight;
    }

    public void setDeltaHeight(final float deltaHeight) {

        this.deltaHeight = deltaHeight;
    }

}
