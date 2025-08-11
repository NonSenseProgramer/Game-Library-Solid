
package DAO;

import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import org.mindrot.jbcrypt.BCrypt;

import DAO.Conector;
// Classe responsável pelas operações de usuário no banco de dados
public class UsuarioConexao {

    // Atributos do usuário
    String nome;
    String senhaUser;
    String tipo_user;
    int id;
    public UsuarioConexao() {
    Conector conector = new Conector();
        conector.conectar();
    }

    // Métodos getters e setters
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSenhaUser() {
        return senhaUser;
    }

  public void setSenhaUser(String senhaUser) {
    this.senhaUser = senhaUser;
    }


    public String getTipo_user() {
        return tipo_user;
    }

    public void setTipo_user(String tipo_user) {
        this.tipo_user = tipo_user;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
   
    // Realiza login do usuário
    public UsuarioConexao conectarUsuario(UsuarioConexao usuario) {
        try {
            String sql = "SELECT * FROM usuarios WHERE nome = ?";
            PreparedStatement stmt = conector.prepareStatement(sql);
            stmt.setString(1, usuario.getNome());
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                String hashSenha = rs.getString("senha"); 

                // Verifica se a senha está correta
                if (BCrypt.checkpw(usuario.getSenhaUser(), hashSenha)) {
                    usuario.setId(rs.getInt("id"));
                    usuario.setNome(rs.getString("nome"));
                    usuario.setSenhaUser(hashSenha);
                    usuario.setTipo_user(rs.getString("tipo_user")); 
                    conector.fecharConexao();
                    return usuario;
                } else {
                    JOptionPane.showMessageDialog(null, "Senha incorreta.");
                }
            } else {
                JOptionPane.showMessageDialog(null, "Usuário não encontrado.");
            }
            conector.fecharConexao();
            return null;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao conectar usuário: " + e.getMessage());
            return null;
        }
    }
 
    // Cadastra um novo usuário
    public UsuarioConexao cadastrarUsuario(String nome, String senha) {
          
     try{
        if(validaNome(nome)){
            // Inserir novo usuário
            String sqlInsert = "INSERT INTO usuarios(nome, senha, tipo_user) VALUES (?, ?, ?)";
            PreparedStatement stmt = conector.prepareStatement(sqlInsert);
            stmt.setString(1, nome);
            stmt.setString(2, BCrypt.hashpw(senha, BCrypt.gensalt()));
            stmt.setString(3, "user");
            stmt.executeUpdate();

            // Buscar o usuário recém-cadastrado
            String sqlSelect = "SELECT * FROM usuarios WHERE nome = ?";
            stmt = conector.prepareStatement(sqlSelect);
            stmt.setString(1, nome);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                UsuarioConexao usuario = new UsuarioConexao();
                usuario.setId(rs.getInt("id"));
                usuario.setNome(rs.getString("nome"));
                usuario.setSenhaUser(rs.getString("senha"));
                usuario.setTipo_user(rs.getString("tipo_user"));

                rs.close();

                JOptionPane.showMessageDialog(null, "Usuário registrado com sucesso");
                return usuario;
            }
}
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Ocorreu algum erro ao cadastrar: " + e.getMessage());
        } finally {
            conector.fecharConexao();
        }
        return null;
    }}
    // Registra um novo jogo jogado pelo usuário
    public void registrarJogo(String nomeJogo, String status, String data, UsuarioConexao usuario) {
        try {
         
            nomeJogo = nomeJogo.trim().toUpperCase();

            // Busca o jogo pelo nome
            String sql = "SELECT id FROM jogos WHERE UPPER(TRIM(jogo)) = ?";
            PreparedStatement statement = conector.conn.prepareStatement(sql);
            statement.setString(1, nomeJogo);
            ResultSet rs = statement.executeQuery();

            if (rs.next()) {
                int idJogo = rs.getInt("id");

                // Insere registro de jogo jogado
                sql = "INSERT INTO jogos_jogados (id_usuario, id_jogo, status, data_jogada) VALUES (?, ?, ?, ?)";
                PreparedStatement stmt = conector.conn.prepareStatement(sql);
                stmt.setInt(1, usuario.getId());
                stmt.setInt(2, idJogo);
                stmt.setString(3, status);
                stmt.setString(4, data);
                stmt.executeUpdate();
                stmt.close();

                JOptionPane.showMessageDialog(null, "Jogo registrado com sucesso!");

            } else {
                // Sugere jogos parecidos caso não encontre
                sql = "SELECT jogo FROM jogos WHERE UPPER(jogo) LIKE ? LIMIT 3";
                PreparedStatement sugestaoStmt = conector.conn.prepareStatement(sql);
                sugestaoStmt.setString(1, "%" + nomeJogo + "%");
                ResultSet sugestoes = sugestaoStmt.executeQuery();

                StringBuilder parecidos = new StringBuilder();
                while (sugestoes.next()) {
                    parecidos.append("- ").append(sugestoes.getString("jogo")).append("\n");
                }

                if (parecidos.length() > 0) {
                    JOptionPane.showMessageDialog(null,
                        "Jogo não encontrado.\nVocê quis dizer:\n" + parecidos.toString());
                } else {
                    JOptionPane.showMessageDialog(null, "Jogo não encontrado na base de dados.");
                }

                sugestoes.close();
                
                sugestaoStmt.close();
                
            }

            rs.close();
            statement.close();
            conector.fecharConexao();

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Ocorreu um erro: " + ex.getMessage());
        }
    }
    // Adiciona um novo jogo ao banco de dados
    public void adicionarJogo(String jogo, String genero, String dataLancamento) {
        try {
          
            String sql = "insert INTO jogos (jogo, genero, dataLancamento) values (?, ?, ?)";
            PreparedStatement stmt = conector.prepareStatement(sql);
            stmt.setString(1, jogo);
            stmt.setString(2, genero);
            stmt.setString(3, dataLancamento);
            stmt.executeUpdate();
            JOptionPane.showConfirmDialog(null, "Jogo adicionado com sucesso!");
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }

    public boolean validaNome (String nome)
{
   try {
        
            // Verifica se o nome já existe
            String sqlCheck = "SELECT nome FROM usuarios WHERE nome = ?";
            PreparedStatement checarNome = conector.prepareStatement(sqlCheck);
            checarNome.setString(1, nome);
            ResultSet resultNome = checarNome.executeQuery();

            if (resultNome.next()) {
                JOptionPane.showMessageDialog(null, "Nome de usuário já existente");
                return false;
            }
            else{
                return true;
            }
        }
        catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro " + e.getMessage());
        }
    }