package studentroster;

public enum Standing {
    MAX_FRESHMEN(30, 'A'),
    MAX_SOPHOMORE(60, 'B'),
    MAX_JUNIOR(90, 'C'),
    MAX_Senior(120,'D');

    private final int maxCredits;
    private final char levelStanding;

    Standing(int maxCredits, char levelStanding){
        this.maxCredits = maxCredits;
        this.levelStanding = levelStanding;
    }

    char getLevelStanding(int currentCredits)
    {
        if(currentCredits >= MAX_JUNIOR.maxCredits)
        {
            return MAX_Senior.levelStanding;
        }
        else if(currentCredits > MAX_SOPHOMORE.levelStanding)
        {
            return MAX_JUNIOR.levelStanding;
        }
        else if(currentCredits > MAX_FRESHMEN.maxCredits)
        {
            return MAX_SOPHOMORE.levelStanding;
        }
        else
        {
            return MAX_FRESHMEN.levelStanding;
        }

    }





}
