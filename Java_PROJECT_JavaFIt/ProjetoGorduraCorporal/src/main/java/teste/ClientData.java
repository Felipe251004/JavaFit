package teste;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ClientData {

    public void insertClientData(String nome, String senha, String sexo, double medidaPunho, 
                                 double medidaTornozelo, double medidaPescoco, double larguraAbdominal, 
                                 double altura, double peso, int idade) {
        String query = "INSERT INTO Clientes (nome, senha, sexo, medida_punho, medida_tornozelo, medida_pescoco, largura_abdominal, altura, peso, idade) " +
                       "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

        try (Connection conn = DatabaseConnection.connect();
             PreparedStatement stmt = conn.prepareStatement(query)) {
            
            stmt.setString(1, nome);
            stmt.setString(2, senha);
            stmt.setString(3, sexo);
            stmt.setDouble(4, medidaPunho);
            stmt.setDouble(5, medidaTornozelo);
            stmt.setDouble(6, medidaPescoco);
            stmt.setDouble(7, larguraAbdominal);
            stmt.setDouble(8, altura);
            stmt.setDouble(9, peso);
            stmt.setInt(10, idade);

            stmt.executeUpdate();
            System.out.println("Dados do cliente inseridos com sucesso!");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void getClientData(int id) {
        String query = "SELECT * FROM Clientes WHERE id = ?";
        
        try (Connection conn = DatabaseConnection.connect();
             PreparedStatement stmt = conn.prepareStatement(query)) {
            
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                System.out.println("Nome: " + rs.getString("nome"));
                // Exibir outros campos conforme necessário
            } else {
                System.out.println("Cliente não encontrado.");
            }
            
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
