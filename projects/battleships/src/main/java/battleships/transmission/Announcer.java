package battleships.transmission;

import java.util.LinkedHashSet;
import java.util.Set;

public class Announcer {

    private Set<Spectator> spectators = new LinkedHashSet<>();

    public void addSpectator(Spectator spectator) {
        spectators.add(spectator);
    }

    public void removeSpectator(Spectator spectator) {
        spectators.remove(spectator);
    }

    public void announce(GameEvent gameEvent) {
        spectators.forEach(spectator -> spectator.spectate(gameEvent));
    }
}
