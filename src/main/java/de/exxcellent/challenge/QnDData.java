package de.exxcellent.challenge;

/*
    Hab geschaut, ob man das mit Java Records machen kann, dann müsste man aber die Berechnung von absoluteDifference
    auslagern, was ich für keine gute Idee halte, da es logisch zu der Datenhaltung gehört
 */
public class QnDData {
    public int max, min;
    public String result;
    public int absoluteDiff;

    public QnDData(int max, int min, String result) {
        this.max = max;
        this.min = min;
        this.result = result;

        this.absoluteDiff = Math.abs(max - min);
    }

    @Override
    public String toString() {
        return "Biggest absolute difference was " + absoluteDiff + " by " + result + ".";
    }
}
