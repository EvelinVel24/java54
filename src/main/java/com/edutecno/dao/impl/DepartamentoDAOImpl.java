package com.edutecno.dao.impl;

import com.edutecno.dao.DepartamentoDAO;
import com.edutecno.model.Departamento;
import com.edutecno.utils.DBConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class DepartamentoDAOImpl implements DepartamentoDAO {

    @Override
    public List<Departamento> obtenerDepartamentosPorFiltro(String filtro) {
        List<Departamento> departamentos = new ArrayList<>();
        String query = "SELECT * FROM departamento WHERE nombre LIKE ? OR descripcion LIKE ?";
        
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {
             
            stmt.setString(1, "%" + filtro + "%");
            stmt.setString(2, "%" + filtro + "%");

            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                Departamento depto = new Departamento(
                    rs.getInt("id"),
                    rs.getString("nombre"),
                    rs.getString("descripcion")
                );
                departamentos.add(depto);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return departamentos;
    }
}
