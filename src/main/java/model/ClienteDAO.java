package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ClienteDAO {

    Connection conn = null;
    PreparedStatement pstm = null;

    public void save(Cliente cliente) {
        String sql = "INSERT INTO cliente(id_cliente, nome, email, senha) VALUES(?,?,?,?)";

        try {
            conn = Conexao.createConnectionToMySQL();
            pstm = conn.prepareStatement(sql);

            pstm.setString(1, cliente.getId_cliente());
            pstm.setString(2, cliente.getNome());
            pstm.setString(3, cliente.getEmail());
            pstm.setString(4, cliente.getSenha());

            pstm.execute();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (pstm != null) {
                    pstm.close();
                }
                if (conn != null) {
                    conn.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public void removeById(String id) {
        String sql = "DELETE FROM cliente WHERE id_cliente = ?";

        try {
            conn = Conexao.createConnectionToMySQL();
            pstm = conn.prepareStatement(sql);
            pstm.setString(1, id);
            pstm.execute();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (pstm != null) {
                    pstm.close();
                }
                if (conn != null) {
                    conn.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public void update(Cliente cliente) {
        String sql = "UPDATE cliente SET nome = ?, email = ?, senha = ? WHERE id_cliente = ?";

        try {
            conn = Conexao.createConnectionToMySQL();
            pstm = conn.prepareStatement(sql);

            pstm.setString(1, cliente.getNome());
            pstm.setString(2, cliente.getEmail());
            pstm.setString(3, cliente.getSenha());
            pstm.setString(4, cliente.getId_cliente());

            pstm.execute();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (pstm != null) {
                    pstm.close();
                }
                if (conn != null) {
                    conn.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public List<Cliente> getClientes() {
        String sql = "SELECT * FROM cliente";

        List<Cliente> clientes = new ArrayList<>();
        ResultSet rset = null;

        try {
            conn = Conexao.createConnectionToMySQL();
            pstm = conn.prepareStatement(sql);
            rset = pstm.executeQuery();

            while (rset.next()) {
                Cliente cliente = new Cliente();
                cliente.setId_cliente(rset.getString("id_cliente"));
                cliente.setNome(rset.getString("nome"));
                cliente.setEmail(rset.getString("email"));
                cliente.setSenha(rset.getString("senha"));
                clientes.add(cliente);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (rset != null) {
                    rset.close();
                }
                if (pstm != null) {
                    pstm.close();
                }
                if (conn != null) {
                    conn.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return clientes;
    }

    public Cliente getClienteById(String id) {
        String sql = "SELECT * FROM cliente WHERE id_cliente = ?";
        Cliente cliente = new Cliente();
        ResultSet rset = null;

        try {
            conn = Conexao.createConnectionToMySQL();
            pstm = conn.prepareStatement(sql);
            pstm.setString(1, id);
            rset = pstm.executeQuery();

            rset.next();

            cliente.setId_cliente(rset.getString("id_cliente"));
            cliente.setNome(rset.getString("nome"));
            cliente.setEmail(rset.getString("email"));
            cliente.setSenha(rset.getString("senha"));
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (rset != null) {
                    rset.close();
                }
                if (pstm != null) {
                    pstm.close();
                }
                if (conn != null) {
                    conn.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return cliente;
    }
}
