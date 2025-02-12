import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class NoteManager {
    private Connection connection;

    public NoteManager() {
        connection = DatabaseConnection.getInstance().getConnection();
    }

    public void addNote(int id, String title, String content) {
        String Query = "INSERT INTO notes (title, content, user_id, created_at) VALUES (?, ?, ?, NOW())";
        try (PreparedStatement statement = connection.prepareStatement(Query)) {
            statement.setInt(3, id);
            statement.setString(2, content);
            statement.setString(1, title);
            statement.executeUpdate();
            System.out.println(" Note added successfully!");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void viewNotes(int id) {
        String Query = "SELECT * FROM notes WHERE user_id = ?";
        try(PreparedStatement statement = connection.prepareStatement(Query)) {
            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                System.out.println(resultSet.getInt("id") + " "
                        + resultSet.getString("title") + " "
                        + resultSet.getString("content") + " "
                        + resultSet.getString("created_at")
                );
            }
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void editNote(int id, String newContent) {
        String sql = "UPDATE notes SET content = ?, created_at = NOW() WHERE id = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, newContent);
            stmt.setInt(2, id);
            int rowsUpdated = stmt.executeUpdate();
            if (rowsUpdated > 0) {
                System.out.println("Note updated!");
            } else {
                System.out.println("Note not found.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    public void deleteNote(int id) {
        String sql = "DELETE FROM notes WHERE id = ?";
        try(PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, id);
            int rowsUpdated = stmt.executeUpdate();
            if (rowsUpdated > 0) {
                System.out.println(" Note deleted!");
            }else {
                System.out.println(" Note not found.");
            }
        } catch (SQLException e){
            e.printStackTrace();
        }
    }

    // Search note by ID
    public void searchNoteById(int noteId, int userId) {
        String sql = "SELECT * FROM notes WHERE id = ? AND user_id = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, noteId);
            stmt.setInt(2, userId);
            ResultSet resultSet = stmt.executeQuery();
            if (resultSet.next()) {
                System.out.println("Note found:");
                System.out.println("ID: " + resultSet.getInt("id"));
                System.out.println("Title: " + resultSet.getString("title"));
                System.out.println("Content: " + resultSet.getString("content"));
                System.out.println("Created At: " + resultSet.getString("created_at"));
            } else {
                System.out.println("Note not found.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Search note by Title
    public void searchNoteByTitle(String title, int userId) {
        String sql = "SELECT * FROM notes WHERE title LIKE ? AND user_id = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, "%" + title + "%");
            stmt.setInt(2, userId);
            ResultSet resultSet = stmt.executeQuery();
            boolean found = false;
            while (resultSet.next()) {
                if (!found) {
                    System.out.println("Notes found:");
                    found = true;
                }
                System.out.println("ID: " + resultSet.getInt("id"));
                System.out.println("Title: " + resultSet.getString("title"));
                System.out.println("Content: " + resultSet.getString("content"));
                System.out.println("Created At: " + resultSet.getString("created_at"));
                System.out.println("-----------------------------");
            }
            if (!found) {
                System.out.println("No notes found with the given title.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
