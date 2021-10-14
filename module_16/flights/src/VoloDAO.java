import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class VoloDAO implements PersistentDAO<Volo> {

	private ConnectionHandler ch;

	public VoloDAO() throws ClassNotFoundException {
		ch = new ConnectionHandler("jdbc:postgresql://localhost:5432/flights", "public", "postgres", "shadow");
	}

	@Override
	public Volo get(Long id) {
		Volo result = null;
		try {
			PreparedStatement preparedStatement = ch.getPreparedStatement("SELECT * FROM volo WHERE id = ?");

			preparedStatement.setLong(1, id);
			ResultSet rs = preparedStatement.executeQuery();

			if (rs.next()) {
				result = getFromResultset(rs);
			}

		} catch (SQLException e) {
			System.out.println("Errore durante il caricamento del volo" + e.getMessage());
		} finally {
			try {
				ch.closeConnection();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return result;
	}

	@Override
	public List<Volo> getAll() {
		List<Volo> result = new ArrayList<Volo>();
		try {
			PreparedStatement preparedStatement = ch.getPreparedStatement("SELECT * FROM volo");

			ResultSet rs = preparedStatement.executeQuery();

			while (rs.next()) {
				result.add(getFromResultset(rs));
			}

		} catch (SQLException e) {
			System.out.println("Errore durante il caricamento dei voli" + e.getMessage());
		} finally {
			try {
				ch.closeConnection();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return result;
	}

	private Volo getFromResultset(ResultSet rs) throws SQLException {
		return new Volo(rs.getString("numeroVolo"), rs.getString("partenza"), rs.getString("destinazione"),
				rs.getString("pilota"), rs.getString("aereo"));
	}

	@Override
	public void save(Volo persistent) {
		try {
			PreparedStatement preparedStatement = ch.getPreparedStatement(
					"INSERT INTO volo (id, partenza, destinazione, pilota, aereo)"
							+ " VALUES (?,?,?,?,?)");

			preparedStatement.setString(1, persistent.getNumeroVolo());
			preparedStatement.setString(2, persistent.getPartenza());
			preparedStatement.setString(3, persistent.getDestinazione());
			preparedStatement.setString(4, persistent.getPilota());
			preparedStatement.setString(5, persistent.getAereo());

			preparedStatement.executeUpdate();

		} catch (SQLException e) {
			System.out.println("Errore durante il salvataggio del volo" + e.getMessage());
		} finally {
			try {
				ch.closeConnection();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	@Override
	public void update(Volo persistent) {
		try {
			PreparedStatement preparedStatement = ch.getPreparedStatement(
					"UPDATE volo SET partenza = ?, destinazione = ?, pilota = ?, aereo = ?" + " WHERE id = ?");

			preparedStatement.setString(1, persistent.getPartenza());
			preparedStatement.setString(2, persistent.getDestinazione());
			preparedStatement.setString(3, persistent.getPilota());
			preparedStatement.setString(4, persistent.getAereo());
			preparedStatement.setString(5, persistent.getNumeroVolo());

			preparedStatement.executeUpdate();

		} catch (SQLException e) {
			System.out.println("Errore durante l'update del volo" + e.getMessage());
		} finally {
			try {
				ch.closeConnection();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	@Override
	public void delete(Volo persistent) {
		try {
			PreparedStatement preparedStatement = ch.getPreparedStatement("DELETE FROM volo WHERE id = ?");

			preparedStatement.setString(1, persistent.getNumeroVolo());

			preparedStatement.executeUpdate();

		} catch (SQLException e) {
			System.out.println("Errore durante la cancellazione del volo" + e.getMessage());
		} finally {
			try {
				ch.closeConnection();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	public int getCapienzaMassimaVolo(String numeroVolo) {
		int capienza = 0;
		try {
			PreparedStatement preparedStatement = ch.getPreparedStatement("SELECT capienza FROM volo v, aereo a where v.numero_volo = ? and a.id = v.aereo");

			preparedStatement.setString(1, numeroVolo);
			ResultSet rs = preparedStatement.executeQuery();

			if (rs.next()) {
				capienza = rs.getInt("capienza");
			}

		} catch (SQLException e) {
			System.out.println("Errore durante il caricamento del volo" + e.getMessage());
		} finally {
			try {
				ch.closeConnection();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return capienza;
	}


	public static void main(String[] args) throws ClassNotFoundException {
		VoloDAO voloDAO = new VoloDAO();
		List<Volo> l = voloDAO.getAll();
		for (Volo volo : l) {
			System.out.println(volo.toString());
		}
		System.out.println(voloDAO.getCapienzaMassimaVolo("1"));
	}

}
