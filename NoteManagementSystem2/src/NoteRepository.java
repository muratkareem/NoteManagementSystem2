import java.util.List;
import java.util.Optional;

public interface NoteRepository {
    void add(NoteManager note);
    Optional<NoteManager> getById(int id);
    List<NoteManager> getAll();
    boolean deleteById(int id);
    boolean update(NoteManager note);
}
