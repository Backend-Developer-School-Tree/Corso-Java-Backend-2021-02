package serie_a;

import java.util.Objects;

public class Player {
    String id, name, surname;

    public Player(String id, String name, String surname) {
        this.id = id;
        this.name = name;
        this.surname = surname;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Player player = (Player) o;
        return id.equals(player.id) &&
                Objects.equals(name, player.name) &&
                Objects.equals(surname, player.surname);
    }

    @Override
    public int hashCode() {
        return id.hashCode();
    }
}
