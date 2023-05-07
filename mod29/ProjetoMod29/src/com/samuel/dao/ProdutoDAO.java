package com.samuel.dao;

import com.samuel.dao.jdbc.ConnectionsFactory;
import com.samuel.domain.Produto;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProdutoDAO implements IProdutoDAO {

    @Override
    public Produto cadastrar(Produto produto) throws Exception{
        Connection connection = null;
        PreparedStatement stm = null;
        ResultSet resultSet = null;
        Produto produtoDB = null;
        try {
            connection = ConnectionsFactory.getConnection();
            String sql = "insert into produto (nome, preco) values (?,?)";
            stm = connection.prepareStatement(sql);
            stm.setString(1, produto.getNome());
            stm.setBigDecimal(2, produto.getPreco());
            stm.executeUpdate();
            stm.close();
            connection.close();

            return buscarPorNome(produto.getNome());
        } catch (Exception e) {
            throw e;
        } finally {
            closeConnection(connection, stm, resultSet);
        }
    }

    @Override
    public Produto buscarUm(Long id) throws Exception {
        Connection connection = null;
        PreparedStatement stm = null;
        ResultSet resultSet = null;
        Produto produto = null;
        try {
            connection = ConnectionsFactory.getConnection();
            String sql = "select * from produto where id = ?";
            stm = connection.prepareStatement(sql);
            stm.setLong(1, id);
            resultSet = stm.executeQuery();
            if (resultSet.next()) {
                produto = new Produto();
                Long idProduto = resultSet.getLong("id");
                String nome = resultSet.getString("nome");
                BigDecimal preco = resultSet.getBigDecimal("preco");
                produto.setNome(nome);
                produto.setPreco(preco);
                produto.setId(idProduto);
                return produto;
            } else {
                return null;
            }
        } catch (Exception e) {
            throw e;
        } finally {
            closeConnection(connection, stm, resultSet);
        }

    }

    @Override
    public Integer excluir(Long id) throws Exception {
        Connection connection = null;
        PreparedStatement stm = null;
        try {
            Produto produto = buscarUm(id);
            if (produto != null) {
                connection = ConnectionsFactory.getConnection();
                String sql = "delete from produto where id = ?";
                stm = connection.prepareStatement(sql);
                stm.setLong(1, id);
                return stm.executeUpdate();
            }
        } catch (Exception e) {
            throw e;
        } finally {
            closeConnection(connection, stm, null);
        }
        return null;
    }

    @Override
    public List<Produto> buscarTodos() throws Exception{
        Connection connection = null;
        PreparedStatement stm = null;
        ResultSet resultSet = null;
        List<Produto> produtos = new ArrayList<>();
        Produto produto = null;

        try {
            connection = ConnectionsFactory.getConnection();
            String sql = "select * from produto";
            stm = connection.prepareStatement(sql);
            resultSet = stm.executeQuery();
            while (resultSet.next()) {
                produto = new Produto();
                Long id = resultSet.getLong("id");
                String nome = resultSet.getString("nome");
                BigDecimal preco = resultSet.getBigDecimal("preco");
                produto.setId(id);
                produto.setNome(nome);
                produto.setPreco(preco);
                produtos.add(produto);
            }
            return produtos;
        } catch (Exception e) {
            throw e;
        } finally {
            closeConnection(connection, stm, resultSet);
        }
    }

    @Override
    public Produto atualizar(Produto produto) throws Exception {
        Connection connection = null;
        PreparedStatement stm = null;
        try {
            connection = ConnectionsFactory.getConnection();
            String sql = "update produto set nome = ?, preco = ? where id = ?";
            stm = connection.prepareStatement(sql);
            stm.setString(1, produto.getNome());
            stm.setBigDecimal(2, produto.getPreco());
            stm.setLong(3, produto.getId());
            stm.executeUpdate();
            stm.close();
            connection.close();

            return buscarPorNome(produto.getNome());
        } catch (Exception e) {
            throw e;
        } finally {
            closeConnection(connection, stm, null);
        }
    }

    public static Produto buscarPorNome(String nome) throws Exception{
        Connection connection = null;
        PreparedStatement stm = null;
        ResultSet resultSet = null;
        Produto produto = null;
        try {
            connection = ConnectionsFactory.getConnection();
            String sql1 = "select * from produto where nome = ?";
            stm = connection.prepareStatement(sql1);
            stm.setString(1, nome);
            resultSet = stm.executeQuery();
            if (resultSet.next()) {
                produto = new Produto();
                Long id = resultSet.getLong("id");
                BigDecimal preco = resultSet.getBigDecimal("preco");
                produto.setId(id);
                produto.setNome(nome);
                produto.setPreco(preco);
            }
            return produto;
        } catch (Exception e) {
            throw e;
        } finally {
            closeConnection(connection, stm, resultSet);
        }
    }

    private static void closeConnection(Connection connection, PreparedStatement stm, ResultSet resultSet) throws SQLException {
        if (connection != null && !connection.isClosed()) connection.close();
        if (stm != null && !stm.isClosed()) stm.close();
        if (resultSet != null && !resultSet.isClosed()) resultSet.close();
    }


}
