package com.samuel.dao;

import com.samuel.dao.jdbc.ConnectionsFactory;
import com.samuel.domain.Cliente;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ClienteDAO implements IClienteDAO{

    @Override
    public Integer cadastrar(Cliente cliente) throws Exception {
        Connection connection = null;
        PreparedStatement stm = null;
        try {
            connection = ConnectionsFactory.getConnection();
            String sql = "insert into cliente (codigo, nome) values (?,?)";
            stm = connection.prepareStatement(sql);
            stm.setString(1, cliente.getCodigo());
            stm.setString(2, cliente.getNome());
            return stm.executeUpdate();
        } catch (Exception e) {
            throw e;
        } finally {
            closeConnection(connection, stm, null);
        }
    }

    @Override
    public Cliente buscarUm(String codigo) throws Exception {
        Connection connection = null;
        PreparedStatement stm = null;
        ResultSet resultSet = null;
        Cliente cliente = null;
        try {
            connection = ConnectionsFactory.getConnection();
            String sql = "select * from cliente where codigo = ?";
            stm = connection.prepareStatement(sql);
            stm.setString(1, codigo);
            resultSet = stm.executeQuery();
            if (resultSet.next()) {
                cliente = new Cliente();
                cliente.setId(resultSet.getLong("id"));
                cliente.setCodigo(resultSet.getString("codigo"));
                cliente.setNome(resultSet.getString("nome"));
            }
            return cliente;
        } catch (Exception e) {
            throw e;
        } finally {
            closeConnection(connection, stm, resultSet);
        }
    }

    @Override
    public Integer excluir(Cliente cliente) throws Exception {
        Connection connection = null;
        PreparedStatement stm = null;
        try {
            connection = ConnectionsFactory.getConnection();
            String sql = "delete from cliente where codigo = ?";
            stm = connection.prepareStatement(sql);
            stm.setString(1, cliente.getCodigo());
            return stm.executeUpdate();
        } catch (Exception e) {
            throw e;
        } finally {
            closeConnection(connection, stm, null);
        }
    }

    @Override
    public List<Cliente> buscarTodos() throws Exception {
        Connection connection = null;
        PreparedStatement stm = null;
        ResultSet resultSet = null;
        List<Cliente> clientes = new ArrayList<>();
        Cliente cliente = null;
        try {
            connection = ConnectionsFactory.getConnection();
            String sql = "select * from cliente";
            stm = connection.prepareStatement(sql);
            resultSet = stm.executeQuery();

            while (resultSet.next()) {
                cliente = new Cliente();
                Long id = resultSet.getLong("id");
                String codigo = resultSet.getString("codigo");
                String nome = resultSet.getString("nome");
                cliente.setId(id);
                cliente.setCodigo(codigo);
                cliente.setNome(nome);
                clientes.add(cliente);
            }
        } catch (Exception e) {
            throw e;
        } finally {
            closeConnection(connection, stm, resultSet);
        }
        return clientes;
    }

    @Override
    public Integer atualizar(Cliente cliente) throws Exception {
        Connection connection = null;
        PreparedStatement stm = null;
        try {
            connection = ConnectionsFactory.getConnection();
            String sql = "update cliente set codigo = ?, nome = ? where id = ?";
            stm = connection.prepareStatement(sql);
            stm.setString(1, cliente.getCodigo());
            stm.setString(2, cliente.getNome());
            stm.setLong(3, cliente.getId());
            return stm.executeUpdate();
        } catch (Exception e) {
            throw e;
        } finally {
            closeConnection(connection, stm, null);
        }
    }

    private void closeConnection(Connection connection, PreparedStatement stm, ResultSet resultSet) throws SQLException {
        if (stm != null && !stm.isClosed()) stm.close();
        if (connection != null && !connection.isClosed()) connection.close();
        if (resultSet != null && !resultSet.isClosed()) resultSet.close();
    }
}
