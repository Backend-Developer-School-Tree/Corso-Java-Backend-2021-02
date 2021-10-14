import java.util.List;

public interface PersistentDAO<T> {

	public T get(Long id);
    public List<T> getAll();
    public void save(T persistent);
    public void update(T persistent);
    public void delete(T persistent);

}
