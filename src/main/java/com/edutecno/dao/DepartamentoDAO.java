package com.edutecno.dao;

import com.edutecno.model.Departamento;
import java.util.List;

public interface DepartamentoDAO {
    List<Departamento> obtenerDepartamentosPorFiltro(String filtro);
}
