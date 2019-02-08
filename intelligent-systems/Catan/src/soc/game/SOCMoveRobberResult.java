package soc.game;



import java.util.List;


/**
 * This class holds the results of moving the robber or pirate.
 * Specifically, the victim or possible victims, and
 * what was stolen.
 * Call {@link SOCGame#getRobberyPirateFlag()} to see which one was moved.
 * Each game has 1 instance of this object, which is updated each time the robber or pirate is moved.
 *
 * @see SOCGame.RollResult
 */
public class SOCMoveRobberResult
{
    /** Victim, or possible victims, or empty or null */
    List<SOCPlayer> victims;

    /** Resource type of loot stolen, as in {@link SOCResourceConstants}, or -1 */
    int loot;

    /**
     * When the pirate fleet moves in game scenario {@link SOCGameOption#K_SC_PIRI _SC_PIRI},
     * the resources stolen from victim.  Otherwise null and ignored.
     * When {@link #sc_piri_loot} is set, the other {@link #loot} field is -1.
     * When {@link #victims} is empty, ignore this field.
     * @see SOCGame#stealFromPlayerPirateFleet(int, int)
     * @since 2.0.00
     */
    public SOCResourceSet sc_piri_loot;

    /**
     * Creates a new SOCMoveRobberResult object.
     */
    public SOCMoveRobberResult()
    {
        victims = null;
        loot = -1;
    }

    /**
     * Clear common fields for reuse of this object.
     * Does not clear the infrequently-used {@link #sc_piri_loot}.
     * @since 2.0.00
     */
    public void clear()
    {
        victims = null;
        loot = -1;
    }

    /**
     * Set the victim (if any) or possible victims
     *
     * @param v Victim or possible victims, may be empty or null
     */
    public void setVictims(List<SOCPlayer> v)
    {
        victims = v;
    }

    /**
     * Get the victim (if any) or possible victims
     *
     * @return Victim or possible victims, may be empty or null
     */
    public List<SOCPlayer> getVictims()
    {
        return victims;
    }

    /**
     * Set the type of resource stolen from the victim
     *
     * @param l type of resource stolen, as in {@link SOCResourceConstants},
     *          or -1 if nothing stolen,
     *          or {@link SOCResourceConstants#CLOTH_STOLEN_LOCAL} for cloth.
     */
    public void setLoot(int l)
    {
        loot = l;
    }

    /**
     * Get the type of resource stolen from the victim;
     * undefined unless {@link #getVictims()}.size() == 1.
     *
     * @return type of resource stolen, as in {@link SOCResourceConstants},
     *         or -1 if nothing stolen,
     *         or {@link SOCResourceConstants#CLOTH_STOLEN_LOCAL} for cloth.
     */
    public int getLoot()
    {
        return loot;
    }
}
